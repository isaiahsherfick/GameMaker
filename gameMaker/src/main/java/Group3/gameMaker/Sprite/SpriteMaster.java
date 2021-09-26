package Group3.gameMaker.Sprite;

import java.util.HashMap;

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
}
