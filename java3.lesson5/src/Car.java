import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;


public class Car implements Runnable{

    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    public static CountDownLatch latch;

    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CountDownLatch latch) {
        this.race = race;
        this.speed = speed;
        this.latch = latch;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;

    }
    @Override
    public void run() {
        System.out.println(this.name + " готовится");
        try {

            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            latch.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            latch.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            try {
                race.getStages().get(i).go(this);
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }


        }
    }
}
