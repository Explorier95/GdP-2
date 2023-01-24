﻿package view;

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
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.MAllShapes;
import model.MCircle;
import model.MRectangle;
import model.MSquare;
import model.MEllipse;
import model.MShape;

public class ShowShapesA extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			Group root = new Group();
			// the data that should be graphically represented
			MShape[] shapes = MAllShapes.getDefaultShapes();

			for (MShape s : shapes) {
				// check whether the shape is a rectangle
				if (s instanceof MRectangle) {
					// cast necessary for the methods getXDelta and getYDelta
					MRectangle srec = (MRectangle) s;
					Rectangle rec = new Rectangle(srec.getXOrigin(), srec.getYOrigin(), 2 * srec.getXDelta(),
							2 * srec.getYDelta());
					// color red is made transparent
					// so that overlapping shapes are visible
					rec.setFill(Color.rgb(255, 0, 0, 0.15));
					// the area (number rounded) displayed as text
					Text text = new Text(srec.getXOrigin(), srec.getYOrigin(),
							"Rechteck: " + Double.toString(Math.round(srec.area())));

					root.getChildren().addAll(rec, text);
				} else if (s instanceof MCircle) {
					// cast necessary for the methods getXDelta and getYDelta
					MCircle sc = (MCircle) s;
					Circle circ = new Circle(sc.getXOrigin(), sc.getYOrigin(), sc.getRadius());
					// color green is made transparent
					// so that overlapping shapes are visible
					circ.setFill(Color.rgb(0, 255, 0, 0.15));
					// the area (number rounded) displayed as text
					Text text = new Text(sc.getXOrigin(), sc.getYOrigin(),
							"Kreis: " + Double.toString(Math.round(sc.area())));
					/**
					 * Aufgabe 1: Ein Quadrat wird erstellt und der Szene hinzugefuegt
					 */
					root.getChildren().addAll(circ, text);
				} else if (s instanceof MSquare) {
					MSquare squr = (MSquare) s;
					MSquare square = new MSquare(squr.getXOrigin(), squr.getYOrigin(), squr.getXDelta());
					Text text = new Text(square.getXOrigin(), square.getYOrigin(),
							"Quadrat: " + Double.toString(Math.round(square.area())));
					root.getChildren().addAll(square.createSquare(Color.rgb(0, 0, 255, 0.15)), text);
					/**
					 * Aufgabe 2 : Eine Ellipse wird erstellt und der Szene hinzugefuegt
					 */
				} else if (s instanceof MEllipse) {

					MEllipse el = (MEllipse) s;
					Ellipse ellipse = new Ellipse(el.getXOrigin(), el.getYOrigin());
					ellipse.setCenterX(el.getCenterX());
					ellipse.setCenterY(el.getCenterY());
					ellipse.setRadiusX(el.getRadiusX());
					ellipse.setRadiusY(el.getRadiusY());
					ellipse.setFill(Color.rgb(255, 255, 0, 0.50));
					Text text = new Text(el.getXOrigin(), el.getYOrigin(),
							"Ellipse: " + Double.toString(Math.round(el.area())));

					root.getChildren().addAll(ellipse, text);
				}
			}

			Scene scene = new Scene(root, 400, 400);
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