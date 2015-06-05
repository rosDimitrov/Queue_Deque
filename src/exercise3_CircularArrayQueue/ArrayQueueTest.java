package exercise3_CircularArrayQueue;

public class ArrayQueueTest {

	public static void main(String[] args) {

		ArrayQueue<String> queue = new ArrayQueue<>();

		queue.enqueue("first");
		queue.enqueue("second");
		queue.enqueue("third");
		System.out.println(queue.size());

		queue.dequeue();
		System.out.println(queue.getFront());
		System.out.println(queue.size());

		queue.clear();
		System.out.println(queue.size());
	}

}
