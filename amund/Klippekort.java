import java.util.Calendar;

public class Klippekort extends Reisekort
{
    public final static int PRIS_PER_REISE = 28;
    private int saldo;

    private static int antallSolgte = 0;
    private static int sumAlleKlippekort = 0;

    public Klippekort(int innskudd)
    {
        super(PRIS_PER_REISE);
        saldo = innskudd;
        antallSolgte++;
        sumAlleKlippekort += innskudd;
    }

    public int getSaldo()
    {
        return saldo;
    }

    public static int getSumAlleKlippekort()
    {
        return sumAlleKlippekort;
    }

    public static int getAntallSolgte()
    {
        return antallSolgte;
    }


    public boolean gyldig() // Blir redefinert her!
    {
        Calendar utløpstid = super.getUtløpstidspunkt();
        Calendar nå = Calendar.getInstance();

        if ( nå.before(utløpstid) )
        {
            return true;
        }
        else if (saldo >= PRIS_PER_REISE)
        {
            saldo -= PRIS_PER_REISE;
            return true;
        }
        else
        {
            return false;
        }
    }

    public void ladOpp(int beløp)
    {
        saldo += beløp;
        sumAlleKlippekort += beløp;
    }

}  // end of class Klippekort