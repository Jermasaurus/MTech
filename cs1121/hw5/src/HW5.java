import javax.swing.UIManager;

/**
 * Set look and feel and start up game.
 * 
 * @author Dr. David A. Poplawski
 *
 * DO NOT CHANGE THIS FILE IN ANY WAY
 */
public class HW5 {

	/**
	 * Set look and feel, create Game object
	 * 
	 * @param args Unused.
	 */
	public static void main(String [] args) throws Exception {

		try {
			// Set cross-platform Java L&F (also called "Metal")
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} 
		catch (Exception e) {
			System.out.println("Look and Feel error");
			System.exit(1);
		}

		new Game(args);
	} // end of main method

} // end of HW5 class
