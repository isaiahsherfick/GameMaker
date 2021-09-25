//Sprite.java
//    Created by: Isaiah Sherfick
//    Created on: 25 Sep 2021
//     Edited by:
//Edited last by: Isaiah Sherfick
//   Last change: Created saveable Sprite class

package Group3.gameMaker.Sprite;

import org.json.simple.JSONObject;

import Group3.gameMaker.SaveAndLoad.Saveable;

public abstract class Sprite implements Saveable
{
	

	public JSONObject save()
	{
		JSONObject obj = new JSONObject();
		return obj;
		
	}
	
	public void load(JSONObject saveData)
	{
		
	}
}
