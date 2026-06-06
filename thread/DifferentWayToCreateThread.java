package thread;

public class DifferentWayToCreateThread {
    // There are three different way to create thread in java

    // Way 1 (Extend Thread class)
    static class MyThread extends Thread {
        public void run() {
            System.out.println("Child Thread");
        }
    }

    static class Test {
        public static void main(String[] args) {
            MyThread t = new MyThread();
            t.start();
        }
    }

    // Way 2 (Implement Runnable)
    static class MyTask implements Runnable {
        public void run() {
            System.out.println("Child Thread1");
        }
    }

    static class Test1 {
        public static void main(String[] args) {
            Thread t = new Thread(new MyTask());
            t.start();
        }
    }

    // Way 3 (Lambda Expression) 
    static class Test2 {
        public static void main(String[] args) {
            Thread t = new Thread(() -> {
                System.out.println("Hello");
            });

            t.start();
        }
    }
}
