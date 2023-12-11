import java.util.Arrays;

class PrinterQueue {
    private static final int DEFAULT_CAPACITY = 10;
    private PrintTask[] queue;
    private int size;

    public PrinterQueue() {
        this.queue = new PrintTask[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public void enqueue(PrintTask printTask) {
        ensureCapacity();
        queue[size++] = printTask;
    }

    public PrintTask dequeue() {
        if (!isEmpty()) {
            PrintTask removedTask = queue[0];
            System.arraycopy(queue, 1, queue, 0, size - 1);
            queue[--size] = null;
            return removedTask;
        } else {
            System.out.println("Queue is empty. Cannot dequeue.");
            return null; // or throw an exception if you prefer
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public PrintTask peek() {
        if (!isEmpty()) {
            return queue[0];
        } else {
            System.out.println("Queue is empty. Cannot peek.");
            return null; // or throw an exception if you prefer
        }
    }

    public void clear() {
        Arrays.fill(queue, null);
        size = 0;
    }

    private void ensureCapacity() {
        if (size == queue.length) {
            int newCapacity = queue.length * 2;
            queue = Arrays.copyOf(queue, newCapacity);
        }
    }
}

class PrintTask {
    private String taskName;

    public PrintTask(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }
}