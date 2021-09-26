//GameMaker.java
//    Created by: Isaiah Sherfick
//    Created on: 22 Sep 2021
//     Edited by: Snehal Patare
//Edited last by: Isaiah Sherfick
//   Last change: Created GameMaker.java 





package Group3.gameMaker.Application;
<<<<<<< HEAD
=======

>>>>>>> c5cad0c0161a5114180e56e8dac315e07b80419d
import Group3.gameMaker.CreateGameView.LayoutManager;
//import CreateGameView.LayoutManager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GameMaker extends Application {
	@Override
	public void start(Stage stage) {
		try {
//			BorderPane root = new BorderPane();
//			Scene scene = new Scene(root,400,400);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.show();
			Stage appStage;
			LayoutManager layoutManager;
			
			appStage = stage;
	    	layoutManager = new LayoutManager(appStage);
	    	layoutManager.makeStage();
	    	
	    	//Canvas gameCanvas = layoutManager.getGameCanvas();
			Scene gameScene = layoutManager.getGameScene();
			
			layoutManager.createButtons();
			layoutManager.showStage();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
