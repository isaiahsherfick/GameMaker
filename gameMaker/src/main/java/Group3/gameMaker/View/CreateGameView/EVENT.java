package Group3.gameMaker.View.CreateGameView;

public enum EVENT {
	
	BLUE("/Group3/gameMaker/Resource/icons8-bounce-up-64.png", "/Group3/gameMaker/Resource/blue_life.png"),
	GREEN("/Group3/gameMaker/Resource/icons8-cross-64.png", "/Group3/gameMaker/Resource/green_life.png"),
	ORANGE("/Group3/gameMaker/Resource/icons8-destroyed-64.png", "/Group3/gameMaker/Resource/orange_life.png");
//	RED("/resources/red_ship.png", "/resources/red_life.png");
	
	String urlShip;
	String urlLife;
	
	private EVENT(String urlShip, String urlLife) {
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