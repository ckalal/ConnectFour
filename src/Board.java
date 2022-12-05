import java.util.Scanner;

public class Board {
    private char[][] board;
    final static int HEIGHT = 6;
    final static int WIDTH = 7;
    Scanner sc = new Scanner(System.in);


    public void Board() {
        //Creates an empty board
        // double for loop --- everything set ' '
        //todo: grace
        System.out.println("1 2 3 4 5 6 7");
        char[][] board = new char[WIDTH][HEIGHT];
        for(int row = 0; row < board.length; row++){
            System.out.print("|");
            for(int col = 0; col <board[0].length; col++){
                System.out.print(board[row][col]);
                System.out.print("|");
            }
            System.out.println();
            System.out.println("--------------");
        }


        return;
    }

    public void move(char player, int col) throws IllegalArgumentException{
        // throw exception if col oob
        // throw exeption if col is full
        // update board
        // todo:grace



    }

    public boolean hasWon(char player) {
        // Todo: Corinne
        int count = 0;
        //checks to see if player has won horizontally
        for (int w = 0;WIDTH > w; w ++){
            for (int h = 0; HEIGHT > h; h++){
                if (board[w][h] == player){
                    count += 1;
                }
                if (count >= 4){
                    return true;
                }
            }
        }
        //Checks to see if player has won vertically
        for (int h = 0; HEIGHT > h; h ++){
            for (int w = 0; WIDTH > w; w++){
                if (board[w][h] == player){
                    count += 1;
                }
                if (count >= 4){
                    return true;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        // create a giant string with \n ... col numbers at top maybe?
        // todo: grace
        return null;
    }

}
