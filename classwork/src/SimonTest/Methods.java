package SimonTest;

import java.util.List;
import java.util.Random;
//DELETE
public class Methods {
	public static void main(String[] args)
	{
		String[] arrayTest = {"A","B","C","d"};
		for (int i = 0; i < 100; i++)
		{
			System.out.println(chooseRandomColor(arrayTest));
		}
	}
	//make constructor
	//List for colors
	//user input list
	//move method
	//returns a boolean if true disable all buttons
	//nvm change to int
	
	public static String chooseRandomColor(String[] array)
	{
		Random random = new Random();
		return array[random.nextInt(array.length)];
	}
	
	public static int updateMove(String color, List<String> e)
	{
		
		//list iterator 
		//if hasNext is false
		//return 1 which means good?
		//if next != color
		//return 0 which means bad
		//if next == color
		//return 2 continue?
		//edit numbers later
		return 0;
	}
}
