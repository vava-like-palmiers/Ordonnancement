
public class Processus {
	
	public int val;
	public int pi;
	public int di;
	public int wi;
	
	public Processus(int p, int d, int w, int v){
		pi = p;
		wi = w;
		di = d;
		val = v;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Processus other = (Processus) obj;
		if (di != other.di)
			return false;
		if (pi != other.pi)
			return false;
		if (val != other.val)
			return false;
		if (wi != other.wi)
			return false;
		return true;
	}
}
