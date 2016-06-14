package com.users;
 
import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.*;  

/**
 *
 * @author Hriday Dubey
 */

public class SendEmailOffice365 {  
 public void sendEmail(String To_mail, String Subject, String MessageContent) {  
  
  String host="smtp.office365.com";  
  final String user="billdesk@ebex.esselgroup.com";//change accordingly  
  final String password="B!LLD@sk!1234*&";//change accordingly  
     
  
   //Get the session object  
   Properties props = new Properties();  
   props.put("mail.smtp.host",host);  
   props.put("mail.smtp.auth", "true");   
   props.put("mail.smtp.starttls.enable", "true");        
   props.put("mail.smtp.port", 587);
     
   Session session = Session.getDefaultInstance(props,  
    new javax.mail.Authenticator() {  
      @Override
      protected PasswordAuthentication getPasswordAuthentication() {  
    return new PasswordAuthentication(user,password);  
      }  
    });  
  
   //Compose the message  
    try {  
     MimeMessage message = new MimeMessage(session);  
    message.setRecipient(Message.RecipientType.TO, new InternetAddress(To_mail));
            message.setFrom(new InternetAddress(user));
            message.setSubject(Subject); 
            message.setContent(MessageContent, "text/html");
             
    //send the message  
     Transport.send(message);  
   
   
     } catch (MessagingException e) {e.getMessage();}  
 }  
}  
