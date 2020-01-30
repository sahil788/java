import java.text.DecimalFormat;

public class Parallelogram extends Main implements Shape{
	
	private double width;
	private double height;
	
	private static DecimalFormat formatter = new DecimalFormat("#.#####");

	public Parallelogram(double width, double height) throws ParallelogramException, SquareException{
		if(width > 0 && height > 0) {
			this.width = width;
			this.height = height;
		} else {
			throw new ParallelogramException("Invalid side!");
		}
	}
	
	public double getWidth() {
		return width;
	}
	
	public void setWidth(double width) throws ParallelogramException{
		if(width > 0) {
			this.width = width;
		} else {
			throw new ParallelogramException("Invalid side!");
		}
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) throws ParallelogramException{
		if(height > 0) {
			this.height = height;
		} else {
			throw new ParallelogramException("Invalid side!");
		}
	}
	
	@Override
	public double getPerimeter() {
		return 2 * (getWidth() + getHeight());
	}
	
	@Override
	public String toString() {
		return "Parallelogram {w=" + (new Double(getWidth()).toString()) + ", h=" + (new Double(getHeight()).toString()) + "} Perimeter = " + (new Double(formatter.format(getPerimeter())).toString());
	}
}
