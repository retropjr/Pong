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
import java.awt.Stroke;
import java.awt.BasicStroke;

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
		     paintDottedLine(g);
		 }
		
		private void paintDottedLine(Graphics g) {
      			Graphics2D g2d = (Graphics2D) g.create();
      			Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
		        g2d.setStroke(dashed);
		        g2d.setPaint(Color.WHITE);
		        g2d.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
		        g2d.dispose();
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
			repaint();
		}
		
		private void update() {
	          
		 }
		  
	 }
	
	/*
	 * Create a new class named 'Sprite' with xPosition, yPosition, xVelocity, yVelocity, width, 
	 * and height integer variables. 

	 * Create public methods to get and set these variables.
	 */
	
	public class Sprite {
		private int xPosition, yPosition;
		private int initialXPosition, initialYPosition;
		private int xVelocity, yVelocity;
		private int width, height;
		
		public int getXPosition() { return xPosition; }
        public int getYPosition() { return yPosition; }
        public int getXVelocity() { return xVelocity; }
        public int getYVelocity() { return yVelocity; }
        public int getWidth() { return width; }
        public int getHeight() { return height; }
        
        /*
         * Add two new integer variables, initialXPosition and initialYPosition. 
         * Create a method to set both of these. Since this will only happen once, 
         * we could set both of these in the same method and call this setInitialPosition() with 
         * two parameters. We do not need a method to get these values.
		 *
		 * Add a new method called resetToInitialPosition(). This method should set the x and y position 
		 * of the object to the initial x and y positions.
         */
        public void setInitialPosition(int initialX, int initialY) {
		       initialXPosition = initialX;
		       initialYPosition = initialY;
		 }
        
        
        public void resetToInitialPosition() {
            setXPosition(initialXPosition);
             setYPosition(initialYPosition);
       }
        
        
        /*
         * Our task is to update the setXPosition() and setYPosition() methods to keep the 
         * Sprite within the bounds of the screen. After setting the position with the parameter 
         * given, we want to check if that is outside the screen and, if so, 
         * bring it back into the screen.

		 * Attempt this yourself before checking the solution. 
		 * This can be done using if conditional statements.
         */
		public void setXPosition(int newX, int panelWidth) {
		       xPosition = newX;
		       if(xPosition < 0) {
		           xPosition = 0;
		       } else if(xPosition + width > panelWidth) {
		           xPosition = panelWidth - width;
		       }
		 }
		
		 public void setYPosition(int newY, int panelHeight) {
		      yPosition = newY;
		      if(yPosition < 0) {
		          yPosition = 0;
		      } else if(yPosition + height > panelHeight) {
		          yPosition = panelHeight - height;
		      }
		 }
		
		public void setXPosition(int newX) {
				xPosition = newX;
			}
		
		public void setYPosition(int newY) {
				yPosition = newY;
			}
		 
		public void setXVelocity(int newX) {
			xVelocity = newX;
		}
		
		public void setYVelocity(int newY) {
			xVelocity = newY;
		}
		
		
		public void setWidth(int newWidth) {
			width = newWidth;
		}
		
		public void setHeight(int newHeight) {
			height = newHeight;
		}
		
	}

	public static void main(String[] args) {
		new Pong();
		
	}
}
