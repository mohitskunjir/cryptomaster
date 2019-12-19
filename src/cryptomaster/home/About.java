package cryptomaster.home;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class About extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private javax.swing.JButton close;
    private javax.swing.JLabel contact;
    private javax.swing.JLabel developers;
    private javax.swing.JLabel email;
    private javax.swing.JLabel headLabel;
    private javax.swing.JLabel mayuri;
    private javax.swing.JLabel mohit;
    private javax.swing.JLabel mokshada;
    private javax.swing.JLabel mrunal;
    private javax.swing.JLabel name;
    private javax.swing.JLabel ver;
    
	public About()
	{
		setTitle("About");
    	setLocation(300,100);
        setSize(750,550);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new java.awt.Color(240,240,240)); 
        
        try 
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) 
            {
                if ("Nimbus".equals(info.getName())) 
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
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
        catch (javax.swing.UnsupportedLookAndFeelException ex) 
        {
           
        }
        
		headLabel = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        ver = new javax.swing.JLabel();
        developers = new javax.swing.JLabel();
        mohit = new javax.swing.JLabel();
        mayuri = new javax.swing.JLabel();
        mrunal = new javax.swing.JLabel();
        mokshada = new javax.swing.JLabel();
        contact = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        close = new javax.swing.JButton();
        
        
        headLabel.setIcon(new javax.swing.ImageIcon("project images\\My store\\home\\enc2.jpg")); // NOI18N

        name.setFont(new java.awt.Font("Papyrus", 1, 40)); // NOI18N
        name.setForeground(java.awt.Color.red);
        name.setText("CryptoMaster");

        ver.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ver.setText("Ver: 1.0");

        developers.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        developers.setText("Developed By:");

        mohit.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        mohit.setText("Mohit Kunjir");

        mayuri.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        mayuri.setText("Mayuri Ingole");

        mrunal.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        mrunal.setText("Mrunal Kshirsagar");

        mokshada.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        mokshada.setText("Mokshada Birari");

        contact.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        contact.setText("Contact Us:");

        email.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        email.setText("cryptomaster1113@gmail.com");

        close.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        close.setText("Close");
        close.addActionListener(this);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 238, Short.MAX_VALUE)
                .addComponent(name)
                .addGap(227, 227, 227))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(mokshada)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(mrunal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(email))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(mayuri)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(contact)
                                .addGap(47, 47, 47))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(341, 341, 341)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(close)
                            .addComponent(ver))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(70, 70, 70))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(headLabel)
                .addGap(267, 267, 267))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(developers)
                .addGap(18, 18, 18)
                .addComponent(mohit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(headLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ver)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(developers)
                            .addComponent(mohit))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mayuri)
                            .addComponent(contact))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mrunal)
                            .addComponent(email))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mokshada)
                        .addContainerGap(34, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(close)
                        .addContainerGap())))
        );
	}

	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource() == close)
		{
			dispose();
			HomePage goToHome = new HomePage();
			goToHome.setVisible(true);
		}
		
	}
	
	public static void main(String args[])
	{
		About about = new About();
		about.setVisible(true);
	}

}
