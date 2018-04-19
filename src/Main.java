import java.util.ArrayList;
import java.util.List;


public class Main {


	public static void ex1() {
		
		SolutionSommeRetards sol = (SolutionSommeRetards) SolutionSommeRetards.borneSup();
		System.out.println("sol : " + sol.afficherSol());
		System.out.println("Valeur borne supp : " + sol.valeur());
		
		
		Algo a = new Algo();
		SolutionSommeRetards solVide = new SolutionSommeRetards();
		SolutionPartielle res = a.minimiser(solVide, null, sol.valeur());
		System.out.println("test " + ((SolutionSommeRetards) res).afficherSol() + " ; valeur : " + ((SolutionSommeRetards) res).valeur());
	}
	
	
	
	public static void ex2() {
		
		SolutionMaxRetard sol = (SolutionMaxRetard) SolutionMaxRetard.borneSup();
		System.out.println("sol : " + sol.afficherSol());
		System.out.println("Valeur borne supp : " + sol.valeur());
		
		
		Algo a = new Algo();
		SolutionMaxRetard solVide = new SolutionMaxRetard();
		SolutionPartielle res = a.minimiser(solVide, null, sol.valeur());
		System.out.println("test " + ((SolutionMaxRetard) res).afficherSol() + " ; valeur : " + ((SolutionMaxRetard) res).valeur());
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		ex2();
	}

}
