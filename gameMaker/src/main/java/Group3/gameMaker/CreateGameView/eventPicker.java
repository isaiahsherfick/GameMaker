package Group3.gameMaker.CreateGameView;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class eventPicker extends VBox {

	private ImageView circleImage;
	private ImageView eventImage;
	
	private String circleNotChoosen = "/Group3/gameMaker/Resource/grey_circle.png";
	private String circleChoosen = "/Group3/gameMaker/Resource/red_choosen.png";
	
	private EVENT event;
	
	private boolean isCircleChoosen;
	
	
	public eventPicker(EVENT event) {
		circleImage = new ImageView(circleNotChoosen);
		eventImage = new ImageView(event.getUrl());
		 
		this.event = event;
		isCircleChoosen = false;
		this.setAlignment(Pos.TOP_CENTER);
		this.setSpacing(10);
		this.getChildren().add(circleImage);
		this.getChildren().add(eventImage);
		
	}
	
	public EVENT getevents() {
		return event;
	}
	
	public boolean getCircleChoosen() {
		return isCircleChoosen;
	}
	
	public void setIsCircleChoosen(boolean isCircleChoosen) {
		this.isCircleChoosen = isCircleChoosen;
		String imageToSet = this.isCircleChoosen ? circleChoosen : circleNotChoosen;
		if (isCircleChoosen) {
			eventImage.setRotate(eventImage.getRotate() + 90);
		}
		
		circleImage.setImage(new Image(imageToSet));
	}
}

