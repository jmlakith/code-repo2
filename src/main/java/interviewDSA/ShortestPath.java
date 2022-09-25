package interviewDSA;

/**
 * @author Lakith Dharmarathna
 * Date : 25/08/2022
 */

class ShortestPath {

    static final int V = 7;

    int minDistance(int[] dist, Boolean[] sptSet) {
        // Initialize min value
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }

        return minIndex;
    }

    void printSolution(int dist[]) {
        System.out.println(
                "Vertex \t\t Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.print(i + " \t\t ");
            System.out.println(dist[i] == Integer.MAX_VALUE ? -1 : dist[i]);
        }
    }

    void dijkstra(int[][] graph, int src) {
        int[] dist = new int[V]; // The output array.

        Boolean[] sptSet = new Boolean[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {

            int u = minDistance(dist, sptSet);

            sptSet[u] = true;

            for (int v = 0; v < V; v++)

                if (!sptSet[v] && graph[u][v] != 0
                        && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }

        printSolution(dist);
    }

    // Driver method
    public static void main(String[] args) {
        /* Let us create the example graph discussed above
         */
        int graph[][]
                = new int[][]{
                {0, 6, 6, 0, 0, 0, 0},
                {0, 0, 0, 0, 6, 0, 0},
                {0, 0, 0, 6, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        ShortestPath t = new ShortestPath();
        t.dijkstra(graph, 1);
    }
}