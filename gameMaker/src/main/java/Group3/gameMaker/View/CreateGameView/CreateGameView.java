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
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import Group3.gameMaker.App;
import Group3.gameMaker.Constants.*;

public class CreateGameView implements View
{
	private Controller createGameController;
	private HashMap<Integer,Integer> spriteIds;
	private MainWindow mainWindow;
	private CreatePanelWindow createPanelWindow;
	private ModifyPanelWindow modifyPanelWindow;
	private int currentSpriteId = -2;
	private Stage createStage;
	private Stage modifyStage;
	private Stage appStage;


	public CreateGameView(Stage stage) {
//		appStage.setX(Constants.MAIN_WINDOW_X);
//		appStage.setY(Constants.MAIN_WINDOW_Y);
		appStage = stage;
		appStage.centerOnScreen();
		appStage.setHeight(Constants.MAIN_WINDOW_HEIGHT);
		appStage.setWidth(Constants.MAIN_WINDOW_WIDTH);
		appStage.setTitle("Main Window");
		mainWindow = new MainWindow(this, appStage);
//		appStage.setResizable(false);
		//mainWindow.makeStage();

		createStage = new Stage();
		createStage.setX(Constants.CREATE_PANEL_X);
		createStage.setY(Constants.CREATE_PANEL_Y);
		createStage.setHeight(Constants.CREATE_PANEL_HEIGHT);
		createStage.setWidth(Constants.CREATE_PANEL_WIDTH);
		createStage.setTitle("Create Panel");
//		createStage.setResizable(false);
		createPanelWindow = new CreatePanelWindow(this, createStage);
		createPanelWindow.createButtons();

		modifyStage = new Stage();
		modifyStage.setX(Constants.MODIFY_PANEL_X);
		modifyStage.setY(Constants.MODIFY_PANEL_Y);
		modifyStage.setHeight(Constants.CREATE_PANEL_HEIGHT);
		modifyStage.setWidth(Constants.CREATE_PANEL_WIDTH);
		modifyStage.setTitle("Sprite Properties");
		modifyStage.setResizable(false);
		modifyPanelWindow = new ModifyPanelWindow(this, modifyStage);
	}
	
	public void show()
	{
		createStage.show();
		modifyStage.show();
		appStage.show();
	}
	public void close()
	{
		createStage.close();
		appStage.close();
		modifyStage.close();
	}

	public CreateGameView() 
	{
		spriteIds = new HashMap<>();
	}

	public int getCurrentSpriteId() {
		return currentSpriteId;
	}

	public void setCurrentSpriteId(int spriteId) {
		this.currentSpriteId = spriteId;
		modifyPanelWindow.displaySprite(createGameController.getSprite(spriteId));
	}

	public void drawSprite(int spriteId)
	{
		createGameController.getSprite(spriteId).draw(mainWindow.getCanvas().getGraphicsContext2D());
		Sprite s = createGameController.getSprite(spriteId);
		GraphicsContext c = mainWindow.getGraphicsContext();
		s.draw(c);
		
	}

	public void drawSprites()
	{
		mainWindow.clearCanvas();
		spriteIds = createGameController.getSpriteIds();
		for (Entry<Integer, Integer> entry : spriteIds.entrySet())
		{
			drawSprite(entry.getKey());
		}
	}

	public void update()
	{
		drawSprites();
		spriteIds = createGameController.getSpriteIds();
		if (currentSpriteId != -2)
			modifyPanelWindow.displaySprite(createGameController.getSprite(currentSpriteId));
	}

	public void setCreateGameController(CreateGameController c)
	{
		createGameController = c;
	}

	public void createSprite()
	{
		Sprite s = new Sprite();
		createGameController.createSprite(s);
		currentSpriteId = s.getSpriteId();
	}

	public Sprite getSprite(int spriteId)
	{
		return createGameController.getSprite(spriteId);
	}

	public void modifySprite(Sprite sprite) {
		createGameController.modifySprite(sprite);
	}

	public ArrayList<Sprite> getAllSprites()
	{
		return createGameController.getAllSprites();
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

	public void save() 
	{
		if (createGameController.save())
		{

		}
		else
		{
			System.out.println("Save was unsuccessful");
		}
	}

	public void load() 
	{
		switch(createGameController.load())
		{
			case CreateGameController.BAD_JSON:
				System.out.println("JSON is corrupted - aborting load");
				break;
			case CreateGameController.CANT_FIND_FILE:
				System.out.println("Can't find savefile");
				break;
			default:
				break;
		}
		modifyPanelWindow.reset();
	}

	public void switchContexts() 
	{
		close();
		App.switchToPlay();
	}

	public Sprite getSelectedSprite() 
	{
		if (currentSpriteId == -2)
		{
			return null;
		}
		else return getSprite(currentSpriteId).copy();
	}
}
