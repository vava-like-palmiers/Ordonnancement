import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


public class SolutionSommeRetards implements SolutionPartielle {

	private List<Processus> procs;
	
	@Override
	public int valeur() {
		
		return 0;
	}

	@Override
	public List<SolutionPartielle> voisins() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static SolutionPartielle borneSup(){
		SolutionSommeRetards sol = new SolutionSommeRetards();
		sol.procs.addAll(enonce);
		Collections.sort(sol.procs, new Comparator<Processus>() {

			@Override
			public int compare(Processus arg0, Processus arg1) {
				return arg0.di/arg0.wi < arg1.di/arg1.wi ? +1 : -1;
			}
		});
		
		return sol;
	}

}
