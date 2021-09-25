package Group3.gameMaker.Sprite;

import org.json.simple.JSONObject;

import Group3.gameMaker.SaveAndLoad.Saveable;

public class ShapeStrategy implements Saveable
{
	
	
	public JSONObject save()
	{
		JSONObject obj = new JSONObject();
		return obj;
		
	}
	
	public void load(JSONObject saveData)
	{
		
	}

}
