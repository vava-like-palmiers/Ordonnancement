import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SolutionMaxRetard implements SolutionPartielle {
	
	// Ã©noncÃ© du problÃ¨me
	public static List<Processus> enonce;
	private static int sommeDurees;
	
	private List<Processus> m1;
	private List<Processus> m2;

	static{
		enonce = new ArrayList<>();
		enonce.add(new Processus(3, 4, 0, 1));
		enonce.add(new Processus(4, 6, 0, 2));
		enonce.add(new Processus(6, 8, 0, 3));
		enonce.add(new Processus(3, 7, 0, 4));
		enonce.add(new Processus(2, 9, 0, 5));
		enonce.add(new Processus(5, 10, 0, 6));
		sommeDurees = 0;
		for(Processus p : enonce){
			sommeDurees += p.pi;
		}
	}


	public SolutionMaxRetard() {
		m1 = new ArrayList<>();
		m2 = new ArrayList<>();
	}

	@Override
	public int valeur() {
		//calculer le retard maximal
		int maxRetard = -1;
		int currentEnd = 0;
		for(Processus p : m1){
			currentEnd += p.pi;
			final int retard = Math.max(0, (currentEnd - p.di));
			if(retard > maxRetard) {
				maxRetard = retard;
			}
		}
		currentEnd = 0;
		for(Processus p : m2){
			currentEnd += p.pi;
			final int retard = Math.max(0, (currentEnd - p.di));
			if(retard > maxRetard) {
				maxRetard = retard;
			}
		}
		
		return maxRetard;
	}

	@Override
	public List<SolutionPartielle> voisins() {
		List<SolutionPartielle> v = new ArrayList<>(enonce.size());
		//construire des solutions avec un processus en plus
		for(Processus p : enonce) {
			//placer un processus s'il n'est pas déjà placé
			if(!m1.contains(p) && !m2.contains(p)) {
				SolutionMaxRetard sol = this.clone();
				sol.m1.add(p);
				v.add(sol);
				sol = (SolutionMaxRetard) this.clone();
				sol.m2.add(p);
				v.add(sol);
			}
		}
		return v;
	}

	@Override
	public boolean finie() {
		return m1.size()  + m2.size() == enonce.size();
	}
	
	
	
	
	public static SolutionPartielle borneSup() {
		SolutionMaxRetard sol = new SolutionMaxRetard();
		List<Processus> procs = new ArrayList<>();
		procs.addAll(enonce);
		Collections.sort(procs, new Comparator<Processus>() {
			@Override
			public int compare(Processus arg0, Processus arg1) {
				return arg0.di - arg1.di;
			}
		});
		
		//injecter les processus dans la solution
		int fin1 = 0, fin2 = 0;
		for(Processus p : procs) {
			//la machine 1 est moins occupée
			if(fin1 <= fin2) {
				sol.m1.add(p);
				fin1 += p.pi;
			}else {	//la machine 2 est moins occupée
				sol.m2.add(p);
				fin2 += p.pi;
			}
		}

		return sol;
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SolutionMaxRetard other = (SolutionMaxRetard) obj;
		if (m1 == null) {
			if (other.m1 != null)
				return false;
		} else if (!m1.equals(other.m1))
			return false;
		if (m2 == null) {
			if (other.m2 != null)
				return false;
		} else if (!m2.equals(other.m2))
			return false;
		return true;
	}

	
	public SolutionMaxRetard clone() {
		SolutionMaxRetard s = new SolutionMaxRetard();
		s.m1.addAll(this.m1);
		s.m2.addAll(this.m2);
		return s;
	}
	
	
	public String afficherSol() {
		StringBuilder s = new StringBuilder();
		s.append("M1 : ");
		for (Processus p : m1) {
			s.append(p.val + " ");
		}
		s.append("\nM2 : ");
		for (Processus p : m2) {
			s.append(p.val + " ");
		}
		return s.toString();
	}
	
	
}
