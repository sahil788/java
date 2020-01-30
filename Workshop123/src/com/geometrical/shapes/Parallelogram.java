import java.text.DecimalFormat;

public class Parallelogram extends Main implements Shape{
	
	private double width;
	private double height;
	
	/* *
	 * to format the decimal value of perimeter
	 * */
	private static DecimalFormat formatter = new DecimalFormat("#.#####");

	/* *
	 *  Constructor with parameter
	 *  throws exception if data is invalid
	 * */
	public Parallelogram(double width, double height) throws ParallelogramException, SquareException{
		if(width > 0 && height > 0) {
			this.width = width;
			this.height = height;
		} else {
			throw new ParallelogramException("Invalid side!");
		}
	}
	
	/* *
	 * getWidth is used to retrieve the width
	 * */
	public double getWidth() {
		return width;
	}
	
	/* *
	 * setWidth is used to set the value of width
	 * */
	public void setWidth(double width) throws ParallelogramException{
		if(width > 0) {
			this.width = width;
		} else {
			throw new ParallelogramException("Invalid side!");
		}
	}
	
	/* *
	 * getHeight is used to retrieve the height
	 * */
	public double getHeight() {
		return height;
	}
	
	/* *
	 * setWidth is used to set the value of height
	 * */
	public void setHeight(double height) throws ParallelogramException{
		if(height > 0) {
			this.height = height;
		} else {
			throw new ParallelogramException("Invalid side!");
		}
	}
	
	/* *
	 * Overriding the getPerimeter method
	 * which find a perimeter of the Parallelogram
	 * */
	@Override
	public double getPerimeter() {
		return 2 * (getWidth() + getHeight());
	}
	
	/* *
	 * function representing the string for parallelogram 
	 * */
	@Override
	public String toString() {
		return "Parallelogram {w=" + (new Double(getWidth()).toString()) + ", h=" + (new Double(getHeight()).toString()) + "} perimeter = " + (new Double(formatter.format(getPerimeter())).toString());
	}
}
