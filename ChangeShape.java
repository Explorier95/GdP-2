package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.MCircle;
import model.MRectangle;

/**
 * EA FXE-E2 Programm zur erweiterung der JavaFX Applikation ShowShapesA VERSION
 * 1
 * 
 * @author Fabian Tappendorf - 357737
 * @contact fabian.tappendorf@stud.th-luebeck.de
 * @date 20/12/22
 *
 */

public class ChangeShape extends ShowShapesA {

	private MRectangle oldRectangle;
	private MCircle oldCircle;

	/**
	 * 
	 * @param stage primaryStage fuer Rechteck
	 */
	public void openNewWindowRectangle(Stage stage) {
		Button b1 = new Button("Submit");
		Text t1 = new Text("Half of the length:");
		Text t2 = new Text("Half of the width:");
		TextField tf1 = new TextField("10");
		TextField tf2 = new TextField("5");

		GridPane g = new GridPane();
		g.add(b1, 0, 2);
		g.add(t1, 0, 0);
		g.add(t2, 0, 1);
		g.add(tf1, 1, 0);
		g.add(tf2, 1, 1);

		b1.setOnAction(e -> {
			double x = Double.parseDouble(tf1.getText());
			double y = Double.parseDouble(tf2.getText());

			setMShape(oldRectangle, x, y);

			Stage newStage = new Stage();
			start(newStage);

			stage.hide();
		});

		stage.setScene(new Scene(g, 200, 100));
		stage.show();
	}

	/**
	 * 
	 * @param stage primaryStage fuer Kreis
	 */
	public void openNewWindowCircle(Stage stage) {
		Button b1 = new Button("Submit");
		Text t1 = new Text("New Radius:");
		TextField tf1 = new TextField("15");

		GridPane g = new GridPane();
		g.add(b1, 0, 2);
		g.add(t1, 0, 0);
		g.add(tf1, 1, 0);

		b1.setOnAction(e -> {
			double r = Double.parseDouble(tf1.getText());

			setMShape2(oldCircle, r);

			Stage newStage = new Stage();
			start(newStage);

			stage.hide();
		});

		stage.setScene(new Scene(g, 200, 100));
		stage.show();
	}
/**
 * 
 * @param r
 */
	public void setRectangle(MRectangle r) {
		this.oldRectangle = r;
	}
/**
 * 
 * @param c
 */
	public void setCircle(MCircle c) {
		this.oldCircle = c;
	}

}
