package people;

public class Student extends Person{
	
	private String school;
	private int OSIS;
	private int gradeLevel;
	private double GPA;

	public Student(String firstName, String familyName, int age, String subject, String school, int OSIS, int gradeLevel, double GPA) {
		super(firstName, familyName, age, subject);
		this.school = school;
		this.OSIS = OSIS;
		this.gradeLevel = gradeLevel;
		this.GPA = GPA;
	}
	@Override
	public String toString() {
		return "student tostring";
	}
}
