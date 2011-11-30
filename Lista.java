
public class Lista {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WykazS ws = new WykazS();
		ws.wstawStudenta(199200,"Kazik");
		ws.wstawStudenta(199201,"Kazik");
		ws.wstawStudenta(199204,"Nikodem");
		ws.wstawStudenta(199205,"Jan");
		ws.wstawStudenta(189557,"Wiesiek");
		
		ws.wstawOcene(199200,5);
		ws.wstawOcene(199200,4);
		ws.wstawOcene(199200,3);
		ws.wstawOcene(199200,5);
		ws.wstawOcene(199200,2);
		ws.wstawOcene(199201,5);
		ws.wstawOcene(199201,6);
		ws.wstawOcene(199204,4);
		ws.wstawOcene(199204,5);
		ws.wstawOcene(199201,4);
		ws.wstawOcene(199205,3);
		ws.wstawOcene(199205,2);
		ws.wstawOcene(189557,6);
		
		System.out.println("Lista:");
		ws.wypisz();
		ws.sortujA();
		System.out.println("\nLista sortujA():");
		ws.wypisz();
		ws.sortujM();
		System.out.println("\nLista sortujM():");
		ws.wypisz();
		//ws.wypisz(199200);
	}
}
