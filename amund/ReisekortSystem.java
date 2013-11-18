//Student: Amund Ring, Studentnr: 193379, Klasse: HINGDATA13H1AA

public class ReisekortSystem
{
    public static final int ANTALL = 100;
    public static final int UTVIDELSE = 10;
    private Reisekort[] reisekortene;

    public ReisekortSystem()
    {
        reisekortene = new Reisekort[ANTALL];
    }

    public Reisekort finnReisekort(int nr)
    {
        for (int i = 0; i < reisekortene.length; i++)
        {
            if (reisekortene[i] != null)
            {
                if (reisekortene[i].getKortNr() == nr)
                {
                    return reisekortene[i];
                }
            }
        }

        return null;
    }

    public void utvidArray()
    {
        Reisekort[] kopi = reisekortene;

        reisekortene = new Reisekort[kopi.length + UTVIDELSE];

        for (int i = 0; i < kopi.length; i++)
        {
            reisekortene[i] = kopi[i];
        }
    }

    public void settInnReisekort(Reisekort k)
    {
        if ( finnReisekort( k.getKortNr() ) == null )
        {
            for (int i = 0; i < reisekortene.length; i++)
            {
                if (reisekortene[i] == null)
                {
                    reisekortene[i] = k;
                    return;
                }
            }

            utvidArray();
            settInnReisekort(k);
        }
    }

    public Klippekort ladOppKlippekort( int nr, int beløp )
    {
        Reisekort kortet = finnReisekort(nr);

        if (kortet instanceof Klippekort)
        {
            Klippekort klippekortet = (Klippekort) kortet;
            klippekortet.ladOpp(beløp);
            return klippekortet;
        }

        return null;
    }

    public static String inntjeningsInfo()
    {
        String info = "";
        info += "Solgte klippekort:  " + Klippekort.getAntallSolgte() + "\n";
        info += "Solgte dagskort:  " + Dagskort.getAntallSolgte() + "\n";
        info += "Solgte månedskort:  " + Maanedskort.getAntallSolgte() + "\n";
        info += "Inntjent på klippekort:  " + Klippekort.getSumAlleKlippekort() + "\n";
        info += "Inntjent på dagskort:  " + Dagskort.getSumAlleDagskort() + "\n";
        info += "Inntjent på månedskort:  " + Maanedskort.getSumAlleMånedskort() + "\n";

        int totalsum =  Klippekort.getSumAlleKlippekort() +
                        Dagskort.getSumAlleDagskort() +
                        Maanedskort.getSumAlleMånedskort();

        info += "Inntjening totalt:  " + totalsum + "\n";

        return info;
    }
}  // end of class ReisekortSystem