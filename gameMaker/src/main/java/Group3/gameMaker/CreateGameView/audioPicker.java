package Group3.gameMaker.CreateGameView;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class audioPicker extends VBox {

	private ImageView circleImage;
	private ImageView audioImage;
	
	private String circleNotChoosen = "/Group3/gameMaker/Resource/grey_circle.png";
	private String circleChoosen = "/Group3/gameMaker/Resource/red_choosen.png";
	
	private AUDIO audio;
	
	private boolean isCircleChoosen;
	
	
	public audioPicker(AUDIO audio) {
		circleImage = new ImageView(circleNotChoosen);
		audioImage = new ImageView(audio.getUrl());
		 
		this.audio = audio;
		isCircleChoosen = false;
		this.setAlignment(Pos.TOP_CENTER);
		this.setSpacing(10);
		this.getChildren().add(circleImage);
		this.getChildren().add(audioImage);
		
	}
	
	public AUDIO getaudio() {
		return audio;
	}
	
	public boolean getCircleChoosen() {
		return isCircleChoosen;
	}
	
	public void setIsCircleChoosen(boolean isCircleChoosen) {
		this.isCircleChoosen = isCircleChoosen;
		String imageToSet = this.isCircleChoosen ? circleChoosen : circleNotChoosen;
		if (isCircleChoosen) {
			audioImage.setRotate(audioImage.getRotate() + 90);
		}
		
		circleImage.setImage(new Image(imageToSet));
	}
}

