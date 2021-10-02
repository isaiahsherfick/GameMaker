package Group3.gameMaker.Sprite.Strategy.EventStrategy;

import org.json.simple.JSONObject;

import Group3.gameMaker.Sprite.Sprite;

public class DoNothingStrategy implements EventStrategy 
{
	private Sprite subject;
	
	public DoNothingStrategy()
	{
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject save() 
	{
		JSONObject obj = new JSONObject();
		obj.put("type","DoNothingStrategy");
		return obj;
	}

	@Override
	public void load(JSONObject saveJSON) 
	{
		return;
	}

	@Override
	public void onClockTick() 
	{
		return;
	}

	@Override
	public void onKeyPress() 
	{
		return;
	}

	@Override
	public void onMouseClick() 
	{
		return;
	}

	@Override
	public void setSubject(Sprite s) 
	{
		subject = s;
	}
}
