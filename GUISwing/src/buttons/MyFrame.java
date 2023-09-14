package buttons;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class MyFrame extends JFrame implements ActionListener {
	
	JButton button; // Instantiation of button
	JLabel label;
	
	MyFrame() {
		ImageIcon buttonIcon=new ImageIcon("src/buttons/Frame_Logo.png");
		ImageIcon labelIcon=new ImageIcon("src/buttons/Label_Image.png");
		
		label=new JLabel();
		label.setIcon(labelIcon);
		label.setBounds(300, 300, 400, 400);
		label.setVisible(false);
		
		button=new JButton(); // Create button
		button.setBounds(300, 50, 200, 150); // Set x, y, width, and height of button
		button.addActionListener(this); // Add action listener to button
		button.setText("CLick Me"); // Set text of button
		button.setFocusable(false); // Remove ugly border around button text
		button.setIcon(buttonIcon);
		button.setVerticalTextPosition(JButton.BOTTOM); // Set vertical position of button text 
		button.setHorizontalTextPosition(JButton.CENTER); // Set horizontal position of button text
		button.setFont(new Font("Comic Sans", Font.BOLD, 25)); // Set font type, style, and size of button text
		button.setForeground(Color.cyan); // Set color of button text
		button.setBackground(Color.lightGray); // Set background color of button
		button.setBorder(BorderFactory.createEtchedBorder()); // Set border type for button
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(800, 800);
		this.setVisible(true);
		this.add(button); // Add button to frame
		this.add(label);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) { 
			// System.out.println("Clicked"); // Print to console when button is clicked
			// button.setEnabled(false); // Disable button after one click
			label.setVisible(true); // Show label when button is clicked
		}
	}
	
}
