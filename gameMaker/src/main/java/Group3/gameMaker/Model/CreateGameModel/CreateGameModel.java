//CreateGameModel.java
//    Created by: Isaiah Sherfick
//    Created on: 29 Sep 2021
//     Edited by:
//Edited last by: Isaiah Sherfick
//   Last change: Created CreateGameModel.java

package Group3.gameMaker.Model.CreateGameModel;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import Group3.gameMaker.Controller.CreateGameController.CreateGameController;
import Group3.gameMaker.Model.Model;
import Group3.gameMaker.SaveAndLoad.SaveFileManager;
import Group3.gameMaker.SaveAndLoad.Saveable;
import Group3.gameMaker.Sprite.Sprite;
import Group3.gameMaker.Sprite.SpriteMaster;
import Group3.gameMaker.View.View;
import Group3.gameMaker.View.CreateGameView.CreateGameView;

public class CreateGameModel implements Model
{

	private SaveFileManager saveFileManager;
	private SpriteMaster spriteMaster;
	private CreateGameController createGameController;
	private ArrayList<View> observers;

	//register a view
	public void addObserver(View newObserver)
	{
		observers.add(newObserver);
	}

	//update views
	public void notifyObservers()
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
		observers = new ArrayList<>();
	}

	//adds a sprite to the spritemaster.
	//spritemaster.add updates the sprite's spriteId variable
	//to be the key where that sprite is stored in the spritemaster
	public void addSprite(Sprite s)
	{
		spriteMaster.add(s);
		notifyObservers();
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
		notifyObservers();
	}

	public void setSpriteMaster(SpriteMaster sm)
	{
		spriteMaster = sm;
		notifyObservers();
	}

	public SpriteMaster getSpriteMaster() 
	{
		return spriteMaster;
	}

	//save everything in the spritemaster to the savefilemanager then call savefile
	public void saveFile() throws IOException
	{
		ArrayList<Sprite> sprites = spriteMaster.getAllSprites();
		saveFileManager.clearSaveObjects();
		for (int i = 0; i < sprites.size(); i++)
		{
			saveFileManager.addSaveObject((Saveable)sprites.get(i));
		}
		saveFileManager.saveFile();
		notifyObservers();
	}

	public void loadFile() throws IOException, ParseException
	{
		//reset the spriteMaster so we can insert all of the restored state into it
		spriteMaster = new SpriteMaster();

		saveFileManager.loadFile();
		ArrayList<Saveable> restoredObjects = saveFileManager.getSaveObjects();

		//I don't think we'll save anything that isn't a sprite, but just in case:
		for (int i = 0; i < restoredObjects.size(); i++)
		{
			if (restoredObjects.get(i) instanceof Sprite)
			{
				spriteMaster.add((Sprite)restoredObjects.get(i));
			}
		}
		notifyObservers();
	}
	
	public void deleteSprite(int spriteId)
	{
		spriteMaster.deleteSprite(spriteId);
		notifyObservers();
	}

	//Passes modifiedSprite to the SpriteMaster
	//and overwrites the one stored at spriteId
	public void modifySprite(Sprite modifiedSprite) 
	{
		spriteMaster.modifySprite(modifiedSprite);
		notifyObservers();
	}
}
