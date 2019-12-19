package cryptomaster.decryption;

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
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import cryptomaster.model.FileInfo;

public class DecryptImageAudioVideo 
{

	Cipher cipher = null; 
	SecretKey secretKey = null; 
	
	FileInfo fileInfoObj;
	
	String encryptedFilePath;
	String decryptedFilePath;
	
	String encryptionKey;
	byte[] encryptionDecodedKey;
	
	public DecryptImageAudioVideo(FileInfo fileInfo) 
	{
		fileInfoObj = fileInfo;
		encryptedFilePath = fileInfoObj.getEncryptedFilePath();
		decryptedFilePath = fileInfoObj.getDecryptedFilePath();
		encryptionKey = fileInfoObj.getEncryptedFileKey();
		encryptionKey = encryptionKey.trim();
	}
	
	public boolean convertStringKeyToSecretKey()
	{
		boolean keyGenerated = false;
		try 
		{
			// Create an object of Cipher class mentioning the name of algorithm  - AES	
			cipher = Cipher.getInstance("AES");
		
			// Create a AES key 
			StringKeyToByteArray test = new StringKeyToByteArray(); 
			encryptionDecodedKey = test.base64ToByteArray(encryptionKey); // secret key byte[] - String encryptionKey // For decryption
			System.out.println(new String(encryptionDecodedKey));
			secretKey = new SecretKeySpec(encryptionDecodedKey,0,encryptionDecodedKey.length,"AES"); // build original key
			System.out.println(new String(secretKey.getEncoded()));
			keyGenerated = true;
			return keyGenerated;
		} 
		catch (NoSuchAlgorithmException e) 
		{
			keyGenerated = false;
			e.printStackTrace();
			return keyGenerated;
		} 
		catch (NoSuchPaddingException e)
		{
			e.printStackTrace();
			keyGenerated = false;
			return keyGenerated;	
		}
		catch (Exception e)
		{
			e.printStackTrace();
			keyGenerated = false;
			return keyGenerated;	
		}
	}

	@SuppressWarnings("resource")
	public boolean decrypt()  
	
	{  
		boolean decryptionPerformed =  false;
		
		File encryptedFile = new File(encryptedFilePath);  

		File decryptedFile = new File(decryptedFilePath);  

		InputStream inStream = null;  
		OutputStream outStream = null; 
		
		try 
		{  

			// Decryption Cipher

			cipher.init(Cipher.DECRYPT_MODE, secretKey); 

			inStream = new FileInputStream(encryptedFile);  
			outStream = new FileOutputStream(decryptedFile); 

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
			decryptionPerformed = true;
			return decryptionPerformed;
		}

		catch (IllegalBlockSizeException ex)
		{  
			decryptionPerformed =  false;
			System.out.println(ex);  
			return decryptionPerformed;
		}

		catch (BadPaddingException ex) 
		{  
			decryptionPerformed =  false;
			System.out.println(ex);  
			return decryptionPerformed;
		} 

		catch (InvalidKeyException ex)
		{  
			decryptionPerformed =  false;
			System.out.println(ex);  
			return decryptionPerformed;
		} 

		catch (FileNotFoundException ex) 
		{  
			decryptionPerformed =  false;
			System.out.println(ex);  
			return decryptionPerformed;
		} 

		catch (IOException ex)
		{  
			decryptionPerformed =  false;
			System.out.println(ex);  
		} 
		 return decryptionPerformed;

	} 
	
	public static void main(String[] args) 
	{  
		String encryptedFilePath = "D:\\files\\encrypted files\\encrypted video.3gp";
		String decryptedFilePath = "D:\\files\\decrypted files\\decrypted video.3gp";
		String encryptedFileKey = "JVI0MBqefACAP+gMEFMzvA== ";
		
		FileInfo testDecryption = new FileInfo();
		testDecryption.setEncryptedFilePath(encryptedFilePath);
		testDecryption.setDecryptedFilePath(decryptedFilePath);
		testDecryption.setEncryptedFileKey(encryptedFileKey);
		
		System.out.println("Passing information for Decryption...");
		
		DecryptImageAudioVideo decryptFile = new DecryptImageAudioVideo(testDecryption);
		
		System.out.println("Generating key...");
		
		boolean keyGenreated = decryptFile.convertStringKeyToSecretKey();
		
		if(keyGenreated)
		{
			System.out.println("Starting Decryption...");
			
			boolean  decryptionPerformed=decryptFile.decrypt();
			
			if(decryptionPerformed)
			{
				System.out.println("Decryption performed: " + decryptionPerformed);
			}
			else
			{
				System.out.println("Keys do not match");
			}
		}
		else
		{
			System.out.println("Key cannot generated");
		}
		
		
	

	}  

}  
	


