package cryptomaster.email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUserCredentials 
{
	String emailText;
	
	public boolean mailUserCredentials(String[] userInfo) 
	{	
		boolean mailSent = false;
		final String adminEmailid = "encryptomaster1113@gmail.com";
		final String password = "cryptomaster1113";

		String username = userInfo[0];
		String emailId = userInfo[1];
		String UserPassword = userInfo[2];
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator()
		{
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication(adminEmailid, password);
			}
		});

		try 
		{
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(adminEmailid));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(emailId));
			message.setSubject("User Credentials");
			emailText = new String("Dear user, \n\n This E-Mail was sent to you on your request of viewing your Login credentials, which are as under.\n Email-ID: " + emailId + "\nPassword: " + UserPassword + "\nUsername: " + username + "\nIf you have forgotten your password, we recommend you to change it once you login.");
			message.setText(emailText);

			Transport.send(message);

			System.out.println(emailText);
			mailSent = true;
			return mailSent;
		}

		catch (MessagingException e) 
		{
			System.out.println("Message Exception: " + e.getMessage());
			mailSent = false;
			return mailSent;
		}
		catch (Exception e) 
		{
			System.out.println("Exception: " + e.getMessage());
			mailSent = false;
			return mailSent;
		}
		
	}

	public static void main(String[] args) 
	{
		
		
		String userInfo[] = new String[3];
		userInfo[0] = "Mohit";
		userInfo[1] = "mohitkunjir@gmail.com";
		userInfo[2] = "1234567890";
					
		boolean mailSent = false;
		EmailUserCredentials test = new EmailUserCredentials();
		mailSent = test.mailUserCredentials(userInfo);
		System.out.println("Mail Sent: " + mailSent);
	}
}