import java.util.Calendar;

public class Maanedskort extends Reisekort
{

  public final static int MÅNEDSPRIS = 1040;

  private static int antallSolgte = 0;
  private static int sumAlleMndkort = 0;      // Det totale antall solgte klippekort


  public Månedskort(){
  super( MÅNEDSPRIS );
  antallSolgte ++;
  sumAlleMndkort = ( antallSolgte * MÅNEDSPRIS );
  }

  public static int getSumAlleMndkort(){
  	return sumAlleMndkort;
  }

  public static int getAntallSolgte(){
  	return antallSolgte;
  }

  public boolean gyldig(){
  	return true;
  }  // redefinert
}  // end of class Månedskort

// Klassene Dagskort og Månedskort skal ikke programmeres, men du vil få bruk for dem senere i oppgaven. Et dagskort er gyldig som billett i 24 timer etter at det er opprettet, mens et månedskort er gyldig i 30 dager etter opprettelsen. Du trenger ikke å vite noe om hvordan klassene er implementert, men du må vite hva metodene gjør, hvilke parametere de har og hva de returnerer. Nedenfor ser du skisser av klassene, med deres public datafelt og metoder.