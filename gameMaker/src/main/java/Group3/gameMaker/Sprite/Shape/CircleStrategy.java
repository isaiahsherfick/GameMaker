package Group3.gameMaker.Sprite.Shape;

import org.json.simple.JSONObject;

import Group3.gameMaker.SaveAndLoad.SaveableColor;
import javafx.scene.canvas.GraphicsContext;

public class CircleStrategy implements ShapeStrategy
{
	private int radius;
	private SaveableColor color;
	public CircleStrategy()
	{
		//TODO null object
		//both null
		this.radius = -1;
		this.color = new SaveableColor();
	}
	
	public CircleStrategy(int radius, SaveableColor color)
	{
		this.radius = radius;
		this.color = color;
	}
	
	

	@SuppressWarnings("unchecked")
	public JSONObject save() 
	{
		JSONObject obj = new JSONObject();
		obj.put("type","CircleStrategy");
		obj.put("radius",radius);
		obj.put("color",color.save());
		return obj;
	}

	public void load(JSONObject saveJSON) 
	{
		radius = (int)saveJSON.get("radius");
		SaveableColor c = new SaveableColor();
		c.load((JSONObject)saveJSON.get("color"));
		color = c;
	}

	public int getWidth() 
	{
		return radius * 2;
	}

	public int getHeight() 
	{
		return radius * 2;
	}

	@Override
	public void draw(GraphicsContext g) 
	{
		//TODO draw a circle
	}
	
}