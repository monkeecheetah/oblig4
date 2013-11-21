/*
Oblig 4 for 
Stine Marie Aas Grumheden s193467 og 
Kristoffer Johansen s193370
*/

public class RuterPluss {
	public static void main(String[] args) {
		ReisekortSystem k = new ReisekortSystem();
		Reisekortsalg salgsvindu = new Reisekortsalg(k);
		Kontrollvindu kontrollvindu = new Kontrollvindu(k);
		Administrasjonsvindu adminvindu = new Administrasjonsvindu();
	}
}