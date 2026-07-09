package practice;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Test130
{
	public static void main(String[] args) throws Exception
	{
		//Create object to "Properties" class and set "mailing server" details
		Properties props=new Properties();
		props.put("mail.smtp.host","smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port","465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth","true");
		props.put("mail.smtp.port","465");
		// This will handle the complete authentication(credentials)
		Authenticator auth=new Authenticator()
		{
			protected PasswordAuthentication getPasswordAuthentication() 
			{
				return new PasswordAuthentication("magnitiait","oiqxspfsmowvlrdw");
			}
		};
		//Create object of Session class by using properties and authentication info
		Session s=Session.getDefaultInstance(props,auth);
		//Create object of Message class and set details
		Message msg=new MimeMessage(s);
		msg.setFrom(new InternetAddress("magnitiait@gmail.com"));
		msg.setRecipients(Message.RecipientType.TO,
				      InternetAddress.parse("heenabhatti042@gmail.com,jds.prst@gmail.com,magnitiait@gmail.com"));
		msg.setSubject("Testing Subject");
		// Create object to add multimedia type content for body and attachment
		BodyPart bodymsg1=new MimeBodyPart();
		bodymsg1.setText("Hi\n please refer atached file");
		BodyPart bodymsg2=new MimeBodyPart();
		String filename="E:\\Model Resume Exp.doc";
		DataSource source=new FileDataSource(filename);
		bodymsg2.setDataHandler(new DataHandler(source));
		bodymsg2.setFileName(filename);
		// Create object of MimeMultipart class
		Multipart mpart=new MimeMultipart();
		mpart.addBodyPart(bodymsg1);
		mpart.addBodyPart(bodymsg2);
		msg.setContent(mpart);
		// Finally send the email
		Transport.send(msg);
		System.out.println("=====Email Sent=====");
	}
}
