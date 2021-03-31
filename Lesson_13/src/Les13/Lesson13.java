package Les13;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Lesson13 {
    public static final int CARS_COUNT = 4;

    public static CountDownLatch onStart;
    public static CyclicBarrier startRacing;
    public static CountDownLatch endRacing;
    public static CountDownLatch win;


    public static void main(String[] args) {

        onStart = new CountDownLatch(CARS_COUNT);
        startRacing = new CyclicBarrier(CARS_COUNT);
        endRacing = new CountDownLatch(CARS_COUNT);
        win = new CountDownLatch(1);

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }


        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        try {
            onStart.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");


        try {
            win.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Победитель: " + Car.winner);


        try {
            endRacing.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}

