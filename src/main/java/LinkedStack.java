import java.util.EmptyStackException;

/**
 * Creates a Stack using a Linked List (Linked Chain) of Node objects
 * @param <T> By Providing type 'T' we create a generic implementation of our Linked Stack
 */
public class LinkedStack<T> implements StackInterface<T> {

    // MARK: - Properties

    private Node topNode;

    // MARK: - Constructor

    /**
     * Creates a new instance of LinkedStack
     */
    public LinkedStack() {
        topNode = null;
    }

    // MARK: - Implementation

    /**
     * Pushes a new Node onto the Stack
     * @param newEntry An object to be added to the stack
     */
    public void push (T newEntry) {
        topNode = new Node(newEntry, topNode);
    }

    /**
     * Pops off the top most node on the stack
     * @return The value/data portion of the Node that is to be popped
     */
    public T pop() {
        try {
            T top = peek();
            topNode = topNode.getNextNode();
            return top;
        } catch (EmptyStackException exception) {
            System.out.println("Error when popping - found an empty stack");
            return null;
        }
    }

    /**
     * Peeks into the top most Node in the stack
     * @return The value of the top most Node in the stack without popping it off
     * @throws EmptyStackException If the stack is empty, throws an exception
     */
    public T peek() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException();
        else
            return (T) topNode.getData();
    }

    /**
     * Checks to see if we have a single node in our stack
     * @return True if we have at least one Node, false if we don't
     */
    public boolean isEmpty() {
        return topNode == null;
    }

    /**
     * Removes the top node from the stack, the rest will be cleared by the GC
     */
    public void clear() {
        topNode = null;
    }
}