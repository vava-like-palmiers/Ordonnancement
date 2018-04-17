import java.util.LinkedList;
import java.util.List;


public class Algo {
	
	public SolutionPartielle minimiser(SolutionPartielle deb, Heuristique h, int borneSup){
		SolutionPartielle meilleure = deb;
		
		//file de traitement des solution partielles
		List<SolutionPartielle> enCours = new LinkedList<>();
		
		//tant qu'on a encore des éléments à traiter
		while(!enCours.isEmpty()){
			//récupérer le premier élément de la file
			SolutionPartielle solActu = enCours.get(0);
			enCours.remove(0);
			final int borneInf = solActu.valeur();
			
			//si la solution est forcément plus mauvaise ( > ) qu'une solution déjà atteinte, l'ignorer
			//sinon, continuer de la construire
			if(borneInf < borneSup){
				//continuer de construire la solution:
				//calculer les voisins
				List<SolutionPartielle> voisins = solActu.voisins();
				enCours.addAll(voisins);
				
				//mettre à jour la borne supérieure si nécessaire
				//ie : si elle est finie, et sa valeur est inférieure à la borne supérieure
				if(solActu.finie()){
					meilleure = solActu;
				}
			}
		}
		
		
		
		
		return deb;
	}

}
