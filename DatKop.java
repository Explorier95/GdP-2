package verzeichnisbehandlung;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * EA DUD-E3 Kopierklasse
 * 
 * @author Fabian Tappendorf - 357737
 * @contact fabian.tappendorf@stud.th-luebeck.de
 * @date 23/11/22
 *
 */
public class DatKop {

	/**
	 * 
	 * @param quellF = Datei die Kopiert werden soll.
	 * @param zielF  = Neuer Pfad und Dateinamen
	 * @throws IOException Sollte es den Pfad nicht geben
	 */
	public void kopiereDatei(File quellF, File zielF) throws IOException {
		FileChannel inChannel = null;
		FileChannel outChannel = null;
		try {
			inChannel = new FileInputStream(quellF).getChannel();
			outChannel = new FileOutputStream(zielF).getChannel();
			inChannel.transferTo(0, inChannel.size(), outChannel);
		} catch (IOException e) {
			throw e;
		} finally {
			try {
				if (inChannel != null)
					inChannel.close();
				if (outChannel != null)
					outChannel.close();
			} catch (IOException e) {
			}
		}
	}

}
