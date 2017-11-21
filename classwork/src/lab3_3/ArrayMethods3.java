package lab3_3;

public class ArrayMethods3 {
	public static void main(String[] args) 
	{
		/*
		int[] test1 = {0,3,4,1,2,5,3,2, 1,1,1,1,1,1,1,1,1,1,1,2,2,2,3,3,23,2,32,32,13,1,34,4,14,541,5,34,23,423,41,23, -1};
		insertionSort(test1);
		for(int i = 0; i < test1.length; i++)
		{
			System.out.print(test1[i] + " ");
		}
		*/
		double[] test2 = {1.2,424.2,0.2,1.1};
		selectionSort(test2);
		for(int i = 0; i < test2.length; i++)
		{
			System.out.print(test2[i] + " ");
		}
	}
	
	public static void insertionSort(int[] list1) {
		int j = 0;
		for (int i = 0; i <= list1.length; i++)
		{
			for (int k = j-1; k >= 0; k--)
			{
				if (list1[k] > list1[j])
				{
					swap(list1, k, j);
					j--;
				}
			}
			j = i;
		}
	}
	
	public static void selectionSort(double[] list1) {
		for (int i = 0; i < list1.length; i++)
		{
			for (int j = i + 1; j < list1.length; j++)
			{
				if (list1[i] > list1[j])
				{
					swap(list1, i, j);
				}
			}
		}
	}
	
	public static void bubbleSort(String[] list1) {
		
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
	
	private static void swap(double[] a, int i, int j)
	{
		double temp = a[i];
	    a[i] = a[j];
	    a[j] = temp;
	}
}
