
package Group3.gameMaker.Model;

import Group3.gameMaker.Sprite.Sprite;
import Group3.gameMaker.Sprite.SpriteMaster;
import Group3.gameMaker.View.View;

public interface Model
{
	public Sprite getSprite(int spriteId);
	public void addObserver(View newObserver);
	public void notifyObservers();
	public SpriteMaster getSpriteMaster();
	public void deleteSprite(int spriteId);
	public void modifySprite(Sprite modifiedSprite);
}
