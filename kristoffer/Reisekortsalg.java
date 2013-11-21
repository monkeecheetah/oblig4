/*
Oblig 4 for 
Stine Marie Aas Grumheden s193467 og 
Kristoffer Johansen s193370
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

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
    
    info.setText("Klippekort:\tkr.28.- klipp\n"
                +"Dagskort:\tkr. 15.-\n" 
                +"Månedskort:\tkr. 1040,-");

    setSize(400,400);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       

    klipp.addActionListener(lytter);
    dag.addActionListener(lytter);
    mnd.addActionListener(lytter);
    ladeknapp.addActionListener( lytter );
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
      Calendar gyldig = Calendar.getInstance();
      gyldig.add( Calendar.DAY_OF_YEAR, 1 );
      k.setUtlopstidspunkt(gyldig);

    } else if(type == MAANED) {
      k = new Maanedskort();
      kortsystem.settInnReisekort(k);
      betalingsFelt.setText(k.getPris()+".-");
      kortNrFelt.setText(k.getKortNr()+"");
      Calendar gyldig = Calendar.getInstance();
      gyldig.add( Calendar.DAY_OF_YEAR, 30 );
      System.out.println(gyldig);
      k.setUtlopstidspunkt(gyldig); 
    }
  }

  public void ladOppKlippekort()
  {
    int kortId = Integer.parseInt(kortNrFelt.getText());
    int belop = Integer.parseInt(belopsFelt.getText());    
    Klippekort k = kortsystem.ladOppKlippekort(kortId, belop);
    if ( k != null) {
      betalingsFelt.setText(belop + ".-");
      JOptionPane.showMessageDialog(null, "Ny saldo: kr." + k.getSaldo() + ".-");
    } else {
      betalingsFelt.setText("Error");
    }
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

} // end of class Reisekortsalg