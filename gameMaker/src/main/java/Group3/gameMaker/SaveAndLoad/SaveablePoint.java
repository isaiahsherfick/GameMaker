//Point.java
//    Created by: Isaiah Sherfick
//    Created on: 25 Sep 2021
//     Edited by:
//Edited last by: Isaiah Sherfick
//   Last change: Created saveable Point class
package Group3.gameMaker.SaveAndLoad;

import org.json.simple.JSONObject;

public class SaveablePoint implements Saveable
{
	private int x;
	private int y;

	public SaveablePoint()
	{
		x = 0;
		y = 0;
	}

	public SaveablePoint(int x, int y)
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
		saveObj.put("type", "SaveablePoint");
		saveObj.put("x",x);
		saveObj.put("y",y);
		return saveObj;
	}

	public void load(JSONObject saveJSON)
	{
		x = ((Long)saveJSON.get("x")).intValue();
		y = ((Long)saveJSON.get("y")).intValue();
	}

	@Override
	public boolean equals(Object o)
	{
		if (o instanceof SaveablePoint)
		{
			SaveablePoint p = (SaveablePoint) o;
			return x == p.getX() && y == p.getY();
		}
		return false;
	}

	public SaveablePoint copy()
	{
		return new SaveablePoint(x,y);
	}
}
