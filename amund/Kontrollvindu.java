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
        c.add(new JLabel("Reisekortnr:");
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

        if ( kortet =! null)
        {
            if ( kortet.gyldig() )
            {
                if (kortet instanceof Klippekort)

                

            }
            else
            {
                display.setText( "\n\n\nKortet er ikke gyldig");
            }



            if (kortet instanceof Klippekort)
            {
                Klippekort klippekortet = (Klippekort) kortet;
                display.setText( "\n\n\nBetalt kr. " + klippekortet.getPris() + ",-" +
                                    "Saldo: kr. " + klippekortet.getSaldo() + ",-" +
                                    "Gyldig til " + klippekortet.getUtløpstidspunkt() );
            }
            else if (kortet instanceof Dagskort)
            {
                display.setText( "\n\n\nDagskort\nGyldig til " + kortet.getUtløpstidspunkt() );
                
            }
            else if (kortet instanceof Maanedskort)
            {
                display.setText( "\n\n\nMånedkort\nGyldig til " + kortet.getUtløpstidspunkt() );
            }


        }
        else
        {
            display.setText("\n\n\nReisekortet er ukjent.");
        }


        < Metoden må lese inn kortets nummer og sjekke om det finnes
        blandt de registrerte kortene. Hvis det finnes og det er gyldig,
        skal følgende gjøre:

        - Hvis det er et klippekort, skal prisen for en reise trekkes fra
        saldoen på kortet. Deretter skal det skrives ut i tekstområde hva
        reisen koster, hva som er saldoen etter at reisen er betalt og hvor
        lenge billetten varer.

        - Hvis det er et dagskort eller et månedskort skal det kun skrives ut
        hvor lenge billetten varer.

        Hvis kortet er ugyldig, skal dette skrives i tekstområdet.
        For klippekort skal i tillegg saldoen skrives ut.

        Hvis kortet er ukjent, skal dette skrives i tekstområdet.>
    }

    private class Lytteklasse implements ActionListener
    {

    }

}  // end of class Kontrollvindu