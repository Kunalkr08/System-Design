package thread;

public class Thread1 {
    public static void main(String[] args) {

        Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Child Thread: " + i);
            }
        });

        t.start(); // Starts a new thread

        try {
            t.join(); // Main thread waits
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted!");
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("Main Thread: " + i);
        }
    }
}
