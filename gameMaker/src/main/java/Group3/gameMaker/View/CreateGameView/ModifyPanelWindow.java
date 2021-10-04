package Group3.gameMaker.View.CreateGameView;

import java.util.ArrayList;
import java.util.List;

import Group3.gameMaker.View.CreateGameView.Location.LayoutType;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import Group3.gameMaker.Constants.*;
import Group3.gameMaker.Sprite.Sprite;

public class ModifyPanelWindow 
{
	private Stage modifyStage;
	private CreateGameView createGameView;
	private TabPane tabPane;
	private Group root;
	private Scene scene;
	
	public ModifyPanelWindow(CreateGameView view, Stage panelStage)
	{
		modifyStage = panelStage;
		modifyStage.setHeight(Constants.CREATE_PANEL_HEIGHT);
		modifyStage.setWidth(Constants.MODIFY_PANEL_WIDTH);
		createGameView = view;
		root = new Group();
		scene = new Scene(root);
		modifyStage.setScene(scene);
		tabPane = new TabPane();
		Tab mainTab = new Tab("Sprite View");
		Tab collisionTab = new Tab("Custom Collisions");
		Tab eventTab = new Tab("Event Behavior Chain");
		tabPane.getTabs().addAll(mainTab, collisionTab, eventTab);
		root.getChildren().add(tabPane);
		tabPane.setMinHeight(modifyStage.getHeight());
		tabPane.setMinWidth(modifyStage.getWidth());
		tabPane.setLayoutX(Location.LeftLayout.controlPaneX);
		createBackground();
	}
	
	private void createBackground() 
	{
		Image backgroundImage = new Image("/Group3/gameMaker/Resource/deep_blue.png", 0, 0, false, false);
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
		tabPane.setBackground(new Background(background));
	}

	public void displaySprite(Sprite sprite) {
		// TODO Auto-generated method stub
		
	}

	public Stage getStage() 
	{
		return modifyStage;
	}
}