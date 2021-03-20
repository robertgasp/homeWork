package Les10;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class PhoneBook {

    private static ArrayList<String> arrayPB = new ArrayList<>();
    static Map<String, ArrayList> phoneBook = new LinkedHashMap<>();

    private String name;
    private String number;


    public PhoneBook(String name, String number) {
        this.name = name;
        this.number = number;
        add(name, number);
    }

    public static void add(String name, String number) {
        arrayPB.add(number);
        phoneBook.put(name, arrayPB);
    }

    public static void get(String name) {
        for (Map.Entry<String, ArrayList> entry : phoneBook.entrySet()) {
            if (entry.getKey().equals(name)) {
                System.out.println(MessageFormat.format("Имя: {0} тел.: {1}", entry.getKey(), entry.getValue()));
            } else System.out.println("Не найдено записей в телефонной книге");
        }
    }
}
