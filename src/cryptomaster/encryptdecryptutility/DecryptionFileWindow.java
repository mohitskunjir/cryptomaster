package cryptomaster.encryptdecryptutility;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import cryptomaster.decryption.DecryptImageAudioVideo;
import cryptomaster.decryption.TextDecryptionController;
import cryptomaster.home.HomePage;
import cryptomaster.model.FileInfo;
import cryptomaster.model.UserInfo;

public class DecryptionFileWindow extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private javax.swing.JButton back;
    private javax.swing.JButton browse;
    private javax.swing.JButton decrypt;
    private javax.swing.JLabel decryptedFilePathLabel;
    private javax.swing.JTextField decryptedFilePathTextField;
    private javax.swing.JLabel decryptionImage;
    private javax.swing.JLabel decryptionKeyLabel;
    private javax.swing.JPasswordField decryptionKeyPasswordField;
    private javax.swing.JLabel encryptedFilePathLabel;
    private javax.swing.JTextField encryptedFilePathTextField;
    private javax.swing.JPanel headPanel;
    private javax.swing.JSeparator jSeparator;
    private javax.swing.JButton logout;
    private javax.swing.JButton saveAs;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel usernameLabel;
    
    UserInfo userInfoObj;
    FileInfo fileInfoObj;
    
    String username;
    String actionToPreform;
    String fileType;
    boolean performDestaganography;
    
    WaitingDialog wait;
    
    String encryptedFilePath;
    String encryptedFileExtension;
    String decryptedFilePath;
    String encryptionKey;
     
    public DecryptionFileWindow(UserInfo userInfo, FileInfo fileInfo)
    {
    	setTitle("Decryption");
    	setLocation(300,100);
    	setSize(750,500);
    	setResizable(false);
    	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(new java.awt.Color(240,240,240));
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    	
    	userInfoObj = userInfo;
    	username = userInfoObj.getUsername();
    	
    	fileInfoObj = fileInfo;
    	fileType = fileInfoObj.getInputFileType();
    	performDestaganography = fileInfoObj.isPerformDestagonagraphy();
    	
    	if(performDestaganography)
    	{
    		actionToPreform = new String("Steganographed");
    	}
    	else
    	{
    		actionToPreform = new String("Encrypted");
    	}
    	
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
         

         titleLabel = new javax.swing.JLabel();
         titleLabel.setFont(new java.awt.Font("Footlight MT Light", 3, 40)); // NOI18N
         titleLabel.setText("Decryption");
         titleLabel.setForeground(new java.awt.Color(153,0,0));
         
         logout = new javax.swing.JButton();
         logout.addActionListener(this);
         logout.setForeground(java.awt.Color.blue);
         logout.setFont(new java.awt.Font("Gisha", 1, 14)); // NOI18N
         logout.setText("Logout");

         usernameLabel = new javax.swing.JLabel();
         usernameLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
         usernameLabel.setText("Hello " + username);
         
         
         
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
       
         jSeparator = new javax.swing.JSeparator();
         jSeparator.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
         
         decryptionImage = new JLabel();
         decryptionImage.setIcon(new javax.swing.ImageIcon("project images\\My store\\decryptionFileWindow\\unlock.jpg"));
         
         encryptedFilePathLabel = new javax.swing.JLabel();
         encryptedFilePathLabel.setFont(new java.awt.Font("Footlight MT Light", 0, 20)); // NOI18N
         encryptedFilePathLabel.setText("Enter " + actionToPreform +" "+ fileType +" File Path :");
         
         encryptedFilePathTextField = new javax.swing.JTextField();
         encryptedFilePathTextField.setEditable(false);

         browse = new javax.swing.JButton();
         browse.setFont(new java.awt.Font("Gisha", 1, 14));
         browse.addActionListener(this);
         browse.setText("Browse");

         decryptedFilePathLabel = new javax.swing.JLabel();
         decryptedFilePathLabel.setFont(new java.awt.Font("Footlight MT Light", 0, 20)); // NOI18
         
         if(performDestaganography)
         {
        	 decryptedFilePathLabel.setText("Enter Decrypted Text File Path :");
         }
         else
         {
        	 decryptedFilePathLabel.setText("Enter Decrypted " + fileType +" File Path :");
         }
         
         saveAs = new javax.swing.JButton();
         saveAs.setFont(new java.awt.Font("Gisha", 1, 14));
         saveAs.addActionListener(this);
         saveAs.setText("Save As");
         
         decryptedFilePathTextField = new javax.swing.JTextField();
         decryptedFilePathTextField.setEditable(false);
         

         decryptionKeyLabel = new javax.swing.JLabel();
         decryptionKeyLabel.setFont(new java.awt.Font("Footlight MT Light", 0, 20)); // NOI18N
         decryptionKeyLabel.setText("Enter Key For Decryption :");
         
         decryptionKeyPasswordField = new javax.swing.JPasswordField();

         back = new javax.swing.JButton();
         back.addActionListener(this);
         back.setFont(new java.awt.Font("Gisha", 1, 14));
         back.setText("BACK");
         
         decrypt = new javax.swing.JButton();
         decrypt.addActionListener(this);    
         decrypt.setFont(new java.awt.Font("Gisha", 1, 14));
         decrypt.setText("DECRYPT");
         
         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
         getContentPane().setLayout(layout);
         layout.setHorizontalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addComponent(headPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
             .addGroup(layout.createSequentialGroup()
                 .addGap(50, 50, 50)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(encryptedFilePathLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(decryptionKeyLabel)
                     .addComponent(decryptedFilePathLabel))
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createSequentialGroup()
                         .addGap(0, 51, Short.MAX_VALUE)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                             .addComponent(encryptedFilePathTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                             .addComponent(decryptedFilePathTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                     .addGroup(layout.createSequentialGroup()
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                         .addComponent(decryptionKeyPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                 .addGap(18, 18, 18)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                     .addComponent(browse)
                     .addComponent(saveAs))
                 .addContainerGap(58, Short.MAX_VALUE))
             .addComponent(jSeparator)
             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                 .addGap(0, 0, Short.MAX_VALUE)
                 .addComponent(back)
                 .addGap(42, 42, 42)
                 .addComponent(decrypt)
                 .addGap(263, 263, 263))
             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                 .addGap(340, 340, 340)
                 .addComponent(decryptionImage)
                 .addGap(340, 340, 340))
         );
         layout.setVerticalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(layout.createSequentialGroup()
                 .addComponent(headPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addGap(0, 0, 0)
                 .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addGap(43, 43, 43)
                 .addComponent(decryptionImage)
                 .addGap(42, 42, 42)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(encryptedFilePathLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(encryptedFilePathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(browse))
                 .addGap(38, 38, 38)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(decryptedFilePathLabel)
                     .addComponent(decryptedFilePathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(saveAs))
                 .addGap(39, 39, 39)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(decryptionKeyLabel)
                     .addComponent(decryptionKeyPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addGap(40, 40, 40)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(back)
                     .addComponent(decrypt))
                 .addGap(39, 39, 39))
         );

         pack();
    }
   
    boolean isValidForm()
    {
    	boolean validForm = true;
    	
    	if(new String(encryptedFilePathTextField.getText()).length() <= 0)
    	{
    		JOptionPane.showMessageDialog(this, "Please Select an Encrypted File", "ERROR !!!", JOptionPane.ERROR_MESSAGE);
    		validForm = false;
    		return validForm;
    	}
    	
    	File f1 = new File(encryptedFilePathTextField.getText());
 
    	if(f1.exists())
    	{
    		if(f1.length()<=0)
    		{
    			JOptionPane.showMessageDialog(this, "The Encrypted File has no contents", "ERROR !!!", JOptionPane.ERROR_MESSAGE);
    			validForm = false;
    			return validForm;
    		}
    	}

    	if(new String(decryptedFilePathTextField.getText()).length() <= 0)
    	{
    		JOptionPane.showMessageDialog(this, "Please Select a location to store the Decrypted File ", "ERROR !!!", JOptionPane.ERROR_MESSAGE);
    		validForm = false;
    		return validForm;
    	}
    	
    	if(new String(decryptionKeyPasswordField.getPassword()).length() <= 0)
    	{
    		JOptionPane.showMessageDialog(this, "Please Enter Key for performing Decryption ", "ERROR !!!", JOptionPane.ERROR_MESSAGE);
    		validForm = false;
    		return validForm;
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
		
		if(ae.getSource() == back)
   	 	{
   		 	EncryptDecryptUtility chooseAction = new EncryptDecryptUtility(userInfoObj);
   		 	chooseAction.setVisible(true);
   		 	dispose();
   	 	}
		
		if(ae.getSource() == browse)
   	 	{
	   		 File encryptedFile;	   		 
	   		
	   		encryptedFile = showFileDialog(true);
	   		encryptedFilePath = encryptedFile.getAbsolutePath();
  
	   		int l = encryptedFilePath.lastIndexOf(".");
	   		encryptedFileExtension = encryptedFilePath.substring(l+1, encryptedFilePath.length());
   		 
	   		encryptedFilePathTextField.setText(encryptedFilePath); 	 
	   		 
	   		if(performDestaganography)
	   		{
	   			fileType = new String("Text");
	   			encryptedFileExtension = new String("txt");
	   		}
   	 	}
		
		if(ae.getSource() == saveAs)
   	 	{
			File outputFile;
   		 
   		 	outputFile = showFileDialog(false);
			String name = outputFile.getName();
			String ext = new String();
			ext = name.substring(name.lastIndexOf(".") + 1).toLowerCase();
			 
			if (!ext.equalsIgnoreCase(encryptedFileExtension)) 
			{
				outputFile = new File(outputFile.getAbsolutePath() +"."+ encryptedFileExtension);
			}
			 
			decryptedFilePath = outputFile.getAbsolutePath();
   		 	decryptedFilePathTextField.setText(decryptedFilePath);   	
   	 	}
		
		if(ae.getSource() == decrypt)
		{
			boolean validForm;
			validForm = isValidForm();
			
			if(validForm)
			{
				encryptionKey = new String(decryptionKeyPasswordField.getPassword());
				
				fileInfoObj.setEncryptedFilePath(encryptedFilePath);
				fileInfoObj.setDecryptedFilePath(decryptedFilePath);
				
				
				if(fileType.equals("Text"))
				{
					 encryptionKey = encryptionKey.substring(encryptionKey.length()-1);
					 System.out.println(encryptionKey);
					 fileInfoObj.setEncryptedFileKey(encryptionKey);
					TextDecryptionController decryptFile = new TextDecryptionController(fileInfoObj);
					boolean fileLoaded;
					
					wait = new WaitingDialog(this, 2);
					wait.setVisible(true);
					
					if(performDestaganography)
					{
						fileLoaded = decryptFile.loadSteganographedImage();
					}
					else
					{
						fileLoaded = decryptFile.loadEncryptedTextFile();
					}
						
					if(fileLoaded)
					{
						boolean keysMatch = decryptFile.compareKeys();
						if(keysMatch)
						{
							boolean performedDecryption = decryptFile.textDecryption();
							if(performedDecryption)
							{
								boolean fileSaved = decryptFile.fileSave();
								if(fileSaved)
								{
									wait.dispose();
									JOptionPane.showMessageDialog(this, "Decryption Completed\n Decrypted " + fileType +" File created at location: " + decryptedFilePath, "SUCCESS !!!", JOptionPane.INFORMATION_MESSAGE);
								}								
							}
							else
							{
								wait.dispose();
								JOptionPane.showMessageDialog(this, "Decryption not completed succesfully !!!", "ERROR !!!", JOptionPane.ERROR_MESSAGE);
							}
						}
						else
						{
							wait.dispose();
							JOptionPane.showMessageDialog(this, "You entered Wrong Key", "ERROR !!!", JOptionPane.ERROR_MESSAGE);
						}
					}
					else
					{
						wait.dispose();
						JOptionPane.showMessageDialog(this, "Cannot Load the Steganographed Image", "ERROR !!!", JOptionPane.ERROR_MESSAGE);
					}
				}
				
				if(fileType.equals("Audio") || fileType.equals("Video") || fileType.equals("Image"))
        		{
					fileInfoObj.setEncryptedFileKey(encryptionKey);
					
					DecryptImageAudioVideo decryptFile = new DecryptImageAudioVideo(fileInfoObj);
					boolean keyGenreated = decryptFile.convertStringKeyToSecretKey();
					
					wait = new WaitingDialog(this, 2);
					wait.setVisible(true);
					
					if(keyGenreated)
					{
						boolean  decryptionPerformed = decryptFile.decrypt();
						if(decryptionPerformed)
						{
							wait.dispose();
							JOptionPane.showMessageDialog(this, "Decryption Completed\n Decrypted " + fileType +" File created at location: " + decryptedFilePath, "SUCCESS !!!", JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							wait.dispose();
							JOptionPane.showMessageDialog(this, "You entered Wrong Key", "ERROR !!!", JOptionPane.ERROR_MESSAGE);
						}
					}
					else
					{
						wait.dispose();
						JOptionPane.showMessageDialog(this, "Please Enter a valid Key", "ERROR !!!", JOptionPane.ERROR_MESSAGE);
					}
        		}
			}
		}
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
			if(performDestaganography)
			{
				FileNameExtensionFilter extFileFilter = new FileNameExtensionFilter("Image Files (*.png)", "png");
				fc.setAcceptAllFileFilterUsed(false);
				fc.addChoosableFileFilter(extFileFilter);
			}
			else
			{
				FileNameExtensionFilter extFileFilter = new FileNameExtensionFilter("Image Files (*.jpg, *.png, *.gif, *.bmp)", "jpg" , "png", "gif" ,"bmp");
				fc.setAcceptAllFileFilterUsed(false);
				fc.addChoosableFileFilter(extFileFilter);
			}
			
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
		UserInfo userInfoTest = new UserInfo();
		userInfoTest.setUsername("Mohit");
		
		FileInfo fileInfoTest = new FileInfo();
		fileInfoTest.setPerformDestagonagraphy(true);
		fileInfoTest.setInputFileType("Image");
		
		DecryptionFileWindow test = new DecryptionFileWindow(userInfoTest, fileInfoTest);
		test.setVisible(true);
	}
}
