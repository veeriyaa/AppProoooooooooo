import javax.swing.JFrame;


public class test extends JFrame {
	
	test(){
		setSize(500,500);
		setContentPane(new TEST());
		setVisible(true);
	}
	public static void main(String[]args){
		test t = new test();
	}

}
