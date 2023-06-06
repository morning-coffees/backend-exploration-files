package com.example.bk.consumer;

import java.util.List;
import java.util.Properties;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.kafka.KafkaItemReader;
import org.springframework.batch.item.kafka.builder.KafkaItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;

import com.example.bk.Customer;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootApplication
@RequiredArgsConstructor
@EnableBatchProcessing
public class ConsumerApplication {

	public static void main(String args[]) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

	@Autowired
	private KafkaProperties properties;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Bean
	Job job() {
		return jobBuilderFactory.get("job")
			.incrementer(new RunIdIncrementer())
			.start(start())
			.build();

	}

	@Bean
	KafkaItemReader<Long, Customer> kafkaItemReader() {
		var props = new Properties();
		props.putAll(this.properties.buildConsumerProperties());

		return new KafkaItemReaderBuilder<Long, Customer>()
			.partitions(0)
			.consumerProperties(props)
			.name("customers-reader")
			.saveState(true)
			.topic("customers")
			.build();
	}

	@Bean
	Step start() {
		var writer = new ItemWriter<Customer>() {
			@Override
			public void write(List<? extends Customer> items) throws Exception {
				items.forEach(it -> {
					System.out.println("new customer: " +  it.getId() +" " + it.getName() );
				});
			}
		};
		return stepBuilderFactory
			.get("step")
			.<Customer, Customer>chunk(10)
			.writer(writer)
			.reader(kafkaItemReader())
			.build();
	}
}
