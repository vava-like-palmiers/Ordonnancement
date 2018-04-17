
public class HeuristiqueSommeRetards implements Heuristique {

	/**
	 * Calculer la borne inférieure
	 */
	@Override
	public double valeur(SolutionPartielle sol) {
		SolutionSommeRetards s = (SolutionSommeRetards) sol;
		
		//calculer la somme des retards
		int sum = 0;
		int currentStart = SolutionSommeRetards.sommeDurees;
		for(Processus p : s.getProcs()){
			final int retard = Math.max(0, (currentStart - p.di)*p.wi);
			sum += retard;
			currentStart -= p.pi;
		}
		
		return sum;
	}

}
