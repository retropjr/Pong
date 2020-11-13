import javax.swing.JFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Pong extends JFrame {
	
	/*Update code to use final static variables for the window title, 
	 *width, and height. Set the width to 800, the height to 600, and the title to “Pong”. 
	 *Replace the values in the method calls in the constructor with these variables. 
	 *The variables are all upper case with a descriptive name.
	*/
	
	private static final int WINDOW_WIDTH = 800; 
	private static final int WINDOW_HEIGHT = 600;
	private static final String WINDOW_TITLE = "Pong";
	
	
	public Pong() {
    	setTitle(WINDOW_TITLE);
    	setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    	setResizable(false);
    	setVisible(true);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
    	add(new PongPanel());
	}
	
	public static class PongPanel extends JPanel implements ActionListener, KeyListener {
		
		private final static Color BACKGROUND_COLOUR = Color.BLACK;
		private final static int TIMER_DELAY = 5;
		
		public PongPanel() {
	         
	          setBackground(BACKGROUND_COLOUR);
	          Timer timer = new Timer(TIMER_DELAY, this);
	             timer.start();
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
		 public void paintComponent(Graphics g) {
		     super.paintComponent(g);
		     g.setColor(Color.WHITE);
		     g.fillRect(20, 20, 100, 100);
		 }

		
		
		/*
		 * This will be your first time seeing the @Override keyword. 
		 * The actionPerformed() method belongs to the ActionListener class and 
		 * we want to customise the behaviour for our own purpose. We override the default 
		 * behaviour of the actionPerformed() method – we use the @Override keyword to identify that 
		 * we are doing this. Whenever we override a method from a parent class it is good practice 
		 * to use @Override; this will make the compiler check that we are correctly overriding an 
		 * existing method – and then we will receive a warning if we haven’t.
		 */
		
		@Override
		public void actionPerformed(ActionEvent event) {
			
			update();
		}
		
		private void update() {
	          
		 }
		  
	 }

	public static void main(String[] args) {
		new Pong();
		
	}
}
