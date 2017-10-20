package people;

public class Student extends Person{
	private String school;
	private double OSIS;
	private int gradeLevel;
	private double GPA;
	
	@Override
	public int calculateAge(int currentDate) {
		return currentDate - getBirthDate();
	}
	@Override
	public String toString() {
		return "student tostring";
	}
}
