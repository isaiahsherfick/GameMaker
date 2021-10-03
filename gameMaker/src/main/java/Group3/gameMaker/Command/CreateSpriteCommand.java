package Group3.gameMaker.Command;

import Group3.gameMaker.Sprite.Sprite;
import Group3.gameMaker.Sprite.SpriteMaster;

public class CreateSpriteCommand implements Command
{
	private Sprite subject;
	private SpriteMaster sm;
	private int spriteId;
	
	public CreateSpriteCommand(Sprite newSprite, SpriteMaster sm)
	{
		subject = newSprite;
	}
	
	public void execute()
	{
		sm.add(subject);
		spriteId = subject.getSpriteId();
	}
	public void unexecute()
	{
		sm.deleteSprite(spriteId);
	}
}
