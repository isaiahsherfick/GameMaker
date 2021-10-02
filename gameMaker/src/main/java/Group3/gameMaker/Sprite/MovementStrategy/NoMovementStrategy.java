package Group3.gameMaker.Sprite.MovementStrategy;

import org.json.simple.JSONObject;

import Group3.gameMaker.Sprite.Sprite;

public class NoMovementStrategy implements MovementStrategy
{
	public void move()
	{
		return;
	}

	public Sprite getSubject()
	{
		return null;
	}

	public void setSubject(Sprite s)
	{

	}

	@Override
	public JSONObject save()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void load(JSONObject saveJSON) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getVelocityX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getVelocityY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setVelocityX(int velocityX) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setVelocityY(int velocityY) {
		// TODO Auto-generated method stub

	}
}
