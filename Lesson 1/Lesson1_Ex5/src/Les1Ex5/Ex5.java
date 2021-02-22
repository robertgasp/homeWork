package Les1Ex5;

public class Ex5 {

    public static void main(String[] args){

        polotr(2);
        polotr(-2);
        polotr(0);
    }

    private static void polotr(int a) {

        if (a < 0){
            System.out.println(a + " - это отрицательное число");
        }
        else if (a >= 0){ //как вариант, можно не делать вторую проверку, а сразу после else вывести System.out.println(i + " - это положительное число");
            System.out.println(a + " - это положительное число");
        }
    }
}
