package learn_java;
import java.util.ArrayList;
import java.util.List;

public class sort {
	public static void main(String[] args)
	{
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(0);
		nums.add(1);
		nums.add(1);
		List<Integer> numsFiltered = removeDupes(nums);
		
		for (Integer num : numsFiltered)
		{
			System.out.println(num);
		}
	}
	public static List<Integer> removeDupes(List<Integer> nums)
	{
		for (int i = 0; i < nums.size() - 1; i++)
		{
			if (nums.get(i).equals(nums.get(i+1)))
			{
				nums.remove(i);
				i--;
			}
		}
		return nums;
	}
}
