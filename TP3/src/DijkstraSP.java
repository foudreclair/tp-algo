import java.util.ArrayList;
import java.util.List;

public class DijkstraSP {
	private int root;
	private boolean[] marked;
	private int[] previous;
	private double[] distance;
	private WDgraph graph;
	
	public DijkstraSP(int root, WDgraph graph) {
		super();
		this.root = root;
		this.graph = graph;
		this.marked = new boolean[graph.getEdges().size()];
		for (int i =0;i<graph.getEdges().size();i++) {
			this.marked[i]=false;
		}
		this.previous = new int[graph.getEdges().size()];
		for (int i =0;i<graph.getEdges().size();i++) {
			this.previous[i]=0;
		}
		this.distance = new double[graph.getEdges().size()];
		for (int i =0;i<graph.getEdges().size();i++) {
			this.distance[i]=-1;
		}
	}
	
	public boolean verifyNonNegative() {
		for (int i =0;i<this.graph.getEdges().size();i++) {
			for (int j =0;j<this.graph.getEdges().get(i).size();j++) {
				if (this.graph.getEdges().get(i).get(j).weight()<0) {
					return false;
				}
			}
		}
		return true;
	}
	
	public void DijkstraSPComputation() {
		int currentNode =this.root;
		this.distance[this.root-1]=0;
		while (true) {
			this.marked[currentNode-1]=true;
			List<DirectedEdge> edges = this.graph.getEdges().get(currentNode-1);
			int child=0;
			double childWeight=-1;
			for (int i =0;i<edges.size();i++) {
				if ((this.distance[edges.get(i).to()-1]==-1|| this.distance[edges.get(i).to()-1]>=(this.distance[currentNode-1]+edges.get(i).weight()))) {
					this.distance[edges.get(i).to()-1] = this.distance[currentNode-1]+edges.get(i).weight();
					this.previous[edges.get(i).to()-1]=currentNode;
					
				}
			}
			for (int i =0;i<this.marked.length;i++) {
				if ((childWeight==-1 || (childWeight>this.distance[i])&&this.distance[i]>-1)&&!this.marked[i]) {
					childWeight=this.distance[i];
					child = i+1;
				}
			}
			
			if (child==0) {
				break;
			}
			currentNode=child;
		}
		
	}
	
	public String toString(){
		String str ="";
		str+="Root element : "+Integer.toString(this.root)+"\n\n";
		str+="Marked : \n";
		for (int i =0;i<this.marked.length;i++) {
			str+="[ index : "+i+", node : "+(i+1)+"] : "+this.marked[i]+"\n";
		}
		str+="\nPrevious : \n";
		for (int i =0;i<this.previous.length;i++) {
			str+="[ index : "+i+", node : "+(i+1)+"] : "+this.previous[i]+"\n";
		}
		str+="\nDistance : \n";
		for (int i =0;i<this.distance.length;i++) {
			str+="[ index : "+i+", node : "+(i+1)+"] : "+this.distance[i]+"\n";
		}
		return str;
	}
	public void printSP(int v) {
		if (!this.hasPathTo(v)) {
			System.out.println("There is no path from "+this.root+" to "+v);
		}else {
			System.out.println("Path from "+this.root+" to "+v+" : ");
			int actualNode = v;
			System.out.print(actualNode);
			while(actualNode!=this.root) {
				actualNode=this.previous[actualNode-1];
				System.out.print(" <= "+actualNode);
			}
			System.out.println();
			System.out.println("With a weight of : "+this.distTo(v));
		}
	}
	public boolean hasPathTo(int v) {
		if (this.distance[v-1]==-1) {
			return false;
		}
		return true;
	}
	public double distTo(int v) {
		return this.distance[v-1];
	}
}
