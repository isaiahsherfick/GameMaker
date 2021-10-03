package Group3.gameMaker.View.PlayGameView;

import java.util.HashMap;
import java.util.Map.Entry;

import Group3.gameMaker.Controller.Controller;
import Group3.gameMaker.Controller.PlayGameController.PlayGameController;
import Group3.gameMaker.Model.CreateGameModel.CreateGameModel;
import Group3.gameMaker.Model.PlayGameModel.PlayGameModel;
import Group3.gameMaker.View.View;

public class PlayGameView implements View
{
	private Controller playGameController;
	private HashMap<Integer,Integer> spriteIds;

	public PlayGameView() 
	{
		spriteIds = new HashMap<>();
	}

	public void update() 
	{
		drawSprites();
		spriteIds = playGameController.getSpriteIds();
	}

	public void drawSprite(int spriteId)
	{
		System.out.printf("Drawing Sprite#%d\n",spriteId);
	}
	
	public void drawSprites()
	{
		spriteIds = playGameController.getSpriteIds();
		for (Entry<Integer, Integer> entry : spriteIds.entrySet())
		{
			drawSprite(entry.getKey());
		}
		System.out.printf("Done drawing sprites\n");
	}

	public void setPlayGameController(PlayGameController c) 
	{
		playGameController = c;
	}

}
