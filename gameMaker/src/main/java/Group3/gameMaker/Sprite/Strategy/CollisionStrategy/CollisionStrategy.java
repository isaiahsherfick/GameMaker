//Sprite.java
//    Created by: Isaiah Sherfick
//    Created on: 25 Sep 2021
//     Edited by: Raghunadham Gattu
//Edited last by: Raghunadham Gattu
//   Last change: Added collision strategy for movement

package Group3.gameMaker.Sprite.Collision;

import Group3.gameMaker.SaveAndLoad.Saveable;
import Group3.gameMaker.Sprite.Sprite;

public interface CollisionStrategy extends Saveable
{
	public void collide(Sprite collidee);

	public void setCollider(Sprite sprite);
}
