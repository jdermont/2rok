public class Lab5 {
	public static void main(String[] args) {
		Ulamek a = new Ulamek(2,3);
		a.mnozPrzez(6);
		Ulamek b = new Ulamek(1,5);
		b.mnozPrzez(a);
		Ulamek c = Ulamek.razy(a,b);
		System.out.println("a = "+a.toString());
		System.out.println("b = "+b.toString());
		System.out.println("a razy b = "+c.toString());
	}

}
