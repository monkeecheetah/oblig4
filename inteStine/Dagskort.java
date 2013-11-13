public class Dagskort extends Reisekort
{
  public final static int DAGSPRIS = 75;
  
  private static int antallSolgte = 0;
  private static int sumAlleDagskort = 0;

  public Dagskort(){
  	super( DAGSPRIS );
  	antallSolgte ++;
  	sumAlleDagskort = ( antallSolgte * DAGSPRIS );
  }

  public static int getSumAlleDagskort(){
  	return sumAlleDagskort;
  }

  public static int getAntallSolgte(){
  	return antallSolgte;
  }

  public boolean gyldig() {  
  return true;
  }  // redefinert

}  // end of class Dagskort