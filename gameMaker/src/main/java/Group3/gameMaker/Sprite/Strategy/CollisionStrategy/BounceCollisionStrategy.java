package Group3.gameMaker.Sprite.Strategy.CollisionStrategy;

import org.json.simple.JSONObject;

import Group3.gameMaker.Sprite.Sprite;

public class BounceCollisionStrategy implements CollisionStrategy {

	private static final int FLIP_DIRECTION = -1;
	Sprite collider;

	public BounceCollisionStrategy(Sprite collider) {
		this.collider = collider;
	}
	
	public BounceCollisionStrategy()
	{
		
	}
	
	public void setCollider(Sprite s)
	{
		collider = s;
	}

	public JSONObject save() {
		JSONObject obj = new JSONObject();
		obj.put("type","BounceCollisionStrategy");
		return obj;
	}

	//nothing needed to do, just call setCollider in Sprite
	public void load(JSONObject saveJSON) {
	}

	@Override
	public void collide(Sprite collidee) {
		int velocityX, velocityY;
		switch (collider.getHitBox().overlaps(collidee.getHitBox())) {
		case TOP_LEFT:
		case TOP_RIGHT:
		case BOTTOM_LEFT:
		case BOTTOM_RIGHT:
			velocityX = collider.getVelocityX();
			collider.setVelocityX(velocityX * FLIP_DIRECTION);
			velocityY = collider.getVelocityY();
			collider.setVelocityY(velocityY * FLIP_DIRECTION);
			break;
		case BOTTOM_CENTER:
		case TOP_CENTER:
			velocityY = collider.getVelocityY();
			collider.setVelocityY(velocityY * FLIP_DIRECTION);
			break;
		case LEFT_CENTER:
		case RIGHT_CENTER:
			velocityX = collider.getVelocityX();
			collider.setVelocityX(velocityX * FLIP_DIRECTION);
			break;
		case NO_OVERLAP:
		};
		collidee.getCollisionStrategyMap().get(collider.getSpriteId()).collide(collider);
	}

}
