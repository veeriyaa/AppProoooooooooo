import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Checkerboard extends JFrame{

	public Checkerboard() {
		JFrame checkerBoard = new JFrame();
		checkerBoard.setSize(1000, 1000);
		checkerBoard.setTitle("CheckerBoard");
		checkerBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		int row = 8;
		int col = 8;

		Container pane = checkerBoard.getContentPane();
		pane.setLayout(new GridLayout(row, col));

		Color checker;

		for (int x = 1; x <= (row * col); x++) {
			int altr = 0;
			altr = (x - 1) % col;
			altr += (x - 1) / col;

			if (altr % 2 == 0) {
				checker = Color.DARK_GRAY;
			} else {
				checker = Color.gray;
			}

			JPanel panel = new JPanel();
			//panel.setPreferredSize(new Dimension(10 / row, 10 / col));
			panel.setBackground(checker);
			pane.add(panel);

			checkerBoard.setVisible(true);
		}
	}
	public static void main(String[]args){
		Checkerboard a = new Checkerboard();
	}
}
