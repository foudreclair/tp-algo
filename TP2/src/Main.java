public class Main {

	public static void main(String[] args) {
		GraphFactory graph = new GraphFactory();
		String path = "/home/foudre/eclipse-workspace/TP2/src/graph.txt";
		GraphFactory.createGraphFromTextFile(path);
	}
}