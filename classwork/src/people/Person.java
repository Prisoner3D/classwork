package people;

public abstract class Person {
	
	private String firstName;
	private String familyName;
	private int age;
	private String subject;
	
	public Person(String firstName, String familyName, int age, String subject)
	{
		this.firstName = firstName;
		this.familyName = familyName;
		this.age = age;
		this.subject = subject;
	}
	
	public String toString()
	{
		return "abc";
	}

}
