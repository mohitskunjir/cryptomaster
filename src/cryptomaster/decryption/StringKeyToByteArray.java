package cryptomaster.decryption;

public class StringKeyToByteArray 
{ 
    public byte[] base64ToByteArray(String s) 
    {
        byte[] alphaToInt =  
        {
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54,
                55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4,
                5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23,
                24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34,
                35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51
        };
        
        int sLen = s.length();
        int numGroups = sLen/4;
        
        if (4*numGroups != sLen)
        {
        	throw new IllegalArgumentException("String length must be a multiple of four.");
        }       
        
        int missingBytesInLastGroup = 0;
        int numFullGroups = numGroups;
        
        if (sLen != 0) 
        {
            if (s.charAt(sLen-1) == '=') 
            {
                missingBytesInLastGroup++;
                numFullGroups--;
            }
            if (s.charAt(sLen-2) == '=')
            {
            	missingBytesInLastGroup++;
            }        
        }
        
        byte[] result = new byte[3*numGroups - missingBytesInLastGroup];

        // Translate all full groups from base64 to byte array elements
        int inCursor = 0, outCursor = 0;
        for (int i=0; i<numFullGroups; i++)
        {
            int ch0 = base64toInt(s.charAt(inCursor++), alphaToInt);
            int ch1 = base64toInt(s.charAt(inCursor++), alphaToInt);
            int ch2 = base64toInt(s.charAt(inCursor++), alphaToInt);
            int ch3 = base64toInt(s.charAt(inCursor++), alphaToInt);
            result[outCursor++] = (byte) ((ch0 << 2) | (ch1 >> 4));
            result[outCursor++] = (byte) ((ch1 << 4) | (ch2 >> 2));
            result[outCursor++] = (byte) ((ch2 << 6) | ch3);
        }

        // Translate partial group, if present
        if (missingBytesInLastGroup != 0) 
        {
            int ch0 = base64toInt(s.charAt(inCursor++), alphaToInt);
            int ch1 = base64toInt(s.charAt(inCursor++), alphaToInt);
            result[outCursor++] = (byte) ((ch0 << 2) | (ch1 >> 4));

            if (missingBytesInLastGroup == 1) 
            {
                int ch2 = base64toInt(s.charAt(inCursor++), alphaToInt);
                result[outCursor++] = (byte) ((ch1 << 4) | (ch2 >> 2));
            }
        }
        // assert inCursor == s.length()-missingBytesInLastGroup;
        // assert outCursor == result.length;
        return result;
    }

    
    public int base64toInt(char c, byte[] alphaToInt)
    {
        int result = alphaToInt[c];
        if (result < 0)
            throw new IllegalArgumentException("Illegal character " + c);
        return result;
    }

    public static void main(String args[]) 
    {
    	StringKeyToByteArray test = new StringKeyToByteArray();
        byte [] b = test.base64ToByteArray("mOxiC6CQ41IxCVvehD81VA==");         
        
        for(int i = 0; i< b.length; i++)
        {
        	System.out.print(b[i] + " ");
        }
        System.out.println("\nDone (in main)");
    }
}

