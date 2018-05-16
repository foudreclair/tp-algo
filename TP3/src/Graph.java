

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


/**
 * This class is an Abstract Graph. 
 * Types of Vertices (V) and Edges (E) are not defined by default. 
 * The only constraints on theses types are that Vertices must be Comparable ie. 
 * there must be a way to order vertices with one another. This is done through the use of the Comparable interface.
 *  
 * 
 * @author slefebvr
 *
 * @param <V>
 * @param <E>
 */
public abstract class Graph<V extends Comparable<V>> {
	
	protected int n;
	protected int m;
	
	
	public Graph(int nbVertices, int nbEdges) {
		this.n= nbVertices;
		this.m = nbEdges;
	}
	
	
	/**
	 * Initializes an empty graph
	 */
	public Graph() {
		this(0,0);
	}
	
	public int order() {
		return n;
	}
	
	public int size() {
		return m;
	}

	/**
	 * Adds the corresponding vertex if needed
	 * @param e
	 */
	public abstract void addEdge(V s, V t);
	
	/**
	 * Adds a vertex to the graph. On success n is increased
	 * @param v
	 */
	public abstract void addVertex(V v);
	
	/**
	 * 
	 * @return the list of the graph vertices
	 */
	public abstract List<V> vertices();
		
	/** 
	 * Return the list of v's neighbors
	 * @param v
	 */
	public abstract List<V> inNeighbors(V v);
	public abstract List<V> outNeighbors(V v);
		
	/**
	 * Returns the inbound degree of node v
	 * in case of undirected graph should return the same as outDegree
	 * @param v
	 * @return inbound degree of vertex v
	 */
	public abstract int inDegree(V v);
	public abstract int outDegree(V v);
	
	
	
	/**
	 * Returns true if the graph is connected
	 * can be more efficient. 
	 * @return
	 */
	public boolean isConnected() {
		if (this.cc(this)==1) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Counts and returns the number of connected components
	 * @param g
	 * @return
	 */
	public static<V extends Comparable<V>> int cc(Graph<V> g) {
		List<V> vertices = g.vertices();
		List<V> seenVertices= new ArrayList<V>();
		int count=0;
		for (int i=0;i<vertices.size();i++) {
			if (!seenVertices.contains(vertices.get(i))) {
				count+=1;
				seenVertices.addAll(dfs(g,vertices.get(i)));
			}
		}
		return count;
	}
	
	/**
	 * Returns the list of vertices ordered by DFS visit 
	 * 
	 * @param g
	 * @return
	 */
	public static<V extends Comparable<V>>  List<V> dfs(Graph<V> g,V initV) {
		
		// We first initialize our variables
		V firstVertice = initV;
		V currentVertice = firstVertice;
		List<V> dfsV = new ArrayList<V>();
		List<List<V>> queueV = new ArrayList<List<V>>();
		
		V child;
		V ch;
		while(true) {
			child=null;
			List<V> children;
			// Then we check if we already have currentVertice's children, and if not, we get them
			if (dfsV.contains(currentVertice)) {
				children = queueV.get(dfsV.indexOf(currentVertice));
			}else {
				dfsV.add(currentVertice);
				children = g.outNeighbors(currentVertice);
				queueV.add(children);
			}
			// We seearch if there is a child that we don't have studied yet 
			for (int i =0;i<children.size();i++) {
				ch = children.get(i);
				if (!dfsV.contains(ch)) {
					child=ch;
					break;
				}
			}
			// If there is none and the current vertice is the first one, we break because we have found all the vertices
			if (child==null && currentVertice==firstVertice) {
				break;
			}
			// If there is none, we go back in the tree
			else if (child==null) {
				currentVertice = dfsV.get(dfsV.indexOf(currentVertice)-1);
			}
			// If there is one, we study it
			else {
				currentVertice=child;
			}
		}
		
		
		return dfsV;
	}
	
	
	/**
	 * Iterative function for bfs 
	 * @param g
	 * @return
	 */
	
	public static<V extends Comparable<V>> List<V> bfs(Graph<V> g, V start) {
		// We firstly initialize the variables
		List<V> toVisit=new ArrayList<V>();
		toVisit.add(start);
		List<V> bfsV=new ArrayList<V>();
		while (true) {
			if (toVisit.size()==0) {
				break;
			}
			List<V> newList=new ArrayList<V>();
			List<V> children;
			for (int i =0;i<toVisit.size();i++) {
				V node = toVisit.get(i);
				bfsV.add(node);
				children = g.outNeighbors(node);
				for (int j=0;j<children.size();j++) {
					if (!bfsV.contains(children.get(j))) {
						newList.add(children.get(j));
					}
				}	
			}
			toVisit = newList;
		}
		return bfsV;
	}

}
