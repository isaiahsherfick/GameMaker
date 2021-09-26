package Group3.gameMaker.SaveAndLoad;

import org.json.simple.JSONObject;

import Group3.gameMaker.Sprite.Shape.*;
import Null.NullObject;

public class StrategyLoader 
{
	//Parse the JSONObject, determine what kind of strategy object has been stored there,
	//Restore it, return it
	public Object load(JSONObject strategyJSON)
	{
		switch((String)strategyJSON.get("type"))
		{
			case "RectangleStrategy":
				RectangleStrategy rectangleStrategy = new RectangleStrategy();
				rectangleStrategy.load(strategyJSON);
				return rectangleStrategy;
			case "CircleStrategy":
				CircleStrategy circleStrategy = new CircleStrategy();
				circleStrategy.load(strategyJSON);
				return circleStrategy;
				
			//Add a case for each kind of strategy object we see
			default:
				return new NullObject();
		}
	}
	

}
