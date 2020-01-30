import java.text.DecimalFormat;

public class Triangle extends Main implements Shape{
	
	private double side1;
	private double side2;
	private double side3;
	
	/* *
	 * to format the decimal value of perimeter
	 * */
	private static DecimalFormat formatter = new DecimalFormat("##.#####");
	
	/* *
	 *  Constructor with parameter
	 *  throws exception if data is invalid
	 * */
	public Triangle(double side1, double side2, double side3) throws TriangleException {
		if(side1 > 0 
				&& side2 > 0 
				&& side3 > 0 
				&& side1 + side2 > side3 
				&& side1 + side3 > side2 
				&& side3 + side2 > side1) 
		{
			this.side1 = side1;
			this.side2 = side2;
			this.side3 = side3;
		} else {
			throw new TriangleException("Invalid side(s)!");
		}
	}
	
	/* *
	 * getSide1 is used to retrieve the value of side1
	 * */
	public double getSide1() {
		return side1;
	}
	
	/* *
	 * setSide1 is used to set the value of side1
	 * */
	public void setSide1(double side1) throws TriangleException {
		if(side1 > 0) {
			this.side1 = side1;
		} else {
			throw new TriangleException("Invalid side(s)!");
		}
	}
	
	/* *
	 * getSide2 is used to retrieve the value of side2
	 * */
	public double getSide2() {
		return side2;
	}
	
	/* *
	 * setSide2 is used to set the value of side2
	 * */
	public void setSide2(double side2) throws TriangleException {
		if(side2 > 0) {
			this.side2 = side2;
		} else {
			throw new TriangleException("Invalid side(s)!");
		}
	}
	
	/* *
	 * getSide3 is used to retrieve the value of side3
	 * */
	public double getSide3() {
		return side3;
	}
	
	/* *
	 * setSide3 is used to set the value of side3
	 * */
	public void setSide3(double side3) throws TriangleException {
		if(side3 > 0) {
			this.side3 = side3;
		} else {
			throw new TriangleException("Invalid side(s)!");
		}
	}
	
	/* *
	 * Overriding the getPerimeter method
	 * which find a perimeter of the Triangle
	 * */
	@Override
	public double getPerimeter() {
		return getSide1() + getSide2() + getSide3();
	}
	
	/* *
	 * function representing the string for Triangle 
	 * */
	@Override
	public String toString() {
		return "Triangle {s="+ (new Double(getSide1()).toString()) +", s="+ (new Double(getSide2()).toString()) +", s="+ (new Double(getSide3()).toString()) +"} perimeter = "+ (new Double(formatter.format(getPerimeter())).toString());
	}
}
