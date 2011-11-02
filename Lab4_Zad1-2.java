/* podstawowe klasy JDBC */
// wstawic odpowiednie: baza, login, haslo, tabela
// zmienic nazwe pliku na Zad1.java lub inna

import java.sql.*;

public class Zad1 {
    public static void main(String[] args){
	if (args.length < 1) {
	    System.out.println("Podaj rok!");
	    System.exit(0);
	}
	String url = "jdbc:postgresql://localhost/jkowalski";
	try {
	    Class.forName("org.postgresql.Driver");
	    Connection db = DriverManager.getConnection(url, "jkowalski","lubiekoty");

	    Statement st = db.createStatement();
	    ResultSet rs = st.executeQuery("SELECT * FROM postaci WHERE rok > "+args[0]);
	    System.out.println("Wpisy dla rok > "+args[0]+":\n");
	    System.out.println("Nazwisko\tRok\t\tPensja:");
	    while (rs.next()) {
		System.out.println(rs.getString(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3));
	    }
	    try {
		st.executeQuery("UPDATE postaci SET kwota=kwota-100 WHERE rok > "+args[0]);
	    } catch (Exception e) {}
	    rs = st.executeQuery("SELECT * FROM postaci WHERE rok > "+args[0]);
	    System.out.println("\nWpisy dla rok > "+args[0]+" (po zmniejszeniu kwoty o 100):\n");
	    System.out.println("Nazwisko\tRok\t\tPensja:");
	    while (rs.next()) {
		System.out.println(rs.getString(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3));
	    }
	    rs.close();
	    st.close();

	} catch (SQLException e) {
	    System.err.println("Wyjatek z zapytania SQL: " + e.getMessage());
	    e.printStackTrace(System.err);
	} catch (ClassNotFoundException e) {
	    System.err.println("Wyjatek przy ladowaniu klas: " + e.getMessage());
	    e.printStackTrace(System.err);
	}

    }
}
