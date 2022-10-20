## BIG PROJECT 
### CICLE STAGING
### https://staging.cicle.app/

----

This is a functional test of Cicle Website (staging phase) including several features:
**Board, Group chat, and Check Ins**. 
Using Java, Cucumber, and Test NG as a runner.

### Framework
* Maven
* TestNG https://mvnrepository.com/artifact/org.testng/testng
* Cucumber https://mvnrepository.com/artifact/io.cucumber/cucumber-testng
* Selenium https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
* Sunmail https://mvnrepository.com/artifact/com.sun.mail/javax.mail

### Running Test
* To run this test **without generating a report**, open runner file and make sure the tag is **@regression** then press Run button
* To run this test **with generating a report**, make sure tag on the runner file is **@regression** and type **mvn clean test** on your terminal

### Test Case Documentation
This code is following this test case documentation.
https://docs.google.com/spreadsheets/d/1siqwD10Ndeu1Znm-ezUvqZukzGa2ZfOrZCFNGzV1AkY/edit?usp=sharing

### Report Mailing Purpose
To send the report via email, please add a new class on main folder then paste this following code and edit several parts needed:

import java.io.File;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendReportUtils {

    public static void main() {

        System.out.println("preparing to send message ...");
        String message = "body message";
        String subject = "email subject";
        String to = "receiver email";
        String from = "sender email";

		sendEmail(message,subject,to,from);
        sendAttach(message,subject,to,from);
    }

    //this is responsible to send the message with attachment
    private static void sendAttach(String message, String subject, String to, String from) {

        //Variable for gmail
        String host="smtp.gmail.com";
        //get the system properties
        Properties properties = System.getProperties();
        System.out.println("PROPERTIES "+properties);
        //setting important information to properties object
        //host set
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");
        //Step 1: to get the session object..
        Session session=Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("sender email", "password");
            }
        });
        session.setDebug(true);
        //Step 2 : compose the message [text,multi media]
        MimeMessage m = new MimeMessage(session);
        try {
            //from email
            m.setFrom(from);
            //adding recipient to message
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            //adding subject to message
            m.setSubject(subject);
            //attachement..
            //file path
            String path="file path";
            MimeMultipart mimeMultipart = new MimeMultipart();
            //text
            //file
            MimeBodyPart textMime = new MimeBodyPart();
            MimeBodyPart fileMime = new MimeBodyPart();
            try {
                textMime.setText(message);
                File file=new File(path);
                fileMime.attachFile(file);
                mimeMultipart.addBodyPart(textMime);
                mimeMultipart.addBodyPart(fileMime);
            } catch (Exception e) {
                e.printStackTrace();
            }
            m.setContent(mimeMultipart);
            //send
            //Step 3 : send the message using Transport class
            Transport.send(m);
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Sent success...................");
    }

    //this is responsible to send email..
    private static void sendEmail(String message, String subject, String to, String from) {
        //Variable for gmail
        String host="smtp.gmail.com";
        //get the system properties
        Properties properties = System.getProperties();
        System.out.println("PROPERTIES "+properties);
        //setting important information to properties object
        //host set
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");
        //Step 1: to get the session object..
        Session session=Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("sender email", "password");
            }
        });
        session.setDebug(true);
        //Step 2 : compose the message [text,multi media]
        MimeMessage m = new MimeMessage(session);
        try {
            //from email
            m.setFrom(from);
            //adding recipient to message
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            //adding subject to message
            m.setSubject(subject);
            //adding text to message
            m.setText(message);
            //send
            //Step 3 : send the message using Transport class
            Transport.send(m);
            System.out.println("Sent success...................");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}