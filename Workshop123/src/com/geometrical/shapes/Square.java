import java.text.DecimalFormat;

public class Square extends Rectangle{
	
	/* *
	 * to format the decimal value of perimeter
	 * */
	private static DecimalFormat formatter = new DecimalFormat("##.#####");
	
	/* *
	 *   Constructor with parameter
	 *  throws exception if data is invalid
	 * */
	public Square(double side) throws ParallelogramException, SquareException {
		super(side, side);
	}
	
	/* *
	 * Overriding the getPerimeter method
	 * which find a perimeter of the Square
	 * */
	@Override
	public double getPerimeter() {
		return 4 * getWidth();
	}
	
	/* *
	 * function representing the string for Square 
	 * */
	@Override
	public String toString() {
		return "Square {s=" + (new Double(getWidth()).toString()) + "} perimeter = " + (new Double(formatter.format(getPerimeter())).toString());
	}
}
