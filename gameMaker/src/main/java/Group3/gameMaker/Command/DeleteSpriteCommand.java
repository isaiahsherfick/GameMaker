package Group3.gameMaker.Command;

import Group3.gameMaker.Model.CreateGameModel.CreateGameModel;
import Group3.gameMaker.Sprite.Sprite;

public class DeleteSpriteCommand implements Command
{
	private int spriteId;
	private Sprite redoableSprite;
	private CreateGameModel model;
	
	public DeleteSpriteCommand(int sid, CreateGameModel cgm)
	{
		spriteId = sid;
		model = cgm;
	}
	
	public void execute()
	{
		redoableSprite = model.getSprite(spriteId);
		model.deleteSprite(spriteId);
	}
	
	public void unexecute()
	{
		model.addSprite(redoableSprite);
	}
}
