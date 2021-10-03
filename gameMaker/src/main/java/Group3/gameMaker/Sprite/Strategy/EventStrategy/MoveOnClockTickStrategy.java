package Group3.gameMaker.Sprite.Strategy.EventStrategy;

import org.json.simple.JSONObject;

import Group3.gameMaker.SaveAndLoad.SaveablePoint;
import Group3.gameMaker.Sprite.Sprite;

public class MoveOnClockTickStrategy implements EventStrategy
{
	private Sprite subject;
	private SaveablePoint velocityPair;
	
	public MoveOnClockTickStrategy()
	{
		velocityPair = new SaveablePoint();
	}
	
	public MoveOnClockTickStrategy(int velocityX, int velocityY)
	{
		velocityPair = new SaveablePoint(velocityX, velocityY);
	}

	@SuppressWarnings("unchecked")
	public JSONObject save() 
	{
		JSONObject obj = new JSONObject();
		obj.put("type","MoveOnClockTickStrategy");
		obj.put("velocityPair",velocityPair.save());
		return obj;
	}
	
	public int getVelocityX()
	{
		return velocityPair.getX();
	}
	
	public int getVelocityY()
	{
		return velocityPair.getY();
	}
	
	public void setVelocityX(int x)
	{
		velocityPair.setX(x);
	}

	public void setVelocityY(int y)
	{
		velocityPair.setY(y);
	}

	public void load(JSONObject saveJSON) 
	{
		velocityPair = new SaveablePoint();
		velocityPair.load((JSONObject)saveJSON.get("velocityPair"));
	}

	public void onClockTick() 
	{
		int x = subject.getX();
		int y = subject.getY();
		x += velocityPair.getX();
		y += velocityPair.getY();
		subject.setX(x);
		subject.setY(y);
	}

	public void onKeyPress() 
	{
		return;
	}

	public void onMouseClick() 
	{
		return;
	}

	public void setSubject(Sprite s) 
	{
		subject = s;
	}
}
