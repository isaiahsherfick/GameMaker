package Group3.gameMaker.View.CreateGameView;

public enum SHAPE {
	
	BLUE("/Group3/gameMaker/Resource/icons8-filled-circle-64.png", "/Group3/gameMaker/Resource/blue_life.png"),
	GREEN("/Group3/gameMaker/Resource/icons8-rectangle-64.png", "/Group3/gameMaker/Resource/green_life.png");
	//ORANGE("icons8-star.gif", "orange_life.png");
//	RED("/resources/red_ship.png", "/resources/red_life.png");
	
	String urlShip;
	String urlLife;
	
	private SHAPE(String urlShip, String urlLife) {
		this.urlShip = urlShip;
		this.urlLife = urlLife;
	}
	
	public String getUrl() {
		return this.urlShip;
	}
	
	public String getUrlLife() {
		return urlLife;
	}

}
