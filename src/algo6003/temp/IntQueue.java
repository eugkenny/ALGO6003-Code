package algo6003.temp;

public class IntQueue {
    int [] queue;
    int head = 0;
    int tail = 0;
    int count = 0;

    public IntQueue(){
        queue = new int[4];
    }

    public boolean isEmpty(){
        return head == tail;
    }

    public void enqueue(int i){
        if(queue.length - count == 1){
            resize(queue.length*2);
        }
        queue[tail] = i;
        tail = (tail+1) % queue.length;
        count++;
    }

    public int dequeue(){
        int item = queue[head];
        queue[head] = 0;
        head = (head+1) % queue.length;
        count--;

        return item;
    }

    private void resize(int newCapacity){
        int [] temp = new int [newCapacity];
        //System.arraycopy(queue, 0, temp, 0, queue.length);
        for(int i = 0; i < queue.length; i++){
            temp[i] = queue[(i + head) % queue.length];
        }
        queue = temp;
    }

    private void printArray(){
        System.out.print("[");
        for(int i = 0; i < queue.length - 1; i++){
            System.out.print(queue[i] + ",");
        }
        System.out.println(queue[queue.length - 1] + "] \t H: " + head + "\t T: " + tail);
    }

    public static void main(String[] args) {
        IntQueue iq = new IntQueue();

        iq.printArray();

        iq.enqueue(10);
        iq.enqueue(20);

        iq.printArray();

        System.out.println("Empty?: " + iq.isEmpty());

        System.out.println(iq.dequeue());
        System.out.println(iq.dequeue());

        iq.printArray();

        System.out.println("Empty?: " + iq.isEmpty());

        iq.enqueue(30);
        iq.enqueue(40);

        iq.printArray();

        System.out.println(iq.dequeue());
        System.out.println(iq.dequeue());

        iq.printArray();

        iq.enqueue(50);
        iq.enqueue(60);
        iq.enqueue(70);
        iq.printArray();
        iq.enqueue(80);
        iq.printArray();
        System.out.println("Empty?: " + iq.isEmpty());

        iq.enqueue(90);
        iq.printArray();
        iq.enqueue(100);

        iq.printArray();

        System.out.println(iq.dequeue());
        System.out.println(iq.dequeue());

        iq.printArray();
    }
}
