import java.util.Calendar;

public class Maanedskort extends Reisekort
{
	public final static int MÅNEDSPRIS = 1040;

    private static int antallSolgte = 0;
    private static int sumAlleMånedskort = 0;

	public Maanedskort(int p, int innskudd)
	{
		super(p);
        antallSolgte++;
        sumAlleMånedskort += innskudd;
	}

	public static int getSumAlleMånedskort()
	{
		return sumAlleMånedskort;
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


}  // end of class Månedskort