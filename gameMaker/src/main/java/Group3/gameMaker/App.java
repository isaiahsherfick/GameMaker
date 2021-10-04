package Group3.gameMaker;

import Group3.gameMaker.View.CreateGameView.LayoutManager;
import Group3.gameMaker.View.PlayGameView.PlayGameView;
import Group3.gameMaker.Controller.Controller;
import Group3.gameMaker.Controller.CreateGameController.CreateGameController;
import Group3.gameMaker.Controller.PlayGameController.PlayGameController;
import Group3.gameMaker.Model.Model;
import Group3.gameMaker.Model.CreateGameModel.CreateGameModel;
import Group3.gameMaker.Model.PlayGameModel.PlayGameModel;
import Group3.gameMaker.View.View;
import Group3.gameMaker.View.CreateGameView.CreateGameView;
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
	private static CreateGameModel createGameModel;
	private static CreateGameController createGameController;
	private static CreateGameView createGameView;
	
	private static PlayGameModel playGameModel;
	private static PlayGameController playGameController;
	private static PlayGameView playGameView;
	
	private static final int PLAY = 0;
	private static final int CREATE = 1;
	
	private int currentContext = CREATE;
	
	public void start(Stage primaryStage)
	{


		Stage appStage = primaryStage;
		createGameModel = new CreateGameModel();
		createGameView = new CreateGameView(appStage);
		createGameController = new CreateGameController();

		createGameView.setCreateGameController(createGameController);
		createGameModel.addObserver(createGameView);
		createGameModel.setCreateGameController(createGameController);
		createGameController.setCreateGameModel(createGameModel);
		createGameController.setCreateGameView(createGameView);
		
		playGameModel = new PlayGameModel();
		playGameView = new PlayGameView(appStage);
		playGameController = new PlayGameController();

		playGameView.setPlayGameController(playGameController);
		playGameModel.addObserver(playGameView);
		playGameModel.setPlayGameController(playGameController);
		playGameController.setPlayGameModel(playGameModel);
		playGameController.setPlayGameView(playGameView);
		
		switch(currentContext)
		{
			case PLAY:
				playGameView.show();
				break;
			case CREATE:
				createGameView.show();
				break;
			default:
				createGameView.show();
				break;
		}
		

	}
	
    public static void main(String[] args)
    {
        launch(args);
    }
    
    public static void switchToPlay()
    {
    	playGameView.show();
    }

	public static void switchToCreate() 
	{
		createGameView.show();
	}
}
