package lab3_4;

import java.util.Arrays;

public class ArrayMethods4 {
	public static void main(String[] args)
	{
		int[] testPartition = {6,5,4,2,8,7,6};
		quickSort(testPartition, 0, 7);
		for (int num : testPartition)
		{
			System.out.println(num);
		}
	}
	
	/**
	 * This method takes the first element of the array and sets it as the pivot. The
	 * pivot is used to test every element and see whether or not they are less or greater
	 * than the pivot. All elements that are less than the pivot are swapped and moved to 
	 * the left of the pivot and all elements that are greater than the pivot are swapped
	 * and moved to the right of the pivot.
	 * 
	 * @param list
	 * @return
	 */
	public static int partition(int[] list, int front, int back)
	{
		int pivot = list[front];
		int i = front;
		//System.out.println(front);
		for (int j = front + 1; j < back; j++)
		{
			if (list[j] <= pivot)
			{
				i++;
				swap(list, i, j);
			}
		}
		//System.out.println(i);
		swap(list, i, front);
		return i;
	}
	
	public static void quickSort(int[] list1, int front, int back)
	{
		if (front >= back)
		{
			return;
		}
		else
		{
			int PIVOTindex = partition(list1, front, back);
			quickSort(list1, front, PIVOTindex);
			quickSort(list1, PIVOTindex + 1, back);
		}
	}
	
	/**
	 * This helper method swaps elements of the int[] at i and j by setting int[i] to a temp
	 * so that the value isn't lost. It then sets int[i] to int[j] and setting int[j] 
	 * to the temp
	 * 
	 * @param a the int[] that is passed in where elements need to be swapped
	 * @param i	the first number that needs to be swapped with the second
	 * @param j the second number that needs to be swapped with the first
	 */
	private static void swap(int[] a, int i, int j)
	{
	    int temp = a[i];
	    a[i] = a[j];
	    a[j] = temp;
	}
}
