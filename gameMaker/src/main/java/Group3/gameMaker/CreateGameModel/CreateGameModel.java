//CreateGameModel.java
//    Created by: Isaiah Sherfick
//    Created on: 29 Sep 2021
//     Edited by:
//Edited last by: Isaiah Sherfick
//   Last change: Created CreateGameModel.java

package Group3.gameMaker.CreateGameModel;

import java.util.ArrayList;

import Group3.gameMaker.CreateGameController.CreateGameController;
import Group3.gameMaker.CreateGameView.CreateGameView;
import Group3.gameMaker.SaveAndLoad.SaveFileManager;
import Group3.gameMaker.Sprite.Sprite;
import Group3.gameMaker.Sprite.SpriteMaster;

public class CreateGameModel 
{
	
	private SaveFileManager saveFileManager;
	private SpriteMaster spriteMaster;
	private CreateGameController createGameController;
	private ArrayList<CreateGameView> observers;
	
	//register a view
	private void addObserver(CreateGameView newObserver)
	{
		observers.add(newObserver);
	}
	
	//update views
	private void notifyObservers()
	{
		for (int i = 0; i < observers.size(); i++)
		{
			observers.get(i).update();
		}
	}
	
	public CreateGameModel()
	{
		this.saveFileManager = new SaveFileManager();
		this.spriteMaster = new SpriteMaster();
	}
	
	//adds a sprite to the spritemaster.
	//spritemaster.add updates the sprite's spriteId variable
	//to be the key where that sprite is stored in the spritemaster
	public void addSprite(Sprite s)
	{
		spriteMaster.add(s);
	}
	
	//TODO implement a NullSpriteException or something like that
	public Sprite getSprite(int spriteId)
	{
		return spriteMaster.get(spriteId);
	}
	
	public void setCreateGameController(CreateGameController cgc)
	{
		createGameController = cgc;
	}
	
	public void setSaveFileManager(SaveFileManager sfm)
	{
		saveFileManager = sfm;
	}
	
	public void setPathToSaveFile(String path)
	{
		saveFileManager.setPathToSaveFile(path);
	}
	
	public void setSpriteMaster(SpriteMaster sm)
	{
		spriteMaster = sm;
	}
}
