package Group3.gameMaker.Sprite.MovementStrategy;

import Group3.gameMaker.SaveAndLoad.Saveable;
import Group3.gameMaker.Sprite.Sprite;

public interface MovementStrategy extends Saveable
{
	public void move();
	public Sprite getSubject();
	public void setSubject(Sprite s);
}
