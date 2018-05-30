import java.util.List;

public class TNode {
	private int[][] board;
	private int wins;
	private TNode parent;
	private int visited;
	private List<TNode> enfants;

	public double UTC(TNode i) {
		return (i.getWins() / i.getVisited())
				+ (Math.sqrt(2)) * (Math.sqrt(Math.log(i.getParent().getVisited()) / i.getVisited()));
	}

	public int[][] getBoard() {
		return board;
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public TNode getParent() {
		return parent;
	}

	public void setParent(TNode parent) {
		this.parent = parent;
	}

	public List<TNode> getEnfant() {
		return enfants;
	}

	public void setEnfant(List<TNode> enfant) {
		this.enfants = enfant;
	}

	public int getVisited() {
		return visited;
	}

	public void setVisited(int visited) {
		this.visited = visited;
	}
}
