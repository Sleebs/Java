import java.util.*;
class Vettore {
	private int[] V;
	public Vettore( String s ) {
		String[] X = s.split( " " );
		V = new int[ X.length ];
		for ( int i = 0; i < X.length; i++ ) {
			int c = Integer.parseInt( X[ i ] );
			//if ( c < 0 )
			//	throw new BadDataException();
			V[ i ] = c;
		}
	}
	public Vettore() { 
		V =  {1, 2, 3, 4, 5 }; 
		}
	public int dim() { return V.length; }
	public int getComp( int i ) {
		//if ( i < 1 || i > V.length ) 
		//	throw new BadDataException();
		return V[ i - 1 ];
	}
	public Vettore sommaDir( Vettore X ) {
		return new Vettore( toString() + " " + X.toString() );
	}
	public Vettore somma( Vettore X ) {
		String t = "";
		if ( V.length != X.dim() ) return new Vettore( "0 0 0 0 0" );
		for ( int i = 0; i < V.length; i++ )
			t += ( V[ i ] + X.getComp( i ) ) + ( i == V.length - 1 ? "" : " " );
		return new Vettore( t );
	}
	public String toString() {
		String t = "";
		for ( int i = 0; i < V.length; i++ )
			t += V[ i ] + ( i == V.length - 1 ? "" : " " );
		return t;
	}
	public boolean equals( Vettore X ) {
		if ( V.length != X.dim() ) return false;
		for ( int i = 0; i < V.length; i++ )
			if ( V[ i ] != X.getComp( i + 1 ) ) return false;
		return true;
	}
	
	public static void main( String[] args ) {
		int M = Integer.parseInt( args[ 0 ] );// inserito a linea di comando
		if ( M < 0 )
			System.out.println( "Parametro negativo!" );
		else {
			Scanner in = new Scanner( System.in );
			ArrayList< Vettore > A = new ArrayList< Vettore >();
			String s;
			while ( ( s = in.nextLine() ).length() > 0 ) { //finchè ha una nuova linea 
				try { 
						A.add( new Vettore( s ) ); //prova a creare un nuovo vettore
					}
				catch ( BadDataException e ) { // in caso ci sia l' erroe->
					System.out.println( "Attenzione! Componenti negative, reinserire" );
				}
			}
			for ( int i = 0; i < A.size() - 1; i++ )		//scorre l'  Array A
				for ( int j = i + 1; j < A.size(); j++ ) {	//scorre il vettore nell' array A
					Vettore p = ( A.get( i ) ).sommaDir( A.get( j ) );	//crea un vettore p e ci mette A(i) e A(j) sommati direttamente
					for ( int t = 1; t <= p.dim(); t++ ) //scorre p
						if ( p.getComp( t ) % M == 0 ) { //se p(t) è un multiplo di M
							System.out.println( A.get( i ) + " " + A.get( j ) ); //stampo i vettori i e j che sommati contenevano un moltiplicatore di M
							break;
						}
				}
		}
	}
}
