package cryptomaster.connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JOptionPane;

public class MySqlConnect
{
	Connection connection = null;

	public MySqlConnect()
	{
		String url = "jdbc:mysql://localhost/cryptography";
		Properties properties = new Properties();
		properties.setProperty("user", "root");
		properties.setProperty("password", "root");
		properties.setProperty("useSSL", "false");
		
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, properties);
		} 
		
		catch (SQLException e)
		{
			if(e.getSQLState().equals("42000") && e.getErrorCode() == 1049) // occurs when database is not found
			{
				JOptionPane.showMessageDialog(null, "Database Not found\nPlease contact your Administrator for checking Database settings", "FATAL ERROR", JOptionPane.ERROR_MESSAGE);
			}
			
			else if(e.getSQLState().equals("28000") && e.getErrorCode() == 1045) // occurs when database credentials are illegal.... check properties
			{
				JOptionPane.showMessageDialog(null, "Access Denied\nPlease contact your Administrator for checking Database settings", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			
			else
			{
				JOptionPane.showMessageDialog(null, "Unknown Error occured", "FATAL ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		catch(ClassNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, "Unknown Error occured", "FATAL ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	public String[] verifyUser(String emailid, String password) 
	{
		ResultSet rs = null;
		String userInfo[]= new String[4];
		boolean isVerifyUser = false;
        PreparedStatement prepareStatement=null;
		try 
		{
			if (this.connection != null) 
			{
				String sql = "select * from userinfo where emailid=?";
				prepareStatement = connection.prepareStatement(sql);
				prepareStatement.setString(1, emailid);

				rs = prepareStatement.executeQuery();
				
				if (rs != null) 
				{
					rs.next();
					String pwd = rs.getString("password");
					isVerifyUser=password.equals(pwd);
					if(isVerifyUser)
					{
						userInfo[0] = rs.getString("username");
						userInfo[1] = rs.getString("role");	
						userInfo[2] = rs.getString("userid");
						userInfo[3] = rs.getString("account");
					}
					else
					{
						userInfo[0] = "null";
						userInfo[1] = "null";
						userInfo[2] = "null"; 
						userInfo[3] = "null"; // username is set to null when specified username exists but passwords do not match
					}
				}
					
			}
			prepareStatement.close();
			connection.close();			
		} 
		
		catch (SQLException e) 
		{
			if(e.getSQLState().equals("S1000") && e.getErrorCode() == 0) // occurs when specified username doesnt exist
			{
				userInfo[0] = "null";
				userInfo[1] = "null";
				userInfo[2] = "null";
				userInfo[3] = "null";
			}			
			
		}
		return userInfo;	
	}

	public int registerUser(String username, String emailid, String password) 
	{
	    int state = 2;
        PreparedStatement prepareStatement;
		try 
		{
			
			if (this.connection != null) 
			{
				String sql = "insert into userinfo(username,password,emailid, role, account) values(?,?,?,?,?)";
				prepareStatement = connection.prepareStatement(sql);
				prepareStatement.setString(1, username);
				prepareStatement.setString(2, password);
				prepareStatement.setString(3, emailid);
				prepareStatement.setString(4, "NU");
				prepareStatement.setString(5, "block");
               int rs  = prepareStatement.executeUpdate();
               prepareStatement.close();
               if (rs > 0) 
    		   {   
    			   state = 1;      		
    	       }  
			}
			
			else
			{
				state = 2;
			}
			
            connection.close();
            return state;
		} 
		
		catch (SQLException e)
		{
			if(e.getSQLState().equals("23000") && e.getErrorCode() == 1062 ) // occurs when specified username already exists in the database
			{
				state = 2;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Unknown Error occured while registering the user\nPlease try again and make sure that the user doesnt exist", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			return state;
		}
	}
	
	public String[] emailIdList()
	{
		String[] emailList = new String[1000];	
		String sendList[] = null;
		int i = 0;
		ResultSet rs = null;
        PreparedStatement prepareStatement=null;
        
		try 
		{
			if (this.connection != null) 
			{
				String sql = "select emailid, role from userinfo";
				prepareStatement = connection.prepareStatement(sql);
				
				rs = prepareStatement.executeQuery();
				if (rs != null) 
				{
					while(rs.next())
					{
						String role = rs.getString("role");
						String email = rs.getString("emailid");
						if(!(role.equals("admin")))
						{							
							emailList[i] = email;		
							i++;
						}
					}
					sendList = new String[i];
					for(int j = 0 ; j < i ; j++)
					{
						sendList[j] = emailList[j];
					}
					return sendList;	
				}
			}
		}
		catch (SQLException e)
		{
			sendList = null;
			return sendList;
		}
		return sendList;				
	}
	
	public String[] searchUser(String emailId)
	{
		ResultSet rs = null;
		
		String userInfo[] = new String[4];
		
        PreparedStatement prepareStatement = null;
        
		try 
		{
			if (this.connection != null) 
			{
				String sql = "select username,emailid,password,account from userinfo where emailid=?";
				prepareStatement = connection.prepareStatement(sql);
				prepareStatement.setString(1, emailId);

				rs = prepareStatement.executeQuery();
				if (rs != null) 
				{
					rs.next();
	
					userInfo[0] = rs.getString("username");
					userInfo[1] = rs.getString("emailid");
					userInfo[2] = rs.getString("password");
					userInfo[3] = rs.getString("account");
				}	
			}
			prepareStatement.close();
			connection.close();
			return userInfo;
		} 
		
		catch (SQLException e) 
		{
			if(e.getSQLState().equals("S1000") && e.getErrorCode() == 0) // occurs when specified username doesnt exist
			{
				userInfo[0] = new String("null");
				userInfo[1] = new String("null");
				userInfo[2] = new String("null");
				userInfo[3] = new String("null");
				return userInfo;
			}
		}	
		return userInfo;
	}
	
	public boolean updateUser(String emailId, String password, String username, String userId)
	{
		boolean userUpdated = false;
		PreparedStatement prepareStatement = null;
		
		try
		{
			if (this.connection != null) 
			{
				String sql = "update userinfo set emailid=?, password=?, username=? where userId=?";
				
				prepareStatement = connection.prepareStatement(sql);     
				prepareStatement.setString(1, emailId);
				prepareStatement.setString(2, password);
				prepareStatement.setString(3, username);		
				prepareStatement.setString(4, userId);
			
				int rs  = prepareStatement.executeUpdate();
				
				prepareStatement.close();
				connection.close();
				
	            if (rs > 0) 
	            {            	
	            	userUpdated = true;
	            	return userUpdated;
	            }
				
				return userUpdated;
			}
		}
		catch(SQLException e)
		{			
			userUpdated = false;
			return userUpdated;
		}
		
		
		return userUpdated;
	}
	
	public int accountAccess(String status, String emailId)
	{
		int userUpdated = 3;
		PreparedStatement prepareStatement = null;
		
		try
		{
			if (this.connection != null) 
			{
				String sql = "update userinfo set account=? where emailid=?";
				
				prepareStatement = connection.prepareStatement(sql);     
				prepareStatement.setString(1, status );
				prepareStatement.setString(2, emailId);
			
			
				int rs  = prepareStatement.executeUpdate();
				
				prepareStatement.close();
				connection.close();
				
	            if (rs > 0) 
	            {            	
	            	userUpdated = 1;
	            }
				
				return userUpdated;
			}
		}
		catch(SQLException e)
		{	
			if(e.getSQLState().equals("S1000") && e.getErrorCode() == 0) // occurs when specified username doesnt exist
			{
				userUpdated = 2;
			}
			else
			{
				userUpdated = 3;
			}
			
			return userUpdated;
		}
		
		
		return userUpdated;
	}
	
	public boolean deleteUser(String emailId)
	{
		boolean userDeleted = false;
		
		PreparedStatement prepareStatement = null;
		
		try
		{
			if (this.connection != null) 
			{
				String sql = "delete from userinfo where emailid=?"; 
				
				prepareStatement = connection.prepareStatement(sql);     
				prepareStatement.setString(1, emailId);
				
				int rs  = prepareStatement.executeUpdate();
				
				prepareStatement.close();
				connection.close();
				
	            if (rs > 0) 
	            {
	            	userDeleted = true;
	            	return userDeleted;
	            }
				
				return userDeleted;
			}
		}
		catch(SQLException e)
		{
			userDeleted = false;
			return userDeleted;
		}
		
		return userDeleted;
	}
	
	public String verifyAdmin(String adminEmailId, String adminPassword)
	{
		ResultSet rs = null;
		int adminId = -1;
		String adminIdString="null";
		boolean isVerifyAdmin = false;
        PreparedStatement prepareStatement=null;
		try 
		{
			if (this.connection != null) 
			{
				String sql = "select adminid, password from admininfo where emailid=?";
				prepareStatement = connection.prepareStatement(sql);
				prepareStatement.setString(1, adminEmailId);

				rs = prepareStatement.executeQuery();
				if (rs != null) 
				{
					rs.next();
					String pwd = rs.getString("password");
					isVerifyAdmin=adminPassword.equals(pwd);
					if(isVerifyAdmin)
					{
						adminId = rs.getInt("adminid");	
						Integer adminIdObj = new Integer(adminId);
						adminIdString = new String(adminIdObj.toString());
					}
					else
					{
						adminIdString="null"; // adminIdString is set to null when specified username exists but passwords do not match
					}
				}
					
			}
			prepareStatement.close();
			connection.close();
			return adminIdString;
		} 
		
		catch (SQLException e) 
		{
			if(e.getSQLState().equals("S1000") && e.getErrorCode() == 0) // occurs when specified username doesnt exist
			{
				adminIdString="null";
				
			}	
			return adminIdString;
		}	
	}
	
	public boolean updateUser(String userEmailId, String userPassword, String userId)
	{
		boolean adminUpdated = false;
		PreparedStatement prepareStatement = null;
		
		try
		{
			if (this.connection != null) 
			{
				String sql = "update admininfo set emailid=?, password=? where adminid=?";
				
				prepareStatement = connection.prepareStatement(sql);     
				prepareStatement.setString(1, userEmailId);
				prepareStatement.setString(2, userPassword);
				prepareStatement.setString(3, userId);						
			
				int rs  = prepareStatement.executeUpdate();
				
				prepareStatement.close();
				connection.close();
				
	            if (rs > 0) 
	            {            	
	            	adminUpdated = true;
	            	return adminUpdated;
	            }
				
				return adminUpdated;
			}
		}
		catch(SQLException e)
		{			
			System.out.println("Exception Caught: " + e.getErrorCode() + "  " + e.getMessage());
			adminUpdated = false;
			return adminUpdated;
		}	
		
		return adminUpdated;
	}

}
