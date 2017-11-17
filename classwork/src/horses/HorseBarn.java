package horses;

public class HorseBarn {

	private Horse[] spaces;
	
	public HorseBarn(Horse[] spaces) {
		this.spaces = spaces;
	}
	
	public int findHorseSpace(String name)
	{
		for (int i = 0; i < this.spaces.length; i++)
		{
			if (this.spaces[i] != null && this.spaces[i].getName().equals(name))
			{
				return i;
			}
		}
		return -1;
	}
	
	public void consolidate()
	{
		Horse[] newBarn = new Horse[this.spaces.length];
		int index = 0;
		for (int i = 0; i < this.spaces.length; i++)
		{
			if (this.spaces[i] != null)
			{
				newBarn[index] = this.spaces[i];
				index++;
			}
		}
		this.spaces = newBarn;
	}
	
	@Override
	public String toString() {
		String test = "";
		for (Horse horse: this.spaces)
		{
			test += "[" + horse + "] ";
		}
		return test;
	}
}
