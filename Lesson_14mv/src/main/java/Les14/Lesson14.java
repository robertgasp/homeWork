package Les14;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.*;

public class Lesson14 {

    static int size;
    static int[] outputArray;
    protected static final Logger logger = Logger.getLogger("Проверка наличия цифры 4 в массиве");


    public static void main(String[] args) throws IOException {
        logger.setLevel(Level.ALL);

        Handler handler = new FileHandler("src/main/resources/logs/logEx1.log");
        logger.addHandler(handler);
        handler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return record.getLevel() + ": " + record.getSourceMethodName() + " " + record.getMessage() + "\n";
            }
        });

        logger.getHandlers()[0].setLevel(Level.ALL);

        int[] inputArray = {1, 2, 3, 2, 5, 2, 1, 8, 9, 10};

        makeNewArray(inputArray);
        System.out.println(Arrays.toString(outputArray));
        System.out.println();

        int[] arr31 = {1, 2, 3, 4, 5, 6};
        int[] arr32 = {1, 1, 1, 2, 2, 2};
        int[] arr33 = {4, 4, 4, 3, 2};

        exercise3(arr31);
        exercise3(arr32);
        exercise3(arr33);
    }


    protected static int[] makeNewArray(int[] inputArray) throws RuntimeException {

        int stop = 0;
        for (int i = inputArray.length - 1; i >= 0; i--) {
            if (inputArray[i] == 4) {
                size = inputArray.length - i - 1;//тк объект с индеком i=4 нам не нужен
                stop = 0;
                break;
            } else stop = 1;
        }


        if (stop == 1) {
            logger.warning("в массиве " + Arrays.toString(inputArray) + " отсутствует цифра 4");
            throw new RuntimeException();
        }

        outputArray = new int[size];
        int k = 0;

        for (int j = (inputArray.length - size); j < inputArray.length; j++) {
            outputArray[k] = inputArray[j];
            k++;
        }
        return outputArray;
    }


    protected static boolean exercise3(int[] arr) {
        int k1 = 0;
        int k4 = 0;

        for (int i : arr) {
            if (i == 1) {
                k1++;
            }
            if (i == 4) {
                k4++;
            }
        }

        if (k1 > 0 && k4 > 0) {
            System.out.println(Arrays.toString(arr) + "-> true. В массиве встречаются и 1, и 4");
            return true;
        } else {
            System.out.println(Arrays.toString(arr) + "-> false");
            return false;
        }
    }
}
