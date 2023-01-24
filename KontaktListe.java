package application;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import application.Kontakt.KontaktTyp;

public class KontaktListe {

	public ArrayList<Kontakt> readKontakteFromXML() throws SAXException, IOException, ParserConfigurationException {
		ArrayList<Kontakt> kontaktListe = new ArrayList<Kontakt>();

		// XML auslesen und in Array speichern - Rückgabe Array
		File file = new File("C:\\Users\\ahaen\\eclipse-workspace\\EA9\\src\\application\\adressen2.xml");

		// an instance of factory that gives a document builder
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// an instance of builder to parse the specified xml file
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(file);
		doc.getDocumentElement().normalize();

		System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
		NodeList nodeList = doc.getElementsByTagName("Kontakt");

		for (int itr = 0; itr < nodeList.getLength(); itr++) {
			Node node = nodeList.item(itr);
			System.out.println("\nNode Name :" + node.getNodeName());
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;

				String vorname = eElement.getElementsByTagName("Vorname").item(0).getTextContent();
				String nachname = eElement.getElementsByTagName("Nachname").item(0).getTextContent();

				String strasse = eElement.getElementsByTagName("Strasse").item(0).getTextContent();
				String plz = eElement.getElementsByTagName("PLZ").item(0).getTextContent();

				String ort = eElement.getElementsByTagName("Ort").item(0).getTextContent();

				String land = eElement.getElementsByTagName("Land").item(0).getTextContent();
				String typ = eElement.getAttribute("typ");
				KontaktTyp kontaktTyp = typ.equals("privat") ? KontaktTyp.privat : KontaktTyp.geschaeftlich;

				Kontakt k = new Kontakt(kontaktTyp, nachname, vorname, strasse, plz, ort, land);

				kontaktListe.add(k);
			}
		}

		return kontaktListe;

	}

	public ArrayList<String> getAlleNamen() throws SAXException, IOException, ParserConfigurationException {
		ArrayList<String> liste = new ArrayList<String>();
		ArrayList<Kontakt> kontakte = readKontakteFromXML();
		for (Kontakt k : kontakte) {
			liste.add(k.getVorname() + " " + k.getNachname());
		}

		return liste;

	}

	public ArrayList<Kontakt> getAdressenDaten(String vorname, String nachname)
			throws SAXException, IOException, ParserConfigurationException {
		ArrayList<Kontakt> liste = new ArrayList<Kontakt>();
		ArrayList<Kontakt> kontakte = readKontakteFromXML();

		for (Kontakt k : kontakte) {
			if (k.getVorname().equals(vorname) && k.getNachname().equals(nachname)) {
				liste.add(k);

			}

		}

		return liste;
	}

	public String getAlleNamenToString() throws SAXException, IOException, ParserConfigurationException {
		String namen = "";
		ArrayList<String> namensListe = getAlleNamen();
		for (String s : namensListe) {
			namen += s + "\n";
		}

		return namen;

	}

}