package com.clgarillo.mailexample.components;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailSender {

    @Value("${mail.smtp.host}")
    private String smtpHost;

    @Value("${mail.smtp.port}")
    private String smtpPort;
	
    private Session session;

    public EmailSender() {
        // Set up mail server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", smtpHost);
        properties.put("mail.smtp.port", smtpPort);

        // Create a mail session
        session = Session.getInstance(properties);
    }
    
    public EmailSender(Session session) {
    	this.session = session;
    }

    public Message createEmailMessage(String sender, String recipient, String subject, String content) throws MessagingException {
        // Create a message
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(sender));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        message.setSubject(subject);
        message.setText(content);

        return message;
    }

    public void sendEmail(Message message) throws MessagingException {
        Transport.send(message);
    }
}
