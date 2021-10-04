package Group3.gameMaker.View.CreateGameView;

import java.util.ArrayList;
import java.util.List;

import Group3.gameMaker.Constants.Constants;
import Group3.gameMaker.Sprite.Sprite;
import Group3.gameMaker.View.CreateGameView.Location.LayoutType;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CreatePanelWindow implements Layable {

	private Stage panelStage;
	private ArrayList<Layable> layables;

	public Group rootGroup;

	private SpaceRunnerSubScene addSpriteSubScene;
	private CreateGameView createGameView;

	List<ShapePicker> shapesList;
	private Shape chosenShape = null;

	public LayablePane controlPane;
	public Scene gameScene;


	// Accessible only within the CreateGameView package
	CreatePanelWindow(CreateGameView createGameView, Stage panelStage) {
		this.panelStage = panelStage;
		layables = new ArrayList<Layable>();
		panelStage.setHeight(Constants.CREATE_PANEL_HEIGHT);
		panelStage.setWidth(Constants.CREATE_PANEL_WIDTH);
		panelStage.setMaxHeight(Constants.VISUAL_HEIGHT);
		this.createGameView = createGameView;
//		panelStage.setMaxWidth(Constants.CREATE_PANEL_WIDTH);
//		panelStage.setMaxHeight(Constants.CREATE_PANEL_HEIGHT);
//		panelStage.setX(Constants.CREATE_PANEL_X);
//		panelStage.setY(Constants.CREATE_PANEL_Y);
	}

	public void makeStage () {
		Group rootGroup = new Group();

		controlPane = new LayablePane();
		layables.add(controlPane);

		rootGroup.getChildren().add(controlPane);
//		controlPane.setMaxWidth(Constants.CREATE_PANEL_WIDTH);
//		controlPane.setMaxHeight(Constants.CREATE_PANEL_HEIGHT);
		controlPane.setMinHeight(panelStage.getHeight());
		controlPane.setLayoutX(Location.LeftLayout.controlPaneX);
		createBackground();


//		BorderPane.setAlignment(controlPane,Pos.CENTER_LEFT);

		gameScene = new Scene(rootGroup, Constants.CREATE_PANEL_WIDTH, Constants.CREATE_PANEL_HEIGHT);
		panelStage.setScene(gameScene);
	}




	private void createBackground() {
		Image backgroundImage = new Image("/Group3/gameMaker/Resource/deep_blue.png", 256, 256, false, false);
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
		controlPane.setBackground(new Background(background));
	}

	private void startAddSpriteSubScene() {
		addSpriteSubScene = new SpaceRunnerSubScene();
		controlPane.getChildren().add(addSpriteSubScene);

		InfoLabel chooseShapeLabel = new InfoLabel("Drag Sprite Shape");
		chooseShapeLabel.setLayoutX((chooseShapeLabel.getWidth())); //110
		chooseShapeLabel.setLayoutY(25);
		addSpriteSubScene.getPane().getChildren().add(chooseShapeLabel);
		addSpriteSubScene.getPane().getChildren().add(createShapesToChoose());
	}

	private HBox createShapesToChoose() {
		HBox box = new HBox();
		box.setSpacing(60);
		shapesList = new ArrayList<>();
		for (Shape shape : Shape.values()) {
			final ShapePicker shapeToPick = new ShapePicker(shape);
			shapesList.add(shapeToPick);
			box.getChildren().add(shapeToPick);
			shapeToPick.setOnMouseClicked(e -> {
				for (ShapePicker s : shapesList) {
					s.setIsCircleChoosen(false);
				}
				shapeToPick.setIsCircleChoosen(true);
				chosenShape = shapeToPick.getShapes();
			});
		}

		box.setLayoutX(300 - (118*2));
		box.setLayoutY(100);
		return box;
	}


	public void createButtons () {

		final LayableButton spriteButton = new LayableButton("New Sprite");
		spriteButton.setLayoutX(Constants.MENU_BUTTON_START_X);
		spriteButton.setLayoutY(Constants.MENU_BUTTON_START_Y);
		spriteButton.setOnAction(e -> {
			startAddSpriteSubScene();
			showSubScene(addSpriteSubScene);
			createGameView.createSprite();
		});


		final LayableButton saveButton = new LayableButton("Save");
		saveButton.setLayoutX(Constants.MENU_BUTTON_START_X);
		saveButton.setLayoutY(Constants.MENU_BUTTON_START_Y+70);
		saveButton.setOnAction(e -> {
			// TODO: Save to file here
		});

		final LayableButton loadButton = new LayableButton("Load");
		//AddMenuButtons( eventbutton);
		loadButton.setLayoutX(Constants.MENU_BUTTON_START_X);
		loadButton.setLayoutY(Constants.MENU_BUTTON_START_Y+140);
		loadButton.setOnAction(e -> {
			// TODO: Load from file here
		});

		final LayableButton playGameButton = new LayableButton("Play Game");
		playGameButton.setLayoutX(Constants.MENU_BUTTON_START_X);
		playGameButton.setLayoutY(Constants.MENU_BUTTON_START_Y+210);
		playGameButton.setOnAction(e -> {
			// TODO: switch context from create game to play game here.
		});

		addButtonToControlPanel(spriteButton);
		addButtonToControlPanel(saveButton);
		addButtonToControlPanel(loadButton);
		addButtonToControlPanel(playGameButton);
		changeLayout(LayoutType.LEFT, 0, 0, 0);


	}

	private void showSubScene(SpaceRunnerSubScene subScene) {
		if (subScene!=null) {
			subScene.setVisible(true);
			subScene.moveInSubScene();
		} else {
			System.out.println("SubScene is null");
		}
	}

	private void hideSubScene(SpaceRunnerSubScene subScene) {
		if(subScene!=null) {
			subScene.setVisible(false);
			subScene.moveOutSubScene();
			subScene = null;
		} else {
			System.out.println("SubScene is null");
		}
	}



	private void addMenuButtons(LayableButton button) {
//		menuButtons.remove(button);
		controlPane.getChildren().remove(button);

//		menuButtons.add(button);
		controlPane.getChildren().add(button);
	}

//	private void showSubScene(SpaceRunnerSubScene subScene) {
//		if (sceneToHide != null) {
//			sceneToHide.moveSubScene();
//		}
//
//		subScene.moveSubScene();
//		sceneToHide = subScene;
//	}


	public void addButtonToControlPanel(LayableButton button) {
		controlPane.AddChild(button);
	}

	public void changeLayout(LayoutType layout, int parentX, int parentY, int index) {
		createBackground();
		for (Layable lay : layables) {
			 lay.changeLayout(layout, parentX, parentY, index);
			index++;
		}
	}

	public void showStage() {
		panelStage.show();
	}

	@Override
	public void addLayable(Layable layable) {
		layables.add(layable);
	}

	@Override
	public void removeLayable(Layable layable) {
		layables.remove(layable);
	}
}
