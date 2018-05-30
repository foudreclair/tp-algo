
public abstract class Player {
	
	protected String name;
	protected int id;
	protected int couleur;
	
	public Player(String name, int id, int couleur) {
		this.name = name; 
		this.id = id;
		this.couleur = couleur;
	}
	
	public abstract int [] getMove(final int [][] board);

	public String getName() {
		return name;
	}
	public int getId() {
		return this.id;
	}
}
