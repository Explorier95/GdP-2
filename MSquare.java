package model;

/**
 * EA FX2 
 * Erweiterung der für die Klasse MShape zum anzeigen in SHowShapesA
 * VERSION 1
 * 
 * @author Fabian Tappendorf - 357737
 * @contact fabian.tappendorf@stud.th-luebeck.de
 * @date 14/12/22
 *
 */
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class MSquare extends MShape {

	private double deltaX;
	private double x;
	private double y;

	public MSquare(double x, double y, double deltaX) {
		super(x, y);
		this.x = x;
		this.y = y;
		this.deltaX = deltaX;
	}

	/**
	 * returns die leange
	 * 
	 * @return = die leange
	 */

	public double getXDelta() {
		return deltaX;
	}

	/**
	 * Flaecheninhalt
	 */
	@Override
	public double area() {
		return (deltaX * deltaX);
	}

	/**
	 * @return Umfang
	 */
	@Override
	public double circumference() {
		return (4 * this.deltaX);
	}

	/**
	 * @return toString()
	 */
	@Override
	public String toString() {
		return "Square with origin: " + origin() + ", deltaX: " + this.deltaX;
	}

	/**
	 * 
	 * @param rgb = Es gibt keine Methode setFill fuer Square diese fuege ich hier
	 *            ein.
	 * @return = Ein Rectangle Objekt welches ein Quadrat ist.
	 */
	public Rectangle createSquare(Color rgb) {

		Rectangle r = new Rectangle(x, y, this.deltaX, this.deltaX);
		r.setFill(rgb);

		return r;
	}

}
