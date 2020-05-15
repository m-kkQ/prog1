
public class Test {

	public static void main(String[] args) {
		pervers();
	}

	
	public static boolean even(int i) {
		if (i % 2 == 0)
			return true;
		return false;
	}
	
	
	public static void pervers() {
//		for (Kaffeevollautomat jura = new Kaffeevollautomat(),
//				saecco = new Kaffeevollautomat(),
//				philipps = new Kaffeevollautomat();
//				even(jura.kocheKaffe());
//				zweiterTest(),
//				ersterTest(),
//				saecco.befuelleWasser(200)) {			
//			//Rumpf
//		}
		
		int[] iArray = new int[5]; 
		for (int i = 0; i < iArray.length; iArray[i] = 2*i, i++)
				;
		for (int i = 0; i < iArray.length; System.out.println(iArray[i]), i++);
	}
	
	
	
	
	public static void dritterTest() {
		Kaffeevollautomat[] maschinen = new Kaffeevollautomat[10];
		maschinen[0] = new Kaffeevollautomat();
		maschinen[0].befuelleBohnen(300);
		maschinen[1] = new Kaffeevollautomat();
		maschinen[1].befuelleWasser(800);
		
	
		
		for (int i = 0; i < maschinen.length; i++) {
			System.out.println(maschinen[i]);
	}
	
		for(int i = 0; i < maschinen.length; i++) {
			if (maschinen[i] != null)
				maschinen[i].kocheKaffe();
	}
}
			
			
			
			
	public static void zweiterTest() {
		int[] intArray = new int[7]; 
		
//		System.out.println(intArray.length);
		
		intArray[0] = 17;
		intArray[1] = 9;
		
		for (int i = 0; i < intArray.length; i++) {
			System.out.println(intArray[i]);
		}
		
	}
	
	public static void ersterTest() {	
		Kaffeevollautomat jura1731 = new Kaffeevollautomat();
		//Kaffeevollautomat saecco13cz = new Kaffeevollautomat();
		
		jura1731.zeigeInhalte();
		
		jura1731.befuelleBohnen(500);
		jura1731.befuelleWasser(900);
		jura1731.zeigeInhalte();

		int tasse = jura1731.kocheKaffe();
		
		System.out.println("Eine leckere Tasse Kaffee: " + tasse);
		jura1731.zeigeInhalte();
//		saecco13cz.zeigeInhalte();
		
		
		tasse = jura1731.kocheKaffe();
		tasse = jura1731.kocheKaffe();
		tasse = jura1731.kocheKaffe();
		tasse = jura1731.kocheKaffe();
		tasse = jura1731.kocheKaffe();
		System.out.println("Eine leckere Tasse Kaffee: " + tasse);
		jura1731.zeigeInhalte();
		
		System.out.println(jura1731.toString());
	}
}
