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
import Group3.gameMaker.SaveAndLoad.SaveableColor;
import Group3.gameMaker.SaveAndLoad.SaveablePoint;
import Group3.gameMaker.SaveAndLoad.StrategyLoader;
import Group3.gameMaker.Sprite.Strategy.CollisionStrategy.BounceCollisionStrategy;
import Group3.gameMaker.Sprite.Strategy.CollisionStrategy.CollisionStrategy;
import Group3.gameMaker.Sprite.Strategy.CollisionStrategy.CustomCollisionMap;
import Group3.gameMaker.Sprite.Strategy.CollisionStrategy.DestroyCollisionStrategy;
import Group3.gameMaker.Sprite.Strategy.CollisionStrategy.HitBox;
import Group3.gameMaker.Sprite.Strategy.EventStrategy.EventStrategy;
import Group3.gameMaker.Sprite.Strategy.EventStrategy.EventStrategyLinkedList;
import Group3.gameMaker.Sprite.Strategy.EventStrategy.MoveOnClockTickStrategy;
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
	private HitBox hitBox;
	// Maps SpriteID to specific collision behavior for that relationship
	private CustomCollisionMap customCollisionMap;

	// Default Collision Strategy is set at key -2 in the customcollisionmap
	private static final int DEFAULT_COLLISION_KEY = -2;

	private EventStrategyLinkedList eventStrategyList;

	//Default Sprite
	public Sprite()
	{
		coordinates = new SaveablePoint(0,0);
		shapeStrategy = new CircleStrategy();
		customCollisionMap = new CustomCollisionMap();
		sound = new Sound();
		eventStrategyList = new EventStrategyLinkedList();
		setHitBox(new HitBox(this));;
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

	public boolean contains(int x, int y)
	{
		return hitBox.contains(new SaveablePoint(x,y));
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
		shapeStrategy.draw(g, getX(), getY());
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
		obj.put("spriteId",spriteId);
		obj.put("sound",sound.save());
		obj.put("customCollisionMap",customCollisionMap.save());
		obj.put("eventStrategyList",eventStrategyList.save());
		return obj;
	}

	public void load(JSONObject saveData)
	{
		coordinates = new SaveablePoint();
		coordinates.load((JSONObject)saveData.get("coordinates"));
		StrategyLoader sl = new StrategyLoader();
		shapeStrategy = (ShapeStrategy)sl.load((JSONObject)saveData.get("shapeStrategy"));
		customCollisionMap = new CustomCollisionMap();
		customCollisionMap.load((JSONObject)saveData.get("customCollisionMap"));
		customCollisionMap.setColliderForAll(this);
		eventStrategyList = new EventStrategyLinkedList();
		eventStrategyList.load((JSONObject)saveData.get("eventStrategyList"));
		eventStrategyList.setSubjectForAll(this);
	}
	//Just needed for unit testing so doesn't need to be super extensive
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
		c.setCollider(this);
		customCollisionMap.addCustomCollision(sprite2.getSpriteId(), c);
	}

	public void setColor(SaveableColor c)
	{
		shapeStrategy.setColor(c);
	}

	public void addEventStrategy(EventStrategy e)
	{
		e.setSubject(this);
		eventStrategyList.add(e);
	}

	public Integer getEventStrategyListLength()
	{
		return eventStrategyList.length();
	}

	public Sprite copy()
	{
		Sprite s = new Sprite();
		s.setSpriteId(this.spriteId);
		s.setCoordinates(this.coordinates.copy());
		s.setShapeStrategy(this.shapeStrategy.copy());
		s.setSound(this.sound);
		s.setHitBox(new HitBox(s));
		s.setCustomCollisionMap(customCollisionMap.copy());
		s.setEventStrategyLinkedList(eventStrategyList.copy());
		return s;
	}

	private void setEventStrategyLinkedList(EventStrategyLinkedList copy)
	{
		eventStrategyList = copy;
	}

	private void setCustomCollisionMap(CustomCollisionMap ccm)
	{
		customCollisionMap = ccm;
	}

	public void setShapeStrategy(ShapeStrategy shapeStrategy2)
	{
		shapeStrategy = shapeStrategy2;
	}

	private void setCoordinates(SaveablePoint coordinates2)
	{
		coordinates = coordinates2;
	}

	public EventStrategyLinkedList getEventStrategyList() {
		return eventStrategyList;
	}


	public void setVelocityY(int v)
	{
		eventStrategyList.setVelocityY(v);
	}
	public void setVelocityX(int v)
	{
		eventStrategyList.setVelocityX(v);
	}
	public int getVelocityY()
	{
		return eventStrategyList.getVelocityY();
	}
	public int getVelocityX()
	{
		return eventStrategyList.getVelocityX();
	}


	public void onClockTick()
	{
		eventStrategyList.onClockTick();
	}


	public void addCustomCollision(int spriteId2, CollisionStrategy c) 
	{
		c.setCollider(this);
		customCollisionMap.addCustomCollision(spriteId2, c);
	}

}
