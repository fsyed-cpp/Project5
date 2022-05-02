public class Driver {

    public static void main(String[] args) throws Exception {

        // Create Graph
        Graph<Object> graph = new Graph<Object>(4);

        // Set labels
        /**
         * We have a graph that looks like this:
         * A --------- C
         * |
         * |
         * B --------- D
         */
        graph.setLabel(0, "A");
        graph.setLabel(1, "B");
        graph.setLabel(2, "C");
        graph.setLabel(3, "D");

        // Add edges
        graph.addEdge(0, 2);
        graph.addEdge(0, 1);

        graph.addEdge(1, 0);
        graph.addEdge(1, 3);

        graph.addEdge(2, 0);

        graph.addEdge(3, 1);
        graph.addEdge(1, 3);

        QueueInterface<Integer> bfsQueue = graph.getBreadthFirstSearch(0);

        System.out.println("BFS Order: ");
        while (!bfsQueue.isEmpty()) {
            Integer item = bfsQueue.dequeue();
            System.out.print(item + " ");
        }
    }
}
