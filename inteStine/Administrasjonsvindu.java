import java.awt.*;
import java.awt.event.*;

public class Administrasjonsvindu extends JFrame implements ActionListener
{
	private JButton info;
	private JTextArea output;

	public Administrasjonsvindu(){
		
		super("ADMINISTRASJON");
		info = new JButton();
		output = new JTextArea();

		info.addActionListener( this );

		Container c = getContentPane();
		c.setLayout( new FlowLayout());
		c.add( info( "Salgsinfo" ) );
		c.add( output( 30, 60 ) );
	}

	public void actionPerformed( ActionEvent e ){
		if ( e.getSource() = info )
			output.setText( ReisekortSystem.inntjeningsInfo() );
	}
}

/*a) Programmer vindusklassen Administrasjonsvindu, slik at vinduet blir seende ut som på bildet. Klassen skal være sin egen lytteklasse og programmeres slik at når du klikker på knappen "Salgsinformasjon" blir den informasjonen som returneres fra inntjeningsInfo()-metoden i klassen ReisekortSystem vist i tekstområdet. */