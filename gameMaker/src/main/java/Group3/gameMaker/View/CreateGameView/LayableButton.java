
//    Created by: Snehal Patare
//    Created on: 22 Sep 2021
//     Edited by:
//Edited last by: Snehal Patare

package Group3.gameMaker.View.CreateGameView;

import Group3.gameMaker.Constants.Constants;
import Group3.gameMaker.View.CreateGameView.Location.LayoutType;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LayableButton extends Button implements Layable {

	private final String FONT_PATH = "/Group3/gameMaker/Resource/kenvector_future.ttf";
	private final String BUTTON_PRESSED_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/Group3/gameMaker/Resource/red_button_pressed.png');";
	private final String BUTTON_FREE_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/Group3/gameMaker/Resource/red_button.png');";


		public LayableButton(String text) {
//			super(label);
//			adjustStyle();

			setText(text);
			setButtonFont();
			setPrefWidth(Constants.LAYABLE_BUTTON_WIDTH);
			setPrefHeight(Constants.LAYABLE_BUTTON_HEIGHT);
			setStyle(BUTTON_FREE_STYLE);
			initializeButtonListeners();

		}

private void setButtonFont() {

			Font font = Font.font("Courier New", FontWeight.BOLD, 17);
			this.setFont(font);

		}

		private void setButtonPressedStyle() {
			setStyle(BUTTON_PRESSED_STYLE);
			setPrefHeight(Constants.LAYABLE_BUTTON_HEIGHT_ON_PRESS);
			setLayoutY(getLayoutY() + 4);

		}

		private void setButtonReleasedStyle() {
			setStyle(BUTTON_FREE_STYLE);
			setPrefHeight(Constants.LAYABLE_BUTTON_HEIGHT);
			setLayoutY(getLayoutY() - 4);

		}

		private void initializeButtonListeners() {

			setOnMousePressed(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					if(event.getButton().equals(MouseButton.PRIMARY)) {
						setButtonPressedStyle();
					}

				}
			});

			setOnMouseReleased(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					if(event.getButton().equals(MouseButton.PRIMARY)) {
						setButtonReleasedStyle();
					}

				}
			});

			setOnMouseEntered(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					setEffect(new DropShadow());

				}
			});

			setOnMouseExited(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					setEffect(null);

				}
			});


		}

//		private void adjustStyle() {
//			this.setStyle("-fx-background-color: #" + "a0344e" + "; -fx-background-radius: 15px;"
//					+ "-fx-font-weight: bold; -fx-text-fill: fefae0;");
//			this.setPrefSize(90, 30);
//			this.setWrapText(true);
//
//			Font font = Font.font("Courier New", 14);
//			this.setFont(font);
//		}


		public void changeLayout(LayoutType layout, int parentX, int parentY, int index) {
			switch (layout) {
			case LEFT:
			case RIGHT:
				setLayoutX(parentX + Constants.LAYABLE_BUTTON_MARGIN + Constants.LAYABLE_BUTTON_PADDING);
				setLayoutY(parentY + Constants.LAYABLE_BUTTON_MARGIN + (index * (Constants.LAYABLE_BUTTON_PADDING + Constants.LAYABLE_BUTTON_HEIGHT)));
				break;
			case TOP:
			case BOTTOM:
				setLayoutX(parentX + Constants.LAYABLE_BUTTON_MARGIN + (index * (Constants.LAYABLE_BUTTON_PADDING + Constants.LAYABLE_BUTTON_WIDTH)));
				setLayoutY(parentY + Constants.LAYABLE_BUTTON_MARGIN + Constants.LAYABLE_BUTTON_PADDING);
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
