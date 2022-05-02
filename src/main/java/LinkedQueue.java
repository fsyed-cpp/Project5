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

    @Override
    public T getFront() throws Exception {
        if (isEmpty()) {
            throw new Exception("Empty Queue!");
        }

        return firstNode.getData();
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
