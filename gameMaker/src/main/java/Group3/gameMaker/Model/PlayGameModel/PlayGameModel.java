package Group3.gameMaker.Model.PlayGameModel;

import java.util.ArrayList;

import Group3.gameMaker.Controller.Controller;
import Group3.gameMaker.Controller.PlayGameController.PlayGameController;
import Group3.gameMaker.Model.Model;
import Group3.gameMaker.Model.CreateGameModel.CreateGameModel;
import Group3.gameMaker.Sprite.Sprite;
import Group3.gameMaker.Sprite.SpriteMaster;
import Group3.gameMaker.View.View;

public class PlayGameModel implements Model
{
	private ArrayList<View> observers;
	private SpriteMaster spriteMaster;
	private Controller playGameController;
	private Model createGameModel;
	
	public PlayGameModel()
	{
		observers = new ArrayList<>();
	}

	public Sprite getSprite(int spriteId) 
	{
		return spriteMaster.get(spriteId);
	}

	public void notifyObservers()
	{
		for (int i = 0; i < observers.size(); i++)
		{
			observers.get(i).update();
		}
	}

	public void addObserver(View newObserver) 
	{
		observers.add(newObserver);
	}

	public SpriteMaster getSpriteMaster() 
	{
		return spriteMaster;
	}

	public void deleteSprite(int spriteId) 
	{
		//can't be done in play game context
	}

	public void modifySprite(Sprite modifiedSprite) 
	{
		//can/t be done in play context
	}

	public void setPlayGameController(PlayGameController c) 
	{
		playGameController = c;
	}
	
	//Pulls the state from the create game model
	//so that changes can be reflected in the play context
	public void pull()
	{
		spriteMaster = createGameModel.getSpriteMaster();
	}

	public void setCreateGameModel(CreateGameModel cm) 
	{
		createGameModel = cm;
	}
}
