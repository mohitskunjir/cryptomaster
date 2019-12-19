package cryptomaster.encryption;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;


import cryptomaster.model.FileInfo;

public class EncryptImageAudioVideo
{  	
	FileInfo fileInfoObj;
	
	String inputFilePath;
	String encryptedFilePath;
	String encryptionKey;
	
	Cipher cipher = null;
	KeyGenerator keyGenerator = null;  
	SecretKey secretKey = null;   

	public EncryptImageAudioVideo(FileInfo fileInfo) 
	{  
		fileInfoObj = fileInfo;
		inputFilePath = fileInfoObj.getInputFilePath();
		encryptedFilePath = fileInfoObj.getEncryptedFilePath();
	}
	
	public boolean generateKey()
	{
		boolean keyGenerated = false;
		
		try 
		{
			// Create an object of Cipher class mentioning the name of algorithm  - AES			
			cipher = Cipher.getInstance("AES");  
			
			// Create a AES key 
			keyGenerator = KeyGenerator.getInstance("AES");  // AES key generation (other cryptography algorithm work too instead of DES
			secretKey = keyGenerator.generateKey();
			
			SecretKeyToString test = new SecretKeyToString();
			encryptionKey = test.byteArrayToBase64(secretKey.getEncoded()); // String encryptionKey - SecretKey secretKey
			fileInfoObj.setEncryptedFileKey(encryptionKey);
			
			keyGenerated = true;
		} 

		catch (NoSuchPaddingException ex) 
		{  
			keyGenerated = false;
			System.out.println(ex);  
		} 

		catch (NoSuchAlgorithmException ex) 
		{  
			keyGenerated = false;
			System.out.println(ex);  
		}  
		
		return keyGenerated;
	}  

	public boolean encrypt() 
	{  
		boolean encryptionPerformed =  false;
		
		File rawFile = new File(inputFilePath);  
		File encryptedFile = new File(encryptedFilePath);

		InputStream inStream = null;  
		OutputStream outStream = null;  

		try 
		{  
			//Encryption cipher
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);  

			inStream = new FileInputStream(rawFile);  

			outStream = new FileOutputStream(encryptedFile); 

			byte[] buffer = new byte[1024];  
			int len;  

			while ((len = inStream.read(buffer)) > 0) 
			{  
				outStream.write(cipher.update(buffer, 0, len));  
				outStream.flush();  
			}  

			outStream.write(cipher.doFinal());  
			inStream.close();  
			outStream.close();  
			encryptionPerformed = true;
		}

		catch (IllegalBlockSizeException ex) 
		{  
			encryptionPerformed =  false;
			System.out.println(ex);  
		} 

		catch (BadPaddingException ex)
		{  
			encryptionPerformed =  false;
			System.out.println(ex);  
		} 

		catch (InvalidKeyException ex)
		{  
			encryptionPerformed =  false;
			System.out.println(ex);  
		}	 

		catch (FileNotFoundException ex) 
		{  
			encryptionPerformed =  false;
			System.out.println(ex);  
		} 

		catch (IOException ex) 
		{  
			encryptionPerformed =  false;
			System.out.println(ex);  
		}  
		
		return encryptionPerformed;
	}
	
	public String getEncryptionKey()
	{
		return encryptionKey;
	} 

	public static void main(String[] args) 
	{  	
		String inputFilePath = "D:\\files\\original video.3gp";
		String encryptedFilePath = "D:\\files\\encrypted files\\encrypted video.3gp";

		FileInfo testFileEncryption = new FileInfo();
		testFileEncryption.setInputFilePath(inputFilePath);
		testFileEncryption.setEncryptedFilePath(encryptedFilePath);
		
		System.out.println("Passing Reqired Information...");
		
		EncryptImageAudioVideo encryptFile = new EncryptImageAudioVideo(testFileEncryption);
		
		System.out.println("Generating key...");
		
		boolean keyGenerated = encryptFile.generateKey();
		
		if(keyGenerated)
		{
			System.out.println("Key Generated");
			
			System.out.println("Starting Encryption...");
			
			boolean encryptionPerformed =  encryptFile.encrypt();
			
			System.out.println("Encryption performed: " + encryptionPerformed);
			
			System.out.println("Encryption key: " + encryptFile.encryptionKey);
		}
		
		else
		{
			System.out.println("Error Occured");
		}
		
	
	}  

}

	