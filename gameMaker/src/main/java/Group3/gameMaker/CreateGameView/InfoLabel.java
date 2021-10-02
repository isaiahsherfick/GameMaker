package Group3.gameMaker.CreateGameView;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class InfoLabel extends Label{
	
	public final static String FONT_PATH = "/Group3/gameMaker/Resource/kenvector_future.ttf";
	
	public final static String BACKGROUND_IMAGE = "/Group3/gameMaker/Resource/red_small_panel.png";
	
	
	public InfoLabel(String text) {
		
		setPrefWidth(200);
		setPrefHeight(30);
		setText(text);
		setWrapText(true);
		setLabelFont();
		setAlignment(Pos.CENTER);
		
		BackgroundImage backgroundImage = new BackgroundImage(new Image(BACKGROUND_IMAGE, 200, 30, false, true), BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, null);
		setBackground(new Background(backgroundImage));
	}
	
	private void setLabelFont() {
		
		Font font = Font.font("Courier New", FontWeight.BOLD, 17);
		this.setTextFill(Color.RED);
		this.setFont(font);
		
		//Font.font("Courier New", 25);
		
	}
	

}
