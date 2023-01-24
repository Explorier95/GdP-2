package verzeichnisbehandlung;

import java.io.File;
import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * EA DUD-E3 Informationsanzeige
 * 
 * @author Fabian Tappendorf - 357737
 * @contact fabian.tappendorf@stud.th-luebeck.de
 * @date 23/11/22
 *
 */
public class DatInfo {

	/**
	 * 
	 * @param name = File Objekt zur uebergabe für die Funktionsaufrufe
	 * @loop = Ermoeglicht eine einfache Bedienung mithilfe eines Switchcases
	 */
	public void infoDat(File name) {

		boolean schleifenPfeife = true;

		while (schleifenPfeife == true) {
			System.out.println("-----------------------------------------------------------");
			System.out.println("--Waehlen Sie:\n" + "-> Dateigroesse 1;\n" + "-> Verzeichnis oder Datei 2;\n"
					+ "-> Letzter Tag der Aenderung 3;\n" + "-> Schreib- und Lesezugriff erlaubt ja/nein 4;\n"
					+ "--EXIT-- 0;\n");
			System.out.println("-----------------------------------------------------------");
			Scanner switchCases = new Scanner(System.in);

			int i = switchCases.nextInt();

			switch (i) {
			case 0:
				schleifenPfeife = false;
				System.out.println("Programm beendet.");
				break;
			case 1:
				System.out.println("Dateigröße: " + name.length() + "Bytes gross.");
				break;
			case 2:
				System.out.println("Dateiname: " + name.getName() + " /Verzeichnis: " + name.getPath());
				break;
			case 3:
				long miliSec = name.lastModified();
				DateFormat obj = new SimpleDateFormat("dd MMM yyyy HH:mm:ss:SSS Z");
				Date res = new Date(miliSec);
				System.out.println("Letzter Tag der Aenderung: " + obj.format(res));
				break;
			case 4:
				if (name.canWrite() == true) {
					System.out.println("Ja");
				} else {
					System.out.println("Nein");
				}
				break;
			default:
				System.out.println("FEHLER: Bitte gebe eine Zahl von 1 - 4 ein!");
				break;
			}

		}

	}
}
