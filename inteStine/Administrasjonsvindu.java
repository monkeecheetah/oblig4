import java.awt.*;
import java.awt.event.*;

public class Administrasjon extends JFrame implements ActionListender
{
	private JButton info;
	private JTextArea output;

	public Administrasjon{
		
		super("ADMINISTRASJON");
		info = new JButton();
		output = new JTextArea();

		info.addActionListener( this );

		Container c = getContentPane();
		c.setLayout( new FlowLayout());
		c.add info("Salgsinfo");
		c.add output( 30, 60 );
	}

	public void actionPerformed( ActionEvent e ){
		e.getSource() = info
			ReisekortSystem.inntjeningsInfo();
	}
}

/*a) Programmer vindusklassen Administrasjonsvindu, slik at vinduet blir seende ut som på bildet. Klassen skal være sin egen lytteklasse og programmeres slik at når du klikker på knappen "Salgsinformasjon" blir den informasjonen som returneres fra inntjeningsInfo()-metoden i klassen ReisekortSystem vist i tekstområdet. */