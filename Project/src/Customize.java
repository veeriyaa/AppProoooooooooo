import iceworld.given.ICEWorldImmigration;
import iceworld.given.IcetizenLook;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


import javax.imageio.ImageIO;
import javax.swing.*;


public class Customize extends JPanel{
	public static void main(String[]args) throws IOException{
		JFrame IceGround = new JFrame();
		IceGround.setSize(1000, 1000);
		IceGround.setTitle("IceGround");
		IceGround.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyIcetizenP3V user = new MyIcetizenP3V();
		user.setIcePortID(250);
		user.setListeningPort(12345);
		user.setUsername("Veeriya.R");
		ICEWorldImmigration immi = new ICEWorldImmigration(user);
		immi.login("7987020");
		IcetizenLook a = new IcetizenLook();
		a.gidB = "B003";
		a.gidH = "H011";
		a.gidS = "S025";
		a.gidW = "W057";
		user.setIcetizenLook(a);
		boolean asdf = immi.customization(a);
	
		
		String add = TestState.getAdd(a.gidS);
		
		
		String s = TestState.getAdd(a.gidW);
		System.out.println(add.substring(45,71));
		System.out.println(s.substring(45,69));
		
		//ImageIcon file = new ImageIcon("dfasd");
		/*ImageIcon file  = new ImageIcon("spongebob.jpg");
		JLabel t = new JLabel(file);
		IceGround.add(t);
		BufferedImage f = ImageIO.read(new URL("http://pic.free.in.th/id/3be6b03ce7c4935a83edf22a8e468a14"));
		JPanel fi = new JPanel();*/
		// use gresources, gid to get the pic of the icetizen
		IceGround.setVisible(true);
	}
}
