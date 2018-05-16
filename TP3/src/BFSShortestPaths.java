import java.util.ArrayList;
import java.util.List;

public class BFSShortestPaths {
	private int root;
	private boolean[] marked;
	private int[] previous;
	private int[] distance;
	private Digraph graph;

	public BFSShortestPaths(int root, Digraph graph) {
		this.root = root;
		this.graph = graph;
		this.marked = new boolean[graph.n];
		for (int i = 0; i < graph.n; i++) {
			this.marked[i] = false;
		}
		this.previous = new int[graph.n];
		for (int i = 0; i < graph.n; i++) {
			this.previous[i] = 0;
		}
		this.distance = new int[graph.n];
		for (int i = 0; i < graph.n; i++) {
			this.distance[i] = -1;
		}
	}

	public void bfs() {
		// We firstly initialize the variables
		Digraph g = this.graph;
		int start = this.root;
		List<Integer> toVisit = new ArrayList<Integer>();
		toVisit.add(start);
		// List<Integer> bfsV=new ArrayList<Integer>();
		int dist = 0;
		while (true) {
			if (toVisit.size() == 0) {
				break;
			}
			List<Integer> newList = new ArrayList<Integer>();
			List<Integer> children;
			for (int i = 0; i < toVisit.size(); i++) {
				int node = toVisit.get(i);
				// bfsV.add(node);
				this.marked[node - 1] = true;
				children = g.outNeighbors(node);
				this.distance[node - 1] = dist;
				for (int j = 0; j < children.size(); j++) {
					if (!this.marked[children.get(j) - 1]) {
						this.previous[children.get(j) - 1] = node;
						newList.add(children.get(j));
					}
				}
			}
			toVisit = newList;
			dist += 1;
		}
	}

	public boolean hasPathTo(int v) {
		if (this.distance[v - 1] == -1) {
			return false;
		}
		return true;
	}

	public int distTo(int v) {
		return this.distance[v - 1];
	}

	public void printSP(int v) {
		if (!this.hasPathTo(v)) {
			System.out.println("There is no path from " + this.root + " to " + v);
		} else {
			int[] path = new int[this.distTo(v)];
			int actualNode = v;
			int count = 0;
			while (actualNode != this.root) {
				actualNode = this.previous[actualNode - 1];
				path[count] = actualNode;
				count++;
			}
			System.out.print("Path from " + this.root + " to " + v + " : ");
			for (int i = 0; i < this.distTo(v); i++) {
				System.out.print(path[this.distTo(v) - i - 1] + " => ");
			}
			System.out.println(v);
		}
	}

	public String toString() {
		String str = "";
		str += "Root element : " + Integer.toString(this.root) + "\n\n";
		str += "Marked : \n";
		for (int i = 0; i < this.marked.length; i++) {
			str += "[ index : " + i + ", node : " + (i + 1) + "] : " + this.marked[i] + "\n";
		}
		str += "\nPrevious : \n";
		for (int i = 0; i < this.previous.length; i++) {
			str += "[ index : " + i + ", node : " + (i + 1) + "] : " + this.previous[i] + "\n";
		}
		str += "\nDistance : \n";
		for (int i = 0; i < this.distance.length; i++) {
			str += "[ index : " + i + ", node : " + (i + 1) + "] : " + this.distance[i] + "\n";
		}
		return str;
	}

	public int getRoot() {
		return root;
	}

	public void setRoot(int root) {
		this.root = root;
	}

	public boolean[] getMarked() {
		return marked;
	}

	public void setMarked(boolean[] marked) {
		this.marked = marked;
	}

	public int[] getPrevious() {
		return previous;
	}

	public void setPrevious(int[] previous) {
		this.previous = previous;
	}

	public int[] getDistance() {
		return distance;
	}

	public void setDistance(int[] distance) {
		this.distance = distance;
	}

	public Digraph getGraph() {
		return graph;
	}

	public void setGraph(Digraph graph) {
		this.graph = graph;
	}

}
