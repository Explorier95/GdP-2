package model;

import java.util.ArrayList;

/**
 * 
 * EA FXG-1 Contact Klasse  
 * VERSION 1
 * 
 * @author Fabian Tappendorf - 357737
 * @contact fabian.tappendorf@stud.th-luebeck.de
 * @date 12/12/22
 *
 */

public class Contact {

	private String vorname;
	private String nachname;
	private String photo;
	private Email emailObjekt;

	private ArrayList<Email> emailList = new ArrayList<>();
	private ArrayList<String> nameList = new ArrayList<>();
/**
 * 
 * @param vorname
 * @param nachname
 * @param photo
 * @param email
 * Konstruktor der drei Strings und ein Email-Element benötigen
 */
	public Contact(String vorname, String nachname, String photo, Email email) {

		this.vorname = vorname;
		this.nachname = nachname;
		this.photo = photo;
		this.emailObjekt = email;

		nameList.add("Name: " + vorname + nachname);
		emailList.add(email);
	}
	/**
	 * 
	 * @return
	 * =Das Email Objekt vom Contaktobjekt wird zurückgegeben
	 */
	public Email getEmailObjekt() {
		return emailObjekt;
	}
/**
 * 
 * @param person
 * =Email Objekt wird benötigt
 * @return
 * =Emails des Objektes werden ausgegeben
 */
	public ArrayList<String> getAllMails(Email person) {
		return person.get_Emails();
	}
/**
 * 
 * @return
 * =ArrayListe der Namen
 */
	public ArrayList<String> nameList() {
		return nameList;
	}
/**
 * 
 * @return
 */
	public String get_Vorname() {
		return vorname;
	}
/**
 * 
 * @return
 */
	public String get_Nachname() {
		return nachname;
	}
/**
 * 
 * @return
 */
	public String get_Photo() {
		return photo;
	}



}
