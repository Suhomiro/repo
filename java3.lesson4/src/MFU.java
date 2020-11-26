public class MFU {
    Object printLock = new Object();
    Object scanLock = new Object();

    public void print(String letter, int number) {
        synchronized (printLock) {
            System.out.println("Starting print");
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Print end");
    }

    public void scan(String letter, int number, int source) {
        synchronized (scanLock) {
            System.out.println("Starting scan");
            switch (source) {
                case 1:
                    System.out.println("Starting scan");
                    for (int i = 0; i < 5; i++) {
                        System.out.println(i);
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    synchronized (printLock) {
                        System.out.println("Starting xerox");
                        for (int i = 0; i < 5; i++) {
                            System.out.println(i);
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("xerox end");
                        break;
                    }
            }
            System.out.println("Scan end");
        }
    }
}
