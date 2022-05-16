import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class cards extends JPanel {

	/**
	 * Create the panel.
	 */
	public JLabel setimage(String path) {
		JLabel imgLabel = new JLabel(new ImageIcon(path));
		this.add(imgLabel);
		imgLabel.setBounds(0, 0, 300, 300);
		imgLabel.setText("");
		return imgLabel;
		
	}
	public JLabel setDetails(String modele) {
		JLabel detail = new JLabel();
		this.add(detail);
		detail.setBounds(0,310,100,20);
		detail.setText(modele);
		return detail;
		
	}
	

}
