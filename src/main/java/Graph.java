public class Graph<E> {

    // MARK: - Properties

    private boolean[][] edges;
    private E[] labels;

    // MARK: - Constructor

    public Graph(int n) {
        this.edges = new boolean[n][n];
        this.labels = (E[]) new Object[n];
    }

    // MARK: - Implementation

    // Accessor method to get the label of a vertex of this Graph
    public E getLabel(int vertex) {
        return labels[vertex];
    }

    // Test whether an edge exists
    public boolean isEdge(int source, int target) {
        return edges[source][target];
    }

    // Add an edge
    public void addEdge(int source, int target) {
        edges[source][target] = true;
    }

    // Obtain a list of neighbors of a specified vertex of this Graph
    public int[] neighbors(int vertex) {
        int i;
        int count = 0;
        int[] answer;
        for (i = 0; i < labels.length; i++) {
            if (edges[vertex][i])
                count++;
        }
        answer = new int[count];
        count = 0;
        for (i = 0; i < labels.length; i++) {
            if (edges[vertex][i])
                answer[count++] = i;
        }
        return answer;
    }

    // Remove an edge
    public void removeEdge(int source, int target) {
        edges[source][target] = false;
    }

    // Change the label of a vertex of this Graph
    public void setLabel(int vertex, E newLabel) {
        labels[vertex] = newLabel;
    }

    // Accessor method to determine the number of vertices in this Graph
    public int size() {
        return labels.length;
    }
}
