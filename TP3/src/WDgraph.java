import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Pierre Goffic
 *
 */
public class WDgraph {
	private List<List<DirectedEdge>> edges;
	private int n;

	public WDgraph(String resource) {
		this.n=0;
		this.edges=new ArrayList<List<DirectedEdge>>();
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
                int weight = Integer.parseInt(nodes[2]);
                this.n=Math.max(Math.max(parentNode,childNode),this.n);
                try {
                		this.edges.get(parentNode-1).add(new DirectedEdge(parentNode,childNode,weight));
                }catch (Exception e){
                		this.edges.add(parentNode-1,new ArrayList<DirectedEdge>());
                		this.edges.get(parentNode-1).add(new DirectedEdge(parentNode,childNode,weight));
                }
                
			}	
		} catch (Exception e) {
			System.out.println("Unable to initialize this element");
			e.printStackTrace();
		}
		while (this.n!=this.edges.size()) {
			this.edges.add(new ArrayList<DirectedEdge>());
		}
	}

	public List<List<DirectedEdge>> getEdges() {
		return edges;
	}

	public void setEdges(List<List<DirectedEdge>> edges) {
		this.edges = edges;
	}
	public int getSize() {
		return this.n;
	}
	public void printEdges() {
		for (int i =0;i<this.edges.size();i++) {
			for (int j=0;j<this.edges.get(i).size();j++) {
				System.out.println(this.edges.get(i).get(j));
			}
		}
	}


	

	
	
}
