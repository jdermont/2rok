import java.awt.* ;
import java.awt.event.* ;
import javax.swing.*;

class Przyciski extends JFrame{
	int ilosc = 0;
	int zolte = 0;
  JTextField t = new JTextField(20);
  JButton b1 = new JButton("przycisk 1") ;
  JButton b2 = new JButton("przycisk 2") ;
  JButton b3 = new JButton("przycisk 3") ;
  JButton b4 = new JButton("przycisk 4") ;
  JButton b5 = new JButton("zeruj") ;

  Przyciski(){
    setTitle("Przyciski");
    Container cp = getContentPane();
    cp.setLayout(new FlowLayout()) ;
    cp.add(b1) ;
    cp.add(b2) ;
    cp.add(b3) ;
    cp.add(b4) ;
    cp.add(t) ;
    cp.add(b5);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(500,200) ;
    setVisible(true) ; 
    ActionListener dolicz = new dolicz();
    b1.addActionListener( new B1());
    b1.addActionListener( dolicz );
    b2.addActionListener( new B2() );
    b2.addActionListener( dolicz );
    b3.addActionListener( new B3() );
    b3.addActionListener( dolicz );
    b4.addActionListener( new B4() );
    b4.addActionListener( dolicz );
    b5.addActionListener( new B5() );
    b1.setBackground(Color.blue);
    b2.setBackground(Color.blue);
    b3.setBackground(Color.blue);
    b4.setBackground(Color.blue);
    t.setText(Integer.toString(ilosc));
  }
  
  public void enabluj() {
	  b1.setEnabled(true);
	  b2.setEnabled(true);
	  b3.setEnabled(true);
	  b4.setEnabled(true);
  }
  
  public void disabluj() {
	  if (b1.getBackground() == Color.blue) b1.setEnabled(false);
	  if (b2.getBackground() == Color.blue) b2.setEnabled(false);
	  if (b3.getBackground() == Color.blue) b3.setEnabled(false);
	  if (b4.getBackground() == Color.blue) b4.setEnabled(false);
  }
  
  class dolicz implements ActionListener {
	  public void actionPerformed(ActionEvent e) {
		  ilosc++;
		  t.setText(Integer.toString(ilosc));
	  }
	}
  
  class B1 implements ActionListener {
	  public void actionPerformed(ActionEvent e) {
		  if (b1.getBackground() == Color.yellow) {
			  b1.setBackground(Color.blue);
			  zolte--;
			  enabluj();
		  } else {
			  b1.setBackground(Color.yellow);
			  zolte++;
			  if (zolte == 3) disabluj();
		  }
	  }
	}
  
  class B2 implements ActionListener {
	  public void actionPerformed(ActionEvent e) {
		  if (b2.getBackground() == Color.yellow) {
			  b2.setBackground(Color.blue);
			  zolte--;
			  enabluj();
		  } else {
			  b2.setBackground(Color.yellow);
			  zolte++;
			  if (zolte == 3) disabluj();
		  }
	  }
	}
  
  class B3 implements ActionListener {
	  public void actionPerformed(ActionEvent e) {
		  if (b3.getBackground() == Color.yellow) {
			  b3.setBackground(Color.blue);
			  zolte--;
			  enabluj();
		  } else {
			  b3.setBackground(Color.yellow);
			  zolte++;
			  if (zolte == 3) disabluj();
		  }
	  }
	}
  
  class B4 implements ActionListener {
	  public void actionPerformed(ActionEvent e) {
		  if (b4.getBackground() == Color.yellow) {
			  b4.setBackground(Color.blue);
			  zolte--;
			  enabluj();
		  } else {
			  b4.setBackground(Color.yellow);
			  zolte++;
			  if (zolte == 3) disabluj();
		  }
	  }
	}
  
  class B5 implements ActionListener {
	  public void actionPerformed(ActionEvent e) {
		 ilosc = 0;
		 t.setText(Integer.toString(ilosc));
	}
  }

  public static void main(String[] arg){
    JFrame f = new Przyciski() ;
  }
}