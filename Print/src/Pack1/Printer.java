import Pack1.PrintTask;
import Pack1.PrinterQueue;

public class Main {
    public static void main(String[] args) {
        PrinterQueue printerQueue = new PrinterQueue();

        // Create print tasks
        PrintTask task1 = new PrintTask("Document1");
        PrintTask task2 = new PrintTask("Document2");
        PrintTask task3 = new PrintTask("Document3");

        // Enqueue print tasks
        printerQueue.enqueue(task1);
        printerQueue.enqueue(task2);
        printerQueue.enqueue(task3);

        // Peek at the front of the queue
        PrintTask peekedTask = printerQueue.peek();
        if (peekedTask != null) {
            System.out.println("Peeked: " + peekedTask.getTaskName());
        }

        // Dequeue and print tasks
        while (!printerQueue.isEmpty()) {
            PrintTask currentTask = printerQueue.dequeue();
            System.out.println("Printing: " + currentTask.getTaskName());
        }

        // Clear the queue
        printerQueue.clear();
        System.out.println("Queue cleared. Is empty: " + printerQueue.isEmpty());
    }
}
