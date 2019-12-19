package cryptomaster.email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import cryptomaster.model.FileInfo;
import cryptomaster.model.UserInfo;

public class SendMailTLS 
{
	String emailText;
	
	public boolean sendEmail(UserInfo userInfo, FileInfo fileInfo) 
	{	
		boolean mailSent = false;
		final String adminEmailid = "encryptomaster1113@gmail.com";
		final String password = "cryptomaster1113";

		String username = userInfo.getUsername();
		String recipientEmailId = userInfo.getReciverEmailId();
		String encryptedFileName = fileInfo.getEncryptedFileName();
		String key = fileInfo.getEncryptedFileKey();
		String senderEmail = userInfo.getEmailid();
		
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
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmailId));
			message.setSubject("Encryption Key");
			emailText = new String("Dear user, \n\n The user who created the encrypted file: " +  username +" ("+senderEmail+")"+ "\n\n The name of the Encrypted file is: " + encryptedFileName + "\n\n The key is: " + key);
			message.setText(emailText);

			Transport.send(message);

			System.out.println(emailText);
			mailSent = true;
			return mailSent;
		}

		catch (MessagingException e) 
		{
			mailSent = false;
			return mailSent;
		}
	}

	public static void main(String[] args) 
	{
		UserInfo testUser = new UserInfo();
		testUser.setUsername("Mohit");
		testUser.setEmailid("mimayu25@gmail.com");
		testUser.setReciverEmailId("mohitssj10@gmail.com");
		
		FileInfo testFileKey = new FileInfo();
		testFileKey.setEncryptedFileKey("12345");
		testFileKey.setEncryptedFileName("enc.jpg");
		
		boolean mailSent = false;
		SendMailTLS test = new SendMailTLS();
		mailSent = test.sendEmail(testUser, testFileKey);
		System.out.println("Mail Sent: " + mailSent);
	}
}