package Group3.gameMaker.View.CreateGameView;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.util.Duration;

public class SpaceRunnerSubScene extends SubScene{
	
	private final static String FONT_PATH = "/Group3/gameMaker/Resource/kenvector_future.ttf";
	private final static String BACKGROUND_IMAGE = "/Group3/gameMaker/Resource/red_panel.png";
	
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
		
		setLayoutX(1200);
		setLayoutY(200);
		
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
	}
	
	
	public AnchorPane getPane() {
		return (AnchorPane) this.getRoot();
	}

}
