
public class GraphAdjMatrix {
	private int n;
	private int m;
	private boolean[][] adj;
	
	public GraphAdjMatrix(int nodeNumber) {
		adj = new boolean[nodeNumber][nodeNumber];
	}
		
	public void addEdge(int u, int v) {
		adj[u-1][v-1] = true;
		adj[v-1][u-1] = true;
	}
	
	public void printGraph() {
		for (int i = 0; i < adj.length; i++) {
		    for (int j = 0; j < adj[i].length; j++) {
		        System.out.print(adj[i][j] + " ");
		    }
		    System.out.println();
		}
	}
	
	
}
