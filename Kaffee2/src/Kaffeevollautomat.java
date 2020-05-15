
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
		if (wasserMenge < 175 || bohnenMenge < 50) {
			System.out.println("leer");
			return 0;
		}
	
			
		wasserMenge = wasserMenge - 175;
		bohnenMenge = bohnenMenge - 50;
		return 175;
	}
	
	public void zeigeInhalte() {
		System.out.println("Wassermenge: " + wasserMenge 
				+ " Bohnenmenge: " + bohnenMenge);
	}
	
	@Override
	public String toString() {
		String s = "Wassermenge: " + wasserMenge + " Bohnenmenge: " + bohnenMenge;
		return s;
	}
}

