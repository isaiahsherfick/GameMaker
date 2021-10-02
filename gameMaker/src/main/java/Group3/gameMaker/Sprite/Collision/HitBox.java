package Group3.gameMaker.Sprite.Collision;

import Group3.gameMaker.Sprite.Sprite;

/*
 * This is assuming a rectangular axis-aligned bounding box, which we are terming a hitbox.
 */
public class HitBox {

	Point bottomLeft;
	Point topRight;
	Sprite sprite;

	public HitBox(Sprite s) {
		sprite = s;
		bottomLeft.setPosX(s.getX());
		bottomLeft.setPosY(s.getY());
		topRight.setPosX(s.getX() + s.getShapeStrategy().getWidth());
		topRight.setPosY(s.getY() + s.getShapeStrategy().getHeight());
	}

	public HitBoxOverlapType overlaps(HitBox secondaryBox) {
//		int deltaBottom = this.bottomLeft.getPosY() - secondaryBox.getTopRight().getPosY(); // Positive implies overlap
//		int deltaTop = this.topRight.getPosY() - secondaryBox.getBottomLeft().getPosY(); // Negative implies overlap
//		int deltaLeft = this.bottomLeft.getPosX() - secondaryBox.getTopRight().getPosX(); // Negative implies overlap
//		int deltaRight = this.topRight.getPosX() - secondaryBox.getBottomLeft().getPosX(); // Positive implies overlap
		boolean bottomOverlap = this.bottomLeft.getPosY() >= secondaryBox.getTopRight().getPosY(); // Positive implies overlap
		boolean topOverlap = this.topRight.getPosY() <= secondaryBox.getBottomLeft().getPosY(); // Negative implies overlap
		boolean leftOverlap = this.bottomLeft.getPosX() <= secondaryBox.getTopRight().getPosX(); // Negative implies overlap
		boolean rightOverlap = this.topRight.getPosX() >= secondaryBox.getBottomLeft().getPosX(); // Positive implies overlap

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

	public Point getBottomLeft() {
		return bottomLeft;
	}

	public void setBottomLeft(Point bottomLeft) {
		this.bottomLeft = bottomLeft;
	}

	public Point getTopRight() {
		return topRight;
	}

	public void setTopRight(Point topRight) {
		this.topRight = topRight;
	}

}
