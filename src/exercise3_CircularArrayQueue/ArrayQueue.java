package exercise3_CircularArrayQueue;

import exercise1_Queue_Single_Linked.QueueADT;

public class ArrayQueue<T> implements QueueADT<T> {

	private T[] queue;
	private int front, rear, count;
	private static int DEFAULT_CAPACITY = 1;

	public ArrayQueue() {
		queue = (T[]) new Object[DEFAULT_CAPACITY];
		front = rear = count = 0;
	}

	@Override
	public void enqueue(T newEntry) {
		if (size() == queue.length) {
			expandCapacity();
		}

		queue[rear] = newEntry;
		rear = (rear + 1) % queue.length;
		count++;
	}

	@Override
	public T dequeue() {
		if (isEmpty()) {
			throw new IllegalStateException("Queue is empty!");
		}
		T result = queue[front];
		queue[front] = null;
		front = (front + 1) % queue.length;
		count--;
		return result;
	}

	@Override
	public T getFront() {
		if (isEmpty()) {
			throw new IllegalStateException("Queue is empty!");
		}
		return queue[front];
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	@Override
	public void clear() {
		for (int i = 0; i < count; i++) {
			queue[front] = null;
			front = (front + 1) % queue.length;
		}
		front = rear = count = 0;

	}

	public int size() {
		return count;
	}

	public void expandCapacity() {
		T[] larger = (T[]) (new Object[queue.length * 2]);

		for (int i = 0; i < count; i++) {
			larger[i] = queue[front];
			front = (front + 1) % queue.length;
		}
		front = 0;
		rear = count;
		queue = larger;
	}

}
