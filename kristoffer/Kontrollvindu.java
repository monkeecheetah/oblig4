import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Kontrollvindu extends JFrame{

  private JTextField kortIdFelt;
  private JTextArea display;
  private JButton kontroll;
  private ReisekortSystem kortsystem;
  private Lytter lytter;
  public Kontrollvindu(ReisekortSystem r)
  {
    super("BILLETTKONTROLL");
    kortIdFelt = new JTextField(10);
    display = new JTextArea(10,30);
    kontroll = new JButton("Kontroller kort");

    // kortsystem = new ReisekortSystem();

/*    < kaller superklassens konstruktør > */

    kortsystem = r;
    Lytter lytter = new Lytter();
    kontroll.addActionListener( lytter );

    Container c = getContentPane();
    c.setLayout( new FlowLayout() );
    c.add( new JLabel("Reisekortnr:") );
    c.add( kortIdFelt );
    c.add( kontroll );
    c.add( display );

    setSize(400,400);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

/*    < oppretter lytteobjekt og knytter knappen til det. >
      < setter opp brukergrensesnittet > */
  }

    // for(int i = 0; i < reisekortene.length; i++) {
    //   if(nr == reisekortene[i].getKortNr()) {
    //     if(reisekortene[i] instanceof Klippekort) {
    //         Klippekort reisekortet = (Klippekort) reisekortene[i];
    //         reisekortet.ladOpp(belop);

  public void kontrollerReisekort() {

    int kortNummer = Integer.parseInt(kortIdFelt.getText());

    Reisekort k = kortsystem.finnReisekort(kortNummer);

    display.setText("");
    System.out.println("kortsystem drifter");
    if(k == null) {
      display.setText("Kortet finnes ikke");
      return;
    }
    if (k.gyldig()) {
      if(k instanceof Klippekort) {
        display.append("Betalt kr." + Klippekort.PRIS_PER_REISE+".-");
        display.append("Saldo: kr." + ((Klippekort) k).getSaldo() + ".-");
      }
        display.append("Gyldig til " + k.gyldigTil());
      } else {
        display.setText("Ugyldig billett, kjøp ny (moskus) ");
      } if(k instanceof Klippekort) {
        display.append("Saldo: kr. "+((Klippekort) k).getSaldo() + ".-\n");
      }
      kortIdFelt.setText("");
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
  

  private class Lytter implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      System.out.println("DU TRØKKA PÅ KONTROLL");
    if ( e.getSource() == kontroll )
      kontrollerReisekort();
    }
  }

/*  < privat lytteklasse > */

}  // end of class Kontrollvindu