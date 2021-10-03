
package Group3.gameMaker.Controller.CreateGameController;

import java.io.IOException;
import java.util.HashMap;

import org.json.simple.parser.ParseException;

import Group3.gameMaker.Command.Command;
import Group3.gameMaker.Command.CommandInvoker;
import Group3.gameMaker.Command.CreateSpriteCommand;
import Group3.gameMaker.Command.DeleteSpriteCommand;
import Group3.gameMaker.Controller.Controller;
import Group3.gameMaker.Controller.PlayGameController.PlayGameController;
import Group3.gameMaker.Model.CreateGameModel.CreateGameModel;
import Group3.gameMaker.Sprite.Sprite;
import Group3.gameMaker.Sprite.Strategy.CollisionStrategy.CollisionDetector;
import Group3.gameMaker.View.CreateGameView.CreateGameView;
import Group3.gameMaker.View.PlayGameView.PlayGameView;

public class CreateGameController implements Controller
{
	private CreateGameView createGameView;
	private CreateGameModel createGameModel;
	private CommandInvoker commandInvoker;
	
	public static final int LOAD_SUCCESS = 0;
	public static final int CANT_FIND_FILE = 1;
	public static final int BAD_JSON = 2;
	
	public CreateGameController()
	{
		commandInvoker = new CommandInvoker();
	}

	public CreateGameController(CreateGameView cgv, CreateGameModel cgm) 
	{
		createGameModel = cgm;
		createGameView = cgv;
		commandInvoker = new CommandInvoker();
	}

	public CreateGameView getCreateGameView() 
	{
		return createGameView;
	}

	public void setCreateGameView(CreateGameView createGameView) 
	{
		this.createGameView = createGameView;
	}

	public void setCreateGameModel(CreateGameModel createGameModel) 
	{
		this.createGameModel = createGameModel;
	}

	public CreateGameModel getCreateGameModel() 
	{
		return createGameModel;
	}

	public void createSprite(Sprite sprite) 
	{
		commandInvoker.receiveCommand(new CreateSpriteCommand(sprite, createGameModel.getSpriteMaster()));
	}
	
	public Sprite getSprite(int spriteId)
	{
		return createGameModel.getSprite(spriteId);
	}
	
	public void deleteSprite(int spriteId)
	{
		commandInvoker.receiveCommand(new DeleteSpriteCommand(spriteId, createGameModel.getSpriteMaster()));
	}
	
	//Returns true on success
	//False on IOException 
	public boolean save()
	{
		try 
		{
			createGameModel.saveFile();
			return true;
		} 
		catch (IOException e) 
		{
			return false;
		}
	}
	
	//Returns 0 on success
	//Returns 1 on IOException (file doesn't exist)
	//Returns 2 on ParseException (bad JSON)
	public int load()
	{
			try 
			{
				createGameModel.loadFile();
				return LOAD_SUCCESS;
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
				return CANT_FIND_FILE;
			} 
			catch (ParseException e) 
			{
				e.printStackTrace();
				return BAD_JSON;
			}
	}
	
	//Passes a sprite which has been modified by the view to the model's spritemaster
	public void modifySprite(Sprite modifiedSprite) 
	{
		
	}


	public void undo() 
	{
		// TODO Auto-generated method stub
		
	}

	public void redo() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public HashMap<Integer, Integer> getSpriteIds() 
	{
		HashMap<Integer,Integer> spriteIds = new HashMap<>();
		
	}
}
