import java.util.Calendar;

public class Dagskort extends Reisekort
{
	public final static int DAGSPRIS = 75;

    private static int antallSolgte = 0;
    private static int sumAlleDagskort = 0;

	public Dagskort()
	{
		super(DAGSPRIS);
        antallSolgte++;
        sumAlleDagskort += DAGSPRIS;
	}

	public static int getSumAlleDagskort()
	{
		return sumAlleDagskort;
	}

	public static int getAntallSolgte()
	{
		return antallSolgte;
	}

	public boolean gyldig()
	{
        Calendar utløpstid = super.getUtløpstidspunkt();
        Calendar nå = Calendar.getInstance();

        if ( nå.before(utløpstid) )
        {
            return true;
        }
        else
        {
            return false;
        }
	}


}  // end of class Dagskort