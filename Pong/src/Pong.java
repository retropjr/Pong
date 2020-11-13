import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Rectangle;
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

	
	public class PongPanel extends JPanel implements ActionListener, KeyListener {
		
		private final Color BACKGROUND_COLOUR = Color.BLACK;
		private final static int TIMER_DELAY = 5;
		
		GameState gameState = GameState.Initialising;
		
		Ball ball;
		Paddle paddle1, paddle2;
		
		public PongPanel() {
	          setBackground(BACKGROUND_COLOUR);
	          Timer timer = new Timer(TIMER_DELAY, this);
	          timer.start();
	      }
		
		public void createObjects() {
	         ball = new Ball(getWidth(), getHeight());
	         paddle1 = new Paddle(Player.One, getWidth(), getHeight());
	         paddle2 = new Paddle(Player.Two, getWidth(), getHeight());
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
	          if(gameState != GameState.Initialising) {
	              paintSprite(g, ball);
	              paintSprite(g, paddle1);
	              paintSprite(g, paddle2);
	          }
	      }
		 
		private void paintDottedLine(Graphics g) {
      			Graphics2D g2d = (Graphics2D) g.create();
      			Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
		        g2d.setStroke(dashed);
		        g2d.setPaint(Color.WHITE);
		        g2d.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
		        g2d.dispose();
		 }
		
		private void paintSprite(Graphics g, Sprite sprite) {
		      g.setColor(sprite.getColour());
		      g.fillRect(sprite.getXPosition(), sprite.getYPosition(), sprite.getWidth(), sprite.getHeight());
		}

		
		
		/*
		 * This will be your first time seeing the @Override keyword. 
		 * The actionPerformed() method belongs to the ActionListener class and 
		 * we want to customise the behaviour for our own purpose. We override the default 
		 * behaviour of the actionPerformed() method � we use the @Override keyword to identify that 
		 * we are doing this. Whenever we override a method from a parent class it is good practice 
		 * to use @Override; this will make the compiler check that we are correctly overriding an 
		 * existing method � and then we will receive a warning if we haven�t.
		 */
		
		@Override
		public void actionPerformed(ActionEvent event) {
			
			update();
			repaint();
		}
		
		
		private void update() {
	           switch(gameState) {
	               case Initialising: {
	                   createObjects();
	                  gameState = GameState.Playing;
	                   break;
	               }
	               case Playing: {
	                   break;
	              }
	              case GameOver: {
	                  break;
	              }
	          }
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
		private Color colour;
		
		public int getXPosition() { return xPosition; }
        public int getYPosition() { return yPosition; }
        public int getXVelocity() { return xVelocity; }
        public int getYVelocity() { return yVelocity; }
        public int getWidth() { return width; }
        public int getHeight() { return height; }
        public Color getColour() { return colour; }
        
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
		 
		public void setXVelocity(int newXVelocity) {
			xVelocity = newXVelocity;
		}
		
		public void setYVelocity(int newYVelocity) {
			xVelocity = newYVelocity;
		}
		
		
		public void setWidth(int newWidth) {
			width = newWidth;
		}
		
		public void setHeight(int newHeight) {
			height = newHeight;
		}
		
		public void setColour(Color newColour) {
			colour = newColour;
		}
		
		public Rectangle getRectangle() {
			return new Rectangle(getXPosition(), getYPosition(), getWidth(), getHeight());
		}
		
	}
	
	/*
	 * Create a new class named 'Ball' that inherits from the Sprite class.

		Add final static variables for the colour, width and height of the ball. 
		Make the width and height 25. Colour should be white.
	
		Add a constructor that sets the colour, width, and height of the ball; 
		a width and height parameter of the panel size should be provided.
	
		Set the initial starting position using the following line of code:
	
	  	setInitialPosition(panelWidth / 2 - (getWidth() / 2), panelHeight / 2 - (getHeight() / 2));
	  	
		This will position the ball in the centre of the screen. The width and height of the ball is used 
		to correctly position it in the centre; if the ball width or height changes it will 
		automatically adjust.

		Finally, call resetToInitialPosition(), which will set the position of the ball to the initial 
		position we provided. This method was conveniently defined in the Sprite class.
	 */
	public class Ball extends Sprite {
		private final Color BALL_COLOUR = Color.WHITE; 
		private static final int BALL_WIDTH = 25;
		private static final int BALL_HEIGHT = 25;
		
		public Ball(int panelWidth, int panelHeight) {
			setColour(BALL_COLOUR);
			setWidth(BALL_WIDTH);
			setHeight(BALL_HEIGHT);
			setInitialPosition(panelWidth / 2 - (getWidth() / 2), panelHeight / 2 - (getHeight() / 2));
			resetToInitialPosition();
		}
	}
	
	/*
	 * Create a new class named �Paddle� that inherits from the Sprite class. 
	 * Add static final variables for the width, height, and colour. Add the constructor 
	 * that takes the Player enum as a parameter.

		The constructor should set the width, height, and colour.

		The constructor should also set the initial starting position (both the x and y position) 
		and call resetToInitialPosition().
	 */
	 public class Paddle extends Sprite {
	       private static final int PADDLE_WIDTH = 10;
	       private static final int PADDLE_HEIGHT = 100;
	       private final Color PADDLE_COLOUR = Color.WHITE;
	       private static final int DISTANCE_FROM_EDGE = 40;
	       
	       public Paddle(Player player, int panelWidth, int panelHeight) {
	          setWidth(PADDLE_WIDTH);
	          setHeight(PADDLE_HEIGHT);
	          setColour(PADDLE_COLOUR);
	          int xPos;
	          if(player == Player.One) {
	              xPos = DISTANCE_FROM_EDGE;
	          } else {
	              xPos = panelWidth - DISTANCE_FROM_EDGE - getWidth();
	          }
	          setInitialPosition(xPos, panelHeight / 2 - (getHeight() / 2));
	          resetToInitialPosition();
	      }
	 }
	

	public static void main(String[] args) {
		new Pong();	
	}
}		

