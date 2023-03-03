package program;

import java.util.List;
import java.util.Scanner;


import database.TietokonepelitDAO;
import database.TietokonepelitJdbcDao;

import model.Tietokonepeli;

public class TietokonepeliKokeiluOhjelma {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Tietokonepelisovellus");
		int valinta = -1;
		while (valinta != 0) {
			System.out.print("\n 1 Listaa pelit \n 2 Lisää peli \n 3 Poista peli \n 4 Hae peli \n 5 Muuta peliä \n 0 Lopeta");
			System.out.print("\n Syötä valintasi: ");
			valinta = input.nextInt();
			input.nextLine(); // syöttöpuskurin tyhjennys, rivinvaihtomerkin lukeminen erikseen

			if (valinta == 1) {
				System.out.println("Listaa pelit");
			} else if (valinta == 2) {
				System.out.println("Lisää peli");
			} else if (valinta == 3) {
				System.out.println("Poista peli");
			} else if (valinta == 4) {
				haePeli();
			} else if (valinta == 5) {
				System.out.println("Muuta peliä");
			} else if (valinta == 0) {
				System.out.println("Kiitos ja näkemiin!");
			} else {
				System.out.println("Virheellinen valinta. Valitse uudelleen!");
			}
		}
		input.close();

	}
	
	private static void haePeli() {
		
		Scanner input = new Scanner(System.in);

		TietokonepelitDAO pelidao = new TietokonepelitJdbcDao();
		System.out.println("Syötä Id: ");
		int valinta = input.nextInt();
		
		
		System.out.println("\nPeli: ");

		Tietokonepeli peli = pelidao.findById(valinta);
	
		System.out.print(" " + peli);
		
	}


}
