package Group3.gameMaker.Sprite.Strategy.ShapeStrategy;

import org.json.simple.JSONObject;

import Group3.gameMaker.Constants.Constants;
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
		width = Constants.DEFAULT_CIRCLE_RADIUS;
		height = Constants.DEFAULT_CIRCLE_RADIUS;
;
		color = new SaveableColor();
	}

	public RectangleStrategy(int w, int h, SaveableColor c)
	{
		width = w;
		height = h;
		color = c;
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
		width = ((Long)saveJSON.get("width")).intValue();
		height = ((Long)saveJSON.get("height")).intValue();

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


	public void draw(GraphicsContext g, int posX, int posY)
	{
		g.setFill(color.getColor());
		g.fillRect(posX, posY, width, height);
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
		return new RectangleStrategy(width, height, color.copy());
	}

}