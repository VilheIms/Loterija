package steks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class Uzd2 {

	public static void main(String[] args) {
		Stack<Integer> LoterijasBumbas = new Stack<>();
		Stack<Integer> UzvarasBumbas = new Stack<>();
		Random rand = new Random();
		String izvele;
		Long Pauze = (long) 60000;
		Long Darbiba = (long) 0;
		ArrayList<Integer> uzvara = new ArrayList<Integer>();
		int laime, laimiga = 0, skaits = 0;
		String[] darbibas = {"Ģenerēt bumbiņas", "Apskatīt laimīgās bumbiņas", "Apturēt"};
		do {
			izvele = (String)JOptionPane.showInputDialog(null, "Izvēlies darbību", "Darbību saraksts", JOptionPane.QUESTION_MESSAGE, null, darbibas, darbibas[0]);
			if(izvele == null)
				izvele = "Apturēt";
		switch(izvele) {
		case "Ģenerēt bumbiņas":
			
			long now1 = System.currentTimeMillis();
			
			
			System.out.println(now1 - Darbiba);
			if(now1 - Darbiba < Pauze) {
				long palikusais = (Pauze - (now1 - Darbiba)) / 1000;
		        JOptionPane.showMessageDialog(null,
		                "Darbību var darīt tikai reizi minūtē!\nPalikušas: " + palikusais + " sekundes");
		        break;
			}else {
			
			LocalDateTime IzmetBumbinas = LocalDateTime.now();
		    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		    String Datums = IzmetBumbinas.format(myFormatObj);
			
				for(int i = 0; i < 3; i++) {
					for(int j = 0; j<10; j++) {
					laime = rand.nextInt(9);
					
					LoterijasBumbas.push(laime);
					}
				laimiga = LoterijasBumbas.pop();
				LoterijasBumbas.clear();
				UzvarasBumbas.push(laimiga);
				
				}
				JOptionPane.showMessageDialog(null, "Laimīgās bumbiņas: "+UzvarasBumbas+", Ģenerētais laiks: "+Datums, "Paziņojums", JOptionPane.INFORMATION_MESSAGE);
				uzvara.addAll(UzvarasBumbas);
				skaits += 1;
				UzvarasBumbas.clear();
				Darbiba = now1;
			}
				break;
		case "Apskatīt laimīgās bumbiņas":
			if(!uzvara.isEmpty())
				for(int i = 0; i < skaits; i++) {
				JOptionPane.showMessageDialog(null, "Laimīgo bumbiņu numuri:"+uzvara.get(i)+" | "+uzvara.get(i+1)+" | "+uzvara.get(i+2), "Paziņojums", JOptionPane.INFORMATION_MESSAGE);
				}
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
