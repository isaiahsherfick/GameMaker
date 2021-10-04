package Group3.gameMaker.View.CreateGameView;

import javafx.animation.TranslateTransition;

import java.nio.file.Paths;
import java.util.ArrayList;

import Group3.gameMaker.Constants.*;
import Group3.gameMaker.Sprite.Sound;
import Group3.gameMaker.View.CreateGameView.Location.LayoutType;
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


	private final static String FONT_PATH = "/Group3/gameMaker/Resource/kenvector_future.ttf";
	private final static String BACKGROUND_IMAGE = "/Group3/gameMaker/Resource/red_panel.png";
	private final static String WHOOSH_IN_SOUND_PATH = "src/main/resources/mixkit-arrow-whoosh-1491.wav";
	private final static String WHOOSH_OUT_SOUND_PATH = "src/main/resources/mixkit-electric-whoosh-2596.wav";
	private  boolean isHidden;


	public SpaceRunnerSubScene() {
		super(new AnchorPane(), Constants.ADD_SPRITE_SUBSCENE_WIDTH, Constants.ADD_SPRITE_SUBSCENE_HEIGHT);
		prefWidth(Constants.ADD_SPRITE_SUBSCENE_WIDTH);
		prefHeight(Constants.ADD_SPRITE_SUBSCENE_HEIGHT);

		BackgroundImage image = new BackgroundImage(new Image(BACKGROUND_IMAGE, Constants.ADD_SPRITE_SUBSCENE_WIDTH, Constants.ADD_SPRITE_SUBSCENE_HEIGHT, false, true),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);

		AnchorPane root2 = (AnchorPane) this.getRoot();
		root2.setBackground(new Background(image));

		isHidden = true ;

		setLayoutX(Constants.ADD_SPRITE_SUBSCENE_SOURCE_X);
		setLayoutY(Constants.ADD_SPRITE_SUBSCENE_SOURCE_Y);

	}

	public void moveInSubScene() {
		TranslateTransition transition = new TranslateTransition();
		transition.setDuration(Duration.seconds(0.3));
		transition.setNode(this);

		if (isHidden) {
			isHidden = false;

			transition.setToX(Constants.ADD_SPRITE_SUBSCENE_DEST_X);
			transition.setToY(Constants.ADD_SPRITE_SUBSCENE_DEST_Y);
			transition.play();
		}
		Sound sound = new Sound(WHOOSH_IN_SOUND_PATH);
		try {
			sound.play();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void moveOutSubScene() {
		TranslateTransition transition = new TranslateTransition();
		transition.setDuration(Duration.seconds(0.3));
		transition.setNode(this);

		if (!isHidden) {
			isHidden = true ;
			transition.setToX(Constants.ADD_SPRITE_SUBSCENE_SOURCE_X);
			transition.setToY(Constants.ADD_SPRITE_SUBSCENE_SOURCE_Y);
			transition.play();
		}

		Sound sound = new Sound(WHOOSH_OUT_SOUND_PATH);
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
