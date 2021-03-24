package Les11;

import java.util.Arrays;

public class ChangeArray<T> {

    public T[] array;

    protected ChangeArray(T... array) {
        this.array = array;
    }

    public void replaceIndex() {
        T buffer;
        buffer = this.array[0];
        this.array[0] = array[1];
        this.array[1] = buffer;
    }

    public void outReplacedIndex() {
        System.out.println(Arrays.toString(this.array));
    }

}
