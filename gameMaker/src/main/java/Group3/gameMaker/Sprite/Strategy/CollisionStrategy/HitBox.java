package Group3.gameMaker.Sprite.Strategy.CollisionStrategy;

import Group3.gameMaker.SaveAndLoad.SaveablePoint;
import Group3.gameMaker.Sprite.Sprite;

/*
 * This is assuming a rectangular axis-aligned bounding box, which we are terming a hitbox.
 */
public class HitBox {

	Sprite sprite;

	public HitBox(Sprite s){
		sprite = s;
	}

	public HitBoxOverlapType overlaps(HitBox secondaryBox) {
		SaveablePoint bottomLeft  = new SaveablePoint(sprite.getX(), sprite.getY());
		SaveablePoint topRight = new SaveablePoint(sprite.getX() + sprite.getShapeStrategy().getWidth(), sprite.getY() + sprite.getShapeStrategy().getHeight());
		boolean bottomOverlap = bottomLeft.getY() >= secondaryBox.getTopRight().getY(); // Positive implies overlap
		boolean topOverlap = topRight.getY() <= secondaryBox.getBottomLeft().getY(); // Negative implies overlap
		boolean leftOverlap = bottomLeft.getX() <= secondaryBox.getTopRight().getX(); // Negative implies overlap
		boolean rightOverlap = topRight.getX() >= secondaryBox.getBottomLeft().getX(); // Positive implies overlap

		if(bottomOverlap) {
			if(leftOverlap) return HitBoxOverlapType.BOTTOM_LEFT;
			else if(rightOverlap) return HitBoxOverlapType.BOTTOM_RIGHT;
			else return HitBoxOverlapType.BOTTOM_CENTER;
		} else if(topOverlap) {
			if(leftOverlap) return HitBoxOverlapType.TOP_LEFT;
			else if(rightOverlap) return HitBoxOverlapType.TOP_RIGHT;
			else return HitBoxOverlapType.TOP_CENTER;
		} else if(leftOverlap) return HitBoxOverlapType.LEFT_CENTER;
		else if(rightOverlap) return HitBoxOverlapType.RIGHT_CENTER;
		return HitBoxOverlapType.NO_OVERLAP;
	}

	public SaveablePoint getBottomLeft() {
		return new SaveablePoint(sprite.getX(), sprite.getY());
	}

	public SaveablePoint getTopRight() {
		return new SaveablePoint(sprite.getX() + sprite.getShapeStrategy().getWidth(), sprite.getY() + sprite.getShapeStrategy().getHeight());
	}
}
