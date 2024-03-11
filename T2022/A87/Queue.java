package T2022.A87;

public class Queue {
    private int[] queue;
    private int front;
    private int rear;

    public Queue(int capacity) {
        queue = new int[capacity];
        front = 0;
        rear = -1;
    }

    public Queue() {
        this(0); // default capacity of 10
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int item = queue[front];
        front++;
        return item;
    }

    public void enqueue(int item) {
        if (rear == queue.length - 1) {
            throw new IllegalStateException("Queue is full");
        }
        rear++;
        queue[rear] = item;
    }

    public boolean isEmpty() {
        return front > rear;
    }

    public int length() {
        return rear - front + 1;
    }

    public void printQueue() {
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    public static Queue what(Queue q) {
        int length = q.length();
        Queue q1 = new Queue(length);
        for (int i = 0; i < length / 2; i++) {
            int num = q.dequeue();
            q1.enqueue(num);
            q1.printQueue();
            // q1 = {1,2,3}
            // q = {4,5,6}
        }

        Queue q2 = new Queue(length);
        for (int i = 0; i < length / 2; i++) {
            int num = q1.dequeue();
            q2.enqueue(num);
            num = q.dequeue();
            q2.enqueue(num);
            q2.printQueue();
            // q2 = {1,4,2,5,3,6}
        }
        q.printQueue();
        Queue q3 = new Queue(length); 
        for (int i = 0; i < length; i++) {
            int num = q2.dequeue();
            q3.enqueue(num);
            // q = {}
        }
        q3.printQueue();
        return q;
    }

    public static void main(String args[]) {
        Queue queue = new Queue(6);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);

        queue.what(queue);
        queue.printQueue();
    }
}
