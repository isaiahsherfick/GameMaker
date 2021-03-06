package Group3.gameMaker.Sprite.Strategy.CollisionStrategy;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import org.json.simple.JSONObject;

import Group3.gameMaker.SaveAndLoad.Saveable;
import Group3.gameMaker.Sprite.Sprite;

public class CustomCollisionMap implements Saveable
{
	private static final int DEFAULT_COLLISION = -2;
	private HashMap<Integer, CollisionStrategy> map;
	
	public CustomCollisionMap()
	{
		map = new HashMap<>();
		map.put(DEFAULT_COLLISION, new NoCollisionStrategy());
	}
	private CustomCollisionMap(HashMap<Integer,CollisionStrategy> map)
	{
		this.map = map;
		map.put(DEFAULT_COLLISION, new NoCollisionStrategy());
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
			obj.put(i, c.save());
			i = i+1;
		}	
		return obj;
	}
	
	public void load(JSONObject saveJSON) 
	{
		map = new HashMap<>();
		int size = ((Long)saveJSON.get("entries")).intValue();
		for (Integer i = 0; i < size; i++)
		{
			JSONObject current = (JSONObject)saveJSON.get(i.toString());
			CustomCollisionPair c = new CustomCollisionPair();
			c.load(current);
			addPair(c);
		}
	}

	public HashMap<Integer, CollisionStrategy> getMap() 
	{
		return map;
	}

	public void setColliderForAll(Sprite sprite) 
	{
		for (Entry<Integer, CollisionStrategy> entry : map.entrySet()) 
		{
			entry.getValue().setCollider(sprite);
		}	
	}

	public CustomCollisionMap copy() 
	{
		HashMap<Integer, CollisionStrategy> newMap = new HashMap<>();

		for (Entry<Integer, CollisionStrategy> entry : map.entrySet()) 
		{
			newMap.put(entry.getKey(),entry.getValue());
		}	
		
		return new CustomCollisionMap(newMap);
	}
	public Set<Entry<Integer, CollisionStrategy>> entrySet() 
	{
		return map.entrySet();
	}
}
