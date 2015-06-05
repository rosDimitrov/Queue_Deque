package exercise2_Queue_Double_Linked;

public class LinkedQueue<T> implements QueueADT<T> {

	private Node<T> firstNode;
	private Node<T> lastNode;

	public LinkedQueue() {
		lastNode = new Node<T>(null, null, null);
		firstNode = new Node<T>(null, null, null);
		firstNode.next = lastNode;
		lastNode.previous = firstNode;
	}

	@Override
	public void enqueue(T newEntry) {
		Node<T> newNode = new Node<>(newEntry, lastNode, lastNode.previous);
		lastNode.previous.next = newNode;
		lastNode.previous = newNode;
	}

	@Override
	public T dequeue() {
		if (firstNode.next.data == null) {
			return null;
		}

		T result = firstNode.next.data;
		firstNode.next = firstNode.next.next;
		firstNode.next.previous = firstNode;

		return result;

	}

	@Override
	public T getFront() {
		if (firstNode.next.data == null) {
			return null;
		}
		return firstNode.next.data;
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
