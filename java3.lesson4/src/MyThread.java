public class MyThread implements Runnable{
        static volatile char symbol = 'A';
        static Object object = new Object();

            private char currentSymbol;
            private char nextSymbol;

            MyThread (char currentSymbol, char nextSymbol) {
                this.currentSymbol = currentSymbol;
                this.nextSymbol = nextSymbol;
            }

            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    synchronized (object) {
                        try {
                            while (symbol != currentSymbol)
                                object.wait();
                            System.out.print(currentSymbol);
                            symbol = nextSymbol;
                            object.notifyAll();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }


