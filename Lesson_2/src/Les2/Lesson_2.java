package Les2;

import java.util.Arrays;

public class Lesson_2 {

    public static void main(String[] args) {

        //первое задание
        System.out.println("Задание №1");
        int[] arr1 = new int[]{1, 0, 0, 1, 1, 0, 1, 0, 1};

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == 0) {
                arr1[i] = 1;
            } else arr1[i] = 0;
        }

        System.out.print(Arrays.toString(arr1) + "\n");
        System.out.println("");


        //второе задание
        System.out.println("Задание №2");
        int[] arr2 = new int[8];

        int b = 0;
        for (int a = 0; a < 8; a++) {
            arr2[a] = b;
            b += 3;
        }

        System.out.print(Arrays.toString(arr2) + "\n");
        System.out.println("");


        //третье задание
        System.out.println("Задание №3");
        int[] arr3 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int c = 0; c < arr3.length; c++) {

            if (arr3[c] < 6) {
                arr3[c] *= 3;
            }
        }

        System.out.print(Arrays.toString(arr3) + "\n");
        System.out.println("");

        //четвертое задание
        System.out.println("Задание №4");
        arr4Konstr(5, 5);
        System.out.println("");


        //пятое задание
        System.out.println("Задание №5");
        int[] arr5 = new int[]{7, 3, 5, -10, 50, 25, 8};

        int minArr5 = 0;
        int maxArr5 = 0;

        for (int k = 0; k < arr5.length; k++) {

            if (minArr5 > arr5[k]) {
                minArr5 = arr5[k];
            }

            if (maxArr5 < arr5[k]) {
                maxArr5 = arr5[k];
            }
        }

        System.out.println("У массива: " + Arrays.toString(arr5) + "  минимальное значение = " + minArr5 + "; максимальное значение = " + maxArr5);
        System.out.println("");

        //шестое задание
        System.out.println("Задание №6");
        int[] arr6 = {1, 3, 5, 4, 1, 2, 2};
        checkBalance(arr6);
        System.out.println("");


        //седьмое задание
        System.out.println("Задание №7");
        int[] arr7 = {1, 2, 3, 4, 5, 10};
        System.out.println("Исходный массив: " + Arrays.toString(arr7));
        sdvigArr(arr7, 2);
        sdvigArr(arr7, -2);
        sdvigArr(arr7, -3);
    }

    private static void arr4Konstr(int d, int e) {
        int[][] arr4 = new int[d][e];

        for (int f = 0; f < d; f++) {
            arr4[f][f] = 1;

        }
        int g = e - 1;

        for (int f = 0; f < d; f++) {

            arr4[f][g] = 1;
            g--;
        }

        for (int h = 0; h < d; h++) {
            for (int j = 0; j < e; j++) {
                System.out.print(arr4[h][j] + " ");
            }
            System.out.println("");
        }
    }

    private static boolean checkBalance(int[] arr6) {

        int sum1 = 0; //сумма левой части массива для сравнения
        int sum2 = 0; //сумма правой части массива для сравнения

        int l;
        int m = 0;

        for (l = 0; l < arr6.length; l++) {
            sum1 += arr6[l];

            for (m = l + 1; m < arr6.length; m++) {
                sum2 += arr6[m];
            }
            m = 0;

            if (sum1 == sum2) {
                System.out.println("Массив " + Arrays.toString(arr6) + " имеет среднее значение между символами под номерами №" + (l + 1) + " = " + arr6[l] + " и №" + (l + 2) + " = " + arr6[l + 1]);
                //при выводе специально к номерам элементов массива прибавил 1, тк для пользователь начнет отсчет номера элемента отображаемого массива не с 0, а с 1, как мы все привыкли считать
                break;
            }
            sum2 = 0;

        }
        System.out.println("Сумма левой части = " + sum1 + " так же, как и сумма правой части = " + sum2);
        return sum1 == sum2;
    }

    private static void sdvigArr(int[] arr7, int n) {

        int bufer;

        for (int p = 1; p <= arr7.length + n; p++) {

            bufer = arr7[arr7.length - 1];

            for (int q = arr7.length - 1; q > 0; q--) {
                arr7[q] = arr7[q - 1];
            }
            arr7[0] = bufer;
        }

        System.out.println("Шаг смещения = " + n);
        System.out.println("Полученный смещенный массив: " + Arrays.toString(arr7));
    }
}

