
package Group3.gameMaker.CreateGameController;

import Group3.gameMaker.CreateGameModel.CreateGameModel;
import Group3.gameMaker.CreateGameView.CreateGameView;
import Group3.gameMaker.PlayGameController.PlayGameController;
import Group3.gameMaker.PlayGameView.PlayGameView;
import Group3.gameMaker.Sprite.Sprite;
import Group3.gameMaker.Sprite.Strategy.CollisionStrategy.CollisionDetector;

public class CreateGameController
{
	private CreateGameView createGameView;
	private CreateGameModel createGameModel;

	public CreateGameController(CreateGameView createGameView) {
		this.createGameView = createGameView;

	}

	public CreateGameView getCreateGameView() {
		return createGameView;
	}

	public void setCreateGameView(CreateGameView createGameView) {
		this.createGameView = createGameView;
	}

	public void setCreateGameModel(CreateGameModel createGameModel) {
		this.createGameModel = createGameModel;
	}

	public CreateGameModel getCreateGameModel() {
		return createGameModel;
	}

	public void createSprite(Sprite sprite) {
		createGameModel.addSprite(sprite);
	}

	//Passes a sprite which has been modified by the view to the model's spritemaster
	public void modifySprite(Sprite modifiedSprite) {
		createGameModel.modifySprite(modifiedSprite);
	}
	CreateGameController() {

	}

	public void switchContext() {
		// TODO switch CreateGameModel for PlayGameModel
		PlayGameView playGameView = new PlayGameView(createGameModel);
		PlayGameController playGameController = new PlayGameController(playGameView, createGameModel);
	}
}
