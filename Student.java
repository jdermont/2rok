import java.util.*;

public class Student implements Comparable<Student> {
	int nr;
	String imie;
	ArrayList<Integer> oceny;
	
	public Student(int nr, String imie) {
		this.nr = nr;
		this.imie = imie;
		oceny = new ArrayList<Integer>();
	}
	
	public boolean equals(Object o) {
		if (!(o instanceof Student)) return false;
		Student s = (Student)o;
		if (s.nr == nr) return true;
		else return false;
	}

	@Override
	public int compareTo(Student s) {
		return this.imie.compareTo(s.imie);
	}
}
