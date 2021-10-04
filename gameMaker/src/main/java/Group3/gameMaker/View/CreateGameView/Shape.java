package Group3.gameMaker.View.CreateGameView;

public enum Shape {

	BLUE("/Group3/gameMaker/Resource/icons8-filled-circle-64.png", "/Group3/gameMaker/Resource/blue_life.png"),
	GREEN("/Group3/gameMaker/Resource/icons8-rectangle-64.png", "/Group3/gameMaker/Resource/green_life.png");
	//ORANGE("icons8-star.gif", "orange_life.png");
//	RED("/resources/red_ship.png", "/resources/red_life.png");

	String urlShape;
	String urlColor;

	private Shape(String urlShape, String urlColor) {
		this.urlShape = urlShape;
		this.urlColor = urlColor;
	}

	public String getUrl() {
		return this.urlShape;
	}

	public String getUrlColor() {
		return urlColor;
	}

}