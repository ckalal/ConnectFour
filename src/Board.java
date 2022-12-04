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
        //checks to see if player has won horizontally
        int counth = 0;
        for (int w = 0;WIDTH > w; w ++){
            for (int h = 0; HEIGHT > h; h++){
                if (board[w][h] == player){
                    counth += 1;
                }
                if (counth >= 4){
                    return true;
                }
                return false;
            }
        }
        //Checks to see if player has won vertically
        int countv = 0;
        for (int h = 0; HEIGHT > h; h ++){
            for (int w = 0; WIDTH > w; w++){
                if (board[w][h] == player){
                    countv += 1;
                }
                if (countv >= 4){
                    return true;
                }
                return false;
            }
        }
        //Checks diagonal going one way
        boolean check1 = false;
        int checkCol1 = 1;
        int checkRow1 = 1;
        int countd1 = 0;

        for (int w = 0; WIDTH > w; w+=1){
            for (int h = 0; HEIGHT > h; h+= 1){
                if (board[w][h] == player){
                    countd1 += 1;
                    check1 = true;
                    while(check1){
                        if (checkCol1 + w <= WIDTH - 1 && checkRow1 + h <= HEIGHT - 1){
                            if (board[w + checkCol1][h + checkRow1] == player){
                                countd1 += 1;
                            }
                        }
                        checkCol1 += 1;
                        checkRow1 += 1;

                        if (countd1 >= 4){
                            return true;
                        }
                    }
                }
                countd1 = 0;
                checkCol1 = 0;
                checkRow1 = 0;
            }
        }
        // Checks diagonal one way
        boolean check2 = false;
        int checkCol2 = 1;
        int checkRow2 = 1;
        int countd2 = 0;

        for (int w = 0; WIDTH > w; w+=1){
            for (int h = 0; HEIGHT > h; h+= 1){
                if (board[w][h] == player){
                    countd2 += 1;
                    check2 = true;
                    while(check2){
                        if (w - checkCol2 >= 0 && h - checkRow2 >= 0){
                            if (board[w - checkCol2][h - checkRow2] == player){
                                countd2 += 1;
                            }
                        }
                        checkCol2 += 1;
                        checkRow2 += 1;

                        if (countd2 >= 4){
                            return true;
                        }
                    }
                }
                countd2 = 0;
                checkCol2 = 0;
                checkRow2 = 0;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        // create a giant string with \n ... col numbers at top maybe?
        // todo: grace
        return null;
    }

}
