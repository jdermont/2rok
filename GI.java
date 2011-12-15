import java.awt.* ;
import java.awt.event.* ;
import javax.swing.*;

	public class GI extends JFrame{
		Label blad = new Label("");
	  JTextField stan  = new JTextField(20);
	  JTextField wplata  = new JTextField(20);
	  Button dodaj = new Button("Wpłać/Wypłać");
	  Button anuluj = new Button("Anuluj");
	  Konto konto = new Konto();
	  GI(){
	   setTitle("GI do Obliczen");
	   Container cp = getContentPane();
	   cp.setLayout(new GridLayout(4,2,20,20)) ;
	   cp.add(new Label("Stan konta:")) ;
	   cp.add(stan);
	   stan.setText(Integer.toString(konto.dajStan()));
	   cp.add(new Label("Wpłata/Wypłata:"));
	   cp.add(wplata);
	   cp.add(anuluj);


	   

	   dodaj.addActionListener(new Obl1L());
	   anuluj.addActionListener(new anuluj());
	   cp.add(dodaj) ;
	   cp.add(blad);
	   setDefaultCloseOperation(EXIT_ON_CLOSE);
	   setVisible(true) ;   
	  }
	  int dajLiczbe(JTextField tf){
		try{
	          return Integer.parseInt(tf.getText()) ;
	        } catch (NumberFormatException e){ return 0 ; }
	  }
	  class Obl1L implements ActionListener{
		   public void actionPerformed(ActionEvent e){
			   try {
				if (dajLiczbe(wplata) == 0) {
					blad.setText("Nic nie zrobiono.");
					return;
				}
				
				konto.operacja(dajLiczbe(wplata));
				if (dajLiczbe(wplata) < 0) {
					blad.setText("Wypłacono "+Math.abs(dajLiczbe(wplata)));
				} else {
					blad.setText("Wpłacono "+dajLiczbe(wplata));
				}
				stan.setText(Integer.toString(konto.dajStan()));
				
			} catch (DebetException e1) {
				blad.setText("Przekroczenie debetu! Nie wyplacono!");
			}

			  }
		   }
	  
	  class rezult implements ActionListener{
		   public void actionPerformed(ActionEvent e){
			   stan.setText(Integer.toString(konto.dajStan()));
			  }
		   }
	  
	  class anuluj implements ActionListener{
		   public void actionPerformed(ActionEvent e){
			try {
				konto.anuluj();
				blad.setText("Anulowano ostatnią operację");
			} catch (CancelException e1) {
				blad.setText("Brak operacji do anulowania!");
			}
			   stan.setText(Integer.toString(konto.dajStan()));
			  }
		   }
	}