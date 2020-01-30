import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		int index = 0;
		int size = 50;
		double maxValue = 0;
		double minValue = 0;
		double TriangleTotal = 0;
		double ParallelogramTotal = 0;
		
		Shape[] shapes = new Shape[size];
		
		System.out.println("------->JAC 444 Assignment 1<--------");
		System.out.println("-------------->Task 1 <--------------\n");
		
		try (BufferedReader br = new BufferedReader(new FileReader("shapes.txt"))) 
		{
			String line;
			
			while ((line = br.readLine()) != null) 
			{
				String[] tokens = line.split(",");
				int len = tokens.length;
				
				for(int i = 0; i < len; i++) {
					
					if(tokens[i].equals("Circle") && len == 2) {
						try{
							shapes[index] = new Circle(Double.parseDouble(tokens[i+1]));
							index++;
						} catch(CircleException e) {
							System.out.println(e.getMessage());
						}
					} else if(tokens[i].equals("Parallelogram") && len == 3) {
						try{
							shapes[index] = new Parallelogram(Double.parseDouble(tokens[i+1]), Double.parseDouble(tokens[i+2]));
							index++;
						} catch(ParallelogramException | SquareException e) {
							System.out.println(e.getMessage());
						}
					} else if(tokens[i].equals("Rectangle") && len == 3) {
						try{
							shapes[index] = new Rectangle(Double.parseDouble(tokens[i+1]), Double.parseDouble(tokens[i+2]));
							index++;
						} catch(ParallelogramException | SquareException e) {
							System.out.println(e.getMessage());
						}
					} else if(tokens[i].equals("Square") && len == 2) {
						try{
							shapes[index] = new Square(Double.parseDouble(tokens[i+1]));
							index++;
						} catch(ParallelogramException | SquareException e) {
							System.out.println(e.getMessage());
						}
					} else if(tokens[i].equals("Triangle") && len == 4) {
						try{
							shapes[index] = new Triangle(Double.parseDouble(tokens[i+1]), Double.parseDouble(tokens[i+2]), Double.parseDouble(tokens[i+3]));
							index++;
						} catch(TriangleException e) {
							System.out.println(e.getMessage());
						}
					} else {
						continue;
					}
				}
			}
			
			
			
			System.out.println("\n" + index + " shapes were created:");	
			
			for(Shape shape : shapes) {
				if(shape != null) {
					System.out.println( "\n" + shape);					
				}
			}
			
			System.out.println("\n------->JAC 444 Assignment 1<--------");
			System.out.println("-------------->Task 2 <--------------\n");
			
			for(int i = 0; i < index; i++) {
				if(shapes[i].getClass().getSimpleName().equals("Circle")) {
					if(maxValue <= shapes[i].getPerimeter()) {
						maxValue = shapes[i].getPerimeter();
					}
					minValue = maxValue;
				} else if(shapes[i].getClass().getSimpleName().equals("Triangle")) {
					if(minValue >= shapes[i].getPerimeter()) {
						minValue = shapes[i].getPerimeter();
					}
				}
			}
			
			for(int i = 0; i < index; i++) {
				if(shapes[i].getClass().getSimpleName().equals("Circle")) {
					if(shapes[i].getPerimeter() == maxValue) {
						for(int j = i; j < index; j++) {
							shapes[j] = shapes[j+1];
						}
						index--;
					}
				}
			}
			
			for(int i = 0; i < index; i++) {
				if(shapes[i].getClass().getSimpleName().equals("Triangle")) {
					if(shapes[i].getPerimeter() == minValue) {
						for(int j = i; j < index; j++) {
							shapes[j] = shapes[j+1];
						}
						index--;
					}
				}
			}
			
			System.out.println(index + " shapes were created:");	
			
			for(Shape shape : shapes) {
				if(shape != null) {
					System.out.println( "\n" + shape);					
				}
			}
			
			System.out.println("\n------->JAC 444 Assignment 1<--------");
			System.out.println("-------------->Task 3 <--------------\n");
			
			for(Shape shape : shapes) {
				if (shape instanceof Parallelogram && !(shape instanceof Rectangle)) {
					ParallelogramTotal += shape.getPerimeter();
				} else if(shape instanceof Triangle) {
					TriangleTotal += shape.getPerimeter();
				}
			}
			
			System.out.println("Total perimeter of Parallelogram is: " + ParallelogramTotal);
			System.out.println("Total perimeter of Parallelogram is: " + TriangleTotal);
			
		} catch (IOException e) {  
			System.out.println(e.getMessage()); 
		}
	}
}
