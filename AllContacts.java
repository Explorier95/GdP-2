package model;

import java.util.ArrayList;
import java.util.Arrays;

public class AllContacts {
	/**
	 * 
	 * EA FXG-1 Klasse zum generieren von Kontakten VERSION 1
	 * 
	 * @author Fabian Tappendorf - 357737
	 * @contact fabian.tappendorf@stud.th-luebeck.de
	 * @date 12/12/22
	 *
	 */
	public static ArrayList<Contact> contactList = new ArrayList<>();

	/**
	 * Generiert Kontakte
	 */
	public static void makeDefaultContacts() {

		Email frankMail = new Email("Frank@abc.de", "SexyHexxy@gmx.de", "Business@frank.de");
		Contact frank = new Contact("Frank", "Muller", "Frank.jpg", frankMail);
		contactList.add(frank);

		Email hugoMail = new Email("hugo@abc.de", "derSchlaue@gmx.de");
		Contact hugo = new Contact("Hugu", "Hugosohn", "hugo.jpg", hugoMail);
		contactList.add(hugo);

		Email reinerMail = new Email("reiner@abc.de", "derTolle@gmx.de", "Tischler@alice.de", "Reiner.keiner@gmx.de");
		Contact reiner = new Contact("Reiner", "Keiner", "Reiner.jpg", reinerMail);
		contactList.add(reiner);

		Email adolfMail = new Email("adolf@abc.de");
		Contact adolf = new Contact("Adolf", "West", "Adolf.jpg", adolfMail);
		contactList.add(adolf);

	}

	/**
	 * 
	 * @return Gibt die Kontakt Objekte zurück
	 */
	public static ArrayList<Contact> getAllContacts() {
		return contactList;
	}

	public static String[] getContactNames() {

		String[] hilfStringArrayDetails = new String[contactList.size()];
		for (int i = 0; i < contactList.size(); i++) {
			for (int y = 0; y < contactList.size(); y++) {
				String temp = "Name: " + contactList.get(i).get_Vorname() + " " + contactList.get(i).get_Nachname();
				if (Arrays.asList(hilfStringArrayDetails).contains(temp)) {
					break;
				} else {
					hilfStringArrayDetails[i] = "Name: " + contactList.get(i).get_Vorname() + " "
							+ contactList.get(i).get_Nachname();
				}
			}
		}
		return hilfStringArrayDetails;
	}

	/**
	 * 
	 * @return
	 * Gibt einen String der Kontakte zurück
	 */
	public static ArrayList<String> getDefaultList() {
		String[] derStringderAllesKann = getContactNames();

		ArrayList<String> contact = new ArrayList<>();

		for (int i = 0; i < derStringderAllesKann.length; i++) {
			contact.add(derStringderAllesKann[i]);
		}

		return contact;

	}

}
