package Group3.gameMaker.Sprite.Strategy.ShapeStrategy;

import org.json.simple.JSONObject;

import Group3.gameMaker.SaveAndLoad.SaveableColor;
import javafx.scene.canvas.GraphicsContext;

public class CircleStrategy implements ShapeStrategy
{
	private int radius;
	private SaveableColor color;
	
	//Default Circle
	public CircleStrategy()
	{
		this.radius = 5;
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
		radius = ((Long)saveJSON.get("radius")).intValue();
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

	public void draw(GraphicsContext g) 
	{
		//TODO draw a circle
	}

	public SaveableColor getColor() 
	{
		return color;
	}

	public void setColor(SaveableColor c) 
	{
		color = c;
	}

	@Override
	public ShapeStrategy copy() 
	{
		return new CircleStrategy(radius,color.copy());
	}
	
}