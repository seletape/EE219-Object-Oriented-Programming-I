package Assignment8;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

public class ScoreBoard extends JPanel {
	private JLabel humanPoints;
	private JLabel computerPoints;
	private JLabel gameResultMessage;
	private JPanel containerPanel;
	private JPanel scoresGrid;
	
	public ScoreBoard() {
		containerPanel = new JPanel();
		containerPanel.setLayout(new BorderLayout(0,0));
		containerPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.GRAY, Color.GRAY));
		// Set up score board title
		JLabel title = new JLabel("SCORE BOARD", JLabel.CENTER);
		title.setFont(new Font("Arial", Font.BOLD, 14));
		title.setBorder(new EmptyBorder(7,0,7,0));
		containerPanel.add(title, BorderLayout.NORTH);
		// Make score board as 2 x 2 Grid
		scoresGrid = new JPanel();
		scoresGrid.setLayout(new GridLayout(2,2,0,0));
		scoresGrid.setBackground(new Color(1f,1f,1f));
		scoresGrid.setPreferredSize(new Dimension(150,37));
		scoresGrid.add(new JLabel("Human", JLabel.CENTER));
		scoresGrid.add(new JLabel("Computer", JLabel.CENTER));
		humanPoints = new JLabel("", JLabel.CENTER);
		computerPoints = new JLabel("", JLabel.CENTER);
		scoresGrid.add(humanPoints);
		scoresGrid.add(computerPoints);
		containerPanel.add(scoresGrid, BorderLayout.SOUTH);
		// Score board message
		gameResultMessage = new JLabel("", JLabel.CENTER);
		gameResultMessage.setFont(new Font("Arial", Font.BOLD, 14));
		gameResultMessage.setBorder(new EmptyBorder(30,0,0,0));
		// Put the content into this JPanel
		this.setBackground(TicTacToe.bgColor);
		this.setLayout(new BorderLayout(0,0));
		this.add(containerPanel, BorderLayout.NORTH);
		this.add(gameResultMessage, BorderLayout.CENTER);
		// Clear score board data
		clear();
	}
	public void clear() {
		humanPoints.setText("0");
		computerPoints.setText("0");
		gameResultMessage.setText("");
	}
	public void addPointsHuman(int pts) {
		int points = Integer.parseInt(humanPoints.getText()) + pts;
		humanPoints.setText(Integer.toString(points));
	}
	public void addPointsComputer(int pts) {
		int points = Integer.parseInt(computerPoints.getText()) + pts;
		computerPoints.setText(Integer.toString(points));
	}
	public void setGameResultMessage(String msg) {
		gameResultMessage.setText(msg);
	}
	
	//////////////////////////////////////////////////////////////////////
	// Test client for ScoreBoard class - not the main app ///////////////
	//////////////////////////////////////////////////////////////////////
	public static void main(String args[]) {
		JFrame testFrame = new JFrame("ScoreBoard Test Frame");
		testFrame.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
		testFrame.getContentPane().setBackground(TicTacToe.bgColor);
		ScoreBoard testScoreBoard = new ScoreBoard();
		testScoreBoard.addPointsHuman(10);
		testScoreBoard.addPointsComputer(20);
		testScoreBoard.setGameResultMessage("Test Message");
		testFrame.add(testScoreBoard);
		testFrame.pack();
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		testFrame.setVisible(true);
	}
}
