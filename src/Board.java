import java.util.Scanner;

public class Board {
    final static int HEIGHT = 6;
    final static int WIDTH = 7;
    private char [][] board;
    Scanner sc = new Scanner(System.in);


    public Board() {
        //Creates an empty board
        //todo: grace
        board = new char[HEIGHT][WIDTH];
        for(int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                board[row][col] = ' ';
            }
        }
    }

    /**
     *
     * @param col 1 t0 7
     * @return
     */
    public boolean validCol(int col) {
        //check for valid column
        if(col < 1 || col > board[0].length){
            return false;
        }
        //check for full column
        if(board[0][col] != ' '){
            return false;
        }
        return true;
    }

    public void move(char player, int col) {
        // update board
        // todo:grace
        //throws exception if col oob
        if (col > 7 || col < 1) {
            throw new IllegalArgumentException("Column is out of bounds");
        }
        col = col-1;
        //throw exception if col is full
        if(board[0][col] != ' '){
            throw new IllegalArgumentException("Column is full");
        }
        int lastOpenRow = 0;
        for(int row = 1; row<HEIGHT; row++){
            if(board[row][col]==' '){
                lastOpenRow = row;
            }
        }
        board[lastOpenRow][col] = player;
    }

    public boolean hasWon(char player, int move) {
       int col = move - 1;
       int row = 0;

       while (board[row][col] == ' ') {
           row++;
       }

       //diagonal down right
       int countDR = 0;
       int r = row;
       int c = col;
       for (int i = 0; i < 3; i++) {
           r = row + 1 + i;
           c = col + 1 + i;

           if (r > 5) {
               break;
           }
           if (c > 6) {
               break;
           }
           if (board[r][c] == player) {
               countDR ++;
           } else {
               break;
           }
       }
        if (countDR == 3) {
            return true;
        }

        //diagonal down left
        int countDL = 0;
        r = row;
        c = col;
        for (int i = 0; i < 3; i++) {
            r = row + 1 + i;
            c = col - 1 - i;
            if (r > 5){
                break;
            }
            if (c < 0){
                break;
            }
            if (board[r][c] == player){
                countDL ++;
            }else {
                break;
            }
        }
        if (countDL == 3){
            return true;
        }

        //Checks diagonal up right
        int countUR = 0;
        r = row;
        c = col;
        for (int i = 0; i < 3; i++) {
            r = row - 1 - i;
            c = col + 1 + i;
            if (r < 0){
                break;
            }
            if (c > 6){
                break;
            }
            if (board[r][c] == player){
                countUR++;
            }else {
                break;
            }
        }
        if (countUR == 3){
            return true;
        }

        //Checks diagonal up left
        int countUL = 0;
        r = row;
        c = col;
        for (int i = 0; i < 3; i++) {
            r = row - 1 - i;
            c = col - 1 - i;
            if (r < 0){
                break;
            }
            if (c < 0){
                break;
            }
            if (board[r][c] == player){
                countUL++;
            } else {
                break;
            }
        }
        if (countUL == 3){
            return true;
        }

        //checks right
        int countR = 0;
        r = row;
        c = col;
        for (int i = 0; i < 3; i++) {
            c = col + 1 + i;
            if (c > 6){
                break;
            }
            if (board[r][c] == player){
                countR ++;
            } else {
                break;
            }
        }
        if (countR == 3){
            return true;
        }

        //check left
        int countL = 0;
        r = row;
        c = col;
        for (int i = 0; i < 3; i++) {
            c = col - 1 - i;
            if (c < 0){
                break;
            }
            if (board[r][c] == player){
                countL ++;
            } else {
                break;
            }
        }
        if (countL == 3){
            return true;
        }

        //check down
        int countD = 0;
        r = row;
        c = col;
        for (int i = 0; i < 3; i++) {
            r = row + 1 + i;
            if (r > 5){
                break;
            }
            if (board[r][c] == player){
                countD ++;
            } else {
                break;
            }
        }
        if (countD == 3){
            return true;
        }

        if ((countUL + countDR) >=3 ) {
            return true;
        }

        if ((countUR + countDL >= 3)){
            return true;
        }

        if (countR + countL >= 3){
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        // create a giant string with \n ... col numbers at top maybe?
        // todo: grace
        String s = "";
        s+=" 1 2 3 4 5 6 7\n";
        for(int row = 0; row < board.length; row++){
            s+="|";
            for(int col = 0; col <board[0].length; col++){
               // board[row][col] = ' ';
                s+=board[row][col];
                s+="|";
            }
            s+="\n--------------\n";
        }

        return s;
    }

}
