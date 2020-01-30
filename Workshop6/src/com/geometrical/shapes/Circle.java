import java.text.DecimalFormat;

public class Circle extends Main implements Shape, ShapeFunctionalInterface{
	
	private double radius;
	
	private static DecimalFormat formatter = new DecimalFormat("#.#####");
	
	public Circle(double radius) throws CircleException {
		if(radius > 0.00) {
			this.radius = radius;
		} else {
			throw new CircleException("Invalid radius!");
		}
	}
	
	public double getRadius() {
		return radius;
	}
	
	
	public void setRadius(double radius) throws CircleException {
		if(radius > 0) {
			this.radius = radius;
		} else {
			throw new CircleException("Invalid radius!");
		}
	}
	
	@Override
	public double getPerimeter() {
		return 2 * Math.PI * getRadius();
	}
	
	
	
	
	/***
	* lambda & functional interface
	*********/
	
	
	ShapeFunctionalInterface area = () -> Math.PI * getRadius() * getRadius();
	
	public double circleValue(double radius, ShapeFunctionalInterface si) {
		return si.getArea();
	}
	
	@Override
	public double getArea() {
		return circleValue(getRadius(), area);
	}
	
	
	
	
	
	public String toString() {
		return "Circle {r=" + (new Double(getRadius()).toString()) + "} Perimeter = " + (new Double(formatter.format(getPerimeter())).toString()) + " Area = " + (new Double(formatter.format(getArea())).toString());
	}

}
