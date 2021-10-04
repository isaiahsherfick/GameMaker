package Group3.gameMaker.View.PlayGameView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import Group3.gameMaker.App;
import Group3.gameMaker.Constants.Constants;
import Group3.gameMaker.Controller.Controller;
import Group3.gameMaker.Controller.PlayGameController.PlayGameController;
import Group3.gameMaker.Model.CreateGameModel.CreateGameModel;
import Group3.gameMaker.Model.PlayGameModel.PlayGameModel;
import Group3.gameMaker.Sprite.Sprite;
import Group3.gameMaker.View.View;
import Group3.gameMaker.View.CreateGameView.MainWindow;
import javafx.stage.Stage;

public class PlayGameView implements View
{
	private PlayGameController metaGameController;
	private HashMap<Integer,Integer> spriteIds;
	private MainWindow mainWindow;
	private MetaButtonWindow metaButtonWindow;
	private int currentSpriteId = -2;
	
	private Stage metaStage;
	private Stage appStage;
	

	public PlayGameView(Stage stage) 
	{
		spriteIds = new HashMap<>();
		appStage = stage;
		appStage.centerOnScreen();

		appStage.setHeight(Constants.MAIN_WINDOW_HEIGHT);
		appStage.setWidth(Constants.MAIN_WINDOW_WIDTH);
		appStage.setTitle("Game Window");
		mainWindow = new MainWindow(this, appStage);
//		appStage.setResizable(false);
		//mainWindow.makeStage();

		metaStage = new Stage();
		metaStage.setX(Constants.CREATE_PANEL_X);
		metaStage.setY(Constants.CREATE_PANEL_Y);
		metaStage.setHeight(Constants.CREATE_PANEL_HEIGHT);
		metaStage.setWidth(Constants.CREATE_PANEL_WIDTH);
		metaStage.setTitle("Meta Buttons");
//		metaStage.setResizable(false);
		metaButtonWindow = new MetaButtonWindow(this, metaStage);
		metaButtonWindow.createButtons();
	}
	
	public PlayGameView()
	{
		spriteIds = new HashMap<>();
	}

	public void update() 
	{
		drawSprites();
		spriteIds = metaGameController.getSpriteIds();
	}

	public void drawSprite(int spriteId)
	{
		System.out.printf("Drawing Sprite#%d\n",spriteId);
	}
	
	public void drawSprites()
	{
		spriteIds = metaGameController.getSpriteIds();
		for (Entry<Integer, Integer> entry : spriteIds.entrySet())
		{
			drawSprite(entry.getKey());
		}
		System.out.printf("Done drawing sprites\n");
	}

	public void setPlayGameController(PlayGameController c) 
	{
		metaGameController = c;
	}

	public void unpause() {
		metaGameController.unpause();
	}

	public void pause() {
		metaGameController.pause();
	}

	@Override
	public void setCurrentSpriteId(int spriteId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Sprite> getAllSprites() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifySprite(Sprite selectedSprite) {
		// TODO Auto-generated method stub
		
	}

	public void show()
	{

		metaStage.show();
		appStage.show();
	}
	public void close()
	{
		metaStage.close();
		appStage.close();
	}

	public void switchContexts() 
	{
		close();
		App.switchToCreate();
	}
	
}
