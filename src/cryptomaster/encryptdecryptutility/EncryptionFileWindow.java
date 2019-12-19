package cryptomaster.encryptdecryptutility;

import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import cryptomaster.email.SendMailTLS;
import cryptomaster.encryption.EncryptImageAudioVideo;
import cryptomaster.encryption.TextEncryptionController;
import cryptomaster.home.HomePage;
import cryptomaster.model.FileInfo;
import cryptomaster.model.UserInfo;

public class EncryptionFileWindow extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private javax.swing.JButton back;
    private javax.swing.JTextField emailIdTextField;
    private javax.swing.JButton encrypt;
    private javax.swing.JLabel encryptedFileForLabel;
    private javax.swing.JLabel encryptedFilePathLabel;
    private javax.swing.JTextField encryptedFilePathTextField;
    private javax.swing.JLabel encryptionImage;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel headPanel;
    private javax.swing.JButton inputBrowse;
    private javax.swing.JLabel inputFilePathLabel;
    private javax.swing.JTextField inputFilePathTextField;
    private javax.swing.JSeparator jSeparator;
    private javax.swing.JButton logout;
    private javax.swing.JRadioButton other;
    private javax.swing.JButton outputBrowse;
    private javax.swing.JRadioButton self;
    private javax.swing.JLabel usernameLabel;
    
    UserInfo userInfoObj = new UserInfo();
    FileInfo fileInfoObj = new FileInfo();
    
    private String username;
    private String fileType;
    private String selfEmailId;
    
    private String inputFilePath;
    private String inputFileExtension;
    private String encryptedFilePath; 
    private String encryptedFileName;
    private String encryptedFileFor;
    private String emailId;
    private String encryptionKey;
    
    WaitingDialog wait;
    
    public EncryptionFileWindow(UserInfo userInfo, FileInfo fileInfo) 
    {
    	setTitle("Encryption");
    	setLocation(300,100);
    	setSize(750,500);
    	setResizable(false);
    	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(new java.awt.Color(240,240,240));
    	  
        userInfoObj = userInfo;
        username = userInfoObj.getUsername();
        selfEmailId = userInfoObj.getEmailid();
       
        fileInfoObj = fileInfo;    	
    	fileType = fileInfoObj.getInputFileType();
    		
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
        
        inputFilePathLabel = new javax.swing.JLabel();
        inputFilePathTextField = new javax.swing.JTextField();
        inputBrowse = new javax.swing.JButton();
        encryptedFilePathTextField = new javax.swing.JTextField();
        outputBrowse = new javax.swing.JButton();
        encryptedFilePathLabel = new javax.swing.JLabel();
        encryptedFileForLabel = new javax.swing.JLabel();
        self = new javax.swing.JRadioButton();
        other = new javax.swing.JRadioButton();
        emailIdTextField = new javax.swing.JTextField();
        encrypt = new javax.swing.JButton();
        headPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        logout = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jSeparator = new javax.swing.JSeparator();
        encryptionImage = new javax.swing.JLabel();
        
        headPanel = new JPanel();
        headPanel.setBackground(new java.awt.Color(153,180,209));
        headPanel.setBackground(new java.awt.Color(153,180,209));
        
        titleLabel = new JLabel("Encryption");
        titleLabel.setFont(new java.awt.Font("Footlight MT Light", 1, 40));
        titleLabel.setForeground(new java.awt.Color(153,0,0));
        
        logout = new JButton();
        logout.setFont(new java.awt.Font("Gisha", 1, 14));
        logout.setText("Logout");
        logout.setForeground(java.awt.Color.blue);
        logout.setToolTipText("Logs out the current  User");
        logout.addActionListener(this);
        
        usernameLabel = new JLabel();
        usernameLabel.setFont(new java.awt.Font("Footlight MT Light", 0, 18)); // NOI18N
        usernameLabel.setText("Hello " + username);
        
        jSeparator.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        encryptionImage.setIcon(new javax.swing.ImageIcon("project images\\My store\\encryptionFileWindow\\lock.jpg")); // NOI18N
        
        inputFilePathLabel.setFont(new java.awt.Font("Footlight MT Light", 0, 20)); // NOI18N
        inputFilePathLabel.setText("Enter Input File path");
       
        inputFilePathLabel.setFont(new java.awt.Font("Footlight MT Light", 0, 20)); // NOI18N
        inputFilePathLabel.setText("Enter " + fileType +" File path");
        inputFilePathLabel.setMaximumSize(new java.awt.Dimension(164, 29));
        
        inputFilePathTextField.setToolTipText("Location of the " + fileType + " File");
        inputFilePathTextField.setEditable(false);
        
        inputBrowse = new JButton();
        inputBrowse.setFont(new java.awt.Font("Gisha", 1, 14));
        inputBrowse.setText("Browse");
        inputBrowse.addActionListener(this);
        
        encryptedFilePathLabel = new JLabel("Enter Encrypted " + fileType + " File path");
        encryptedFilePathLabel.setFont(new java.awt.Font("Footlight MT Light", 0, 20));
        
        encryptedFilePathTextField.setToolTipText("Location where the Encrypted " + fileType + " File should be stored");
        encryptedFilePathTextField.setEditable(false);
        
        outputBrowse = new JButton("Save As");
        outputBrowse.setFont(new java.awt.Font("Gisha", 1, 14));
        outputBrowse.setText("Save As");
        outputBrowse.addActionListener(this);
        
        encryptedFileForLabel = new JLabel("Encrypted " + fileType + " File For");
        encryptedFileForLabel.setFont(new java.awt.Font("Footlight MT Light", 0, 20));
        
        self = new JRadioButton("Self");
        self.setFont(new Font("Century", 1, 11));
        self.setText("Self");
        self.addActionListener(this);
        
        other = new JRadioButton("Other");
        other.setFont(new Font("Century", 1, 11)); 
        other.setText("Other");
        other.addActionListener(this);
        
        emailIdTextField.setEnabled(false);
        emailIdTextField.setText("Recipient's Email...");
        emailIdTextField.setToolTipText("Please Enter the Recipient's Email address");
   
        encrypt = new JButton("Encrypt !!!");
        encrypt.setFont(new java.awt.Font("Gisha", 1, 14));
        encrypt.setText("Encrypt");
        encrypt.addActionListener(this);
        
        back = new JButton();
        back.setFont(new java.awt.Font("Gisha", 1, 14));
        back.setText("Back");
        back.setEnabled(true);
        back.addActionListener(this);
   
        javax.swing.GroupLayout headPanelLayout = new javax.swing.GroupLayout(headPanel);
        headPanel.setLayout(headPanelLayout);
        headPanelLayout.setHorizontalGroup(
            headPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(logout)
                .addGap(174, 174, 174)
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(usernameLabel)
                .addGap(25, 25, 25))
        );
        headPanelLayout.setVerticalGroup(
            headPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headPanelLayout.createSequentialGroup()
                .addGroup(headPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headPanelLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(headPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(logout)
                            .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(headPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(titleLabel)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputFilePathLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(encryptedFileForLabel)
                    .addComponent(encryptedFilePathLabel))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(self)
                        .addGap(49, 49, 49)
                        .addComponent(other, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(emailIdTextField)
                        .addGap(82, 82, 82))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputFilePathTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(encryptedFilePathTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(inputBrowse)
                            .addComponent(outputBrowse))
                        .addGap(47, 47, 47))))
            .addComponent(jSeparator)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(back)
                .addGap(42, 42, 42)
                .addComponent(encrypt)
                .addGap(263, 263, 263))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addComponent(encryptionImage)
                .addGap(340, 340, 340))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(encryptionImage)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputFilePathLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputFilePathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputBrowse))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(encryptedFilePathLabel)
                    .addComponent(encryptedFilePathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outputBrowse))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(encryptedFileForLabel)
                    .addComponent(self)
                    .addComponent(other)
                    .addComponent(emailIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back)
                    .addComponent(encrypt))
                .addGap(39, 39, 39))
        );

        pack();
    }
    
    boolean isValidForm()
    {
    	boolean validForm = true;
    	
    	if(new String(inputFilePathTextField.getText()).length() == 0)
    	{
    		JOptionPane.showMessageDialog(this, "Please Select a Input File", "ERROR !!!", JOptionPane.ERROR_MESSAGE);
    		validForm = false;
    		return validForm;
    	}
    	
    	File f1 = new File(inputFilePathTextField.getText());
    	if(f1.exists())
    	{
    		if(f1.length()<=0)
    		{
    			JOptionPane.showMessageDialog(this, "The Input File has no contents", "ERROR !!!", JOptionPane.ERROR_MESSAGE);
    			validForm = false;
    		}
    	}
    	else
    	{
    		JOptionPane.showMessageDialog(this, "The System cannot find specified File", "ERROR !!!", JOptionPane.ERROR_MESSAGE);
    		validForm = false;
    	}
    	
    	
    	if(new String(encryptedFilePathTextField.getText()).length() == 0)
    	{
    		JOptionPane.showMessageDialog(this, "Please Select a location to store the Encrypted File ", "ERROR !!!", JOptionPane.ERROR_MESSAGE);
    		validForm = false;
    		return validForm;
    	}
    	   	
    	if(encryptedFileFor.equals("other"))
    	{
    		if(new String(emailIdTextField.getText()).equals("Recipient's Email..."))
    		{
    			JOptionPane.showMessageDialog(this, "Please give the Recipient's Email Address", "ERROR !!!", JOptionPane.ERROR_MESSAGE);
        		validForm = false;
        		return validForm;
    		}
    		
    		if(new String(emailIdTextField.getText()).length() == 0)
    		{
    			JOptionPane.showMessageDialog(this, "Please enter the Recipient's Email Address", "ERROR !!!", JOptionPane.ERROR_MESSAGE);
        		validForm = false;
        		return validForm;
    		}
    	}
    	return validForm;
    }
                       
    public void actionPerformed(ActionEvent ae)
	{
    	 if(ae.getSource() == logout)
    	 {
    		 userInfoObj = null;
    		 fileInfoObj = null;
    		 HomePage goToHome = new HomePage();
    		 goToHome.setVisible(true);
    		 dispose();
    	 }
    	 
    	 if(ae.getSource() == self && self.isSelected() == true)
    	 {
    		other.setSelected(false);
    		emailIdTextField.setEnabled(false);
    		
    		encryptedFileFor = new String("self");
    		emailIdTextField.setText(selfEmailId); 
    	 }
    	 
    	 if(ae.getSource() == other && other.isSelected() == true)
    	 {
    		self.setSelected(false);
    		emailIdTextField.setEnabled(true);
    		emailIdTextField.setText("");
    		encryptedFileFor = new String("other");    		
    	 }
    	 
    	 if(ae.getSource() == inputBrowse)
    	 {
    		 File inputFile;
    		 inputFile = showFileDialog(true);
    		 inputFilePath = inputFile.getAbsolutePath();
    		
    		 int l = inputFilePath.lastIndexOf(".");
    		 inputFileExtension = inputFilePath.substring(l+1, inputFilePath.length());
    		 
    		 inputFilePathTextField.setText(inputFilePath);
    	 }
    	 
    	 if(ae.getSource() == outputBrowse)
    	 {
    		 File outputFile;
    		 
    		 outputFile = showFileDialog(false);
			 encryptedFileName = outputFile.getName();
			 System.out.println(encryptedFileName);
			 String ext = new String();
			 ext = encryptedFileName.substring(encryptedFileName.lastIndexOf(".") + 1).toLowerCase();
			 
			 if (!ext.equalsIgnoreCase(inputFileExtension)) 
			 {
				 outputFile = new File(outputFile.getAbsolutePath() +"."+ inputFileExtension);
			 }
			 
    		 encryptedFilePath = outputFile.getAbsolutePath();
    		 encryptedFilePathTextField.setText(encryptedFilePath);   		 
    	 }
    	 
    	 if(ae.getSource() == back)
    	 {
    		 EncryptDecryptUtility chooseAction = new EncryptDecryptUtility(userInfoObj);
    		 chooseAction.setVisible(true);
    		 dispose();
    	 }
    	 
    	 if(ae.getSource() == encrypt)
    	 { 	 
    		 boolean validForm = false;
    		 boolean steganographyEligiblity = false;
    		 validForm = isValidForm();
    		 
    		 if(validForm)
    		 { 
    			 emailId = new String(emailIdTextField.getText());
        		 if(encryptedFileFor.equals("self"))
        		 {
        			 emailId = new String(selfEmailId);
        		 }
        		 
        		 fileInfoObj.setInputFilePath(inputFilePath);
        		 	 
        		 fileInfoObj.setEncryptedFilePath(encryptedFilePath);
        		 fileInfoObj.setEncryptedFileName(encryptedFileName);
        		 fileInfoObj.setEncryptedFileFor(encryptedFileFor);
        		 userInfoObj.setReciverEmailId(emailId);       	
        		 
        		 if(fileType.equals("Text"))
    			 {
        			 TextEncryptionController textEncryption = new TextEncryptionController(userInfoObj, fileInfoObj);
        			 boolean performSteganography = false;
        			 try 
        			 {
						steganographyEligiblity = textEncryption.setTextEncryptionParameters();
						encryptionKey = textEncryption.getEncryptionKey();
						fileInfoObj.setEncryptedFileKey(encryptionKey);
						
						wait = new WaitingDialog(this,1);
						wait.setVisible(true);
						
						boolean mailSent = this.sendEmail();
							
						if(mailSent)
						{
							wait.dispose();
							if(steganographyEligiblity)
							{	
								SteganographDialogBox steganographyDialogBox = new SteganographDialogBox(this);
								
								performSteganography = steganographyDialogBox.performSteganography();
								steganographyDialogBox.dispose();
	        				 
								if(performSteganography)
								{
									textEncryption.steganography();
									dispose();
								}
								else
								{
									boolean fileSaved = true;
									fileSaved = textEncryption.fileSave();
									
									if(fileSaved == false)
									{
										JOptionPane.showMessageDialog(this, "Some Error Occured while Saving the Encrypted File", "OPPS an ERROR occured!!!", JOptionPane.ERROR_MESSAGE);
									}
								}	
							}
						}
						
					 }

        			 catch (IOException e) 
        			 {
						e.printStackTrace();
					 }
    			 }
        		 
        		if(fileType.equals("Image") || fileType.equals("Audio") || fileType.equals("Video") )
        		{
        			boolean success = false;
        			
        			EncryptImageAudioVideo encryption = new EncryptImageAudioVideo(fileInfoObj);
        			boolean keyGeneration = encryption.generateKey();
        							
					if(keyGeneration)
					{
						encryptionKey = encryption.getEncryptionKey();
	        			fileInfoObj.setEncryptedFileKey(encryptionKey);
	        			
	        			wait = new WaitingDialog(this, 1);
						wait.setVisible(true);
	        			
						boolean mailSent = this.sendEmail();
						
						if(mailSent)
						{
							success = encryption.encrypt();
						}
	        			if(success)
	        			{
	        				wait.dispose();
	        				encryptionKey = encryption.getEncryptionKey();
	        				fileInfoObj.setEncryptedFileKey(encryptionKey);
	        				JOptionPane.showMessageDialog(this, fileType + " Encryption Successful\nYour Key is " + encryptionKey , "Success!!!", JOptionPane.INFORMATION_MESSAGE);
	        				System.out.println("Key: " + encryptionKey);
	        			}
	        			else
	        			{
	        				JOptionPane.showMessageDialog(this, fileType + " Encryption was Unsuccessful due to some errors", "Error!!!", JOptionPane.ERROR_MESSAGE);
	        			}
					}
					else
					{
						JOptionPane.showMessageDialog(this,"Key Generation Failed","ERROR!!!", JOptionPane.ERROR_MESSAGE);
					}
        		}
    		 }	 
    	 }
	}
    
	
	private boolean sendEmail()
    {
    	boolean mailSent = true;
    	SendMailTLS sendEncryptionCertificate = new SendMailTLS();
    	mailSent = sendEncryptionCertificate.sendEmail(userInfoObj, fileInfoObj);
    					
    	if(mailSent == false)
    	{
    		wait.dispose();
    		JOptionPane.showMessageDialog(this, "Cannot send E-mail Please Check Internet Connection and Recipient's Email ID", "Email not Sent!!!", JOptionPane.ERROR_MESSAGE);
    	}	
    	
		return mailSent;
    }
    
    private File showFileDialog(final boolean open) 
	{
		JFileChooser fc = new JFileChooser("Open File");	
		if(fileType.equals("Text"))
		{
			FileNameExtensionFilter extFileFilter = new FileNameExtensionFilter("Text Files (*.txt)", "txt");
			fc.setAcceptAllFileFilterUsed(false);
			fc.addChoosableFileFilter(extFileFilter);
		}
		else if(fileType.equals("Image"))
		{
			FileNameExtensionFilter extFileFilter = new FileNameExtensionFilter("Image Files (*.jpg, *.png, *.gif, *.bmp)", "jpg" , "png", "gif" ,"bmp");
			fc.setAcceptAllFileFilterUsed(false);
			fc.addChoosableFileFilter(extFileFilter);
		}
		else if(fileType.equals("Audio"))
		{
			FileNameExtensionFilter extFileFilter = new FileNameExtensionFilter("Audio Files (*.mp3, *.wav, *.aac)", "mp3", "wav", "aac");
			fc.setAcceptAllFileFilterUsed(false);
			fc.addChoosableFileFilter(extFileFilter);
		}
		else if(fileType.equals("Video"))
		{
			FileNameExtensionFilter extFileFilter = new FileNameExtensionFilter("Video Files (*.3gp, *.mp4, *.mkv, *.flv)", "3gp", "mp4", "mkv", "flv");
			fc.setAcceptAllFileFilterUsed(false);
			fc.addChoosableFileFilter(extFileFilter);
		}

		java.io.File f = null;
		if (open && fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
			f = fc.getSelectedFile();
		else if (!open && fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
			f = fc.getSelectedFile();
		return f;
	}

    public static void main(String args[]) 
    {
       UserInfo userInfo = new UserInfo();
       userInfo.setUsername("Mohit");
       userInfo.setEmailid("mohitssj10@gmail.com");
       
       FileInfo fileInfo = new FileInfo();
       fileInfo.setInputFileType("Text");
       
       EncryptionFileWindow test = new EncryptionFileWindow(userInfo, fileInfo);
       test.setVisible(true);
    }

	boolean performSteganography;	                 
}


class SteganographDialogBox extends JDialog implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	JLabel steganographLabel;
	JButton yes, no;
	FlowLayout flowLayout;
	
	
	boolean steganography = false;
	
	public SteganographDialogBox(JFrame parent)
	{
		super(parent,true);
		setLocation(462,320);
		setSize(400,100);		
		setResizable(false);
		this.getContentPane().setBackground(new java.awt.Color(153,180,209));
		setTitle("Perform Steganography");
		
		flowLayout = new FlowLayout();
		setLayout(flowLayout);
		
		steganographLabel = new JLabel("Do you want to perform Steganography ?");
		steganographLabel.setFont(new java.awt.Font("Footlight MT Light", 0, 20));
		
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
		if(type == 1)
		{
			wait.setText("Please wait as the email is being sent and file is to be encrypted");
			
		}
		else
		{
			wait.setText("Please wait as the file is being Decrypted");		
		}
		add(wait);
		setVisible(true);
	}
}