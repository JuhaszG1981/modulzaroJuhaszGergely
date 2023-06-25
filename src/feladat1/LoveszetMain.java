package feladat1;

import java.util.ArrayList;
import java.util.List;

public class LoveszetMain {

	public static void main(String[] args) {
		
		List<Versenyzo> versenzok = new ArrayList<Versenyzo>();
		
		versenzok.add(new Versenyzo("Franciska", "v0001", 467));
		versenzok.add(new Versenyzo("Tibor", "v0002", 486));
		versenzok.add(new Versenyzo("Zsolt", "v0003", 478));
		versenzok.add(new Versenyzo("Erika", "v0004", 481));
		versenzok.add(new Versenyzo("Lajos", "v0005", 472));

		for (int i = 0; i < 5; i++) {
			for (Versenyzo versenyzo : versenzok) {
				
				int loves = versenyzo.loves();
				versenyzo.setLovesek(("Lövés"+(i+1)), loves);
				System.out.println((i+1)+" kör");
				System.out.println(versenyzo.getNev() + "\naktuális lövés: " + loves + "\nEddigi összpontszám: " + (versenyzo.getAktualisOsszPontszam()+loves));
				System.out.println(versenyzo.rekordEllenorzes(i+1));
				System.out.println("Aktuális rekord: " + versenyzo.getRekord());
				System.out.println();
				
			}
			
		}
		
		
	}

}
