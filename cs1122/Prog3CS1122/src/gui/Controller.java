package gui;

import hangMan.HangMan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * This class serves as a gate keeper between the AppletUI and the actual
 * HangMan game
 * 
 * @author Bryan Franklin
 * 
 * @author Jeremy Sommerfeld
 * CS1122 R02 Spring 2014
 * 
 */
public class Controller implements ActionListener, MouseListener, KeyListener {
	private JLabel scoreLabel;
	private JLabel playersLabel;
	private JLabel lengthLabel;
	private JPanel gamePanel;
	
	//private JLabel[] labelArrayList = new JLabel[6];

	private JButton playerUp;
	private JButton playerDown;
	private JButton pass;
	private JButton giveUp;
	private JButton lengthDown;
	private JButton lengthUp;

	private HangMan game;

	/**
	 * This method sets up the game according to the filename passed to it.
	 * 
	 * @param filename
	 * 				The filename passed to the method to set the game up with.
	 */
	public Controller(String filename) {
		game = new HangMan(filename);
	}

	/**
	 * This method sets the score label up and refreshes it when recalled.
	 * 
	 * @param labelRef
	 * 				The label passed to the method from the HangmanUI class.
	 */
	public void setScoreLabel(JLabel labelRef) {
		scoreLabel = labelRef;
		
		String label = "";
		for (int i = 0; i < game.getNumPlayers(); i++) {
			label += "<html>Player " + (i+1) + ":  " + game.getPlayerScore(i) + "<br>";
		}
		label += "</html>";
		scoreLabel.setText(label);
	}

	/**
	 * This method sets the text for the number of players label.
	 * 
	 * @param labelRef
	 * 				The label passed to the method in the HangmanUI class.
	 */
	public void setPlayersLabel(JLabel labelRef) {
		playersLabel = labelRef;
	}

	/**
	 * This method sets up the buttons to change the number of players that are currently playing.
	 * 
	 * @param down
	 * 				The JButton passed that is associated with lowering the number of players.
	 * 
	 * @param up
	 * 				The JButton passed that is associated with raising the number of players.
	 */
	public void setPlayerButtons(JButton down, JButton up) {
		playerDown = down;
		playerUp = up;
		playerDown.setFocusable(false);
		playerUp.setFocusable(false);
		playerDown.addActionListener(this);
		playerUp.addActionListener(this);
	}

	/**
	 * This method sets up the panel where the gallows and other UI elements are located.
	 * 
	 * @param panelRef
	 * 				The panel passed that is associated with the panel where everything is painted.
	 */
	public void setGamePanel(JPanel panelRef) {
		gamePanel = panelRef;
		gamePanel.addMouseListener(this);
	}

	/**
	 * This method sets up the pass button.
	 * 
	 * @param buttonRef
	 * 				The JButton passed that is associated with a player passing his/her turn.
	 */
	public void setPassButton(JButton buttonRef) {
		pass = buttonRef;
		pass.setFocusable(false);
		pass.addActionListener(this);
	}

	/**
	 * This method sets up the 'Give Up' button.
	 * 
	 * @param buttonRef
	 * 				The JButton passed that is associated with a player giving up on a word.
	 */
	public void setGiveUpButton(JButton buttonRef) {
		giveUp = buttonRef;
		giveUp.setFocusable(false);
		giveUp.addActionListener(this);
	}

	/**
	 * This method sets up the label for word length.
	 * 
	 * @param labelRef
	 * 				The JLabel passed that is associated with the length of the current/next word.
	 */
	public void setLengthLabel(JLabel labelRef) {
		lengthLabel = labelRef;
		
		lengthLabel.setText("" + game.getWordLength());
	}

	/**
	 * This method sets up the buttons that can change the length of the word being guessed.
	 * 
	 * @param down
	 * 				The JButton passed that is associated with decreasing the letter count.
	 * 
	 * @param up
	 * 				The JButton passed that is associated with increasing the letter count.
	 */
	public void setLengthButtons(JButton down, JButton up) {
		lengthDown = down;
		lengthUp = up;
		lengthDown.setFocusable(false);
		lengthUp.setFocusable(false);
		lengthDown.addActionListener(this);
		lengthUp.addActionListener(this);
	}

	/**
	 * This method returns the state of the game to other classes.
	 * 
	 * @return game
	 * 				The state of the game according to this class.
	 */
	public HangMan getGame() {
		return game;
	}

	/**
	 * This method updates all of the labels and panels whenever there is a change in the state
	 * of the game.
	 */
	public void updateAll() {
		if (playersLabel != null) {
			playersLabel.setText("" + game.getNumPlayers());
		}
		if (lengthLabel != null) {
			lengthLabel.setText("" + game.getWordLength());
		}
		if (gamePanel != null) {
			gamePanel.getParent().repaint();
		}
		if (scoreLabel != null) {
			setScoreLabel(scoreLabel);
		}
		if (game.gameWon()) {
			
			//game.changeWord();
		}
	}

	/**
	 * This method sets up what actions are taken when certain buttons are pressed.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == playerDown) {
			game.setNumPlayers(game.getNumPlayers() - 1);
		}
		if (e.getSource() == playerUp) {
			game.setNumPlayers(game.getNumPlayers() + 1);
		}
		if (e.getSource() == pass) {
			game.nextPlayer();
		}
		if (e.getSource() == lengthDown) {
			//game.giveUp();
			game.setWordLength(game.getWordLength()-1);
			game.changeWord();
		}
		if (e.getSource() == lengthUp) {
			//game.giveUp();
			game.setWordLength(game.getWordLength()+1);
			game.changeWord();
		}
		if (e.getSource() == giveUp) {
			game.giveUp();
		}
		updateAll();
	}

	/**
	 * This method sets up what action is taken when the mouse is clicked in the HangmanPanel.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// check each letter
		int x = e.getX();
		int y = e.getY();
		int letterWidth = 20;
		int clicked = 0;
		
		char[] letters = new char[26];
		for (int i = 0; i < 26; ++i) {
			letters[i] = (char) ('A' + i);
		}
		
		System.out.println("Click at position " + x + "," + y);
		
		//Sets up the button press for the change new word button.
		if ((game.gameWon() || game.gameLost()) && x <= 350 && x >= 150 && y <= 55 && y >= 25) {
			game.changeWord();
		}
		
		//Font.get
		if(!game.gameWon() && !game.gameLost()) {
			if(x <= 530 && x >= 15 && y <= 450 && y >= 425) {
				clicked = (x-15) / letterWidth;
				game.makeGuess(letters[clicked]);
			}
		}
		// cause an immediate redraw
		updateAll();
	}

	/**
	 * This method sets up the action taken when the mouse enters the HangmanPanel.
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
	}

	/**
	 * This method sets up the action taken when the mouse exits the HangmanPanel.
	 */
	@Override
	public void mouseExited(MouseEvent e) {
	}

	/**
	 * This method sets up the action taken when the mouse is pressed and held in the HangmanPanel.
	 */
	@Override
	public void mousePressed(MouseEvent e) {
	}

	/**
	 * This method sets up the action taken when the mouse button is released in the HangmanPanel.
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
	}

	/**
	 * This method sets up the action taken when a key is pressed.
	 */
	@Override
	public void keyPressed(KeyEvent arg0) {
	}

	/**
	 * This method sets up the action taken when a key is released.
	 */
	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	/**
	 * This method sets up the action taken when a key is typed during the game.
	 * If a key is typed, it will make a guess on that letter in the hangman game, 
	 * and output the key pressed to the console.
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println(e.getKeyChar() + " typed on keyboard");

		game.makeGuess(e.getKeyChar());
		// cause an immediate redraw
		updateAll();
	}

}
