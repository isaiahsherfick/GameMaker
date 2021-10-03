package Group3.gameMaker.View.CreateGameView;

import javafx.animation.TranslateTransition;

import java.nio.file.Paths;

import Group3.gameMaker.Constants.*;
import Group3.gameMaker.Sprite.Sound;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.util.Duration;

// TODO pull constants to Constants class
public class SpaceRunnerSubScene extends SubScene {

	private final static String FONT_PATH = "fonts/kenvector_future.ttf";
	private final static String BACKGROUND_IMAGE = "backgrounds/red_panel.png";
	private final static String WHOOSH_SOUND_PATH = "mixkit-arrow-whoosh-1491.wav";

	private  boolean isHidden;


	public SpaceRunnerSubScene() {
		super(new AnchorPane(), 400, 275);
		prefWidth(400);
		prefHeight(275);

		BackgroundImage image = new BackgroundImage(new Image(BACKGROUND_IMAGE, 400, 275, false, true),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);

		AnchorPane root2 = (AnchorPane) this.getRoot();
		root2.setBackground(new Background(image));

		isHidden = true ;

		setLayoutX(Constants.ANIMATION_START_X);
		setLayoutY(Constants.ANIMATION_START_Y);

	}

	public void moveSubScene() {
		TranslateTransition transition = new TranslateTransition();
		transition.setDuration(Duration.seconds(0.3));
		transition.setNode(this);

		if (isHidden) {

			transition.setToX(-1150);
			transition.setToY(200);
			isHidden = false;

		} else {

			transition.setToX(0);
			transition.setToY(0);
			isHidden = true ;
		}


		transition.play();
		Sound sound = new Sound(Paths.get(WHOOSH_SOUND_PATH).toUri().toString());
		try {
			sound.play();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void moveSubScene2() {
		TranslateTransition transition = new TranslateTransition();
		transition.setDuration(Duration.seconds(0.3));
		transition.setNode(this);

		if (isHidden) {

			transition.setToX(-1150);
			transition.setToY(0);
			isHidden = false;

		} else {

			transition.setToX(0);
			transition.setToY(0);
			isHidden = true ;
		}


		transition.play();
		Sound sound = new Sound(Paths.get(WHOOSH_SOUND_PATH).toUri().toString());
		try {
			sound.play();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public AnchorPane getPane() {
		return (AnchorPane) this.getRoot();
	}

}
