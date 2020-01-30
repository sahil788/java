import java.text.DecimalFormat;

public class Square extends Rectangle{
	
	private static DecimalFormat formatter = new DecimalFormat("##.#####");
	
	public Square(double side) throws ParallelogramException, SquareException {
		super(side, side);
	}
	
	@Override
	public double getPerimeter() {
		return 4 * getWidth();
	}
	

	/***
	* lambda & functional interface
	*********/
	ShapeFunctionalInterface area = () -> getWidth() * getWidth();
	
	public double squareValue(double width, ShapeFunctionalInterface si) {
		return si.getArea();
	}
	
	@Override
	public double getArea() {
		return squareValue(getWidth(), area);
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "Square {s=" + (new Double(getWidth()).toString()) + "} Perimeter = " + (new Double(formatter.format(getPerimeter())).toString()) + " Area = " + (new Double(formatter.format(getArea())).toString());
	}
}
