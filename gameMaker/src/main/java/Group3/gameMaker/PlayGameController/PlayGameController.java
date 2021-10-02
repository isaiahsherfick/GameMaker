package Group3.gameMaker.PlayGameController;

import Group3.gameMaker.CreateGameModel.CreateGameModel;
import Group3.gameMaker.PlayGameModel.PlayGameModel;
import Group3.gameMaker.PlayGameView.PlayGameView;
import Group3.gameMaker.PlayGameModel.PlayGameModel;
import Group3.gameMaker.PlayGameView.PlayGameView;
import Group3.gameMaker.Sprite.Sprite;
import Group3.gameMaker.Sprite.SpriteMaster;
import Group3.gameMaker.Sprite.Collision.CollisionDetector;

public class PlayGameController {

	private PlayGameView playGameView;
//	private PlayGameModel playGameModel;
	// TODO Change playGameModel to a reference of PlayGameModel class
	private CreateGameModel playGameModel;
	private SpriteMaster spriteMaster;

	public PlayGameController(PlayGameView playGameView, CreateGameModel playGameModel) {
		this.playGameView = playGameView;
		spriteMaster = playGameModel.getSpriteMaster();
		CollisionDetector collisionDetector = new CollisionDetector(spriteMaster);


	}

	public PlayGameController() {
		CollisionDetector collisionDetector = new CollisionDetector();

	}


	public PlayGameView getPlayGameView() {
		return playGameView;
	}

	public void setPlayGameView(PlayGameView playGameView) {
		this.playGameView = playGameView;
	}

	public void setPlayGameModel(CreateGameModel playGameModel) {
		this.playGameModel = playGameModel;
	}

	public CreateGameModel getPlayGameModel() {
		return playGameModel;
	}
/*
	public void addSprite(Sprite sprite) {
		playGameModel.addSprite(sprite);
	}

	public void modifySprite(Sprite sprite) {
		playGameModel.modifySprite(sprite);
	}
*/
}
