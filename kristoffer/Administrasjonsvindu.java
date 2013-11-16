import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Administrasjonsvindu extends JFrame implements ActionListener {
	
	private JButton salgsInfo;
	private JTextArea tekstFelt;

	public Administrasjonsvindu() {
		super("Administrasjonsvindu");
		salgsInfo = new JButton("Salgsinformasjon");
		salgsInfo.addActionListener(this);
		tekstFelt = new JTextArea(10, 30);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(salgsInfo);
		c.add(new JScrollPane(tekstFelt));
	}

	private void visInfo() {
		tekstFelt.setText(ReisekortSystem.inntjeningsInfo());

	} 

   public void actionPerformed(ActionEvent e)
   {
     if (e.getSource() == salgsInfo)
       visInfo();
	}



}

// a) Programmer vindusklassen Administrasjonsvindu, slik at vinduet blir seende ut som på bildet. Klassen skal være sin egen lytteklasse og programmeres slik at når du klikker på knappen "Salgsinformasjon" blir den informasjonen som returneres fra inntjeningsInfo()-metoden i klassen ReisekortSystem vist i tekstområdet. 