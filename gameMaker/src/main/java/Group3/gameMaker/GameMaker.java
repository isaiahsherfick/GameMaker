//GameMaker.java
//    Created by: Isaiah Sherfick
//    Created on: 22 Sep 2021
//     Edited by:
//Edited last by: Isaiah Sherfick
//   Last change: Created GameMaker.java 


package Group3.gameMaker;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;



public class GameMaker extends Application
{
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
//			Stage appStage;
//			LayoutManager layoutManager;
//			
//			appStage = stage;
//	    	layoutManager = new LayoutManager(appStage);
//	    	layoutManager.makeStage();
//	    	
//	    	//Canvas gameCanvas = layoutManager.getGameCanvas();
//			Scene gameScene = layoutManager.getGameScene();
//			
//			layoutManager.createButtons();
//			layoutManager.showStage();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
    public static void main(String[] args)
    {
        //placeholder for now
        System.out.println("This is where we will launch the application.");
        launch(args);
    }
}
