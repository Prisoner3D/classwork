package lab3_1;

public class ArrayMethods {
	public static void main(String[] args)
	{
		int[] test1 = {1,2,2,3,4};
		int[] test2 = removeDuplicates(test1);
		for (int item:test2)
		{
			System.out.println(item);
		}
	}
	public static int[] removeDuplicates(int[] list)
	{
		int[] temp = new int[] {};
		for (int i = 0; i < list.length; i++)
		{
			int counter = 0;
			for (int j = 0; j < list.length; j++)
			{
				if (list[i] == list[j])
				{
					counter++;
				}
			}
			if (!(counter > 1))
			{
				temp = appendArray(temp, list[i]);
			}
		}
		return temp;
	}
	public static int[][] productArray(int[] arr1, int[] arr2)
	{
		return null;
	}
	public static int[][] pascalTriangle(int n)
	{
		return null;
	}
	public static void printPascalTriangle(int[][] pTriangle)
	{
		
	}
	
	public static int[] appendArray(int[] arr, int num)
	{
		int[] temp = new int[arr.length + 1];
		for (int i = 0; i < arr.length; i++)
		{
			temp[i] = arr[i];
		}
		temp[temp.length - 1] = num;
		return temp;
	}
}
