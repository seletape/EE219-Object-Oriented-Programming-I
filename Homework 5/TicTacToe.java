// Tic-Tac-Toe, CMA, DCU, March 2020

package Assignment8;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

//
// Main Tic-Tac-Toe application class
// Constructs and lays out GUI elements and runs app
// Acts as listener for GridSquares when clicked
// Controls play between human and computer and identifies
// when game is over (won or drawn)
//

public class TicTacToe implements GridSquareListener {

	private JFrame gameFrame;
	private Grid grid;
	private ScoreBoard scoreBoard;
	private JButton playButton;

	private int moveNumber;
	private boolean gameOver;
	private boolean isHumansMove;
	private boolean computerStartsNextGame;

	public final static Color bgColor = new Color(0.8f,0.8f,0.8f);

	public TicTacToe() {

		// Create game elements
		gameFrame = new JFrame("Tic-Tac-Toe");
		grid = new Grid();
		grid.addGridSquareListener(this);
		scoreBoard = new ScoreBoard();
		playButton = new JButton("Play Another Game");

		// Create sub-panel to contain the score board and play button
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BorderLayout(0,0));
		rightPanel.add(scoreBoard, BorderLayout.NORTH);
		rightPanel.add(playButton, BorderLayout.SOUTH);
		rightPanel.setBackground(bgColor);

		// Create outer panel to contain game grid and rightPanel
		JPanel gameContainerPanel = new JPanel();
		gameContainerPanel.setLayout(new GridLayout(1,2,40,0));
		gameContainerPanel.setBackground(bgColor);
		gameContainerPanel.add(grid);
		gameContainerPanel.add(rightPanel);

		// Add outer panel to main frame
		gameFrame.add(gameContainerPanel);

		// Play button's action listener
		playButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (computerStartsNextGame) {
					scoreBoard.setGameResultMessage("");
					computerStartsNextGame = false;
					computerMove();
				}
				else {
					scoreBoard.setGameResultMessage("You go first");
					computerStartsNextGame = true;
				}
				startNewGame();
			}
		});
		playButton.setFocusable(false);

		// Setup for first game
		playButton.setVisible(false);
		isHumansMove = true;
		computerStartsNextGame = true;
		scoreBoard.setGameResultMessage("You go first");

		// Configure the main frame and display it
		gameFrame.setLayout(new FlowLayout(FlowLayout.CENTER,30,30));
		gameFrame.getContentPane().setBackground(bgColor);
		gameFrame.setSize(550,295);
		gameFrame.setLocationRelativeTo(null);
		gameFrame.setResizable(false);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setVisible(true);
	}

	// Call back from a grid square when it is clicked
	// Implements our GridSquareListener interface
	@Override
	public void gridSquareClicked(int sqrID) {
		if (isHumansMove && !gameOver)
			humanMove(sqrID);
	}
	
	private void startNewGame() {
		grid.clear();
		moveNumber = 0;
		gameOver = false;
		playButton.setVisible(false);
	}

	private void humanMove(int sqrID) {
		if (grid.getSquareState(sqrID) == GridSquare.EMPTY_SQUARE) {
			moveNumber++;
			grid.setSquareState(sqrID, GridSquare.HUMAN_PLAYER);
			updateGameState();
			if (gameOver == false)
				computerMove();
			else
				playButton.setVisible(true);
		}
	}

	//
	// Computer move strategy:
	//
	// Check if computer can win on next move 
	// If not, check if human can win on next move and block human's winning move
	// Otherwise, just make a random move
	// This is a simple strategy - could enhance it by also searching for human move
	// that will lead to an unbeatable "fork" and block that move (not implemented here)
	// Fully optimal strategy would require constructing a full "game-tree" or,
	// use an "unsupervised machine learning" strategy - ala the 1983 movie "WarGames" :)
	//
	private void computerMove() {
		isHumansMove = false;
		// Add a delay before computer moves, to give impression it is "thinking" (optional feature)
		Timer timer = new Timer(400, new ActionListener() {
			public void actionPerformed(ActionEvent event) { // timer expired, make computer move
				moveNumber++;
				int sqrID = GameEngine.findWinningMove(GridSquare.COMPUTER_PLAYER, grid);
				if (sqrID == -1)
					sqrID = GameEngine.findWinningMove(GridSquare.HUMAN_PLAYER, grid);
				if (sqrID == -1)
					sqrID = GameEngine.getRandomMove(grid);
				grid.setSquareState(sqrID, GridSquare.COMPUTER_PLAYER);
				updateGameState();
				if (gameOver == true)
					playButton.setVisible(true);
				isHumansMove = true;
			}
		});
		timer.setRepeats(false);
		timer.start();		
	}

	private void updateGameState() {
		scoreBoard.setGameResultMessage("");
		if (GameEngine.isWinner(GridSquare.HUMAN_PLAYER, grid)) {
			gameOver = true;
			scoreBoard.addPointsHuman(2);
			scoreBoard.setGameResultMessage("YOU WIN!");
			return;
		}
		if (GameEngine.isWinner(GridSquare.COMPUTER_PLAYER, grid)) {
			gameOver = true;
			scoreBoard.addPointsComputer(2);
			scoreBoard.setGameResultMessage("COMPUTER WINS!");
			return;
		}
		if (moveNumber == 9) {
			gameOver = true;
			scoreBoard.addPointsHuman(1);
			scoreBoard.addPointsComputer(1);
			scoreBoard.setGameResultMessage("IT'S A DRAW!");
			return;
		}
		gameOver = false;
	}

	//////////////////////////////////////////////////////////////////////
	// Create and run the app ////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////
	public static void main(String args[]) {
		new TicTacToe();
	}

}
