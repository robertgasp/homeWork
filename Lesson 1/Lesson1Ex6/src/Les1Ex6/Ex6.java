package Les1Ex6;

public class Ex6 {

    public static void main(String[] args){

        checkOtr(-3);
        checkOtr(0);
        checkOtr(5);
        checkOtr(10);
    }

    public static boolean checkOtr(int a){

        if (a < 0) {
            return true;
        } else {
            return false;
        }
    }
}
