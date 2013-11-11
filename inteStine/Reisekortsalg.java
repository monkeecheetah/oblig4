< import-setninger >

public class Reisekortsalg < ... >
{
  private static final int KLIPP = 1, DAG = 2, MÅNED = 3;
  private JTextField kortNrFelt, betalingsFelt, beløpsFelt;
  private JButton klipp, dag, mnd, ladeknapp;
  private JTextArea info;
  private Lytter lytter;
  private ReisekortSystem kortsystem;

  public Reisekortsalg(ReisekortSystem k)
  {
    super("KORTSALG");
    kortsystem = k;
    lytter =  new Lytter();
    < oppretter skjermkomponenene >
    klipp.addActionListener(lytter);
    dag.addActionListener(lytter);
    mnd.addActionListener(lytter);
    ladeknapp.addActionListener( lytter );
    < setter opp brukergrensesnittet. >
  }

  public void nyttReisekort(int type)
  {
    < Metoden skal foreta et salg av et reisekort av typen parameteren type angir.
      (Se konstantene i skissen av klassen over.) Når kortet er opprettet og satt
      inn i datasystemet, skal metoden skrive ut kortets nummer i tekstfeltet
      kortNrFelt og prisen som skal betales i tekstfeltet betalingsFelt. >
  }

  public void ladOppKlippekort()
  {
    < Metoden skal lade opp klippekortet med det beløpet som brukeren skriver
      inn, under forutsetning av at kortnummerer som oppgis tilhører et
      klippekort i datasystemet. I så fall  skal den nye saldoen skrives ut
      i et dialogvindu (JOptionPane.showMessageDialog(..)), og prisen som skal
      betales skrives i betalingsfeltet. Hvis kortnummeret er feil skal det
      skrives "error" i betalingsfeltet. >
  }

  < privat lytteklasse >

} // end of class Reisekortsalg

a) Programmer metoden public void nyttReisekort(int type).

b) Programmer metoden public void ladOppKlippekort().

c) Programmer den private lytteklassen slik at den fanger opp klikkene på knappene og sørger at riktig oppgave blir utført. 