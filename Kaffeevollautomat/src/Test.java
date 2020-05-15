
public class Test {

	public static void main(String[] args) {

		Kaffeevollautomat jura1731 = new Kaffeevollautomat();
		Kaffeevollautomat saecco13cz = new Kaffeevollautomat();
		
		jura1731.zeigeInhalte();
		
		jura1731.befuelleBohnen(500);
		jura1731.befuelleWasser(900);
		jura1731.zeigeInhalte();

		int tasse = jura1731.kocheKaffe();
		
		System.out.println("Eine leckere Tasse Kaffee: " + tasse);
		jura1731.zeigeInhalte();
		saecco13cz.zeigeInhalte();
	}

	
}
