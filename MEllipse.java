package model;

/**
 * EA FX2 Erweiterung der für die Klasse MShape zum anzeigen in SHowShapesA
 * VERSION 1
 * 
 * @author Fabian Tappendorf - 357737
 * @contact fabian.tappendorf@stud.th-luebeck.de
 * @date 14/12/22
 *
 */
public class MEllipse extends MShape {

	private double radiusX;
	private double radiusY;
	private double centerX;
	private double centerY;

	/**
	 * 
	 * @param x       = alt x
	 * @param y       = alt y
	 * @param xRadius = Radius x der Ellipse
	 * @param yRadius = Radius y der Ellipse
	 * @param centerX = Mittelpunkt X
	 * @param centerY = Mittelpunkt Y
	 * 
	 *                Durch die Mittelpunkte brauchen wir super(x,y) nurnoch um den
	 *                Text nach dem Verfahren von ShowShapesA auszugeben.
	 */
	public MEllipse(double x, double y, double xRadius, double yRadius, double centerX, double centerY) {
		super(x, y);
		this.radiusX = xRadius;
		this.radiusY = yRadius;
		this.centerX = centerX;
		this.centerY = centerY;
	}

	/**
	 * 
	 * @return
	 */
	public double getRadiusX() {
		return radiusX;
	}

	/**
	 * 
	 * @return
	 */
	public double getRadiusY() {
		return radiusY;
	}

	/**
	 * 
	 * @return
	 */
	public double getCenterX() {
		return centerX;
	}

	/**
	 * 
	 * @return
	 */
	public double getCenterY() {
		return centerY;
	}

	/**
	 * Zur berrechnung des Flaecheninhalts
	 */
	@Override
	public double area() {
		return (Math.PI * (this.radiusX * this.radiusY));
	}

	/**
	 * toStinr() zur ausgabe in MShape
	 */
	@Override
	public String toString() {
		return "Ellipse with origin: " + origin() + ", RadiusX: " + this.radiusX + ",RadiusY: " + this.radiusY
				+ ",CenterX: " + this.centerX + ",CenterY: " + this.centerY + ", Area: " + area() + ", Circumference: "
				+ circumference();
	}

	/**
	 * zur berrechnung des Umfanges der Ellipse
	 */
	@Override
	public double circumference() {
		return (2 * 3.14 * Math.sqrt((Math.pow(this.radiusX, 2) + Math.pow(this.radiusY, 2)) / 2));
	}

}
