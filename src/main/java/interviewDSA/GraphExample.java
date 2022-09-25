package interviewDSA;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Lakith Dharmarathna
 * Date : 18/08/2022
 */

class Graph<T> {

    Map<T, List<T>> adjacencyList = new HashMap<>();

    public void addVertex(T vertex) {
        adjacencyList.put(vertex, new LinkedList<>());
    }

    public void addEdge(T source, T destination, boolean biDirectional) {
        if (!adjacencyList.containsKey(source)) {
            addVertex(source);
        }
        if (!adjacencyList.containsKey(destination)) {
            addVertex(destination);
        }
        adjacencyList.get(source).add(destination);
        if (biDirectional) {
            adjacencyList.get(destination).add(source);
        }
    }

    public void getVertexCount() {
        System.out.println(adjacencyList.size());
    }

    public void getEdgesCount(boolean biDirectional) {
        AtomicInteger tot = new AtomicInteger();
        adjacencyList.forEach((key, value) -> tot.addAndGet(value.size()));
        if (biDirectional) {
            System.out.println(tot.get() / 2);
        } else {
            System.out.println(tot.get());
        }
    }

    public void printGraph() {
        StringBuilder stringBuilder = new StringBuilder();
        adjacencyList.forEach((k, v) -> v.forEach(val -> stringBuilder.append("vertex: ").append(k).append(" connected to: ").append(val).append("\n")));
        System.out.println(stringBuilder);

    }

    public void DFS(T vertex) {

        Map<T, Boolean> visitor = new HashMap<>();

        DFSUtil(vertex, visitor);

    }

    private void DFSUtil(T vertex, Map<T, Boolean> visitor) {
        //mark visited
        visitor.put(vertex, true);
        //print vertex
        System.out.println("Visited: " + vertex);

        adjacencyList.get(vertex).forEach(value -> {
            if (!visitor.containsKey(value)) {
                DFSUtil(value, visitor);
            }
        });
    }

    public void dfsWithoutRecursion(T start) {
        Stack<T> stack = new Stack<>();
        Map<T, Boolean> visitor = new HashMap<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            T current = stack.pop();
            if (!visitor.containsKey(current)) {
                visitor.put(current, true);
                System.out.println("Visited: " + current);
                for (T dest : adjacencyList.get(current)) {
                    if (!visitor.containsKey(dest)) {
                        stack.push(dest);
                    }
                }
            }
        }
    }


    public void BFS(T vertex) {
        Map<T, Boolean> visitor = new HashMap<>();
        LinkedList<T> queue = new LinkedList<>();
        visitor.put(vertex, true);
        queue.add(vertex);
        while (!queue.isEmpty()) {
            T vertexFetched = queue.poll();
            System.out.println("Fetched: " + vertexFetched);
            adjacencyList.get(vertexFetched).forEach(x -> {
                if (!visitor.containsKey(x)) {
                    visitor.put(x, true);
                    queue.add(x);
                }

            });
        }
    }


}

public class GraphExample {


    public static void main(String[] args) {

        Graph<Integer> g = new Graph<>();

/*        g.addEdge(0, 1, false);
        g.addEdge(0, 2, false);
        g.addEdge(1, 2, false);
        g.addEdge(2, 0, false);
        g.addEdge(2, 3, false);
        g.addEdge(3, 3, false);*/

        g.addEdge(0, 1, false);
        g.addEdge(0, 2, false);
        g.addEdge(1, 2, false);
        g.addEdge(2, 0, false);
        g.addEdge(2, 3, false);
        g.addEdge(3, 3, false);


/*        g.addEdge(0, 1, true);
        g.addEdge(0, 4, true);
        g.addEdge(1, 2, true);
        g.addEdge(1, 3, true);
        g.addEdge(1, 4, true);
        g.addEdge(2, 3, true);
        g.addEdge(3, 4, true);*/

/*        g.printGraph();

        // Gives the no of vertices in the graph.
        g.getVertexCount();

        // Gives the no of edges in the graph.
        g.getEdgesCount(true);*/

        //Depth First
        //g.DFS(0);
        g.BFS(0); // O(n)

       // g.dfsWithoutRecursion(2);



    }


}
