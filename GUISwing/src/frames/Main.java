package frames;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Main {
	
	public static void main(String[] args) {
		// Frame is a GUI window to add components to
		
		JFrame frame=new JFrame(); // Create frame
		
		frame.setSize(800, 800); // Set x-dimension and y-dimension of frame
		frame.setVisible(true); // Make frame visible
		frame.setTitle("My GUI"); // Set title of frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit application on close instead of hiding it
		frame.setResizable(false); // Prevent frame from being resized
				
		ImageIcon frameLogo=new ImageIcon("src/frames/Frame_Logo.png"); // Create image icon
		frame.setIconImage(frameLogo.getImage()); // Set icon of frame
		
		frame.getContentPane().setBackground(Color.PINK); // Set background color of frame
	}
}
