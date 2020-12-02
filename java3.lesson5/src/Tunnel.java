import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Tunnel extends Stage{
    Semaphore semaphore;
    ReentrantLock lock = new ReentrantLock();
    CyclicBarrier cb = new CyclicBarrier(1);
    public Tunnel(Semaphore semaphore) {
        this.semaphore = semaphore;
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }
    @Override
    public void go(Car c) {
        try {
            try {
                semaphore.acquire();
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);

                }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
