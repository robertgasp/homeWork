package Les11;

import java.util.ArrayList;

public class ToArrayList<T> {

    private T[] array;
    ArrayList<T> arrayList = new ArrayList<>();

    public void toArrayList(T[] array) {

        for (T t : array) {
            arrayList.add(t);
        }

        System.out.println(arrayList.toString());

    }

}
