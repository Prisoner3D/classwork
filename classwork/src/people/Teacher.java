package people;

public class Teacher extends Person {
	
	private int salary;
	private String subject;
	
	public Teacher(String firstName, String familyName, int age, String subject ) {
		super(firstName, familyName, age, subject);
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public String toString() {
		return "teacher tostring";
	}
	
}
