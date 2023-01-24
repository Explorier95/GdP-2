
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * EA REK-E1 Programm zur erstellung von 10 x 10 zufallsgenerierte Labyrinthe.
 * Wegweisung ist entweder moeglich oder nicht, beginnend von der Mitter heraus.
 * 0 = Es gibt keinen Ausweg. A = Der Ausweg. * = Der Weg den das Programm
 * 
 * ACHTUNG!!: Es handelt sich hierbei um keine Generische Loesung, es kommt
 * leider manchmal zu Problemen im Algorythmus. Wenn es zu Problemen kommt den
 * Code einfach noch mal ausfuehren bis zwei gueltige Ergebnisse angezeigt
 * werden. 
 * 
 * VERSION 1
 * 
 * @author Fabian Tappendorf - 357737
 * @contact fabian.tappendorf@stud.th-luebeck.de
 * @date 27/12/22
 *
 */
public class Labyrinth{

	private static Random random = new Random();
	public char[][] labyrinth = new char[10][10];
	public static ArrayList<int[]> oldLocations = new ArrayList<>();

	/**
	 * Zur erstellung von random indexzahlen für random "X"
	 * 
	 * @param n
	 * @return
	 */
	public static int randomGenerator(int n) {
		ArrayList<Integer> usedNumbers = new ArrayList<>();
		int randomNr = random.nextInt(n);
		if (usedNumbers.contains(randomNr)) {
			randomGenerator(n);
		} else
			usedNumbers.add(randomNr);
		return randomNr;
	}

	/**
	 * Erstelle Labyrinth
	 * 
	 * @return Ein zweidimensionales Array wird ausgegeben.
	 */
	public char[][] creatLab() {

		for (int i = 0; i < labyrinth.length; i++) {
			try {
				int randomNr1 = randomGenerator(labyrinth.length);
				int randomNr2 = randomGenerator(labyrinth.length);
				labyrinth[i][randomNr1] = ' ';
				labyrinth[i][randomNr2] = ' ';
				labyrinth[randomNr1][i] = ' ';
				labyrinth[randomNr2][i] = ' ';
				labyrinth[randomNr1][randomNr1] = ' ';
				labyrinth[randomNr1][randomNr2] = ' ';
				labyrinth[randomNr2][randomNr2] = ' ';

			} catch (StackOverflowError e) {

				System.err.println("Fehler! Es kommt zum Unendlichloop und wird abgebrochen!");
			}

		}
		labyrinth[4][4] = '0';
		cleanArray(labyrinth);
		return labyrinth;

	}

	public char[][] totalFinder(char[][] sArrays, int x, int y) {
		return sArrays;
	}

	/**
	 * 
	 * @param cArrays
	 * @param x
	 * = x
	 * @param y
	 * = y 
	 * @param v
	 * Case
	 * @return
	 * @throws Exception
	 */
	public char[][] verticalFinder(char[][] cArrays, int x, int y, int v) {

		if (cArrays[4][4 + 1] == 'X' && cArrays[4][4 - 1] == 'X' && cArrays[4 + 1][4] == 'X'
				&& cArrays[4 - 1][4] == 'X') {

			System.err.println("Kein Ausweg vorhanden!");

		} else {
			try {
				switch (v) {
				case 1:
					try {
						int[] hLocCase1 = { x, y };
						oldLocations.add(hLocCase1);
						if (cArrays[x][y] == '*') {
//							System.out.println("ich war hier schon - gehe in Funktion 4!");
							verticalFinder(cArrays, x + 1, y + 1, 4);
						} else if (cArrays[x][y + 1] == 'X') {
//							System.out.println("geh in funktion 2!");
							verticalFinder(cArrays, x, y, 2);
						} else if (cArrays[x][y + 1] != 'X') {
							cArrays[x][y] = '*';
							System.out.println("* wurde in index [" + x + "][" + y + "]" + "geschrieben");
							verticalFinder(cArrays, x, y + 1, v);
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						cArrays[x][y] = 'A';
						System.err.println("Ausgang erreicht");

					}
					break;
				case 2:
					try {
						int[] hLocCase2 = { x, y };
						oldLocations.add(hLocCase2);
						if (cArrays[x][y] == '*') {
//							System.out.println("ich war hier schon - gehe in Funktion 1!");
							verticalFinder(cArrays, x, y, 1);
						} else if (cArrays[x - 1][y] == 'X') {
//							System.out.println("geh in funktion 3!");
							verticalFinder(cArrays, x, y, 3);
						} else if (cArrays[x - 1][y] != 'X') {
							System.out.println("* wurde in index [" + x + "][" + y + "]" + "geschrieben");
							cArrays[x][y] = '*';
							verticalFinder(cArrays, x - 1, y, v);
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						cArrays[x][y] = 'A';
						System.err.println("Ausgang erreicht");
					}

					break;
				case 3:
					try {
						int[] hLocCase3 = { x, y };
						oldLocations.add(hLocCase3);
						if (cArrays[x][y] == '*') {
//							System.out.println("ich war hier schon - gehe in Funktion 2");
							verticalFinder(cArrays, x + 1, y + 1, 2);
						} else if (cArrays[x][y - 1] == 'X') {
//							System.out.println("geh in funktion 4!");
							verticalFinder(cArrays, x, y, 4);
						} else if (cArrays[x][y - 1] != 'X') {
							System.out.println("* wurde in index [" + x + "][" + y + "]" + "geschrieben");
							cArrays[x][y] = '*';
							verticalFinder(cArrays, x, y - 1, v);

						}
					} catch (ArrayIndexOutOfBoundsException e) {
						cArrays[x][y] = 'A';
						System.err.println("Ausgang erreicht");
					}

					break;
				case 4:
					try {
						int[] hLocCase4 = { x, y };
						oldLocations.add(hLocCase4);
						if (cArrays[x][y] == '*') {
//							System.out.println("ich war hier schon - gehe in Funktion 3");
							verticalFinder(cArrays, x + 1, y - 1, 3);
						} else if (cArrays[x + 1][y] == 'X') {
//							System.out.println("geh in funktion 1!");
							verticalFinder(cArrays, x, y, 1);

						} else if (cArrays[x + 1][y] != 'X') {
							System.out.println("* wurde in index [" + x + "][" + y + "]" + "geschrieben");
							cArrays[x][y] = '*';
							verticalFinder(cArrays, x + 1, y, v);
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						cArrays[x][y] = 'A';
						System.err.println("Ausgang erreicht");
					}

					break;
				}
			} catch (StackOverflowError e) {
				int rN = random.nextInt(4);
				verticalFinder(cArrays, x, y, rN);

			}

		}
		return cArrays;
	}

	/**
	 * Hilf-Funktion zur erstellung des Labyrinths
	 * 
	 * @param array String Array welcher gereinigt werden soll von "null"
	 */
	public void cleanArray(char[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int y = 0; y < array[i].length; y++) {
				if (Character.toString(array[i][y]).equals(" ")) {
					array[i][y] = 'X';
				}
			}
		}
	}

	public static void main(String[] args) {
		Labyrinth aLab = new Labyrinth();

		System.out.println(Arrays.deepToString(aLab.verticalFinder(aLab.creatLab(), 4, 4, 1)).replace("], ", "]\n"));
		System.out.println(Arrays.deepToString(aLab.verticalFinder(aLab.creatLab(), 4, 4, 1)).replace("], ", "]\n"));

	}

}
