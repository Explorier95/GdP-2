package application;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AdressenViewController {

	KontaktListe kontaktListe = new KontaktListe();

	@FXML
	private Button hinzufuegen;

	@FXML
	private Button anzeigen;

	@FXML
	private Button loeschen;

	@FXML
	void hinzufuegenButton(ActionEvent event) {

	}

	@FXML
	void loeschenButton(ActionEvent event) {

	}

	@FXML
	void anzeigenButton(ActionEvent event)
			throws ParserConfigurationException, SAXException, IOException, TransformerException {
		// Neue Root und Scene erstellen
		// Methode aus List aufrufen

		// Neues Fenster

		GridPane root2 = new GridPane();

		Label label = new Label("Die Kontakte:\n" + kontaktListe.getAlleNamenToString());

		root2.getChildren().add(label);

		Scene secondScene = new Scene(root2, 450, 350);

		// Neues Fenster (Stage)
		Stage newWindow = new Stage();

		newWindow.setTitle("Zeige alle Kontakte");

		newWindow.setScene(secondScene);

		newWindow.show();

	}

}
