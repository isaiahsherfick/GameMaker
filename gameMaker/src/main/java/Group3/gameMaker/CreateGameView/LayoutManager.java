
//    Created by: Snehal Patare
//    Created on: 25 Sep 2021
//     Edited by:
//Edited last by: Snehal Patare




package Group3.gameMaker.CreateGameView;

import java.util.ArrayList;

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



public class LayoutManager implements Layable {
	
	// Main Window
	public Stage appStage;
	public Group rootGroup;
	public Pane rootPane;
	public LayoutType currentLayout = LayoutType.RIGHT;
	
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
				Pane rootPane = new Pane();
				rootPane.setPrefSize(Location.RightLayout.rootPaneWidth, Location.RightLayout.rootPaneHeight);
				rootPane.setStyle("-fx-background-color: #FF00FF");
				rootGroup.getChildren().add(rootPane);
				
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
	
	
	public void createButtons () {
		 
		    
		 // create a text input dialog
//	        TextInputDialog td = new TextInputDialog("Enter X co-ordinates");
//	        TextInputDialog td1 = new TextInputDialog("Enter Y co-ordinates");
//	        // setHeaderText
//	        td.setHeaderText("enter your name");
//	        
//	        final Popup popup = new Popup(); popup.setX(300); popup.setY(200);
//		    popup.getContent().add(td,td1);
//	  
		
		LayableButton button = new LayableButton("Circle");
//		button.setOnAction(value -> {new EventHandler<ActionEvent>() {
//		      @Override public void handle(ActionEvent event) {
//		          popup.show(Dialogue);
//		        }
//		      });
		button = new LayableButton("Rectangle");
		//button.setOnAction(value -> {
////			gameEngine.reset();
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
		        System.out.println("Option 3 selected");
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
		
		menuItem1.setGraphic(new ImageView(new Image("icons8-audio-30.png")));
		menuItem2.setGraphic(new ImageView(new Image("icons8-audio-30.png")));
		menuItem3.setGraphic(new ImageView(new Image("icons8-audio-30.png")));
		
		
		LayableMenuButton menubutton = new LayableMenuButton ("Audio");
		
		menubutton.getItems().add(menuItem1);
		menubutton.getItems().add(menuItem2);
		menubutton.getItems().add(menuItem3);
		menubutton.setGraphic(new ImageView(new Image("icons8-audio-30.png")));
		addMenuButtonToControlPanel(menubutton);
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
