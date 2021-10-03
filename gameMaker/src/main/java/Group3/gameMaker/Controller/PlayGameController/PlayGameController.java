package Group3.gameMaker.Controller.PlayGameController;

import Group3.gameMaker.Controller.Controller;
import Group3.gameMaker.Model.CreateGameModel.CreateGameModel;
import Group3.gameMaker.Model.PlayGameModel.PlayGameModel;
import Group3.gameMaker.Sprite.Sprite;
import Group3.gameMaker.Sprite.SpriteMaster;
import Group3.gameMaker.Sprite.Strategy.CollisionStrategy.CollisionDetector;
import Group3.gameMaker.View.PlayGameView.PlayGameView;

public class PlayGameController implements Controller
{

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
	@Override
	public Sprite getSprite(int spriteId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteSprite(int spriteId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createSprite(Sprite s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifySprite(Sprite s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		
	}
}
