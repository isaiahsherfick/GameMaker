package Group3.gameMaker.View.CreateGameView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import Group3.gameMaker.Controller.Controller;
import Group3.gameMaker.Controller.CreateGameController.CreateGameController;
import Group3.gameMaker.Sprite.Sprite;
import Group3.gameMaker.View.View;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CreateGameView implements View
{
	private Controller createGameController;
	private HashMap<Integer,Integer> spriteIds;

	public CreateGameView()
	{
		
	}
	
	public CreateGameView(Stage appStage) {
		LayoutManager layoutManager = new LayoutManager(appStage);
    	layoutManager.makeStage();

    	//Canvas gameCanvas = layoutManager.getGameCanvas();
		Scene gameScene = layoutManager.getGameScene();

		layoutManager.createButtons();
		layoutManager.showStage();

	}
	
	public void drawSprite(int spriteId)
	{
		System.out.printf("Drawing Sprite#%d\n",spriteId);
	}
	
	public void drawSprites()
	{
		for (Entry<Integer, Integer> entry : spriteIds.entrySet())
		{
			drawSprite(entry.getKey());
		}
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
}
