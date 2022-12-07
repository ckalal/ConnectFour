import java.util.Random;
import java.util.Scanner;

public class Game {
    Scanner scan = new Scanner(System.in);
    private Board b;
    private char currPlayer;
    private String player1;
    private String player2;


    // initially just 2 players ---
    // but later change to take one param to indicate play against comp or human
    public Game() {
        b = new Board();
        currPlayer = 'Y';
    }

    public int getMove() {
        boolean badMove = true;
        int move = 0;
        while (badMove) {
            System.out.println(currPlayer + ", please enter a column number (1-7): ");
            if (scan.hasNextInt()) {
                move = scan.nextInt();
                badMove = false;
            } else {
                System.out.println("not an int try again");
                scan.next();
            }
        }
        return move;
    }

    public void gameLoopTwoPlayer() {
//            System.out.println("Player 1: Please enter your name.");
//            player1 = scan.next();
//            System.out.println("Player 2: Please enter your name");
//            player2 = scan.next();
        System.out.println("Player 1 is red (R) and player 2 is yellow (Y).");

        //Prints out the initial empty board
        System.out.println(b);

        int move = 0;
        do {
            //Toggles between player one and player two
            if (currPlayer == 'R') {
                currPlayer = 'Y';
            } else {
                currPlayer = 'R';
            }

            //adds a move to the board
            while (true) {
                try {
                    move = getMove();
                    b.move(currPlayer, move);
                    System.out.println(b);
//                    System.out.println(b.hasWon(currPlayer,move));
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

        } while (!(b.hasWon(currPlayer, move)));

        System.out.println(currPlayer + " has won!");
        }

        public int getCompMoveEasy () {
            Random rand = new Random();
            int num = rand.nextInt(7);
            return num;
        }

    }
