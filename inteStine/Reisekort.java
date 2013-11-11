import java.util.Calendar;
import java.text.DateFormat;

public abstract class Reisekort
{
  private Calendar utløpstidspunkt; // Blir tildelt verdi når kortet valideres

  private long kortNr;
  private int pris;

  // < kortNr - et unikt nummer som identifiserer hvert enkelt reisekort >
  // < pris - hva kortet koster i hele kroner >
  < hjelpevariabel for å generere et unikt kortNr >

  public Reisekort( int p, long nr ){
    pris = p;
    kortNr = nr;
  }

  < konstruktør som mottar prisen som parameter og som
    tildeler reisekortet et unikt kortNr >

    abstract void setUtløp(){
      Date 
    }

    abstract long getKortNr();

    abstract int getPris();

    abstract double getUtLøp();

// < set-metode for utløpstidspunkt >
// < get-metoder for kortNr, pris og utløpstidspunkt >

  public String gyldigTil()
  {
     if ( utløpstidspunkt == null )
       return null;

     DateFormat tf = DateFormat.getDateTimeInstance
                  ( DateFormat.LONG, DateFormat.MEDIUM );

     return tf.format(utløpstidspunkt.getTime());
  }

  public boolean gyldig() // Metoden vil  bli redefinert av subklassene
  {
     Calendar nå = Calendar.getInstance();
     return nå.before( utløpstidspunkt );
  }
}  // end of class Reisekort 