package lab3_1;

public class ArrayMethods {
	public static void main(String[] args)
	{
		/*
		int[] test1 = {1,2,2,3,4};
		int[] test2 = removeDuplicates(test1);
		for (int item:test2)
		{
			System.out.println(item);
		}

		int[] test3 = {1,4,5,2};
		int[] test4 = {1,2,4,9};
		int[][]	test5 = productArray(test3,test4);
		for (int[] row : test5)
		{
			for (int num: row)
			{
				System.out.print(num);
				System.out.print(" ");
			}
			System.out.println();
		}
		*/
		int[][] testtri = pascalTriangle(6);
		printPascalTriangle(testtri);
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
		int[][] products = new int[arr1.length][arr2.length];
		for (int i = 0; i < arr1.length; i++)
		{
			for (int j = 0; j < arr2.length; j++)
			{
				products[i][j] = arr1[j] * arr2[i]; //Reversed...
			}
		}
		return products;
	}
	public static int[][] pascalTriangle(int n)
	{
		int[][] triangle = new int[n][];
		for (int i = 0; i < triangle.length; i++)
		{
			triangle[i] = new int [i + 1];
			for (int j = 0; j < triangle[i].length; j++)
			{
				if (j == 0 || j == triangle[i].length - 1)
				{
					triangle[i][j] = 1;
				}
				else
				{
					triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
				}
			}
		}
		return triangle;
	}
	public static void printPascalTriangle(int[][] pTriangle)
	{
		int maxLength = String.valueOf(pTriangle[pTriangle.length - 1][pTriangle[pTriangle.length - 1].length / 2]).length();
		System.out.println(maxLength);
		int width = pTriangle[pTriangle.length - 1].length + pTriangle[pTriangle.length - 1].length - 1;
		for (int[] row : pTriangle)
		{
			for (int i = 0; i < (width - (row.length + row.length - 1)) / 2; i++)
			{
				System.out.print(" ");
			}
			for (int i = 0; i < row.length / 2; i++)
			{
				System.out.print(row[i]);
				System.out.print(" ");
			}
			for (int i = row.length / 2; i < row.length; i++)
			{
				System.out.print(row[i]);
				System.out.print(" ");
			}
			for (int i = 0; i < (width - (row.length + row.length - 1)) / 2; i++)
			{
				System.out.print(" ");
			}
			System.out.println();
		}
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
