import java.util.Random;
import java.util.Scanner;

public class Game {
    private Board b;
    private char currPlayer;
    private String player1;
    private String player2;
    private int userCol;

    // initially just 2 players ---
    // but later change to take one param to indicate play against comp or human
    public Game() {
        b = new Board();
    }

    public void gameLoop(){

    }
    public void gameLoopTwoPlayer() throws IllegalArgumentException {
        Scanner scan = new Scanner(System.in);
            System.out.println("Player 1: Please enter your name.");
            player1 = scan.next();
            System.out.println("Player 2: Please enter your name");
            player2 = scan.next();
            System.out.println("Player 1 is red and player 2 is yellow.");
            //Prints out the initial empty board
            System.out.println(b);

            //Game Loop
            while (!b.hasWon(currPlayer)) {

                //Toggles between player one and player two
                if (currPlayer == 'R') {
                    currPlayer = 'Y';
                } else {
                    currPlayer = 'R';
                }

                System.out.println("Please enter a column number (1-7): ");
                userCol = scan.nextInt();
                if (userCol > 6) { //throws an argument if the user enters a number that is too big
                    throw new IllegalArgumentException("This column number is too big. Please try again.");
                }
                if (!(scan.hasNextInt())) { //throws an exception if the user does not enter an int
                    throw new IllegalArgumentException("You need to enter a number 1-7.");
                } else { //adds a move to the board
                    b.move(currPlayer, userCol);
                    System.out.println(b); //prints out the board after the move has been placed
                }
            }
        // Checks if a player has won
        if (b.hasWon(currPlayer)) {
            System.out.println(currPlayer + " has won!");
            if (currPlayer == 'R') {
                System.out.println("Congratulations, " + player1 + "!");
            }
            if (currPlayer == 'Y') {
                System.out.println("Congratulations, " + player2 + "!");
            }
        }
    }

    public void gameLoopOnePlayer() throws IllegalArgumentException {
        Scanner scnr = new Scanner(System.in);
        while (!b.hasWon(currPlayer)) {
            currPlayer = 'R';
            System.out.println("Please enter a number 1-7.");
            userCol = scnr.nextInt();
            if (userCol > 6) { //throws an argument if the user enters a number that is too big
                throw new IllegalArgumentException("This column number is too big. Please try again.");
            }
            if (!(scnr.hasNextInt())) { //throws an exception if the user does not enter an int
                throw new IllegalArgumentException("You need to enter a number 1-7.");
            } else { //adds a move to the board
                b.move(currPlayer, userCol);
                System.out.println(b); //prints out the board after the move has been placed
            }
            b.move('Y',getCompMoveEasy());
        }
    }

    public int getCompMoveEasy() {
        Random rand = new Random();
        int num = rand.nextInt(7);
        return num;
    }

}
