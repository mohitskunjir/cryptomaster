package cryptomaster.encryption;


class SecretKeyToString 
{ 
	public final char intToBase64[] = 
	{
	        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
	        'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
	        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
	        'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
	        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'
	};
	
    public String byteArrayToBase64(byte[] a) 
    {
        int aLen = a.length;
        int numFullGroups = aLen/3;
        int numBytesInPartialGroup = aLen - 3*numFullGroups;
        int resultLen = 4*((aLen + 2)/3);
        StringBuffer result = new StringBuffer(resultLen);
        char[] intToAlpha = intToBase64;

        // Translate all full groups from byte array elements to Base64
        int inCursor = 0;
        for (int i=0; i<numFullGroups; i++) 
        {
            int byte0 = a[inCursor++] & 0xff;
            int byte1 = a[inCursor++] & 0xff;
            int byte2 = a[inCursor++] & 0xff;
            result.append(intToAlpha[byte0 >> 2]);
            result.append(intToAlpha[(byte0 << 4)&0x3f | (byte1 >> 4)]);
            result.append(intToAlpha[(byte1 << 2)&0x3f | (byte2 >> 6)]);
            result.append(intToAlpha[byte2 & 0x3f]);
        }

        // Translate partial group if present
        if (numBytesInPartialGroup != 0) 
        {
            int byte0 = a[inCursor++] & 0xff;
            result.append(intToAlpha[byte0 >> 2]);
            if (numBytesInPartialGroup == 1) 
            {
                result.append(intToAlpha[(byte0 << 4) & 0x3f]);
                result.append("==");
            } 
            else 
            {
                // assert numBytesInPartialGroup == 2;
                int byte1 = a[inCursor++] & 0xff;
                result.append(intToAlpha[(byte0 << 4)&0x3f | (byte1 >> 4)]);
                result.append(intToAlpha[(byte1 << 2)&0x3f]);
                result.append('=');
            }
        }
        return result.toString();
    }

    public static void main(String args[]) 
    {
    	SecretKeyToString test = new SecretKeyToString();
    	byte[] ba = { 1,2,3,4};
        String b = test.byteArrayToBase64(ba);         
        System.out.println( b +"\nDone (in main)");
    }
}
