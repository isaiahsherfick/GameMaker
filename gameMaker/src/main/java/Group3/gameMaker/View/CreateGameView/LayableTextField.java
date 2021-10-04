package Group3.gameMaker.View.CreateGameView;

import Group3.gameMaker.View.CreateGameView.Location.LayoutType;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

public class LayableTextField extends TextField implements Layable {

	public LayableTextField() {
		super();
		adjustStyle();
	}

	private void adjustStyle() {
		this.setStyle("-fx-background-color: #" + "a0344e" + "; -fx-background-radius: 15px;"
				+ "-fx-font-weight: bold; -fx-text-fill: fefae0;");
		this.setPrefSize(90, 30);
		//this.setWrapText(true);

		Font font = Font.font("Courier New", 14);
		this.setFont(font);
	}

	@Override
	public void changeLayout(LayoutType layout, int parentX, int parentY, int index) {
		switch (layout) {
		case LEFT:
		case RIGHT:
			setLayoutX(parentX + 30);
			setLayoutY(parentY + 40 + (index * 45));
			break;
		case TOP:
		case BOTTOM:
			setLayoutX(parentX + 40 + (index * 140));
			setLayoutY(parentY + 30);
			break;
		}
	}



	@Override
	public void addLayable(Layable layable) {
		// nothing
	}

	@Override
	public void removeLayable(Layable layable) {
		// nothing
	}


}
