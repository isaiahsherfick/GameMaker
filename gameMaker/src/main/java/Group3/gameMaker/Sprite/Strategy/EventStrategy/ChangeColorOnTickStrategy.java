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
		//TODO make this random
		SaveableColor c = new SaveableColor();
		subject.setColor(c);
	}

	public void onKeyPress() 
	{
		
	}

	public void onMouseClick() 
	{

	}

	public void setSubject(Sprite s) 
	{
		subject = s;
	}

	@Override
	public int getVelocityX() {
		return 0;
	}

	@Override
	public int getVelocityY() {
		return 0;
	}

	@Override
	public void setVelocityX(int v) {
		
	}

	@Override
	public void setVelocityY(int v) {
		
	}

}
