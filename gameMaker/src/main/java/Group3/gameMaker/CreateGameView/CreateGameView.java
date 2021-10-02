package Group3.gameMaker.CreateGameView;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class CreateGameView
{
	public CreateGameView(Stage appStage) {
		LayoutManager layoutManager = new LayoutManager(appStage);
    	layoutManager.makeStage();

    	//Canvas gameCanvas = layoutManager.getGameCanvas();
		Scene gameScene = layoutManager.getGameScene();

		layoutManager.createButtons();
		layoutManager.showStage();

	}

	public void update()
	{
		//TODO: called by CreateGameModel
		//when model's state has changed
		//probably just fetch state of cgm
	}
}
