// Klassen ReisekortSystem, som er skissert nedenfor, lagrer alle reisekortene i en array. I utgangspunktet er det plass til 100 reisekort. Arrayens størrelse skal imidlertid kunne økes etter behov slik at salget av reisekort ikke begrenses. Nedenfor ser du en skisse av klassen: 

public class ReisekortSystem
{
  public static final int ANTALL = 100; //flyttet = tegnet til etter antall
  public static final int UTVIDELSE = 10;
  private Reisekort[] reisekortene;

  public ReisekortSystem()
  {
    reisekortene = new Reisekort[ANTALL];
    // < Oppretter arrayen med lengde lik ANTALL. >
  }

  public Reisekort finnReisekort(int nr)
  {
    for(int i = 0; i < reisekort.length; i++){
      if ( reisekort[i].getKortNr() = nr ){
        return i;
      }

    }
/*    < Metoden skal returnere (en referanse/peker til) det reisekortet
      i arrayen som har kortNr lik den innkomne parameteren nr.
      Hvis kortet ikke finnes i arrayen, skal metoden returnere null.>*/
  }

  public void utvidArray()
  {
    Reisekort[] temp = reisekortene;

    reisekortene = new Reisekort[ reisekortene.length + UTVIDELSE ];
    
    for( int i = 0; i < reisekortene; i++ ){
      if(reisekortene[i] =! null){
        reisekortene[i] = temp[i];
      }
    }
    /*< Metoden skal utvide arrayen med så mange elementer som konstanten
      UTVIDELSE angir. Metoden vil bli kalt når det er behov for å utvide
      arrayen i forbindelse med innsetting av et nytt reisekort. >*/
  }

  public void settInnReisekort(Reisekort k){
    boolean check;
    for( int i = 0; i < reisekortene.length; i++){
      if( reisekortene[i].getKortNr == k )
        check = true;
    }

    if( !check ){
      for( int i = 0; i < reisekortene.length; i++ ){
        if( reisekortene[i] == null )
          reisekortene[i] = k;
        else{
          utvidArray();
          settInnReisekort( Reisekort k );
        }
      }
    }

   /* < Metoden mottar et nytt reisekort som parameter og skal sette dette inn på første ledige plass i arrayen, under forutsetning av at detikke finnes et reisekort med samme nr i arrayen fra før. Hvis arrayen er full, skal den først utvides med så mange elementer som konstanten UTVIDELSE angir, og deretter skal kortet settes inn. >*/
  }

  public Klippekort ladOppKlippekort( int nr, int beløp ){
    for(int i = 0; i < reisekortene.length; i++ reisekortene[i]instanceof Klippekort){
      if(reisekortene[i].getKortNr == nr && reisekortene[i] instanceof Klippekort ){
        Klippekort(beløp);
        return Klippekort;
      }
      return null;
    }
/*    < Hvis det finnes et klippekort med kortNr lik den innkomne parameteren nr,
      skal metoden øke saldoen på dette kortet med så mye som parameteren
      beløp angir, og deretter returnere ( en referanse/peker til) klippekortet.
      Hvis det ikke finnes et slikt klippekort, skal metoden returnere null. >*/
  }

  public static String inntjeningsInfo()
  {
    int sum, sumMnd, sumDag, sumKlipp; 
    for( int i = 0; i < reisekortene.length; i++){
      if( reisekortene[i]  instanceof Maanedskort )
        sumMnd += reisekortene[i].getAntallSolgte();
      else if( reisekortene[i]  instanceof Dagskort )
        dumDag += reisekortene[i].getAntallSolgte();

    }
  /*
    < Metoden skal returnere en tekst som inneholder informasjon om   hvor mange reisekort det er solgt av de forskjellige typene, hvor mye som er tjent inn på hver type, og hvor mye som er tjent inn totalt. >*/
  }
}  // end of class ReisekortSystem

/*
 a) Programmer klassens konstruktør og metoden public Reisekort finnReisekort(int nr).

b) Programmer metoden public void utvidArray().

c) Programmer metoden public void settInnReisekort(Reisekort k).

d) Programmer metoden public Klippekort ladOppKlippekort( int nr, int beløp ).

e) Programmer metoden public static String inntjeningsInfo().


*/