package Group3.gameMaker.Sprite.Strategy.CollisionStrategy;

import org.json.simple.JSONObject;

import Group3.gameMaker.SaveAndLoad.Saveable;
import Group3.gameMaker.SaveAndLoad.StrategyLoader;

public class CustomCollisionPair implements Saveable
{
	private int spriteId;
	private CollisionStrategy collisionStrategy;
	
	public CustomCollisionPair()
	{

	}
	public CustomCollisionPair(int s, CollisionStrategy c)
	{
		spriteId = s;
		collisionStrategy = c;
	}
	
	public int getSpriteId()
	{
		return spriteId;
	}
	
	public CollisionStrategy getCollisionStrategy()
	{
		return collisionStrategy;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject save()
	{
		JSONObject obj = new JSONObject();
		obj.put("type","CustomCollisionPair");
		obj.put("spriteId",spriteId);
		obj.put("collisionStrategy",collisionStrategy.save());
		return obj;
	}
	public void load(JSONObject saveData)
	{
		spriteId = ((Long)saveData.get("spriteId")).intValue();
		StrategyLoader s = new StrategyLoader();
		collisionStrategy = (CollisionStrategy)s.load((JSONObject)saveData.get("collisionStrategy"));
	}
}
