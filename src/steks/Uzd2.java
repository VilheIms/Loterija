package steks;

import java.util.Random;
import java.util.Stack;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

public class Uzd2 {

	public static void main(String[] args) {
		Stack<Integer> LoterijasBumbas = new Stack<>();
		Stack<Integer> UzvarasBumbas = new Stack<>();
		Random rand = new Random();
		Timer timer = new Timer();
		String izvele;
		
		
		
		
		
		int bumbinas, laime, laimiga = 0, laiks = 0;
		String[] darbibas = {"Ģenerēt bumbiņas", "Apskatīt laimīgās bumbiņas", "Apturēt"};
		do {
			izvele = (String)JOptionPane.showInputDialog(null, "Izvēlies darbību", "Darbību saraksts", JOptionPane.QUESTION_MESSAGE, null, darbibas, darbibas[0]);
		switch(izvele) {
		case "Ģenerēt bumbiņas":
			if(laiks != 0) {
				System.out.println("Nav vēl laiks beidzies! Atlikušais laiks: "+laiks);
				break;
			}else {
				for(int i = 0; i < 3; i++) {
					for(int j = 0; j<10; j++) {
					laime = rand.nextInt(9);
					LoterijasBumbas.push(laime);
					}
				laimiga = LoterijasBumbas.pop();
				LoterijasBumbas.clear();
				UzvarasBumbas.push(laimiga);
				}
				JOptionPane.showMessageDialog(null, "Laimīgās bumbiņas: "+UzvarasBumbas, "Paziņojums", JOptionPane.INFORMATION_MESSAGE);
				UzvarasBumbas.clear();
				try {
					Thread.sleep(60000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
				break;
		case "Apskatīt laimīgās bumbiņas":
			if(!LoterijasBumbas.isEmpty())
				JOptionPane.showMessageDialog(null, "Stekā esošā vārda garums:"+LoterijasBumbas.size(), "Paziņojums", JOptionPane.INFORMATION_MESSAGE);
			else
				JOptionPane.showMessageDialog(null, "Nav laimīgās bumbiņas!", "Paziņojums", JOptionPane.INFORMATION_MESSAGE);
			break;
		case "Apturēt":
			JOptionPane.showMessageDialog(null, "Programma apturēta!", "Informācija", JOptionPane.INFORMATION_MESSAGE);
			break;
		}
		}while(!izvele.equals("Apturēt"));
	}

}
