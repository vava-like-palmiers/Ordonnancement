import java.util.ArrayList;
import java.util.List;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SolutionSommeRetards sol = (SolutionSommeRetards) SolutionSommeRetards.borneSup();
		System.out.println("sol : " + sol.afficherSol());
		System.out.println("Valeur borne supp : " + sol.valeur());
		
		
		Algo a = new Algo();
		SolutionSommeRetards solVide = new SolutionSommeRetards();
		SolutionPartielle res = a.minimiser(solVide, null, sol.valeur());
		System.out.println("test" + ((SolutionSommeRetards) res).afficherSol() + " ; valeur : " + ((SolutionSommeRetards) res).valeur());
	}

}
