import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Kontrollvindu extends JFrame
{
    private JTextField kortIdFelt;
    private JTextArea display;
    private JButton kontroll;
    private ReisekortSystem kortsystem;

    public Kontrollvindu(ReisekortSystem r)
    {
        super("BILLETT-KONTROLL");
        kortIdFelt = new JTextField(6);
        display = new JTextArea(40, 20);
        kontroll = new JButton("Billett-kontroll");
        kortsystem = r;

        Lytteklasse lytter = new Lytteklasse();
        kontroll.addActionListener(lytter);

        Container c = getContentPane();
        c.setLayout( new FlowLayout() );
        c.add( new JLabel("Reisekortnr:") );
        c.add(kortIdFelt);
        c.add(kontroll);
        c.add(display);

        setSize(100, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void kontrollerReisekort()
    {
        int nr = Integer.parseInt( kortIdFelt.getText() );

        Reisekort kortet = kortsystem.finnReisekort(nr);

        if ( kortet != null)
        {
            
            if (kortet instanceof Klippekort)
            {
                Klippekort klippekortet = (Klippekort) kortet;

                if ( klippekortet.gyldig() )
                {
                    display.setText( "\n\n\nBetalt kr. " + klippekortet.getPris() + ",-\n" +
                                        "Saldo: kr. " + klippekortet.getSaldo() + ",-\n" +
                                        "Gyldig til " + klippekortet.getUtløpstidspunkt() );
                }
                else
                {
                    display.setText( "\n\n\nKortet er ikke gyldig\n" +
                                    "Saldo: kr. " + klippekortet.getSaldo() + ",-");
                }
            }
            else if (kortet instanceof Dagskort)
            {
                Dagskort dagskortet = (Dagskort) kortet;

                if ( dagskortet.gyldig() )
                {
                    display.setText( "Gyldig til " + dagskortet.getUtløpstidspunkt() );
                }
                else
                {
                    display.setText( "\n\n\nKortet er ikke gyldig");
                }
            }
            else if (kortet instanceof Maanedskort)
            {
                Maanedskort maanedskortet = (Maanedskort) kortet;

                if ( maanedskortet.gyldig() )
                {
                    display.setText( "Gyldig til " + maanedskortet.getUtløpstidspunkt() );
                }
                else
                {
                    display.setText( "\n\n\nKortet er ikke gyldig");
                }
            }
        }
        else
        {
            display.setText("\n\n\nReisekortet er ukjent.");
        }

    } //end of kontrollerReisekort()


    private class Lytteklasse implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            kontrollerReisekort();
        }

    }

}  // end of class Kontrollvindu