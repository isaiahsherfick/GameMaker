package Group3.gameMaker;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

import Group3.gameMaker.Controller.CreateGameController.CreateGameController;
import Group3.gameMaker.Controller.PlayGameController.GameClock;
import Group3.gameMaker.Controller.PlayGameController.PlayGameController;
import Group3.gameMaker.Model.CreateGameModel.CreateGameModel;
import Group3.gameMaker.Model.PlayGameModel.PlayGameModel;
import Group3.gameMaker.SaveAndLoad.SaveablePoint;
import Group3.gameMaker.Sprite.Sprite;
import Group3.gameMaker.Sprite.Strategy.EventStrategy.MoveOnClockTickStrategy;
import Group3.gameMaker.View.CreateGameView.CreateGameView;
import Group3.gameMaker.View.PlayGameView.PlayGameView;

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
	

	@Test
	public void PlayMVCTest()
	{
		CreateGameModel cm = new CreateGameModel();
		CreateGameView cv = new CreateGameView();
		CreateGameController cc = new CreateGameController();
		cv.setCreateGameController(cc);
		cm.addObserver(cv);
		cm.setCreateGameController(cc);
		cc.setCreateGameModel(cm);
		cc.setCreateGameView(cv);
		cv.createSprite(); 
		assertEquals(cm.getSpriteMaster().numberOfSprites(),1); //Add a sprite //Should be at 0,0 with a donothingstrategy
		cv.addEventStrategy(new MoveOnClockTickStrategy(5,5), 0);
		cv.createSprite();

		
		
		PlayGameModel m = new PlayGameModel();
		PlayGameView v = new PlayGameView();
		PlayGameController c = new PlayGameController();

		v.setPlayGameController(c);
		m.addObserver(v);
		m.setPlayGameController(c);
		c.setPlayGameModel(m);
		c.setPlayGameView(v);
		m.setCreateGameModel(cm);
		m.pull();
		
		SaveablePoint before = m.getSprite(0).getCoordinates().copy();
		c.startClock();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SaveablePoint after = m.getSprite(0).getCoordinates();
		System.out.println(before.getX());
		assertNotEquals(before.getX(), after.getX());
		c.stopClock();

	}
	

}
