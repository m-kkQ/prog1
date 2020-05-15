
public class Kaffeevollautomat {
	// Eigenschaften oder Felder oder Attribute
	// sind synonyme 
	private int wasserMenge;
	private int bohnenMenge;
	
	public void befuelleWasser(int wasser) {
		wasserMenge = wasserMenge + wasser;
		
	}
	
	public void befuelleBohnen(int bohnen) {
		bohnenMenge = bohnenMenge + bohnen;
	}
	
	public int kocheKaffe() {
		wasserMenge = wasserMenge - 175;
		bohnenMenge = bohnenMenge - 50;
		return 175;
	}
	
	public void zeigeInhalte() {
		System.out.println("Wassermenge: " + wasserMenge + " Bohnenmenge: " + bohnenMenge);
	}
}

