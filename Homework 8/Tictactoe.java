package Final;
import java.awt.*;

import java.awt.event.*;

import java.awt.geom.*;

import javax.swing.*;

import java.util.Random;

class TicTacToe extends JFrame implements MouseListener{


    



    private Color oColor = Color.BLUE, xColor = Color.RED;

    static final char SPACE = ' ', O = 'O', X = 'X';

    private char[] position = { // Board position (SPACE, O, or X)

            SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, SPACE };

    static int wins = 0, losses = 0; // game count by user

    JLabel w = new JLabel("HUMAN : " + wins);

    JLabel l = new JLabel("COMPUTER :" + losses);



    // Start the game

    public static void main(String args[]) {

        new TicTacToe();

    }

    // Initialize

    public TicTacToe() {
    //Call parent class
        // main frame layout
        super("Tic Tac Toe");


        //board


        JPanel score = new JPanel();
        score.setBackground(Color.red);
        score.setLayout(new GridLayout(3,3,0,5));
        score.setBorder(BorderFactory.createEmptyBorder(0,10,20,10));

        score.add(w);
        score.add(l);
      
        add(score,BorderLayout.EAST);

        JPanel topPanel = new JPanel();

        topPanel.setLayout(new FlowLayout());

        topPanel.add(new JLabel("SCORE BOARD:"));



        topPanel.add(w);

        topPanel.add(l);


        add(new Board(), BorderLayout.CENTER);

        JPanel sidePanel= new JPanel();
        sidePanel.setLayout(new FlowLayout());
        sidePanel.add(new JLabel("You go first!"));

        sidePanel.setBorder(BorderFactory.createEmptyBorder(200,10,0,5));
        add(topPanel, BorderLayout.EAST);



        //topPanel.setBackground(Color.white);
        topPanel.add(sidePanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(800, 600);

        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    // Board is what actually plays and displays the game

    private class Board extends JPanel implements MouseListener {



        private static final long serialVersionUID = 1L;

        private Random random = new Random();
        //Defines all the rows
        private int[][] rows = { { 0, 2 }, { 3, 5 }, { 6, 8 }, { 0, 6 }, { 1, 7 }, { 2, 8 }, { 0, 8 }, { 2, 6 } };

        // Endpoints of the 8 rows in position[] (across, down, diagonally)

        public Board() {

            addMouseListener(this);

        }

        // Redraw the board

        public void paintComponent(Graphics g) {

            super.paintComponent(g);

            int w = getWidth();

            int h = getHeight();

            Graphics2D g2d = (Graphics2D) g;

            // Draw the grid

            g2d.setPaint(Color.WHITE);

            g2d.fill(new Rectangle2D.Double(0, 0, w, h));

            g2d.setPaint(Color.BLACK);

            int lineThickness = 8;
            g2d.setStroke(new BasicStroke(lineThickness));

            g2d.draw(new Line2D.Double(0, h / 3, w, h / 3));

            g2d.draw(new Line2D.Double(0, h * 2 / 3, w, h * 2 / 3));

            g2d.draw(new Line2D.Double(w / 3, 0, w / 3, h));

            g2d.draw(new Line2D.Double(w * 2 / 3, 0, w * 2 / 3, h));

            // Draw the Os and Xs

            for (int i = 0; i < 9; ++i) {

                double xpos = (i % 3 + 0.5) * w / 3.0;

                double ypos = (i / 3 + 0.5) * h / 3.0;

                double xr = w / 8.0;

                double yr = h / 8.0;

                if (position[i] == O) {

                    g2d.setPaint(oColor);

                    g2d.draw(new Ellipse2D.Double(xpos - xr, ypos - yr, xr * 2, yr * 2));

                } else if (position[i] == X) {

                    g2d.setPaint(xColor);

                    g2d.draw(new Line2D.Double(xpos - xr, ypos - yr, xpos + xr, ypos + yr));

                    g2d.draw(new Line2D.Double(xpos - xr, ypos + yr, xpos + xr, ypos - yr));

                }

            }

        }

        // Draw an O where the mouse is clicked

        public void mouseClicked(MouseEvent e) {

            int xpos = e.getX() * 3 / getWidth();

            int ypos = e.getY() * 3 / getHeight();

            int pos = xpos + 3 * ypos;
            //Position of pos = position of SPACE
            if (pos >= 0 && pos < 9 && position[pos] == SPACE) {

                position[pos] = X;

                repaint();

                putX(); // computer plays

                repaint();

            }

        }

        // Ignore other mouse events

        public void mousePressed(MouseEvent e) {

        }

        public void mouseReleased(MouseEvent e) {

        }

        public void mouseEntered(MouseEvent e) {

        }

        public void mouseExited(MouseEvent e) {

        }

        // Computer plays X

        void putX() {

            // Check if game is over

            if (won(X))

                newGame(X);

            else if (isDraw())

                newGame(SPACE);

                // Play O, possibly ending the game

            else {

                nextMove();

                if (won(O))

                    newGame(O);

                else if (isDraw())

                    newGame(SPACE);

            }

        }

        // Return true if player has won

        boolean won(char player) {

            for (int i = 0; i < 8; ++i)

                if (testRow(player, rows[i][0], rows[i][1]))

                    return true;

            return false;

        }

        // Has player won in the row from position[a] to position[b]?
        // Checks if player has won with rows

        boolean testRow(char player, int a, int b) {

            return position[a] == player && position[b] == player && position[(a + b) / 2] == player;

        }

        // Play O in the best spot

        void nextMove() {
        // The computer overall aim is to block the user from winning and

        // also tries to create a row to win if possible if it cant do that it will move at random

            int r = findRow(); // complete a row of O and win if possible

            if (r < 0)

                r = findRow(); // or try to block X from winning

            if (r < 0) { // otherwise move randomly

                do

                    r = random.nextInt(9);

                while (position[r] != SPACE);

            }

            position[r] = O;

        }

        // Return 0-8 for the position of a SPACE spot in a row if the

        // other 2 spots are occupied by player, or -1 if no spot exists

        int findRow() {

            for (int i = 0; i < 8; ++i) {

                int result = find1Row(rows[i][0], rows[i][1]);

                if (result >= 0)

                    return result;

            }

            return -1;

        }

        // If 2 of 3 spots in the row from position[a] to position[b]

        // are occupied by player and the third is SPACE, then return the

        // index of the SPACE spot, else return -1.

        int find1Row(int a, int b) {

            int c = (a + b) / 2; // middle spot

            if (position[a] == TicTacToe.O && position[b] == TicTacToe.O && position[c] == SPACE)

                return c;

            if (position[a] == TicTacToe.O && position[c] == TicTacToe.O && position[b] == SPACE)

                return b;

            if (position[b] == TicTacToe.O && position[c] == TicTacToe.O && position[a] == SPACE)

                return a;

            return -1;

        }

        //Checks if  all 9 spots filled

        boolean isDraw() {

            for (int i = 0; i < 9; ++i)

                if (position[i] == SPACE)

                    return false;

            return true;

        }

        // Start a new game

        void newGame(char winner) {

            repaint();

            // Announce result of last game. Ask user to play again.

            String result;

            if (winner == X) {

                wins+=2;

                result = "Human Wins!";

            } else if (winner == O) {

                losses+=2;

                result = "Computer Wins!";

            } else {

                result = "Tie";
                wins++;
                losses++;

            }

            if (JOptionPane.showConfirmDialog(null, "Play Another Game?", result,

                    JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {

                System.exit(0);

            }

            // Clear the board to start a new game

            for (int j = 0; j < 9; ++j)

                position[j] = SPACE;

            // setting the text of the labels if user wants to play again

            //The labels update the score

            w.setText("HUMAN : " + wins);

            l.setText("COMPUTER : " + losses);

        }


    } // end inner class Board

} // end class TicTacToe