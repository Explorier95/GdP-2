package verzeichnisbehandlung;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TestKlasse {
	/**
	 * EA DUD-E3 Mainklasse - Programm zur erstellung von Verzeichnisstrukturen mit
	 * Kopier- und Informationsfunktionen
	 * 
	 * @author Fabian Tappendorf - 357737
	 * @contact fabian.tappendorf@stud.th-luebeck.de
	 * @date 23/11/22
	 *
	 */

	public static void main(String[] args) {

		File quellF;
		File zielF;

		VerzErst erstellung = new VerzErst("Dateimanagement", "HTML", "Dokumente", "Graphik", "Java");
		erstellung.erstelleVerzeichnis();

		Scanner tastartur = new Scanner(System.in);
		System.out.println("\nBitte gebe das Verzeichnis an worin sich die Datei befindet:\n ");
		String quell = tastartur.next();
		quellF = new File(quell);
		System.out.println("\nBitte gebe das Verzeichnis mit namen der neuen Datei + Dateikuerzel an:\n ");
		String ziel = tastartur.next();
		zielF = new File(ziel);

		DatKop kopierung = new DatKop();

		try {
			kopierung.kopiereDatei(quellF, zielF);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Leider wurde einer der Pfade für die Kopierung nicht gefunde.");
		}

		System.out.println("\nBitte gebe das Verzeichnis an worin sich die Datei befindet fuer eine Info:\n ");
		String quellInfo = tastartur.next();
		File quellInfoF = new File(quellInfo);

		DatInfo info = new DatInfo();
		info.infoDat(quellInfoF);
		tastartur.close();

	}

}
