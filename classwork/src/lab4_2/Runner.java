package lab4_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Runner {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String fileLoc = "subway.csv";
		CSVUtilities test = new CSVUtilities(new File(fileLoc));
		List<String> columns = test.getDataString(5);
		for (String integer : columns) {
			System.out.println(integer);
		}
	}

}
