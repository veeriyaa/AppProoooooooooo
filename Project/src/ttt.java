import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class ttt {
	public static void main(String [] args){
		JFrame a = new JFrame();
		a.setSize(1000,1000);
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		a.setVisible(true);
		SwingUtilities.updateComponentTreeUI(a);
	}

	public class IceGround extends JPanel{
		public void init(){
			Dimension dim = this.getSize();
			int w = dim.width/100;
			int h = dim.height/100;
			this.setBackground(Color.cyan);
			this.setLayout(new GridLayout(100,100));
			
		}
	}

}
