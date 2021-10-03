package Group3.gameMaker.Command;

import Group3.gameMaker.Model.CreateGameModel.CreateGameModel;
import Group3.gameMaker.Sprite.Sprite;
import Group3.gameMaker.Sprite.SpriteMaster;

public class CreateSpriteCommand implements Command
{
	private Sprite subject;
	private CreateGameModel model;
	private int spriteId;
	
	public CreateSpriteCommand(Sprite newSprite, CreateGameModel cgm)
	{
		subject = newSprite;
		model = cgm;
	}
	
	public void execute()
	{
		model.addSprite(subject);
		spriteId = subject.getSpriteId();
	}
	public void unexecute()
	{
		model.deleteSprite(spriteId);
	}
}
