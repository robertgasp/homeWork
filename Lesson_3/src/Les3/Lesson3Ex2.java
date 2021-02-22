package Les3;

import java.util.Random;
import java.util.Scanner;

//В задаче приведен пример, где для подсказки выводятся первые 2 буквы, но тк есть слова из 3-х букв, то это было бы слишком просто для отгадки,
//поэтому выводится только первая буква
public class Lesson3Ex2 {

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

            int k = 1; //переменная для вывода загаданного слова по 1 букве, начинается с 1, тк под буква №0 уже выведена в самом начале
            char n = wordForCycle.charAt(0);//узнаем, какая буква первая, чтобы вывести ее для первоначальной подсказки
            String m = "" + n;//пришлось сделать вывод первой буквы через переменную n, тк напрямую без посредника выдавало ошибку, даже с учетом ""+


            int sizeWord = zagWords[a].length();//определяем количество символов в загаданном слове, чтобы потом подставить в цикл
            char[] str = new char[sizeWord];//создаем массив размером с загаданное слово, чтобы в каждый элемент вставить по букве

            System.out.println("Загаданное компьютером слово: ");
            System.out.println(wordForCycle.charAt(0) + "##############");

            while (zagWords[a] != vvedSlovo) {

                vvedSlovo = scanner.nextLine();

                if (zagWords[a].equals(vvedSlovo)) {
                    System.out.println("Поздравляем, Вы угадали слово");
                    break;
                } else {
                    //начинаем прибавлять по 1 букве с учетом того, что первая буква уже выведена (k=1)
                    if (k < sizeWord - 1) {
                        System.out.println("Вы ввели неправильное слово. Следующая попытка.");
                        m += wordForCycle.charAt(k);
                        System.out.print(m);
                        k++;

                        //Добавляем # вместо неотгаданных букв
                        for (int l = 15 - k; l > 0; l--) {
                            System.out.print("#");
                        }
                        System.out.println("");
                    } else
                        //проверка на то, чтобы не выйти за пределы слова и остановка цикла вовремя
                        if (k >= sizeWord - 1) {
                            System.out.println("Загаданное слово: " + zagWords[a]);
                            break;
                        }
                }
            }


            //Повтор или прерывание игры
            System.out.println("Хотите повторить игру?(да/нет)");
            newGame = scanner.nextLine();

            if (newGame.equals(stopGame)) {
                break;
            }

        }
    }
}
