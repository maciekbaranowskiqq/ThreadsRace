import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JFrame;


public class Main {
	
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Panel panel = new Panel();
		frame.add(panel);
		frame.setSize(500,500);
		frame.setVisible(true);
		
	}

}
