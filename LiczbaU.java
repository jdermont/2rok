public class LiczbaU {
	private int calosc;
	private Ulamek czescU;
	
	public LiczbaU(int cal,int licz,int mian) {
		this.calosc = cal;
		this.czescU = new Ulamek(licz,mian);
	}
	
	public LiczbaU(int cal,Ulamek cz) {
		this.calosc = cal;
		this.czescU = cz;
	}
	
	public void mnozPrzez(LiczbaU l) {
		int licz = calosc*this.czescU.getMianownik()+this.czescU.getLicznik();
		int licz2 = l.getCalosc()*l.getCzescU().getMianownik()+l.getCzescU().getLicznik();
		licz *= licz2;
		int mian = this.czescU.getMianownik()*l.getCzescU().getMianownik();
		this.calosc = licz/mian;
		this.czescU.setLicznik(licz%mian);
		this.czescU.setMianownik(mian);
	}
	
	public void mnozPrzez(int i) {
		int licz = calosc*this.czescU.getMianownik()+this.czescU.getLicznik();
		licz *= i;
		this.calosc = licz/this.czescU.getMianownik();
		this.czescU.setLicznik(licz%this.czescU.getMianownik());
		
	}
	
	public void mnozPrzez(Ulamek u) {
		int licz = calosc*this.czescU.getMianownik()+this.czescU.getLicznik();
		licz *= u.getLicznik();
		this.czescU = Ulamek.razy(this.czescU, u);
		this.calosc = licz/this.czescU.getMianownik();
		this.czescU.setLicznik(licz%this.czescU.getMianownik());
	}
	
	public int getCalosc() {
		return this.calosc;
	}
	
	public void setCalosc(int cal) {
		this.calosc = cal;
	}
	
	public Ulamek getCzescU() {
		return this.czescU;
	}
	
	public void setCzescU(Ulamek cz) {
		this.czescU = cz;
	}
	
	public String toString() {
		return this.calosc+" "+this.czescU.toString();
	}
}
