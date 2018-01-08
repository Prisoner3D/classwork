package SimonTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Simon {
	// need to add this to everything
	// dont forget to comment out useless
	private ArrayList<String> colors = new ArrayList<String>();
	private String[] ref = {"red","blue","green"}; // change so that it works with different applications
	private Random random = new Random();
	private Iterator in;
	private int score;
	
	public Simon() {
		
		System.out.println(this.addRandomColor());
		this.score = 0;
	}

	public String addRandomColor()
	{
		String color = ref[random.nextInt(ref.length)];
		colors.add(color);
		return color;
	}
	
	public int getScore()
	{
		return score;
	}
	
	public ArrayList<String> getColors() {
		return colors;
	}
	
	public int updateMove(String color)
	{
		if (in == null)
		{
			in = colors.iterator(); // default in is not initialized
		}
		if (in.hasNext())
		{
			if (in.next().equals(color))
			{
				if (!in.hasNext()) // round is over
				{
					System.out.println("done");
					String test = this.addRandomColor(); // adds another color to round
					score++;
					System.out.println(test);
					in = colors.iterator(); // starts new round
					return 2; // round over
				}
				return 1; // correct input
			}
			else
			{
				System.out.println("you lose");
				return 0; // incorrect input
			}
		}
		return -1; // should never happen?
	}
}
