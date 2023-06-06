package com.clgarillo.mailexample.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.util.Properties;

import org.junit.jupiter.api.Test;

import com.clgarillo.mailexample.components.EmailSender;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;

public class EmailServiceTest {
	
	
    @Test
    public void testCreateEmailMessage() throws MessagingException, IOException {
        // Create a mock session
        Session session = Session.getDefaultInstance(new Properties());

        // Create an instance of the EmailSender class
        EmailSender emailSender = new EmailSender(session);

        // Set up test data
        String sender = "sender@example.com";
        String recipient = "recipient@example.com";
        String subject = "Test Email";
        String content = "This is a test email message.";

        // Call the method being tested
        Message message = emailSender.createEmailMessage(sender, recipient, subject, content);

        // Assert that the message has the expected properties
        assertEquals(sender, message.getFrom()[0].toString());
        assertEquals(recipient, message.getRecipients(Message.RecipientType.TO)[0].toString());
        assertEquals(subject, message.getSubject());
        assertEquals(content, message.getContent());
        
        assertThrows(MessagingException.class, () -> emailSender.sendEmail(message));

    }
}
