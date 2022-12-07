import java.util.Random;
import java.util.Scanner;

public class Game {
    Scanner scan = new Scanner(System.in);
    private Board b;
    private char currPlayer;

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

    public void gameLoopOnePlayer() {
        int move = 0;
        System.out.println("You are player one, and you will go first.\nPlayer one is Red (R) and player two is yellow (Y)");
        //prints out an empty board
        System.out.println(b);
        do {
            if (currPlayer == 'R') {
                currPlayer = 'Y';
            } else {
                currPlayer = 'R';
            }
            while (true) {
                try {
                    move = getMove();
                    b.move(currPlayer, move);
                    System.out.println(b);
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            if (b.hasWon(currPlayer, move)) {
                break;
            }
            if (currPlayer == 'R') {
                currPlayer = 'Y';
            } else {
                currPlayer = 'R';
            }
            while (true) {
                try {
                    b.move(currPlayer, getCompMoveEasy());
                    System.out.println(b);
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } while (!(b.hasWon(currPlayer, move)));

        if (currPlayer == 'Y') {
            System.out.println("You Lose!");
        }
        if (currPlayer == 'R') {
            System.out.println("Congratulations, you won!");
        }
    }

    public void gameLoop() {
        System.out.println("Do you want to play against the computer? (Yes - 1 or No - 2)");
        boolean badInput = true;
        int user = 0;
        while (badInput) {
//            if (scan.hasNextInt()) {
            try{
                user = scan.nextInt();
                if (user == 1 || user == 2) {
                    badInput = false;
                    break;
                }
                else {
                    System.out.println("Please enter a 1 or a 2.");
                }
            } catch(Exception e) {
                System.out.println("You did not enter the correct input. Please enter a 1 or a 2.");
                scan.next();
            }
        }
        if (user == 1){
            gameLoopOnePlayer();
        }
        if (user == 2){
            gameLoopTwoPlayer();
        }
    }

        public int getCompMoveEasy () {
            Random rand = new Random();
            int num = rand.nextInt(7);
            return num + 1;
        }

    }
