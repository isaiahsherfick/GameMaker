package Group3.gameMaker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Group3.gameMaker.Controller.CreateGameController.CreateGameController;
import Group3.gameMaker.Model.CreateGameModel.CreateGameModel;
import Group3.gameMaker.Sprite.Sprite;
import Group3.gameMaker.Sprite.Strategy.EventStrategy.MoveOnClockTickStrategy;
import Group3.gameMaker.View.CreateGameView.CreateGameView;

class MVCTest {

	@Test
	public void CreateMVCTest()
	{
		CreateGameModel m = new CreateGameModel();
		CreateGameView v = new CreateGameView();
		CreateGameController c = new CreateGameController();
		v.setCreateGameController(c);
		m.addObserver(v);
		m.setCreateGameController(c);
		c.setCreateGameModel(m);
		c.setCreateGameView(v);
		
		v.createSprite();
		assertEquals(m.getSpriteMaster().numberOfSprites(),1);
		//Also expect a print statement for drawing sprite#0
		
		v.createSprite();
		assertEquals(m.getSpriteMaster().numberOfSprites(),2);
		//Also expect a print statement for drawing sprite#0
		
		v.addEventStrategy(new MoveOnClockTickStrategy(),1);
		
		assertEquals(m.getSpriteMaster().get(1).getEventStrategyListLength(), 2); //moveontick -> donothing
		
		v.undo();

		assertEquals(m.getSpriteMaster().get(1).getEventStrategyListLength(), 1); //donothing
		
		v.redo();

		assertEquals(m.getSpriteMaster().get(1).getEventStrategyListLength(), 2); //moveontick -> donothing
		
		v.undo();

		assertEquals(m.getSpriteMaster().get(1).getEventStrategyListLength(), 1); //donothing

		v.undo();

		assertEquals(m.getSpriteMaster().numberOfSprites(),1);
		//Also expect a print statement for drawing sprite#0
	}
	

}
