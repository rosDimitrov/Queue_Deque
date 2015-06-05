package exercise4_Deque_Double_Linked;

public class testDeque {

	public static void main(String[] args) {
		DequeDoubleLinked<String> deque = new DequeDoubleLinked<>();

		deque.addToFront("first");
		deque.addToFront("second");

		System.out.println(deque.getFront());

		deque.addToBack("back");

		System.out.println(deque.getFront());
		System.out.println(deque.getBack());

		deque.removeFront();
		System.out.println(deque.getFront());
	}

}
