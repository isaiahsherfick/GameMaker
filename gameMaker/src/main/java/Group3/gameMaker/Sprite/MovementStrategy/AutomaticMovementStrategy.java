package Group3.gameMaker.Sprite.MovementStrategy;

import org.json.simple.JSONObject;

import Group3.gameMaker.Sprite.Sprite;

public class AutomaticMovementStrategy implements MovementStrategy
{
	private int velocityX;
	private int velocityY;
	private Sprite subject;
	
	//Defualt constructor
	//By default stuff moves 5 on the x and y so the user can get instant confirmation
	//That the sprite does indeed move automatically
	public AutomaticMovementStrategy(Sprite s)
	{
		subject = s;
		velocityX = 5;
		velocityY = 5;
	}
	public AutomaticMovementStrategy(Sprite s, int xv, int yv)
	{
		subject = s;
		velocityX = xv;
		velocityY = yv;
	}
	public void move()
	{
		int x = subject.getX();
		int y = subject.getY();
		subject.setX(x + velocityX);
		subject.setY(y + velocityY);
	}
	public int getXVelocity() 
	{
		// TODO Auto-generated method stub
		return 0;
	}
	public int getYVelocity() 
	{
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Sprite getSubject() 
	{
		return subject;
	}
	@Override
	public void setSubject(Sprite s) 
	{
		subject = s;
	}
	@SuppressWarnings("unchecked")
	@Override
	public JSONObject save() 
	{
		JSONObject obj = new JSONObject();
		obj.put("type","AutomaticMovementStrategy");
		obj.put("subjectID",subject.getSpriteId());
		obj.put("velocityY",velocityY);
		obj.put("velocityX",velocityX);
		// TODO Auto-generated method stub
		return obj;
	}
	@Override
	
	//TODO figure out how to restore the relationship to Subject
	//Without brekaing the saveable interface
	//Going to need to have some kind of static reference to the SpriteMaster
	//In order to get the Sprite
	//Possibly put the SpriteMaster into the S/L manager? Something along those lines
	public void load(JSONObject saveJSON) 
	{
		
	}
}
