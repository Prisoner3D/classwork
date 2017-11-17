package lab3_2;

import java.util.Arrays;

public class ArrayMethods2 {

	public static void main(String[] args)
	{
		String[] test1 = {"point", "tutorials"};
		String[] test2 = {"zebra", "ha", "dbab", "dba", "point", "dab"};
		int[] test3 = {5,1,7,8,9,5,2};
		int answer = partition(test3);
		for (int test : test3)
		{
			System.out.println(test);
		}
		System.out.println("answer: " + answer);
	}
	
	/**
	 * This method takes in two different arrays and merges them in a sorted order
	 * by comparing the elements in the array and placing them in their respective orders.
	 * For strings, it compares the characters of the compared strings and for integer,
	 * their values.
	 * 
	 * @param list1 test array 1 that will be merged with the second
	 * @param list2 test array 2 that will be merged with the first
	 * @return a String[] that will have all elements of the two parameters sorted
	 */
	public static String[] merge(String[] list1, String[] list2)
	{
		String[] copy1 = list1;
		String[] copy2 = list2;
		String[] answer = new String[list1.length + list2.length];
		int counter = 0;
		while (copy1.length > 0 || copy2.length > 0)
		{
			String compare1 = "";
			String compare2 = "";
			if (copy1.length > 0)
			{
				compare1 = copy1[0];
			}
			if (copy2.length > 0)
			{
				compare2 = copy2[0];
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
				if (compare1.compareTo(compare2) < 0)
				{
					winner = 1;
				}
				if (winner == 1)
				{
					answer[counter] = compare1;
					copy1 = removeAtIndex(copy1, 0);
				}
				else
				{
					answer[counter] = compare2;
					copy2 = removeAtIndex(copy2, 0);
				}
			}
			counter++;
		}
		return answer;
	}

	/**
	 * This method takes in an unsorted array and arranges them in a sorted order through
	 * Splitting the array into halves continuously until the smallest array has a length is 1.
	 * It then compares the smaller arrays, merges them then sorts them and continuously does so
	 * until we get the final sorted array.
	 * 
	 * @param list The array that needs to be sorted
	 * @return the array sorted
	 */
	public static String[] mergeSort(String[] list)
	{
		if (list.length == 1)
		{
			return list;
		}
		else if (list.length > 2)
		{
			int middle = list.length / 2;
			String[] left = Arrays.copyOfRange(list, 0, middle);
			String[] right = Arrays.copyOfRange(list, middle, list.length);
			return merge(mergeSort(left), mergeSort(right));
		}
		else
		{
			String[] left = Arrays.copyOfRange(list, 0, 1);
			String[] right = Arrays.copyOfRange(list, 1, 2);
			return merge(mergeSort(left), mergeSort(right));
		}
	}
	
	/**
	 * 
	 * @param list
	 * @return
	 */
	public static int partition(int[] list)
	{
		int pivot = list[0];
		int i = 0;
		for (int j = 1; j < list.length; j++)
		{
			if (list[j] <= pivot)
			{
				i++;
				swap(list, i, j);
			}
		}
		swap(list, i, 0);
		return i;
	}
	
	private static void swap(int[] a, int i, int j)
	{
	    int temp = a[i];
	    a[i] = a[j];
	    a[j] = temp;
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
