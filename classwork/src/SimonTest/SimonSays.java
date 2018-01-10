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
		borderGlow.setWidth(100);
		borderGlow.setHeight(100);

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

		Button red = new Button("red");
		red.setId(Color.RED.toString());
		red.setEffect(borderGlow);
		Button blue = new Button("blue");
		blue.setId("blue");
		blue.setEffect(borderGlow2);
		Button green = new Button("green");
		green.setId("green");
		green.setEffect(borderGlow3);

		ArrayList<Button> buttons = new ArrayList<Button>();
		buttons.add(red);
		buttons.add(green);
		buttons.add(blue);

		VBox vbox = new VBox(50);
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().add(red);
		vbox.getChildren().add(blue);
		vbox.getChildren().add(green);
		
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
        Scene scene = new Scene(vbox, 400, 400);
        //scene.getStylesheets().add("file:///C://Users//BT_1N3_20//eclipse-workspace//javafx//b.css"); //change
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
