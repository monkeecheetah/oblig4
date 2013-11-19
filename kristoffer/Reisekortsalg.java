/*< import-setninger >*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reisekortsalg extends JFrame
{
  private static final int KLIPP = 1, DAG = 2, MAANED = 3;
  private JTextField kortNrFelt, betalingsFelt, belopsFelt;
  private JButton klipp, dag, mnd, ladeknapp;
  private JTextArea info;
  private Lytter lytter;
  private ReisekortSystem kortsystem;

  public Reisekortsalg(ReisekortSystem k)
  {
    super("KORTSALG");
    kortsystem = k;
    lytter =  new Lytter();

    kortNrFelt = new JTextField(15);
    betalingsFelt = new JTextField(15);
    belopsFelt = new JTextField(15);
    klipp = new JButton("Klippekort");
    dag = new JButton("Dagskort");
    mnd = new JButton("Månedskort");
    ladeknapp = new JButton("Ladeknapp");
    info = new JTextArea(10,30);
    Container c = getContentPane();
    betalingsFelt.setEditable(false);
    c.setLayout(new FlowLayout());
    c.add(info);
    c.add(klipp);
    c.add(dag);
    c.add(mnd);
    c.add(new JLabel ("Beløp:"));
    c.add(belopsFelt);
    c.add(ladeknapp);
    c.add(new JLabel ("Kortnr: "));
    c.add(kortNrFelt);
    c.add(new JLabel ("Betal kr: "));
    c.add(betalingsFelt);    
    

    setSize(400,400);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       

    // < oppretter skjermkomponenene >
    klipp.addActionListener(lytter);
    dag.addActionListener(lytter);
    mnd.addActionListener(lytter);
    ladeknapp.addActionListener( lytter );
    // < setter opp brukergrensesnittet. >
  }

  public void nyttReisekort(int type)
  {
    Reisekort k = null;
    if(type == KLIPP) {
      int belop = Integer.parseInt(belopsFelt.getText());
      k = new Klippekort(belop); 
      kortsystem.settInnReisekort(k);
      betalingsFelt.setText(k.getPris()+".-");
      kortNrFelt.setText(k.getKortNr()+"");  
    } else if (type == DAG) {
      k = new Dagskort();
      kortsystem.settInnReisekort(k);
      betalingsFelt.setText(k.getPris()+".-");
      kortNrFelt.setText(k.getKortNr()+"");  
    } else if(type == MAANED) {
      k = new Maanedskort();
      kortsystem.settInnReisekort(k);
      betalingsFelt.setText(k.getPris()+".-");
      kortNrFelt.setText(k.getKortNr()+"");
    }

/*    < Metoden skal foreta et salg av et reisekort av typen parameteren type angir.
      (Se konstantene i skissen av klassen over.) Når kortet er opprettet og satt
      inn i datasystemet, skal metoden skrive ut kortets nummer i tekstfeltet
      kortNrFelt og prisen som skal betales i tekstfeltet betalingsFelt. >*/
  }

  public void ladOppKlippekort()
  {
    int kortId = Integer.parseInt(kortNrFelt.getText());
    int belop = Integer.parseInt(belopsFelt.getText());    
    System.out.println("kortId"+kortId);
    Klippekort k = kortsystem.ladOppKlippekort(kortId, belop);
    System.out.println("Her er k som tydeligvis ikke er noenting og det faensteike mæ feil!!!! "+k);
    if ( k != null) {
      betalingsFelt.setText(belop + ".-");
      JOptionPane.showMessageDialog(null, "Ny saldo: kr." + k.getSaldo() + ".-");
    } else {
      betalingsFelt.setText("Error");
    }
/*    < Metoden skal lade opp klippekortet med det beløpet som brukeren skriver
      inn, under forutsetning av at kortnummerer som oppgis tilhører et
      klippekort i datasystemet. I så fall  skal den nye saldoen skrives ut
      i et dialogvindu (JOptionPane.showMessageDialog(..)), og prisen som skal
      betales skrives i betalingsfeltet. Hvis kortnummeret er feil skal det
      skrives "error" i betalingsfeltet. > */
  }

  private class Lytter implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      if(e.getSource() == klipp) {
        nyttReisekort(KLIPP);
      } else if(e.getSource() == dag) {
        nyttReisekort(DAG);
      } else if(e.getSource() == mnd) {
        nyttReisekort(MAANED);
      } else if(e.getSource() == ladeknapp) {
        ladOppKlippekort();
      }

    }
  }

/*  < privat lytteklasse > */

} // end of class Reisekortsalg