package cryptomaster.home;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import cryptomaster.login.Login;
import cryptomaster.registration.Registeration;

public class HomePage extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private javax.swing.JPanel headPanel;
	private javax.swing.JLabel titleLabel;
	private javax.swing.JLabel cryptoLabel;
	
	private javax.swing.JSeparator jSeparator;
	
	private javax.swing.JLabel iconLabel;
	private javax.swing.JButton login;
    private javax.swing.JButton about;
    private javax.swing.JButton register;
	   
	
	Container container;
	
	public HomePage()
	{
		setTitle("Home Page");
    	setLocation(300,100);
        setSize(750,550);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new java.awt.Color(240,240,240)); // set background color for Frame
        
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
        titleLabel.setFont(new java.awt.Font("Footlight MT Light", Font.BOLD, 40)); // NOI18N
        titleLabel.setText("Welcome To");
        titleLabel.setForeground(new java.awt.Color(153,0,0));
        
        cryptoLabel = new javax.swing.JLabel();
        cryptoLabel.setFont(new java.awt.Font("Papyrus", Font.BOLD, 40)); // NOI18N
        cryptoLabel.setForeground(java.awt.Color.red);
        cryptoLabel.setText("CryptoMaster");
        
        jSeparator = new javax.swing.JSeparator();
        jSeparator.setForeground(new java.awt.Color(25, 255, 255));
        jSeparator.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        
        iconLabel = new javax.swing.JLabel();
        iconLabel.setBackground(java.awt.Color.blue);
        iconLabel.setForeground(java.awt.Color.blue);
        iconLabel.setIcon(new javax.swing.ImageIcon("project images\\My store\\home\\enc2.jpg")); // NOI18N    
        
        login = new javax.swing.JButton();
        login.setFont(new java.awt.Font("Papyrus", 3, 18)); // NOI18N
        login.setText("Log In");
        login.setMaximumSize(new java.awt.Dimension(73, 30));
        login.setMinimumSize(new java.awt.Dimension(73, 30));
        login.setPreferredSize(new java.awt.Dimension(73, 30));
        login.addActionListener(this);
        
        register = new javax.swing.JButton();
        register.setFont(new java.awt.Font("Papyrus", 3, 18)); // NOI18N
        register.setText("Register");
        register.setMaximumSize(new java.awt.Dimension(73, 30));
        register.setMinimumSize(new java.awt.Dimension(73, 30));
        register.setPreferredSize(new java.awt.Dimension(73, 30));
        register.addActionListener(this);
        
        about = new javax.swing.JButton();
        about.setFont(new java.awt.Font("Papyrus", 3, 18)); // NOI18N
        about.setText("About");
        about.setMaximumSize(new java.awt.Dimension(73, 30));
        about.setMinimumSize(new java.awt.Dimension(73, 30));
        about.setPreferredSize(new java.awt.Dimension(73, 30));
        about.addActionListener(this);
        
        
        javax.swing.GroupLayout headPanelLayout = new javax.swing.GroupLayout(headPanel);
        headPanel.setLayout(headPanelLayout);
        headPanelLayout.setHorizontalGroup(
            headPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cryptoLabel)
                .addGap(40, 40, 40))
        );
        headPanelLayout.setVerticalGroup(
            headPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(cryptoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(267, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(iconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(about, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(register, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                        .addComponent(login, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)))
                .addGap(284, 284, 284))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(iconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(register, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(about, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
	}

	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource() == login)
		{
			Login loginUser = new Login();
			loginUser.setVisible(true);
			
			dispose();
		}
		
		if(ae.getSource() == register)
		{
			Registeration registerUser = new Registeration();
			registerUser.setVisible(true);
			
			dispose();
		}
		
		if(ae.getSource() == about)
		{
			dispose();
			About about = new About();
			about.setVisible(true);
		}
	}
		
	public static void main(String args[])
	{
		HomePage test = new HomePage();
		test.setVisible(true);
	}
}

/* 
javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
  getContentPane().setLayout(layout);
  layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(headPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(jSeparator)
      .addGroup(layout.createSequentialGroup()
          .addGap(125, 125, 125)
          .addComponent(iconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
          .addContainerGap(271, Short.MAX_VALUE)
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(manage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(register, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
              .addComponent(login, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
          .addGap(284, 284, 284))
  );
  layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
          .addComponent(headPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGap(0, 0, 0)
          .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGap(20, 20, 20)
          .addComponent(iconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGap(20, 20, 20)
          .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGap(18, 18, 18)
          .addComponent(register, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGap(18, 18, 18)
          .addComponent(manage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addContainerGap(62, Short.MAX_VALUE))
  );
*/
