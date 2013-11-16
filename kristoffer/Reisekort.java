import java.util.Calendar;
import java.text.DateFormat;

public abstract class Reisekort
{
  private Calendar utlopstidspunkt; // Blir tildelt verdi når kortet valideres

  private int kortNr, pris;
  private int nesteKortNr = 1;

  // < kortNr - et unikt nummer som identifiserer hvert enkelt reisekort >
  // < pris - hva kortet koster i hele kroner >
  // < hjelpevariabel for å generere et unikt kortNr >

  public Reisekort( int p ){
    pris = p;
    kortNr = nesteKortNr++;
  }

  // < konstruktør som mottar prisen som parameter og som
  //   tildeler reisekortet et unikt kortNr >

    public void setUtlopstidspunkt(){
      utlopstidspunkt = Calendar.getInstance();
    } 

    public int getKortNr(){
      return kortNr;
    }

    public int getPris(){
      return pris;
    }

    public Calendar getUtlopstidspunkt(){
      return utlopstidspunkt;
    }

// < set-metode for utløpstidspunkt >
// < get-metoder for kortNr, pris og utløpstidspunkt >

  public String gyldigTil()
  {
     if ( utlopstidspunkt == null )
       return null;

     DateFormat tf = DateFormat.getDateTimeInstance
                  ( DateFormat.LONG, DateFormat.MEDIUM );

     return tf.format(utlopstidspunkt.getTime());
  }
// Metoden vil  bli redefinert av subklassene
  public boolean gyldig() {
     Calendar now = Calendar.getInstance();
     return now.before( utlopstidspunkt );
  }
}  // end of class Reisekort 