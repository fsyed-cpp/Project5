public interface QueueInterface<T>
{
    public void enqueue(T newEntry);

    public T dequeue() throws Exception;

    public T getFront() throws Exception;

    public boolean isEmpty();

    public void clear();

    public T get(int index) throws Exception;

    public int getSize();
}
