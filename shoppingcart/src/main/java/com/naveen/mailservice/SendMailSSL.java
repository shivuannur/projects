package com.naveen.mailservice;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;  

public class SendMailSSL {

	public static void main( String[] args )
    {

        try{
        String host = "smtp.gmail.com";
        String username = "harish990088@gmail.com" ;
        String password = "harish12kavi";
        Properties props = new Properties();
        props.setProperty("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        // set any other needed mail.smtp.* properties here
        Session session = Session.getInstance(props);
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("harish990088@gmail.com"));
        msg.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("shivus476@gmail.com"));
        msg.setSubject("Testing Subject");
        msg.setText("Dear Mail Crawler," +
                "\n\n No spam to my email, please!");

        // set the message content here
        System.out.println("before send()");
        Transport.send(msg, username, password);
        System.out.println("message sent success");
    } catch (MessagingException e) {
        throw new RuntimeException(e);
    }}

}
