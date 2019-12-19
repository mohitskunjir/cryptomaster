package cryptomaster.decryption;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

class DecryptText
{
	int decryptionKey;
	byte[] encryptedArray;
	
	public DecryptText(byte[] ipEncryptedArray)
	{
		encryptedArray = ipEncryptedArray;
	}
	
	public int extractKey()
	{
	   decryptionKey = encryptedArray[encryptedArray.length - 1];   
	   return decryptionKey;
	}
	
	public byte[] decryptionCipher()
	{
		int i,sl=encryptedArray.length,dasciit,dasciif,k=0;		
		
		//Block 1
		//Contracted Encrypted Reverse Text 
		
		byte dct[]=new byte[sl/2+1];
		for(i=0;i<sl;i++)
		{
			if(i%2!=0)
			{
				i++;	
			}
			dasciif=(int)encryptedArray[i];
			dasciit=dasciif-decryptionKey;
			
			dct[k]=(byte)dasciit;	
			
			encryptedArray[k]='*';
			k++;			
		}
		
		
		//end of Block 1
		
		//Block 2
		// Plain Text 
		byte pt[] = new byte[sl/2+1];
		for(i=0;i<sl/2;i++)
		{
			pt[i]=dct[(sl/2+1)-i-1];
		}
		
		//end of Block 2
		
		return pt;
	}
	
	public static void main(String args[]) throws IOException
	{
		byte encryptedArray[] = new byte[50000];
		
		int charArrayLength=0, i, counterI;
		
		File inputFile = new File("D:\\files\\encrypted files\\encrpted text.txt");
		FileInputStream inputStream = new FileInputStream(inputFile);
		
		while(( counterI=inputStream.read())!= -1)
		{
			encryptedArray[charArrayLength] = (byte)counterI;
			charArrayLength++;
		}
		inputStream.close();
		
		byte temparr[] = new byte[charArrayLength];
		for(i = 0; i < charArrayLength; i++)
		{
			temparr[i] = encryptedArray[i];
			System.out.print((char)temparr[i]);
		}
		
		System.out.println("\n\nLength = " + charArrayLength) ;
		
		DecryptText test = new DecryptText(temparr);
		
		int returnedKey = test.extractKey();
		
		System.out.println("Returned Key : " + returnedKey);
		
		System.out.println("\n\n Plain Text \n\n");
		
		byte plainText[] = test.decryptionCipher();
		for(i = 0 ; i < plainText.length ; i++)
		{
			System.out.print((char)plainText[i]);
		}
		
		/*File outputFile = new File("D:\\Decrypted.txt");
		FileOutputStream outStream = new FileOutputStream(outputFile);
		outStream.write(plainText);
		outStream.close();*/
	}
}
