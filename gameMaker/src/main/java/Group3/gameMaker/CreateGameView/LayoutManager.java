
//    Created by: Snehal Patare
//    Created on: 25 Sep 2021
//     Edited by:
//Edited last by: Snehal Patare




package Group3.gameMaker.CreateGameView;

import java.util.ArrayList;

import javax.swing.JRootPane;

import Group3.gameMaker.CreateGameView.Layable;
import javafx.scene.*;
import javafx.scene.layout.Pane;
import javafx.stage.*;



public class LayoutManager implements Layable {
	
	// Main Window
	public Stage appStage;
	public Group rootGroup;
	public Pane rootPane;
	
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
