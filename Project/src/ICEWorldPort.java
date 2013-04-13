import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.Font;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import iceworld.given.*;


public class ICEWorldPort extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ICEWorldPort frame = new ICEWorldPort();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws MalformedURLException 
	 */
	public ICEWorldPort() throws MalformedURLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 550);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mnFile.add(mntmQuit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmViewHelp = new JMenuItem("View help");
		mntmViewHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mnHelp.add(mntmViewHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		desktopPane.setBounds(0, 0, 872, 480);
		contentPane.add(desktopPane);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(238, 252, 311, 20);
		desktopPane.add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(238, 204, 311, 20);
		desktopPane.add(textField);
		textField.setColumns(10);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.setBounds(599, 204, 111, 68);
		desktopPane.add(btnLogIn);
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnLogInAs = new JButton("Log in as Alien");
		btnLogInAs.setBounds(238, 304, 156, 35);
		desktopPane.add(btnLogInAs);
		btnLogInAs.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblPassword = new JLabel("Password:\r\n");
		lblPassword.setBounds(140, 252, 69, 17);
		desktopPane.add(lblPassword);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(140, 201, 69, 23);
		desktopPane.add(lblUsername);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblBackground = new JLabel("Background");
		lblBackground.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\IMG_1941.jpg"));
		lblBackground.setBounds(31, 126, 228, 48);
		desktopPane.add(lblBackground);
		btnLogIn.addActionListener(new Action());
		btnLogInAs.addActionListener(new Action());
	}
	class Action implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			MyIcetizenP3V user = new MyIcetizenP3V();
			user.setIcePortID(250);
			//the listening port # shouldn't repeat. Will implement more later
			user.setListeningPort(12345);
			ICEWorldImmigration immi = new ICEWorldImmigration(user);
			
			//Log in as an inhabitant
			if(b.getText().equals("Log in")){
				String username = textField.getText();
				char[] pass = passwordField.getPassword();
				String s="";
				for(int i=0;i<pass.length;i++){
					s=s+pass[i];
				}
				user.setUsername(username);
				System.out.println(username);
				System.out.println(pass);
				if(immi.login(s)){
					//id pass, enter the ICE World
					immi.walk(40, 30);
					JOptionPane.showMessageDialog(contentPane, "BLAAAAA");
					System.out.println("walked");
					IcetizenLook a = new IcetizenLook();
					a.gidB = "B004";
					a.gidH = "H069";
					a.gidS = "S025";
					a.gidW = "W057";
					
					boolean ba = immi.customization(a);
					System.out.println(ba);
				}
				else{
					JOptionPane.showMessageDialog(contentPane, "Error");
				}
			}else{
				if(immi.loginAlien()){
					//enter ICE World as Alien
					JOptionPane.showMessageDialog(contentPane, "Alien");
				}else{
					//Pop-up dialog - error connecting with system
					JOptionPane.showMessageDialog(contentPane, "BLAAAAA");
				}
			}
		}
	}
}
