package hackeranktest;

/**
 * @author Lakith Dharmarathna
 * Date : 25/08/2022
 */

import java.util.Scanner;

public class ShortestReachInAGraph {

    static StringBuilder stringBuilder = new StringBuilder();

    int vertices = 0;

    public ShortestReachInAGraph(int nodeNum) {
        vertices = nodeNum;
    }

    int minDistance(int[] dist, Boolean[] sptSet) {
        // Initialize min value
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < vertices; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }

        return minIndex;
    }

    void printSolution(int dist[]) {

        for (int i = 0; i < vertices; i++) {
            if (dist[i] != 0) {
//                System.out.print(dist[i] == Integer.MAX_VALUE ? -1 + " " : dist[i] + " ");
                stringBuilder.append(dist[i] == Integer.MAX_VALUE ? -1 + " " : dist[i] + " ");
                //stringBuilder.append(dist[i]);
            }
        }
    }

    void dijkstra(int[][] graph, int src) {
        int[] dist = new int[vertices]; // The output array.

        Boolean[] sptSet = new Boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[src] = 0;

        for (int count = 0; count < vertices - 1; count++) {

            int u = minDistance(dist, sptSet);

            sptSet[u] = true;

            for (int v = 0; v < vertices; v++)

                if (!sptSet[v] && graph[u][v] != 0
                        && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }

        printSolution(dist);
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int queries = Integer.parseInt(scan.next());
        for (int i = 0; i < queries; i++) {
            //edges and nodes
            String node1 = scan.next();
            String node2 = scan.next();
            int nodeNum = Integer.parseInt(node1);
            int edges = Integer.parseInt(node2);
            int[][] inputArray = new int[nodeNum][nodeNum];
            //init array with zeros
            for (int jj = 0; jj < inputArray.length; jj++) {
                for (int ii = 0; ii < inputArray[0].length; ii++) {
                    inputArray[ii][jj] = 0;
                }
            }

            for (int j = 0; j < edges; j++) {

                String data1 = scan.next();
                String data2 = scan.next();

                int source = Integer.parseInt(data1);
                int destination = Integer.parseInt(data2);

                inputArray[source - 1][destination - 1] = 6;
                inputArray[destination - 1][source - 1] = 6;
            }

            int start = Integer.parseInt(scan.next());

            ShortestReachInAGraph solution = new ShortestReachInAGraph(nodeNum);
            solution.dijkstra(inputArray, start - 1);
            stringBuilder.append("\n");

        }
        System.out.println(stringBuilder.toString());
        scan.close();
    }
}
