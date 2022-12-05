import java.util.Random;

public class AI {

    /**
     *
     * @param b
     * @return  1 to 7
     */
    public static int getMove(Board b) {
       // Random r  = new Random();
        int botMove = (int) (Math.random()*7)+1;
        while(b.validCol(botMove)){

        }
        return botMove;
    }

    public static void main(String[] args) {
//        for (int i=0;i<30; i++) {
//            System.out.println(getMove(null));
//        }
    }
}
