package exercise2_Queue_Double_Linked;

public class Test {

	public static void main(String[] args) {

		LinkedQueue<String> queue = new LinkedQueue<>();

		queue.enqueue("first");
		System.out.println(queue.getFront());

		queue.enqueue("second");
		System.out.println(queue.getFront());

		queue.dequeue();
		System.out.println(queue.getFront());

	}

}
