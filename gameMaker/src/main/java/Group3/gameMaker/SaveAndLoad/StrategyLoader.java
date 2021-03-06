package Group3.gameMaker.SaveAndLoad;

import org.json.simple.JSONObject;

import Group3.gameMaker.Null.NullObject;
import Group3.gameMaker.Sprite.Strategy.CollisionStrategy.BounceCollisionStrategy;
import Group3.gameMaker.Sprite.Strategy.CollisionStrategy.NoCollisionStrategy;
import Group3.gameMaker.Sprite.Strategy.EventStrategy.ChangeColorOnTickStrategy;
import Group3.gameMaker.Sprite.Strategy.EventStrategy.DoNothingStrategy;
import Group3.gameMaker.Sprite.Strategy.EventStrategy.MoveOnClockTickStrategy;
import Group3.gameMaker.Sprite.Strategy.EventStrategy.MoveWithWASDStrategy;
import Group3.gameMaker.Sprite.Strategy.MovementStrategy.AutomaticMovementStrategy;
import Group3.gameMaker.Sprite.Strategy.ShapeStrategy.*;

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
			case "AutomaticMovementStrategy":
				AutomaticMovementStrategy autoMove = new AutomaticMovementStrategy();
				autoMove.load(strategyJSON);
				return autoMove;
			case "BounceCollisionStrategy":
				BounceCollisionStrategy bounce = new BounceCollisionStrategy();
				bounce.load(strategyJSON);
				return bounce;
			case "DoNothingStrategy":
				DoNothingStrategy dn = new DoNothingStrategy();
				return dn;
			case "MoveOnClockTickStrategy":
				MoveOnClockTickStrategy m = new MoveOnClockTickStrategy();
				m.load(strategyJSON);
				return m;
			case "ChangeColorOnTickStrategy":
				ChangeColorOnTickStrategy c = new ChangeColorOnTickStrategy();
				c.load(strategyJSON);
				return c;
			case "MoveWithWASDStrategy":
				MoveWithWASDStrategy mo = new MoveWithWASDStrategy();
				mo.load(strategyJSON);
				return mo;
			case "NoCollisionStrategy":
				return new NoCollisionStrategy();
			//Add a case for each kind of strategy object we see
			default:
				return new NullObject();
		}
	}
}
