package Group3.gameMaker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Group3.gameMaker.Controller.PlayGameController.PlayGameController;
import Group3.gameMaker.Model.PlayGameModel.PlayGameModel;

class ClockTest {

	@Test
	//Uncomment the print statement in GameClock.tick() to test this
	public void GameClockTest() throws InterruptedException
	{
		PlayGameModel p = new PlayGameModel();
		PlayGameController c = new PlayGameController();
		c.setPlayGameModel(p);
		c.startClock();
		Thread.sleep(1000);
		System.out.println("Pause!");
		c.pause();
		Thread.sleep(1000);
		System.out.println("Unpause!");
		c.unpause();
		Thread.sleep(3000);
		c.stopClock();
		System.out.println("Stop!");
		
		
	}

}
