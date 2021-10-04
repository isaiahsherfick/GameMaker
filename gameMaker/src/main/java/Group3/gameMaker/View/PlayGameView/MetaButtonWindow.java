package Group3.gameMaker.View.PlayGameView;

import Group3.gameMaker.App;
import Group3.gameMaker.Constants.Constants;
import Group3.gameMaker.View.CreateGameView.Layable;
import Group3.gameMaker.View.CreateGameView.LayableButton;
import Group3.gameMaker.View.CreateGameView.Location;
import Group3.gameMaker.View.CreateGameView.Location.LayoutType;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MetaButtonWindow
{
	private Stage panelStage;
	private Pane controlPane;
	private PlayGameView playGameView;

	private Group root;
	private Scene scene;
	
	MetaButtonWindow(PlayGameView playGameView, Stage panelStage)
	{
		this.panelStage = panelStage;
		panelStage.setHeight(Constants.CREATE_PANEL_HEIGHT);
		panelStage.setWidth(Constants.CREATE_PANEL_WIDTH);
		this.playGameView = playGameView;
		root = new Group();
		scene = new Scene(root);
		panelStage.setScene(scene);
		controlPane =  new Pane();
		root.getChildren().add(controlPane);
		controlPane.setMinHeight(panelStage.getHeight());
		controlPane.setMinWidth(panelStage.getWidth());
		controlPane.setLayoutX(Location.LeftLayout.controlPaneX);
		createBackground();
	}

	private void createBackground() 
	{
		Image backgroundImage = new Image("/Group3/gameMaker/Resource/deep_blue.png", 0, 0, false, false);
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
		controlPane.setBackground(new Background(background));
	}

	public void createButtons () 
	{

		int index = 0;
		final LayableButton backToCreatorButton = new LayableButton("Back to Creator");
		backToCreatorButton.setLayoutX(Constants.MENU_BUTTON_START_X);
		backToCreatorButton.setLayoutY(Constants.MENU_BUTTON_START_Y);
		backToCreatorButton.setOnAction(e -> {
			playGameView.switchContexts();
		});
		index++;


		final LayableButton pauseButton = new LayableButton("Pause");
		pauseButton.setLayoutX(Constants.MENU_BUTTON_START_X);
		pauseButton.setLayoutY(Constants.MENU_BUTTON_START_Y + (index * (Constants.LAYABLE_BUTTON_PADDING + Constants.LAYABLE_BUTTON_HEIGHT)));
		pauseButton.setOnAction(e -> {
			playGameView.pause();
		});
		index++;

		final LayableButton unpauseButton = new LayableButton("Unpause");
		//AddMenuButtons( eventbutton);
		unpauseButton.setLayoutX(Constants.MENU_BUTTON_START_X);
		unpauseButton.setLayoutY(Constants.MENU_BUTTON_START_Y + (index * (Constants.LAYABLE_BUTTON_PADDING + Constants.LAYABLE_BUTTON_HEIGHT)));
		unpauseButton.setOnAction(e -> {
			playGameView.unpause();
		});
		index++;

		addButtonToControlPanel(backToCreatorButton);
		addButtonToControlPanel(pauseButton);
		addButtonToControlPanel(unpauseButton);
	}
	

	public void addButtonToControlPanel(LayableButton button) {
		controlPane.getChildren().add(button);
	}

	public void changeLayout(LayoutType layout, int parentX, int parentY, int index) {
		createBackground();
//		for (Layable lay : layables) {
//			 lay.changeLayout(LayoutType.LEFT, parentX, parentY, index);
//			index++;
//		}
	}
}
