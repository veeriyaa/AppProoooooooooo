import java.awt.*;

import javax.swing.*;

public class Character{
	int x,y,dx,dy;
	Image img;
	public Character(){
		ImageIcon dummy = new ImageIcon("dummy.png");
		img = dummy.getImage();
		x = 20;y=20;
	}
}