package gui;

import hangMan.HangMan;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * <Description of this class goes here>
 * 
 * @author Bryan Franklin
 * 
 * @author Jeremy Sommerfeld
 * CS1122 R02 Spring 2014
 * 
 */
public class HangmanUI extends JFrame {
	private static final long serialVersionUID = -6215774992938009947L;
	HangMan game;
	Controller ctrl;

	public HangmanUI() {
		String dictionaryFile = "up-goer-5.txt";
		ctrl = new Controller(dictionaryFile);
		game = ctrl.getGame();
	}

	/**
	 * This method initializes the window and sets the size and constraints associated with it.
	 */
	public void init() {

		setSize(640, 480);
		Container pane = getContentPane();
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 0;
		c.weighty = 0;
		c.fill = GridBagConstraints.BOTH;

		// players config stuff
		JLabel players = new JLabel("Players");
		players.setHorizontalAlignment(SwingConstants.CENTER);
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 0;
		pane.add(players, c);

		// start row of single width buttons
		c.gridwidth = 1;
		c.gridy = 1;

		JButton playersDown = new JButton("-");
		c.gridx = 0;
		pane.add(playersDown, c);

		JLabel numPlayers = new JLabel("" + game.getNumPlayers());
		c.gridx = 1;
		pane.add(numPlayers, c);
		ctrl.setPlayersLabel(numPlayers);

		JButton playersUp = new JButton("+");
		c.gridx = 2;
		pane.add(playersUp, c);
		ctrl.setPlayerButtons(playersDown, playersUp);

		// pass
		JButton pass = new JButton("Pass");
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 3;
		pane.add(pass, c);
		ctrl.setPassButton(pass);

		// create score label
		JLabel scores = new JLabel("");
		scores.setHorizontalAlignment(SwingConstants.LEFT);
		scores.setVerticalAlignment(SwingConstants.TOP);
		c.gridwidth = 3;
		c.gridheight = 1;
		c.gridy = 3;
		c.gridx = 0;
		c.weighty = 1; // make it fill extra space
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		pane.add(scores, c);
		ctrl.setScoreLabel(scores);
		c.weighty = 0;

		//Add in Give Up button:
		JButton giveUp = new JButton("Give Up");
		c.gridwidth = 3;
		c.gridheight = 1;
		c.gridx = 0;
		c.gridy = 4;
		pane.add(giveUp, c);
		ctrl.setGiveUpButton(giveUp);

		//Add in letter count:
		JLabel letterCount = new JLabel("Letter Count");
		players.setHorizontalAlignment(SwingConstants.CENTER);
		c.gridwidth = 3;
		c.gridheight = 1;
		c.gridx = 0;
		c.gridy = 5;
		pane.add(letterCount, c);

		// start row of single width buttons
		c.gridwidth = 1;
		c.gridy = 6;

		JButton lengthDown = new JButton("-");
		c.gridx = 0;
		pane.add(lengthDown, c);

		JLabel lengthCount = new JLabel("" + game.getWordLength());
		c.gridx = 1;
		pane.add(lengthCount, c);
		ctrl.setLengthLabel(lengthCount);

		JButton lengthUp = new JButton("+");
		c.gridx = 2;
		pane.add(lengthUp, c);
		ctrl.setLengthButtons(lengthDown, lengthUp);
		
		// create place to draw game state
		JPanel drawPanel = new HangmanPanel(game);
		drawPanel.setBackground(Color.LIGHT_GRAY);
		c.gridx = 4;
		c.gridy = 0;
		c.weightx = 1;
		c.gridheight = 7;
		c.fill = GridBagConstraints.BOTH;
		this.addKeyListener(ctrl);
		pane.add(drawPanel, c);
		ctrl.setGamePanel(drawPanel);

		
		// start game
		game.changeWord();

		// make sure UI is updated
		ctrl.updateAll();
	}

	/**
	 * This method initializes the window according to the init method and sets the window to visible.
	 * 
	 * @param args
	 * 				The main args in a main method.
	 */
	public static void main(String[] args) {
		HangmanUI app = new HangmanUI();
		app.init();
		app.setPreferredSize(new Dimension(640, 480));
		app.pack();
		app.setVisible(true);
	}

}
