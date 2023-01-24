package umlaute;
import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * EA DUD-E2
 * Programm zum suchen und ersetzen von Umlauten.
 *@author Fabian Tappendorf - 357737
 *@contact fabian.tappendorf@stud.th-luebeck.de
 *@date 08/11/22
 *
 */

public class HtmlConv {
/**
 * Array zu testen der Korekten Umlautersetzung.
 */

	public static ArrayList<String> inhalt = new ArrayList<String>();

	/**
	 * Mainmethode
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String pfad = "C:\\Users\\Ftapp\\eclipse-workspace\\EA\\src\\umlaute\\datei1702_vor.html";
		String dateiName = "datei1702_nach.html";
		testeCharacterEingabe(pfad,dateiName);
	}
	
/**
 * 
 * @param pfad
 * = Pfad zur Wunschdatei
 * @param dateiName
 * = Name der neuen Datei
 * @throws IOException
 */
	public static void testeCharacterEingabe(String pfad,String dateiName) throws IOException {

		try {
			FileInputStream fiStream = new FileInputStream(pfad);
			InputStreamReader isReader = new InputStreamReader(fiStream, StandardCharsets.UTF_8);
			BufferedReader bReader = new BufferedReader(isReader);
			BufferedWriter bWriter = new BufferedWriter(new FileWriter(dateiName));
			

			while (bReader.ready()) {
				String e = bReader.readLine();
				e = e.replace("ä", "&auml");
				e = e.replace("Ä", "&Auml");
				e = e.replace("ö", "&ouml");
				e = e.replace("Ö", "&Ouml");
				e = e.replace("ü", "&uuml");
				e = e.replace("Ü", "&Uuml");
				e = e.replace("ß", "&szlig");
				inhalt.add(e);
				bWriter.write(e);
			}
			bReader.close();
			bWriter.close();
	

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println(inhalt);

	}
}
