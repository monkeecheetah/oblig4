public class ReisekortSystem
{
  public static final int ANTALL = 100;
  public static final int UTVIDELSE = 10;
  private Reisekort[] reisekortene;

  public ReisekortSystem()
  {

    reisekortene = new Reisekort[ANTALL];

//    < Oppretter arrayen med lengde lik ANTALL. >

  }

  public Reisekort finnReisekort(int nr)
  {

    for(int i = 0; i < reisekortene.length; i++) {
      if(nr == reisekortene[i].getKortNr()) {
        return reisekortene[i];
      }
    }
    return null;

/*    
    < Metoden skal returnere (en referanse/peker til) det reisekortet i arrayen som har kortNr lik den innkomne parameteren nr. Hvis kortet ikke finnes i arrayen, skal metoden returnere null.>
*/
  
  }

  public void utvidArray()
  {
  
    Reisekort[] kopi = reisekortene;

    Reisekort[] reisekortene = new Reisekort[kopi.length + UTVIDELSE];

    for(int i = 0; i < kopi.length; i++) {
      reisekortene[i] = kopi[i];
    }

/*    < Metoden skal utvide arrayen med så mange elementer som konstanten UTVIDELSE angir. Metoden vil bli kalt når det er behov for å utvide arrayen i forbindelse med innsetting av et nytt reisekort. >*/

  }

  public void settInnReisekort(Reisekort k)
  {
    for (int i = 0; i < reisekortene.length; i++) {
      if(reisekortene[i] != null) {
        reisekortene[i] = k;
      }
    }

/*    < Metoden mottar et nytt reisekort som parameter og skal sette dette inn på første ledige plass i arrayen, under forutsetning av at det ikke finnes et reisekort med samme nr i arrayen fra før. Hvis arrayen er full, skal den først utvides med så mange elementer som konstanten UTVIDELSE angir, og deretter skal kortet settes inn. >*/
  }

  public Klippekort ladOppKlippekort( int nr, int belop )
  {

    for(int i = 0; i < reisekortene.length; i++) {
      if(nr == reisekortene[i].getKortNr()) {
        if(reisekortene[i] instanceof Klippekort) {
            Klippekort reisekortet = (Klippekort) reisekortene[i];
            reisekortet.ladOpp(belop);
        
          return reisekortet;
      }
    }
  }
  return null;

/*    < Hvis det finnes et klippekort med kortNr lik den innkomne parameteren nr,
      skal metoden øke saldoen på dette kortet med så mye som parameteren
      beløp angir, og deretter returnere (en referanse/peker til) klippekortet.
      Hvis det ikke finnes et slikt klippekort, skal metoden returnere null. >*/

  }
  public static String inntjeningsInfo()
  {
    String print = "";
    int klipp = Klippekort.sumAlleKlippekort();
    int dag = Dagskort.sumAlleDagskort();
    int mnd = Maanedskort.sumAlleMndkort();
    int sum = klipp + dag + mnd;

    print += "Antall klippekort solgt: " + Klippekort.antallSolgte() + "\tfor " + klipp + "kr\n";
    print += "Antall dagskort solgt: " + Dagskort.getAntallSolgte() + "\tfor" + dag + "kr\n";
    print += "Antall månedskort solgt: " + Maanedskort.getAntallSolgte() + "\tfor" + mnd + "kr\n";

    print += "Sammenlagt sum " + sum +"kr";

    return print; 

/*    < Metoden skal returnere en tekst som inneholder informasjon om hvor mange
      reisekort det er solgt av de forskjellige typene, hvor mye som er tjent inn
      på hver type, og hvor mye som er tjent inn totalt. >*/
  
  }
}  // end of class ReisekortSystem