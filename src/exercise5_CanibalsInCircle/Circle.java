package exercise5_CanibalsInCircle;

@SuppressWarnings("hiding")
public class Circle {

	private Node<Person> firstPerson;
	private int size;

	public Circle() {
		firstPerson = new Node<Person>(null);
		size = 0;
	}

	public void addPerson(Person newEntry) {

		Node<Person> toAdd = new Node<Person>(newEntry);

		if (size == 0) {
			firstPerson = toAdd;
		} else if (size == 1) {
			firstPerson.next = toAdd;
			toAdd.next = firstPerson;
		} else {
			toAdd.next = firstPerson.next;
			firstPerson.next = toAdd;
		}
		size++;
	}

	// public T getNodeAtIndex(int index) {
	// Node<T> currentNode = firstNode;
	// for (int i = 1; i < index; i++) {
	// currentNode = currentNode.next;
	// }
	// return (T) currentNode;
	//
	// }
	//

	public String printPersons() {
		StringBuilder sb = new StringBuilder("Menu: ");
		Node<Person> current = firstPerson;
		for (int i = 0; i < size && current != null; i++) {
			sb.append(current.data.getName() + " ");
			current = current.next;
		}
		return sb.toString();
	}

	public Person removeFirst() {
		int index = (int) (Math.random() * (size - 1));

		Person result = null;

		if (index == 0) {
			result = firstPerson.data;
			firstPerson = firstPerson.next;

			personAtIndex(size - 1).next = firstPerson;

			size--;

		} else {
			Node<Person> before = personAtIndex(index);
			Node<Person> eaten = before.next;
			Node<Person> after = eaten.next;

			before.next = after;

			result = eaten.data;
			eaten = null;

			size--;
		}
		return result;
	}

	public Person removeNext(int count) {
		Person result = null;
		Node<Person> toBeeaten = lastRemoved;
		System.out.println("to be eaten " + toBeeaten.data);

		if (count > size)
			return null;

		for (int i = 0; i < count - 1; i++) {
			toBeeaten = toBeeaten.next;
		}

		Node<Person> before = toBeeaten;
		Node<Person> eaten = before.next;
		Node<Person> after = eaten.next;

		before.next = after;
		lastRemoved = before;
		result = eaten.data;

		size--;

		return result;

	}

	private Node<Person> personAtIndex(int index) {
		Node<Person> current = firstPerson;
		for (int i = 0; i < index - 1; i++) {
			current = current.next;
		}
		return current;
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