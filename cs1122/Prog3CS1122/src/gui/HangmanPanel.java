//TODO: COMMENT CODE!!

package gui;

import hangMan.HangMan;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;


/**
 * This class is used to draw the graphical portion of the user interface (i.e.
 * the gallows, letters, current word, etc.)
 * 
 * @author Bryan Franklin
 * 
 * @author Jeremy Sommerfeld
 * CS1122 R02 Spring 2014
 * 
 */
public class HangmanPanel extends JPanel {
	private static final long serialVersionUID = 7734877696044080629L;
	HangMan game;

	public HangmanPanel(HangMan gameRef) {
		game = gameRef;
	}

	/**
	 * paintComponent method is part of the JPanel class and is called to draw
	 * things to the JPanel
	 * 
	 * @param g
	 *            - graphics object use for drawing to the JPanel
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		//Lawn/Letter area:
		g.setColor(Color.GREEN);
		g.fillRect(0, 415, 640, 65);
		
		//Floor of Gallows:
		g.setColor(Color.RED);
		g.fillRect(100, 350, 325, 65);
		
		//Horizontal Bar:
		g.fillRect(175, 75, 150, 25);
		
		//Vertical Bar:
		g.fillRect(165, 75, 25, 300);
		
		//Vertical Bar #2:
		g.setColor(Color.YELLOW);
		g.fillRect(285, 75, 3, 50);
		
		//Sets up a black background for the white text.
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 640, 60);
		
		//Sets up text that displays the current user.
		g.setColor(Color.WHITE);
		Font font = new Font(Font.MONOSPACED, Font.PLAIN, 16);
		g.setFont(font);
		if (game.gameWon()) {
			g.drawString("Player " + (game.currentPlayer() + 1) + " wins!!", 175, 25);
			g.drawString("Click for new word.", 160, 50);
		}
		else if (game.gameLost()) {
			g.drawString("You Lose...", 200, 25);
			g.drawString("Click for new word.", 160, 50);
		}
		else {
			g.drawString("Player " + (game.currentPlayer() + 1) + "'s turn.", 175, 40);
		}
		
		//Adds the current word and letters guessed correctly.
		g.setColor(Color.BLACK);
		g.drawString(game.getExposedLetters(), 140, 390);
		
		//Adds the letters available to be guessed.
		char[] letters = new char[26];
		for (int i = 0; i < 26; ++i) {
			letters[i] = (char) ('A' + i);
		}
		String lettersAvailable = "";
		
		for(int i = 0; i < 26; i++) {
			if(game.letterAvailable(letters[i])) {
				lettersAvailable += "" + letters[i] + " ";
			}
			else{
				lettersAvailable += "  ";
			}
		}
		g.drawString(lettersAvailable, 15, 443);
		
		//Add in man being hung.
		if (game.getFailures() >=  1) {
			g.drawOval(260, 125, 50, 50);
		}
		if (game.getFailures() >= 2) {
			g.drawLine(285, 175, 285, 240);
		}
		if (game.getFailures() >= 3) {
			g.drawLine(285, 200, 265, 240);
		}
		if (game.getFailures() >= 4) {
			g.drawLine(285, 200, 305, 240);
		}
		if (game.getFailures() >= 5) {
			g.drawLine(285, 240, 265, 280);
		}
		if (game.getFailures() >= 6) {
			g.drawLine(285, 240, 305, 280);
		}
		
		
	} // end of paintComponent method

}
