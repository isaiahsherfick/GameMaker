package Group3.gameMaker.Sprite.Strategy.EventStrategy;

import org.json.simple.JSONObject;

import Group3.gameMaker.SaveAndLoad.SaveablePoint;
import Group3.gameMaker.Sprite.Sprite;

public class MoveWithWASDStrategy implements EventStrategy
{
	private Sprite subject;
	
	//there's an x and a y velocity
	//in case you want to create an object that can only move in one dimension
	//i.e. a pong paddle
	private SaveablePoint velocityPair;
	
	public MoveWithWASDStrategy()
	{
		this.velocityPair = new SaveablePoint();
	}

	@SuppressWarnings("unchecked")
	public JSONObject save() 
	{	
		JSONObject obj = new JSONObject();
		obj.put("type","MoveWithWASDStrategy");
		obj.put("velocityPair",velocityPair.save());
		return obj;
	}

	public void load(JSONObject saveJSON) 
	{	

	}

	public void onClockTick() 
	{	
		return;
	}

	public void onKeyPress() 
	{	
		//something like
		//if key == w move up $speed
		//elif key == a move left $speed
		//etc
	}

	public void onMouseClick() 
	{	
		return;
	}

	public void setSubject(Sprite s) 
	{	
		return;
	}

	public int getVelocityX() 
	{
		return velocityPair.getX();
	}

	public int getVelocityY() 
	{
		return velocityPair.getY();
	}

	public void setVelocityX(int v) 
	{
		velocityPair.setX(v);
	}

	public void setVelocityY(int v) 
	{
		velocityPair.setY(v);
	}
}
