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

	public SolutionSommeRetards() {
		enonce = new ArrayList<>();
		procs = new ArrayList<>();
		initDIWI();
	}

	public List<Processus> getProcs() {
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

	public static SolutionPartielle borneSup() {
		SolutionSommeRetards sol = new SolutionSommeRetards();
		sol.procs.addAll(enonce);
		Collections.sort(sol.procs, new Comparator<Processus>() {

			@Override
			public int compare(Processus arg0, Processus arg1) {
				return arg0.di / arg0.wi < arg1.di / arg1.wi ? +1 : -1;
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

	public void initDIWI() {
		enonce.add(new Processus(3, 16, 2, 1));
		enonce.add(new Processus(7, 15, 3, 2));
		enonce.add(new Processus(2, 9, 1, 3));
		enonce.add(new Processus(3, 4, 2, 4));
		enonce.add(new Processus(5, 10, 4, 5));
	}
}
