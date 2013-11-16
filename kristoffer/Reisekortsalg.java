/*< import-setninger >*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reisekortsalg extends JFrame implements ActionListener
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

    klipp = new JButton("Klippekort");
    dag = new JButton("Dagskort");
    mnd = new JButton("Månedskort");
    ladeknapp = new JButton("Ladeknapp");
    info = new JTextArea(10,30);
    Container c = getContentPane();
    c.setLayout(new FlowLayout());
    c.add(klipp);
    c.add(dag);
    c.add(mnd);
    c.add(info);

    c.add(new JScrollPane(tekstFelt));

    // < oppretter skjermkomponenene >
    klipp.addActionListener(lytter);
    dag.addActionListener(lytter);
    mnd.addActionListener(lytter);
    ladeknapp.addActionListener( lytter );
    // < setter opp brukergrensesnittet. >
  }

  public void nyttReisekort(int type)
  {
    if(type == 1) {
      Reisekort reise = new Reisekort();
    } else if(type == 2) {

    } else if(type == 3) {

    }
    

/*    < Metoden skal foreta et salg av et reisekort av typen parameteren type angir.
      (Se konstantene i skissen av klassen over.) Når kortet er opprettet og satt
      inn i datasystemet, skal metoden skrive ut kortets nummer i tekstfeltet
      kortNrFelt og prisen som skal betales i tekstfeltet betalingsFelt. >*/
  }

  public void ladOppKlippekort()
  {
/*    < Metoden skal lade opp klippekortet med det beløpet som brukeren skriver
      inn, under forutsetning av at kortnummerer som oppgis tilhører et
      klippekort i datasystemet. I så fall  skal den nye saldoen skrives ut
      i et dialogvindu (JOptionPane.showMessageDialog(..)), og prisen som skal
      betales skrives i betalingsfeltet. Hvis kortnummeret er feil skal det
      skrives "error" i betalingsfeltet. > */
  }

/*  < privat lytteklasse > */

} // end of class Reisekortsalg