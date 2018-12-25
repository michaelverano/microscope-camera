//package camera.operations;
import java.util.Properties;
import java.io.*;
import java.lang.*;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.Multipart;
import javax.mail.BodyPart;

import javax.activation.FileDataSource;
import javax.activation.DataSource;
import javax.activation.DataHandler;

public class email_image {
    public static void main(String[] args) {
	Console user_console = System.console();
	String enteredUser = new String(user_console.readLine("Type username: "));
	
	Console password_console = System.console();
	String enteredPassword = new String(password_console.readPassword("Password: "));
        String filename = "test.txt";


	System.out.println(enteredUser);
	email_image email = new email_image();
	email.start(enteredUser, enteredUser,  enteredPassword,  filename);
    }

    public static void start(String from_username, String to_username, String password, String filename){

	// final String from_username = "";
	// final String password = enteredPassword;
	// final String to_username = "";

	Properties props = new Properties();
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.port", "587");

	// Session Object
	Session session = Session.getInstance(props,
					      new javax.mail.Authenticator() {
						  protected PasswordAuthentication getPasswordAuthentication(){
						      return new PasswordAuthentication(from_username, password);
						  }
					      });

	try {
	    // Create a default MimeMessage object
	    Message message = new MimeMessage(session);

	    // Set from header field of the header.
	    message.setFrom(new InternetAddress(from_username));

	    //Set to: Header field of the header
	    message.setRecipients(Message.RecipientType.TO,
				  InternetAddress.parse(to_username));

	    // Set Subject: header field
	    message.setSubject("Testing Subject");

	    // Create the message part
	    BodyPart messageBodyPart = new MimeBodyPart();

	    // Set  message
	    messageBodyPart.setText("Test Message.");

	    // Setting up the multipart message
	    Multipart multipart = new MimeMultipart();

	    // Set text message part
	    multipart.addBodyPart(messageBodyPart);

	    // Set up the attachment
	    messageBodyPart = new MimeBodyPart();
	    DataSource source = new FileDataSource(filename);
	    messageBodyPart.setDataHandler(new DataHandler(source));
	    messageBodyPart.setFileName(filename);
	    multipart.addBodyPart(messageBodyPart);

	    // Send the complete message parts
	    message.setContent(multipart);

	    // Send the message
	    Transport.send(message);

	    System.out.println("Message sent successsfully....");

	} catch (MessagingException e) {
	    throw new RuntimeException(e);
	}
    }
}
