package Les4;

import java.util.Random;
import java.util.Scanner;

public class Lesson4_XO {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    static final char FIELD_DOT = '•';
    static final char FIELD_USER = 'X';
    static final char FIELD_AI = '0';
    static final int KOLZ = 4;  //необходимое количество символов для победы
    static char symbol;


    static int kolX;        //подсчитываем количество Х и 0 для победы
    static int diagObraytOtsch; //обратный отсчет при проверке победы по диагонали (максимальная диагональ = SIZE), по мере движения по строкам и столбцам ее длина уменьшается на 1


    static final int SIZE = 5;  //размер матрицы для игры
    static int coordX;
    static int coordY;
    static int count = 0; //для подсчета количества ходов

    static final char[][] gameField = new char[SIZE + 1][SIZE + 1];//создаем на 1 больше, чтобы в нулевую строку и нулевой столбец вписать цифры

    public static void main(String[] args) {


        initMap();//инициализация и одновременный вывод всего поля с цифрами строк и столбцов

        while (true) {
            turnUser();//ход игрока
            checkEndGame(FIELD_USER);//проверка на победу и окончание игры
            turnAI();//ход компьютера
            arrayPrint(gameField);
            checkEndGame(FIELD_AI);//проверка на победу и окончание игры
        }
    }

    private static void initMap() {
        for (int i = 0; i <= SIZE; i++) {
            for (int j = 0; j <= SIZE; j++) {
                if (i == 0 && j == 0) {
                    //на позиции 0, 0 печатаем +
                    gameField[i][j] = '+';
                    System.out.print(gameField[i][j] + " ");
                } else if (i == 0) {
                    //печатаем верхнюю строку
                    gameField[0][j] = Character.forDigit(j, 10);
                    System.out.print(gameField[i][j] + " ");
                } else if (j == 0) {
                    //печатаем первый столбец
                    gameField[i][0] = Character.forDigit(i, 10);
                    System.out.print(gameField[i][j] + " ");
                } else {
                    // остальное поле заполняем точками
                    gameField[i][j] = FIELD_DOT;
                    System.out.print(gameField[i][j] + " ");
                }
            }
            System.out.println("");
        }
    }

    private static void turnUser() {
        do {
            System.out.println("Ваш ход. Введите координаты Вашего хода");
            System.out.print("№ строки: ");
            coordX = scanner.nextInt();
            System.out.print("№ столбца: ");
            coordY = scanner.nextInt();

        } while (!(checkCorrect(coordX, coordY) && checkEmpty(coordX, coordY)));
        gameField[coordX][coordY] = FIELD_USER;
        count++;
    }

    private static boolean checkCorrect(int coordX, int coordY) {
        return coordX > 0 && coordX <= SIZE && coordY > 0 && coordY <= SIZE;
    }

    private static boolean checkEmpty(int coordX, int coordY) {
        return gameField[coordX][coordY] == FIELD_DOT;
    }


    private static void checkEndGame(char symbol) {
        if (checkWin(symbol)) {
            if (symbol == FIELD_USER) {
                System.out.println("Игра закончена, Вы победили");
                arrayPrint(gameField);
            } else if (symbol == FIELD_AI) {
                System.out.println("Игра закончена, победил ПК");
                arrayPrint(gameField);
            }
            System.exit(0);
        } else if (checkCount()) {
            System.out.println("Игра закончена. Ничья");
            System.exit(0);
        }
    }

    private static boolean checkWin(char symbol) {
        return (checkWinGor(symbol) || checkWinVert(symbol) || checkWinDiag(symbol));
    }

    private static boolean checkWinGor(char symbol) {
        for (int i = 1; i <= SIZE; i++) {
            kolX = 0;
            for (int j = 1; j < SIZE; j++) {
                if (gameField[i][j] == gameField[i][j + 1] && gameField[i][j] == symbol) {
                    kolX++;
                    if (kolX == KOLZ - 1) {
                        return true;
                    }
                } else kolX = 0;
            }
        }
        return false;
    }

    private static boolean checkWinVert(char symbol) {
        for (int j = 1; j <= SIZE; j++) {
            kolX = 0;
            for (int i = 1; i < SIZE; i++) {
                if (gameField[i][j] == gameField[i + 1][j] && gameField[i][j] == symbol) {
                    kolX++;
                    if (kolX == KOLZ - 1) {
                        return true;
                    }
                } else kolX = 0;
            }
        }
        return false;
    }

    private static boolean checkWinDiag(char symbol) {
        return checkWinDiag1(symbol) || checkWinDiag2(symbol);
    }

    private static boolean checkWinDiag1(char symbol) {
        //проверяем диагонали, начинающиеся на первой строке
        for (int j = 1; j <= SIZE - (KOLZ - 1); j++) {//меняетя j, проверка всегда начинается с 1 строки
            int i = 1;
            int step = j; //создаем буферную переменную, чтобы внутри дальнейшего цикла не затирать J, а менять только step
            for (diagObraytOtsch = SIZE - j; diagObraytOtsch >= 1; diagObraytOtsch--) {//рассчитываем количество проверок по диагонали(всегда на 1 меньше,чем элементов, тк,по-сути, это интервалы)
                if (gameField[i][step] == gameField[i + 1][step + 1] && gameField[i][step] == symbol) {
                    kolX++;
                    if (kolX == KOLZ - 1) {//интервалов на 1 меньше, чем элементов для победы
                        return true;
                    }
                } else kolX = 0;
                i++;
                step++;
            }
        }

        //проверяем диагонали, начинающиеся на первом столбце
        for (int i = 1; i <= SIZE - (KOLZ - 1); i++) {//меняетя i, проверка всегда начинается с 1 столбца
            int j = 1;
            int step = i; //создаем буферную переменную, чтобы внутри дальнейшего цикла не затирать J, а менять только step
            for (diagObraytOtsch = SIZE - i; diagObraytOtsch >= 1; diagObraytOtsch--) {//рассчитываем количество проверок по диагонали(всегда на 1 меньше,чем элементов, тк,по-сути, это интервалы)
                if (gameField[step][j] == gameField[step + 1][j + 1] && gameField[step][j] == symbol) {
                    kolX++;
                    if (kolX == KOLZ - 1) {
                        return true;
                    }
                } else kolX = 0;
                j++;
                step++;
            }
        }
        return false;
    }

    private static boolean checkWinDiag2(char symbol) {
        //проверяем диагонали, начинающиеся на первой строке
        for (int j = SIZE; j >= KOLZ; j--) {//меняетя j, проверка всегда начинается с 1 строки
            int i = 1;
            int step = j; //создаем буферную переменную, чтобы внутри дальнейшего цикла не затирать J, а менять только step
            for (diagObraytOtsch = step - 1; diagObraytOtsch >= 1; diagObraytOtsch--) {//рассчитываем количество проверок по диагонали(всегда на 1 меньше,чем элементов, тк,по-сути, это интервалы)
                if (gameField[i][step] == gameField[i + 1][step - 1] && gameField[i][step] == symbol) {
                    kolX++;
                    if (kolX == KOLZ - 1) {
                        return true;
                    }
                } else kolX = 0;
                i++;
                step--;
            }
        }

        //проверяем диагонали, начинающиеся на первом столбце
        for (int i = 1; i <= SIZE - (KOLZ - 1); i++) {//меняетя i, проверка всегда начинается с последнего столбца
            int j = SIZE;
            int step = i; //создаем буферную переменную, чтобы внутри дальнейшего цикла не затирать J, а менять только step
            for (diagObraytOtsch = SIZE - i; diagObraytOtsch >= 1; diagObraytOtsch--) {//рассчитываем количество проверок по диагонали(всегда на 1 меньше,чем элементов, тк,по-сути, это интервалы)
                if (gameField[step][j] == gameField[step + 1][j - 1] && gameField[step][j] == symbol) {
                    kolX++;
                    if (kolX == KOLZ - 1) {
                        return true;
                    }
                } else kolX = 0;
                j--;
                step++;
            }
        }
        return false;
    }

    private static boolean checkCount() {
        return count == SIZE * SIZE;
    }

    private static void turnAI() {

        //условие, чтобы выполнялся лишь 1 метод, хотя и так выполнялся лишь 1 без условия и без возврата(boolean), но это создавало предпосылки для багов
        if (checkToBlockGor()) {

        } else if (checkToBlockVert()) {
        } else if (checkToBlockDiag()) {

        } else {
            do {
                coordX = random.nextInt(SIZE) + 1;
                coordY = random.nextInt(SIZE) + 1;
            } while (!(checkEmpty(coordX, coordY)));
            gameField[coordX][coordY] = FIELD_AI;
        }
        count++;
    }

    private static boolean checkToBlockGor() {
        //метод для определения ситуации по горизонтали, ХХ0 или 0ХХ и сразу заблокировать
        for (int i = 1; i <= SIZE; i++) {
            kolX = 0;
            for (int j = 1; j <= SIZE; j++) {

                if (gameField[i][j] == gameField[i][j - 1] && gameField[i][j] == FIELD_USER) { // определяе ХХ

                    if ((j - 2) > 0 && gameField[i][j - 3] == FIELD_AI) { // определяем 0ХХ
                        if ((j + 1) <= SIZE && gameField[i][j + 1] == FIELD_DOT) { // определяем, свободна ли точка, если да, то ставим 0
                            gameField[i][j + 1] = FIELD_AI;   //блокируем: 0ХХ0
                            return true;
                        }
                    } else if ((j + 1) <= SIZE && gameField[i][j + 1] == FIELD_AI) {  // определяем ХХ0
                        if ((j - 2) > 0 && gameField[i][j - 3] == FIELD_DOT) {  // определяем, свободна ли точка, если да, то ставим 0
                            gameField[i][j - 3] = FIELD_AI; //блокируем: 0ХХ0
                            return true;
                        }
                    } else if ((j + 1) <= SIZE && gameField[i][j + 1] == FIELD_DOT) { // определяем, свободна ли точка, если да, то ставим 0
                        gameField[i][j + 1] = FIELD_AI;   //ставим ХХ0
                        return true;
                    } else if ((j - 2) > 0 && gameField[i][j - 3] == FIELD_DOT) {  // определяем, свободна ли точка, если да, то ставим 0
                        gameField[i][j - 3] = FIELD_AI; //ставим 0ХХ
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean checkToBlockVert() {
        //метод для определения ситуации по вертикали, ХХ0 или 0ХХ и сразу заблокировать
        for (int j = 1; j <= SIZE; j++) {
            kolX = 0;
            for (int i = 1; i <= SIZE; i++) {
                if (gameField[i][j] == gameField[i - 1][j] && gameField[i][j] == FIELD_USER) { // определяе ХХ

                    if ((j - 2) > 0 && (i - 3) > 0 && gameField[i - 3][j] == FIELD_AI) { // определяем 0ХХ
                        if ((i + 1) <= SIZE && gameField[i + 1][j] == FIELD_DOT) { // определяем, свободна ли точка, если да, то ставим 0
                            gameField[i + 1][j] = FIELD_AI;   //блокируем: 0ХХ0
                            return true;
                        }
                    } else if ((i + 1) <= SIZE && gameField[i + 1][j] == FIELD_AI) {  // определяем ХХ0
                        if ((i - 2) > 0 && gameField[i - 3][j] == FIELD_DOT) {  // определяем, свободна ли точка, если да, то ставим 0
                            gameField[i - 3][j] = FIELD_AI; //блокируем: 0ХХ0
                            return true;
                        }
                    } else if ((i + 1) <= SIZE && gameField[i + 1][j] == FIELD_DOT) { // определяем, свободна ли точка, если да, то ставим 0
                        gameField[i + 1][j] = FIELD_AI;   //ставим ХХ0
                        return true;
                    } else if ((i - 2) > 0 && gameField[i - 3][j] == FIELD_DOT) {  // определяем, свободна ли точка, если да, то ставим 0
                        gameField[i - 3][j] = FIELD_AI; //ставим 0ХХ
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean checkToBlockDiag() {

        return (checkToBlockDiag1() || checkToBlockDiag2());
    }

    public static boolean checkToBlockDiag1() {
        //проверяем диагонали, начинающиеся на первой строке
        for (int j = 1; j <= SIZE - 1; j++) {//меняетя j, проверка всегда начинается с 1 строки
            int i = 1;
            int step = j; //создаем буферную переменную, чтобы внутри дальнейшего цикла не затирать J, а менять только step
            for (diagObraytOtsch = SIZE - j; diagObraytOtsch >= 1; diagObraytOtsch--) {//рассчитываем количество проверок по диагонали(всегда на 1 меньше,чем элементов, тк,по-сути, это интервалы)
                if (gameField[i][step] == gameField[i + 1][step + 1] && gameField[i][step] == FIELD_USER) {
                    if ((step + 2) <= SIZE && gameField[i + 2][step + 2] == FIELD_DOT) {
                        gameField[i + 2][step + 2] = FIELD_AI;
                        return true;
                    } else if (gameField[i - 1][step - 1] == FIELD_DOT) {
                        gameField[i - 1][step - 1] = FIELD_AI;
                        return true;
                    }
                } else kolX = 0;
                i++;
                step++;
            }
        }

        //проверяем диагонали, начинающиеся на первом столбце
        for (int i = 1; i <= SIZE - 1; i++) {//меняетя i, проверка всегда начинается с 1 строки
            int j = 1;
            int step = i; //создаем буферную переменную, чтобы внутри дальнейшего цикла не затирать J, а менять только step
            for (diagObraytOtsch = SIZE - i; diagObraytOtsch >= 1; diagObraytOtsch--) {//рассчитываем количество проверок по диагонали(всегда на 1 меньше,чем элементов, тк,по-сути, это интервалы)
                if (gameField[step][j] == gameField[step + 1][j + 1] && gameField[step][j] == FIELD_USER) {
                    if ((step + 2) <= SIZE && gameField[step + 2][j + 2] == FIELD_DOT) {
                        gameField[step + 2][j + 2] = FIELD_AI;
                        return true;
                    } else if (gameField[step - 1][j - 1] == FIELD_DOT) {
                        gameField[step - 1][j - 1] = FIELD_AI;
                        return true;
                    }
                } else kolX = 0;
                j++;
                step++;
            }
        }
        return false;
    }

    private static boolean checkToBlockDiag2() {
        //проверяем диагонали, начинающиеся на первой строке
        for (int j = SIZE; j >= 2; j--) {//меняетя j, проверка всегда начинается с 1 строки
            int i = 1;
            int step = j; //создаем буферную переменную, чтобы внутри дальнейшего цикла не затирать J, а менять только step
            for (diagObraytOtsch = step - 1; diagObraytOtsch >= 1; diagObraytOtsch--) {//рассчитываем количество проверок по диагонали(всегда на 1 меньше,чем элементов, тк,по-сути, это интервалы)
                if (gameField[i][step] == gameField[i + 1][step - 1] && gameField[i][step] == FIELD_USER) {
                    if ((i + 2) <= SIZE && (step - 2) > 0 && gameField[i + 2][step - 2] == FIELD_DOT) {
                        gameField[i + 2][step - 2] = FIELD_AI;
                        return true;
                    } else if ((i - 1) > 0 && (step + 1) <= SIZE && gameField[i - 1][step + 1] == FIELD_DOT) {
                        gameField[i - 1][step + 1] = FIELD_AI;
                        return true;
                    }
                } else kolX = 0;
                i++;
                step--;
            }
        }

        //проверяем диагонали, начинающиеся на первом столбце
        for (int i = 2; i <= SIZE; i++) {//меняетя i, проверка всегда начинается с 1 строки
            int j = SIZE;
            int step = i; //создаем буфе1
            // рную переменную, чтобы внутри дальнейшего цикла не затирать J, а менять только step
            for (diagObraytOtsch = SIZE - i; diagObraytOtsch >= 1; diagObraytOtsch--) {//рассчитываем количество проверок по диагонали(всегда на 1 меньше,чем элементов, тк,по-сути, это интервалы)
                if (gameField[step][j] == gameField[step + 1][j - 1] && gameField[step][j] == FIELD_USER) {
                    if ((step + 2) <= SIZE && (j - 1) > 0 && gameField[step + 2][j - 2] == FIELD_DOT) {
                        gameField[step + 2][j - 2] = FIELD_DOT;
                        return true;
                    } else if ((step - 1) > 0 && (j + 1) <= SIZE && gameField[step - 1][j + 1] == FIELD_DOT) {
                        gameField[step - 1][j + 1] = FIELD_AI;
                        return true;
                    }
                } else kolX = 0;
                j--;
                step++;
            }
        }
        return false;
    }

    private static void arrayPrint(char[][] gameField) {
        for (int i = 0; i <= SIZE; i++) {
            for (int j = 0; j <= SIZE; j++) {
                System.out.print(gameField[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
