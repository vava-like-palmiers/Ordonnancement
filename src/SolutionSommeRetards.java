import java.util.List;


public class SolutionSommeRetards implements SolutionPartielle {
	
	//processus représentant une solution
	private List<Processus> procs;
	
	//énoncé du problème
	public static List<Processus> enonce;
	public static int sommeDurees;
	
	
	public List<Processus> getProcs(){
		return procs;
	}
	
	
	@Override
	public int valeur() {
		// TODO
		return 0;
	}

	@Override
	public List<SolutionPartielle> voisins() {
		// TODO Auto-generated method stub
		return null;
	}

}
