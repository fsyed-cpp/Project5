import java.util.Iterator;
import java.util.Queue;

public class Graph<E>
{

    // MARK: - Properties

    private LinkedQueue<Integer> adjMatrix[];
    private boolean[][] edges;      // edges[i][j] is true if there is a vertex from i to j
    private E[] labels;             // label[i] contains the label for vertex i


    // MARK: - Constructor

    public Graph(int n) {
        this.edges = new boolean[n][n];     // All values initially false
        this.labels = (E[]) new Object[n];  // All values initially null
        adjMatrix = new LinkedQueue[n];
        for (int i = 0; i < n; i++) {
            adjMatrix[i] = new LinkedQueue<>();
        }
    }

    // MARK: - Implementation

    // Accessor method to get the label of a vertex of this Graph
    public E getLabel(int vertex)
    {
        return labels[vertex];
    }

    // Test whether an edge exists
    public boolean isEdge(int source, int target)
    {
        return edges[source][target];
    }

    // Add an edge
    public void addEdge(int source, int target)
    {
        adjMatrix[source].enqueue(target);
    }

    // Obtain a list of neighbors of a specified vertex of this Graph
    public int[] neighbors(int vertex)
    {
        int i;
        int count = 0;
        int[] answer;
        for (i = 0; i < labels.length; i++)
        {
            if (edges[vertex][i])
                count++;
        }
        answer = new int[count];
        count = 0;
        for (i = 0; i < labels.length; i++)
        {
            if (edges[vertex][i])
                answer[count++] = i;
        }
        return answer;
    }

    // Remove an edge
    public void removeEdge(int source, int target)
    {
        edges[source][target] = false;
    }

    // Change the label of a vertex of this Graph
    public void setLabel(int vertex, E newLabel)
    {
        labels[vertex] = newLabel;
    }

    // Accessor method to determine the number of vertices in this Graph
    public int size()
    {
        return labels.length;
    }

    /**
     * Perform Breadth First Search using Adjacency Matrix
     * @param origin The origin vertex to start the search
     * @return A Queue containing the order of the traversal
     * @throws Exception
     */
    public QueueInterface<Integer> getBreadthFirstSearch(int origin) throws Exception {

        // Create queue to maintain order, as well as an
        // array of visited nodes to track visitation
        LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
        boolean visited[] = new boolean[this.size()];
        int vertex = 0;

        visited[origin] = true;
        queue.enqueue(origin);

        // Queue to return the final traversal order
        QueueInterface<Integer> traversal = new LinkedQueue<Integer>();

        // Go through the queue one by one and add the neighbors,
        // We will traverse the first level of each neighbor before moving onto the next
        // FIFO Order so that the first neighbor we find we will find its neighbors
        while (!queue.isEmpty()) {
            origin = queue.dequeue();
            traversal.enqueue(origin);

            for (int i = 0; i < adjMatrix[origin].getSize(); i++) {
                vertex = adjMatrix[origin].get(i);
                if (!visited[vertex]) {
                    visited[vertex] = true;
                    queue.enqueue(vertex);
                }
            }
        }

        return traversal;
    }

    /**
     * Perform Depth-First-Search using a Stack with our Adjacency Matrix
     * @param origin The original vertex where we start our search
     * @return A Stack containing the traversal order
     * @throws Exception
     */
    public StackInterface<Integer> getDepthFirstSearch(int origin) throws Exception {

        // Create visited list and stack to maintain order
        boolean visited[] = new boolean[this.size()];
        LinkedStack<Integer> orderStack = new LinkedStack<>();
        LinkedStack<Integer> resultStack = new LinkedStack<>();

        // Add origin
        orderStack.push(origin);
        int vertex = 0;

        // Starting from the node, we will add all the next vertex
        // neighbors to the stack, and keep going until the stack is full
        // for a single path, and then start popping off the stack to visit
        while(!orderStack.isEmpty()) {
            origin = orderStack.pop();

            if(visited[origin] == false) {
                resultStack.push(origin);
                visited[origin] = true;
            }

            // For a vertex "V" - visit all the edges for this vertex's
            // path and push each vertex onto the stack
            for (int i = 0; i < adjMatrix[origin].getSize(); i++) {
                vertex = adjMatrix[origin].get(i);
                if (!visited[vertex]) {
                    orderStack.push(vertex);
                }
            }
        }

        return resultStack;
    }
}