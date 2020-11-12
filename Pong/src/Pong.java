import javax.swing.JFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class Pong extends JFrame {
	
	/*Update code to use final static variables for the window title, 
	 *width, and height. Set the width to 800, the height to 600, and the title to “Pong”. 
	 *Replace the values in the method calls in the constructor with these variables. 
	 *The variables are all upper case with a descriptive name.
	*/
	
	private static final int WINDOW_WIDTH = 800; 
	private static final int WINDOW_HEIGHT = 600;
	private static final String WINDOW_TITLE = "Pong";
	private static final Color BACKGROUND_COLOR = Color.BLACK;
	
	public Pong() {
    	setTitle(WINDOW_TITLE);
    	setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    	setResizable(false);
    	setVisible(true);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
    	add(new PongPanel());
	}
	
	public class PongPanel extends JPanel implements ActionListener, KeyListener {
		
		public PongPanel() {
	          setBackground(BACKGROUND_COLOR);
	      }
		
		@Override
		public void keyTyped(KeyEvent event) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent event) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent event) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			
		}
		  
	 }

	public static void main(String[] args) {
		new Pong();
		
	}
}
