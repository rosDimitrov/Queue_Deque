package exercise4_Deque_CircularArray;

public class ArrayDeque<T> implements DequeADT<T> {

	private T[] deque;
	private int front, rear, count;
	private static int DEFAULT_CAPACITY = 1;

	public ArrayDeque() {
		deque = (T[]) new Object[DEFAULT_CAPACITY];
		front = rear = count = 0;
	}

	@Override
	public void addToFront(T newEntry) {
		if (size() == deque.length) {
			expandCapacity();
		}
		deque[front] = newEntry;
		front -= 1;
		if (front < 0) {
			front = deque.length - 1;
		}
		count++;

	}

	@Override
	public void addToBack(T newEntry) {
		if (size() == deque.length) {
			expandCapacity();
		}
		rear = (rear + 1) % deque.length;
		deque[rear] = newEntry;
		count++;
	}

	@Override
	public T removeFront() {
		T result = null;
		if (deque[rear] == null) {
			return result;
		} else if (front == deque.length - 1) {
			result = deque[0];
			deque[0] = null;
			front = 0;
			count--;
			return result;
		} else {
			result = deque[front + 1];
			deque[front + 1] = null;
			front += front + 1;
			count--;
			return result;
		}
	}

	@Override
	public T removeBack() {
		T result = null;
		if (deque[rear] == null) {
			return result;
		}

		result = deque[rear];
		deque[rear] = null;
		rear -= 1;
		if (rear < 0) {
			rear = deque.length - 1;
		}
		count--;
		return result;

	}

	@Override
	public T getFront() {
		if (deque[rear] == null) {
			return null;
		} else if (front == deque.length - 1) {
			return deque[0];
		} else {
			return deque[front + 1];
		}
	}

	@Override
	public T getBack() {
		if (deque[rear] == null) {
			return null;
		}
		return deque[rear];

	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	@Override
	public void clear() {
		for (int i = 0; i < deque.length; i++) {
			deque[i] = null;
		}
	}

	public int size() {
		return count;
	}

	public void expandCapacity() {
		T[] larger = (T[]) (new Object[deque.length * 2]);

		for (int i = 0; i < count; i++) {
			front = (front + 1) % deque.length;
			larger[i] = deque[front];
		}
		front = 0;
		rear = count;
		deque = larger;
	}
}
