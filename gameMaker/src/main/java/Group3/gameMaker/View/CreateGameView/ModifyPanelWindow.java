package Group3.gameMaker.View.CreateGameView;

import java.util.ArrayList;
import javafx.scene.control.ColorPicker;
import java.util.List;

import Group3.gameMaker.View.CreateGameView.Location.LayoutType;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;

import Group3.gameMaker.Constants.*;
import Group3.gameMaker.SaveAndLoad.SaveableColor;
import Group3.gameMaker.Sprite.Sprite;
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
		
		
		
		mainPane.getChildren().add(spriteIdLabel);
		mainPane.getChildren().add(spriteLocationLabel);
		mainPane.getChildren().add(spriteShapeStrategyDropdown);
		mainPane.getChildren().add(colorPicker);
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
		}
		else
		{
			spriteIdLabel.setText(String.format("Sprite ID: none selected"));
			spriteLocationLabel.setText("");
		}
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