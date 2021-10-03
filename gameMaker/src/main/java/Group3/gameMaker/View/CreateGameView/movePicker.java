package Group3.gameMaker.View.CreateGameView;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class movePicker extends VBox {

	private ImageView circleImage;
	private ImageView moveImage;
	
	private String circleNotChoosen = "/Group3/gameMaker/Resource/grey_circle.png";
	private String circleChoosen = "/Group3/gameMaker/Resource/red_choosen.png";
	
	private MOVEMENT move;
	
	private boolean isCircleChoosen;
	
	
	public movePicker(MOVEMENT move) {
		circleImage = new ImageView(circleNotChoosen);
		moveImage = new ImageView(move.getUrl());
		 
		this.move = move;
		isCircleChoosen = false;
		this.setAlignment(Pos.TOP_CENTER);
		this.setSpacing(10);
		this.getChildren().add(circleImage);
		this.getChildren().add(moveImage);
		
	}
	
	public MOVEMENT getmoves() {
		return move;
	}
	
	public boolean getCircleChoosen() {
		return isCircleChoosen;
	}
	
	public void setIsCircleChoosen(boolean isCircleChoosen) {
		this.isCircleChoosen = isCircleChoosen;
		String imageToSet = this.isCircleChoosen ? circleChoosen : circleNotChoosen;
		if (isCircleChoosen) {
			moveImage.setRotate(moveImage.getRotate() + 90);
		}
		
		circleImage.setImage(new Image(imageToSet));
	}
}
