package SimonTest;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class TEST extends Application  {
	private ArrayList<String> colors = new ArrayList<String>();
	
	
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("HBox Experiment 1");
        colors.add("red");

        Button red = new Button("red");
        Button blue = new Button("blue");
        Button green = new Button("green");
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.BOTTOM_CENTER);
        vbox.getChildren().add(red);
        vbox.getChildren().add(blue);
        vbox.getChildren().add(green);
        red.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("red test!");
                int status = Methods.updateMove("red", colors);
                if (status == 0)
                {
                	red.setDisable(true);
                    blue.setDisable(true);
                    green.setDisable(true);
                }
                //rather calls functions which diables all buttons
            }
        });
        blue.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("blue test!");
                red.setDisable(true);
                blue.setDisable(true);
                green.setDisable(true);
                //rather calls functions which diables all buttons
            }
        });
        green.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("green test!");
                red.setDisable(true);
                blue.setDisable(true);
                green.setDisable(true);
                //rather calls functions which diables all buttons
            }
        });
        Scene scene = new Scene(vbox, 200, 100);
        scene.getStylesheets().add("file:///C://Users//BT_1N3_20//eclipse-workspace//javafx//b.css"); //change
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
