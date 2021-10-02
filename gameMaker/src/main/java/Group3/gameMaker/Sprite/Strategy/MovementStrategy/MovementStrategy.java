package Group3.gameMaker.Sprite.MovementStrategy;

import Group3.gameMaker.SaveAndLoad.Saveable;
import Group3.gameMaker.Sprite.Sprite;

public interface MovementStrategy extends Saveable
{
	public void move();
	public Sprite getSubject();
	public void setSubject(Sprite s);
	public int getVelocityX();
	public int getVelocityY();
	public void setVelocityX(int velocityX);
	public void setVelocityY(int velocityY);
}
