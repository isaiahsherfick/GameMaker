package Group3.gameMaker.View;

import java.util.ArrayList;

import Group3.gameMaker.Sprite.Sprite;

public interface View
{
	public void update(); //Views observe models

	public void setCurrentSpriteId(int spriteId);

	public ArrayList<Sprite> getAllSprites();

	public void modifySprite(Sprite selectedSprite);
}
