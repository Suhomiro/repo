public class Main {

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread('A', 'B'));
        t1.start();
        Thread t2 = new Thread(new MyThread('B', 'C'));
        t2.start();
        Thread t3 = new Thread(new MyThread('C', 'A'));
        t3.start();
    }
}
