package cryptomaster.registration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import cryptomaster.connectivity.MySqlConnect;
import cryptomaster.home.HomePage;
import cryptomaster.login.Login;

public class Registeration extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;

	private javax.swing.JButton back;
    private javax.swing.JPasswordField confirmPasswordField;
    private javax.swing.JLabel confirmPasswordlLabel;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTextfield;
    private javax.swing.JPanel headPanel;
    private javax.swing.JSeparator jSeparator;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordlLabel;
    private javax.swing.JLabel registerIconLabel;
    private javax.swing.JPanel subPanel;
    private javax.swing.JButton submit;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameTextfield;

	public Registeration()
	{
		setVisible(true);
		setLocation(300,100);
        setSize(750, 500); 
		setTitle("Registeration Form");
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
        submit = new javax.swing.JButton();
        registerIconLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        usernameTextfield = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        emailTextfield = new javax.swing.JTextField();
        passwordlLabel = new javax.swing.JLabel();
        confirmPasswordlLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        confirmPasswordField = new javax.swing.JPasswordField();
        back = new javax.swing.JButton();
        
        headPanel.setBackground(new java.awt.Color(153,180,209));

        titleLabel.setFont(new java.awt.Font("Footlight MT Light", 1, 40)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(153, 0, 0));
        titleLabel.setText("REGISTERATION FORM");
        
        jSeparator.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));

        subPanel.setBackground(new java.awt.Color(240,240,240));
        
        submit.setFont(new java.awt.Font("Gisha", 1, 18)); // NOI18N
        submit.setText("Submit");
        submit.addActionListener(this);
        
        registerIconLabel.setIcon(new javax.swing.ImageIcon("project images\\My store\\user reg\\ureg edit.png")); // NOI18N
        registerIconLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 51, 51), new java.awt.Color(102, 102, 102), new java.awt.Color(0, 0, 0), new java.awt.Color(102, 102, 102)));

        usernameLabel.setFont(new java.awt.Font("Footlight MT Light", 0, 26)); // NOI18N
        usernameLabel.setText("Enter Name :");

        usernameTextfield.setText("");

        emailLabel.setFont(new java.awt.Font("Footlight MT Light", 0, 26)); // NOI18N
        emailLabel.setText("Enter Email id :");

        emailTextfield.setText("");

        passwordlLabel.setFont(new java.awt.Font("Footlight MT Light", 0, 26)); // NOI18N
        passwordlLabel.setText("Enter Password :");

        confirmPasswordlLabel.setFont(new java.awt.Font("Footlight MT Light", 0, 26)); // NOI18N
        confirmPasswordlLabel.setText("Confirm Password :");

        back.setFont(new java.awt.Font("Gisha", 1, 18)); // NOI18N
        back.setText("Back");
        back.addActionListener(this);
        
        javax.swing.GroupLayout headPanelLayout = new javax.swing.GroupLayout(headPanel);
        headPanel.setLayout(headPanelLayout);
        headPanelLayout.setHorizontalGroup(
            headPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headPanelLayout.createSequentialGroup()
                .addGap(163, 163, 163)
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
                .addGap(161, 161, 161)
                .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(subPanelLayout.createSequentialGroup()
                        .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(emailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addComponent(usernameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(34, 34, 34)
                        .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailTextfield, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(usernameTextfield))
                        .addGap(158, 158, 158))
                    .addGroup(subPanelLayout.createSequentialGroup()
                        .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(passwordlLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(confirmPasswordlLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(subPanelLayout.createSequentialGroup()
                                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)))
                        .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(subPanelLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(confirmPasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                    .addComponent(passwordField)))
                            .addGroup(subPanelLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(subPanelLayout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(registerIconLabel)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        subPanelLayout.setVerticalGroup(
            subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(registerIconLabel)
                .addGap(36, 36, 36)
                .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordlLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordField))
                .addGap(15, 15, 15)
                .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmPasswordlLabel)
                    .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
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
    	
    	 if (usernameTextfield.getText().length() == 0) 
         {
    		 validForm = false;
             JOptionPane.showMessageDialog(this, "Please Enter User Name!", "Enter User Name", JOptionPane.ERROR_MESSAGE);
             return validForm;
         } 
    	 
    	 if(emailTextfield.getText().length() == 0)
    	 {
    		 validForm = false;
             JOptionPane.showMessageDialog(this, "Please Enter your Email address!", "Enter Email-ID", JOptionPane.ERROR_MESSAGE);
             return validForm;
    	 }

         if (passwordField.getPassword().length == 0) 
         {
        	 validForm = false;
             JOptionPane.showMessageDialog(this, "Please Enter Password!", "Enter Password", JOptionPane.ERROR_MESSAGE);
             return validForm;
         } 
         
         if (passwordField.getPassword().length < 8) 
         {
        	 validForm = false;
             JOptionPane.showMessageDialog(this, "Minimum Password Length is 8 characters", "Enter a complex Password", JOptionPane.ERROR_MESSAGE);
             return validForm;
         } 
         
         if (confirmPasswordField.getPassword().length == 0) 
         {
        	 validForm = false;
             JOptionPane.showMessageDialog(this, "Please Confirm Password!", "Confirm Password", JOptionPane.ERROR_MESSAGE);
             return validForm;
         } 
         
         if(!new String(confirmPasswordField.getPassword()).equals(new String(passwordField.getPassword())))
         {
        	 validForm = false;
        	 JOptionPane.showMessageDialog(this, "Please Enter password again", "Passwords do not match!!!", JOptionPane.ERROR_MESSAGE);
        	 return validForm;
         }
         return validForm;
    }
	
	public void actionPerformed(ActionEvent ae)
	{
	    if(ae.getSource() == submit)
	    {
	    	boolean validForm = true;
	    	
	    	validForm = formValidate();
	    	
	    	if(validForm)
	    	{
	    		String username, emailid, password;
	    		MySqlConnect connect;
	    		
	    		username = usernameTextfield.getText();
	         	emailid = emailTextfield.getText();
	            password = new String(passwordField.getPassword());
	            
	            connect = new MySqlConnect();
				int registered = connect.registerUser(username, emailid, password);  
				
				if(registered == 1)
				{
					JOptionPane.showMessageDialog(this, "User Successfully Registered!!!", "Success", JOptionPane.INFORMATION_MESSAGE);
					Login goToLogin = new Login();
					goToLogin.setVisible(true);
					dispose();
				}
				else if(registered == 2)
				{
					JOptionPane.showMessageDialog(this, "User already exists", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(this, "User cannot be registered\nPlease try again", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
	    	}
	    	
	    }  
	    
	    if(ae.getSource() == back)
	    {
	    	HomePage goToHome = new HomePage();
	    	goToHome.setVisible(true);
	    	
	    	dispose();
	    }
	}
	
	public static void main(String[] args)
	{
		Registeration regTest = new Registeration();
		regTest.setVisible(true);
    }
}