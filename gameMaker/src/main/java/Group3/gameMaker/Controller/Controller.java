package Group3.gameMaker.Controller;

import Group3.gameMaker.Sprite.Sprite;

public interface Controller
{
	public Sprite getSprite(int spriteId);
	public void deleteSprite(int spriteId);
	public void createSprite(Sprite s);
	public void modifySprite(Sprite s);
	public void undo();
	public void redo();
}