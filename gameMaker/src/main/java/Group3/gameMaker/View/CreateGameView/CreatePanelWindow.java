package Group3.gameMaker.View.CreateGameView;

import java.util.ArrayList;
import java.util.List;

import Group3.gameMaker.Constants.Constants;
import Group3.gameMaker.View.CreateGameView.Location.LayoutType;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CreatePanelWindow implements Layable {

	private Stage panelStage;
	private ArrayList<Layable> layables;
	private SpaceRunnerSubScene addSpriteSubScene;
	private CreateGameView createGameView;
	List<ShapePicker> shapesList;
	public Pane controlPane;
	
	private Group root;
	private Scene scene;


	// Accessible only within the CreateGameView package
	CreatePanelWindow(CreateGameView createGameView, Stage panelStage) 
	{
		this.panelStage = panelStage;
		layables = new ArrayList<Layable>();
		panelStage.setHeight(Constants.CREATE_PANEL_HEIGHT);
		panelStage.setWidth(Constants.CREATE_PANEL_WIDTH);
		this.createGameView = createGameView;
		root = new Group();
		scene = new Scene(root);
		panelStage.setScene(scene);
		controlPane = new Pane();
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
			});
		}

		box.setLayoutX(300 - (118*2));
		box.setLayoutY(100);
		return box;
	}


	public void createButtons () 
	{

		int index = 0;
		final LayableButton spriteButton = new LayableButton("New Sprite");
		spriteButton.setLayoutX(Constants.MENU_BUTTON_START_X);
		spriteButton.setLayoutY(Constants.MENU_BUTTON_START_Y);
		spriteButton.setOnAction(e -> {
			createGameView.createSprite();
		});
		index++;


		final LayableButton saveButton = new LayableButton("Save");
		saveButton.setLayoutX(Constants.MENU_BUTTON_START_X);
		saveButton.setLayoutY(Constants.MENU_BUTTON_START_Y + (index * (Constants.LAYABLE_BUTTON_PADDING + Constants.LAYABLE_BUTTON_HEIGHT)));
		saveButton.setOnAction(e -> {
			createGameView.save();
		});
		index++;

		final LayableButton loadButton = new LayableButton("Load");
		//AddMenuButtons( eventbutton);
		loadButton.setLayoutX(Constants.MENU_BUTTON_START_X);
		loadButton.setLayoutY(Constants.MENU_BUTTON_START_Y + (index * (Constants.LAYABLE_BUTTON_PADDING + Constants.LAYABLE_BUTTON_HEIGHT)));
		loadButton.setOnAction(e -> {
			createGameView.load();
		});
		index++;

		final LayableButton playGameButton = new LayableButton("Play Game");
		playGameButton.setLayoutX(Constants.MENU_BUTTON_START_X);
		playGameButton.setLayoutY(Constants.MENU_BUTTON_START_Y + (index * (Constants.LAYABLE_BUTTON_PADDING + Constants.LAYABLE_BUTTON_HEIGHT)));
		playGameButton.setOnAction(e -> {
			createGameView.switchContexts();
		});
		index++;

		addButtonToControlPanel(spriteButton);
		addButtonToControlPanel(saveButton);
		addButtonToControlPanel(loadButton);
		addButtonToControlPanel(playGameButton);
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
		controlPane.getChildren().add(button);
	}

	public void changeLayout(LayoutType layout, int parentX, int parentY, int index) {
		createBackground();
		for (Layable lay : layables) {
			 lay.changeLayout(LayoutType.LEFT, parentX, parentY, index);
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

	public Stage getStage() {
		return panelStage;
	}
}
