//SaveableString.java
//    Created by: Isaiah Sherfick
//    Created on: 22 Sep 2021
//     Edited by:
//Edited last by: Isaiah Sherfick
//   Last change: Created SaveFileManager.java
package Group3.gameMaker.SaveAndLoad;

import org.json.simple.JSONObject;

import Group3.gameMaker.Null.NullObject;
import javafx.scene.paint.Color;

//Just exists to run some unit tests before the other objects
//are made

//Also is kind of the example for how we will write wrapper classes
//for classes which we cannot force to implement Saveable
public class SaveableColor implements Saveable
{
	private Color color;
	
	//default: white
	public SaveableColor()
	{
		this.color = new Color(1,1,1,1);
	}
	public SaveableColor(Color c)
	{
		this.color = c;
	}
	
	public SaveableColor(double r, double g, double b, double o)
	{
		this.color = new Color(r,g,b,o);
	}
	
	public void setColor(Color c)
	{
		color = c;
	}
	
	
	public Color getColor()
	{
		return color;
	}

	@SuppressWarnings("unchecked")
	public JSONObject save()
	{
		JSONObject obj = new JSONObject();
		obj.put("type", "SaveableColor");
		obj.put("r",color.getRed());
		obj.put("g",color.getGreen());
		obj.put("b",color.getBlue());
		obj.put("o",color.getOpacity());
		return obj;
	}
	public void load(JSONObject saveData)
	{
		double red = (double)saveData.get("r");
		double green = (double)saveData.get("g");
		double blue = (double)saveData.get("b");
		double opacity = (double)saveData.get("o");
		color = new Color(red,green,blue,opacity);
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (o instanceof SaveableColor)
		{
			SaveableColor other = (SaveableColor)o;
			return color.equals(other.getColor());
		}
		return false;
	}
	public SaveableColor copy() 
	{
		Color newColor = new Color(color.getRed(),color.getBlue(),color.getGreen(),color.getOpacity());
		return new SaveableColor(newColor);
	}
	
}