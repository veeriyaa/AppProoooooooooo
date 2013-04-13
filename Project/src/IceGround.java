import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class IceGround extends JPanel implements Runnable{
	Character c;
	Image bg;
	int targetX=20,targetY=20;
	Thread thread;
	Boolean active = true;
	
	
	
	public IceGround() {
		//setBackground(Color.BLACK);
		
		c = new Character();
		ImageIcon btemp = new ImageIcon("2D.png");
		bg = btemp.getImage();
		init();
		addMouseListener(new Clicka());
	}
	public void paint(Graphics g){
		super.paint(g);
		g.drawImage(bg,0,0,null);
		g.drawImage(c.img, c.x, c.y, null);
	}
	public void init(){
		System.out.println("init");
		Thread t = new Thread(this);
		t.start();
	}
	
	class Clicka implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
			targetX = e.getX();
			targetY = e.getY();
			//move(e.getX(),e.getY());
			System.out.println("X :"+targetX);
			System.out.println("Y :"+targetY);
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	@Override
	public void run() {
		
		while(true){
			if(targetX - c.x >0){
				//move right
				c.x++;
			}else if (targetX - c.x < 0){
				//move left
				c.x--;
			}else if (targetX - c.x == 0){
				if(targetY -c.y >0){
				//move down
				c.y++;
			}else if(targetY - c.y < 0){
				//move up
				c.y--;
			}
			}
			
			
			
			
			repaint();
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
