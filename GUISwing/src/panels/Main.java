package panels;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {
		// Panel is a GUI component that functions as a container to hold other components
		
		JLabel label=new JLabel();
		label.setText("Hi");
		label.setBackground(Color.pink);
		label.setOpaque(true);
		label.setBounds(50, 50, 200, 100);
		
		JPanel redPanel=new JPanel(); // Create panel
		redPanel.setBackground(Color.red); // Set background color of panel
		redPanel.setBounds(0, 0, 250, 250); // Set (x, y) for top left corner of panel, and width and height of label within frame
		
		JPanel bluePanel=new JPanel();
		bluePanel.setBackground(Color.blue);
		bluePanel.setBounds(250, 0, 250, 250);
		
		JPanel greenPanel=new JPanel();
		greenPanel.setBackground(Color.green);
		greenPanel.setBounds(0, 250, 500, 250);
		greenPanel.setLayout(null);
		
		JFrame frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.setVisible(true);
		frame.setLayout(null);
		greenPanel.add(label); // Add label to panel
		frame.add(redPanel); // Add panel to frame
		frame.add(bluePanel);
		frame.add(greenPanel);
	}
	
}
