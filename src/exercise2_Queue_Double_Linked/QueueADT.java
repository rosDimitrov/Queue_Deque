package exercise2_Queue_Double_Linked;

public interface QueueADT<T> {

	/**
	 * Adds a new entry to the back of the queue.
	 * 
	 * @param newEntry
	 *            an object to be added
	 */
	public void enqueue(T newEntry);

	/**
	 * Removes and returns the entry at the front of this queue.
	 * 
	 * @return either the object at the front of the queue or, if the queue is
	 *         empty before the operation, null
	 */
	public T dequeue();

	/**
	 * Retrieves the entry at the front of this queue.
	 * 
	 * @return either the object at the front of the queue or, if the queue is
	 *         empty, null
	 */
	public T getFront();

	/**
	 * Detects whether this queue is empty.
	 * 
	 * @return true if the queue is empty, or false otherwise
	 */
	public boolean isEmpty();

	/** Removes all entries from this queue. */
	public void clear();
}
