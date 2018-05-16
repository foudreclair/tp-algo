import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Pierre Goffic Launch the file main.java for run
 *
 */
public class GraphAdjList {
	// Counter node
	private int n;
	// Counter edge
	private int m;

	private List<List<Integer>> adj;

	public GraphAdjList() {
		adj = new ArrayList<>();
	}

	public void GraphOrderAndSize() {
		// return the total order and the size of the graph
		System.out.println("The size is : " + m);
		System.out.println("\nthe order is : " + n);
	}

	public void addEdge(int u, int v) {
		if (adj.size() > u - 1 && adj.get(u - 1).contains(v) == false) {
			adj.get(u - 1).add(v);
			addEdge(v, u);
			// remove edge in the counter
			m--;
		} else {
			for (int i = adj.size(); i <= u - 1; i++) {
				adj.add(new ArrayList<>());
				n++;
				if (i == u - 1) {
					adj.get(u - 1).add(v);
				}
			}

		}
		// Add edge in the counter
		m++;
	}

	public void neighbors(int v) {
		System.out.println("Neigbors :");
		if (adj.size() >= v - 1) {
			System.out.print(adj.get(v - 1));
		}
	}

	public void printAdjency() {
		System.out.println("Print Adjency :");
		for (int i = 0; i < adj.size(); i++) {
			System.out.println("node numero " + (i + 1) + " voisins —> " + adj.get(i));
		}
	}

	public void degree(int v) {
		int counter = 0;
		System.out.println("size: " + adj.get(v - 1).size());
		for (int i = 0; i < adj.get(v - 1).size(); i++) {
			if (adj.get(v - 1).get(i) == v) {
				counter = counter + 2;
			} else {
				counter++;
			}
			;
		}
		neighbors(v);
		System.out.println("node number " + (v) + " degree --> " + counter);
	}

	public void buildGraph() {
		int edgeNb, nodeNb, u, v, next;
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Number of vertices");
			nodeNb = scan.nextInt();
			System.out.println("Number of Edges");
			edgeNb = scan.nextInt();
			for (int i = 0; i < edgeNb; i++) {
				next = 0;
				do {
					System.out.println("Edge " + i + "?");
					u = scan.nextInt();
					v = scan.nextInt();
					if (u > nodeNb || v > nodeNb) {
						System.out.println("they are " + nodeNb + " Nodes. retry");
					} else {
						next = 1;
					}
				} while (next == 0);
				addEdge(u, v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		printAdjency();
	}
}