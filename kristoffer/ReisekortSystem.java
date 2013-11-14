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
      if(nr == reisekortene[i]) {
        return reisekortene[i];
      }
    }
    return -1;

/*    < Metoden skal returnere (en referanse/peker til) det reisekortet i arrayen som har kortNr lik den innkomne parameteren nr. Hvis kortet ikke finnes i arrayen, skal metoden returnere null.>
*/
  
  }

  public void utvidArray()
  {
  


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
      if(nr == reisekortene[i].kortNr) {
        if(reisekortene[i] instanceof klippekort) {
          reisekortene[i].saldo += belop;
          return reisekortene[i];
      }
    }
  }
  return -1;

/*    < Hvis det finnes et klippekort med kortNr lik den innkomne parameteren nr,
      skal metoden øke saldoen på dette kortet med så mye som parameteren
      beløp angir, og deretter returnere (en referanse/peker til) klippekortet.
      Hvis det ikke finnes et slikt klippekort, skal metoden returnere null. >*/

  }
  public static String inntjeningsInfo()
  {
    String antMndKort = Maanedskort.getAntallSolgte();
    String antDagsKort = Dagskort.getAntallSolgte();    

/*    < Metoden skal returnere en tekst som inneholder informasjon om hvor mange
      reisekort det er solgt av de forskjellige typene, hvor mye som er tjent inn
      på hver type, og hvor mye som er tjent inn totalt. >*/
  
  }
}  // end of class ReisekortSystem