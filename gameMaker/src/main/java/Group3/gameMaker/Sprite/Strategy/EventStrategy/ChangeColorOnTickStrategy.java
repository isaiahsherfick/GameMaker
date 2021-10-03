package Group3.gameMaker.Sprite.Strategy.EventStrategy;

import org.json.simple.JSONObject;

import Group3.gameMaker.SaveAndLoad.SaveableColor;
import Group3.gameMaker.Sprite.Sprite;

public class ChangeColorOnTickStrategy implements EventStrategy
{
	private int numberOfTicksBeforeColorChanges;
	private Sprite subject;
	
	public ChangeColorOnTickStrategy()
	{
		numberOfTicksBeforeColorChanges = 1;
	}
	
	public ChangeColorOnTickStrategy(int num)
	{
		numberOfTicksBeforeColorChanges = num;
	}
	
	public int getNumberOfTicksBeforeColorChanges()
	{
		return numberOfTicksBeforeColorChanges;
	}
	
	public void setNumberOfTicksBeforeColorChanges(int num)
	{
		numberOfTicksBeforeColorChanges = num;
	}

	@SuppressWarnings("unchecked")
	public JSONObject save() 
	{
		JSONObject obj = new JSONObject();
		obj.put("type","ChangeColorOnTickStrategy");
		obj.put("numberOfTicksBeforeColorChanges",numberOfTicksBeforeColorChanges);
		return obj;
	}

	public void load(JSONObject saveJSON) 
	{
		numberOfTicksBeforeColorChanges = ((Long)(saveJSON.get("numberOfTicksBeforeColorChanges"))).intValue();
	}

	public void onClockTick() 
	{
		SaveableColor c = new SaveableColor();
		subject.setColor(c);
	}

	public void onKeyPress() {
		// TODO Auto-generated method stub
		
	}

	public void onMouseClick() {
		// TODO Auto-generated method stub
		
	}

	public void setSubject(Sprite s) {
		// TODO Auto-generated method stub
		
	}

}
