package view;

import java.util.ArrayList;

import model.AllContacts;
import model.Contact;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 
 * EA FXG-1 Programm zur optischen Anzeige von Kontakten. VERSION 1
 * 
 * @author Fabian Tappendorf - 357737
 * @contact fabian.tappendorf@stud.th-luebeck.de
 * @date 12/12/22
 *
 */
public class ShowContacts extends Application {

	public void start(Stage primaryStage) {

		AllContacts.makeDefaultContacts();
		ArrayList<Contact> contacts = new ArrayList<>(AllContacts.getAllContacts());
		ArrayList<String> contactList = new ArrayList<>();

		try {
			GridPane root = new GridPane();
			root.setAlignment(Pos.CENTER);
			root.setHgap(10);
			root.setVgap(10);
			root.setPadding(new Insets(25, 25, 25, 25));

			for (int i = 0; i < contacts.size(); i++) {
				ArrayList<String> emailList = new ArrayList<>();
				// System.out.println(contacts.get(i).getAllMails(contacts.get(i).getEmailObjekt()));
				for (int y = 0; y < contacts.get(i).getAllMails(contacts.get(i).getEmailObjekt()).size(); y++) {
					emailList.add(contacts.get(i).getAllMails(contacts.get(i).getEmailObjekt()).get(y));
				}

				contactList.add(contacts.get(i).get_Vorname() + " " + contacts.get(i).get_Nachname() + " " + emailList);
				System.out.println(contactList.get(i));

			}

			Image imagePerson1 = new Image(
					getClass().getResource("/resources/" + contacts.get(0).get_Photo()).toString(), 100, 100, false,
					false);

			ImageView imageview1 = new ImageView(imagePerson1);
			root.add(imageview1, 1, 0);

			Text person1 = new Text(contactList.get(0));
			root.add(person1, 0, 0);

			Text person2 = new Text(contactList.get(1));
			root.add(person2, 0, 1);

			Image imagePerson2 = new Image(
					getClass().getResource("/resources/" + contacts.get(1).get_Photo()).toString(), 100, 100, false,
					false);

			ImageView imageview2 = new ImageView(imagePerson2);
			root.add(imageview2, 1, 1);

			Text person3 = new Text(contactList.get(2));
			root.add(person3, 0, 2);

			Image imagePerson3 = new Image(
					getClass().getResource("/resources/" + contacts.get(2).get_Photo()).toString(), 100, 100, false,
					false);

			ImageView imageview3 = new ImageView(imagePerson3);
			root.add(imageview3, 1, 2);

			Text person4 = new Text(contactList.get(3));
			root.add(person4, 0, 3);

			Image imagePerson4 = new Image(
					getClass().getResource("/resources/" + contacts.get(3).get_Photo()).toString(), 100, 100, false,
					false);

			ImageView imageview4 = new ImageView(imagePerson4);
			root.add(imageview4, 1, 3);

			Scene scene = new Scene(root, 600, 600);
			primaryStage.setTitle("");
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
