package SimonTest;

import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SimonSays extends Application  {
    @Override
    public void start(Stage primaryStage) throws Exception {
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

		Button red = new Button("red");
		red.setId(Color.RED.toString());
		red.setEffect(borderGlow);
		
		Button blue = new Button("blue");
		blue.setId(Color.BLUE.toString());
		blue.setEffect(borderGlow2);
		
		Button green = new Button("green");
		green.setId(Color.GREEN.toString());
		green.setEffect(borderGlow3);
		
		Button yellow = new Button("yellow");
		yellow.setId(Color.YELLOW.toString());
		yellow.setEffect(borderGlow4);

		ArrayList<Button> buttons = new ArrayList<Button>();
		buttons.add(red);
		buttons.add(green);
		buttons.add(blue);
		buttons.add(yellow);

		HBox hbox1 = new HBox(25);
		VBox vbox = new VBox(25);
		VBox vbox2 = new VBox(25);
		
		hbox1.setPrefHeight(50);
		
		vbox2.setPrefWidth(50);
		vbox.setPrefWidth(50);
		
		vbox2.setMaxHeight(Double.MAX_VALUE);
		blue.setMaxHeight(Double.MAX_VALUE);
		green.setMaxHeight(Double.MAX_VALUE);
		yellow.setMaxHeight(Double.MAX_VALUE);
		red.setMaxWidth(Double.MAX_VALUE);
		blue.setMaxWidth(Double.MAX_VALUE);
		green.setMaxWidth(Double.MAX_VALUE);
		yellow.setMaxWidth(Double.MAX_VALUE);
		
		hbox1.getChildren().add(vbox);
		hbox1.getChildren().add(vbox2);
		hbox1.setAlignment(Pos.CENTER);
		
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().add(red);
		vbox.getChildren().add(blue);
		vbox2.setAlignment(Pos.CENTER);
		vbox2.getChildren().add(green);
		vbox2.getChildren().add(yellow);
		
		Methods.showSequence(simon, buttons);
		
		red.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("red test!");
				int status = simon.updateMove(Color.RED);
				if (status == 0) {
					borderGlow.setHeight(0);
					System.out.println("you got " + simon.getScore());
					for (Button button : buttons) {
						button.setDisable(true);
					}
				}
				if (status == 2) {
					for (Button button : buttons) {
						button.setDisable(true);
					}
					Methods.showSequence(simon, buttons);
				}
			}
		});
		blue.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("blue test!");
				int status = simon.updateMove(Color.BLUE);
				if (status == 0) {
					System.out.println("you got " + simon.getScore());
					for (Button button : buttons) {
						button.setDisable(true);
					}
				}
				if (status == 2) {
					for (Button button : buttons) {
						button.setDisable(true);
					}
					Methods.showSequence(simon, buttons);
				}
			}
		});
		green.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("green test!");
				int status = simon.updateMove(Color.GREEN);
				if (status == 0) {
					System.out.println("you got " + simon.getScore());
					for (Button button : buttons) {
						button.setDisable(true);
					}
				}
				if (status == 2) {
					for (Button button : buttons) {
						button.setDisable(true);
					}
					Methods.showSequence(simon, buttons);
				}
			}
		});
		yellow.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("yellow test!");
				int status = simon.updateMove(Color.YELLOW);
				if (status == 0) {
					System.out.println("you got " + simon.getScore());
					for (Button button : buttons) {
						button.setDisable(true);
					}
				}
				if (status == 2) {
					for (Button button : buttons) {
						button.setDisable(true);
					}
					Methods.showSequence(simon, buttons);
				}
			}
		});
        Scene scene = new Scene(hbox1, 400, 400);
        //scene.getStylesheets().add("file:///C://Users//BT_1N3_20//eclipse-workspace//javafx//b.css"); //change
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
