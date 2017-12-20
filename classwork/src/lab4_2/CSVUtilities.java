package lab4_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVUtilities {
	private ArrayList<String> CSVData = new ArrayList<String>();
	private int numColumns;
	
	public CSVUtilities(File csv) throws FileNotFoundException, IOException
	{
		String line;
		try (BufferedReader reader = new BufferedReader(new FileReader(csv)))
		{
			while ((line = reader.readLine()) != null)
			{
				this.CSVData.add(line);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		if (!CSVData.isEmpty())
		{
			String[] splitWords = CSVData.get(0).split(",");
			numColumns = splitWords.length;
		}
	}
	public List<String> getColumnHeaders()
	{
		ArrayList<String> headers = new ArrayList<String>();
		if (!CSVData.isEmpty())
		{
			String[] splitWords = CSVData.get(0).split(",");
			for (String string : splitWords)
			{
				headers.add(string);
			}
		}
		return headers;
	}
	public List<String> getDataString(int column)
	{
		ArrayList<String> strings = new ArrayList<String>();
		if (!CSVData.isEmpty() && column < numColumns)
		{
			for (String line : CSVData)
			{
				String[] splitWords = line.replaceAll("^\"", "").split("\"?(,|$)(?=(([^\"]*\"){2})*[^\"]*$) *\"?");
				strings.add(splitWords[column]);
			}
		}
		return strings;
	}
	public List<Integer> getDataInt(int column)
	{
		ArrayList<Integer> ints = new ArrayList<Integer>();
		if (!CSVData.isEmpty() && column < numColumns)
		{
			for (String line : CSVData)
			{
				String[] splitWords = line.replaceAll("^\"", "").split("\"?(,|$)(?=(([^\"]*\"){2})*[^\"]*$) *\"?");
				try {
					ints.add(Integer.valueOf(splitWords[column]));
				} catch (NumberFormatException e) {
					continue;
				}
			}
		}
		return ints;
	}
	public List<Double> getDataDouble(int column)
	{
		ArrayList<Double> doubles = new ArrayList<Double>();
		if (!CSVData.isEmpty() && column < numColumns)
		{
			for (String line : CSVData)
			{
				String[] splitWords = line.replaceAll("^\"", "").split("\"?(,|$)(?=(([^\"]*\"){2})*[^\"]*$) *\"?");
				try {
					doubles.add(Double.valueOf(splitWords[column]));
				} catch (NumberFormatException e) {
					continue;
				}
			}
		}
		return doubles;
	}
}
