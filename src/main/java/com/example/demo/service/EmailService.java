package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailService {
    @Autowired
    private Environment env;

    /**
     * Method to send new password through email to customer if they forgot password
     *
     * @param Recipient
     * @param Subject
     * @param EmailMessage
     */
    public void send(String Recipient, String Subject, String EmailMessage) {
        String host = env.getProperty("spring.mail.host");
        String port = env.getProperty("spring.mail.port");
        String username = env.getProperty("spring.mail.username");
        String password = env.getProperty("spring.mail.password");

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("NoReply@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(Recipient)); // to be added an email addr
            message.setSubject(Subject);
            message.setText(EmailMessage);

            Transport.send(message);


        } catch (MessagingException e) {
            System.out.println(e.getMessage());
        }
    }


}