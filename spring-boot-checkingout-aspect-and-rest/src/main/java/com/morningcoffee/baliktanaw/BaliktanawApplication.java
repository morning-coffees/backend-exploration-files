package com.morningcoffee.baliktanaw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.EventListener;

import com.morningcoffee.baliktanaw.controllers.SampleAspect;
import com.morningcoffee.baliktanaw.models.Book;
import com.morningcoffee.baliktanaw.repositories.BookRepository;

@SpringBootApplication
public class BaliktanawApplication {

	@Autowired
	BookRepository bookRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BaliktanawApplication.class, args);
		
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		bookRepository.save(new Book("Book 1"));
		bookRepository.save(new Book("Book 2"));
		bookRepository.save(new Book("Book 3"));
		bookRepository.save(new Book("Book 4"));
		bookRepository.save(new Book("Book 5"));
		bookRepository.save(new Book("Book 6"));
		bookRepository.save(new Book("Book 7"));
	}

}
