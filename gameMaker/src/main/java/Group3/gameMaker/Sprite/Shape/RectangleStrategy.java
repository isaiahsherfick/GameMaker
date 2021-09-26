package Group3.gameMaker.Sprite.Shape;

import org.json.simple.JSONObject;

import Group3.gameMaker.SaveAndLoad.SaveableColor;
import javafx.scene.canvas.GraphicsContext;

public class RectangleStrategy implements ShapeStrategy
{
	private int width;
	private int height;
	private SaveableColor color;
	public RectangleStrategy()
	{
		//TODO null object
		width = -1;
		height = -1;
		color = new SaveableColor();
	}

	@SuppressWarnings("unchecked")
	public JSONObject save() 
	{
		JSONObject obj = new JSONObject();
		obj.put("type","RectangleStrategy");
		obj.put("width",width);
		obj.put("height",height);
		obj.put("color",color.save());
		return obj;
	}

	public void load(JSONObject saveJSON) 
	{
		width = (int)saveJSON.get("width");
		height = (int)saveJSON.get("height");
		SaveableColor c = new SaveableColor();
		c.load((JSONObject)saveJSON.get("color"));
		color = c;
	}

	public int getWidth() 
	{
		return width;
	}

	public int getHeight() 
	{
		return height;
	}


	@Override
	public void draw(GraphicsContext g) 
	{
				//TODO draw a rectangle
	}
	
}