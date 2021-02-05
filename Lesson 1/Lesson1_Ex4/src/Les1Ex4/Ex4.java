package Les1Ex4;

public class Ex4 {

    public static void main(String[] args){

        checkLimit(15,1);
        checkLimit(5,3);
        checkLimit(10,0);
        checkLimit(40,50);


    }

    private static boolean checkLimit(int a, int b) {
        if ((a+b) >= 10 & (a+b) <= 20) {
            return true;
        } else {
            return false;
        }
    }
}
