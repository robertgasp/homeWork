package Les1Ex8;

public class Ex8 {
    
    public static void main(String[] args){
        
        checkVisYear(15);
        checkVisYear(400);
        checkVisYear(100);
        checkVisYear(800);
        checkVisYear(65);
        checkVisYear(200);
    }

    private static void checkVisYear(int y) {

        if (y%4 == 0 & y%400 == 0) {
            System.out.println(y + " - високосный год");
        }
        else {
            System.out.println(y + " - не високосный год");
        }



    }
}
