import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class ICEGround extends JPanel implements Runnable {
	Character c;
	MyUser me;
	Image bg;
	int targetX = 20, targetY = 20;
	Thread thread;
	Boolean active = true;

	public ICEGround() {
		init();
		ImageIcon btemp = new ImageIcon("2D.png");
		bg = btemp.getImage();
		init();
		addMouseListener(new Clicka());
	}
	public void paint(Graphics g) {
		super.paint(g);
		// change the position : add the offsets
		
		g.drawImage(bg,0,0,null);
		g.drawImage(me.avatar, me.user.position.x, me.user.position.x, null);
	}

	public void init() {
		me = new MyUser();
		System.out.println("init");
		Thread t = new Thread(this);
		t.start();
		
		
	}

	class Clicka implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

			targetX = e.getX();
			targetY = e.getY();
			// move(e.getX(),e.getY());
			System.out.println("X :" + targetX);
			System.out.println("Y :" + targetY);

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

	}

	@Override
	public void run() {

		while (true) {
			// move horizontally before vertically
			if (targetX - me.user.position.x > 0) {
				// move right
				System.out.print("Old X : "+me.user.position.x);
				me.user.position.x++;
				System.out.println("     New X :  "+me.user.position.x);
				
			} else if (targetX - me.user.position.x < 0) {
				// move left
				System.out.print("Old X : "+me.user.position.x);
				me.user.position.x--;
				System.out.println("     New X :  "+me.user.position.x);
				
			}/* else if (targetX - me.user.position.x == 0) {
				if (targetY - me.user.position.y > 0) {
					// move down
					System.out.print("Old Y : "+me.user.position.y);
					me.user.position.y++;
					System.out.println("     New Y :  "+me.user.position.y);
				} else if (targetY - me.user.position.y < 0) {
					// move up
					System.out.print("Old X : "+me.user.position.y);
					me.user.position.y--;
					System.out.println("     New Y :  "+me.user.position.y);
				}
			}*/
			repaint();
			try {
				//walking rate (fps)/1000
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
