package Les3;

import java.util.Random;
import java.util.Scanner;

//В задаче приведен пример, где для подсказки выводятся первые 2 буквы, но тк есть слова из 3-х букв, то это было бы слишком просто для отгадки,
//поэтому выводится только первая буква
public class Lesson3Ex2_Var_igry_2 {

    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        String[] zagWords = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};


        String stopGame = "нет";
        String newGame = "да";  //переменная, с которой будет сравниваться ответ о продолжении игры
        String playAgain = "да";
        String vvedSlovo = null;

        while (playAgain.equals(newGame)) {


            int a = random.nextInt(24);
            String wordForCycle = zagWords[a];


            char c;
            char d;

            int k = 1; //переменная для вывода загаданного слова по 1 букве, начинается с 1, тк под буква №0 уже выведена в самом начале
            char n = wordForCycle.charAt(0);//узнаем, какая буква первая, чтобы вывести ее для первоначальной подсказки
            String m = "" + n;//пришлось сделать вывод первой буквы через переменную n, тк напрямую без посредника выдавало ошибку, даже с учетом ""+



            System.out.println("Загаданное компьютером слово: ");
            System.out.println(wordForCycle.charAt(0) + "##############");

            while (!zagWords[a].equals(vvedSlovo)) {

                vvedSlovo = scanner.nextLine();

                int sizeZagWord = zagWords[a].length();
                int sizeVvedWord = vvedSlovo.length();

                if (zagWords[a].equals(vvedSlovo)) {
                    System.out.println("Поздравляем, Вы угадали слово");
                    break;
                } else {


                    System.out.println("Вы ввели неправильное слово. Следующая попытка.");

                    //начинаем сравнивать каждую букву и выводить по 1
                    //Чтобы не выйти за пределы меньшего слова (введенного или загаданного), сравниваем их и организуем цикл по слову меньшей длины, а  то выдаеи ошибку
                    if (sizeZagWord > sizeVvedWord) {
                        for (k = 0; k < sizeVvedWord; k++) {
                            c = zagWords[a].charAt(k);
                            d = vvedSlovo.charAt(k);

                            if (c == d) {
                                System.out.print(c);
                            } else {
                                System.out.print("#");
                            }
                            //Заполняем # оставшееся поле до 15 значений
                            for (int z = 0; z < 15 - sizeVvedWord; z++) {
                                System.out.print("#");
                            }

                        }
                        System.out.println("");//перепрыгиваем на новую строку для следующей попытки
                    } else {
                        for (k = 0; k < sizeZagWord; k++) {
                            c = zagWords[a].charAt(k);
                            d = vvedSlovo.charAt(k);

                            if (c == d) {
                                System.out.print(c);
                            } else {
                                System.out.print("#");
                            }
                        }
                        //Заполняем # оставшееся поле до 15 значений
                        for (int z = 0; z < 15 - sizeZagWord; z++) {
                            System.out.print("#");
                        }
                    }
                    System.out.println("");//перепрыгиваем на новую строку для следующей попытки
                }


            }
            System.out.println("");
            System.out.println("Загаданное слово: " + zagWords[a]);
            System.out.println("");


            //Повтор или прерывание игры
            System.out.println("Хотите повторить игру?(да/нет)");
            newGame = scanner.nextLine();

            if (newGame.equals(stopGame)) {
                break;
            }
        }
    }
}
