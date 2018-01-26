package lab4_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Runner extends Application {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		/* RUN ONCE TO COMBINE DATA
		String fileLoc = "lab4_2.csv";
		ArrayList<String> test1 = new ArrayList<String>();
		CSVUtilities test = new CSVUtilities(new File(fileLoc));
		Map<String, Integer> map = test.getRecipientNames(4, 38);
		for (String integer : map.keySet()) {
			test1.add(integer);
			test1.add(map.get(integer).toString());
		}
		test.writeCSV(test1, 2);
		*/
		Application.launch(args);
	}

	@Override
    public void start(Stage stage) throws FileNotFoundException, IOException {
		String fileLoc = "lab4_2.csv";
		CSVUtilities test = new CSVUtilities(new File(fileLoc));
		List<String> recipients = test.getDataString(0);
		List<Double> amounts = test.getDataDouble(1);

        stage.setTitle("NYC Mayor Contribution Amounts");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = 
            new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("2013 Contributions");
        xAxis.setLabel("Recipients");       
        yAxis.setLabel("Amount");
 
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("2013");       
        for (int i = 0; i < recipients.size() && i < amounts.size(); i++) {
        	series1.getData().add(new XYChart.Data(recipients.get(i), amounts.get(i)));
        }
        
        Scene scene  = new Scene(bc,1600,900);
        bc.getData().addAll(series1);
        stage.setScene(scene);
        stage.show();
    }

}
