package lab3_2;

public class ArrayMethods2 {

	public static void main(String[] args)
	{
		
	}
	
	public static String[] merge(int[] list1, int[] list2)
	{
		int[] copy1 = list1;
		int[] copy2 = list2;
		int[] answer = new int[list1.length + list2.length];
		
		for (int i = 0)
		return null;
	}

	public static String[] mergeSort(String[] list)
	{
		return null;
	}
	public static int partition(int[] list)
	{
		return null;
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
}
