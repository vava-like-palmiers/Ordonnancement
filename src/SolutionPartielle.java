import java.util.List;



public interface SolutionPartielle {
	
	public int valeur();
	
	public List<SolutionPartielle> voisins();
	
	public boolean finie();
	
}
