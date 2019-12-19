package cryptomaster.encryption;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import cryptomaster.model.FileInfo;

class EncryptText
{
	FileInfo fileInfoObj;
	String inputTextFilePath;
	int key;
	
	public EncryptText(FileInfo fileInfo)
	{
		fileInfoObj = fileInfo;
		inputTextFilePath = fileInfoObj.getInputFilePath();
	}
	
	public String generateKey()
	{
		Random random = new Random();
		key = random.nextInt(9);
		
		int k1 = random.nextInt(200);
		int k2 = random.nextInt(9);
		int k3 = random.nextInt(250);
		int k4 = random.nextInt(90);
		int k5 = random.nextInt(9);
		int k6 = random.nextInt(300);
		int k7 = random.nextInt(9);
		
		char c1 = (char) k1;
		char c3 = (char) k3;
		char c6 = (char) k6;
		
		Character c11 = new Character(c1);
		Character c33 = new Character(c3);
		Character c66 = new Character(c6);
		
		Integer k22 = new Integer(k2);
		Integer k44 = new Integer(k4);
		Integer k55 = new Integer(k5);
		Integer k77 = new Integer(k7);
		Integer akey = new Integer(key);

		String keys = new String(c11.toString());
		keys = keys + k22.toString();
		keys = keys + c33.toString();
		keys = keys + k44.toString();
		keys = keys + k55.toString();
		keys = keys + c66.toString();
		keys = keys + k77.toString();
		keys = keys + akey.toString();
		System.out.println(" keys " + keys);
		
		return keys;
	}
	
	public byte[] encrypt() throws IOException
	{	
		Random random = new Random();
		int counterI, counterJ, charArrayLength=0, easciit, easciif;
		byte inputCharArray[]=new byte[50000];
		byte reverseArray[] = new byte[50000];
		byte encryptedArray[]=new byte[50000];
		byte temp;
		
		// Block 1
		// File read
		
		File inputFile = new File(inputTextFilePath);
		FileInputStream inputStream = null;
		
		inputStream = new FileInputStream(inputFile);
		
		while((counterI=inputStream.read())!= -1)
		{
			inputCharArray[charArrayLength] = (byte)counterI;
			charArrayLength++;
		}
		inputStream.close();
		//end of Block 1
	
		
		//Block 2		
		//Reverse text 
		
		for(counterI=0;counterI<charArrayLength;counterI++)
		{
			reverseArray[counterI]=inputCharArray[charArrayLength-counterI-1];
		}
		//end of Block 2
		
		//Block 3
		//Encrypted Reverse text 
		for(counterI=0;counterI<charArrayLength;counterI++)
		{
			easciit=(int)reverseArray[counterI];
			easciif=easciit+key;
			encryptedArray[counterI]=(byte)easciif;
			inputCharArray[counterI]='*';
			reverseArray[counterI]='*';
		}
		//end of Block 3
		
		//Block 4
		// Expanded Encrypted Reverse text
		for(counterI=0;counterI<charArrayLength*2;counterI++)
		{
			temp=encryptedArray[counterI];
			if(counterI%2!=0)
			{
				counterJ=charArrayLength*2;
				while(counterJ>counterI)
				{
					encryptedArray[counterJ+1]=encryptedArray[counterJ];
					counterJ=counterJ-1;	
				}
				encryptedArray[counterI]=(byte)(counterI + random.nextInt(50));
				encryptedArray[counterI+1]=temp;
			}
		}
		
		//end 0f Block 4
		int i, length = charArrayLength * 2 + 1;
		byte temparr[] = new byte[length];
		for(i = 0; i < charArrayLength * 2; i++)
		{
			temparr[i] = encryptedArray[i];
		}
		
		temparr[i] =  (byte) key;
		
		return temparr;		
	}
	
	public static void main(String args[]) throws IOException
	{
		FileInfo testFile = new FileInfo();
		testFile.setInputFilePath("D:\\files\\original text.txt");
		
		EncryptText testCipher = new EncryptText(testFile);		
		String key = testCipher.generateKey();
		
		System.out.println("Key = " + key);
		
		byte encryptedArray [] = testCipher.encrypt();
		
		System.out.println("Encryption Completed\n\nEncrypted Text:\n\n");
		
		for(int counter = 0 ; counter < encryptedArray.length ; counter++)
		{
			System.out.print((char)encryptedArray[counter]);
		}
	}
}
