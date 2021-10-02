package Group3.gameMaker.CreateGameView;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class ShapePicker extends VBox {

	private ImageView circleImage;
	private ImageView shapeImage;
	
	private String circleNotChoosen = "/Group3/gameMaker/Resource/grey_circle.png";
	private String circleChoosen = "/Group3/gameMaker/Resource/red_choosen.png";
	
	private SHAPE shape;
	
	private boolean isCircleChoosen;
	
	
	public ShapePicker(SHAPE shape) {
		circleImage = new ImageView(circleNotChoosen);
		shapeImage = new ImageView(shape.getUrl());
		 
		this.shape = shape;
		isCircleChoosen = false;
		this.setAlignment(Pos.TOP_CENTER);
		this.setSpacing(10);
		this.getChildren().add(circleImage);
		this.getChildren().add(shapeImage);
		
	}
	
	public SHAPE getShapes() {
		return shape;
	}
	
	public boolean getCircleChoosen() {
		return isCircleChoosen;
	}
	
	public void setIsCircleChoosen(boolean isCircleChoosen) {
		this.isCircleChoosen = isCircleChoosen;
		String imageToSet = this.isCircleChoosen ? circleChoosen : circleNotChoosen;
		if (isCircleChoosen) {
			shapeImage.setRotate(shapeImage.getRotate() + 90);
		}
		
		circleImage.setImage(new Image(imageToSet));
	}
}
