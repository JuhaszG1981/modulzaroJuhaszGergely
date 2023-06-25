package feladat1;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Versenyzo implements ILovesEsEllenorzes {
	
	private String nev;
	private String azonosito;
	private double rekord;
	private Map<String,Integer> lovesek = new HashMap<String,Integer>();
	private int aktualisOsszPontszam = 0;
	public Versenyzo(String nev, String azonosito, double rekord) {
		this.nev = nev;
		this.azonosito = azonosito;
		this.rekord = rekord;
	}
	
	
	
	public double getRekord() {
		return rekord;
	}



	public int getAktualisOsszPontszam() {
		return aktualisOsszPontszam;
	}

	public String getNev() {
		return nev;
	}

	public void setLovesek(String hanyadikLoves, int lovesPontszam) {
		lovesek.put(hanyadikLoves, lovesPontszam);
	}
	
	@Override
	public int loves() {
		int egyLoves;
		Random r = new Random();
		egyLoves = r.nextInt(80,101);
		return egyLoves;
	}
	@Override
	public String rekordEllenorzes(int lovesKor) {
		
		aktualisOsszPontszam = 0;
		for(Map.Entry<String, Integer> loves : lovesek.entrySet()) {
			aktualisOsszPontszam += loves.getValue();
		}
		
		if ((rekord < aktualisOsszPontszam+((5-lovesKor)*100)) && lovesKor != 5 && aktualisOsszPontszam<=rekord) {
				return  "még dönthet rekordot";
		} else if (aktualisOsszPontszam>rekord){
				rekord = aktualisOsszPontszam;
				return "Új egyéni rekord";	
		} else {
			return  "Már nem dönthet rekordot maximális pontszámmal sem!";
		}
		
		
	}
	
	

}
