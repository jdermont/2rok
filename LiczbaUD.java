// zmienic w Ulamek private na protected
public class LiczbaUD extends Ulamek {
	private int calosc;
	
	public LiczbaUD(int c,int l, int m) {
		super(l,m);
		this.calosc = c;
	}
	
	public void mnozPrzez(LiczbaUD l) {
		int licz = calosc*this.mianownik+this.licznik;
		int licz2 = l.getCalosc()*l.getMianownik()+l.getLicznik();
		licz *= licz2;
		int mian = this.mianownik*l.getMianownik();
		this.calosc = licz/mian;
		this.licznik = licz%mian;
		this.mianownik = mian;
	}
	
	public void mnozPrzez(int i) {
		int licz = calosc*this.mianownik+this.licznik;
		licz *= i;
		this.calosc = licz/this.mianownik;
		this.licznik = licz%this.mianownik;
		
	}
	
	public void mnozPrzez(Ulamek u) {
		int licz = calosc*this.mianownik+this.licznik;
		licz *= u.getLicznik();
		Ulamek x = Ulamek.razy(new Ulamek(this.licznik,this.mianownik), u);
		licznik = x.getLicznik();
		mianownik = x.getMianownik();
		this.calosc = licz/this.mianownik;
		this.licznik = licz%this.mianownik;
	}
	
	public int getCalosc() {
		return this.calosc;
	}
	
	public String toString() {
		return this.calosc+" "+super.toString();
	}

}
