package Les9;


public class MyArrayDataException extends NumberFormatException {


    public MyArrayDataException() {
        super("Неверный тип данных в массиве");

    }

    public MyArrayDataException(int i, int j) {
        super("Неверный тип данных в ячейке [" + i + "][" + j + "]");
    }


}
