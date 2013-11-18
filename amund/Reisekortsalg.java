

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

public class Reisekortsalg extends JFrame
{
	private static final int KLIPP = 1, DAG = 2, MÅNED = 3;
	private JTextField kortNrFelt, betalingsFelt, beløpsFelt;
	private JButton klippKnapp, dagKnapp, mnd, ladeknapp;
	private JTextArea info;
	private Lytter lytter;
	private ReisekortSystem kortsystem;

	public Reisekortsalg(ReisekortSystem k)
	{
		super("KORTSALG");
		kortsystem = k;
		lytter =  new Lytter();
		kortNrFelt = new JTextField(7);
		betalingsFelt = new JTextField(5);
		betalingsFelt.setEditable(false);
		beløpsFelt = new JTextField(5);
		klippKnapp = new JButton("Klippekort");
		dagKnapp = new JButton("Dagskort");
		mnd = new JButton("Månedskort");
		ladeknapp = new JButton("Opplading av klippekort");
		info = new JTextArea(3, 25);
		info.setText("Klippekort:\tkr. 28,- per klipp\n" +
					"Dagskort:\tkr. 75,-\n" +
					"Månedskort:\t kr. 1040,-");
		info.setEditable(false);
		klippKnapp.addActionListener(lytter);
		dagKnapp.addActionListener(lytter);
		mnd.addActionListener(lytter);
		ladeknapp.addActionListener(lytter);

		Container c = getContentPane();
		c.setLayout( new FlowLayout() );
		c.add(info);
		c.add(klippKnapp);
		c.add(dagKnapp);
		c.add(mnd);
		c.add( new JLabel("Beløp:") );
		c.add(beløpsFelt);
		c.add(ladeknapp);
		c.add( new JLabel("Reisekortnr:") );
		c.add(kortNrFelt);
		c.add( new JLabel("Betal kr:") );
		c.add(betalingsFelt);

		setSize(350, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void nyttReisekort(int type)
	{
		Calendar gyldigTil;

		switch (type)
		{
			case KLIPP:	int innskudd = Integer.parseInt( beløpsFelt.getText() );
						beløpsFelt.setText("");
						Klippekort klippekortet = new Klippekort(innskudd);
						gyldigTil = Calendar.getInstance();
						klippekortet.setUtløpstidspunkt(gyldigTil);
						kortsystem.settInnReisekort(klippekortet);
						kortNrFelt.setText( "" + klippekortet.getKortNr() );
						betalingsFelt.setText( "" + innskudd + ",-");
						break;

			case DAG:	Dagskort dagskortet = new Dagskort();
						gyldigTil = Calendar.getInstance();
						gyldigTil.add( Calendar.DAY_OF_YEAR, 1 );
						dagskortet.setUtløpstidspunkt(gyldigTil);
						kortsystem.settInnReisekort(dagskortet);
						kortNrFelt.setText( "" + dagskortet.getKortNr() );
						betalingsFelt.setText( "" + dagskortet.getPris() + ",-");
						break;

			case MÅNED:	Maanedskort månedskortet = new Maanedskort();
						gyldigTil = Calendar.getInstance();
						gyldigTil.add( Calendar.MONTH, 1 );
						månedskortet.setUtløpstidspunkt(gyldigTil);
						kortsystem.settInnReisekort(månedskortet);
						kortNrFelt.setText( "" + månedskortet.getKortNr() );
						betalingsFelt.setText( "" + månedskortet.getPris() + ",-");
						break;
		}
	} //end of nyttReisekort(int type)

	public void ladOppKlippekort()
	{
		int nr = Integer.parseInt( kortNrFelt.getText() );
		int beløp = Integer.parseInt( beløpsFelt.getText() );

		Klippekort oppladetKort = kortsystem.ladOppKlippekort(nr, beløp);

		if (oppladetKort != null)
		{
			betalingsFelt.setText( "" + oppladetKort.getPris() );
			JOptionPane.showMessageDialog(null, "Ny saldo: " + oppladetKort.getSaldo() + ",-\n",
											"Saldo", JOptionPane.PLAIN_MESSAGE);
		}
		else
		{
			betalingsFelt.setText("error");
		}
	}

	private class Lytter implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == klippKnapp)
			{
				nyttReisekort(KLIPP);
			}
			else if (e.getSource() == dagKnapp)
			{
				nyttReisekort(DAG);
			}
			else if (e.getSource() == mnd)
			{
				nyttReisekort(MÅNED);
			}
			else if (e.getSource() == ladeknapp)
			{
				ladOppKlippekort();
			}
		}
	} //end of class Lytter

} // end of class Reisekortsalg