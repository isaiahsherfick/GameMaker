package Group3.gameMaker.Sprite.Collision;

import org.json.simple.JSONObject;

import Group3.gameMaker.Sprite.Sprite;

public class BounceCollisionStrategy implements CollisionStrategy {

	private static final int FLIP_DIRECTION = -1;
	Sprite collider;

	BounceCollisionStrategy(Sprite collider) {
		this.collider = collider;
	}

	@Override
	public JSONObject save() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void load(JSONObject saveJSON) {
		// TODO Auto-generated method stub

	}

	@Override
	public void collide(Sprite collidee) {
		int velocityX, velocityY;
		switch (collider.getHitBox().overlaps(collidee.getHitBox())) {
		case TOP_LEFT:
		case TOP_RIGHT:
		case BOTTOM_LEFT:
		case BOTTOM_RIGHT:
			velocityX = collider.getMovementStrategy().getVelocityX();
			collider.getMovementStrategy().setVelocityX(velocityX * FLIP_DIRECTION);
			velocityY = collider.getMovementStrategy().getVelocityY();
			collider.getMovementStrategy().setVelocityY(velocityY * FLIP_DIRECTION);
			break;
		case BOTTOM_CENTER:
		case TOP_CENTER:
			velocityY = collider.getMovementStrategy().getVelocityY();
			collider.getMovementStrategy().setVelocityY(velocityY * FLIP_DIRECTION);
			break;
		case LEFT_CENTER:
		case RIGHT_CENTER:
			velocityX = collider.getMovementStrategy().getVelocityX();
			collider.getMovementStrategy().setVelocityX(velocityX * FLIP_DIRECTION);
			break;
		case NO_OVERLAP:
		};
		collidee.getCollisionStrategyMap().get(collider.getSpriteId()).collide(collider);
	}

}
