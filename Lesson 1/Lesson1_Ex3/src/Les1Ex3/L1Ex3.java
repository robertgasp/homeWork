package Les1Ex3;

public class L1Ex3 {

    public static void main(String[] args){
        int a = 5;
        int b = 3;
        int c = 15;
        int d = 4;
        double result = a*(b+((double)c/d));

        System.out.println("Входные параметры:");
        System.out.println("а=" + a + "; b=" + b + "; c=" + c + "; d=" + d);
        System.out.println("Выражение a*(b+(c/d) = " + result);

    }
}
