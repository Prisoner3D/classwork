package cheese;

public class Cheese {

	public static void main(String[] args) {
		String[] cheese = new String[] {"1","2","3"};
		String[] twoCheese = two(cheese);
		System.out.println(cheese);
		System.out.println(twoCheese);
		methodthatprintsout(cheese);
		methodthatprintsout(twoCheese);
	}
	public static String[] two(String[] str)
	{
		for (int i = 0; i < str.length; i++)
		{
			str[i] = str[i] + str[i];
		}
		return str;
	}
	public static void methodthatprintsout(String[] str)
	{
		for (String x : str)
		{
			System.out.println(x);
		}
	}
}
