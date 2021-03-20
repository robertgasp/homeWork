package Les10;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Lesson10 {

    public static void main(String[] args) {

        exercise1();

        System.out.println();

        exercise2();
    }


    private static void exercise1() {
        String[] arrayOriginal = {"АБ", "АБ", "В", "АБ", "В", "В", "Д", "Д", "Г", "Е", "Е", "Ж"}; //Исходный массив

        ArrayList<String> arrayList1 = new ArrayList<>();

        for (int i = 0; i < arrayOriginal.length; i++) {    //Добавляю элементы в arrayList1, чтобы поле дальнейшего подсчета одинаковых слов и удалять их из arrayList1
            arrayList1.add(arrayOriginal[i]);

        }

        Map<String, Integer> map = new LinkedHashMap<>();

        //Создаем 2 переменных размером с массив arrayList1 для дальнейших циклов
        int icycle = arrayList1.size(); //переменная, которая будет уменьшать повторы цикла на величину найденных совпадений, тк из массива arrayList1 будут удаляться совпадения
        int jcycle = arrayList1.size(); //переменная цикла для сравнения всех значений массиива arrayList1 с первым элементом данного массива, в случае каждого совпадения будет уменьшаться


        while (icycle > 0) {
            int k = 1;//количество повторений слова (совпадений)
            int j = 1;//значение индекса элемента в цикле перебора

            while (jcycle > 0 && j < arrayList1.size()) {

                if (arrayList1.get(0).equals(arrayList1.get(j))) {
                    k++;
                    map.put(arrayList1.get(0), k);
                    arrayList1.remove(j); //удаляем элемент с индексом j
                    jcycle--; // увеличивать j нельзя, тк на место удаленного элемента поступает следующий за ним элемент, что обеспечивает необходимый сдвиг

                } else {
                    map.put(arrayList1.get(j), 1); //если в дальнейшем у данного слова найдутся повторения, то единица перезапишется на новое число
                    j++;
                }
            }
            arrayList1.remove(0);
            jcycle--;//уменьшаем еще на 1, тк удалили элемент с индексом [0]
            icycle = jcycle;//тк удалились элементы массива, то и главный цикл уменьшается на эту же величину

        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(MessageFormat.format("Слово: {0} встречается {1} раз(а)", entry.getKey(), entry.getValue()));

        }
    }

    private static void exercise2() {
        PhoneBook.add("Петров", "+7-925-140-85");
        PhoneBook.add("Петров", "+7-925-222-22");
        PhoneBook.get("Петров");
    }
}
