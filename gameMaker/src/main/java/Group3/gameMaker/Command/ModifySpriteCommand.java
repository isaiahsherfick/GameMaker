package Group3.gameMaker.Command;

import Group3.gameMaker.Model.CreateGameModel.CreateGameModel;
import Group3.gameMaker.Sprite.Sprite;
import Group3.gameMaker.Sprite.SpriteMaster;

public class ModifySpriteCommand implements Command
{
	private Sprite subject;
	private Sprite previousState;
	private int spriteId;
	private CreateGameModel model;
	
	public ModifySpriteCommand(Sprite s, CreateGameModel cgm)
	{
		subject = s;
		spriteId = s.getSpriteId();
		model = cgm;
	}
	
	@Override
	public void execute() 
	{
		previousState = model.getSprite(spriteId).copy();
		model.modifySprite(subject);
	}

	@Override
	public void unexecute() {
		if (previousState != null)
		{
			model.modifySprite(previousState);
			previousState = subject;
		}
	}

}
