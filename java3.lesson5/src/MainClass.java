import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class MainClass {

    public static final int CARS_COUNT = 4;
    static CyclicBarrier cb = new CyclicBarrier(CARS_COUNT);


    public static void main(String[] args)  {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(new Semaphore(CARS_COUNT / 2)), new Road(40));

        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10),new CountDownLatch(CARS_COUNT));

        }


        for (int i = 0; i < cars.length; i++) {
            new Thread((Runnable) cars[i]).start();

        }
        }

    }

