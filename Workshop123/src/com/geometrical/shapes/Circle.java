import java.text.DecimalFormat;

public class Circle extends Main implements Shape{
	
	private double radius;
	
	/* *
	 * to format the decimal value of perimeter
	 * */
	private static DecimalFormat formatter = new DecimalFormat("#.#####");
	
	/* *
	 *  Constructor with parameter
	 *  throws exception if data is invalid
	 * */
	public Circle(double radius) throws CircleException {
		if(radius > 0.00) {
			this.radius = radius;
		} else {
			throw new CircleException("Invalid radius!");
		}
	}
	
	/* *
	 * getRadius is used to retrieve the radius
	 * */
	public double getRadius() {
		return radius;
	}
	
	/* *
	 * setRadius is used to set the value of radius
	 * */
	public void setRadius(double radius) throws CircleException {
		if(radius > 0) {
			this.radius = radius;
		} else {
			throw new CircleException("Invalid radius!");
		}
	}
	
	/* *
	 * Overriding the getPerimeter method
	 * which find a perimeter of the circle
	 * */
	public double getPerimeter() {
		return 2 * Math.PI * getRadius();
	}
	
	/* *
	 * function representing the string for circle 
	 * */
	public String toString() {
		return "Circle {r=" + (new Double(getRadius()).toString()) + "} perimeter = " + (new Double(formatter.format(getPerimeter())).toString());
	}
}
