package verzeichnisbehandlung;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * EA DUD-E3 Verzeichniserstellung
 * @author Fabian Tappendorf - 357737
 * @contact fabian.tappendorf@stud.th-luebeck.de
 * @date 23/11/22
 *
 */
public class VerzErst {
	
/**
 * Zwei private Variablen 
 * verzeichnisAngabe für den Scanner
 * verzeichnisArray für die Übergabe der Konstruktorparameter und einfache Umsetzung
 */
	private String verzeichnisAngabe = null;
	private ArrayList<String> verzeichnisArray = new ArrayList();
/**
 * 
 * @param a
 * = Erstes Verzeichnis
 * @param b
 * = Zweites Verzeichnis
 * @param c
 * = Drittes Verzeichnis
 * @param d
 * = Viertes Verzeichnis
 * @param e
 * = Fünftes Verzeichnis
 */
	public VerzErst(String a, String b, String c, String d, String e) {
		this.verzeichnisArray.add(a);
		this.verzeichnisArray.add(b);
		this.verzeichnisArray.add(c);
		this.verzeichnisArray.add(d);
		this.verzeichnisArray.add(e);
	}
	
	public void erstelleVerzeichnis() {
		Scanner eingabe = new Scanner(System.in);
		System.out.println(
				"\nBitte gebe das Verzeichnis an indem eine vollstaendiges neue Verzeichnisstruktur entstehen soll:\n ");
		verzeichnisAngabe = eingabe.next();
		System.out.println("Das Verzeichnis: \n" + verzeichnisAngabe);
		File datenmanagement = new File(verzeichnisAngabe + "\\" + verzeichnisArray.get(0));
		if (datenmanagement.mkdirs()) {
			System.out.println("Verzeichnis: " + verzeichnisArray.get(0) + " wurde erfolgreich angelegt.");
		}
		File html = new File(datenmanagement + "\\" + verzeichnisArray.get(1));
		if (html.mkdirs()) {
			System.out.println("Verzeichnis: " + verzeichnisArray.get(1) + " wurde erfolgreich angelegt.");
		}
		for (int i = 2; i < verzeichnisArray.size(); i++) {
			File subVerzeichnis = new File(html + "\\" + verzeichnisArray.get(i));
			if (subVerzeichnis.mkdirs()) {
				System.out.println("Verzeichnis: " + verzeichnisArray.get(i) + " wurde erfolgreich angelegt.");
			}
		}

	
	}

}
