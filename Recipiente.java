import java.util.*;

public class Recipiente {
static ArrayList<Cubo> contiene  = new ArrayList<Cubo>();
	static int capacita;
	public Recipiente(int c) {
		capacita=c;
	}
	public static int getCap() {
		return capacita;
	}
	public static double getVolumeCubi() {
		double tot = 0;
		for(int i=0;i<contiene.size();i++)
			tot+=contiene.get(i).getVolume();
		return tot;
	}
	public double getVolumeDisponibile() {
		return capacita-Recipiente.getVolumeCubi();
	}	
	public void metti( Cubo c ) {
		if(c.getVolume()<this.getVolumeDisponibile())
			contiene.add(c);
		//else
			//throw new RecFullException();
	}
	public int numCubi() {
		return contiene.size();
	}
	public static Cubo getCubo( int i ) {
		//if ( i < 1 || i > contiene.size())
			//throw new NoCubeException();
		return contiene.get(i-1);
	}
	public String toString() {
		String txt="";
		for(int i=0;i<contiene.size();i++)
			txt+= contiene.get(i).toString()+"\n";
		return txt;
	}
	public static Recipiente versa( Recipiente R1, Recipiente R2 ) {
		Recipiente V = new Recipiente( R1.getCap() + R2.getCap() );
		for ( int i = 1; i <= R2.numCubi(); V.metti( R2.getCubo( i++ ) ) );
		for ( int i = R1.numCubi(); i >= 1; V.metti( R1.getCubo( i-- ) ) );
		return V;
		}
}
