import javax.swing.JFrame;


public class TestGC extends JFrame {
	public TestGC(){
		ICEGround ground = new ICEGround();
		this.add(ground);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);
        setTitle("ICE GROUND NA JA ");
        setResizable(false);
        setVisible(true);
	}
	public static void main(String[]args){
		new TestGC();
	}
}
