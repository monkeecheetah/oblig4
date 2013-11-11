import java.util.Calendar;
import java.text.DateFormat;

public abstract class Reisekort
{
  private Calendar utlopstidspunkt; // Blir tildelt verdi når kortet valideres

  private int kortNr;
  private int pris;
  private int nesteKortNr;

/*
  < kortNr - et unikt nummer som identifiserer hvert enkelt reisekort >
  < pris - hva kortet koster i hele kroner >
  < hjelpevariabel for å generere et unikt kortNr >
*/

/*
  < konstruktør som mottar prisen som parameter og som
    tildeler reisekortet et unikt kortNr >
*/

  public Reisekort(int p) {
    pris = p;
    kortNr = nesteKortNr++;
  }

  abstract public void setUtlopsTidsPunkt();

/*
  < set-metode for utløpstidspunkt >
*/
  public int getKortNr() {
    return kortNr;
  }

  public int getPris() {
    return pris;
  }
  abstract public void getUtlopsTidsPunkt();

/*
  < get-metoder for kortNr, pris og utløpstidspunkt >
*/

  public String gyldigTil()
  {
     if ( utlopstidspunkt == null )
       return null;

     DateFormat tf = DateFormat.getDateTimeInstance
                  ( DateFormat.LONG, DateFormat.MEDIUM );

     return tf.format(utlopstidspunkt.getTime());
  }

  public boolean gyldig() // Metoden vil  bli redefinert av subklassene
  {
     Calendar na = Calendar.getInstance();
     return na.before( utlopstidspunkt );
  }
}  // end of class Reisekort 