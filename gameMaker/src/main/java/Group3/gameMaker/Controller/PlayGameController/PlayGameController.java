package Group3.gameMaker.Controller.PlayGameController;

import java.util.ArrayList;
import java.util.HashMap;

import Group3.gameMaker.Controller.Controller;
import Group3.gameMaker.Model.Model;
import Group3.gameMaker.Sprite.Sprite;
import Group3.gameMaker.Sprite.Strategy.CollisionStrategy.CollisionDetector;
import Group3.gameMaker.View.View;
import Group3.gameMaker.View.PlayGameView.PlayGameView;

public class PlayGameController implements Controller
{

	private View playGameView;
	private Model playGameModel;
	private GameClock clock;

	public PlayGameController()
	{
		CollisionDetector collisionDetector = new CollisionDetector();
		clock = new GameClock();
		clock.addObserver(this);
	}

	public View getPlayGameView()
	{
		return playGameView;
	}

	public void setPlayGameView(PlayGameView playGameView)
	{
		this.playGameView = playGameView;
	}

	public Model getPlayGameModel()
	{
		return playGameModel;
	}
	@Override
	public Sprite getSprite(int spriteId)
	{
		return playGameModel.getSprite(spriteId);
	}

	@Override
	public void deleteSprite(int spriteId)
	{
		//Not needed for play context
	}

	@Override
	public void createSprite(Sprite s)
	{
		//Not needed for play context
	}

	@Override
	public void modifySprite(Sprite s)
	{
		//Not needed for play context
	}

	@Override
	public void undo()
	{
		//Not yet possible in play context
	}

	@Override
	public void redo()
	{
		//Not yet possible in play context
	}

	@Override
	public HashMap<Integer, Integer> getSpriteIds()
	{
		return playGameModel.getSpriteMaster().getViewMap();
	}

	public void setPlayGameModel(Model m)
	{
		playGameModel = m;
	}

	//Force the clock to tick for unit testing
	public void forceTick()
	{
		clock.tick();
	}

	//called whenever the clock ticks
	public void update()
	{
		ArrayList<Sprite> sprites = playGameModel.getSpriteMaster().getAllSprites();
		for (Sprite sprite : sprites)
		{
			sprite.onClockTick();
		}
	}

	public void onKeyPress()
	{

	}

	public void startClock()
	{
		clock.start();
	}

	public void stopClock()
	{
		clock.stop();
	}

	public void pause()
	{
		clock.pause();
	}

	public void unpause()
	{
		clock.unpause();
	}

	@Override
	public ArrayList<Sprite> getAllSprites() {
		return playGameModel.getSpriteMaster().getAllSprites();
	}

	@Override
	public boolean save() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int load() {
		// TODO Auto-generated method stub
		return 0;
	}
}
