import javax.swing.JLabel;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class MyLabel extends JLabel {
	
	public MyLabel(MyFrame frame) {
		// Label is a GUI display area for a string, an image or both
		
		frame.add(this);
		
		this.setText("Do you love to code ?"); // Set text of label
		ImageIcon labelImage=new ImageIcon("src/Images/Label_Image.png");
		this.setIcon(labelImage);
		this.setHorizontalTextPosition(JLabel.CENTER); // Set text LEFT, RIGHT, or CENTER of image icon horizontally
		this.setVerticalTextPosition(JLabel.TOP); // Set text TOP, BOTTOM, or CENTER of image icon vertically
		this.setForeground(Color.CYAN); // Set color of text
		this.setFont(new Font("MV Boli", Font.PLAIN, 20)); // Set font of text
		
		Border border=BorderFactory.createLineBorder(Color.CYAN, 3); // Create border
		
		this.setBorder(border); // Set border for label
		this.setVerticalAlignment(JLabel.CENTER); // Set vertical position of text and image within label
		this.setHorizontalAlignment(JLabel.CENTER); // Set horizontal position of text and image within label
		
		// Label takes up as much space as possible by default
		
		frame.setLayout(null); // To set bounds for label
		this.setBounds(200, 0, 400, 250); // Set (x, y) for top left corner of label, and width and height of label within frame  
	}
	
}