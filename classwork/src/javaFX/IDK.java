package javaFX;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

public class IDK extends Application {
	private Stage primary;
	private Pane pane;
	private Button yesButton;
	private Group root = new Group();
	private Scene scene;
    @Override 
    public void start(Stage stage) {
        primary = stage;
        pane = new Pane();
        scene = new Scene(pane, 400, 300);
        
        yesButton = new Button("Yes");
        yesButton.setPrefSize(200,100); // Enlargens the button
        pane.getChildren().add(yesButton);
        
        primary.setTitle("Button Demo");
        primary.setScene(scene);
        primary.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}