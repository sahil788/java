import java.text.DecimalFormat;

public class Triangle extends Main implements Shape{
	
	private double side1;
	private double side2;
	private double side3;
	
	private static DecimalFormat formatter = new DecimalFormat("##.#####");
	
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
	
	public double getSide1() {
		return side1;
	}
	
	public void setSide1(double side1) throws TriangleException {
		if(side1 > 0) {
			this.side1 = side1;
		} else {
			throw new TriangleException("Invalid side(s)!");
		}
	}
	
	public double getSide2() {
		return side2;
	}
	
	public void setSide2(double side2) throws TriangleException {
		if(side2 > 0) {
			this.side2 = side2;
		} else {
			throw new TriangleException("Invalid side(s)!");
		}
	}
	
	public double getSide3() {
		return side3;
	}
	
	public void setSide3(double side3) throws TriangleException {
		if(side3 > 0) {
			this.side3 = side3;
		} else {
			throw new TriangleException("Invalid side(s)!");
		}
	}
	
	@Override
	public double getPerimeter() {
		return getSide1() + getSide2() + getSide3();
	}
	
	@Override
	public String toString() {
		return "Triangle {s="+ (new Double(getSide1()).toString()) +", s="+ (new Double(getSide2()).toString()) +", s="+ (new Double(getSide3()).toString()) +"} Perimeter = "+ (new Double(formatter.format(getPerimeter())).toString());
	}
}
