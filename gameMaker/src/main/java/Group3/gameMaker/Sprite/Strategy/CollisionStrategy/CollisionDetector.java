package Group3.gameMaker.Sprite.Strategy.CollisionStrategy;

import java.util.ArrayList;
import java.util.HashMap;

import Group3.gameMaker.Sprite.Sprite;
import Group3.gameMaker.Sprite.SpriteMaster;

public class CollisionDetector {
	private SpriteMaster spriteMaster;
	private HashMap<Integer, ArrayList<Integer>> collisionCheckedMap;
	private CustomCollisionMap collisionStrategyMap;

	// TODO: Move this to a Constants package
	public static final int DEFAULT_COLLISION_STRATEGY = 2;

	public CollisionDetector() {
		collisionCheckedMap = new HashMap<Integer, ArrayList<Integer>>();
		spriteMaster = null;
		// check for collision strategy first
	}

	public CollisionDetector(SpriteMaster spriteMaster) {
		this.spriteMaster = spriteMaster;
	}

	public void checkCollisions() {
		ArrayList<Sprite> sprites = spriteMaster.getAllSprites();
		collisionCheckedMap = new HashMap<Integer, ArrayList<Integer>>();
		ArrayList<Integer> checkedList = new ArrayList<Integer>();
		for(int i=0; i<sprites.size(); i++) {
			Sprite collider = sprites.get(i);
			collisionStrategyMap = collider.getCollisionStrategyMap();
			for(int j=i+1; j<sprites.size(); j++) {
				Sprite collidee = sprites.get(j);


				// This nested if is to keep track of previous collision checks of same pair of sprites
				if(collisionStrategyMap.containsKey(collidee.getSpriteId())) {
					collisionStrategyMap.get(collidee.getSpriteId()).collide(collider);
					if(collisionCheckedMap.get(collider) == null) {
						if(collisionCheckedMap.get(collidee.getSpriteId()) == null) {
							checkedList = new ArrayList<Integer>();
							checkedList.add(collider.getSpriteId());
							collisionCheckedMap.put(collidee.getSpriteId(),checkedList);
						} else {
							checkedList = collisionCheckedMap.get(collidee.getSpriteId());
							checkedList.add(collider.getSpriteId());
						}
					} else {
						checkedList = collisionCheckedMap.get(collider.getSpriteId());
						checkedList.add(collidee.getSpriteId());
					}
				}

				collisionStrategyMap = collider.getCollisionStrategyMap();
				if(collisionStrategyMap.containsKey(collidee.getSpriteId())) {
					collisionStrategyMap.get(collidee.getSpriteId()).collide(collidee);
				} else {
					collisionStrategyMap.get(DEFAULT_COLLISION_STRATEGY).collide(collidee);
				}
			}
		}
	}

	public void clearCheckedMap() {
		collisionCheckedMap = null;
		collisionCheckedMap = new HashMap<Integer, ArrayList<Integer>>();
	}
	public boolean checkCollision(Sprite collider, Sprite collidee) {
		return false;
	}

}
