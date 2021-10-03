package Group3.gameMaker.View.CreateGameView;

import java.util.ArrayList;
import java.util.List;

import Group3.gameMaker.View.CreateGameView.Location.LayoutType;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
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

public class ModifyPanelWindow implements Layable {

	private Stage propertyStage;
	private ArrayList<Layable> layables;
	List<LayableButton> menuButtons;
	public LayablePane modifyPane;
	Scene propertyScene;
	private SpaceRunnerSubScene eventChooserSubscene;
	private EVENT choosenevent;
	List<eventPicker> eventList;
	private SpaceRunnerSubScene sceneToHide;

	// Accessible only within the CreateGameView package
	ModifyPanelWindow(Stage propertyStage) {
		this.propertyStage = propertyStage;
		layables = new ArrayList<Layable>();
		propertyStage.setWidth(Constants.MODIFY_PANEL_WIDTH);
		propertyStage.setHeight(Constants.MODIFY_PANEL_HEIGHT);
//		panelStage.setX(Constants.MODIFY_PANEL_X);
//		panelStage.setY(Constants.MODIFY_PANEL_Y);
	}


	public void makeStage () {
		
		//menuButtons = new ArrayList<>();
		Group rootGroup = new Group();
		//Pane rootPane = new Pane();
		
		modifyPane = new LayablePane();
//		controlPane.setStyle("-fx-background-color: #FF00FF");
		layables.add(modifyPane);
//		controlPane.setPrefSize(Location.LeftLayout.controlPaneWidth, Location.LeftLayout.controlPaneHeight);
		rootGroup.getChildren().add(modifyPane);
		modifyPane.setLayoutX(Location.LeftLayout.controlPaneX);
		//controlPane.setStyle("-fx-background-color: #000000");
		createBackground();
		createEventChooserSubScene();
		createeventButton();
		
		propertyScene = new Scene(rootGroup, Constants.MODIFY_PANEL_WIDTH, Constants.MODIFY_PANEL_HEIGHT);
		propertyStage.setScene(propertyScene);
	}
	
	public void createBackground() {
		Image backgroundImage = new Image("/Group3/gameMaker/Resource/deep_blue.png", 256, 256, false, false);
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, null);
		modifyPane.setBackground(new Background(background));
		
	}
	
	private void createEventChooserSubScene() {
		eventChooserSubscene = new SpaceRunnerSubScene();
		modifyPane.getChildren().add(eventChooserSubscene);

		InfoLabel chooseeventLabel = new InfoLabel("CHOOSE YOUR EVENT");
		chooseeventLabel.setLayoutX(110);
		chooseeventLabel.setLayoutY(25);
		eventChooserSubscene.getPane().getChildren().add(chooseeventLabel);
		eventChooserSubscene.getPane().getChildren().add(createeventToChoose());
		eventChooserSubscene.getPane().getChildren().add(createButtonToStartEvent());
	}
	
	private HBox createeventToChoose() {
		HBox box = new HBox();
		box.setSpacing(60);
		eventList = new ArrayList<>();
		for (EVENT event : EVENT.values()) {
			final eventPicker eventToPick = new eventPicker(event);
			eventList.add(eventToPick);
			box.getChildren().add(eventToPick);
			eventToPick.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					for (eventPicker audio : eventList) {
						audio.setIsCircleChoosen(false);
					}
					eventToPick.setIsCircleChoosen(true);
					choosenevent = eventToPick.getevents();

				}
			});
		}

		box.setLayoutX(300 - (118*2));
		box.setLayoutY(100);
		return box;
	}
	
	private LayableButton createButtonToStartEvent() {
		LayableButton starteventButton = new LayableButton("ADD EVENT");
		starteventButton.setLayoutX(105);
		starteventButton.setLayoutY(220);
		
		
		starteventButton.setOnAction(new EventHandler<ActionEvent>() {

			

			@Override
			public void handle(ActionEvent event) {
					
				if (choosenevent != null) {
//					GameViewManager gameManager = new GameViewManager();
//					gameManager.createNewGameEvent(choosenevent);;
				}
			}
		});
		
		return starteventButton;
	}
	
	private void createeventButton() {
		LayableButton eventbutton = new LayableButton("Event");
		//AddMenuButtons( eventbutton);
		eventbutton.setLayoutX(Constants.MENU_BUTTON_START_X);
		eventbutton.setLayoutY(Constants.MENU_BUTTON_START_Y+140);
		eventbutton.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			showSubScene(eventChooserSubscene);

		}
	});
		addButtonToControlPanel(eventbutton);
	}
	
	public void addButtonToControlPanel(LayableButton button) {
		modifyPane.AddChild(button);
	}
	
	
	private void showSubScene(SpaceRunnerSubScene subScene) {
		if (sceneToHide != null) {
			sceneToHide.moveSubScene();
		}

		subScene.moveSubScene();
		sceneToHide = subScene;
	}
		
	public void showStage() {
		propertyStage.show();
	}
	

	@Override
	public void changeLayout(LayoutType currentLayout, int parentX, int parentY, int index) {
		for (Layable lay : layables) {
			 lay.changeLayout(currentLayout, parentX, parentY, index);
			index++;
		}

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