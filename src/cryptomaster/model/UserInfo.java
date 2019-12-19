package cryptomaster.model;

public class UserInfo
{
	private String userName;
	private String emailId;
	private String password;
	private String receiverEmailId;
	

	public String getUsername() 
	{
		return userName;
	}
	
	public void setUsername(String userName) 
	{
		this.userName = userName;
	}
	
	public String getEmailid() 
	{
		return emailId;
	}

	public void setEmailid(String emailId) 
	{
		this.emailId = emailId;
	}
	
	public String getReciverEmailId()
	{
		return receiverEmailId;
	}
	
	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setReciverEmailId(String reciverEmailId) 
	{
		this.receiverEmailId = reciverEmailId;
	}
	
	
}
