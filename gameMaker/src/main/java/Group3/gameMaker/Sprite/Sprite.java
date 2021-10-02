//Sprite.java
//    Created by: Isaiah Sherfick
//    Created on: 25 Sep 2021
//     Edited by:
//Edited last by: Isaiah Sherfick
//   Last change: Created saveable Sprite class

package Group3.gameMaker.Sprite;

import java.util.HashMap;

import org.json.simple.JSONObject;

import Group3.gameMaker.SaveAndLoad.Saveable;
import Group3.gameMaker.SaveAndLoad.SaveablePoint;
import Group3.gameMaker.SaveAndLoad.StrategyLoader;
import Group3.gameMaker.Sprite.Collision.CustomCollisionMap;
import Group3.gameMaker.Sprite.Collision.BounceCollisionStrategy;
import Group3.gameMaker.Sprite.Collision.CollisionStrategy;
import Group3.gameMaker.Sprite.Collision.HitBox;
import Group3.gameMaker.Sprite.MovementStrategy.AutomaticMovementStrategy;
import Group3.gameMaker.Sprite.MovementStrategy.MovementStrategy;
import Group3.gameMaker.Sprite.Strategy.ShapeStrategy.CircleStrategy;
import Group3.gameMaker.Sprite.Strategy.ShapeStrategy.ShapeStrategy;
import javafx.scene.canvas.GraphicsContext;

public class Sprite implements Saveable
{
	//This is -2 so that it doesn't conflict with using -1 in SpriteMaster
	private int spriteId = -2;
	private SaveablePoint coordinates;
	private ShapeStrategy shapeStrategy;
	private Sound sound;
	private MovementStrategy movementStrategy;
	private HitBox hitBox;
	
	// Maps SpriteID to specific collision behavior for that relationship
	private CustomCollisionMap customCollisionMap;

	// Default Collision Strategy is set at key -2 in the customcollisionmap
	private static final int DEFAULT_COLLISION_KEY = -2;

	//Default Sprite
	public Sprite()
	{
		coordinates = new SaveablePoint(0,0);
		shapeStrategy = new CircleStrategy();
		movementStrategy = new AutomaticMovementStrategy(this);
		customCollisionMap = new CustomCollisionMap();
		sound = new Sound();
		
		setHitBox(new HitBox(this));;
	}
	
	public MovementStrategy getMovementStrategy()
	{
		return movementStrategy;
	}

	public CustomCollisionMap getCollisionStrategyMap() {
		return customCollisionMap;
	}

	public void setSound(Sound sound) {
		this.sound = sound;
	}

	public Sound getSound() {
		return sound;
	}

	public void setSpriteId(int id)
	{
		spriteId = id;
	}
	
	public int getSpriteId()
	{
		return spriteId;
	}

	public HitBox getHitBox() {
		return hitBox;
	}

	public void setHitBox(HitBox hitBox) {
		this.hitBox = hitBox;
	}

	public int getX()
	{
		return coordinates.getX();
	}

	public int getY()
	{
		return coordinates.getY();
	}
	
	public SaveablePoint getCoordinates()
	{
		return coordinates;
	}
	
	public void setX(int x)
	{
		coordinates.setX(x);
	}

	public void setY(int y)
	{
		coordinates.setY(y);
	}
	
	public void draw(GraphicsContext g)
	{
		shapeStrategy.draw(g);
	}
	
	public ShapeStrategy getShapeStrategy()
	{
		return shapeStrategy;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject save()
	{
		JSONObject obj = new JSONObject();
		obj.put("type","Sprite");
		obj.put("coordinates",coordinates.save());
		obj.put("shapeStrategy",shapeStrategy.save());
		obj.put("movementStrategy",movementStrategy.save());
		obj.put("spriteId",spriteId);
		obj.put("sound",sound.save());
		obj.put("customCollisionMap",customCollisionMap.save());
		return obj;
	}
	
	//TODO update 
	public void load(JSONObject saveData)
	{
		coordinates = new SaveablePoint();
		coordinates.load((JSONObject)saveData.get("coordinates"));
		StrategyLoader sl = new StrategyLoader();
		shapeStrategy = (ShapeStrategy)sl.load((JSONObject)saveData.get("shapeStrategy"));
		movementStrategy = (MovementStrategy)sl.load((JSONObject)saveData.get("movementStrategy"));
		movementStrategy.setSubject(this);
		customCollisionMap = new CustomCollisionMap();
		customCollisionMap.load((JSONObject)saveData.get("customCollisionMap"));
		customCollisionMap.setColliderForAll(this);
	}
	
	//Only returns true if the other sprite is an exact copy
	//even spriteid needs to match
	//should only happen during unit testing
	public boolean equals(Object o)
	{
		if (o instanceof Sprite)
		{
			Sprite s = (Sprite) o;
			return spriteId == s.getSpriteId() && coordinates.equals(s.getCoordinates()) ;
		}
		return false;
	}

	public CustomCollisionMap getCustomCollisionMap() 
	{
		return customCollisionMap;
	}

	public void addCustomCollision(Sprite sprite2, CollisionStrategy c) 
	{
		customCollisionMap.addCustomCollision(sprite2.getSpriteId(), c);
	}
}
