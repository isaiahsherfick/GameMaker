//Sprite.java
//    Created by: Isaiah Sherfick
//    Created on: 25 Sep 2021
//     Edited by:
//Edited last by: Isaiah Sherfick
//   Last change: Created saveable Sprite class

package Group3.gameMaker.Sprite;

import org.json.simple.JSONObject;

import Group3.gameMaker.SaveAndLoad.Saveable;
import Group3.gameMaker.SaveAndLoad.StrategyLoader;
import Group3.gameMaker.Sprite.Shape.ShapeStrategy;
import javafx.scene.canvas.GraphicsContext;

public class Sprite implements Saveable
{
	//This is -2 so that it doesn't conflict with using -1 in SpriteMaster
	private int spriteId = -2;
	private Point coordinates;
	private ShapeStrategy shapeStrategy;
	//private CollisionStrategy collisionStrategy;
	//private CommandInvoker commandInvoker;
	
	public Sprite(int x, int y, ShapeStrategy shape)
	{
		coordinates = new Point(x,y);
		shapeStrategy = shape;
	}

	public Sprite(int x, int y, ShapeStrategy shape, int spriteId)
	{
		coordinates = new Point(x,y);
		shapeStrategy = shape;
		this.spriteId = spriteId;
	}

	public Sprite(Point point, ShapeStrategy shape)
	{
		coordinates = point;
		shapeStrategy = shape;
	}

	public Sprite(Point point, ShapeStrategy shape, int spriteId)
	{
		coordinates = point;
		shapeStrategy = shape;
		this.spriteId = spriteId;
	}
	
	public void setSpriteId(int id)
	{
		spriteId = id;
	}
	
	public int getSpriteId()
	{
		return spriteId;
	}
	
	public int getX()
	{
		return coordinates.getX();
	}

	public int getY()
	{
		return coordinates.getY();
	}
	
	public Point getCoordinates()
	{
		return coordinates;
	}
	
	public void setX(int x)
	{
		coordinates.setX(x);
	}

	public void setY(int y)
	{
		coordinates.setY(y);
	}
	
	public void draw(GraphicsContext g)
	{
		shapeStrategy.draw(g);
	}
	
	public ShapeStrategy getShapeStrategy()
	{
		return shapeStrategy;
	}

	@SuppressWarnings("unchecked")
	public JSONObject save()
	{
		JSONObject obj = new JSONObject();
		obj.put("type","Sprite");
		obj.put("coordinates",coordinates.save());
		obj.put("shapeStrategy",shapeStrategy.save());
		obj.put("spriteId",spriteId);
		return obj;
	}
	
	public void load(JSONObject saveData)
	{
		coordinates = new Point();
		coordinates.load((JSONObject)saveData.get("coordinates"));
		StrategyLoader sl = new StrategyLoader();
		sl.load((JSONObject)saveData.get("shapeStrategy"));
	}
	
	//Only returns true if the other sprite is an exact copy
	//even spriteid needs to match
	//should only happen during unit testing
	public boolean equals(Object o)
	{
		if (o instanceof Sprite)
		{
			Sprite s = (Sprite) o;
			return spriteId == s.getSpriteId() && coordinates.equals(s.getCoordinates()) && shapeStrategy.equals(s.getShapeStrategy());
		}
		return false;
	}
}
