import java.util.concurrent.locks.ReentrantReadWriteLock;

public class A3_Q8 {
    private String message = "Initial Notice";
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    // Method to read the message
    public void readNotice(String readerName) {
        rwLock.readLock().lock();
        try {
            System.out.println(readerName + " is reading: " + message);
            Thread.sleep(1000); // Simulate time taken to read
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            rwLock.readLock().unlock();
        }
    }

    // Method to write/update the message
    public void writeNotice(String writerName, String newMessage) {
        System.out.println(writerName + " is waiting to write...");
        rwLock.writeLock().lock();
        try {
            System.out.println(writerName + " is writing...");
            Thread.sleep(2000); // Simulate time taken to write
            this.message = newMessage;
            System.out.println(writerName + " updated the notice to: " + message);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        A3_Q8 board = new A3_Q8();

        // Multiple readers
        Runnable reader = () -> board.readNotice(Thread.currentThread().getName());

        // One writer
        Runnable writer = () -> board.writeNotice(Thread.currentThread().getName(), "New Notice from " + Thread.currentThread().getName());

        // Creating threads
        Thread t1 = new Thread(reader, "Reader-1");
        Thread t2 = new Thread(reader, "Reader-2");
        Thread t3 = new Thread(writer, "Writer-1");
        Thread t4 = new Thread(reader, "Reader-3");
        Thread t5 = new Thread(writer, "Writer-2");

        // Start threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}