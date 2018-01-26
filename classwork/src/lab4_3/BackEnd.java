package lab4_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import lab4_2.CSVUtilities;

public class BackEnd {
	private final static double DELAY = 0.4;
	private final static double DURATION = 0.6;

	public static void showSequence(Simon simon, ArrayList<Button> buttons) {
		simon.setChanging(true); // DISABLES CLICKING
		for (int i = 1; i <= simon.getColors().size(); i++) {
			Color current = simon.getColors().get(i - 1);
			Timeline timeline;
			if (i == simon.getColors().size()) { // LAST LIGHTUP
				timeline = new Timeline(new KeyFrame(Duration.seconds(i * DURATION), e -> {
					for (Button button : buttons) {
						if (button.getId().equals("b" + current.toString())) {
							button.setDisable(false);
						}
						else {
							button.setDisable(true);
						}
					}
				}), new KeyFrame(Duration.seconds((i * DURATION) + DELAY), e -> {
					for (Button button : buttons) {
						button.setDisable(true);
					}
				}), new KeyFrame(Duration.seconds((i * DURATION) + DELAY + DELAY), e -> {
					for (Button button : buttons) {
						button.setDisable(false);
					}
					simon.setChanging(false); // ENABLES CLICKING AGAIN
				}));
				timeline.play();
			} else {
				timeline = new Timeline(new KeyFrame(Duration.seconds(i * DURATION), e -> {
					for (Button button : buttons) {
						if (button.getId().equals("b" + current.toString())) {
							button.setDisable(false);
						}
						else {
							button.setDisable(true);
						}
					}
				}), new KeyFrame(Duration.seconds((i * DURATION) + DELAY), e -> {
					for (Button button : buttons) {
						button.setDisable(true);
					}
				}));
				timeline.play();
			}
		}
	}
	
	public static List<String> writeScores(Simon simon, String name, TextArea textArea) throws FileNotFoundException, IOException {
		// CSV is stored /classwork
		CSVUtilities csvutil = new CSVUtilities(new File("simon.csv"));
		// getClass().getResourceAsStream("Simon.csv")
		List<String> scores = new ArrayList<String>();
		// scores.add("Name,Score");
		// Add regex? 
		scores.addAll(csvutil.getData());
		scores.add(name);
		scores.add(simon.getScore() + "");
		csvutil.writeCSV(scores);
		int i = 0;
		StringBuilder textAreaScores = new StringBuilder();
		textAreaScores.append("You lost! Your score was " + simon.getScore() + ". Below are all of the scores. \r\n");
		for (String entry : scores) {
			textAreaScores.append(entry);
			if (i % 2 == 0) {
				textAreaScores.append(" : ");
			}
			else {
				textAreaScores.append("\r\n");
			}
			i++;
		}
		textArea.setText(textAreaScores.toString());
		return scores;
		// Close csvutil?
	}
}
