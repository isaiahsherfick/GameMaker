package Group3.gameMaker.Sprite.Collision;

/*
 * This class does not implement saveable. It is a protected class that is used by  the HitBox class
 */
final class Point {

	int posX;
	int posY;

	public Point(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
}
