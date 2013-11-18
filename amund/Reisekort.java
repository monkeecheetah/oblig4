//Student: Amund Ring, Studentnr: 193379, Klasse: HINGDATA13H1AA

import java.util.Calendar;
import java.text.DateFormat;

public abstract class Reisekort
{
    private Calendar utløpstidspunkt;

    private int kortNr;
    private int pris;
    private static int nesteKortNr = 1001;

    public Reisekort(int p)
    {
        kortNr = nesteKortNr++;
        pris = p;
    }

    public void setUtløpstidspunkt(Calendar c)
    {
        utløpstidspunkt = c;
    }

    public int getKortNr()
    {
        return kortNr;
    }

    public int getPris()
    {
        return pris;
    }

    public Calendar getUtløpstidspunkt()
    {
        return utløpstidspunkt;
    }

    public String gyldigTil()
    {
        if ( utløpstidspunkt == null )
        {
            return null;
        }

        DateFormat tf = DateFormat.getDateTimeInstance( DateFormat.LONG, DateFormat.MEDIUM );

        return tf.format(utløpstidspunkt.getTime());
    }

    public boolean gyldig() //Metoden vil  bli redefinert av subklassene
    {
        Calendar nå = Calendar.getInstance();
        return nå.before( utløpstidspunkt );
    }

}  // end of class Reisekort