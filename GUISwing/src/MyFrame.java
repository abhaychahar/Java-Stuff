import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Color;

public class MyFrame extends JFrame {
	
	public MyFrame() {
		// GUI window to add components to
		this.setSize(800, 600); // set x-dimension and y-dimension of frame
		this.setVisible(true); // make frame visible
		this.setTitle("My GUI"); // set title of frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit application on close instead of hiding it
		this.setResizable(false); // prevent frame from being resized
		
		ImageIcon logo=new ImageIcon("src/Images/Logo.png"); // create image icon
		this.setIconImage(logo.getImage()); // set icon of frame
		
		this.getContentPane().setBackground(new Color(173, 95, 157)); // set background color of frame		
	}
	
}