import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Administrasjonsvindu extends JFrame implements ActionListener
{
	JButton salgsinfoKnapp;
	JTextArea utskrift;


	public Administrasjonsvindu()
	{
		super("ADMINISTRASJON");
		salgsinfoKnapp = new JButton("Salgsinformasjon");
		utskrift = new JTextArea(8, 15);
		utskrift.setEditable(false);

		salgsinfoKnapp.addActionListener(this);

		Container c = getContentPane();
		c.setLayout( new FlowLayout() );
		c.add(salgsinfoKnapp);
		c.add(utskrift);

		setSize(200, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed( ActionEvent e )
	{
		utskrift.setText( ReisekortSystem.inntjeningsInfo() );
	}

}