import java.util.Scanner;

public class DijkstraAlgorithm {
    static final int INF = 999; // Using 999 as infinity

    private static int chooseMinVertex(int[] dist, boolean[] S, int n) {
        int minIndex = -1, min = INF;
        for (int i = 0; i < n; i++)
            if (!S[i] && dist[i] < min) {
                min = dist[i];
                minIndex = i;
            }
        return minIndex;
    }

    public static void shortestPaths(int v, int[][] cost, int[] dist, int n) {
        boolean[] S = new boolean[n];

        for (int i = 0; i < n; i++)
            dist[i] = cost[v][i];

        S[v] = true;

        for (int num = 1; num < n; num++) {
            int u = chooseMinVertex(dist, S, n);
            if (u == -1) break;
            S[u] = true;

            for (int w = 0; w < n; w++)
                if (!S[w] && dist[u] + cost[u][w] < dist[w])
                    dist[w] = dist[u] + cost[u][w];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();
        int[][] cost = new int[n][n];

        System.out.println("Enter cost adjacency matrix (Use 999 for INF):");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                cost[i][j] = sc.nextInt();

        System.out.print("Enter source vertex: ");
        int source = sc.nextInt();
        int[] dist = new int[n];

        shortestPaths(source, cost, dist, n);

        System.out.println("Shortest distances from source " + source + ":");
        for (int i = 0; i < n; i++)
            System.out.println("Vertex " + i + " : " + (dist[i] == INF ? "INF" : dist[i]));

        sc.close();
    }
}
// Output
// Enter number of vertices: 4
// Enter cost adjacency matrix (Use 999 for INF):
// 0 3 999 7
// 3 0 2 999
// 999 2 0 1
// 7 999 1 0
// Enter source vertex: 0
// Shortest distances from source 0:
// Vertex 0 : 0
// Vertex 1 : 3
// Vertex 2 : 5
// Vertex 3 : 6
