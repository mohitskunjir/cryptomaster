package cryptomaster.decryption;

import java.awt.image.BufferedImage;
import java.io.File;


import javax.imageio.*;

import cryptomaster.model.FileInfo;

class DecodeMessage
{
	BufferedImage inputImage = null;
 
	FileInfo  fileInfoObj;
	String steganographedImageFilePath;
	
	public DecodeMessage(FileInfo fileInfo) 
	{
		fileInfoObj = fileInfo;		
		steganographedImageFilePath = fileInfoObj.getEncryptedFilePath();
	}

	public boolean openImage() 
	{
		boolean imageLoaded = false;
		
		File f = new File(steganographedImageFilePath);
		try 
		{   
			inputImage = ImageIO.read(f);
			imageLoaded = true;
		} 
		catch(Exception ex) 
		{ 
			imageLoaded = false; 
		}
		return imageLoaded;
	}
 
	public byte[] decodeMessage()
	{
		int len = extractInteger(inputImage, 0, 0);
		byte embeddedMessage[] = new byte[len];
		
		for(int i=0; i<len; i++)
		{
			embeddedMessage[i] = extractByte(inputImage, i*8+32, 0);
		}
		
		return embeddedMessage;
	}
	
	private int extractInteger(BufferedImage img, int start, int storageBit)
	{
		int maxX = img.getWidth(), maxY = img.getHeight(), startX = start/maxY, startY = start - startX*maxY, count=0, length = 0;
	    
		for(int i=startX; i<maxX && count<32; i++) 
	    {
	       for(int j=startY; j<maxY && count<32; j++) 
	       {
	          int rgb = img.getRGB(i, j), bit = getBitValue(rgb, storageBit);
	          length = setBitValue(length, count, bit);
	          count++;
	       }
	    }
		
	    return length;
	}
 
	private byte extractByte(BufferedImage img, int start, int storageBit) 
	{
		int maxX = img.getWidth(), maxY = img.getHeight(), startX = start/maxY, startY = start - startX*maxY, count=0;
	    byte b = 0;
	    
	    for(int i=startX; i<maxX && count<8; i++) 
	    {
	       for(int j=startY; j<maxY && count<8; j++) 
	       {
	         int rgb = img.getRGB(i, j), bit = getBitValue(rgb, storageBit);
	          b = (byte)setBitValue(b, count, bit);
	          count++;
	        }
	    }
	    
	    return b;
	}
 
	private int getBitValue(int n, int location) 
	{
		int v = n & (int) Math.round(Math.pow(2, location));
		return v==0?0:1;
    }
 
	private int setBitValue(int n, int location, int bit) 
	{
		int toggle = (int) Math.pow(2, location), bv = getBitValue(n, location);
	    if(bv == bit)
	       return n;
	    if(bv == 0 && bit == 1)
	       n |= toggle;
	    else if(bv ==  1&& bit == 0)
	       n ^= toggle;
	    return n;
    }
 
 public static void main(String arg[])
 {
	boolean imageLoaded = false;
	 
	byte[] embeddedMessage;
	 
	FileInfo testFile = new FileInfo();
	 
	testFile.setInputFilePath("D:\\files\\steganographed image\\steganographed image.png");
	testFile.setEncryptedFilePath("D:\\files\\decrypted files\\decrypted text.txt");
	 
	DecodeMessage testDecode = new DecodeMessage(testFile);
	 
	imageLoaded = testDecode.openImage();
		
	if(imageLoaded)
	{
		embeddedMessage = testDecode.decodeMessage();
		System.out.println("\n\nDecoding done Done: " + embeddedMessage);
	}
	else
	{
		System.out.println("Cannot Load the Image");
	}
	  
  }
 }

