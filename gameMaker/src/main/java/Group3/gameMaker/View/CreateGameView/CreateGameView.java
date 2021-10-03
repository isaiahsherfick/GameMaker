package Group3.gameMaker.View.CreateGameView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import Group3.gameMaker.Controller.Controller;
import Group3.gameMaker.Controller.CreateGameController.CreateGameController;
import Group3.gameMaker.Sprite.Sprite;
import Group3.gameMaker.Sprite.Strategy.EventStrategy.EventStrategy;
import Group3.gameMaker.View.View;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Group3.gameMaker.Constants.*;

public class CreateGameView implements View
{
	private Controller createGameController;
	private HashMap<Integer,Integer> spriteIds;

	public CreateGameView()
	{
		
	}
	
	public CreateGameView(Stage appStage) {
//		appStage.setX(Constants.MAIN_WINDOW_X);
//		appStage.setY(Constants.MAIN_WINDOW_Y);
		appStage.centerOnScreen();
		appStage.setHeight(Constants.MAIN_WINDOW_HEIGHT);
		appStage.setWidth(Constants.MAIN_WINDOW_WIDTH);
		appStage.setTitle("Main Window");
		MainWindow mainWindow = new MainWindow(appStage);
//		appStage.setResizable(false);
		mainWindow.makeStage();

		Stage createStage = new Stage();
		createStage.setX(Constants.CREATE_PANEL_X);
		createStage.setY(Constants.CREATE_PANEL_Y);
		createStage.setHeight(Constants.CREATE_PANEL_HEIGHT);
		createStage.setWidth(Constants.CREATE_PANEL_WIDTH);
		createStage.setTitle("Create Panel");
//		createStage.setResizable(false);
		CreatePanelWindow createPanelWindow = new CreatePanelWindow(createStage);
		createPanelWindow.makeStage();
		createPanelWindow.createButtons();

		Stage modifyStage = new Stage();
		modifyStage.setX(Constants.MODIFY_PANEL_X);
		modifyStage.setY(Constants.MODIFY_PANEL_Y);
		modifyStage.setHeight(Constants.MODIFY_PANEL_HEIGHT);
		modifyStage.setWidth(Constants.MODIFY_PANEL_WIDTH);
		modifyStage.setTitle("Sprite Properties");
//		modifyStage.setResizable(false);
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
	
	public void drawSprite(int spriteId)
	{
		//System.out.printf("Drawing Sprite#%d\n",spriteId);
	}
	
	public void drawSprites()
	{
		spriteIds = createGameController.getSpriteIds();
		for (Entry<Integer, Integer> entry : spriteIds.entrySet())
		{
			drawSprite(entry.getKey());
		}
		//System.out.printf("Done drawing sprites\n");
	}

	public void update()
	{
		drawSprites();
		spriteIds = createGameController.getSpriteIds();
	}
	
	public void setCreateGameController(CreateGameController c)
	{
		createGameController = c;
	}

	public void createSprite() 
	{
		Sprite s = new Sprite();
		createGameController.createSprite(s);
	}
	
	public Sprite getSprite(int spriteId)
	{
		return createGameController.getSprite(spriteId);
	}
	
	public void addEventStrategy(EventStrategy e, int spriteId)
	{

		Sprite s = createGameController.getSprite(spriteId).copy();
		s.addEventStrategy(e);
		createGameController.modifySprite(s);
	}
	

	public void undo() 
	{
		createGameController.undo();
	}

	public void redo() 
	{
		createGameController.redo();
	}
}
