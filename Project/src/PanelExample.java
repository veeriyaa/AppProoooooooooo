import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class PanelExample {
	private void createAndDisplayGUI() {
		JFrame frame = new JFrame("Panel Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPane = new JPanel();
		contentPane.setOpaque(true);
		contentPane.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5,
				Color.WHITE));
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(new BorderLayout(10, 10));
		ImagePanel imagePanel = new ImagePanel();
		// imagePanel.createGUI();
		// BlankPanel blankPanel = new BlankPanel();
		// contentPane.add(blankPanel, BorderLayout.LINE_START);
		contentPane.add(imagePanel, BorderLayout.CENTER);
		frame.setContentPane(contentPane);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new PanelExample().createAndDisplayGUI();
			}
		});
	}
}

class ImagePanel extends JPanel {
	private BufferedImage image;

	public ImagePanel() {
		setOpaque(true);
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		try {
			image = ImageIO
					.read(new URL(
							"http://www.wallpaperpimper.com/wallpaper/Art_&_3D/Space/Sky-Splash-1-A1IDO4UVVJ-1600x1200.jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		createGUI();
	}

	public void createGUI() {
		setLayout(new GridBagLayout());
		JPanel loginPanel = new JPanel();
		loginPanel.setOpaque(false);
		loginPanel.setLayout(new GridLayout(2, 2, 2, 2));
		JLabel userLabel = new JLabel("USERNAME : ");
		userLabel.setForeground(Color.WHITE);
		JTextField userField = new JTextField(10);
		JLabel passLabel = new JLabel("PASSWORD : ");
		passLabel.setForeground(Color.WHITE);
		JPasswordField passField = new JPasswordField(10);
		loginPanel.add(userLabel);
		loginPanel.add(userField);
		loginPanel.add(passLabel);
		loginPanel.add(passField);
		add(loginPanel);
		System.out.println("I am finished");
	}

	@Override
	public Dimension getPreferredSize() {
		return (new Dimension(1600, 1200));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	}
}