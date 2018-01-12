package SimonTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.util.Duration;

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
}
