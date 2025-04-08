import java.util.concurrent.Semaphore;

public class A3_Q6 {
    private int n;
    private int current = 1;
    private final Semaphore fizz = new Semaphore(0);
    private final Semaphore buzz = new Semaphore(0);
    private final Semaphore fizzbuzz = new Semaphore(0);
    private final Semaphore number = new Semaphore(1);

    public A3_Q6(int n) {
        this.n = n;
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        while (true) {
            fizz.acquire();
            if (current > n) break;
            printFizz.run();
            releaseNext();
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (true) {
            buzz.acquire();
            if (current > n) break;
            printBuzz.run();
            releaseNext();
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (true) {
            fizzbuzz.acquire();
            if (current > n) break;
            printFizzBuzz.run();
            releaseNext();
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        while (current <= n) {
            number.acquire();
            if (current > n) {
                fizz.release();
                buzz.release();
                fizzbuzz.release();
                break;
            }
            if (current % 3 == 0 && current % 5 == 0) {
                fizzbuzz.release();
            } else if (current % 3 == 0) {
                fizz.release();
            } else if (current % 5 == 0) {
                buzz.release();
            } else {
                printNumber.accept(current);
                releaseNext();
            }
        }
    }

    private void releaseNext() {
        current++;
        number.release();
    }

    // IntConsumer Interface
    interface IntConsumer {
        void accept(int x);
    }

    // Main method for testing
    public static void main(String[] args) {
        A3_Q6 fb = new A3_Q6(15);

        Thread A = new Thread(() -> {
            try {
                fb.fizz(() -> System.out.println("fizz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread B = new Thread(() -> {
            try {
                fb.buzz(() -> System.out.println("buzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread C = new Thread(() -> {
            try {
                fb.fizzbuzz(() -> System.out.println("fizzbuzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread D = new Thread(() -> {
            try {
                fb.number((number) -> System.out.println(number));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        A.start();
        B.start();
        C.start();
        D.start();
    }
}