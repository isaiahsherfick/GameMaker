package Group3.gameMaker.Sprite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class SpriteMaster 
{
	private int currentKey = -1;
	private HashMap<Integer, Sprite> spriteMap; 
	public SpriteMaster()
	{
		this.spriteMap = new HashMap<>();
	}
	
	public void add(Sprite s)
	{
		if (s.getSpriteId() > currentKey)
		{
			spriteMap.put(s.getSpriteId(),s);
			currentKey = s.getSpriteId();
		}
		if (s.getSpriteId() <= currentKey)
		{
			currentKey++;
			s.setSpriteId(currentKey);
			spriteMap.put(currentKey,s);
		}
	}
	
	public Sprite get(int key)
	{
		return spriteMap.get(key);
	}
	
	public ArrayList<Sprite> getAllSprites()
	{
		ArrayList<Sprite> returnList = new ArrayList<>();
		for (Entry<Integer, Sprite> entry : spriteMap.entrySet()) 
		{
			returnList.add(entry.getValue());
		}	
		return returnList;
	}
}
