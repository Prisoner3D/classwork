package lab4_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CSVUtilities {
	private ArrayList<String> CSVData = new ArrayList<String>();
	private int numColumns;
	private File csv;
	//Skip first entry
	public CSVUtilities(File csv) throws FileNotFoundException, IOException
	{
		String line;
		this.csv = csv;
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

	public Map<String, Integer> getRecipientNames(int recipient, int amount)
	{
		Map<String, Integer> recipientsAndAmount = new TreeMap<String, Integer>();
		List<String> recipients = getDataString(recipient);
		List<Integer> amounts = getDataInt(amount);
		for (int i = 0; i < recipients.size() && i < amounts.size(); i++)
		{
			Integer addedAmount = amounts.get(i);
			if (!recipientsAndAmount.containsKey(recipients.get(i)))
			{
				recipientsAndAmount.put(recipients.get(i), addedAmount);
			}
			else
			{
				Integer existingAmount = recipientsAndAmount.get(recipients.get(i));
				recipientsAndAmount.put(recipients.get(i), addedAmount + existingAmount);
			}
		}
		return recipientsAndAmount;
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
	
	public void writeCSV(List<String> text, int columns)
	{
		PrintWriter pw = null;
		int counter = 0;
		try {
			pw = new PrintWriter(csv);
		}
		catch (FileNotFoundException e){
			System.err.println(e);
		}
		StringBuilder sb = new StringBuilder();
		sb.append("TEST1,TEST2\r\n"); //change so that instead of int columns theres another list for columns
		for (String string : text) {
			if (string.indexOf(',') == -1)
			{
				sb.append(string);
			}
			else
			{
				sb.append("\"");
				sb.append(string);
				sb.append("\"");
			}
			counter++;
			if (counter >= columns)
			{
				sb.append("\r\n");
				counter = 0;
				
			}
			else
			{
				sb.append(", ");
			}
		}
		pw.write(sb.toString());
		pw.close();
	}
}
