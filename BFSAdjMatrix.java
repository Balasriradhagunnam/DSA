import java.util.*;
class BFSAdjMatrix {
	 public int v;
	 public int[ ][ ] adj;
	 public BFSAdjMatrix(int v) {
	 this.v = v;
	 adj = new int[v][v];
	 }
 	public void BFS(int start) {
		 boolean[] visited = new boolean[v];
		 Arrays.fill(visited, false);
		 Queue<Integer> queue = new LinkedList<>();
		 queue.add(start);
		 visited[start] = true;
	 	while (!queue.isEmpty()) {
		 int vis = queue.poll();
		 System.out.print(vis + " ");
		 for (int i = 0; i < v; i++)  // Explore all adjacent vertices
	 		if (adj[vis][i] == 1 && !visited[i]) {
				 queue.add(i);
				 visited[i] = true;
	 		}
	 	}
	 }
public static void main(String[] args) {
	 Scanner scanner = new Scanner(System.in);
	 System.out.print("Enter the number of vertices: ");
	 int v = scanner.nextInt();
	 BFSAdjMatrix graph = new BFSAdjMatrix(v);
	 System.out.println("Enter the adjacency matrix (" + v + "x" + v + "): ");
	 for (int i = 0; i < v; i++)
	 	for (int j = 0; j < v; j++)
		 	graph.adj[i][j] = scanner.nextInt();
			 System.out.print("Enter the starting vertex for BFS: ");
	 int start = scanner.nextInt();
	 System.out.println("BFS traversal starting from vertex " + start + ":");
	 graph.BFS(start);
	 scanner.close();
	 }
}
// Output
//   Enter the number of vertices: 6
//   Enter the adjacency matrix (6x6): 
// 0 1 1 1 1 0 
// 1 0 0 1 0 0
// 1 0 0 1 1 1 
// 1 1 1 0 0 1
// 1 0 1 0 0 0
// 0 0 1 1 0 0 
// Enter the starting vertex for BFS: 1
// BFS traversal starting from vertex 1:
// 1 0 3 2 4 5 
