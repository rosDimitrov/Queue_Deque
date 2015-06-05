package exercise1_Queue_Single_Linked;

public class LinkedQueue<T> implements QueueADT<T> {

	private Node<T> firstNode;
	private Node<T> lastNode;

	public LinkedQueue() {
		firstNode = null; // references node at front of queue
		lastNode = null; // references node at back of queue

	}

	@Override
	public void enqueue(T newEntry) {

		Node<T> newNode = new Node(newEntry, null);
		if (isEmpty()) {
			firstNode = newNode;
		} else {
			lastNode.next = newNode;
		}
		lastNode = newNode;
	}

	@Override
	public T dequeue() {

		T front = null;

		if (!isEmpty()) {
			front = firstNode.getData();
			firstNode = firstNode.next;
			if (firstNode == null)
				lastNode = null;
		}
		return front;
	}

	@Override
	public T getFront() {

		T front = null;

		if (!isEmpty())
			front = firstNode.getData();
		return front;
	}

	@Override
	public boolean isEmpty() {
		return (firstNode == null) && (lastNode == null);
	}

	@Override
	public void clear() {
		firstNode = null;
		lastNode = null;
	}

	private static class Node<T> {
		private T data; // entry in bag
		private Node<T> next; // link to next node

		public Node(T data) {
			this(data, null);
		}

		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}

		public T getData() {
			return data;
		}

		public Node<T> getNext() {
			return next;
		}
	}

}
