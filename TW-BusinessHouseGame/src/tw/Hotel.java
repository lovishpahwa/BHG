package tw;

public interface Hotel extends Cell {

	public int getRent();

	public int getValue();

	public void setOwner(Player player);

	public Player getOwner();
	
}
