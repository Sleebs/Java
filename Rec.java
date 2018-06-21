import java.util.Scanner;
class Rec {
	public static void main( String[] args ) {
		Recipiente R1 = new Recipiente( Integer.parseInt(args[0]) );
		Recipiente R2 = new Recipiente( Integer.parseInt(args[1]) );
		Cubo max1 = null, max2 = null, c;
		Scanner in = new Scanner( System.in );
		try {
			while ( true ) {
				System.out.print( "Lato del cubo: ");
				c = new Cubo( in.nextDouble() );
	if ( R1.getVolumeDisponibile() > R2.getVolumeDisponibile() ) {
		R1.metti( c );
		if ( max1 == null || c.getVolume() > max1.getVolume() )
			max1 = c;
	}
	else {
		R2.metti( c );
		if ( max2 == null || c.getVolume() > max2.getVolume() )
			max2 = c;
	}
			}
		}
		catch ( RecFullException e ) {
			System.out.println( "Contenuto del recipiente col cubo di volume maggiore:" )
			System.out.println( max1.getVolume() > max2.getVolume() ? R1 : R2 );
		}
	}
}