package Les12;

public class Lesson12 {

    public final static int SIZE = 10000000;
    public final static int HALF = SIZE / 2;

    public static void main(String[] args) {

        float[] arr = new float[SIZE];
        float[] arr2 = new float[SIZE];

        oneThreadExection(arr);
        twoThreadExection(arr2);
    }


    public static void oneThreadExection(float[] arr) {

        long s = System.currentTimeMillis();

        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long e = System.currentTimeMillis();
        System.out.println("Время выполнения однопоточного вычисления: " + (e - s) + " мс");
    }


    private static void twoThreadExection(float[] arr2) {
        long s = System.currentTimeMillis();
        var t1 = new Thread(() -> fillHalfArray1(arr2));
        var t2 = new Thread(() -> fillHalfArray2(arr2));
        t1.start();
        t2.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long e = System.currentTimeMillis();
        System.out.println("Время выполнения двухпоточного вычисления: " + (e - s) + " мс");
    }

    private static void fillHalfArray1(float[] arr2) {

        for (int i = 0; i < HALF; i++) {
            arr2[i] = (float) (arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }



    private static void fillHalfArray2(float[] arr2) {

        for (int i = HALF; i < SIZE; i++) {
            arr2[i] = (float) (arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

}
