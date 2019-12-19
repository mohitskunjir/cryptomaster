package cryptomaster.manageaccounts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import cryptomaster.connectivity.MySqlConnect;
import cryptomaster.home.HomePage;
import cryptomaster.model.UserInfo;

public class ManageAccounts  extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private javax.swing.JPanel headPanel;
	private javax.swing.JLabel headLabel;
	private javax.swing.JButton logout;
	private javax.swing.JLabel helloLabel;
	private javax.swing.JSeparator jSeparator;
	private javax.swing.JPanel subPanel;
	private javax.swing.JLabel manageLabel;
	private javax.swing.JLabel emailIdLabel;
    private javax.swing.JComboBox<String> emailIdCombo;	
    private javax.swing.JButton search;
	private javax.swing.JLabel accountStatusLabel;
    private javax.swing.JRadioButton block; 
    private javax.swing.JRadioButton unblock;
    private javax.swing.JButton delete;

    UserInfo userInfoObj;
    String[] userInfo = new String[4];
	
    public ManageAccounts(UserInfo userInfo)
    {
    	setTitle("Manage Accounts");
    	setLocation(300,100);
        setSize(750,500);
        setTitle("Manage Users");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        userInfoObj = userInfo;
        String name = userInfoObj.getUsername();
        
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
        headPanel.setBackground(java.awt.Color.red);
        headPanel.setForeground(java.awt.Color.red);
        headPanel.setMaximumSize(new java.awt.Dimension(750, 120));
        headPanel.setMinimumSize(new java.awt.Dimension(750, 120));
        headPanel.setPreferredSize(new java.awt.Dimension(750, 120));
        
        headLabel = new javax.swing.JLabel();
        headLabel.setFont(new java.awt.Font("Footlight MT Light", 1, 35)); // NOI18N
        headLabel.setForeground(java.awt.Color.white);
        headLabel.setText(" Manage Users");
        
        logout = new JButton();
        logout.setFont(new java.awt.Font("Gisha", 1, 14));
        logout.setText("Logout");
        logout.setForeground(java.awt.Color.blue);
        logout.setToolTipText("Logs out the current  User");
        logout.addActionListener(this);
        
        helloLabel = new javax.swing.JLabel();
        helloLabel.setFont(new java.awt.Font("Papyrus", 3, 16)); // NOI18N
        helloLabel.setForeground(java.awt.Color.black);
        helloLabel.setText("Hello " + name);
       
        jSeparator = new javax.swing.JSeparator();
        jSeparator.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));    
        
        subPanel = new javax.swing.JPanel();
        subPanel.setBackground(java.awt.Color.white);
        subPanel.setMaximumSize(new java.awt.Dimension(750, 378));
        subPanel.setMinimumSize(new java.awt.Dimension(750, 378));

        manageLabel = new javax.swing.JLabel();
        manageLabel.setIcon(new javax.swing.ImageIcon("project images\\My store\\manage\\manage.jpg")); // NOI18N
        
        emailIdLabel = new javax.swing.JLabel();
        emailIdLabel.setFont(new java.awt.Font("Footlight MT Light", 1, 20)); // NOI18N
        emailIdLabel.setText("Select Email-Id");
        
        MySqlConnect connect = new MySqlConnect();
        String emailIdList[] = connect.emailIdList();
        String status = null;
        if(emailIdList!=null)
        {
        	emailIdCombo = new javax.swing.JComboBox<String>(emailIdList);
            emailIdCombo.setEditable(false);
            emailIdCombo.setMaximumRowCount(5);
            emailIdCombo.setSelectedIndex(0);
            emailIdCombo.addActionListener(this);
            String[] data = connect.searchUser((String)emailIdCombo.getSelectedItem());
			status = data[3];
        }
        else
        {
        	JOptionPane.showMessageDialog(this,"No Users have heen registered", "ERROR!!!", JOptionPane.ERROR_MESSAGE);
        }
      
        search = new javax.swing.JButton();
        search.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        search.setForeground(java.awt.Color.blue);
        search.setText("Search");
        search.addActionListener(this);  
        
        accountStatusLabel = new javax.swing.JLabel();
        accountStatusLabel.setFont(new java.awt.Font("Footlight MT Light", 1, 20)); // NOI18N
        accountStatusLabel.setText("Account Status");
        
        block = new javax.swing.JRadioButton();
        block.setToolTipText("Block User");
        block.setIcon(new javax.swing.ImageIcon("project images\\My store\\manage\\user block.jpg")); // NOI18N
        block.setRolloverIcon(new javax.swing.ImageIcon("project images\\My store\\manage\\user block selected.JPG")); // NOI18N
        block.setRolloverSelectedIcon(new javax.swing.ImageIcon("project images\\My store\\manage\\user block selected.JPG")); // NOI18N
        block.setSelectedIcon(new javax.swing.ImageIcon("project images\\My store\\manage\\user block selected.JPG")); // NOI18N
        block.addActionListener(this);
        
        unblock = new javax.swing.JRadioButton();
        unblock.setToolTipText("UnBlock User");
        unblock.setIcon(new javax.swing.ImageIcon("project images\\My store\\manage\\user unblock.JPG")); // NOI18N
        unblock.setRolloverIcon(new javax.swing.ImageIcon("project images\\My store\\manage\\user unblock selected.JPG")); // NOI18N
        unblock.setRolloverSelectedIcon(new javax.swing.ImageIcon("project images\\My store\\manage\\user unblock selected.JPG")); // NOI18N
        unblock.setSelectedIcon(new javax.swing.ImageIcon("project images\\My store\\manage\\user unblock selected.JPG")); // NOI18N
        unblock.addActionListener(this);   
        
        delete = new javax.swing.JButton();
        delete.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        delete.setForeground(java.awt.Color.blue);
        delete.setText("Delete");
        delete.addActionListener(this);
        
       
		if(status.equals("block"))
		{
			block.setSelected(true);
			unblock.setSelected(false);
		}
		else
		{
			unblock.setSelected(true);
			block.setSelected(false);
		}
        
        javax.swing.GroupLayout headPanelLayout = new javax.swing.GroupLayout(headPanel);
        headPanel.setLayout(headPanelLayout);
        headPanelLayout.setHorizontalGroup(
            headPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(helloLabel)
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headPanelLayout.createSequentialGroup()
                .addContainerGap(202, Short.MAX_VALUE)
                .addComponent(headLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(198, 198, 198))
        );
        headPanelLayout.setVerticalGroup(
            headPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(headLabel)
                .addGap(0, 0, 0)
                .addGroup(headPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(helloLabel)
                    .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        
        javax.swing.GroupLayout subPanelLayout = new javax.swing.GroupLayout(subPanel);
        subPanel.setLayout(subPanelLayout);
        subPanelLayout.setHorizontalGroup(
            subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subPanelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emailIdLabel)
                    .addComponent(accountStatusLabel))
                .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(manageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(325, 325, 325))
                    .addGroup(subPanelLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(subPanelLayout.createSequentialGroup()
                                .addComponent(block)
                                .addGap(88, 88, 88)
                                .addComponent(unblock))
                            .addComponent(emailIdCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(60, 196, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(delete)
                .addGap(279, 279, 279))
        );
        subPanelLayout.setVerticalGroup(
            subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subPanelLayout.createSequentialGroup()
                .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(subPanelLayout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailIdLabel)
                            .addComponent(emailIdCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addComponent(accountStatusLabel)
                        .addGap(34, 34, 34))
                    .addGroup(subPanelLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(manageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(unblock, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(block, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(25, 25, 25)
                .addComponent(delete)
                .addContainerGap())
        );
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator)
            .addComponent(headPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    

	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource() == logout)
		{
			HomePage goToHome = new HomePage();
			goToHome.setVisible(true);
			
			dispose();
		}	
		
		if(ae.getSource() == delete)
		{	
			String emailId = (String) emailIdCombo.getSelectedItem();
			
			MySqlConnect deleteUser = new MySqlConnect();
			
			boolean deleted = deleteUser.deleteUser(emailId);
			if(deleted)
			{
				JOptionPane.showMessageDialog(this,"User was deleted Succesfully", "SUCCESS!!!", JOptionPane.INFORMATION_MESSAGE);
				emailIdCombo.removeItem(emailId);
			}
			else
			{
				JOptionPane.showMessageDialog(this,"User was not deleted", "ERROR!!!", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if(ae.getSource() == block)
		{
			unblock.setSelected(false);
			String emailId = (String) emailIdCombo.getSelectedItem();
			if(!(emailId.length()<=0))
			{
				String status = "block";				
				MySqlConnect blockUser = new MySqlConnect();				
				int accountStatus = blockUser.accountAccess(status, emailId);
				if(accountStatus == 1)
				{
					JOptionPane.showMessageDialog(this,"User was blocked Succesfully", "SUCCESS!!!", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(accountStatus == 2)
				{
					JOptionPane.showMessageDialog(this,"User does not exist", "ERROR!!!", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"User was not blocked due to some errors", "ERROR!!!", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			else
			{
				JOptionPane.showMessageDialog(this,"Please select a Email-Id", "Select Email-Id", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		if(ae.getSource() == emailIdCombo)
		{
			String email = (String) emailIdCombo.getSelectedItem();
			MySqlConnect connect = new MySqlConnect();
			String[] data = connect.searchUser(email);
			String status = null;
			status = data[3];
			
			if(status.equals("block"))
			{
				block.setSelected(true);
				unblock.setSelected(false);
			}
			else
			{
				unblock.setSelected(true);
				block.setSelected(false);
			}
		}
		if(ae.getSource() == unblock)
		{
			block.setSelected(false);
			String emailId = (String) emailIdCombo.getSelectedItem();
			if(!(emailId.length()<=0))
			{
				String status = "unblock";				
				MySqlConnect blockUser = new MySqlConnect();				
				int accountStatus = blockUser.accountAccess(status, emailId);
				if(accountStatus == 1)
				{
					JOptionPane.showMessageDialog(this,"User was unblocked Succesfully", "SUCCESS!!!", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(accountStatus == 2)
				{
					JOptionPane.showMessageDialog(this,"User does not exist", "ERROR!!!", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"User was not unblocked due to some errors", "ERROR!!!", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			else
			{
				JOptionPane.showMessageDialog(this,"Please select a Email-Id", "Select Email-Id", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	public static void main(String args[])
	{
		UserInfo testUser = new UserInfo();
		testUser.setUsername("Administrator");
		testUser.setEmailid("administrator");
		
		ManageAccounts test = new ManageAccounts(testUser);
		test.setVisible(true);
	}
		        
}
    /* */

/* javax.swing.GroupLayout headPanelLayout = new javax.swing.GroupLayout(headPanel);
        headPanel.setLayout(headPanelLayout);
        headPanelLayout.setHorizontalGroup(
            headPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(helloLabel)
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headPanelLayout.createSequentialGroup()
                .addContainerGap(202, Short.MAX_VALUE)
                .addComponent(headLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(198, 198, 198))
        );
        headPanelLayout.setVerticalGroup(
            headPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(headLabel)
                .addGap(0, 0, 0)
                .addGroup(headPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(helloLabel)
                    .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        
        javax.swing.GroupLayout subPanelLayout = new javax.swing.GroupLayout(subPanel);
        subPanel.setLayout(subPanelLayout);
        subPanelLayout.setHorizontalGroup(
            subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subPanelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emailIdLabel)
                    .addComponent(accountStatusLabel))
                .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(manageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(325, 325, 325))
                    .addGroup(subPanelLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(subPanelLayout.createSequentialGroup()
                                .addComponent(block)
                                .addGap(88, 88, 88)
                                .addComponent(unblock))
                            .addComponent(emailIdCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(search)
                        .addGap(60, 60, 60))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(delete)
                .addGap(325, 325, 325))
        );
        subPanelLayout.setVerticalGroup(
            subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subPanelLayout.createSequentialGroup()
                .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(subPanelLayout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailIdLabel)
                            .addComponent(search)
                            .addComponent(emailIdCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addComponent(accountStatusLabel)
                        .addGap(34, 34, 34))
                    .addGroup(subPanelLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(manageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(unblock, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(block, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(25, 25, 25)
                .addComponent(delete)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator)
            .addComponent(headPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    }*/
