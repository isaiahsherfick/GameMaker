package Group3.gameMaker.Sprite.Strategy.EventStrategy;

import Group3.gameMaker.SaveAndLoad.Saveable;
import Group3.gameMaker.Sprite.Sprite;

public interface EventStrategy extends Saveable
{
	public void onClockTick();
	public void onKeyPress();
	public void onMouseClick();
	public void setSubject(Sprite s);
}
