
//    Created by: Snehal Patare
//    Created on: 25 Sep 2021
//     Edited by:
//Edited last by: Snehal Patare

package Group3.gameMaker.CreateGameView;

import java.util.ArrayList;
import java.util.List;


import Group3.gameMaker.CreateGameView.Location.LayoutType;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.skin.MenuButtonSkin;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import javafx.stage.Stage;



//import Group3.gameMaker.CreateGameView.LayableMenuButton;

import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;




public class LayoutManager implements Layable {
	
	// Main Window
	
	//TODO fix the encapsulation issue
	//make all of these private, use getters/setters
	public Stage appStage;
	public Group rootGroup;
	public Pane rootPane;
	public LayoutType currentLayout = LayoutType.LEFT; 
	public LayoutType changesLayout = LayoutType.RIGHT; 
	
	private final static int MENU_BUTTON_START_X = 100;
	private final static int MENU_BUTTON_START_Y = 100;

	private static final int HEIGHT = 700;
	private static final int WIDTH = 800;
	List<LayableButton> menuButtons;
	List<LayableButton> menuButtons1;
	private SpaceRunnerSubScene shapeChooserSubscene;
	private SpaceRunnerSubScene sceneToHide;
	private SpaceRunnerSubScene audioChooserSubscene;
	private SpaceRunnerSubScene movementChooserSubscene;
	private SpaceRunnerSubScene eventChooserSubscene;
	
	List<ShapePicker> shapesList;
	List<audioPicker> audioList;
	List<movePicker> moveList;
	List<eventPicker> eventList;
	private SHAPE choosenShape;
	private AUDIO choosenaudio;
	private MOVEMENT choosenmove;
	private EVENT choosenevent;
	
	public LayablePane controlPane;
	public LayablePane actionPane;
	public LayablePane actionPane1;
	public LayableCanvas gameCanvas;
	public Scene gameScene;
	// Add list of items to be added in Layable array
	public ArrayList<Layable> layables = new ArrayList<Layable>();
	
	public LayoutManager(Stage appStage) {
		this.appStage = appStage;
		appStage.setWidth(Location.RightLayout.rootPaneWidth);
		appStage.setWidth(Location.RightLayout.rootPaneHeight);
	}
	
	public void makeStage () {
		// Build root group and root pane
				//BorderPane rootGroup = new BorderPane();
				menuButtons = new ArrayList<>();
				rootGroup = new Group();
				rootPane = new Pane();
				Pane rootPane = new Pane();
				//Canvas gameCanvas = new Canvas();

				rootPane.setPrefSize(Location.LeftLayout.rootPaneWidth, Location.LeftLayout.rootPaneHeight);
				rootPane.setStyle("-fx-background-color: #FF00FF");
				rootGroup.getChildren().add(rootPane);
				
				
//				gameCanvas = new LayableCanvas(Location.LeftLayout.gameCanvasWidth, Location.LeftLayout.gameCanvasHeight);
//				layables.add(gameCanvas);
//				rootGroup.getChildren().add(gameCanvas);
//				gameCanvas.setLayoutX(Location.LeftLayout.gameCanvasX);
//				gameCanvas.setStyle("-fx-background-color: #FF00FF");
				
				//rootGroup.getChildren().add(rootPane);
				
				
				controlPane = new LayablePane();
				layables.add(controlPane);
				controlPane.setPrefSize(Location.LeftLayout.controlPaneWidth, Location.LeftLayout.controlPaneHeight);
				rootGroup.getChildren().add(controlPane);
				controlPane.setLayoutX(Location.LeftLayout.controlPaneX);
				//controlPane.setStyle("-fx-background-color: #000000");
				createBackground();
				
				BorderPane.setAlignment(controlPane,Pos.CENTER_LEFT);
				//BorderPane.setAlignment(gameCanvas,Pos.CENTER_RIGHT);
				
				
				
				createSubScenes();
				
				gameScene = new Scene(rootGroup, WIDTH, HEIGHT);
				appStage.setScene(gameScene);
	}
	
	
	public void createButtons () {
		
		final LayableButton shapebutton = new LayableButton("Shapes");
		shapebutton.setLayoutX(MENU_BUTTON_START_X);
		shapebutton.setLayoutY(MENU_BUTTON_START_Y);
		shapebutton.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			showSubScene(shapeChooserSubscene);
			
		}
	});
		
		
		final LayableButton movementbutton = new LayableButton("Movement");
		//AddMenuButtons( movementbutton);
		movementbutton.setLayoutX(MENU_BUTTON_START_X);
		movementbutton.setLayoutY(MENU_BUTTON_START_Y+70);
		movementbutton.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			showSubScene(movementChooserSubscene);
			
		}
	});
		
		final LayableButton eventbutton = new LayableButton("Event");
		//AddMenuButtons( eventbutton);
		eventbutton.setLayoutX(MENU_BUTTON_START_X);
		eventbutton.setLayoutY(MENU_BUTTON_START_Y+140);
		eventbutton.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			showSubScene(eventChooserSubscene);
			
		}
	});
		
		
		
		final LayableButton Audiobutton = new LayableButton("Audio");
		//AddMenuButtons( Audiobutton);
		Audiobutton.setLayoutX(MENU_BUTTON_START_X);
		Audiobutton.setLayoutY(MENU_BUTTON_START_Y+210);
		Audiobutton.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			showSubScene(audioChooserSubscene);
			
		}
	});
		
		LayableButton newspritebutton = new LayableButton("Create New Sprites");
		//AddMenuButtons(shapebutton);
		newspritebutton.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
//			AddactionPane();
			AddMenuButtons(shapebutton);
			AddMenuButtons( movementbutton);
			AddMenuButtons( eventbutton);
			AddMenuButtons( Audiobutton);
			//showSubScene2(SpritesChooserSubscene);
			
		}
	});
		//controlPane.getChildren().add(newspritebutton);
		addButtonToControlPanel(newspritebutton);
		
		LayableButton existspritebutton = new LayableButton("Modify Sprites");
		//AddMenuButtons(shapebutton);
		existspritebutton.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			//AddactionPane1();

			AddMenuButtons(shapebutton);
			AddMenuButtons( movementbutton);
			AddMenuButtons( eventbutton);
			AddMenuButtons( Audiobutton);

		}
	});
		//controlPane.getChildren().add(existspritebutton);
		addButtonToControlPanel(existspritebutton);
		
		changeLayout(currentLayout, 0, 0, 0);
        
		
	}
	
	public void changeLayout(LayoutType layout, int parentX, int parentY, int index) {
		for (Layable lay : layables) {
			 lay.changeLayout(layout, parentX, parentY, 0);
			index++;
		}
		System.out.println("Layout has been changed to: " + layout);
	}
	public void showStage() {
		appStage.show();
	}
	
	public void addButtonToControlPanel(LayableButton button) {
		controlPane.AddChild(button);
	}
	
	public Scene getGameScene() {
		return gameScene;
	}
	
	public Canvas getGameCanvas() {
		return gameCanvas;
	}
	
	
	
	@Override
	public void addLayable(Layable layable) {
		// TODO Auto-generated method stub
		layables.add(layable);
	}

	@Override
	public void removeLayable(Layable layable) {
		// TODO Auto-generated method stub
		layables.remove(layable);
		
	}
	
	private void createBackground() {
		Image backgroundImage = new Image("/Group3/gameMaker/Resource/deep_blue.png", 256, 256, false, false);
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
		controlPane.setBackground(new Background(background));
	}
	
	private void createactionBackground() {
		Image backgroundImage = new Image("/Group3/gameMaker/Resource/�Pngtree�explosion game poster background_1048673.jpg", 500, 700, false, false);
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
		actionPane.setBackground(new Background(background));
	}
	
	
	private void AddMenuButtons(LayableButton button) {

		menuButtons.remove(button);
		controlPane.getChildren().remove(button);
		
		menuButtons.add(button);
		controlPane.getChildren().add(button);
		
		
	}
	
//	private void AddMenuButtons(LayableButton button) {
//		button.setLayoutX(MENU_BUTTON_START_X);
//		button.setLayoutY(MENU_BUTTON_START_Y + menuButtons.size() * 70);
//		//button.setLayoutX(MENU_BUTTON_START_Y + menuButtons.size());
//		menuButtons.add(button);
//		SpritesChooserSubscene.getChildren().add(button);
//	}
	
	
	private void showSubScene(SpaceRunnerSubScene subScene) {
		if (sceneToHide != null) {
			sceneToHide.moveSubScene();
		}
		
		subScene.moveSubScene();
		sceneToHide = subScene;
	}
	
	
	private void createSubScenes() {
		
		createShapeChooserSubScene();
		createAudioChooserSubScene();
		createMovementChooserSubScene();
		createEventChooserSubScene();
	
	}
	
	
	private void createShapeChooserSubScene() {
		shapeChooserSubscene = new SpaceRunnerSubScene();
		controlPane.getChildren().add(shapeChooserSubscene);
		
		InfoLabel chooseShapeLabel = new InfoLabel("CHOOSE YOUR SHAPE");
		chooseShapeLabel.setLayoutX(110);
		chooseShapeLabel.setLayoutY(25);
		shapeChooserSubscene.getPane().getChildren().add(chooseShapeLabel);
		shapeChooserSubscene.getPane().getChildren().add(createShapesToChoose());
		shapeChooserSubscene.getPane().getChildren().add(createButtonToStart());		
	}
	
	private void createAudioChooserSubScene() {
		audioChooserSubscene = new SpaceRunnerSubScene();
		controlPane.getChildren().add(audioChooserSubscene);
		
		InfoLabel chooseAudioLabel = new InfoLabel("CHOOSE YOUR AUDIO");
		chooseAudioLabel.setLayoutX(110);
		chooseAudioLabel.setLayoutY(25);
		audioChooserSubscene.getPane().getChildren().add(chooseAudioLabel);
		audioChooserSubscene.getPane().getChildren().add(createAudioToChoose());
		audioChooserSubscene.getPane().getChildren().add(createButtonToStart());	
	}
	
	private void createMovementChooserSubScene() {
		movementChooserSubscene = new SpaceRunnerSubScene();
		controlPane.getChildren().add(movementChooserSubscene);
		
		InfoLabel choosemovementLabel = new InfoLabel("CHOOSE YOUR MOVEMENT");
		choosemovementLabel.setLayoutX(110);
		choosemovementLabel.setLayoutY(25);
		movementChooserSubscene.getPane().getChildren().add(choosemovementLabel);
		movementChooserSubscene.getPane().getChildren().add(createmovementToChoose());
		movementChooserSubscene.getPane().getChildren().add(createButtonToStart());		
		
	}
	
	private void createEventChooserSubScene() {
		eventChooserSubscene = new SpaceRunnerSubScene();
		controlPane.getChildren().add(eventChooserSubscene);
		
		InfoLabel chooseeventLabel = new InfoLabel("CHOOSE YOUR EVENT");
		chooseeventLabel.setLayoutX(110);
		chooseeventLabel.setLayoutY(25);
		eventChooserSubscene.getPane().getChildren().add(chooseeventLabel);
		eventChooserSubscene.getPane().getChildren().add(createeventToChoose());
		eventChooserSubscene.getPane().getChildren().add(createButtonToStart());		
	}
	
	
	private HBox createAudioToChoose() {
		HBox box = new HBox();
		box.setSpacing(60);
		audioList = new ArrayList<>();
		for (AUDIO audio : AUDIO.values()) {
			final audioPicker audioToPick = new audioPicker(audio);
			audioList.add(audioToPick);
			box.getChildren().add(audioToPick);
			audioToPick.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					for (audioPicker audio : audioList) {
						audio.setIsCircleChoosen(false);
					}
					audioToPick.setIsCircleChoosen(true);
					choosenaudio = audioToPick.getaudio();
					
				}
			});
		}
		
		box.setLayoutX(300 - (118*2));
		box.setLayoutY(100);
		return box;
	}
	
	private HBox createmovementToChoose() {
		HBox box = new HBox();
		box.setSpacing(60);
		moveList = new ArrayList<>();
		for (MOVEMENT move : MOVEMENT.values()) {
			final movePicker moveToPick = new movePicker(move);
			moveList.add(moveToPick);
			box.getChildren().add(moveToPick);
			moveToPick.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					for (movePicker audio : moveList) {
						audio.setIsCircleChoosen(false);
					}
					moveToPick.setIsCircleChoosen(true);
					choosenmove = moveToPick.getmoves();
					
				}
			});
		}
		
		box.setLayoutX(300 - (118*2));
		box.setLayoutY(100);
		return box;
	}
	
	
	
	
	private HBox createShapesToChoose() {
		HBox box = new HBox();
		box.setSpacing(60);
		shapesList = new ArrayList<>();
		for (SHAPE shape : SHAPE.values()) {
			final ShapePicker shapeToPick = new ShapePicker(shape);
			shapesList.add(shapeToPick);
			box.getChildren().add(shapeToPick);
			shapeToPick.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					for (ShapePicker shape : shapesList) {
						shape.setIsCircleChoosen(false);
					}
					shapeToPick.setIsCircleChoosen(true);
					choosenShape = shapeToPick.getShapes();
					
				}
			});
		}
		
		box.setLayoutX(300 - (118*2));
		box.setLayoutY(100);
		return box;
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
	
	
	private LayableButton createButtonToStart() {
		LayableButton startButton = new LayableButton("ADD");
		startButton.setLayoutX(105);
		startButton.setLayoutY(220);
		
		
		startButton.setOnAction(new EventHandler<ActionEvent>() {

			

			@Override
			public void handle(ActionEvent event) {
				if (choosenShape != null) {
//					GameViewManager gameManager = new GameViewManager();
//					gameManager.createNewGame(mainStage, choosenShip);;
				}
				
			}
		});
		
		return startButton;
	}
	
		


}
