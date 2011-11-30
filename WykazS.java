import java.util.*;

class Porownaj implements Comparator<Student> {
	@Override
	public int compare(Student s1, Student s2) {
		int i;
		int max1 = 0;
		for (i=0;i<s1.oceny.size();i++) {
			if (s1.oceny.get(i) > max1) max1 = s1.oceny.get(i);
		}
		int max2 = 0;
		for (i=0;i<s2.oceny.size();i++) {
			if (s2.oceny.get(i) > max2) max2 = s2.oceny.get(i);
		}
		if (max1 >= max2) return -1;
		else return 1;
	}
	
}

public class WykazS {
	ArrayList<Student> lista;
	
	public WykazS() {
		lista = new ArrayList<Student>();
	}
	
	public void wstawStudenta(int nr,String imie) {
		lista.add(new Student(nr,imie));
	}
	
	public void wstawOcene(int nr, int ocena) {
		int i = lista.indexOf(new Student(nr,""));
		Student s = lista.get(i);
		s.oceny.add(ocena);
	}
	
	public void wypisz(int nr) {
		int i = lista.indexOf(new Student(nr,""));
		String text = "";
		Student s = lista.get(i);
		text += Integer.toString(s.nr)+" "+s.imie;
		for (i=0;i<s.oceny.size();i++) {
			text += " "+Integer.toString(s.oceny.get(i));
		}
		System.out.println(text);
	}
	
	public void wypisz() {
		String text;
		Student s;
		int i,j;
		for (i=0;i<lista.size();i++) {
			text = "";
			s = lista.get(i);
			text += Integer.toString(s.nr)+" "+s.imie;
			for (j=0;j<s.oceny.size();j++) {
				text += " "+Integer.toString(s.oceny.get(j));
			}
			System.out.println(text);
		}
	}
	
	public void sortujA() {
		Collections.sort(lista);
	}
	
	public void sortujM() {
		Collections.sort(lista, new Porownaj());
	}

}
