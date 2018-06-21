
public class Cubo {
	static double lato;
	public  Cubo(double l) {
		lato=l;
	}
	//restituisce il volume del cubo
	public static double getVolume() {
		return lato*lato*lato;
	}
	//restituisce una stringa contenente il lato del cubo
	public String toString() {
		return "Cubo di lato: "+ lato;
	}
}
