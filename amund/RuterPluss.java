//Student: Amund Ring, Studentnr: 193379, Klasse: HINGDATA13H1AA

public class RuterPluss
{
	public static void main(String[] args)
	{
		ReisekortSystem kortsystem = new ReisekortSystem();

		Reisekortsalg salgsvindu = new Reisekortsalg(kortsystem);

		Kontrollvindu kontrollvindu = new Kontrollvindu(kortsystem);

		Administrasjonsvindu adminvindu = new Administrasjonsvindu();
	}
}