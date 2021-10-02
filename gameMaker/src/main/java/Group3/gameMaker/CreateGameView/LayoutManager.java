
//    Created by: Snehal Patare
//    Created on: 25 Sep 2021
//     Edited by:
//Edited last by: Snehal Patare

package Group3.gameMaker.CreateGameView;

import java.util.ArrayList;

import Group3.gameMaker.CreateGameView.Layable;
import Group3.gameMaker.CreateGameView.Location.LayoutType;
import Group3.gameMaker.Sprite.Sound;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.Pane;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.File;
import java.nio.file.Paths;

import javax.swing.JRootPane;

//import Group3.gameMaker.CreateGameView.LayableMenuButton;
import Group3.gameMaker.CreateGameView.Location.LayoutType;
import Group3.gameMaker.CreateGameView.Layable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.*;
import javafx.stage.FileChooser.ExtensionFilter;



public class LayoutManager implements Layable {

	// Main Window

	//TODO fix the encapsulation issue
	//make all of these private, use getters/setters
	public Stage appStage;
	public Group rootGroup;
	public Pane rootPane;
	public LayoutType currentLayout = LayoutType.RIGHT;
	private String path = null;

	public LayablePane controlPane;
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
				rootGroup = new Group();
				rootPane = new Pane();
				Pane rootPane = new Pane();

				rootPane.setPrefSize(Location.RightLayout.rootPaneWidth, Location.RightLayout.rootPaneHeight);
				rootPane.setStyle("-fx-background-color: #FF00FF");
				rootGroup.getChildren().add(rootPane);
				Pane newPane = new Pane();
				newPane.setPrefSize(300, 300);
				rootGroup.getChildren().add(newPane);
//				gameScene = new Scene(rootGroup);
//				// Not sure if this is right...
//				appStage.setScene(gameScene);

				controlPane = new LayablePane();
				layables.add(controlPane);
				controlPane.setPrefSize(Location.TopLayout.controlPaneWidth, Location.TopLayout.controlPaneHeight);
				rootGroup.getChildren().add(controlPane);
				controlPane.setLayoutX(Location.TopLayout.controlPaneX);
				controlPane.setStyle("-fx-background-color: #000000");

				gameScene = new Scene(rootGroup);
				// Not sure if this is right...
				appStage.setScene(gameScene);
	}
	public void Dialogue() {
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(5);
		grid.setHgap(5);
		//Defining the Name text field
		final TextField name = new TextField();
		name.setPromptText("Enter your first name.");
		name.setPrefColumnCount(10);
		name.getText();
		GridPane.setConstraints(name, 0, 0);
		grid.getChildren().add(name);
		//Defining the Last Name text field
		final TextField lastName = new TextField();
		lastName.setPromptText("Enter your last name.");
		GridPane.setConstraints(lastName, 0, 1);
		grid.getChildren().add(lastName);
		//Defining the Comment text field
		final TextField comment = new TextField();
		comment.setPrefColumnCount(15);
		comment.setPromptText("Enter your comment.");
		GridPane.setConstraints(comment, 0, 2);
		grid.getChildren().add(comment);
		//Defining the Submit button
		Button submit = new Button("Submit");
		GridPane.setConstraints(submit, 1, 0);
		grid.getChildren().add(submit);
		//Defining the Clear button
		Button clear = new Button("Clear");
		GridPane.setConstraints(clear, 1, 1);
		grid.getChildren().add(clear);
	}


	public void createButtons () {

		 // create a text input dialog
//	        TextInputDialog td = new TextInputDialog("Enter X co-ordinates");
//	        TextInputDialog td1 = new TextInputDialog("Enter Y co-ordinates");
//	        // setHeaderText
//	        td.setHeaderText("enter your name");
//
//	        final Popup popup = new Popup(); popup.setX(300); popup.setY(200);
//		    popup.getContent().add(td,td1);

		LayableButton button = new LayableButton("Choose File");
//		button.setOnAction(value -> {new EventHandler<ActionEvent>() {
//		      @Override public void handle(ActionEvent event) {
//		          popup.show(Dialogue);
//		        }
//		      });

		addButtonToControlPanel(button);
		button.setOnAction(e -> {
			System.out.println("File manager stuff here");
			FileChooser fileChooser = new FileChooser();
			fileChooser.setInitialDirectory(new File(System.getProperty("user.home").concat("/Documents/SoundDir")));
			fileChooser.setTitle("Open Audio File");
			ExtensionFilter selectedExtensionFilter = new FileChooser.ExtensionFilter("WAV", "*.wav");
			fileChooser.getExtensionFilters().addAll(
					new FileChooser.ExtensionFilter("All Files", "*.*"),
					new FileChooser.ExtensionFilter("AAC", "*.aac"),
					new FileChooser.ExtensionFilter("MP3", "*.mp3"),
					selectedExtensionFilter
            );
			fileChooser.setSelectedExtensionFilter(selectedExtensionFilter);
			File chosenFile = fileChooser.showOpenDialog(appStage);
			path = chosenFile.getPath();

			Sound sound = new Sound();
			sound.setUri(Paths.get(path).toUri().toString());
			try {
				sound.play();
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			System.out.println("played that");

		});
//
//		Sound sound = new Sound();
//		sound.setUri(path);
//		try {
//			sound.play();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

//		System.out.println("played that");

		button = new LayableButton("Rectangle");
		//TODO
		//button.setOnAction(value -> {
//			gameEngine.reset();
		//});
		addButtonToControlPanel(button);

		button = new LayableButton("Triangle");
		//button.setOnAction(value -> {
//			gameEngine.pause();
		//});
		addButtonToControlPanel(button);

		MenuItem menuItem1 = new MenuItem("Audio1");
		menuItem1.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	System.out.println("Option 1 selected");
				Sound sound = new Sound("src/main/resources/mixkit-arcade-game-complete-or-approved-mission-205.wav");
				try {
					sound.play();
				} catch (Exception e) {
					e.printStackTrace();
				}
		    }
		});

		MenuItem menuItem2 = new MenuItem("Audio2");
		menuItem2.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		        System.out.println("Option 3 selected");
		    }
		});

		MenuItem menuItem3 = new MenuItem("Audio3");
		menuItem3.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		        System.out.println("Option 3 selected");
		    }
		});

		//TODO get these working
		//I get a bad URI on my machine - Isaiah
		//We need to figure out a way to make it work on all development platforms
		menuItem1.setGraphic(new ImageView(new Image("icons8-audio-30.png")));
		menuItem2.setGraphic(new ImageView(new Image("icons8-audio-30.png")));
		menuItem3.setGraphic(new ImageView(new Image("icons8-audio-30.png")));


		LayableMenuButton menubutton = new LayableMenuButton ("Audio");

		menubutton.getItems().add(menuItem1);
		menubutton.getItems().add(menuItem2);
		menubutton.getItems().add(menuItem3);
		menubutton.setGraphic(new ImageView(new Image("icons8-audio-30.png")));
		addMenuButtonToControlPanel(menubutton);

		//Not sure if this goes here, it was leftover from a bad merge
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

	public void addMenuButtonToControlPanel(LayableMenuButton menubutton) {
		controlPane.AddChild(menubutton);
	}

	public Scene getGameScene() {
		return gameScene;
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

}
