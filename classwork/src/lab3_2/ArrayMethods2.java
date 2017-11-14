package lab3_2;

public class ArrayMethods2 {

	public static void main(String[] args)
	{
		String[] test1 = {"a", "z"};
		String[] test2 = {"db", "da"};
		
		String[] test3 = merge(test1, test2);
		for (String test : test3)
		{
			System.out.println(test);
		}
	}
	
	public static String[] merge(String[] list1, String[] list2)
	{
		String[] copy1 = list1;
		String[] copy2 = list2;
		String[] answer = new String[list1.length + list2.length];
		int counter = 0;
		while (copy1.length > 0 || copy2.length > 0)
		{
			String compare1;
			String compare2;
			if (copy1.length > 0)
			{
				compare1 = copy1[0];
			}
			else
			{
				compare1 = "";
			}
			if (copy2.length > 0)
			{
				compare2 = copy2[0];
			}
			else 
			{
				compare2 = "";
			}
			
			if (compare1.equals("") && !compare2.equals(""))
			{
				answer[counter] = compare2;
				copy2 = removeAtIndex(copy2, 0);
			}
			else if (!compare1.equals("") && compare2.equals(""))
			{
				answer[counter] = compare1;
				copy1 = removeAtIndex(copy1, 0);
			}
			else
			{
				int winner = 0;
				int charCounter = 0;
				while (winner == 0)
				{
					System.out.println((int)compare1.charAt(charCounter));
					System.out.println((int)compare2.charAt(charCounter));
					if ((int)compare1.charAt(charCounter) == (int)compare2.charAt(charCounter))
					{
						charCounter++;
					}

					if ((int)compare1.charAt(charCounter) > (int)compare2.charAt(charCounter))
					{
						winner = 2;
					}
					else if ((int)compare1.charAt(charCounter) < (int)compare2.charAt(charCounter))
					{
						winner = 1;
					}
					
				}
				
				if (winner == 1)
				{
					answer[counter] = compare1;
					copy1 = removeAtIndex(copy1, 0);
				}
				else if (winner == 2)
				{
					answer[counter] = compare2;
					copy2 = removeAtIndex(copy2, 0);
				}
			}
			counter++;
		}
		return answer;
	}

	public static String[] mergeSort(String[] list)
	{
		return null;
	}
	public static int partition(int[] list)
	{
		return 1;
	}
	
	private static int[] appendArray(int[] arr, int num)
	{
		int[] temp = new int[arr.length + 1];
		for (int i = 0; i < arr.length; i++)
		{
			temp[i] = arr[i];
		}
		temp[temp.length - 1] = num;
		return temp;
	}
	private static String[] removeAtIndex(String[] arr, int num)
	{
		if (num > arr.length)
		{
			return null;
		}
		String[] temp = new String[arr.length - 1];
		int counter = 0;
		for (int i = 0; i < arr.length; i++)
		{
			if (i == num)
			{
				continue;
			}
			else
			{
				temp[counter] = arr[i];
				counter++;
			}
		}
		return temp;
	}
}
