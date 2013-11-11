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