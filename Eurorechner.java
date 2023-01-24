package waehrungsumrechner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Eurorechner {
	
/**
 * @author Fabian Tappendorf
 * EA DUD-E1
 * Programm zum einfachen umrechnen von Euro nach Dollar und anders herum.
 * @contact fabian.tappendorf@stud.th-luebeck.de
 * @datum 24-10-2022
 * 
 */

	
	public double ergebnisUSD = 0;
	public double ergebnisEUR = 0;
	protected char waehrung;
	protected double umrechnungswert;
	protected double kursUSD = 0.9872;
	protected double kursEUR = 1.0140;
	
	/**
 	* 	
 	* @param umrechnungswert
 	* = ergebnisUSD
 	* = ergebnisEUR
 	*/
	public Eurorechner(double umrechnungswert) {
		this.umrechnungswert = umrechnungswert;
		this.ergebnisUSD = umrechnungswert * get_kursUSD(); 
		this.ergebnisEUR = umrechnungswert * get_kursEUR();
	//	System.out.println(umrechnungswert + " EUR ist " + ergebnisUSD + " US Dollar.");
	//	System.out.println(umrechnungswert + " US Dollar ist " + ergebnisEUR + " EURO.");	
	}
	
	/**
	 * 
	 * @return
	 * = umrechnungswert
	 */
	
	public double get_umrechnungswert() {
		return umrechnungswert;
	}
	/**
	 * 
	 * @return
	 * =ergebnisUSD
	 */
	public double get_ergebnisUSD() {
		return ergebnisUSD;
	}
	/**
	 * 
	 * @return
	 * =ergebnisEUR
	 */
	public double get_ergebnisEUR() {
		return ergebnisEUR;
	}
	/**
 	* Standardkonstruktor 
 	*/
	
	public Eurorechner() {
	
	}
	
	/**
 	* 
 	* @return
 	* kursUSD
 	*/
	
	public double get_kursUSD() {
		return kursUSD;
	}
	
	/**
	 * 
	 * @return
	 * kursEUR
	 */
	
	public double get_kursEUR() {
		return kursEUR;
	}
	
	/**
	 * 
	 * @param w
	 * waehrung
	 */
	
	public void set_waehrung(char w) {
		this.waehrung = w;
	}
	
	/**
	 * 
	 * @return
	 * waehrung.
	 */
	
	public char get_waehrung() {
		return waehrung;
	}
	
	/**
	 * 
	 * @return
	 * input.
	 * @throws IOException 
	 */
	

	public char eingabeWaehrung() throws Exception {
		int inputE = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			inputE = br.read();
		} catch (IOException e) {
			System.out.println("Falsche Eingabe bitte nochmal!");
			e.printStackTrace();
		}
		
		return (char)inputE;	
	}
	
	/**
	 * 
	 * @return
	 * inputA
	 * @throws IOException
	 */
	
	public char abfrage() throws IOException {
		System.out.println("Wollen Sie noch einmal j/n? : ");
		int inputA = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		inputA = br.read();
		return (char) inputA;
	}
	
	/**
	 * 
	 * @return
	 * input
	 * @throws Exception
	 * IOException
	 */

	public double eingabeZahlen() throws Exception {
		int inputZ = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Bitte gebe den umzurechnenden Betrag ein: ");
			inputZ = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			System.out.println("Falsche Eingabe bitte nochmal!");
		
		} catch (IOException e) {
			System.out.println("Falsche Eingabe bitte nochmal!");
		}

		return (double)inputZ;
	}
	
	
	/**
	 * 
	 * @throws Exception
	 *  
	 */

	public void maschiene() throws Exception {
		do {
		System.out.println("Eingabe der Ausgangswaehrung (E)uro oder (U)S Dollar ? : ");
		char i = eingabeWaehrung();
		switch(i) {
        case'U':
        	if(get_ergebnisUSD()<= 0) {
            	double eingegebeneZahl1 = eingabeZahlen();
            	System.out.println(eingegebeneZahl1 + " US Dollar sind " + eingegebeneZahl1 * get_kursUSD()+" Euro");
        	}else {
        		System.out.println(get_umrechnungswert()+" Us Dollar sind " + get_umrechnungswert()*get_kursUSD() + " Euro");
        	}
            break;
        case'u':
        	if(get_ergebnisUSD()<= 0||get_kursUSD()<= 0) {
            	double eingegebeneZahl1 = eingabeZahlen();
            	System.out.println(eingegebeneZahl1 + " US Dollar sind " + eingegebeneZahl1 * get_kursUSD()+" Euro");
        	}else {
        		System.out.println(get_umrechnungswert()+" Us Dollar sind " + get_umrechnungswert()*get_kursUSD() + " Euro");
        	}
            break;
        case'E':
        	if(get_ergebnisEUR()<= 0||get_kursUSD()<= 0) {
            	double eingegebeneZahl3 = eingabeZahlen();
            	System.out.println(eingegebeneZahl3 + " EURO sind " + eingegebeneZahl3 * get_kursEUR()+" US Dollar");
        	}else {
        		System.out.println(get_umrechnungswert()+ " EURO sind " + get_umrechnungswert()*get_kursEUR() + " US Dollar");
        	}
            break;
        case'e':
        	if(get_ergebnisEUR()<= 0||get_kursUSD()<= 0) {
            	double eingegebeneZahl3 = eingabeZahlen();
            	System.out.println(eingegebeneZahl3 + " EURO sind " + eingegebeneZahl3 * get_kursEUR()+" US Dollar");
        	}else {
        		System.out.println(get_umrechnungswert()+ " EURO sind " + get_umrechnungswert()*get_kursEUR() + " US Dollar");
        	}
            break;
      default:
            System.out.println("Falsche Eingabe bitte nochmal!");
            break;
		}
		}while(abfrage()=='j');
		
		
	}
/**
 * 
 * @param args
 * @throws IOException
 * Zwei mögliche Szenarien.
 * 1. Konstruktor aufruf mit Wert als Übergabeparameter.
 * 2. Eigene Eingabe mithilfe von BufferedReader und InputStream.
 */
	public static void main(String[] args) throws Exception {
		
		Eurorechner r = new Eurorechner(5);
		//Eurorechner l = new Eurorechner();
		r.maschiene();
		Eurorechner l = new Eurorechner();
		l.maschiene();
		


		
		
	}

}
