import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.Scanner;

public class GraphFactory {

	static GraphAdjList createGraphFromTextFile(String path) {
		GraphAdjList graph = new GraphAdjList();
		try (Scanner scan = new Scanner(FileSystems.getDefault().getPath(path))) {
			while (scan.hasNextInt()) {
				int u = scan.nextInt(), v = scan.nextInt();
				graph.addEdge(u, v);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		graph.printAdjency();
		graph.neighbors(1);
		graph.degree(2);
		graph.GraphOrderAndSize();
		graph.buildGraph();
		return graph;
	}

	static GraphAdjMatrix createGraphMatrixFromTextFile(String path) {
		int biggest = 0;
		try (Scanner scan = new Scanner(FileSystems.getDefault().getPath(path))) {
			while (scan.hasNextInt()) {
				int x = scan.nextInt();
				if (x > biggest) {
					biggest = x;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		GraphAdjMatrix g = new GraphAdjMatrix(biggest);
		try (Scanner scan = new Scanner(FileSystems.getDefault().getPath(path))) {
			while (scan.hasNextInt()) {
				int u = scan.nextInt(), v = scan.nextInt();
				g.addEdge(u, v);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.printGraph();
		return g;
	}

}