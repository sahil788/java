import java.text.DecimalFormat;

public class Rectangle extends Parallelogram{
	
	/* *
	 * to format the decimal value of perimeter
	 * */
	private static DecimalFormat formatter = new DecimalFormat("##.#####");
	
	/* *
	 *   Constructor with parameter
	 *  throws exception if data is invalid
	 * */
	public Rectangle(double width, double height) throws ParallelogramException, SquareException {
		super(width, height);
	}
	
	/* *
	 * Overriding the getPerimeter method
	 * which find a perimeter of the Rectangle
	 * */
	@Override
	public double getPerimeter() {
		return 2 * (getWidth() + getHeight());
	}
	
	/* *
	 * function representing the string for Rectangle 
	 * */
	@Override
	public String toString() {
		return "Rectangle {w=" + (new Double(getWidth()).toString()) + ", h=" + (new Double(getHeight()).toString()) + "} perimeter = " + (new Double(formatter.format(getPerimeter())).toString());
	}
}
