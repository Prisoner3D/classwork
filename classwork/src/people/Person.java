package people;

public abstract class Person {
	
	private String familyName;
	private String firstName;
	private int birthDate;
	private String subject;
	
	public Person(String firstName, String familyName, int birthDate, String subject)
	{
		this.firstName = firstName;
		this.familyName = familyName;
		this.birthDate = birthDate;
		this.subject = subject;
	}
	
	public String toString()
	{
		return "abc";
	}

	public int calculateAge(int currentDate) {
		return (int) ((currentDate - birthDate) / 3.154e+10) ;
	}

	public int getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(int birthDate) {
		this.birthDate = birthDate;
	}
}
