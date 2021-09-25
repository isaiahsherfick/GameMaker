//Sprite.java
//    Created by: Isaiah Sherfick
//    Created on: 25 Sep 2021
//     Edited by:
//Edited last by: Isaiah Sherfick
//   Last change: Created saveable Sprite class

package Group3.gameMaker.Sprite;

import org.json.simple.JSONObject;

import Group3.gameMaker.SaveAndLoad.Saveable;
import Group3.gameMaker.Sprite.Shape.ShapeStrategy;

public abstract class Sprite implements Saveable
{
	private Point coordinates;
	private ShapeStrategy shapeStrategy;
	private CollisionStrategy collisionStrategy;
	//private CommandInvoker commandInvoker;
	
	public int getX()
	{
		return coordinates.getX();
	}

	public int getY()
	{
		return coordinates.getY();
	}
	
	public void setX(int x)
	{
		coordinates.setX(x);
	}

	public void setY(int y)
	{
		coordinates.setY(y);
	}
	
	//TODO figure out what to pass this
	public void draw()
	{
		shapeStrategy.draw();
	}

	@SuppressWarnings("unchecked")
	public JSONObject save()
	{
		JSONObject obj = new JSONObject();
		obj.put("type","Sprite");
		obj.put("coordinates",coordinates.save());
		obj.put("shapeStrategy",shapeStrategy.save());
		return obj;
	}
	
	public void load(JSONObject saveData)
	{
		coordinates = new Point();
		coordinates.load((JSONObject)saveData.get("coordinates"));
		//TODO figure out how to load shapestrategy
	}
}
