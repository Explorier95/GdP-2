package telefonnummer;

import java.util.ArrayList;

/**
 * EA DUD-E2 Programm zur Erweiterung von TelefonEintrag mithilfer von ArrayList
 * VERSION 1
 * 
 * @author Fabian Tappendorf - 357737
 * @contact fabian.tappendorf@stud.th-luebeck.de
 * @date 06/12/22
 *
 */

public class Telefonliste {

	ArrayList<TelefonEintrag> telefonliste = new ArrayList<>();

	/**
	 * 
	 * @return = Die ArrayListe
	 */
	public ArrayList<TelefonEintrag> get_telefonliste() {
		return telefonliste;
	}

	/**
	 * 
	 * @param name   = neuer Name
	 * @param number = neue Nummer
	 */
	public void addEntry(String name, String number) {
		TelefonEintrag eintragAdd = new TelefonEintrag(name, number);
		telefonliste.add(eintragAdd);
		System.out.println(name + " und " + number + " wurden addiert.");

	}

	/**
	 * 
	 * @param name   = entferne Namen
	 * @param number = entferne Nummer
	 */
	public void removeEntry(String name, String number) {
		TelefonEintrag eintragDel = new TelefonEintrag(name, number);

		for (int i = 0; i < telefonliste.size(); i++) {
			if (telefonliste.get(i).equals(eintragDel)) {
				telefonliste.remove(i);
				System.out.println("Eintrag: " + eintragDel + " wurde erfolgreich entfernt.");
			} else {
				System.out.println("Eintrag: " + eintragDel + " wurde nicht gefunden.");
			}
		}
	}

	/**
	 * 
	 * @param oldName   = Suche nach alten Namen
	 * @param oldNumber = Suche nach alter Nummer
	 * @param newName   = Füge neuen Namen ein
	 * @param newNumber = Füge neue Nummer ein
	 * @return
	 */
	public boolean modifyEntry(String oldName, String oldNumber, String newName, String newNumber) {
		TelefonEintrag eintragChange = new TelefonEintrag(oldName, oldNumber);
		TelefonEintrag eintragNew = new TelefonEintrag(newName, newNumber);
		boolean test = false;

		for (int i = 0; i < telefonliste.size(); i++) {
			if (telefonliste.get(i).equals(eintragChange)) {
				telefonliste.remove(i);
				telefonliste.add(eintragNew);
				System.out.println("Eintrag: " + eintragNew + " wurde neu Eingetragen(In der Liste)");
				test = true;
			}
		}
		return test;
	}

	/**
	 * 
	 * @param name = Zu suchende Name
	 * @return Gib das Element der Liste zurück
	 */
	public String searchByName(String name) {
		TelefonEintrag eintragSearchName = new TelefonEintrag(name, "");

		for (int i = 0; i < telefonliste.size(); i++) {
			if (telefonliste.get(i).toString().startsWith(eintragSearchName.toString())) {
				eintragSearchName = telefonliste.get(i);
			} else {
				System.out.println("Index: " + i + " falsches Element");
			}
		}
		return "" + eintragSearchName;
	}

	/**
	 * 
	 * @param number = Zu suchende Nummer
	 * @return Gibt das element der Liste zurück
	 */
	public String searchNameByNumber(String number) {
		String nummer = number;
		String stringAmount = nummer.toString();

		int intAmount = stringAmount.length();

		for (int i = 0; i < telefonliste.size(); i++) {
			int hilfsVariable = telefonliste.get(i).toString().length();
			if (telefonliste.get(i).toString().substring(hilfsVariable - intAmount, hilfsVariable)
					.equals(nummer.toString())) {
				nummer = telefonliste.get(i).toString();
			} else {
				if (telefonliste.get(i).toString().contains((("0" + nummer.toString())))) {
					nummer = telefonliste.get(i).toString();
				} else {
					System.out.println("NICHT GEFUNDEN!!");
				}
				System.out.println("Index: " + i + " falsches Element");
			}
		}
		return "" + nummer;
	}

	/**
	 * Hilsfunktion für TelefonlisteTets
	 */
	public void clear() {
		get_telefonliste().clear();

	}

	/**
	 * Hilsfunktion für TelefonlisteTets
	 */
	public Integer size() {

		return get_telefonliste().size();
	}

}
