package cryptomaster.encryption;

import java.awt.image.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.imageio.*;

import cryptomaster.encryptdecryptutility.EncryptionFileWindow;
import cryptomaster.model.FileInfo;
import cryptomaster.model.UserInfo;

class EmbedMessage extends JFrame implements ActionListener 
{
	private static final long serialVersionUID = 1L;
	JButton open = new JButton("Open");
	JButton embed = new JButton("Embed");
	JButton save = new JButton("Save into new file");
	JButton reset = new JButton("Reset");
	BufferedImage sourceImage = null, embeddedImage = null;
	JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	JScrollPane originalPane = new JScrollPane(), embeddedPane = new JScrollPane();

	String stegmess;
	String encryptionKey;
	String sentEmailId;
	
	UserInfo userInfoObj = new UserInfo();
	FileInfo fileInfoObj = new FileInfo();
	
	public EmbedMessage(UserInfo userInfo,FileInfo fileInfo,String mess) 
	{
		setTitle("Perform Steganography");
		setLocation(300,100);
    	setSize(750,500);
    	setResizable(true);
    	//this.setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());
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
        
		JPanel p = new JPanel(new FlowLayout());
		p.add(open);
		p.add(embed);
		p.add(save);
		p.add(reset);
		
		getContentPane().add(p, BorderLayout.SOUTH);
		
		sp.setLeftComponent(originalPane);
		sp.setRightComponent(embeddedPane);
		
		originalPane.setBorder(BorderFactory.createTitledBorder("Original Image"));
		embeddedPane.setBorder(BorderFactory.createTitledBorder("Steganographed Image"));
		
		getContentPane().add(sp, BorderLayout.CENTER);		
		
		setVisible(true);
		
		sp.setDividerLocation(0.5);
		
		validate();
	
		open.addActionListener(this);
		embed.addActionListener(this);
		save.addActionListener(this);
		reset.addActionListener(this);
		
		embed.setEnabled(false);
		save.setEnabled(false);
		
		userInfoObj = userInfo;
		sentEmailId = userInfo.getReciverEmailId();
		
		fileInfoObj = fileInfo;
		stegmess = mess;
		encryptionKey = fileInfoObj.getEncryptedFileKey();		
	}

	public void actionPerformed(ActionEvent ae) 
	{
		Object o = ae.getSource();
		if (o == open)
		{
			openImage();
			
		}		
		else if (o == embed)
		{
			embedMessage();
			save.setEnabled(true);
		}		
		else if (o == save)
			saveImage();
		else if (o == reset)
		{
			embed.setEnabled(false);
			save.setEnabled(false);
			resetInterface();
		}
			
	}

	private File showFileDialog(final boolean open) 
	{
		JFileChooser fc = new JFileChooser("Open an image");
		FileFilter ff = new FileFilter() 
		{
			public boolean accept(File f) 
			{
				String name = f.getName().toLowerCase();
				if (open)
					return f.isDirectory() || name.endsWith(".jpg")
							|| name.endsWith(".jpeg") || name.endsWith(".png")
							|| name.endsWith(".gif") || name.endsWith(".tiff")
							|| name.endsWith(".bmp") || name.endsWith(".dib");
				
				return f.isDirectory() || name.endsWith(".png") || name.endsWith(".bmp");
			}

			public String getDescription()
			{
				if (open)
					return "Image (*.jpg, *.jpeg, *.png, *.gif, *.tiff, *.bmp, *.dib)";
				return "Image (*.png, *.bmp)";
			}
		};
		fc.setAcceptAllFileFilterUsed(false);
		fc.addChoosableFileFilter(ff);

		File f = null;
		if (open && fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
			f = fc.getSelectedFile();
		else if (!open && fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
			f = fc.getSelectedFile();
		if(f!=null)
		{
			embed.setEnabled(true);
		}
		else
		{
			JOptionPane.showMessageDialog(this,"Please select an Image file", "File not selected",JOptionPane.ERROR_MESSAGE);
		}
		return f;
	}

	private void openImage() {
		File f = showFileDialog(true);
		try {
			sourceImage = ImageIO.read(f);
			JLabel l = new JLabel(new ImageIcon(sourceImage));
			originalPane.getViewport().add(l);
			this.validate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void embedMessage() 
	{
		String mess = stegmess;
		embeddedImage = sourceImage.getSubimage(0, 0, sourceImage.getWidth(),
				sourceImage.getHeight());
		embedMessage(embeddedImage, mess);
		JLabel l = new JLabel(new ImageIcon(embeddedImage));
		embeddedPane.getViewport().add(l);
		this.validate();
	}

	private void embedMessage(BufferedImage img, String mess) {
		int messageLength = mess.length();

		int imageWidth = img.getWidth(), imageHeight = img.getHeight(), imageSize = imageWidth
				* imageHeight;
		if (messageLength * 8 + 32 > imageSize) {
			JOptionPane.showMessageDialog(this,
					"Message is too long for the chosen image",
					"Message too long!", JOptionPane.ERROR_MESSAGE);
			return;
		}
		embedInteger(img, messageLength, 0, 0);

		byte b[] = mess.getBytes();
		for (int i = 0; i < b.length; i++)
			embedByte(img, b[i], i * 8 + 32, 0);
	}

	private void embedInteger(BufferedImage img, int n, int start,
			int storageBit) {
		int maxX = img.getWidth(), maxY = img.getHeight(), startX = start
				/ maxY, startY = start - startX * maxY, count = 0;
		for (int i = startX; i < maxX && count < 32; i++) {
			for (int j = startY; j < maxY && count < 32; j++) {
				int rgb = img.getRGB(i, j), bit = getBitValue(n, count);
				rgb = setBitValue(rgb, storageBit, bit);
				img.setRGB(i, j, rgb);
				count++;
			}
		}
	}

	private void embedByte(BufferedImage img, byte b, int start, int storageBit) {
		int maxX = img.getWidth(), maxY = img.getHeight(), startX = start
				/ maxY, startY = start - startX * maxY, count = 0;
		for (int i = startX; i < maxX && count < 8; i++) {
			for (int j = startY; j < maxY && count < 8; j++) {
				int rgb = img.getRGB(i, j), bit = getBitValue(b, count);
				rgb = setBitValue(rgb, storageBit, bit);
				img.setRGB(i, j, rgb);
				count++;
			}
		}
	}

	private void saveImage() {
		if (embeddedImage == null) {
			JOptionPane.showMessageDialog(this,
					"No message has been embedded!", "Nothing to save",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		File f = showFileDialog(false);
		String name = f.getName();
		String ext = name.substring(name.lastIndexOf(".") + 1).toLowerCase();
		if (!ext.equals("png") && !ext.equals("bmp") && !ext.equals("dib")) 
		{
			ext = "png";
			f = new File(f.getAbsolutePath() + ".png");
		}
		try {
			if (f.exists())
				f.delete();
			ImageIO.write(embeddedImage, ext.toUpperCase(), f);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(this,"Encryption and Steganography is done!!\n" + "Email was sent to: " +sentEmailId+ "\nSteganographed Image stored at location: " + f.getAbsolutePath() + "\nYour Key: " + encryptionKey, "SUCCESS !!!",JOptionPane.INFORMATION_MESSAGE);
		
		EncryptionFileWindow goToPreviousScreen = new EncryptionFileWindow(userInfoObj, fileInfoObj);
		goToPreviousScreen.setVisible(true);
		dispose();
	}

	private void resetInterface() {
		originalPane.getViewport().removeAll();
		embeddedPane.getViewport().removeAll();
		sourceImage = null;
		embeddedImage = null;
		sp.setDividerLocation(0.5);
		this.validate();
	}

	private int getBitValue(int n, int location) {
		int v = n & (int) Math.round(Math.pow(2, location));
		return v == 0 ? 0 : 1;
	}

	private int setBitValue(int n, int location, int bit) {
		int toggle = (int) Math.pow(2, location), bv = getBitValue(n, location);
		if (bv == bit)
			return n;
		if (bv == 0 && bit == 1)
			n |= toggle;
		else if (bv == 1 && bit == 0)
			n ^= toggle;
		return n;
	}

	public static void main(String arg[]) 
	{
		UserInfo testInfo = new UserInfo();
		testInfo.setReciverEmailId("mohitssj10@gmail.com");	
		
		FileInfo testFileInfo = new FileInfo();
		testFileInfo.setEncryptedFileKey("123456");
		String text = "Hi, I am Mohit";
		
		@SuppressWarnings("unused")
		EmbedMessage test = new EmbedMessage(testInfo,testFileInfo,text);
	
	}
}
