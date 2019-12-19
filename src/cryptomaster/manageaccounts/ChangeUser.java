package cryptomaster.manageaccounts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import cryptomaster.connectivity.MySqlConnect;
import cryptomaster.home.HomePage;
import cryptomaster.model.UserInfo;

public class ChangeUser extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private javax.swing.JPanel headPanel;
	private javax.swing.JLabel titleLabel;
	private javax.swing.JLabel helloLabel;
	private javax.swing.JButton logout;
	
	private javax.swing.JSeparator jSeparator;
	
	private javax.swing.JPanel subPanel;
    private javax.swing.JLabel adminLabel;
    private javax.swing.JLabel oldEmailIdLabel;
    private javax.swing.JTextField oldEmailIdTextfield;
    private javax.swing.JLabel oldPasswordLabel;
    private javax.swing.JPasswordField oldPasswordfield;
    private javax.swing.JButton check;
    private javax.swing.JLabel newUsernameLabel;
    private javax.swing.JTextField newUsernameTextfield;
    private javax.swing.JLabel newEmailIdLabel;
    private javax.swing.JTextField newEmailIdTextfield;
    private javax.swing.JLabel newPasswordLabel;
    private javax.swing.JPasswordField newPasswordfield;
    private javax.swing.JLabel confirmPasswordLabel;
    private javax.swing.JPasswordField confirmPasswordfield;
    private javax.swing.JButton change;
    
    UserInfo userInfoObj = new UserInfo();;
    
    String emailId;
    String password;
    String username;
    
    String userId;
    
    public ChangeUser(UserInfo userInfo)
    {
    	setTitle("Change Account Setting");
    	setLocation(300,100);
    	setSize(750,540);
    	setResizable(true);
    	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	getContentPane().setBackground(new java.awt.Color(153,180,209)); // set background color for Frame
        
    	userInfoObj = userInfo;
    	String name = new String(userInfoObj.getUsername());
    	String email = new String(userInfoObj.getEmailid());
    	
    	 try 
         {
              for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) 
              {
                  if ("Nimbus".equals(info.getName())) 
                  {
                      UIManager.setLookAndFeel(info.getClassName());
                      break;
                  }
              }
          } 
         
         catch (ClassNotFoundException ex)
         {
             
         }
         
         catch (InstantiationException ex) 
         {
             
         } 
         
         catch (IllegalAccessException ex) 
         {
             
         }
         
         catch (UnsupportedLookAndFeelException ex) 
         {
            
         }

         headPanel = new javax.swing.JPanel();
         headPanel.setBackground(new java.awt.Color(153,180,209));
         headPanel.setMaximumSize(new java.awt.Dimension(750, 120));
         headPanel.setMinimumSize(new java.awt.Dimension(750, 120));
         headPanel.setPreferredSize(new java.awt.Dimension(750, 120));
         
         titleLabel = new javax.swing.JLabel();
         titleLabel.setFont(new java.awt.Font("Footlight MT Light", 1, 40)); // NOI18N
         titleLabel.setText("    Account Settings");
         titleLabel.setForeground(new java.awt.Color(153,0,0));
         
         logout = new JButton();
         logout.setFont(new java.awt.Font("Gisha", 1, 14));
         logout.setText("Logout");
         logout.setForeground(java.awt.Color.blue);
         logout.setToolTipText("Logs out the current  User");
         logout.addActionListener(this);
         
         helloLabel = new javax.swing.JLabel();
         helloLabel.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
         helloLabel.setText("Hello " + name);
         
         jSeparator = new javax.swing.JSeparator();
         jSeparator.setForeground(java.awt.Color.white);
         jSeparator.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
         
         subPanel = new javax.swing.JPanel();
         subPanel.setBackground(new java.awt.Color(240,240,240));
         subPanel.setForeground(java.awt.Color.blue);
         
         adminLabel = new javax.swing.JLabel();
         adminLabel.setIcon(new javax.swing.ImageIcon("project images\\My store\\change user\\Admin.jpg")); // NOI18N
      
         oldEmailIdLabel = new javax.swing.JLabel();
         oldEmailIdLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
         oldEmailIdLabel.setForeground(java.awt.Color.blue);
         oldEmailIdLabel.setText("Enter old Email-Id");

         oldEmailIdTextfield = new javax.swing.JTextField();
         oldEmailIdTextfield.setText(email);
         oldEmailIdTextfield.setEditable(false);
         
         oldPasswordLabel = new javax.swing.JLabel();
         oldPasswordLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
         oldPasswordLabel.setForeground(java.awt.Color.blue);
         oldPasswordLabel.setText("Enter old password");
                        
         oldPasswordfield = new javax.swing.JPasswordField();     
               
         check = new javax.swing.JButton();
         check.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
         check.setForeground(java.awt.Color.blue);
         check.setText("Check");
         check.addActionListener(this);
        
         newUsernameLabel = new javax.swing.JLabel();
         newUsernameLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
         newUsernameLabel.setForeground(java.awt.Color.blue);
         newUsernameLabel.setText("Enter new Username");
         
         newUsernameTextfield = new javax.swing.JTextField();
         newUsernameTextfield.setText(name);
         
         newEmailIdLabel = new javax.swing.JLabel();
         newEmailIdLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
         newEmailIdLabel.setForeground(java.awt.Color.blue);
         newEmailIdLabel.setText("Enter new Email-Id");
         
         newEmailIdTextfield = new javax.swing.JTextField();
         newEmailIdTextfield.setText(email);
         
         newPasswordLabel = new javax.swing.JLabel();
         newPasswordLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
         newPasswordLabel.setForeground(java.awt.Color.blue);
         newPasswordLabel.setText("Enter new password");         
         
         newPasswordfield = new javax.swing.JPasswordField();
         
         confirmPasswordLabel = new javax.swing.JLabel();
         confirmPasswordLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
         confirmPasswordLabel.setForeground(java.awt.Color.blue);
         confirmPasswordLabel.setText("Confirm Password");
         
         confirmPasswordfield = new javax.swing.JPasswordField();
         
         change = new javax.swing.JButton();
         change.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
         change.setForeground(java.awt.Color.blue);
         change.setText("Change");
         change.addActionListener(this);
         
         newUsernameTextfield.setEnabled(false);
         newEmailIdTextfield.setEnabled(false);
         newPasswordfield.setEnabled(false);
		 confirmPasswordfield.setEnabled(false);
		 change.setEnabled(false);
         
         javax.swing.GroupLayout headPanelLayout = new javax.swing.GroupLayout(headPanel);
         headPanel.setLayout(headPanelLayout);
         headPanelLayout.setHorizontalGroup(
             headPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(headPanelLayout.createSequentialGroup()
                 .addGap(169, 169, 169)
                 .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addContainerGap(168, Short.MAX_VALUE))
             .addGroup(headPanelLayout.createSequentialGroup()
                 .addGap(25, 25, 25)
                 .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                 .addComponent(helloLabel)
                 .addGap(25, 25, 25))
         );
         headPanelLayout.setVerticalGroup(
             headPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(headPanelLayout.createSequentialGroup()
                 .addGap(40, 40, 40)
                 .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addGap(0, 0, 0)
                 .addGroup(headPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(helloLabel))
                 .addGap(20, 20, 20))
         );
         
         javax.swing.GroupLayout subPanelLayout = new javax.swing.GroupLayout(subPanel);
         subPanel.setLayout(subPanelLayout);
         subPanelLayout.setHorizontalGroup(
             subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(subPanelLayout.createSequentialGroup()
                 .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(subPanelLayout.createSequentialGroup()
                         .addGap(195, 195, 195)
                         .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                             .addComponent(oldPasswordLabel)
                             .addComponent(oldEmailIdLabel)
                             .addComponent(newPasswordLabel)
                             .addComponent(newEmailIdLabel)
                             .addComponent(confirmPasswordLabel)
                             .addComponent(newUsernameLabel))
                         .addGap(83, 83, 83)
                         .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                             .addComponent(newPasswordfield, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                             .addComponent(newEmailIdTextfield, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                             .addComponent(confirmPasswordfield, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                             .addComponent(oldEmailIdTextfield, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                             .addComponent(oldPasswordfield, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                             .addComponent(newUsernameTextfield)))
                     .addGroup(subPanelLayout.createSequentialGroup()
                         .addGap(335, 335, 335)
                         .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                             .addComponent(check, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                             .addComponent(adminLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                             .addComponent(change, javax.swing.GroupLayout.Alignment.TRAILING))))
                 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
         );
         subPanelLayout.setVerticalGroup(
             subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(subPanelLayout.createSequentialGroup()
                 .addContainerGap()
                 .addComponent(adminLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                 .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(oldEmailIdLabel)
                     .addComponent(oldEmailIdTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                 .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(oldPasswordLabel)
                     .addComponent(oldPasswordfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                 .addComponent(check)
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                 .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(newUsernameLabel)
                     .addComponent(newUsernameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                 .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(subPanelLayout.createSequentialGroup()
                         .addComponent(newEmailIdLabel)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                         .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                             .addComponent(newPasswordLabel)
                             .addComponent(newPasswordfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                         .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                             .addComponent(confirmPasswordLabel)
                             .addComponent(confirmPasswordfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                         .addComponent(change))
                     .addComponent(newEmailIdTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addContainerGap())
         );
         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
         getContentPane().setLayout(layout);
         layout.setHorizontalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(layout.createSequentialGroup()
                 .addComponent(headPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addGap(0, 0, Short.MAX_VALUE))
             .addComponent(jSeparator)
             .addComponent(subPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         );
         layout.setVerticalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(layout.createSequentialGroup()
                 .addComponent(headPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addGap(0, 0, 0)
                 .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addGap(0, 0, 0)
                 .addComponent(subPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
         );

         pack();

    }
    
    public boolean oldCredentialsFormValidate()
    {
    	boolean validForm = true;
    	
   	 	if (oldEmailIdTextfield.getText().length() == 0) 
        {
   		 validForm = false;
            JOptionPane.showMessageDialog(this, "Please Enter Email id!", "Enter email id", JOptionPane.ERROR_MESSAGE);
            return validForm;
        }   

        if (oldPasswordfield.getPassword().length == 0) 
        {
       	 validForm = false;
            JOptionPane.showMessageDialog(this, "Please Enter Password!", "Enter Password", JOptionPane.ERROR_MESSAGE);
            return validForm;
        } 
      
        return validForm;
    }
    
    public boolean newCredentialsFormValidate()
    {
    	boolean validForm = true;
    	
    	if(newUsernameTextfield.getText().length() == 0)
    	{
    		validForm = false;
            JOptionPane.showMessageDialog(this, "Please Enter Username", "Enter Username", JOptionPane.ERROR_MESSAGE);
            return validForm;
    	}
   	 	if (newEmailIdTextfield.getText().length() == 0) 
        {
   	 		validForm = false;
            JOptionPane.showMessageDialog(this, "Please Enter Email id!", "Enter email id", JOptionPane.ERROR_MESSAGE);
            return validForm;
        }   

        if (newPasswordfield.getPassword().length == 0) 
        {
       	 	validForm = false;
            JOptionPane.showMessageDialog(this, "Please Enter Password!", "Enter Password", JOptionPane.ERROR_MESSAGE);
            return validForm;
        } 
      
        if (confirmPasswordfield.getPassword().length == 0) 
        {
       	 	validForm = false;
            JOptionPane.showMessageDialog(this, "Please Enter Password!", "Enter Password", JOptionPane.ERROR_MESSAGE);
            return validForm;
        } 
        if (confirmPasswordfield.getPassword().length <= 8) 
        {
       	 	validForm = false;
            JOptionPane.showMessageDialog(this, "Please choose a Complex Password!", "Enter Password", JOptionPane.ERROR_MESSAGE);
            return validForm;
        } 
        
        if(!new String(confirmPasswordfield.getPassword()).equals(new String(newPasswordfield.getPassword())))
        {
        	validForm = false;
       	 	JOptionPane.showMessageDialog(this, "Please Enter password again", "Passwords do not match!!!", JOptionPane.ERROR_MESSAGE);
       	 	return validForm;
        }
        	return validForm;
    }
    
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource() == logout)
		{
			HomePage goToHome = new HomePage();
			goToHome.setVisible(true);
			
			dispose();
		}
		
		if(ae.getSource() == check)
		{
			boolean validForm = this.oldCredentialsFormValidate();
			
			if(validForm)
			{
				emailId = oldEmailIdTextfield.getText();
				password = new String(oldPasswordfield.getPassword());
				MySqlConnect verifyUser = new MySqlConnect();
				String userInfo[] = new String[3];
				userInfo = verifyUser.verifyUser(emailId, password);
				userId = userInfo[2];
				if(!userId.equals("null"))
				{
					JOptionPane.showMessageDialog(this, "You can now change the Account Credentials", "Success", JOptionPane.INFORMATION_MESSAGE);
					newUsernameTextfield.setEnabled(true);
					newEmailIdTextfield.setEnabled(true);
					newPasswordfield.setEnabled(true);
					confirmPasswordfield.setEnabled(true);
					change.setEnabled(true);
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Bad Email id or Password !!!!!!!", "Error", JOptionPane.ERROR_MESSAGE);
					newUsernameTextfield.setEnabled(false);
			        newEmailIdTextfield.setEnabled(false);
			        newPasswordfield.setEnabled(false);
				    confirmPasswordfield.setEnabled(false);
					change.setEnabled(false);
				}
			}
		}
		
		if(ae.getSource() == change)
		{
			boolean validForm = this.newCredentialsFormValidate();
			
			if(validForm)
			{
				emailId = new String(newEmailIdTextfield.getText());
				password = new String(newPasswordfield.getPassword());
				username = new String(newUsernameTextfield.getText());
				
				System.out.println(userId);
				MySqlConnect changeUser = new MySqlConnect();
				boolean  userUpdated = changeUser.updateUser(emailId, password, username, userId);
				
				if(userUpdated)
				{
					JOptionPane.showMessageDialog(this, "Account Information Updated Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
				}				
				else
				{
					JOptionPane.showMessageDialog(this, "Account Information was not Updated", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
	
	public static void main(String args[])
	{
		UserInfo testUser = new UserInfo();
		testUser.setEmailid("mohitssj10@gmail.com");
		testUser.setUsername("Mohit");
		ChangeUser test = new ChangeUser(testUser);
		test.setVisible(true);
	}
}
