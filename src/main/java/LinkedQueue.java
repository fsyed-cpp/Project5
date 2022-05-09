/**
 * This class implements the Queue Interface using a Linked Chain
 * @param <T> Generic Type
 */
public class LinkedQueue<T> implements QueueInterface<T> {

    // MARK: - Properties

    private Node<T> firstNode;
    private Node<T> lastNode;

    // MARK: - Constructor

    public LinkedQueue() {
        firstNode = null;
        lastNode = null;
    }

    // MARK: - Functionality

    /**
     * Adding a new entry at the end of the Node
     * If empty set newNode to the first Node, otherwise set newNode to the lastNode
     * @param newEntry An object to be added.
     */
    @Override
    public void enqueue(T newEntry) {
        Node newNode = new Node(newEntry, null);
        if (isEmpty()) {
            firstNode = newNode;
        } else {
            lastNode.setNextNode(newNode);
        }

        lastNode = newNode;
    }

    /**
     * Removes and returns the entry at the front of this queue.
     * @return an item at the front of the queue
     * @throws Exception if the queue is empty before performing the operation.
     */
    @Override
    public T dequeue() throws Exception {
        T front = getFront();

        firstNode.setData(null);
        firstNode = firstNode.getNextNode();

        if (firstNode == null) {
            lastNode = null;
        }

        return front;
    }

    /** Retrieves the entry at the front of this queue.
     * @return The first node if the data
     * @throws Exception if the queue is empty.
     */
    @Override
    public T getFront() throws Exception {
        if (isEmpty()) {
            throw new Exception("Empty Queue!");
        }

        return firstNode.getData();
    }

    /** Detects whether this queue is empty.
     * @return True if first and last nodes are empty.
     */
    @Override
    public boolean isEmpty() {
        return (firstNode == null) && (lastNode == null);
    }

    /** Removes all entries from this queue.
     * set the first and last nods to null
     */
    @Override
    public void clear() {
        firstNode = null;
        lastNode = null;
    }

    /**
     * Get an item in the data
     * Iterate through the whole data. Stop the iteration when the current is empty
     * @param index of the item in data
     * @return return 0 if the current Node is empty, otherwise if return the contained data
     * @throws Exception if the queue is empty
     */
    @Override
    public T get(int index) throws Exception {

        if (isEmpty()) {
            throw new Exception("Empty queue!");
        }

        Node current = firstNode;
        for (int i = 0; i < index; i++) {
            current = current.getNextNode();
            if (current == null) {
                break;
            }
        }

        if (current == null) {
            Node zero = new Node(0);
            return (T) zero.getData();
        } else {
            return (T) current.getData();
        }
    }

    /** Get the size of the adjacency matrix
     * Iterates to the whole data
     * If next node is not empty, increment the size
     * @return the number of size*/
    @Override
    public int getSize() {
        int size = 0;
        Node current = firstNode;
        while (current != null) {
            size++;
            current = current.getNextNode();
        }
        return size;
    }
}
