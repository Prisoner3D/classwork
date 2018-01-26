package lab4_3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SimonSaysRunner extends Application  {
	
    private static String name;

	@Override
    public void start(Stage primaryStage) throws Exception {
    	//System.out.println(Color.RED.toString());
    	//System.out.println(Color.BLUE.toString());
    	//System.out.println(Color.GREEN.toString());
    	//System.out.println(Color.YELLOW.toString());
    	
    	// add you lose and score
    	
    	// Change so that buttons dont glow when they dont need to
    	// Add desc
    	// Fix csv
    	// Add box where user adds name
    	
		primaryStage.setTitle("Simon Says...");
		Simon simon = new Simon();

		DropShadow borderGlow = new DropShadow();
		borderGlow.setOffsetY(0f);
		borderGlow.setOffsetX(0f);
		borderGlow.setColor(Color.RED);
		borderGlow.setWidth(50);
		borderGlow.setHeight(50);

		DropShadow borderGlow2 = new DropShadow();
		borderGlow2.setOffsetY(0f);
		borderGlow2.setOffsetX(0f);
		borderGlow2.setColor(Color.BLUE);
		borderGlow2.setWidth(50);
		borderGlow2.setHeight(50);

		DropShadow borderGlow3 = new DropShadow();
		borderGlow3.setOffsetY(0f);
		borderGlow3.setOffsetX(0f);
		borderGlow3.setColor(Color.GREEN);
		borderGlow3.setWidth(50);
		borderGlow3.setHeight(50);
		
		DropShadow borderGlow4 = new DropShadow();
		borderGlow4.setOffsetY(0f);
		borderGlow4.setOffsetX(0f);
		borderGlow4.setColor(Color.YELLOW);
		borderGlow4.setWidth(50);
		borderGlow4.setHeight(50);

		Button start = new Button("START");
		
		Button red = new Button("Red");
		red.setId("b" + Color.RED.toString());
		red.setEffect(borderGlow);
		red.setDisable(true);
		
		Button blue = new Button("Blue");
		blue.setId("b" + Color.BLUE.toString());
		blue.setEffect(borderGlow2);
		blue.setDisable(true);
		
		Button green = new Button("Green");
		green.setId("b" + Color.GREEN.toString());
		green.setEffect(borderGlow3);
		green.setDisable(true);
		
		Button yellow = new Button("Yellow");
		yellow.setId("b" + Color.YELLOW.toString());
		yellow.setEffect(borderGlow4);
		yellow.setDisable(true);

		ArrayList<Button> buttons = new ArrayList<Button>();
		buttons.add(red);
		buttons.add(green);
		buttons.add(blue);
		buttons.add(yellow);

		HBox startContainer = new HBox(100);
		
		VBox main = new VBox(100);
		
		HBox hbox1 = new HBox(100);
		VBox vbox = new VBox(75);
		VBox vbox2 = new VBox(75);
		
		startContainer.setPrefHeight(200);
		hbox1.setPrefHeight(200);
		
		vbox2.setPrefWidth(200);
		vbox.setPrefWidth(200);
		
		vbox2.setPrefHeight(Double.MAX_VALUE);
		
		red.setMaxHeight(0);
		blue.setMaxHeight(Double.MAX_VALUE);
		green.setMaxHeight(Double.MAX_VALUE);
		yellow.setMaxHeight(Double.MAX_VALUE);
		red.setMaxWidth(Double.MAX_VALUE);
		blue.setMaxWidth(Double.MAX_VALUE);
		green.setMaxWidth(Double.MAX_VALUE);
		yellow.setMaxWidth(Double.MAX_VALUE);
		
		startContainer.getChildren().add(start);
		startContainer.setAlignment(Pos.CENTER);
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().add(red);
		vbox.getChildren().add(blue);
		vbox2.setAlignment(Pos.CENTER);
		vbox2.getChildren().add(green);
		vbox2.getChildren().add(yellow);
		hbox1.getChildren().add(startContainer);
		hbox1.getChildren().add(vbox);
		hbox1.getChildren().add(vbox2);
		hbox1.setAlignment(Pos.CENTER);
		
		// Text t = new Text (10, 20, "Hey " + name + "! Welcome to Simon Says! Press the buttons in the order that they blink up!");
		TextArea textArea = new TextArea();
		textArea.setPrefRowCount(3);
		textArea.setPrefColumnCount(100);
		textArea.setText("Hey " + name + "! Welcome to Simon Says! Press the buttons in the order that they blink up!");

		start.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				start.setDisable(true);
				BackEnd.showSequence(simon, buttons);
				red.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						//System.out.println("You pressed Red!");
						int status = simon.updateMove(Color.RED);
						if (status == 0) {
							//System.out.println("end game");
							try {
								BackEnd.writeScores(simon, name, textArea);
							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							for (Button button : buttons) {
								button.setDisable(true);
							}
						}
						if (status == 2) {
							for (Button button : buttons) {
								button.setDisable(true);
							}
							BackEnd.showSequence(simon, buttons);
						}
					}
				});
				blue.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						//System.out.println("You pressed Blue!");
						int status = simon.updateMove(Color.BLUE);
						if (status == 0) {
							//System.out.println("end game");
							try {
								BackEnd.writeScores(simon, name, textArea);
							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							for (Button button : buttons) {
								button.setDisable(true);
							}
						}
						if (status == 2) {
							for (Button button : buttons) {
								button.setDisable(true);
							}
							BackEnd.showSequence(simon, buttons);
						}
					}
				});
				green.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						//System.out.println("You pressed Green!");
						int status = simon.updateMove(Color.GREEN);
						if (status == 0) {
							//System.out.println("end game");
							try {
								BackEnd.writeScores(simon, name, textArea);
							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							for (Button button : buttons) {
								button.setDisable(true);
							}
						}
						if (status == 2) {
							for (Button button : buttons) {
								button.setDisable(true);
							}
							BackEnd.showSequence(simon, buttons);
						}
					}
				});
				yellow.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						//System.out.println("You pressed Yellow!");
						int status = simon.updateMove(Color.YELLOW);
						if (status == 0) {
							//System.out.println("end game");
							try {
								BackEnd.writeScores(simon, name, textArea);
							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							for (Button button : buttons) {
								button.setDisable(true);
							}
						}
						if (status == 2) {
							for (Button button : buttons) {
								button.setDisable(true);
							}
							BackEnd.showSequence(simon, buttons);
						}
					}
				});
			}
		});
		
		
		//main.getChildren().add(t);
		main.getChildren().add(textArea);
		main.getChildren().add(hbox1);
        Scene scene = new Scene(main, 800, 500);
        scene.getStylesheets().add(getClass().getResource("css\\simon.css").toExternalForm()); // CSS
        Image applicationIcon = new Image(getClass().getResourceAsStream("img\\icon.jpg")); // ICON
        primaryStage.getIcons().add(applicationIcon);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
    	System.out.println("What is your name?");
    	Scanner in = new Scanner(System.in);
    	name = in.nextLine();
        Application.launch(args);
        in.close();
    }
}
