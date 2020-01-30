import java.util.*;

public class StudentProcess {
	
	public static void main(String[] args) {
		Student[] student = {
				new Student("Jack", "Smith", 50.0, "IT"),
				new Student("Aaron", "Johnson", 76.0, "IT"),
				new Student("Maaria", "White", 35.8, "Business"),
				new Student("John", "White", 47.0, "Media"),
				new Student("Laney", "White", 62.0, "IT"),
				new Student("Jack", "Jones", 32.9, "Business"),
				new Student("Wesley", "Jones", 42.89, "Media")
		};
			
		/* *
		 * TASK 1
		 * */
		List<Student> studentList = Arrays.asList(student);
		System.out.println("--------TASK 1--------\n");
		System.out.println("Complete Student list:");
		studentList
			.stream()
			.forEach(System.out::println);
		
		/* *
		 * TASK 2
		 * */
		System.out.println("\n--------TASK 2--------\n");
		System.out.println("Students who got 50.0 - 100.0 sorted by grade:");
		studentList
			.stream()
			.sorted(Comparator.comparing(Student::getGrade))
			.filter(stu -> stu.getGrade() >= 50.0 && stu.getGrade() <= 100.0)
			.forEach(System.out::println);
		
		/* *
		 * TASK 3
		 * */
		System.out.println("\n--------TASK 3--------\n");
		System.out.println("First Student who got 50.0 - 100.0:");
		System.out.println(
				studentList
					.stream()
					.findFirst()
					.get()
		);
		
		/* *
		 * TASK 4 - Ascending
		 * */
		System.out.println("\n--------TASK 4--------\n");
		System.out.println("Students in ascending order by last name then first:");
		studentList
			.stream()
			.sorted(
					Comparator.comparing(Student::getLastName)
					.thenComparing(Comparator.comparing(Student::getFirstName))
			)
			.forEach(System.out::println);;
		
		/* *
		 * TASK 4 - Descending
		 * */
		System.out.println("\nStudents in descending order by last name then first:");
		studentList
			.stream()
			.sorted(
					Comparator.comparing(Student::getLastName)
					.thenComparing(Comparator.comparing(Student::getFirstName))
					.reversed()
			)
			.forEach(System.out::println);
		
		/* *
		 * TASK 5
		 * */
		System.out.println("\n--------TASK 5--------\n");
		System.out.println("Unique Student last names:");
		studentList
			.stream()
			.map(Student::getLastName)
			.distinct()
			.sorted()
			.forEach(System.out::println);
	}
}
