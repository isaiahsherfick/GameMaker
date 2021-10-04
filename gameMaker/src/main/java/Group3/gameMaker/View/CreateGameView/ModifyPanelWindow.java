package Group3.gameMaker.View.CreateGameView;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import java.util.List;
import java.util.Map.Entry;

import Group3.gameMaker.View.CreateGameView.Location.LayoutType;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.Slider;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import Group3.gameMaker.Constants.*;
import Group3.gameMaker.SaveAndLoad.SaveableColor;
import Group3.gameMaker.Sprite.Sound;
import Group3.gameMaker.Sprite.Sprite;
import Group3.gameMaker.Sprite.Strategy.CollisionStrategy.BounceCollisionStrategy;
import Group3.gameMaker.Sprite.Strategy.CollisionStrategy.CollisionStrategy;
import Group3.gameMaker.Sprite.Strategy.CollisionStrategy.CustomCollisionMap;
import Group3.gameMaker.Sprite.Strategy.CollisionStrategy.CustomCollisionPair;
import Group3.gameMaker.Sprite.Strategy.CollisionStrategy.DestroyCollisionStrategy;
import Group3.gameMaker.Sprite.Strategy.CollisionStrategy.NoCollisionStrategy;
import Group3.gameMaker.Sprite.Strategy.ShapeStrategy.*;
import Group3.gameMaker.Sprite.Strategy.ShapeStrategy.CircleStrategy;
import Group3.gameMaker.Sprite.Strategy.ShapeStrategy.RectangleStrategy;

public class ModifyPanelWindow
{
	private Stage modifyStage;
	private CreateGameView createGameView;
	private TabPane tabPane;
	private Group root;
	private Scene scene;
	private Tab mainTab, collisionTab, eventTab;
	private Pane mainPane, collisionPane, eventPane;
	private Sprite selectedSprite;
	private Label spriteIdLabel, spriteLocationLabel;
	private MenuButton spriteShapeStrategyDropdown;
	private ColorPicker colorPicker;
	private int collisionIndex = 1;
	private static final int COLLISION_PADDING = 25;
	private static final int COLLISION_DROPDOWN_LEFT_PADDING = 100;
	Slider radiusSlider, widthSlider, heightSlider;

	public ModifyPanelWindow(CreateGameView view, Stage panelStage)
	{
		modifyStage = panelStage;
		modifyStage.setHeight(Constants.CREATE_PANEL_HEIGHT);
		modifyStage.setWidth(Constants.MODIFY_PANEL_WIDTH);
		createGameView = view;

		root = new Group();
		scene = new Scene(root);
		modifyStage.setScene(scene);

		initializePanes();
		initializeTabs();

		root.getChildren().add(tabPane);

		initializePaneChildren();

		tabPane.setMinHeight(modifyStage.getHeight());
		tabPane.setMinWidth(modifyStage.getWidth());
		tabPane.setLayoutX(Location.LeftLayout.controlPaneX);

		createBackground();
		populateTabs();
		selectedSprite = createGameView.getSelectedSprite();
	}

	private void initializePaneChildren()
	{
		spriteIdLabel = new Label();
		spriteIdLabel.setFont(new Font(25));
		spriteIdLabel.setTextFill(Color.web("#FFFFFF"));
		spriteIdLabel.setLayoutX(Constants.LABEL_LEFT_PADDING);
		spriteIdLabel.setLayoutY(Constants.LABEL_VERTICAL_PADDING);
		int index = 1;

		spriteLocationLabel = new Label();
		spriteLocationLabel.setFont(new Font(25));
		spriteLocationLabel.setTextFill(Color.web("#FFFFFF"));
		spriteLocationLabel.setLayoutX(Constants.LABEL_LEFT_PADDING);
		spriteLocationLabel.setLayoutY((Constants.LABEL_VERTICAL_PADDING + Constants.LABEL_HEIGHT) * index++);

		spriteShapeStrategyDropdown = new MenuButton();
		spriteShapeStrategyDropdown.setText("Change Shape Strategy");
		MenuItem circleStrategy = new MenuItem("Circle");
		circleStrategy.setOnAction( e ->
		{
			if (selectedSprite != null)
			{
				selectedSprite.setShapeStrategy(new CircleStrategy());
				createGameView.modifySprite(selectedSprite);
			}
		});
		spriteShapeStrategyDropdown.getItems().add(circleStrategy);
		MenuItem rectangleStrategy = new MenuItem("Rectangle");
		rectangleStrategy.setOnAction( e ->
		{
			if (selectedSprite != null)
			{
				selectedSprite.setShapeStrategy(new RectangleStrategy());
				createGameView.modifySprite(selectedSprite);
			}
		});
		spriteShapeStrategyDropdown.getItems().add(rectangleStrategy);
		spriteShapeStrategyDropdown.setLayoutX(Constants.LABEL_LEFT_PADDING);
		spriteShapeStrategyDropdown.setLayoutY((Constants.LABEL_VERTICAL_PADDING + Constants.LABEL_HEIGHT) * index++);

		colorPicker = new ColorPicker();
		colorPicker.setValue(Color.web("#0000FF"));
		colorPicker.setOnAction( e ->
		{
			if (selectedSprite != null)
			{
				selectedSprite.setColor(new SaveableColor(colorPicker.getValue()));
				createGameView.modifySprite(selectedSprite);
			}
		});
		colorPicker.setLayoutX(Constants.LABEL_LEFT_PADDING);
		colorPicker.setLayoutY((Constants.LABEL_VERTICAL_PADDING + Constants.LABEL_HEIGHT) * index++);

		Button soundExplorer = new Button("Sound");
		soundExplorer.setOnAction(e -> {
 			FileChooser fileChooser = new FileChooser();
 			fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
 			fileChooser.setTitle("Open Audio File");
 			ExtensionFilter selectedExtensionFilter = new FileChooser.ExtensionFilter("WAV", "*.wav");
 			fileChooser.getExtensionFilters().addAll(
 					new FileChooser.ExtensionFilter("All Files", "*.*"),
 					new FileChooser.ExtensionFilter("AAC", "*.aac"),
 					new FileChooser.ExtensionFilter("MP3", "*.mp3"),
 					selectedExtensionFilter
             );
 			fileChooser.setSelectedExtensionFilter(selectedExtensionFilter);
 			File chosenFile = fileChooser.showOpenDialog(modifyStage);
 			String path = chosenFile.getPath();

 			Sound sound = new Sound();
 			sound.setUri(Paths.get(path).toUri().toString());
 			try {
 				sound.play();
 			} catch (Exception ex) {
 				ex.printStackTrace();
 			}

 			selectedSprite.setSound(sound);
 			createGameView.modifySprite(selectedSprite);

 		});

		soundExplorer.setLayoutX(Constants.LABEL_LEFT_PADDING);
		soundExplorer.setLayoutY((Constants.LABEL_VERTICAL_PADDING + Constants.LABEL_HEIGHT) * index++);

		widthSlider = new Slider();
		widthSlider.setMin(0);
		widthSlider.setMax(Constants.MAIN_WINDOW_WIDTH);
		widthSlider.setValue(50);
		widthSlider.setShowTickLabels(true);
		widthSlider.setShowTickMarks(true);
		widthSlider.setMajorTickUnit(50);
		widthSlider.setMinorTickCount(5);
		widthSlider.setBlockIncrement(10);
		widthSlider.setVisible(false);

		heightSlider = new Slider();
		heightSlider.setMin(0);
		heightSlider.setMax(Constants.MAIN_WINDOW_HEIGHT);
		heightSlider.setValue(50);
		heightSlider.setShowTickLabels(true);
		heightSlider.setShowTickMarks(true);
		heightSlider.setMajorTickUnit(50);
		heightSlider.setMinorTickCount(5);
		heightSlider.setBlockIncrement(10);
		heightSlider.setVisible(false);

		radiusSlider = new Slider();
		radiusSlider.setMin(0);
		radiusSlider.setMax(Constants.MAIN_WINDOW_WIDTH);
		radiusSlider.setValue(50);
		radiusSlider.setShowTickLabels(true);
		radiusSlider.setShowTickMarks(true);
		radiusSlider.setMajorTickUnit(50);
		radiusSlider.setMinorTickCount(5);
		radiusSlider.setBlockIncrement(10);
		radiusSlider.setVisible(false);


		heightSlider.setLayoutX(Constants.LABEL_LEFT_PADDING);
		heightSlider.setLayoutY((Constants.LABEL_VERTICAL_PADDING + Constants.LABEL_HEIGHT) * index++);

		widthSlider.setLayoutX(Constants.LABEL_LEFT_PADDING);
		widthSlider.setLayoutY((Constants.LABEL_VERTICAL_PADDING + Constants.LABEL_HEIGHT) * index);

		radiusSlider.setLayoutX(Constants.LABEL_LEFT_PADDING);
		radiusSlider.setLayoutY((Constants.LABEL_VERTICAL_PADDING + Constants.LABEL_HEIGHT) * index++);

		mainPane.getChildren().add(spriteIdLabel);
		mainPane.getChildren().add(spriteLocationLabel);
		mainPane.getChildren().add(spriteShapeStrategyDropdown);
		mainPane.getChildren().add(colorPicker);
		mainPane.getChildren().add(soundExplorer);
		mainPane.getChildren().addAll(heightSlider, widthSlider, radiusSlider);

	}

	private void initializePanes()
	{
		tabPane = new TabPane();
		mainPane = new Pane();
		collisionPane = new Pane();
		eventPane = new Pane();
	}

	private void initializeTabs()
	{
		mainTab = new Tab("Sprite View");
		collisionTab = new Tab("Custom Collisions");
		eventTab = new Tab("Event Behavior Chain");
		collisionTab.setContent(collisionPane);
		eventTab.setContent(eventPane);
		mainTab.setContent(mainPane);
		tabPane.getTabs().addAll(mainTab, collisionTab, eventTab);
	}



	private void populateTabs()
	{
		if (selectedSprite != null && selectedSprite.getSpriteId() != -2)
		{
			spriteIdLabel.setText(String.format("Sprite ID: %d", selectedSprite.getSpriteId()));
			spriteLocationLabel.setText(String.format("X: %4d\tY: %4d",selectedSprite.getX(), selectedSprite.getY()));
			
			populateCollisionTab();
		}
		else
		{
			spriteIdLabel.setText(String.format("Sprite ID: none selected"));
			spriteLocationLabel.setText("");
		}

		if(selectedSprite !=null && selectedSprite.getShapeStrategy() instanceof CircleStrategy) {
			radiusSlider.setVisible(true);
			heightSlider.setVisible(false);
			widthSlider.setVisible(false);
			radiusSlider.setOnDragDetected( e-> {
				((CircleStrategy)(selectedSprite.getShapeStrategy())).setRadius((int)radiusSlider.getValue());
				createGameView.modifySprite(selectedSprite);
			});
		}
		else if(selectedSprite !=null && selectedSprite.getShapeStrategy() instanceof RectangleStrategy) {
			heightSlider.setVisible(true);
			widthSlider.setVisible(true);
			radiusSlider.setVisible(false);
			heightSlider.setOnDragDetected( e-> {
				((RectangleStrategy)(selectedSprite.getShapeStrategy())).setHeight((int)heightSlider.getValue());
				createGameView.modifySprite(selectedSprite);
			});
			widthSlider.setOnDragDetected( e-> {
				((RectangleStrategy)(selectedSprite.getShapeStrategy())).setWidth((int)widthSlider.getValue());
				createGameView.modifySprite(selectedSprite);
			});
		}
	}

	private void populateCollisionTab()
	{
		collisionIndex = 0;
		collisionPane.getChildren().clear();
		CustomCollisionMap customCollisionMap = selectedSprite.getCustomCollisionMap();
		for (Entry<Integer, CollisionStrategy> entry : customCollisionMap.entrySet())
		{
			//Uncomment to remove concurrentaccessexception
			//displayCustomCollision(new CustomCollisionPair(entry.getKey(),entry.getValue()));
			collisionIndex++;
		}
	}


	private void displayCustomCollision(CustomCollisionPair customCollisionPair) 
	{
		Label currentCollisionLabel = new Label(String.format("SprideID: %d\tCollision:%s",customCollisionPair.getSpriteId(),customCollisionPair.getCollisionStrategy()));
		currentCollisionLabel.setLayoutY(collisionIndex * COLLISION_PADDING);
		currentCollisionLabel.setFont(new Font(17));
		currentCollisionLabel.setTextFill(Color.web("#FFFFFF"));

		MenuButton customCollisions = new MenuButton();
		customCollisions.setLayoutY(collisionIndex * COLLISION_PADDING + 25);
		customCollisions.setLayoutX(COLLISION_DROPDOWN_LEFT_PADDING);
		MenuItem destroyCollision = new MenuItem("Be Destroyed");
		destroyCollision.setOnAction( e ->
		{
			if (selectedSprite != null)
			{
				selectedSprite.addCustomCollision(customCollisionPair.getSpriteId(), new DestroyCollisionStrategy(selectedSprite));
				createGameView.modifySprite(selectedSprite);
			}
		});
		customCollisions.getItems().add(destroyCollision);
		MenuItem bounceCollision = new MenuItem("Bounce");
		destroyCollision.setOnAction( e ->
		{
			if (selectedSprite != null)
			{
				selectedSprite.addCustomCollision(customCollisionPair.getSpriteId(), new BounceCollisionStrategy(selectedSprite));
				createGameView.modifySprite(selectedSprite);
			}
		});
		customCollisions.getItems().add(destroyCollision);
		MenuItem doNothingCollision = new MenuItem("Ignore Collision");
		destroyCollision.setOnAction( e ->
		{
			if (selectedSprite != null)
			{
				selectedSprite.addCustomCollision(customCollisionPair.getSpriteId(), new NoCollisionStrategy());
				createGameView.modifySprite(selectedSprite);
			}
		});
		customCollisions.getItems().add(destroyCollision);
		collisionPane.getChildren().add(customCollisions);
		collisionPane.getChildren().add(currentCollisionLabel);
	}

	private void createBackground()
	{
		Image backgroundImage = new Image("/Group3/gameMaker/Resource/deep_blue.png", 0, 0, false, false);
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
		tabPane.setBackground(new Background(background));
	}

	public void displaySprite(Sprite sprite)
	{
		selectedSprite = sprite;
		populateTabs();
	}

	public Stage getStage()
	{
		return modifyStage;
	}

	public void reset()
	{
		spriteIdLabel.setText(String.format("Sprite ID: none selected"));
	}
}