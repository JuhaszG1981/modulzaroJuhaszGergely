package feladat2;

public class Ingatlan {
	
	private String tulajdonos;
	private String hrsz;
	private int alapterulet;
	private int ar;
	public Ingatlan(String tulajdonos, String hrsz, int alapterulet, int ar) {
		this.tulajdonos = tulajdonos;
		this.hrsz = hrsz;
		this.alapterulet = alapterulet;
		this.ar = ar;
	}
	public String getTulajdonos() {
		return tulajdonos;
	}
	public void setTulajdonos(String tulajdonos) {
		this.tulajdonos = tulajdonos;
	}
	public String getHrsz() {
		return hrsz;
	}
	public void setHrsz(String hrsz) {
		this.hrsz = hrsz;
	}
	public int getAlapterulet() {
		return alapterulet;
	}
	public void setAlapterulet(int alapterulet) {
		this.alapterulet = alapterulet;
	}
	public int getAr() {
		return ar;
	}
	public void setAr(int ar) {
		this.ar = ar;
	}
	@Override
	public String toString() {
		return tulajdonos + " " + hrsz + " " + alapterulet + " " + ar
				+ "Ft";
	}
	
	

}
