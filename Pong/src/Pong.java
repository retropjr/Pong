import javax.swing.JFrame;

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
	}

	public static void main(String[] args) {
		new Pong();

	}
}
