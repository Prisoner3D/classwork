package SimonTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import lab4_2.CSVUtilities;

public class BackEnd {
	private final static double DELAY = 0.4;
	private final static double DURATION = 0.8;

	public static void showSequence(Simon simon, ArrayList<Button> buttons) {
		for (int i = 1; i <= simon.getColors().size(); i++) {
			Color current = simon.getColors().get(i - 1);
			Timeline timeline;
			if (i == simon.getColors().size()) {
				timeline = new Timeline(new KeyFrame(Duration.seconds(i * DURATION), e -> {
					for (Button button : buttons) {
						if (button.getId().equals(current.toString())) {
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
				}));
				timeline.play();
			} else {
				timeline = new Timeline(new KeyFrame(Duration.seconds(i * DURATION), e -> {
					for (Button button : buttons) {
						if (button.getId().equals(current.toString())) {
							button.setDisable(false);
						}
						else {
							button.setDisable(true);
						}
					}
				}), new KeyFrame(Duration.seconds(i * DURATION + DELAY), e -> {
					for (Button button : buttons) {
						button.setDisable(true);
					}
				}));
				timeline.play();
			}
		}
	}
	
	public static void writeScores(Simon simon) throws FileNotFoundException, IOException {
		CSVUtilities csvutil = new CSVUtilities(new File("simon.csv"));
		List<String> scores = new ArrayList<String>();
		scores.add("Scores:");
		// BUG: util will collect names in column using int as temp
		scores.addAll(csvutil.getDataString(0));
		scores.add(simon.getScore()+"");
		csvutil.writeCSV(scores, 1);
		// Close csvutil?
	}
}
