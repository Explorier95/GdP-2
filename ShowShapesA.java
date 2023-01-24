package view;

/**
 * A class to represent graphically an Array of Shape-objects.
 * A Shape Object can be a rectangle or a circle.
 * The shapes appear with their real dimensions and positions,
 * and their area (number rounded) displayed at their origin.
 * @author agathe merceron, updated Fabian Tappendorf
 */

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.MAllShapes;
import model.MCircle;
import model.MRectangle;
import model.MShape;

public class ShowShapesA extends Application {

	private double rX;
	private double rY;
	private MShape[] shapes = MAllShapes.getDefaultShapes();

	private Rectangle recBinder = new Rectangle();

	/**
	 * primaryStage
	 */
	@Override
	public void start(Stage primaryStage) {

		try {
			// Objekt für die Funktionen der Klasse changeShape
			ChangeShape changeShape = new ChangeShape();

			Group root = new Group();

			for (MShape s : shapes) {

				// check whether the shape is a rectangle
				if (s instanceof MRectangle) {
					changeShape.setRectangle((MRectangle) s);

					MRectangle srec = (MRectangle) s;
					// hilfsvariablen
					rX = srec.getXDelta() * 2;
					rY = srec.getYDelta() * 2;

					Rectangle rec = new Rectangle(srec.getXOrigin(), srec.getYOrigin(), rX, rY);
					// Farbe
					rec.setFill(Color.rgb(255, 0, 0, 0.15));
					Text text = new Text(srec.getXOrigin(), srec.getYOrigin(),
							"Rechteck: " + Double.toString(Math.round(srec.area())));

					// Neues Fenster beim Klicken auf das Objekt
					rec.setOnMouseClicked(e -> {

						changeShape.setRectangle(srec);
						changeShape.openNewWindowRectangle(primaryStage);

					});
					root.getChildren().addAll(rec, text);

				} else if (s instanceof MCircle) {

					MCircle sc = (MCircle) s;
					Circle circ = new Circle(sc.getXOrigin(), sc.getYOrigin(), sc.getRadius());

					circ.setFill(Color.rgb(0, 255, 0, 0.15));
					// the area (number rounded) displayed as text
					Text text = new Text(sc.getXOrigin(), sc.getYOrigin(),
							"Kreis: " + Double.toString(Math.round(sc.area())));

					// Neues Fenster beim Klicken auf das Objekt
					circ.setOnMouseClicked(e -> {

						changeShape.setCircle(sc);
						changeShape.openNewWindowCircle(primaryStage);

					});

					root.getChildren().addAll(circ, text);

				}
			}

			Scene scene = new Scene(root, 400, 400);

			primaryStage.setTitle("Shapes");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param recM
	 * @param x
	 * @param y
	 * MRectangle Objekt mit hoehe und leange.
	 * Sucht nach einem Speziellen MRectangle um es zu aendern.
	 * Gibt neue Maße aus.
	 */
	public void setMShape(MRectangle recM, double x, double y) {
		for (int i = 0; i < shapes.length; i++) {
			if (shapes[i] instanceof MRectangle) {
				MRectangle m = (MRectangle) shapes[i];
				if (m.getXDelta() == recM.getXDelta() && m.getYDelta() == recM.getYDelta()) {
					recM.setRectangleX(x);
					recM.setRectangleY(y);
					shapes[i] = recM;
					System.err.println("NEU!!  " + shapes[i]);
				}
			}
		}
	}

	/**
	 * 
	 * @param circM
	 * @param r
	 * MCircle Objekt mit radius.
	 * Sucht nach einem Speziellen MCircle um es zu aendern.
	 * Gibt neue Maße aus.
	 */
	public void setMShape2(MCircle circM, double r) {
		for (int i = 0; i < shapes.length; i++) {
			if (shapes[i] instanceof MCircle) {
				MCircle c = (MCircle) shapes[i];
				if (c.getRadius() == circM.getRadius()) {
					circM.setRadius(r);
					shapes[i] = circM;
					System.err.println("NEU!!  " + shapes[i]);
				}
			}
		}
	}
/**
 * 
 * @return
 * 
 */
	public Rectangle getTheRectangleBilder() {
		return recBinder;
	}
/**
 * 
 * @param args
 */
	public static void main(String[] args) {
		launch(args);
	}

}