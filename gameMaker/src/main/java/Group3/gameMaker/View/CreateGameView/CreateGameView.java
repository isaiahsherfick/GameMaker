package Group3.gameMaker.View.CreateGameView;

import Group3.gameMaker.View.View;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Group3.gameMaker.Constants.*;

public class CreateGameView implements View
{
	public CreateGameView(Stage appStage) {
		appStage.setX(Constants.WINDOW_PADDING);
		appStage.setY(Constants.WINDOW_PADDING);
		appStage.setHeight(Constants.CREATE_PANEL_HEIGHT);
		appStage.setWidth(Constants.CREATE_PANEL_WIDTH);
		appStage.setTitle("Main Window");
		MainWindow mainWindow = new MainWindow(appStage);
		mainWindow.makeStage();

		Stage createStage = new Stage();
		createStage.setX(Constants.WINDOW_PADDING);
		createStage.setY(Constants.WINDOW_PADDING);
		createStage.setHeight(Constants.CREATE_PANEL_HEIGHT);
		createStage.setWidth(Constants.CREATE_PANEL_WIDTH);
		createStage.setTitle("Create Panel");
		CreatePanelWindow createPanelWindow = new CreatePanelWindow(createStage);
		createPanelWindow.makeStage();
		createPanelWindow.createButtons();

		Stage modifyStage = new Stage();
		modifyStage.setX(Constants.WINDOW_PADDING);
		modifyStage.setY(Constants.WINDOW_PADDING);
		modifyStage.setHeight(Constants.MODIFY_PANEL_HEIGHT);
		modifyStage.setWidth(Constants.MODIFY_PANEL_WIDTH);
		modifyStage.setTitle("Sprite Properties");
		ModifyPanelWindow modifyPanelWindow = new ModifyPanelWindow(modifyStage);
		modifyPanelWindow.makeStage();

//		LayoutManager layoutManager = new LayoutManager(appStage);
//		layoutManager.makeStage();

		createStage.show();
		modifyStage.show();
		appStage.show();




    	//Canvas gameCanvas = layoutManager.getGameCanvas();
//		Scene gameScene = layoutManager.getGameScene();

//		layoutManager.createButtons();
//		layoutManager.showStage();

	}

	public void update()
	{
		//TODO: called by CreateGameModel
		//when model's state has changed
		//probably just fetch state of cgm
	}
}
