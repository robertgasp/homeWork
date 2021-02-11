package Les2;

public class Bonusnoe_Zadanie {

    public static void main(String[] args) {

//Бонусное задание: на уроке Тимофей предложил всем желающим написать программу на заполнение двумерного
//массива по архимедовой спирали против часовой стрелки. Решение этой задачи ниже:

        arrArch(7, 6); //метод для создания массива размерами axb
    }

    private static void arrArch(int a, int b) {

        int[][] arr = new int[a][b];
        int size = (a * b);  //определили количество заполняемых элементов
        int z = 0;  //числовые значения элементов массива
        int i = 0;   //переменная для перебора вертикальных значений
        int j = 0;   //переменная для перебора горизонтальных значерий
        int c = 0;   //переменная для уменьшения конечных значений индекса при заполнении столбцов сверху вниз (на сколько не дойдет до низа матрицы)
        int d = 0;  //переменная для уменьшения конечных значений индекса при заполнении строк слева направо (на сколько не дойдет до правой части матрицы)
        int e = 0;  //переменная для уменьшения конечных значений индекса при заполнении столбца снизу вверх (на сколько не дойдет до верхней части матрицы)
        int f = 1;  //переменная для уменьшения конечных значений индекса при заполнении столбца слева направо (на сколько не дойдет до верхней части матрицы)


        while (z < size) {   //создаем главный цикл while, в котором будут подставляться значения в ячейки массива

            //Движение сверху вниз
            while ((i < a - c) && (z < size)) { //Дополнительное условие (z < size), чтобы в нужный момент остановить заполнение, если не дошли до конца главного цикла
                arr[i][j] = z++;
                i++;
            }

            i--;
            c++; //увеличили значение переменной, чтобы впоследствии на эту величину не доходить до низа матрицы и не заполнять повторно ячейки
            j++; //сместили на 1 ячейку вправо, чтобы повторноее не заполнить

            //Движение слева еаправо
            while ((j < b - d) && (z < size)) {
                arr[i][j] = z++;
                j++;
            }

            j--;
            d++;
            i--;

            //Движение снизу вверх
            while ((i >= e) && (z < size)) {
                arr[i][j] = z++;
                i--;
            }

            i++;
            e++;
            j--;

            //Движение справа налево
            while ((j >= f) && (z < size)) {
                arr[i][j] = z++;
                j--;
            }

            i++;
            j++;
            f++;
        }
        for (i = 0; i < a; i++) {
            for (j = 0; j < b; j++) {
                System.out.printf("%4d", arr[i][j]);
            }
            System.out.println("");
        }

    }

}

