import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Color;

public class MyFrame extends JFrame {
	
	public MyFrame() {
		// Frame is a GUI window to add components to
		
		this.setSize(800, 800); // Set x-dimension and y-dimension of frame
		this.setVisible(true); // Make frame visible
		this.setTitle("My GUI"); // Set title of frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit application on close instead of hiding it
		this.setResizable(false); // Prevent frame from being resized
		
		ImageIcon frameLogo=new ImageIcon("src/Images/Frame_Logo.png"); // Create image icon
		this.setIconImage(frameLogo.getImage()); // Set icon of frame
		
		this.getContentPane().setBackground(new Color(173, 95, 157)); // Set background color of frame		
	}
	
}