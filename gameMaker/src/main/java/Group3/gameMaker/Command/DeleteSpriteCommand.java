package Group3.gameMaker.Command;

import Group3.gameMaker.Sprite.Sprite;
import Group3.gameMaker.Sprite.SpriteMaster;

public class DeleteSpriteCommand implements Command
{
	private int spriteId;
	private Sprite redoableSprite;
	private SpriteMaster spriteMaster;
	
	public DeleteSpriteCommand(int sid, SpriteMaster sm)
	{
		spriteId = sid;
		spriteMaster = sm;
	}
	
	public void execute()
	{
		redoableSprite = spriteMaster.get(spriteId);
		spriteMaster.deleteSprite(spriteId);
	}
	
	public void unexecute()
	{
		spriteMaster.add(redoableSprite);
	}
}
