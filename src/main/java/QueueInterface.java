public interface QueueInterface<T>
{
    /** Adds a new entry to the back of this queue.
     * @param newEntry An object to be added. */
    public void enqueue(T newEntry);

    /** Removes and returns the entry at the front of this queue.
     * @return The object at the front of the queue.
     * @throws Exception if the queue is empty before performing the operation. */
    public T dequeue() throws Exception;

    /** Retrieves the entry at the front of this queue.
     * @return The object at the front of the queue.
     * @throws Exception if the queue is empty.*/
    public T getFront() throws Exception;

    /** Detects whether this queue is empty.
     * @return True is the queue is empty, or false otherwise*/
    public boolean isEmpty();

    /** Removes all entries from this queue. */
    public void clear();

    /** Get an item in the adjacency matrix
     * @param index of the item in the adjacency matrix
     * @return an item contains in the given index
     * @throws Exception if the queue is empty */
    public T get(int index) throws Exception;

    /** Get the size of the adjacency matrix
     * @return the number of size*/
    public int getSize();
}
