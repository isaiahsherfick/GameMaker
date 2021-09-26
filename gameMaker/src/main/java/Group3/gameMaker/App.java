package Group3.gameMaker;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends Application
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
