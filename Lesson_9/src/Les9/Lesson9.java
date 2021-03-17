package Les9;


public class Lesson9 {

    static int sizeX = 4;
    static int sizeY = 4;

    public static void main(String[] args) {


        String[][] arr = new String[sizeX][sizeY];

        int k = 0; //Для заполнения массива цифрами в формате String
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                arr[i][j] = String.valueOf(k);
                k++;
            }
        }

        arr[1][1] = "ф";   //это специально для проверки MyArrayDataException


        try {
            checkArrayData(arr);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }

    }

    private static void checkArrayData(String[][] arr) throws MyArraySizeException, MyArrayDataException {

        if (arr.length != 4 || arr[0].length != 4) {
            throw new MyArraySizeException();
        }

        int sum = 0;

        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length; j++) {

                try {
                    Integer.parseInt(arr[i][j]);
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
    }
}
