import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		System.out.println("");
		System.out.println("###### Part 1 : DFS");
		System.out.println("");
		UndirectedAdjGraph graph = new  UndirectedAdjGraph();
		graph = undirectedGraphFromResource("graph-DFS-BFS.txt",graph);
		System.out.println("Result of DFS : "+graph.dfs(graph,5));
		System.out.println("The order of the first encounter of the nodes? : "+graph.inDegree(5));
		System.out.println("How many components does the graph have? : "+graph.cc(graph));
		System.out.println("Is this graph connected? : "+graph.isConnected());
		System.out.println("");
		
		// Ex BFS /2 : everything seems to be working well
		System.out.println("");
		System.out.println("###### Part 2 : BFS");
		System.out.println("");
		UndirectedAdjGraph graph2 = new  UndirectedAdjGraph();
		graph2 = undirectedGraphFromResource("graph-DFS-BFS.txt",graph2);
		System.out.println("Result of BFS : "+graph2.bfs(graph2,5));
		System.out.println("What is the order of the first encounter of the nodes? : "+graph2.inDegree(5));
		System.out.println("How many components does the graph have? : "+graph2.cc(graph2));
		System.out.println("Is this graph connected? : "+graph2.isConnected());
		
		
		// Ex BFS for shortest paths
		System.out.println("");
		System.out.println("###### Part 3 : BFS path computation");
		System.out.println("");
		Digraph graph3 = new  Digraph();
		graph3 = digraphFromResource("graph-DFS-BFS.txt",graph3);
		BFSShortestPaths bfsGraph3 = new	BFSShortestPaths(1,graph3);
		bfsGraph3.bfs();
		System.out.println(bfsGraph3.toString());
		// Making some test
		System.out.println(bfsGraph3.hasPathTo(5));
		System.out.println(bfsGraph3.hasPathTo(4));
		System.out.println(bfsGraph3.distTo(6));
		bfsGraph3.printSP(7);
		
		
		//Ex Dijkstra 
		// Note : I changed the method DijkstraSP to DijkstraSPComputation because DijkstraSP was already the name of my constructor
		System.out.println("");
		System.out.println("###### Part 4 : Dijkstra path computation");
		System.out.println("");
		WDgraph graph4 = new WDgraph("graph-WDG.txt");
		graph4.printEdges();
		System.out.println("Graph's size : "+graph4.getSize());
		DijkstraSP djGraph = new DijkstraSP(1,graph4);
		djGraph.DijkstraSPComputation();
		System.out.println(djGraph);
		djGraph.printSP(8);
		System.out.println("");
		djGraph.printSP(5);
		System.out.println("");
		djGraph.printSP(7);
	}
	
	// This method load a graph from a file
	public static<V extends Comparable<V>> UndirectedAdjGraph undirectedGraphFromResource(String resource,UndirectedAdjGraph g) {
		URL url = ClassLoader.getSystemResource("resources/"+resource);
		try {
			File graph = new File(url.toURI());
			@SuppressWarnings("resource")
			BufferedReader buffer = new BufferedReader(new FileReader(graph));
			String line = "";

			while ((line = buffer.readLine()) != null) {
                String[] nodes = line.split(" ");
                int parentNode = Integer.parseInt(nodes[0]);
                int childNode = Integer.parseInt(nodes[1]);
                g.addEdge(parentNode, childNode);
			}
			
			
		} catch (Exception e) {
			System.out.println("Unable to initialize this element");
			e.printStackTrace();
		}
		return g;
	}
	public static<V extends Comparable<V>> Digraph digraphFromResource(String resource,Digraph g) {
		URL url = ClassLoader.getSystemResource("resources/"+resource);
		try {
			File graph = new File(url.toURI());
			@SuppressWarnings("resource")
			BufferedReader buffer = new BufferedReader(new FileReader(graph));
			String line = "";

			while ((line = buffer.readLine()) != null) {
                String[] nodes = line.split(" ");
                int parentNode = Integer.parseInt(nodes[0]);
                int childNode = Integer.parseInt(nodes[1]);
                g.addEdge(parentNode, childNode);
			}
			
			
		} catch (Exception e) {
			System.out.println("Unable to initialize this element");
			e.printStackTrace();
		}
		return g;
	}

}
