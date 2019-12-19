package cryptomaster.model;

public class FileInfo 
{
	private String userAction;
	private String encryptedFileFor;
	private String encryptedFileKey;
	private String inputFileType;
	private String inputFilePath;
	private String encryptedFilePath;
	private String encryptedFileName;
	private String decryptedFilePath;
	private boolean performDestagonagraphy;
	
	public String getUserAction() 
	{
		return userAction;
	}
	
	public void setUserAction(String userAction)
	{
		this.userAction = userAction;
	}
	
	public String getEncryptedFileFor() 
	{
		return encryptedFileFor;
	}
	
	public void setEncryptedFileFor(String encryptedFileFor) 
	{
		this.encryptedFileFor = encryptedFileFor;
	}
	
	public String getEncryptedFileKey()
	{
		return encryptedFileKey;
	}
	
	public void setEncryptedFileKey(String encryptedFileKey) 
	{
		this.encryptedFileKey = encryptedFileKey;
	}
	
	public String getInputFileType() 
	{
		return inputFileType;
	}
	
	public void setInputFileType(String inputFileType)
	{
		this.inputFileType = inputFileType;
	}
	
	public String getInputFilePath() 
	{
		return inputFilePath;
	}
	
	public void setInputFilePath(String inputFilePath) 
	{
		this.inputFilePath = inputFilePath;
	}

	public String getEncryptedFilePath() 
	{
		return encryptedFilePath;
	}

	public void setEncryptedFilePath(String encryptedFilePath) 
	{
		this.encryptedFilePath = encryptedFilePath;
	}

	public String getEncryptedFileName() 
	{
		return encryptedFileName;
	}

	public void setEncryptedFileName(String encryptedFileName) 
	{
		this.encryptedFileName = encryptedFileName;
	}

	public String getDecryptedFilePath() 
	{
		return decryptedFilePath;
	}
	
	public void setDecryptedFilePath(String decryptedFilePath) 
	{
		this.decryptedFilePath = decryptedFilePath;	
	}
	
	public boolean isPerformDestagonagraphy() 
	{
		return performDestagonagraphy;
	}

	public void setPerformDestagonagraphy(boolean performDestagonagraphy) 
	{
		this.performDestagonagraphy = performDestagonagraphy;
	}
}
