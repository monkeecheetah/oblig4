/*
Oblig 4 for 
Stine Marie Aas Grumheden s193467 og 
Kristoffer Johansen s193370
*/

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

  public static int sumAlleDagskort(){
  	return sumAlleDagskort;
  }

  public static int antallSolgte(){
  	return antallSolgte;
  }

  public boolean gyldig() {  
   boolean sjekk = super.gyldig();

   if(sjekk == true){
      return sjekk;
    }
    return false;
  }  // redefinert

}  // end of class Dagskort