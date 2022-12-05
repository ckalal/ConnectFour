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
        System.out.println("Player 1 is red and player 2 is yellow.");
        //Prints out the initial empty board
        System.out.println(b);

        //Game Loop
        while (!(b.hasWon(currPlayer))) {
            //Toggles between player one and player two
            if (currPlayer == 'R') {
                currPlayer = 'Y';
            } else {
                currPlayer = 'R';
            }

            //adds a move to the board
            while (true) {
                try {
                    int move = getMove();
                    b.move(currPlayer, move);
                    System.out.println(b);
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());


                }
            }
            //prints out the board after the move has been placed

        }
            // Checks which player won
//            if (b.hasWon(currPlayer)) {
//                System.out.println(currPlayer + " has won!");
                if (currPlayer == 'R') {
                    System.out.println("Congratulations, " + player1 + "!");
                }
                if (currPlayer == 'Y') {
                    System.out.println("Congratulations, " + player2 + "!");
                }
//            }

        }

//    public void gameLoopOnePlayer() throws IllegalArgumentException {
//        Scanner scnr = new Scanner(System.in);
//        while (!b.hasWon(currPlayer)) {
//            currPlayer = 'R';
//
//
//            System.out.println("Please enter a number 1-7.");
//            userCol = scnr.nextInt();
//            if (!(scnr.hasNextInt())) { //throws an exception if the user does not enter an int
//                throw new IllegalArgumentException("You need to enter a number 1-7.");
//            } else { //adds a move to the board
//                b.move(currPlayer, userCol);
//                System.out.println(b); //prints out the board after the move has been placed
//            }
//            b.move('Y', getCompMoveEasy());
//        }
//        if (b.hasWon('R')) {
//            System.out.println("Congrats, you won!");
//        } else if (b.hasWon('Y')) {
//            System.out.println("You lose!");
//        }
//    }

        public int getCompMoveEasy () {
            Random rand = new Random();
            int num = rand.nextInt(7);
            return num;
        }

    }
