//Point.java
//    Created by: Isaiah Sherfick
//    Created on: 25 Sep 2021
//     Edited by:
//Edited last by: Isaiah Sherfick
//   Last change: Created saveable Point class
package Group3.gameMaker.Sprite;

import org.json.simple.JSONObject;

import Group3.gameMaker.SaveAndLoad.Saveable;

public class Point implements Saveable
{
	private int x;
	private int y;
	
	public Point()
	{
		x = 0;
		y = 0;
	}
	
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}

	public void setY(int y)
	{
		this.y = y;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject save() 
	{
		JSONObject saveObj = new JSONObject();
		saveObj.put("type", "Point");
		saveObj.put("x",x); 
		saveObj.put("y",y);
		return saveObj;
	}
	
	public void load(JSONObject saveJSON) 
	{
		x = (int)saveJSON.get("x");
		y = (int)saveJSON.get("y");
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (o instanceof Point)
		{
			Point p = (Point) o;
			return x == p.getX() && y == p.getY();
		}
		return false;
	}
}
