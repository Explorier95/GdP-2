package model;

/**
 * represents a Rectangle.
 * A Rectangle is a Shape with a length and a width.
 * @author Gert Veltink, updated Agathe Merceron and Fabian Tappendorf
 *
 */

public class MRectangle extends MShape {
	
	private double xDelta;
	private double yDelta;
	
	/**
     * constructs a rectangle object 
     * 
     * @param xOrigin
     *            the x-coordinate of the shape's origin
     * @param yOrigin
     *            the y-coordinate of the shape's origin
     * @param xDelta
     *            half of the length
     * @param yDelta
     *            half of the width
     * 
     */
    
	public MRectangle(double xOrigin, double yOrigin, double xDelta, double yDelta) {
        super(xOrigin, yOrigin);
        this.xDelta = xDelta;
        this.yDelta = yDelta;
    }
	
	public void setRectangleX (double x) {
		this.xDelta = x;
	}
	
	public void setRectangleY (double y) {
		this.yDelta = y;
	}
	
	/**
	 * returns half the length of the rectangle
	 * @return half the length
	 */
	
	public double getXDelta() {
		return xDelta;
	}
	
	/**
	 * returns half the width of the rectangle
	 * @return half the width
	 */
	
	public double getYDelta(){
		return yDelta;
	}

    /**
     * calculate the area of this rectangle.
     * 
     * @return the area of the rectangle
     * @update habe ich angepasst da falsche Formel gerechnet wurde
     */
	@Override
    public double area() {
        return this.xDelta * this.yDelta;
    }

    /**
     * calculate the circumference of this rectangle.
     * 
     * @return the circumference of the rectangle
     * @update habe ich angepasst da falsche Formel gerechnet wurde
     */
	@Override
    public double circumference() {
        return (2*this.xDelta) + (2*this.yDelta);
    }

    /**
     * constructs a textual representation of the object.
     * 
     * @return the current object in a textual representation
     */
    @Override
    public String toString() {
    	return "Rectangle with origin: " + origin() + 
				", xDelta: " + this.xDelta + ", yDelta: " +this.yDelta;
    }

}
