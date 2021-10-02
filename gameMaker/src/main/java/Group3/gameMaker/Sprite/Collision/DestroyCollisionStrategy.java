package Group3.gameMaker.Sprite.Collision;

import org.json.simple.JSONObject;

import Group3.gameMaker.Sprite.Sprite;

public class DestroyCollisionStrategy implements CollisionStrategy {

	Sprite collider;

	public DestroyCollisionStrategy(Sprite collider) {
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
		// TODO Auto-generated method stub

	}

	@Override
	public void setCollider(Sprite sprite) {
		// TODO Auto-generated method stub
		
	}

}
