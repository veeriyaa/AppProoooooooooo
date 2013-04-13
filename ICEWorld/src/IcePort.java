import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class IcePort extends JFrame {

	public IcePort() {
		getContentPane().setBackground(new Color(250, 240, 230));
		getContentPane().setForeground(new Color(244, 164, 96));
		getContentPane().setBackground(new Color(224, 255, 255));
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		//File
		JMenu mnFile = new JMenu("File");
		//menuBar.nHelp.setBackground(new Color(255, 255, 255));
		menuBar.add(mnFile);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mnFile.add(mntmNew);
		//NewEvent a = new NewEvent();
		//mntmNew.addActionListener(a);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		ExitEvent b = new ExitEvent ();
		mntmExit.addActionListener(b);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		AboutEvent d = new AboutEvent();
		mntmAbout.addActionListener(d);
		
		JMenuItem mntmHelp = new JMenuItem("Help ");
		mnHelp.add(mntmHelp);
		HelpEvent c = new HelpEvent();
		mntmHelp.addActionListener(c);
		 mntmHelp.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
		}
	public class ExitEvent implements ActionListener{
		public void actionPerformed(ActionEvent e){
            System.exit(0);		}
	}
	public class AboutEvent implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Image img = null;
			final JDialog about = new JDialog();
			about.setLayout(new BorderLayout());
			URL imgURL = getClass().getResource("/aboutpage.png");
			try {
				img = ImageIO.read(imgURL);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			JLabel imgLabel = new JLabel(new ImageIcon(img));
			about.setTitle("Members of");

			about.getContentPane().add(imgLabel, BorderLayout.CENTER);
			about.setSize(700,526);
			about.setLocationRelativeTo(null);
			about.pack();
			about.setVisible(true);
			
		}
		
	}
			/*BufferedImage img = null;
			try {
				img = ImageIO.read(new File("aboutpage.png"));
			} catch (IOException e1) {
				

			}
			
			JLabel imgLabel = new JLabel(new ImageIcon(img));

			d.getContentPane().add(imgLabel, BorderLayout.CENTER);
			d.add(imgLabel);

		}
	
	}*/

	/*
	 * try { FileInputStream in = new FileInputStream("aboutpage.png"); Image i
	 * = ImageIO.read(in); } catch (IOException e1) { e1.printStackTrace();
	 * 
	 * }
	 */

	/*
	 * Image img = null; final JDialog mntmAbout = new JDialog();
	 * mntmAbout.setLayout(new BorderLayout()); //URL imgURL =
	 * getClass().getResource("aboutpage.png"); try { Image image =
	 * Image.createImage ("/aboutpage.png");
	 * 
	 * 
	 * } catch (IOException e1) { System.out.println(e1.toString()); }
	 */

	public class HelpEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(new JFrame(), "PLEASE", "HELP!",
					JOptionPane.PLAIN_MESSAGE);
		}
	}

	public static void main(String[] args) {
		IcePort gui = new IcePort();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
		gui.setTitle("ICE WORLD PORT");
		gui.setSize(1000, 1000);

	}
}
