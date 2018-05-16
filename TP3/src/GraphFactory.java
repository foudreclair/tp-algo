import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.Scanner;

public class GraphFactory {
	
	public static Digraph createDiGraphFromTextFile(String path) {
		Digraph g = new Digraph();
		try(Scanner scan = new Scanner(FileSystems.getDefault().getPath(path))){
			while(scan.hasNextInt()) {
				int u = scan.nextInt(),
					v = scan.nextInt();
				g.addEdge(u, v);
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
		return g;
	}
	/*
	public static WDigraph createWDiGraphFromTextFile(String path) {
		WDigraph g = new WDigraph();
		try(Scanner scan = new Scanner(FileSystems.getDefault().getPath(path))){
			while(scan.hasNextInt()) {
				int u = scan.nextInt(),
					v = scan.nextInt();
				double w = scan.nextDouble();
				g.addEdge(u, v,w);
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
		return g;
	}
	*/

}
