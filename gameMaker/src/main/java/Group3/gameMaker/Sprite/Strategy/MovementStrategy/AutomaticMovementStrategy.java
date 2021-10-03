package Group3.gameMaker.Sprite.Strategy.MovementStrategy;

import org.json.simple.JSONObject;

import Group3.gameMaker.Sprite.Sprite;
import Group3.gameMaker.Sprite.SpriteMaster;

public class AutomaticMovementStrategy implements MovementStrategy
{
	private int velocityX;
	private int velocityY;
	private int subjectId;
	private Sprite subject;


	public AutomaticMovementStrategy()
	{
		velocityX = 0;
		velocityY = 0;
		//TODO null Sprite
		subject = null;
		subjectId = -2;
	}

	//Defualt constructor
	//By default stuff moves 5 on the x and y so the user can get instant confirmation
	//That the sprite does indeed move automatically
	public AutomaticMovementStrategy(Sprite s)
	{
		subject = s;
		subjectId = s.getSpriteId();
		velocityX = 5;
		velocityY = 5;
	}
	public AutomaticMovementStrategy(Sprite s, int xv, int yv)
	{
		subject = s;
		subjectId = s.getSpriteId();
		velocityX = xv;
		velocityY = yv;
	}
	public void move()
	{
		int x = subject.getX();
		int y = subject.getY();
		subject.setX(x + velocityX);
		subject.setY(y + velocityY);
	}
	public int getVelocityX()
	{
		// TODO Auto-generated method stub
		return velocityX;
	}
	public int getVelocityY()
	{
		// TODO Auto-generated method stub
		return velocityY;
	}
	@Override
	public Sprite getSubject()
	{
		return subject;
	}
	@Override
	public void setSubject(Sprite s)
	{
		subject = s;
		subjectId = s.getSpriteId();
	}
	@SuppressWarnings("unchecked")
	@Override
	public JSONObject save()
	{
		JSONObject obj = new JSONObject();
		obj.put("type","AutomaticMovementStrategy");
		obj.put("subjectId",subject.getSpriteId());
		obj.put("velocityY",velocityY);
		obj.put("velocityX",velocityX);
		return obj;
	}
	@Override

	//After calling load, AutomaticMovementStrategies need
	//a call to restoreSubject() with the spritemaster containing
	//the subject as an argument
	public void load(JSONObject saveJSON)
	{
		subjectId = ((Long)saveJSON.get("subjectId")).intValue();
		velocityX = ((Long)saveJSON.get("velocityX")).intValue();
		velocityY = ((Long)saveJSON.get("velocityY")).intValue();
	}

	public boolean equals(Object o)
	{
		if (o instanceof AutomaticMovementStrategy)
		{
			AutomaticMovementStrategy a = (AutomaticMovementStrategy) o;
			return velocityX == a.getVelocityX() && velocityY == a.getVelocityY() && subject.equals(a.getSubject());
		}
		return false;
	}

	@Override
	public void setVelocityX(int velocityX) {
		this.velocityX = velocityX;

	}

	@Override
	public void setVelocityY(int velocityY) {
		this.velocityY = velocityY;

	}
}
