import javax.swing.JLabel;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class Main {
	
	public static void main(String[] args) {
		MyFrame frame=new MyFrame(); // Create frame
		
		// Label is a GUI display area for a string, an image or both
		
		JLabel label=new JLabel(); // Create label
		frame.add(label);
		label.setText("Do you love to code ?"); // Set text of label
		ImageIcon labelImage=new ImageIcon("src/Images/Label_Image.png");
		label.setIcon(labelImage);
		label.setHorizontalTextPosition(JLabel.CENTER); // Set text LEFT, RIGHT, or CENTER of image icon horizontally
		label.setVerticalTextPosition(JLabel.TOP); // Set text TOP, BOTTOM, or CENTER of image icon vertically
		label.setForeground(Color.CYAN); // Set color of text
		label.setFont(new Font("MV Boli", Font.PLAIN, 20)); // Set font of text
		
		Border border=BorderFactory.createLineBorder(Color.CYAN, 3); // Create border
		
		label.setBorder(border); // Set border for label
		label.setVerticalAlignment(JLabel.CENTER); // Set vertical position of text and image within label
		label.setHorizontalAlignment(JLabel.CENTER); // Set horizontal position of text and image within label
		
		// Label takes up as much space as possible by default
		
		frame.setLayout(null);
		label.setBounds(200, 0, 400, 250); // Set (x, y) for top left corner of label, and width and height of label within frame  
		
	}
	
}