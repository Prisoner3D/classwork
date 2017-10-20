package people;

public class Teacher extends Person {
	private int salary;
	private String subject;

	@Override
	public int calculateAge(int currentDate) {
		return currentDate - getBirthDate();
	}
	@Override
	public String toString() {
		return "teacher tostring";
	}
	
}
