import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;




public class IceWorldGUI extends IcePort {
	private JTextField textField;
	private JPanel panel_2;
	JSlider BGSound;
	BGsound sound;
	public IceWorldGUI() {
		sound = new BGsound("bgSound.wav");
		setTitle("P3V");
		getContentPane().setLayout(new GridLayout(1, 2, 0, 0));

		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(3, 1, 0, 0));
		// window
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout());
		
		panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout());
		
		textField = new JTextField();
		textField.setBounds(6, 46, 485, 35);
		panel_2.add(textField, BorderLayout.SOUTH);
		textField.setColumns(10);
		
		
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout (2,1,0,0));
		
		
		
		JButton btnTalk = new JButton("TALK");
		panel_3.add(btnTalk);
	
		
		JButton btnYell = new JButton("YELL");
		panel_3.add(btnYell);
		
		
		JButton btnFile = new JButton("FILE TRANSFORM");
		panel_3.add(btnFile);
		btnFile.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		

		JButton btnSound = new JButton("SOUND");
		panel_3.add(btnSound);
		SoundEvent a = new SoundEvent ();
		btnSound.addActionListener(a);
		
		
		JButton btnRefreshInterval = new JButton("REFRESH INTERVAL");
		btnRefreshInterval.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		panel_3.add(btnRefreshInterval);
		

		JButton btnCustomization = new JButton("CUSTOMIZATION");
		btnCustomization.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		panel_3.add(btnCustomization);
		

	}
	//SoundEvent: open new dialog with JSlider inside.
	public  class SoundEvent implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			JDialog dialog = new JDialog();
			BGSound = new JSlider( 0, 100, 50);
			BGSound.setMajorTickSpacing(10);
			BGSound.setPaintTicks(true);
			dialog.add(BGSound);
			
			event slide = new event();
			BGSound.addChangeListener(slide);
			
			
			dialog.setLocationRelativeTo(null);
			dialog.pack();
			dialog.setVisible(true);
			
		}
	}
	public class event implements ChangeListener{
		@Override
		public void stateChanged(ChangeEvent e){
			
			
			int value = BGSound.getValue();
			if(value <10){
				sound.increase();				
			}else sound.decrease();
			
		}
	}
	

	
	public static void main(String[] args) {
		IceWorldGUI gui = new IceWorldGUI();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);

		gui.setSize(1000, 1000);

	}
}
