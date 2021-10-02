package Group3.gameMaker.Sprite.Collision;

import java.util.HashMap;
import java.util.Map.Entry;

import org.json.simple.JSONObject;

import Group3.gameMaker.SaveAndLoad.Saveable;

public class CustomCollisionMap implements Saveable
{
	private HashMap<Integer, CollisionStrategy> map;
	
	public CustomCollisionMap()
	{
		map = new HashMap<>();
	}
	
	//adds a new custom collision behavior for when the object that contains this ccm
	//collides with the sprite of spriteId
	
	//note that you can only add one custom collision behavior per other sprite in the system.
	//We can't think of an edge case where you'd want more than one, but in case you do, just change this class
	//so that it maps ints to a linkedlist of collisionstrategies to accomplish that. We opted to save the memory.
	public void addCustomCollision(int spriteId, CollisionStrategy customCollision)
	{
		map.put(spriteId, customCollision);
	}
	
	public boolean containsKey(int spriteId)
	{
		return map.containsKey(spriteId);
	}
	
	public CollisionStrategy get(int spriteId)
	{
		return map.get(spriteId);
	}
	
	public void addPair(CustomCollisionPair c)
	{
		map.put(c.getSpriteId(), c.getCollisionStrategy());
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject save()
	{
		JSONObject obj = new JSONObject();

		obj.put("type","CustomCollisionMap");
		obj.put("entries", map.entrySet().size());
		int i = 0;
		for (Entry<Integer, CollisionStrategy> entry : map.entrySet()) 
		{
			CustomCollisionPair c = new CustomCollisionPair(entry.getKey(), entry.getValue());
			obj.put(i, c);
			i = i+1;
		}	
		return obj;
	}
	
	public void load(JSONObject saveJSON) 
	{
		map = new HashMap<>();
		int size = ((Long)saveJSON.get("spriteId")).intValue();
		for (int i = 0; i < size; i++)
		{
			CustomCollisionPair c = new CustomCollisionPair();
			c.load((JSONObject)saveJSON.get(i));
			addPair(c);
		}
	}

	public HashMap<Integer, CollisionStrategy> getMap() 
	{
		return map;
	}
}
