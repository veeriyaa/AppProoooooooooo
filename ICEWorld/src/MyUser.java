import iceworld.given.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class MyUser extends MyIcetizenP3V {
	MyIcetizenP3V user = new MyIcetizenP3V();
	BufferedImage avatar;

	// could pass on uid from the log-in as a parameter to create the user's
	// avatar
	public MyUser() {
		super();
		// set up dummy user
		user.setIcePortID(250);
		user.setUsername("Veeriya.R");
		user.setUserID(37);
		user.setPosition(new Point(100, 100));
		ICEWorldImmigration i = new ICEWorldImmigration(user);
		i.login("7987020");
		
		try {
			setAvatar();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setAvatar() throws MalformedURLException {
		ICEWorldStates test = new ICEWorldStates();
		
		IcetizenLook look = test.getLook((user.getUserID()));
		try {
			BufferedImage avatar = test.getPic(look);
			//avatar = new BufferedImage(150,150,BufferedImage.TYPE_INT_ARGB);
			Graphics g = avatar.getGraphics();
			g.drawImage(avatar,0,0,150,150,null);
			//ImageIcon h = new ImageIcon("halo.png");
			//Image halo =  h.getImage();
			//g.drawImage(halo,0,0,150,50,null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// Method : Get the icetizen icon, merge the icon with the identifier
}
