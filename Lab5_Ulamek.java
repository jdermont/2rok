// zmienic nazwe pliku na Ulamek.java

public class Ulamek {
	int licznik;
	int mianownik;
	
	public Ulamek(int licz,int mian) {
		licznik = licz;
		mianownik = mian;
	}
	
	public void mnozPrzez(Ulamek v) {
		licznik *= v.licznik;
		mianownik *= v.mianownik;
	}
	
	public void mnozPrzez(int i) {
		licznik = licznik * i;
	}
	
	public static Ulamek razy(Ulamek u, Ulamek v) {
		Ulamek nowy = new Ulamek(u.licznik,u.mianownik);
		nowy.mnozPrzez(v);
		return nowy;
	}
	
	public String toString() {
		String text = Integer.toString(licznik)+"/"+Integer.toString(mianownik);
		return text;
	}
}
