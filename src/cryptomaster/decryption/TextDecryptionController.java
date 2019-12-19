package cryptomaster.decryption;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import cryptomaster.model.FileInfo;

public class TextDecryptionController 
{
	byte[] embeddedMessage;
	byte[] plainText;
	
	FileInfo fileInfoObj = new FileInfo();
	
	String encryptedFilePath;
	String decryptedFilePath;
	String decryptionKey;
	
	public TextDecryptionController(FileInfo fileInfo)
	{
		fileInfoObj = fileInfo;
		
		encryptedFilePath = fileInfoObj.getEncryptedFilePath();
		decryptedFilePath = fileInfoObj.getDecryptedFilePath();
		decryptionKey = fileInfoObj.getEncryptedFileKey();
	}
	
	public boolean loadSteganographedImage()
	{
		boolean imageLoaded = false;
		
		DecodeMessage testDecode = new DecodeMessage(fileInfoObj);
		imageLoaded = testDecode.openImage();		
		if(imageLoaded)
		{
			embeddedMessage = testDecode.decodeMessage();
			imageLoaded = true;
			return imageLoaded;
		}
		else
		{
			imageLoaded = false;
			return imageLoaded;
		}
	}
	
	public boolean loadEncryptedTextFile()
	{
		boolean fileLoaded = false;
		
		int charArrayLength=0, counterI;
		byte tempInputArray[] =  new byte[50000];
		
		try
		{
			File inputFile = new File(encryptedFilePath);
			FileInputStream inputStream = new FileInputStream(inputFile);
			
			while(( counterI=inputStream.read())!= -1)
			{
				tempInputArray[charArrayLength] = (byte)counterI;
				charArrayLength++;
			}
			
			inputStream.close();
			
			embeddedMessage = new byte[charArrayLength];
			for(int i = 0 ; i < charArrayLength ; i++)
			{
				embeddedMessage[i] = tempInputArray[i];
			}
			fileLoaded = true;
		}
		catch (FileNotFoundException e)
		{
			fileLoaded = false;
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			fileLoaded = false;
			e.printStackTrace();
		}
		
		
		
		return fileLoaded;
	}
	
	public boolean compareKeys()
	{
		boolean keysMatch = false;
		
		DecryptText testKeys = new DecryptText(embeddedMessage);
		int returnedKey = testKeys.extractKey();
		Integer IKey = new Integer(returnedKey);
		String SKey = new String(IKey.toString());
		if(SKey.equals(decryptionKey))
		{
			keysMatch = true;
		}
		else
		{
			keysMatch = false;
		}
		return keysMatch;
	}
	
	public boolean textDecryption()
	{
		boolean decryptionDone = false;
		
		DecryptText decryptingText = new DecryptText(embeddedMessage);
		decryptingText.extractKey();
		plainText = decryptingText.decryptionCipher();
		decryptionDone = true;
		if(plainText.length<=0)
		{
			decryptionDone = false;
		}
		return decryptionDone;
	}
	
	public boolean fileSave()
	{
		boolean fileSaved = false;
		
		File outputFile = null;
		FileOutputStream outStream = null;
		
		try 
		{
			outputFile = new File(decryptedFilePath);
			outStream = new FileOutputStream(outputFile);
			outStream.write(plainText);
			outStream.close();
			fileSaved = true;
		}
		catch (FileNotFoundException e)
		{
			fileSaved = false;
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			fileSaved = false;
			e.printStackTrace();
		}
		
		return fileSaved;
	}
		
	public static void main(String args[])
	{
		String encryptedTextFilePath = "D:\\files\\encrypted files\\encrypted text.txt";
		String steganographedImageFilePath = "D:\\files\\steganographed image\\steganographed image.png";
		String decryptedTextFilePath1= "D:\\files\\decrypted files\\encrypted text (from txt).txt";
		String decryptedTextFilePath2= "D:\\files\\decrypted files\\encrypted text (from img).txt";
		String encryptedFileKey1 = "4";
		String encryptedFileKey2 = "5";
		
		FileInfo setInfo1 = new FileInfo();
		setInfo1.setEncryptedFilePath(encryptedTextFilePath);
		setInfo1.setDecryptedFilePath(decryptedTextFilePath1);
		setInfo1.setEncryptedFileKey(encryptedFileKey1);
		
		TextDecryptionController test1 = new TextDecryptionController(setInfo1);
		boolean loadTextFile = test1.loadEncryptedTextFile();
		if(loadTextFile)
		{
			System.out.println("Encrypted Text File loaded\n");
			boolean keysMatch = test1.compareKeys();
			if(keysMatch)
			{
				System.out.println("Keys Match\n");
				System.out.println("Starting Decryption of Text File\n");
				boolean decryptionDone = test1.textDecryption();
				if(decryptionDone)
				{
					System.out.println("Text File Decryption complete\n");
					boolean fileSaved1 = test1.fileSave();
					if(fileSaved1)
					{
						System.out.println("Decrypted Text File saved at: " + decryptedTextFilePath1 + "\n");
					}
				}
				else
				{
					System.out.println("Error: Decrypted Text File Cannot be stored");
				}
			}
			else
			{
				System.out.println("Error: Keys do not match. Enter valid key");
			}
		}
		else
		{
			System.out.println("Error: Text File Cannot be loaded. Check encrypted text file path...");
		}
		
		FileInfo setInfo2 = new FileInfo();
		
		setInfo2.setEncryptedFilePath(steganographedImageFilePath);
		setInfo2.setDecryptedFilePath(decryptedTextFilePath2);
		setInfo2.setEncryptedFileKey(encryptedFileKey2);
		
		TextDecryptionController test2 = new TextDecryptionController(setInfo2);
		boolean loadImage = test2.loadSteganographedImage();
		if(loadImage)
		{
			System.out.println("Steganographed Image File loaded\n");
			boolean keysMatch = test2.compareKeys();
			if(keysMatch)
			{
				System.out.println("Keys Match\n");
				System.out.println("Starting Decryption of Text File\n");
				boolean decryptionDone = test2.textDecryption();
				if(decryptionDone)
				{
					System.out.println("Text File Decryption complete\n");
					boolean fileSaved2 = test2.fileSave();
					if(fileSaved2)
					{
						System.out.println("Decrypted Text File saved at: " + decryptedTextFilePath2 + "\n");
					}
				}
				else
				{
					System.out.println("Error: Decrypted Tet File Cannot be stored");
				}
			}
			else
			{
				System.out.println("Error: Keys do not match. Enter valid key");
			}
		}
		else
		{
			System.out.println("Error: Image File Cannot be loaded. Check encrypted text file path...");
		}
		
		
	}

}
