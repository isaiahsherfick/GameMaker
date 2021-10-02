package Group3.gameMaker.Sprite.Collision;

import org.json.simple.JSONObject;

import Group3.gameMaker.Sprite.Sprite;

public class NoCollisionStrategy implements CollisionStrategy{

	@Override
	public JSONObject save() {

		return null;
	}

	@Override
	public void load(JSONObject saveJSON) {
	}

	@Override
	public void collide(Sprite collidee) {
		// Do nothing
	}

	@Override
	public void setCollider(Sprite sprite) {
		// TODO Auto-generated method stub
		
	}

}
