import java.io.PrintWriter;

public class Drinks {
    static class ChocolateProcess implements Runnable {
        private PrintWriter out;
        private Object lock;

        public ChocolateProcess(PrintWriter out, Object lock) {
            this.out = out;
            this.lock = lock;
        }

        public void run() {
            synchronized (lock) {
                try {
                    System.out.println(Thread.currentThread().getName() + " locked chocolate");
                    // Acquire the necessary ingredients
                    System.out.println("Adding chocolate powder...");
                    Thread.sleep(1000);
                    System.out.println("Pouring hot water...");
                    Thread.sleep(1000);
                    System.out.println("Adding milk...");
                    Thread.sleep(1000);
                    System.out.println("Mixing everything together...");
                    System.out.println(Thread.currentThread().getName() + " free chocolate");
                    // Output a message indicating that the drink is ready
                    out.println("Chocolate is ready.");
                    out.flush();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class CoffeeProcess implements Runnable {
        private PrintWriter out;
        private Object lock;

        public CoffeeProcess(PrintWriter out, Object lock) {
            this.out = out;
            this.lock = lock;
        }

        public void run() {
            synchronized (lock) {
                try {
                    System.out.println(Thread.currentThread().getName() + " locked coffee");
                    // Acquire the necessary ingredients
                    System.out.println("Adding coffee powder...");
                    Thread.sleep(2000);
                    System.out.println("Pouring hot water...");
                    Thread.sleep(2000);
                    System.out.println("Adding milk...");
                    Thread.sleep(2000);
                    System.out.println("Mixing everything together...");
                    System.out.println(Thread.currentThread().getName() + " free coffee");
                    // Output a message indicating that the drink is ready
                    out.println("Coffee is ready.");
                    //out.flush();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class TeaProcess implements Runnable {
        private PrintWriter out;
        private Object lock;

        public TeaProcess(PrintWriter out, Object lock) {
            this.out = out;
            this.lock = lock;
        }

        public void run() {
            synchronized (lock) {
                try {
                    // Acquire the necessary ingredients
                    System.out.println(Thread.currentThread().getName() + " locked tea");
                    System.out.println("Adding tea extract...");
                    Thread.sleep(1000);
                    System.out.println("Pouring hot water...");
                    Thread.sleep(1000);
                    System.out.println("Mixing everything together...");
                    // Output a message indicating that the drink is ready
                    System.out.println(Thread.currentThread().getName() + " free tea");
                    out.println("Tea is ready.");
                    out.flush();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class WaterProcess implements Runnable {
        private PrintWriter out;
        private Object lock;

        public WaterProcess(PrintWriter out, Object lock) {
            this.out = out;
            this.lock = lock;
        }

        public void run() {
            synchronized (lock) {
                try {
                    System.out.println(Thread.currentThread().getName() + " locked water");
                    // Acquire the necessary ingredients
                    System.out.println("Pouring water...");
                    Thread.sleep(1500);
                    // Output a message indicating that the drink is ready
                    out.println("Water is ready.");
                    System.out.println(Thread.currentThread().getName() + " free water");
                    out.flush();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
