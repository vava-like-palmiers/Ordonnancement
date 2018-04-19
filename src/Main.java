import java.util.ArrayList;
import java.util.List;


public class Main {


	public static void ex1() {
		//afficher l'énoncé
		System.out.println("Exercice 1, énoncé : ");
		for(Processus p : SolutionSommeRetards.enonce) {
			System.out.println(p);
		}
		
		SolutionSommeRetards sol = (SolutionSommeRetards) SolutionSommeRetards.borneSup();
		System.out.println("heuristique : ");
		System.out.println(sol.afficherSol());
		System.out.println("Valeur borne supp : " + sol.valeur());
		
		
		Algo a = new Algo();
		SolutionSommeRetards solVide = new SolutionSommeRetards();
		SolutionPartielle res = a.minimiser(solVide, null, sol.valeur());
		System.out.println("----");
		System.out.println("solution : " + ((SolutionSommeRetards) res).afficherSol() + " ; valeur : " + ((SolutionSommeRetards) res).valeur());
	}
	
	
	
	public static void ex2() {
		//afficher l'énoncé
		System.out.println("Exercice 2, énoncé : ");
		for(Processus p : SolutionMaxRetard.enonce) {
			System.out.println(p);
		}
		
		SolutionMaxRetard sol = (SolutionMaxRetard) SolutionMaxRetard.borneSup();
		System.out.println("heuristique : ");
		System.out.println(sol.afficherSol());
		System.out.println("Valeur borne supp : " + sol.valeur());
		
		
		Algo a = new Algo();
		SolutionMaxRetard solVide = new SolutionMaxRetard();
		SolutionPartielle res = a.minimiser(solVide, null, sol.valeur());
		System.out.println("----");
		System.out.println("solution : " + ((SolutionMaxRetard) res).afficherSol() + " ; valeur : " + ((SolutionMaxRetard) res).valeur());
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		ex1();
		System.out.println();
		System.out.println();
		System.out.println();
		ex2();
	}

}
