import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Digraph extends Graph<Integer> {
	private final Map<Integer, List<Edge<Integer>>> adjacency = new TreeMap<>();

	@Override
	public void addEdge(Integer s, Integer t) {
		m++;		
		if(!adjacency.containsKey(s))
			addVertex(s);
		if(!adjacency.containsKey(t))
			addVertex(t);
		
		List<Edge<Integer>> se = adjacency.get(s);
		se.add(new Edge<>(s,t));
	}

	@Override
	public void addVertex(Integer v) {
		n++;
		adjacency.put(v, new LinkedList<>());
		
	}

	@Override
	public List<Integer> vertices() {
		List<Integer> out = new ArrayList<>();
		out.addAll(adjacency.keySet());
		
		return out;
	}

	
	public List<Edge<Integer>> inEdges(Integer vertice) {
		List<Edge<Integer>> out = new LinkedList<>();
		
		for(Integer source: vertices())
			for(Edge<Integer> e: outEdges(source))
				if(e.to().intValue()==vertice.intValue())
					out.add(e);
		return out;
	}

	
	public List<Edge<Integer>> outEdges(Integer vertice) {
		
		return adjacency.get(vertice);
	}

	@Override
	public List<Integer> inNeighbors(Integer v) {
		
		List<Integer> out = new LinkedList<>();
		for(Edge<Integer> e: inEdges(v))
			out.add(e.from());
		
		return out;

	}

	@Override
	public List<Integer> outNeighbors(Integer v) {
		
		List<Integer> out = new LinkedList<>();
		for(Edge<Integer> e: outEdges(v))
			out.add(e.to());
		
		return out;
	}

	@Override
	public int inDegree(Integer v) {
		
		return inNeighbors(v).size();
	}

	@Override
	public int outDegree(Integer v) {
		return adjacency.get(v).size();
	}	


}
