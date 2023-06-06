package com.clgarillo.mailexample;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@SpringBootApplication
public class MailExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailExampleApplication.class, args);
		

        // Set up mail server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "localhost");
        properties.put("mail.smtp.port", "1025");

        // Create a mail session
        Session session = Session.getInstance(properties);

        try {
            // Create a message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("sender@example.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("recipient@example.com"));
            message.setSubject("Java Mail Example");
            message.setText("Hello, this is a Java Mail example.");

            // Send the message
            Transport.send(message);
            System.out.println("Message sent successfully.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
	}

}
