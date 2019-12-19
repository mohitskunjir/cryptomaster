package cryptomaster.encryption;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

import cryptomaster.model.FileInfo;
import cryptomaster.model.UserInfo;

public class TextEncryptionController 
{
	UserInfo userInfoObj;
	FileInfo fileInfoObj;
	
	String encryptedTextFilePath;
	String encryptionFor;
	String sentEmailId;
	
	String encryptionKey;
	
	boolean steganographyEligibility = false;
	byte encryptedArray[];
	
	public TextEncryptionController(UserInfo userInfo, FileInfo fileInfo)
	{
		userInfoObj = userInfo;
		
		fileInfoObj = fileInfo;
		
		encryptedTextFilePath = fileInfoObj.getEncryptedFilePath();
		encryptionFor = fileInfoObj.getEncryptedFileFor();
	}
	
	public boolean setTextEncryptionParameters() throws IOException
	{
		EncryptText initiateEncryption = new EncryptText(fileInfoObj);
		
		encryptionKey = initiateEncryption.generateKey();
	    
	    fileInfoObj.setEncryptedFileKey(encryptionKey);
	    
	    encryptedArray = initiateEncryption.encrypt();
		
		long fileSize = encryptedArray.length;		
		if(fileSize<10000)
		{
			steganographyEligibility = true;			
		}
		
		else
		{
			steganographyEligibility = false;
		}
		
		return steganographyEligibility;
	}
	
	public void steganography()
	{
		 String encryptMessage = new String(encryptedArray);
		 
		 EmbedMessage steg = new EmbedMessage(userInfoObj,fileInfoObj,encryptMessage); 
		 steg.setVisible(true);
	}
	
	public boolean fileSave() 
	{
		boolean fileSaved = false;
		File encryptedFile = null;
	   	FileOutputStream outputStream = null;
	    
	   	try
	   	{
	   		encryptedFile = new File(encryptedTextFilePath); 
	   		outputStream = new FileOutputStream(encryptedFile);
			for(int counterI=0;counterI<encryptedArray.length;counterI++)
			{
				outputStream.write(encryptedArray[counterI]);
				encryptedArray[counterI]='*';
			}
			fileSaved = true;
			JOptionPane.showMessageDialog(null,"Encryption is done!!\n" + "Email was sent to: " +userInfoObj.getReciverEmailId() + "\nEncrypted File stored at location: " + encryptedTextFilePath + "\nYour Key: " + encryptionKey, "SUCCESS !!!",JOptionPane.INFORMATION_MESSAGE);
			System.out.println("Key: " + encryptionKey);
	   	}
	   	catch (IOException ioe)
	   	{
	   		fileSaved = false;
	   	}
		return fileSaved;
	}
	
	public String getEncryptionKey()
	{
		return encryptionKey;
	}
	
	public static void main(String args[])
	{
		UserInfo userTestInfo = new UserInfo();
		userTestInfo.setUsername("Mohit");
		userTestInfo.setReciverEmailId("mohitssj10@gmail.com");
		
		FileInfo fileTestInfo = new FileInfo();
		fileTestInfo.setInputFilePath("D:\\files\\original text.txt");
		fileTestInfo.setEncryptedFilePath("D:\\files\\encrypted files\\encrypted text.txt");
		fileTestInfo.setEncryptedFileFor("other");
		
		boolean steganographyEligible = false;
		boolean performSteganography = false;
		
		TextEncryptionController test = new TextEncryptionController(userTestInfo, fileTestInfo);
		try 
		{
			steganographyEligible = test.setTextEncryptionParameters();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		if(steganographyEligible)
		{
			if(performSteganography)
			{
				test.steganography();
			}
			else
			{
					boolean fileSaved = test.fileSave();
					System.out.println("File save Satus " + fileSaved);
			}
		}
		
		System.out.println("Input File Path = D:\\files\\original text.txt" );
		System.out.println("Encrypted File Path = D:\\files\\encrypted files\\encrypted text.txt" );
		System.out.println("Encrypted File For: self");
		System.out.println("Eligible for steganography: " + steganographyEligible);
		System.out.println("Perform Steganography = " + performSteganography);
		System.out.println("\n\nDone !!!");
	}
	
}
