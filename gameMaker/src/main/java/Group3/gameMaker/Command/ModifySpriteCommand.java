package Group3.gameMaker.Command;

import Group3.gameMaker.Sprite.Sprite;
import Group3.gameMaker.Sprite.SpriteMaster;

public class ModifySpriteCommand implements Command
{
	private Sprite subject;
	private Sprite previousState;
	private int spriteId;
	private SpriteMaster spriteMaster;
	
	public ModifySpriteCommand(Sprite s, SpriteMaster sm)
	{
		subject = s;
		spriteId = s.getSpriteId();
		spriteMaster = sm;
	}
	
	@Override
	public void execute() 
	{
		previousState = spriteMaster.get(spriteId);
		spriteMaster.modifySprite(subject);
	}

	@Override
	public void unexecute() {
		if (previousState != null)
		{
			spriteMaster.modifySprite(previousState);
		}
	}

}
