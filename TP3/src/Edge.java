
public class Edge<V> {
	private final V source, destination;
	
	public Edge(V s, V d) {
		this.source = s;
		this.destination = d;
	}
	public V from() {return source;}
	public V to() {return destination;}
	
}
