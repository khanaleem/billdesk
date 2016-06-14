package com.users;


import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import java.io.*;

public class SendMailUsingAuthentication {

    private static final String SMTP_HOST_NAME = "smtp.office365.com"; //or simply "localhost"
    private static final String SMTP_AUTH_USER = "Alim.khan@ebex.esselgroup.com";
    private static final String SMTP_AUTH_PWD = "Ruta7591";
    private static final String emailMsgTxt = "Body";
    private static final String emailSubjectTxt = "Subject";
    private static final String emailFromAddress = "Alim.khan@ebex.esselgroup.com"; // Add List of Email address to who email needs to be sent to 
    private static final String[] emailList = {"hriday.dubey@ebex.esselgroup.com"};

    

    public void postMail(String recipients[], String subject, String message) throws MessagingException, AuthenticationFailedException {
        boolean debug = false; //Set the host smtp address 
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtp.host", SMTP_HOST_NAME);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", 587);
        Authenticator auth = new SMTPAuthenticator();        
        Session session = Session.getDefaultInstance(props, auth);
        session.setDebug(debug); // create a message
        Message msg = new MimeMessage(session); // set the from and to address
        InternetAddress addressFrom = new InternetAddress(emailFromAddress);
        msg.setFrom(addressFrom);
        InternetAddress[] addressTo = new InternetAddress[recipients.length];
        for (int i = 0; i < recipients.length; i++) {
            addressTo[i] = new InternetAddress(recipients[i]);
        }
        msg.setRecipients(Message.RecipientType.TO, addressTo); // Setting the Subject and Content Type
        msg.setSubject(subject);
        msg.setContent(message, "text/html");
        Transport.send(msg);
        
    }

    private class SMTPAuthenticator extends javax.mail.Authenticator {

        public PasswordAuthentication getPasswordAuthentication() {
            String username = SMTP_AUTH_USER;
            String password = SMTP_AUTH_PWD;
            return new PasswordAuthentication(username, password);
        }
    }
    
    public static void main(String args[]) throws Exception {
        SendMailUsingAuthentication smtpMailSender = new SendMailUsingAuthentication();
        smtpMailSender.postMail(emailList, emailSubjectTxt, emailMsgTxt);
        System.out.println("Sucessfully Sent mail to All Users");
    }
}
