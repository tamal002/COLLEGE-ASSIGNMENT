import java.util.Scanner;

class SharedVariable {
    private int value = 0;

    public synchronized void increment(int amount) {
        value += amount;
    }

    public synchronized void decrement(int amount) {
        value -= amount;
    }

    public int getValue() {
        return value;
    }
}

class IncrementThread extends Thread {
    private SharedVariable shared;
    private int amount;

    public IncrementThread(SharedVariable shared, int amount) {
        this.shared = shared;
        this.amount = amount;
    }

    public void run() {
        shared.increment(amount);
    }
}

class DecrementThread extends Thread {
    private SharedVariable shared;
    private int amount;

    public DecrementThread(SharedVariable shared, int amount) {
        this.shared = shared;
        this.amount = amount;
    }

    public void run() {
        shared.decrement(amount);
    }
}

public class A3_Q5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            SharedVariable shared = new SharedVariable();

            System.out.print("Enter amount to increment: ");
            int incAmount = scanner.nextInt();
            System.out.print("Enter amount to decrement: ");
            int decAmount = scanner.nextInt();

            Thread t1 = new IncrementThread(shared, incAmount);
            Thread t2 = new IncrementThread(shared, incAmount);
            Thread t3 = new DecrementThread(shared, decAmount);
            Thread t4 = new DecrementThread(shared, decAmount);

            t1.start();
            t2.start();
            t3.start();
            t4.start();

            try {
                t1.join();
                t2.join();
                t3.join();
                t4.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Final value: " + shared.getValue());
            System.out.print("Repeat (y/n)? ");
            String choice = scanner.next();
            if (!choice.equalsIgnoreCase("y")) {
                break;
            }
        }

        scanner.close();
    }
}