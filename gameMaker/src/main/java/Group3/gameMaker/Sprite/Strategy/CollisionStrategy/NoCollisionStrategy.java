package Group3.gameMaker.Sprite.Strategy.CollisionStrategy;

import org.json.simple.JSONObject;

import Group3.gameMaker.Sprite.Sprite;

public class NoCollisionStrategy implements CollisionStrategy{

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject save() 
	{
		JSONObject obj = new JSONObject();
		obj.put("type", "NoCollisionStrategy");
		return obj;
	}

	@Override
	public void load(JSONObject saveJSON) 
	{

	}

	@Override
	public void collide(Sprite collidee) {
		// Do nothing
	}

	@Override
	public void setCollider(Sprite sprite) {
		// TODO Auto-generated method stub
		
	}
	
	public String toString()
	{
		return "No Collision";
	}

}
