package steks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class Uzd2 {

	public static void main(String[] args) {
		Stack<Integer> LoterijasBumbas = new Stack<>();
		Random rand = new Random();
		String izvele;
		int bumbinas, laime, laimiga = 0;
		String[] darbibas = {"Ģenerēt bumbiņas", "Apskatīt laimīgās bumbiņas", "Apturēt"};
		do {
			izvele = (String)JOptionPane.showInputDialog(null, "Izvēlies darbību", "Darbību saraksts", JOptionPane.QUESTION_MESSAGE, null, darbibas, darbibas[0]);
		switch(izvele) {
		case "Ģenerēt bumbiņas":
				for(int i = 0; i < 4; i++) {
				for(i = 0; i<10; i++) {
					laime = rand.nextInt(9);
					LoterijasBumbas.push(laime);
					}
				laimiga = LoterijasBumbas.pop();
				LoterijasBumbas.clear();
				}
				System.out.println(laimiga);
				break;
		case "Apskatīt laimīgās bumbiņas":
			if(!LoterijasBumbas.isEmpty())
				JOptionPane.showMessageDialog(null, "Stekā esošā vārda garums:"+LoterijasBumbas.size(), "Paziņojums", JOptionPane.INFORMATION_MESSAGE);
			else
				JOptionPane.showMessageDialog(null, "Steks ir tukšs!", "Paziņojums", JOptionPane.INFORMATION_MESSAGE);
			break;
		case "Apturēt":
			JOptionPane.showMessageDialog(null, "Programma apturēta!", "Informācija", JOptionPane.INFORMATION_MESSAGE);
			break;
		}
		}while(!izvele.equals("Apturēt"));
	}

}
