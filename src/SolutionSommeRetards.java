import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class SolutionSommeRetards implements SolutionPartielle {

	// processus représentant une solution
	private List<Processus> procs;

	// énoncé du problème
	public static List<Processus> enonce;
	public static int sommeDurees;

	static{
		enonce = new ArrayList<>();
		enonce.add(new Processus(3, 16, 2, 1));
		enonce.add(new Processus(7, 15, 3, 2));
		enonce.add(new Processus(2, 9, 1, 3));
		enonce.add(new Processus(3, 4, 2, 4));
		enonce.add(new Processus(5, 10, 4, 5));
		sommeDurees = 0;
		for(Processus p : enonce){
			sommeDurees += p.pi;
		}
	}
	
	public SolutionSommeRetards() {
		procs = new ArrayList<>();
	}

	public List<Processus> getProcs() {
		return procs;
	}

	@Override
	public int valeur(){
		
		//calculer la somme des retards
		int sum = 0;
		int currentEnd = SolutionSommeRetards.sommeDurees;
		for(Processus p : procs){
			final int retard = Math.max(0, (currentEnd - p.di)*p.wi);
			currentEnd -= p.pi;
			sum += retard;
		}
		
		return sum;
	}
	
	
	@Override
	public boolean finie(){
		return procs.size() == enonce.size();
	}

	@Override
	public List<SolutionPartielle> voisins() {
		List<SolutionPartielle> v = new ArrayList<>(enonce.size());
		for(Processus p : enonce){
			if(!procs.contains(p)){
				SolutionSommeRetards sol = this.clone();
				sol.procs.add(p);
				v.add(sol);
			}
		}
		return v;
	}
	
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SolutionSommeRetards other = (SolutionSommeRetards) obj;
		if (procs == null) {
			if (other.procs != null)
				return false;
		} else if (!procs.equals(other.procs))
			return false;
		return true;
	}

	public SolutionSommeRetards clone(){
		SolutionSommeRetards s = new SolutionSommeRetards();
		s.procs.addAll(this.procs);
		return s;
	}
	
	public static SolutionPartielle borneSup() {
		SolutionSommeRetards sol = new SolutionSommeRetards();
		sol.procs.addAll(enonce);
		Collections.sort(sol.procs, new Comparator<Processus>() {

			@Override
			public int compare(Processus arg0, Processus arg1) {
				return (double)arg0.di / (double)arg0.wi < (double)arg1.di / (double)arg1.wi ? 1 : -1;
			}
		});

		return sol;
	}

	public String afficherSol() {
		StringBuilder s = new StringBuilder();
		for (Processus p : procs) {
			s.append(p.val + " ");
		}
		return s.toString();
	}

	public void removeProc(){
		procs.remove(0);
	}
}
