package cryptomaster.encryptdecryptutility;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import cryptomaster.home.HomePage;
import cryptomaster.manageaccounts.ChangeUser;
import cryptomaster.model.FileInfo;
import cryptomaster.model.UserInfo;

public class EncryptDecryptUtility extends JFrame implements ItemListener,ActionListener
{	
	private static final long serialVersionUID = 1L;
	
	private javax.swing.JLabel actionToPerformLabel;
	private javax.swing.JRadioButton audioRadioButton;
	private javax.swing.JButton manageAccount;
	private javax.swing.JRadioButton decrypt;
	private javax.swing.JRadioButton encrypt;
	private javax.swing.JLabel fileTypeLabel;
	private javax.swing.JPanel headPanel;
	private javax.swing.JRadioButton imageRadioButton;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JSeparator jSeparator2;
	private javax.swing.JButton logout;
	private javax.swing.JButton next;
	private javax.swing.JPanel subPanel;
	private javax.swing.JRadioButton textRadioButton;
	private javax.swing.JLabel titleLabel;
	private javax.swing.JLabel usernameLabel;
	private javax.swing.JRadioButton videoRadioButton;
	
	UserInfo userInfoObj = new UserInfo();
	FileInfo fieInfoObj = new FileInfo();
	
	String usernameString;
	
	String actionToPerform;
	String fileType;
	

	public EncryptDecryptUtility(UserInfo userInfo) 
	{
		setTitle("Select your File Type");
		setLocation(300,100);
		setSize(750,500);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(new java.awt.Color(153,180,209));
		
		userInfoObj = userInfo;
		usernameString = userInfoObj.getUsername();
		
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
        jSeparator1 = new javax.swing.JSeparator();
        logout = new javax.swing.JButton();
        usernameLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        subPanel = new javax.swing.JPanel();
        actionToPerformLabel = new javax.swing.JLabel();
        encrypt = new javax.swing.JRadioButton();
        decrypt = new javax.swing.JRadioButton();
        fileTypeLabel = new javax.swing.JLabel();
        textRadioButton = new javax.swing.JRadioButton();
        imageRadioButton = new javax.swing.JRadioButton();
        audioRadioButton = new javax.swing.JRadioButton();
        videoRadioButton = new javax.swing.JRadioButton();
        next = new javax.swing.JButton();
        manageAccount = new javax.swing.JButton();
        
        headPanel.setBackground(new java.awt.Color(153,180,209));
        headPanel.setBorder(new javax.swing.border.MatteBorder(null));

        titleLabel.setFont(new java.awt.Font("Footlight MT Light", 1, 40)); // NOI18N
        titleLabel.setText("Select File Type");
        titleLabel.setForeground(new java.awt.Color(153,0,0));
        
        logout.setFont(new java.awt.Font("Gisha", 1, 14)); // NOI18N
        logout.setText("Logout");
        logout.setForeground(java.awt.Color.blue);
        logout.setToolTipText("Logs out the current  User");
        logout.addActionListener(this);
        
        usernameLabel.setFont(new java.awt.Font("Footlight MT Light", 0, 18)); // NOI18N
        usernameLabel.setText("Hello " + usernameString);
        
        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
        
        subPanel.setBorder(new javax.swing.border.MatteBorder(null));
        subPanel.setBackground(new java.awt.Color(240,240,240));

        actionToPerformLabel.setFont(new java.awt.Font("Footlight MT Light", 0, 28)); // NOI18N
        actionToPerformLabel.setText("Choose Action to Perform :");

        encrypt.setToolTipText("Encrypt");
        encrypt.setIcon(new javax.swing.ImageIcon("project images\\My store\\encryptionDecryptionUtility\\lock.jpg")); // NOI18N
        encrypt.setRequestFocusEnabled(false);
        encrypt.setSelectedIcon(new javax.swing.ImageIcon("project images\\My store\\encryptionDecryptionUtility\\lock selected.jpg")); // NOI18N
        encrypt.addActionListener(this);
        
        decrypt.setToolTipText("Decrypt");
        decrypt.setIcon(new javax.swing.ImageIcon("project images\\My store\\encryptionDecryptionUtility\\unlock.jpg")); // NOI18N
        decrypt.setSelectedIcon(new javax.swing.ImageIcon("project images\\My store\\encryptionDecryptionUtility\\unlock selected.jpg")); // NOI18N
        decrypt.addActionListener(this);
        
        fileTypeLabel.setFont(new java.awt.Font("Footlight MT Light", 0, 28)); // NOI18N
        fileTypeLabel.setText("Select File Type :");
        
        textRadioButton.setToolTipText("Text File");
        textRadioButton.setEnabled(false);
        textRadioButton.setIcon(new javax.swing.ImageIcon("project images\\My store\\encryptionDecryptionUtility\\File types\\Text files\\textfile icon.jpg")); // NOI18N
        textRadioButton.setSelectedIcon(new javax.swing.ImageIcon("project images\\My store\\encryptionDecryptionUtility\\File types\\Text files\\textfile icon selected.jpg")); // NOI18N
        textRadioButton.addItemListener(this);
        
        imageRadioButton.setToolTipText("Image File");
        imageRadioButton.setEnabled(false);
        imageRadioButton.setIcon(new javax.swing.ImageIcon("project images\\My store\\encryptionDecryptionUtility\\File types\\Image files\\imagefile icon.jpg")); // NOI18N
        imageRadioButton.setSelectedIcon(new javax.swing.ImageIcon("project images\\My store\\encryptionDecryptionUtility\\File types\\Image files\\imagefile icon selected.jpg")); // NOI18N
        imageRadioButton.addItemListener(this);
        
        audioRadioButton.setToolTipText("Audio File");
        audioRadioButton.setEnabled(false);
        audioRadioButton.setIcon(new javax.swing.ImageIcon("project images\\My store\\encryptionDecryptionUtility\\File types\\Audio files\\audiofile icon.png")); // NOI18N
        audioRadioButton.setSelectedIcon(new javax.swing.ImageIcon("project images\\My store\\encryptionDecryptionUtility\\File types\\Audio files\\audiofile icon selected.png")); // NOI18N
        audioRadioButton.addItemListener(this);
        
        videoRadioButton.setToolTipText("Video File");
        videoRadioButton.setEnabled(false);
        videoRadioButton.setIcon(new javax.swing.ImageIcon("project images\\My store\\encryptionDecryptionUtility\\File types\\video files\\videofile icon.png")); // NOI18N
        videoRadioButton.setSelectedIcon(new javax.swing.ImageIcon("project images\\My store\\encryptionDecryptionUtility\\File types\\video files\\videofile icon selected.png")); // NOI18N
        videoRadioButton.addItemListener(this);
        
        next.setFont(new java.awt.Font("Gisha", 1, 18)); // NOI18N
        next.setText("Next");
        next.addActionListener(this);
        next.setEnabled(false);
        
        manageAccount.setFont(new java.awt.Font("Gisha", 1, 14)); // NOI18N
        manageAccount.setText("Account Setting");
        manageAccount.addActionListener(this);       
        
        javax.swing.GroupLayout headPanelLayout = new javax.swing.GroupLayout(headPanel);
        headPanel.setLayout(headPanelLayout);
        headPanelLayout.setHorizontalGroup(
            headPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(headPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(logout)
                .addGroup(headPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headPanelLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(titleLabel)
                        .addContainerGap(237, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(usernameLabel)
                        .addGap(25, 25, 25))))
        );
        headPanelLayout.setVerticalGroup(
            headPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headPanelLayout.createSequentialGroup()
                .addGroup(headPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(titleLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(headPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(logout)
                            .addComponent(usernameLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        
        javax.swing.GroupLayout subPanelLayout = new javax.swing.GroupLayout(subPanel);
        subPanel.setLayout(subPanelLayout);
        subPanelLayout.setHorizontalGroup(
            subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imageRadioButton)
                    .addGroup(subPanelLayout.createSequentialGroup()
                        .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(actionToPerformLabel)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subPanelLayout.createSequentialGroup()
                                .addComponent(fileTypeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textRadioButton)))
                        .addGap(63, 63, 63)
                        .addComponent(encrypt))
                    .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subPanelLayout.createSequentialGroup()
                        .addComponent(decrypt)
                        .addGap(104, 104, 104))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subPanelLayout.createSequentialGroup()
                        .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(manageAccount)
                            .addGroup(subPanelLayout.createSequentialGroup()
                                .addComponent(audioRadioButton)
                                .addGap(32, 32, 32)
                                .addComponent(videoRadioButton)))
                        .addGap(22, 22, 22))))
        );
        subPanelLayout.setVerticalGroup(
            subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subPanelLayout.createSequentialGroup()
                .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(subPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(decrypt, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(subPanelLayout.createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addComponent(encrypt, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(subPanelLayout.createSequentialGroup()
                            .addGap(57, 57, 57)
                            .addComponent(actionToPerformLabel))))
                .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(subPanelLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(fileTypeLabel))
                    .addGroup(subPanelLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(audioRadioButton)
                            .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(imageRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(videoRadioButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(next)
                .addGap(13, 13, 13)
                .addComponent(manageAccount)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator2)
            .addComponent(subPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(subPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
	}
	
	public void actionPerformed(ActionEvent ae)
	{
			if(ae.getSource()==encrypt && encrypt.isSelected())
			{
				decrypt.setSelected(false);
				
				textRadioButton.setEnabled(true);
				imageRadioButton.setEnabled(true);
				audioRadioButton.setEnabled(true);
				videoRadioButton.setEnabled(true);
				
				actionToPerform = new String("encryption");
				fieInfoObj.setUserAction(actionToPerform);
			}
			
		   if(ae.getSource()==decrypt && decrypt.isSelected())
			{
				
				encrypt.setSelected(false);
				
				textRadioButton.setEnabled(true);
				imageRadioButton.setEnabled(true);
				audioRadioButton.setEnabled(true);
				videoRadioButton.setEnabled(true);
				
				actionToPerform = new String("decryption");
				fieInfoObj.setUserAction(actionToPerform);
			}
			
			if(ae.getSource() == next)
			{
				if(actionToPerform.equals("encryption"))
				{
					EncryptionFileWindow encFileWindowObj = new EncryptionFileWindow(userInfoObj,fieInfoObj);
					encFileWindowObj.setVisible(true);
					
					dispose();
				}
				
				if(actionToPerform.equals("decryption"))
				{
					DecryptionFileWindow decFileWindowObj = new DecryptionFileWindow(userInfoObj,fieInfoObj);
					decFileWindowObj.setVisible(true);
					
					dispose();
				}
			}
			
			if(ae.getSource() == logout)
			{
				userInfoObj = null;
				fieInfoObj = null;
				
				HomePage goToHome = new HomePage();
				goToHome.setVisible(true);
				
				dispose();
			}
			
			if(ae.getSource() == manageAccount)
			{
				ChangeUser manage = new ChangeUser(userInfoObj);
				manage.setVisible(true);
				
				dispose();
			}
	 }
	 
	public void itemStateChanged(ItemEvent ie)
	{
		 if(ie!=null && ie.getStateChange() == ItemEvent.SELECTED)
		 {  
			 if((ie.getItem()) instanceof JRadioButton) 
			 {
				 JRadioButton temp = (JRadioButton)ie.getItem();
				 temp.setBackground(Color.MAGENTA);
	
			    if(temp.equals(textRadioButton))
			    {
			       fileType = new String("Text");
			       fieInfoObj.setInputFileType(fileType);
			    	
				   videoRadioButton.setSelected(false);
				   videoRadioButton.setBackground(Color.white);
				   imageRadioButton.setSelected(false);
				   imageRadioButton.setBackground(Color.white);
				   audioRadioButton.setSelected(false);
				   audioRadioButton.setBackground(Color.white);
				   
				   next.setEnabled(true);	   
			     }
			    
			    if(temp.equals(imageRadioButton))
			    {
			    	fileType = new String("Image");
			    	fieInfoObj.setInputFileType(fileType);
			    	
				    if(actionToPerform.equals("decryption"))
				    {
				    	SteganographyDialogBox steganographyDialogBox = new SteganographyDialogBox(this);
						
						boolean performSteganography = false;
						performSteganography = steganographyDialogBox.performSteganography();
						steganographyDialogBox.dispose();
						fieInfoObj.setPerformDestagonagraphy(performSteganography);
						
				    }
			    	videoRadioButton.setSelected(false);
				    videoRadioButton.setBackground(Color.white);
					audioRadioButton.setSelected(false);
					audioRadioButton.setBackground(Color.white);
					textRadioButton.setSelected(false);
					textRadioButton.setBackground(Color.white);
					
					next.setEnabled(true);								    	
			    }
			   
			   if(temp.equals(audioRadioButton))
			   {
				   fileType = new String("Audio");
				   fieInfoObj.setInputFileType(fileType);
				   
				   videoRadioButton.setSelected(false);
				   videoRadioButton.setBackground(Color.white);
				   imageRadioButton.setSelected(false);
				   imageRadioButton.setBackground(Color.white);
				   textRadioButton.setSelected(false);
				   textRadioButton.setBackground(Color.white);
				   
				   next.setEnabled(true);				   
				   
			   }
			    
			   if(temp.equals(videoRadioButton))
			   {
				   fileType = new String("Video");
				   fieInfoObj.setInputFileType(fileType);
				  
				   audioRadioButton.setSelected(false);
				   audioRadioButton.setBackground(Color.white);
				   imageRadioButton.setSelected(false);
				   imageRadioButton.setBackground(Color.white);
				   textRadioButton.setSelected(false);
				   textRadioButton.setBackground(Color.white);
				   
				   next.setEnabled(true);				  
			   } 
			}		   
		} 
	}		

	public static void main(String[] args) 
	{
		UserInfo testUserInfo = new UserInfo();
		testUserInfo.setUsername("Mohit");
		testUserInfo.setEmailid("mohitssj10@gmail.com");
		EncryptDecryptUtility f1 = new EncryptDecryptUtility(testUserInfo);
		f1.setVisible(true);
	}

}

class SteganographyDialogBox extends JDialog implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	JLabel steganographLabel;
	JButton yes, no;
	FlowLayout flowLayout;
	
	boolean steganography = false;
	
	public SteganographyDialogBox(JFrame parent)
	{
		super(parent,true);
		setLocation(462,320);
		setSize(400,100);		
		setResizable(false);
		setTitle("Perform Steganography");
		this.getContentPane().setBackground(new java.awt.Color(153,180,209));
		flowLayout = new FlowLayout();
		setLayout(flowLayout);

		steganographLabel = new JLabel("\t\t\tIs    the    Image    Steganograhed   ?\t\t\t");
		steganographLabel.setFont(new java.awt.Font("Footlight MT Light", Font.BOLD, 20));
		yes = new JButton("Yes");
		no = new JButton("No");
		
		add(steganographLabel);
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
			steganography = true;
			dispose();
		}
		
		if(ae.getSource() == no)
		{
			steganography = false;
			dispose();
		}
	}
	
	public boolean performSteganography()
	{
		return steganography;
	}
	 
}