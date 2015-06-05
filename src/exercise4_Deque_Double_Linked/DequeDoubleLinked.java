package exercise4_Deque_Double_Linked;

public class DequeDoubleLinked<T> implements DequeADT<T> {

	private Node<T> firstNode;
	private Node<T> lastNode;

	public DequeDoubleLinked() {
		lastNode = new Node<T>(null, null, null);
		firstNode = new Node<T>(null, null, null);
		firstNode.next = lastNode;
		lastNode.previous = firstNode;

	}

	@Override
	public void addToFront(T newEntry) {
		Node<T> newNode = new Node<>(newEntry, firstNode.next, firstNode);
		firstNode.next.previous = newNode;
		firstNode.next = newNode;
	}

	@Override
	public void addToBack(T newEntry) {
		Node<T> newNode = new Node<>(newEntry, lastNode, lastNode.previous);
		lastNode.previous.next = newNode;
		lastNode.previous = newNode;
	}

	@Override
	public T removeFront() {
		if (firstNode.next.data == null) {
			return null;
		}

		T result = firstNode.next.data;
		firstNode.next.next.previous = firstNode;
		firstNode.next = firstNode.next.next;
		return result;

	}

	@Override
	public T removeBack() {
		if (lastNode.previous.data == null) {
			return null;
		}
		T result = lastNode.previous.data;
		lastNode.previous = lastNode.previous.previous;
		lastNode.previous.next = lastNode;

		return result;
	}

	@Override
	public T getFront() {
		if (firstNode.next.data == null) {
			return null;
		}
		T front = firstNode.next.data;

		return front;
	}

	@Override
	public T getBack() {
		if (lastNode.previous.data == null) {
			return null;
		}
		T back = lastNode.previous.data;
		return back;
	}

	@Override
	public boolean isEmpty() {
		return firstNode.next.data == null;
	}

	@Override
	public void clear() {
		firstNode.next = lastNode;
		lastNode.previous = firstNode;

	}

	private static class Node<T> {
		private T data; // entry in bag
		private Node<T> next; // link to next node
		private Node<T> previous;

		public Node(T data) {
			this(data, null, null);
		}

		public Node(T data, Node<T> next, Node<T> previous) {
			this.data = data;
			this.next = next;
			this.previous = previous;
		}

		public T getData() {
			return data;
		}

		public Node<T> getNext() {
			return next;
		}
	}

}
