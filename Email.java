package model;

import java.util.ArrayList;
/**
 * 
 * EA FXG-1 Email Klasse
 * VERSION 1
 * 
 * @author Fabian Tappendorf - 357737
 * @contact fabian.tappendorf@stud.th-luebeck.de
 * @date 12/12/22
 *
 */
public class Email {

	private ArrayList<String> emailAddresses = new ArrayList<>();
/**
 * 
 * @param email
 * Konstruktor, der beliebig viele Strings entgegennimmt.
 */
	public Email(String... email) {

		for (int i = 0; i < email.length; i++) {
			char[] emailChar = email[i].toCharArray();
			for (int e = 0; e < emailChar.length; e++) {
				if (emailChar[0]=='@') {
					System.out.println("Falsche E-Mai");
					break;
				}
				if (emailChar[emailChar.length-1] == '@') {
					System.out.println("Falsche E-Mai");
					break;
				}
				if (emailChar.toString().contains("@")) {
					this.emailAddresses.add(email[i].toString());
					break;
				}
				if (emailChar.toString().contains("@")) {
					System.out.println("Falsche E-Mai");
					break;
				}
				
			}
		}

	}

	/**
	 * 
	 * @return
	 * = Eine Liste der Emails im Objekt
	 */
	public ArrayList<String> get_Emails() {
		ArrayList<String> emailArrayList = new ArrayList<>();
		for (int i = 0; i < emailAddresses.size(); i++) {
			emailArrayList.add(emailAddresses.get(i));
		}
		return emailArrayList;
	}
	

}