package cryptomaster.login;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import cryptomaster.connectivity.MySqlConnect;
import cryptomaster.email.EmailUserCredentials;
import cryptomaster.encryptdecryptutility.EncryptDecryptUtility;
import cryptomaster.home.HomePage;
import cryptomaster.manageaccounts.ManageAccounts;
import cryptomaster.model.UserInfo;

public class Login extends JFrame implements ActionListener 
{

    private static final long serialVersionUID = 1L;

    private javax.swing.JPanel headPanel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JSeparator jSeparator;
    private javax.swing.JPanel subPanel;
    private javax.swing.JLabel usericonLabel;
    private javax.swing.JLabel emailIdlLabel;    
    private javax.swing.JTextField emailidTextfield;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JButton back;
    private javax.swing.JButton login;   
    private javax.swing.JButton forgot;
    
    WaitingDialog wait;
	
    public Login()
    {
    	setTitle("Log In");
    	setLocation(300,100);
        setSize(750, 500);  
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
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
        titleLabel = new javax.swing.JLabel();
        jSeparator = new javax.swing.JSeparator();
        subPanel = new javax.swing.JPanel();
        login = new javax.swing.JButton();
        back = new javax.swing.JButton();
        emailIdlLabel = new javax.swing.JLabel();
        emailidTextfield = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        passwordLabel = new javax.swing.JLabel();
        usericonLabel = new javax.swing.JLabel();
        forgot = new javax.swing.JButton();
        
        headPanel.setBackground(new java.awt.Color(153,180,209));

        titleLabel.setFont(new java.awt.Font("Footlight MT Light", 1, 40)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(153,0,0));
        titleLabel.setText("LOGIN FORM");
        
        jSeparator.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));

        subPanel.setBackground(new java.awt.Color(240,240,240));

        login.setFont(new java.awt.Font("Gisha", 1, 18)); // NOI18N
        login.setText("Login");
        login.addActionListener(this);
        
        emailIdlLabel.setFont(new java.awt.Font("Footlight MT Light", 0, 30)); // NOI18N
        emailIdlLabel.setText("Email Id :");
        
        passwordLabel.setFont(new java.awt.Font("Footlight MT Light", 0, 30)); // NOI18N
        passwordLabel.setText("Password :");

        usericonLabel.setIcon(new javax.swing.ImageIcon("project images\\My store\\user login\\user login edit.png")); // NOI18N
        usericonLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102), new java.awt.Color(153, 153, 153)));

        back.setFont(new java.awt.Font("Gisha", 1, 18)); // NOI18N
        back.setText("Back");
        back.addActionListener(this);
        
        forgot.setFont(new java.awt.Font("Gisha", 1, 18)); // NOI18N
        forgot.setText("Forgot Password");
        forgot.addActionListener(this);
        
        javax.swing.GroupLayout headPanelLayout = new javax.swing.GroupLayout(headPanel);
        headPanel.setLayout(headPanelLayout);
        headPanelLayout.setHorizontalGroup(
            headPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headPanelLayout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(titleLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        headPanelLayout.setVerticalGroup(
            headPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(titleLabel)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        
        javax.swing.GroupLayout subPanelLayout = new javax.swing.GroupLayout(subPanel);
        subPanel.setLayout(subPanelLayout);
        subPanelLayout.setHorizontalGroup(
            subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subPanelLayout.createSequentialGroup()
                .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(subPanelLayout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addComponent(usericonLabel))
                    .addGroup(subPanelLayout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(forgot))
                    .addGroup(subPanelLayout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(emailIdlLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordLabel))
                        .addGap(50, 50, 50)
                        .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailidTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        subPanelLayout.setVerticalGroup(
            subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(usericonLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emailIdlLabel)
                    .addComponent(emailidTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordLabel)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(forgot, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator)
            .addComponent(subPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private boolean formValidate()
    {
    	boolean validForm = true;
    	
    	 if (emailidTextfield.getText().length() == 0) 
         {
    		 validForm = false;
             JOptionPane.showMessageDialog(this, "Please Enter Email id!", "Enter email id", JOptionPane.ERROR_MESSAGE);
             return validForm;
         }   

         if (passwordField.getPassword().length == 0) 
         {
        	 validForm = false;
             JOptionPane.showMessageDialog(this, "Please Enter Password!", "Enter Password", JOptionPane.ERROR_MESSAGE);
             return validForm;
         } 
       
         return validForm;
    }
    
    public void actionPerformed(ActionEvent ae) 
    {
    	if (ae.getSource() == login) 
        {
    		boolean validForm = true;
    
            validForm = formValidate();
            
    		if(validForm)
    		{
    			String emailid = new String(emailidTextfield.getText());
                String password = new String(passwordField.getPassword());
                
                MySqlConnect connect;
                String userinfo[] = new String[4];
               
                connect = new MySqlConnect();        
                userinfo = connect.verifyUser(emailid, password);
               
                String username = userinfo[0];
				String role = userinfo[1];               
				String userId = userinfo[2];
				String accountStatus = userinfo[3];
				
				 if(!username.equals("null") && !role.equals("null") && !userId.equals("null") && !accountStatus.equals("null"))
				 {
					 UserInfo userInfoObj = new UserInfo();
					 userInfoObj.setUsername(username);
					 userInfoObj.setEmailid(emailid);
					 userInfoObj.setPassword(password);
					 
					 if(role.equals("admin"))
					 {
						 SelectAction actionToPerform = new SelectAction(this);						 
						 boolean action = actionToPerform.performAction();						 						 
						 
						 actionToPerform.dispose();
						 
						 if(action)
						 {
							 ManageAccounts manageAccounts = new ManageAccounts(userInfoObj);
							 manageAccounts.setVisible(true);
							 dispose();
						 }
						 else
						 {
							 EncryptDecryptUtility selectFileType = new EncryptDecryptUtility(userInfoObj);
							 selectFileType.setVisible(true);
							 dispose();
						 }
					 }
					 else
					 {
						 if(!accountStatus.equals("block"))
						 {
							 EncryptDecryptUtility selectFileType = new EncryptDecryptUtility(userInfoObj);
							 selectFileType.setVisible(true);
							 dispose();
						 }
						 else
						 {
							 JOptionPane.showMessageDialog(this, "Your Account has been blocked\nPlease Contact your Administrator", "Error", JOptionPane.ERROR_MESSAGE);
						 }
					 }
					 
				 }
				 else
				 {
					 JOptionPane.showMessageDialog(this, "Bad Email id or Password !!!!!!!", "Error", JOptionPane.ERROR_MESSAGE);
				 }
            }
    		
        }
    	
    	if (ae.getSource() == back)
    	{
    		HomePage goToHome = new HomePage();
    		goToHome.setVisible(true);
    		
    		dispose();
    	}
    	
    	if (ae.getSource() == forgot)
    	{
    		String emailId = new String(emailidTextfield.getText());
    		if(!(emailidTextfield.getText().length() == 0))
    		{
    			MySqlConnect searchUser = new MySqlConnect();
    			String userInfo[] = searchUser.searchUser(emailId);
    			
    			if(!userInfo[0].equals("null") && !userInfo[1].equals("null") && !userInfo[2].equals("null") && !userInfo[3].equals("null"))
    			{
    				boolean mailSent = false;
    				EmailUserCredentials test = new EmailUserCredentials();
    				wait = new WaitingDialog(this,1);
					wait.setVisible(true);
    				mailSent = test.mailUserCredentials(userInfo);
    				if(mailSent)
    				{
    					wait.dispose();
    					JOptionPane.showMessageDialog(this, "User credentials have been mailed", "Success", JOptionPane.INFORMATION_MESSAGE);
    				}
    				else
    				{
    					wait.dispose();
    					JOptionPane.showMessageDialog(this, "Cannot send E-mail Please Check Internet Connection and Recipient's Email ID", "Email not Sent!!!", JOptionPane.ERROR_MESSAGE);
    				}
    			}
    			else
    			{
    				wait.dispose();
    				JOptionPane.showMessageDialog(this, "Bad Email Id !!!!!!!", "Error", JOptionPane.ERROR_MESSAGE);
    			}
    		}
    		
    		else
    		{
    			 JOptionPane.showMessageDialog(this, "Please Enter Email id!", "Enter email id", JOptionPane.ERROR_MESSAGE);
    		}
    	}
    }

    public static void main(String args[]) 
    {
        Login loginTest = new Login();
        loginTest.setVisible(true);
    }
}

class SelectAction extends JDialog implements ActionListener
{
	private static final long serialVersionUID = 1L;
	JLabel actionLabel;
	JButton yes;
	JButton no; 
	FlowLayout flowLayout;
	
	boolean action;
	
	public SelectAction(JFrame parent)
	{
		super(parent,true);
		setLocation(462,320);
		setSize(400,100);		
		setResizable(false);
		setTitle("Administrator Login Detected");
		
		flowLayout = new FlowLayout();
		setLayout(flowLayout);

		actionLabel = new JLabel("\t\t\tDo you want to Manage User Accounts?\t\t\t");
		actionLabel.setFont(new Font("Papyrus", 3, 18)); 
		actionLabel.setForeground(Color.blue);
		yes = new JButton("Yes");
		no = new JButton("No, go to Encryption");
		
		add(actionLabel);
		add(yes);
		add(no);
		
		yes.addActionListener(this);
		no.addActionListener(this);	
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == yes)
		{
			action = true;
			dispose();
		}
		
		if(ae.getSource() == no)
		{
			action = false;
			dispose();
		}
	}
	
	public boolean performAction()
	{
		return action;
	}
	 
}

class WaitingDialog extends Dialog 
{
	private static final long serialVersionUID = 1L;
	Label wait;
	FlowLayout flow;
	
	public WaitingDialog(JFrame parent, int type)
	{	
		super(parent,false);
		setLocation(462,350);
		setSize(500,80);
		setResizable(false);
		setBackground(new java.awt.Color(153,180,209));
		setTitle("Please Wait");
		
		flow = new FlowLayout();
		setLayout(flow);
		
		wait = new Label();
		wait.setFont(new java.awt.Font("Footlight MT Light", 0, 15));
		wait.setText("Please wait as the E-mail is being sent");		
		
		
		add(wait);
		setVisible(true);
	}
}