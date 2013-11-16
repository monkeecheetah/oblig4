import javax.swing.*;

public class Kontrollvindu extends JFrame implements ActionListener{

  private JTextField kortIdFelt;
  private JTextArea display;
  private JButton kontroll;
  private ReisekortSystem kortsystem;

  public Kontrollvindu(ReisekortSystem r)
  {
    super("BILLETT KONTROLL")
    kortIdfelt = new JTextField();
    display = new JTextArea();
    kontroll = new JButton();

    // kortsystem = new ReisekortSystem();

/*    < kaller superklassens konstruktør > */

    kortsystem = r;

    kontroll.addActionListener( this );

    Container c = getContentPane();
    c.setLayout( new FlowLayout() );
    c.add( new JLabel("Reisekortnr:") );
    c.add( kortIdfelt );
    c.add( kontroll );
    c.add( display );

/*    < oppretter lytteobjekt og knytter knappen til det. >
      < setter opp brukergrensesnittet > */
  }

    // for(int i = 0; i < reisekortene.length; i++) {
    //   if(nr == reisekortene[i].getKortNr()) {
    //     if(reisekortene[i] instanceof Klippekort) {
    //         Klippekort reisekortet = (Klippekort) reisekortene[i];
    //         reisekortet.ladOpp(belop);

  public void kontrollerReisekort(){

  int kortNummer = kortIdfelt.getText()

    for(int i = 0; i < kortsystem.length; i++){
      if(kortsystem[i].getKortNr == kortNummer){
        if( kortnummer[i].gyldig() == true ){
          if( kortnummer[i] instanceof Klippekort){
            Klippekort klipp = (Klippekort) kortnummer[i];
            if(klipp.gyldig() == true );
              display.setText( "Gjenstående saldo på klippekort " + klipp.getSaldo + "\npris pr reiser er " + PRIS_PER_REISE + "kr\nbiletten er gyldig i en time");
          }else if( kortnummer[i] instanceof Dagskort){
            Dagskort dag = (Dagskort) kortnummer[i];
            if (dag.gyldig() == true )
              

          }else if( kortnummer[i] instanceof Maanedskort ){
            Maanedskort mnd = (Maanedskort) kortnummer[i];

          }
        }
      }

    }
/*    < Metoden må lese inn kortets nummer og sjekke om det finnes
      blandt de registrerte kortene. Hvis det finnes og det er gyldig,
      skal følgende gjøre:

      - Hvis det er et klippekort, skal prisen for en reise trekkes fra
      saldoen på kortet. Deretter skal det skrives ut i tekstområde hva
      reisen koster, hva som er saldoen etter at reisen er betalt og hvor
      lenge billetten varer.

      - Hvis det er et dagskort eller et månedskort skal det kun skrives ut
      hvor lenge billetten varer.

      Hvis kortet er ugyldig, skal dette skrives i tekstområdet.
      For klippekort skal i tillegg saldoen skrives ut.

      Hvis kortet er ukjent, skal dette skrives i tekstområdet.> */
  }

  private void actionPerformed( ActionEvent e){
    if ( e.getSorce() == kontroll )
      kontrollerReisekort()
  }

/*  < privat lytteklasse > */

}  // end of class Kontrollvindu