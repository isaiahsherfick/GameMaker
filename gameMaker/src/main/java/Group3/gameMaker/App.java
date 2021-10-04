package Group3.gameMaker;

import Group3.gameMaker.View.CreateGameView.LayoutManager;
import Group3.gameMaker.Controller.CreateGameController.CreateGameController;
import Group3.gameMaker.Model.CreateGameModel.CreateGameModel;
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
	@Override

	public void start(Stage primaryStage)
	{


		Stage appStage = primaryStage;
		CreateGameModel createGameModel = new CreateGameModel();
		CreateGameView createGameView = new CreateGameView(appStage);
		CreateGameController createGameController = new CreateGameController();
		createGameView.setCreateGameController(createGameController);
		createGameModel.addObserver(createGameView);
		createGameModel.setCreateGameController(createGameController);
		createGameController.setCreateGameModel(createGameModel);
		createGameController.setCreateGameView(createGameView);

	}

    public static void main(String[] args)
    {
        //placeholder for now
        launch(args);
    }

	public static void switchContexts() 
	{
		//switch between play/create contexts
	}
}
