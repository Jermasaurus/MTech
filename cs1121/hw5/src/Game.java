
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.*;

/**
 * Play the game.
 * 
 * @author Jeremy Sommerfeld
 */
public class Game {

	// properties
	protected JButton [][] board;  // do not change or remove this line

	/**
	 * Set up GUI and listeners.
	 *
	 * @param args The command line arguments.
	 */
	public Game(String [] args) {

		//READS IN FROM THE FILE INPUT.TXT
		String fileName = "initial.txt";
		File f = new File(fileName);
		//Set up the Scanner:
		Scanner in = null;
		try {
			in = new Scanner(f);
		}
		catch (FileNotFoundException ex) {
			System.out.println("Can't read from " + fileName);
			System.exit(1);
		}
		//number of rows and columns
		final int n = in.nextInt();
		in.nextLine();  //Gets rid of line that 'n' was on

		//Set a reference size of board.
		board = new JButton[n][n];

		char[][] chars = new char[n][n];
		String str = "";

		for (int outCount = 0; outCount < n; outCount++) {
			str = in.nextLine();
			//System.out.println(str);
			str.trim();
			str = str.replaceAll("\\s", "");
			//System.out.println(str);
			char[] innerChars = str.toCharArray();
			for (int inCount = 0; inCount < n; inCount++) {
				chars[outCount][inCount] = innerChars[inCount];
			}
		}

		//START SETTING UP THE GUI
		JFrame gui = new JFrame();
		// set layout manager
		gui.setLayout(new GridLayout(n,n));
		//board;

		for(int outCount = 0; outCount < n; outCount++) {
			for(int inCount = 0; inCount < n; inCount++) {

				board[outCount][inCount] = new JButton();

				if (chars[outCount][inCount] == '*') {
					board[outCount][inCount].setBackground(Color.GRAY);
					board[outCount][inCount].setForeground(Color.GRAY);
				}
				else if (chars[outCount][inCount] == 'x') {
					board[outCount][inCount].setBackground(Color.RED);
					board[outCount][inCount].setForeground(Color.RED);
				}
				else {
					board[outCount][inCount].setBackground(Color.WHITE);
					board[outCount][inCount].setForeground(Color.WHITE);
				}

				//Adds the button to the board.
				gui.add(board[outCount][inCount]);
			}
		}

		//Sets gui's size.
		gui.setSize(600, 600);
		//Makes the x button on window terminate the program.
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Gives the window a title.
		gui.setTitle("Homework 5 GUI Game");
		//Sets the visibility of the gui.
		gui.setVisible(true);  //Always do this last
	} // end of constructor

} // end of Game class