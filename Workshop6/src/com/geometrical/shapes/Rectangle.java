import java.text.DecimalFormat;

public class Rectangle extends Parallelogram implements ShapeFunctionalInterface{
	
	private static DecimalFormat formatter = new DecimalFormat("##.#####");
	
	public Rectangle(double width, double height) throws ParallelogramException, SquareException {
		super(width, height);
	}
	
	@Override
	public double getPerimeter() {
		return 2 * (getWidth() + getHeight());
	}
	
	
	
	/***
	* lambda & functional interface
	*********/
	
	ShapeFunctionalInterface area = () -> getWidth() * getHeight();
	
	public double rectangleValue(double width, double height, ShapeFunctionalInterface si) {
		return si.getArea();
	}
	
	@Override
	public double getArea() {
		return rectangleValue(getWidth(), getHeight(), area);
	}


	
	@Override
	public String toString() {
		return "Rectangle {w=" + (new Double(getWidth()).toString()) + ", h=" + (new Double(getHeight()).toString()) + "} Perimeter = " + (new Double(formatter.format(getPerimeter())).toString()) + " Area = " + (new Double(formatter.format(getArea())).toString());
	}
}
