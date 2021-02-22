package Les3;

import java.util.Random;
import java.util.Scanner;

public class Lesson3 {

    public static void main(String[] args) {

        Random random = new Random();


        int proba; //переменная для считывания введенного пользователем числа
        int newGame = 1; //переменная для вопроса о продолжнении игры

        Scanner scanner = new Scanner(System.in);

        while (newGame > 0) {

            System.out.println("Компьютер загадал новое число в пределах 0...9, попробуйте угадать. У Вас 3 попытки");
            int zagChislo = random.nextInt(10);

            for (int i = 1; i <= 3; i++) { //даем пользователю 3 попытки

                proba = scanner.nextInt();

                if (proba != zagChislo && i == 3) {
                    System.out.println("Количество попыток закончилось, загаданным числом было " + zagChislo);
                } else if (proba < zagChislo) {
                    System.out.println("Загаданное компьютером число больше");
                } else if (proba > zagChislo) {
                    System.out.println("Загаданное компьютером число меньше");
                } else {
                    System.out.println("Вы угадали загаданное компьютером число, оно равняется " + zagChislo);
                    break;
                }
            }
            System.out.println("Хотите повторить еще раз? Если да, то введите 1, для выхода введите 0");
            newGame = scanner.nextInt();
            if (newGame == 0) {
                break;
            }
        }
    }
}
