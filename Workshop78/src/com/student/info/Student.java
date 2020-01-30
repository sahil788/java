public class Student {

	private String firstName;
	private String lastName;
	private Double grade;
	private String department;
	
	/* *
	 * Constructor
	 * */
	public Student(final String firstName, final String lastName, final double grade, final String department) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.grade = grade;
		this.department = department;
	}
	
	/* *
	 * Getter Methods
	 * */
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public double getGrade() {
		return grade;
	}
	public String getDepartment() {
		return department;
	}
	
	/* *
	 * Setter Methods
	 * */
	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}
	public void setGrade(final double grade) {
		this.grade = grade;
	}
	public void setDepartment(final String department) {
		this.department = department;
	}
	
	public String getName() {
		return getFirstName() + "\t" + getLastName();
	}
	
	/* *
	 * equals method
	 * */
	@Override
	public boolean equals(Object object) {
		if(this == object) {
			return true;
		}
		if(object == null) {
			return false;
		}
		if(getClass() != object.getClass()) {
			return false;
		}
		Student student = (Student) object;
		if(firstName == null) {
			if(student.firstName != null) {
				return false;
			}
		} else if(!(firstName.equals(student.firstName))){
			return false;
		}
		if(lastName == null) {
			if(student.lastName != null) {
				return false;
			}
		} else if(!(lastName.equals(student.lastName))){
			return false;
		}
		if(grade == null) {
			if(student.grade != null) {
				return false;
			}
		} else if(!(grade.equals(student.grade))){
			return false;
		}
		if(department == null) {
			if(student.department != null) {
				return false;
			}
		} else if(!(department.equals(student.department))){
			return false;
		}
		return true;
	}
	
	/* *
	 * toString Method to print the information of student
	 * */
	@Override
	public String toString() {
		return getName() + "\t" + getGrade() + "\t" + getDepartment();
	}
	
}
