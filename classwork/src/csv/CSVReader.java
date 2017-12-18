package csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReader {
	
	public static void main(String[] args) throws FileNotFoundException
	{
		String directory = "C:\\Users\\BT_1N3_20\\eclipse-workspace\\csv\\src\\csv\\csv111.csv";
		File file = new File(directory);
		Scanner in = new Scanner(file);
		
		while(in.hasNext())
		{
			List<String> words = parseLine(in.next());
			for (String word : words)
			{
				System.out.print(word + " ");
			}
			System.out.println();
			//System.out.println(in.next());
		}
		
		in.close();
	}
	public static List<String> parseLine(String string)
	{
		boolean inQuotes = false;
		char newSeperator = ',';
		StringBuffer newString = new StringBuffer();
		ArrayList<String> appended = new ArrayList<String>();
		char[] chars = string.toCharArray();
		for (char character : chars)
		{
			if (inQuotes)
			{
				if (character == '"')
				{
					inQuotes = false;
					continue;
				}
				newString.append(character);
			}
			else
			{
				if (character == '"')
				{
					inQuotes = true;
					continue;
				}
				if (character == newSeperator)
				{
					appended.add(newString.toString());
					newString.setLength(0);
					continue;
				}
				else
				{
					newString.append(character);
				}
			}
			
		}
		appended.add(newString.toString());
		return appended;
	}
}
