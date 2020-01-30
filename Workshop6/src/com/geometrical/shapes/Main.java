import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		int index = 0;
		int size = 50;
		
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
						
		} catch (IOException e) {  
			System.out.println(e.getMessage()); 
		}
	}
}