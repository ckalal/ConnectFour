public class Board {
    private char[][] board;
    final static int HEIGHT = 6;
    final static int WIDTH = 7;

    public Board() {
        //Creates an empty board
        // double for loop --- everything set ' '
        //todo: grace
    }

    public void move(char player, int col) {
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
