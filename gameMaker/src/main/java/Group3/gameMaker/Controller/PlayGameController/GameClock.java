package Group3.gameMaker.Controller.PlayGameController;

import java.util.ArrayList;

import Group3.gameMaker.Controller.Controller;

public class GameClock implements Runnable
{
	private ArrayList<Controller> observers;
	private boolean paused;
	private static final int SIXTY_FPS = 16;
	private static final int THIRTY_FPS = 33;
	private static final int MILLISECONDS_BETWEEN_FRAMES = SIXTY_FPS;
	private int ticks;
	private Thread myThread;
	public GameClock()
	{
		observers = new ArrayList<>();
		paused = true;
		myThread = new Thread(this);
	}
	
	public void notifyObservers()
	{
		for (Controller c : observers)
		{
			c.update();
		}
	}

	public void tick() 
	{
		notifyObservers();
	}
	
	public void start()
	{
		myThread.start();
	}
	
	public void pause()
	{
		paused = true;
	}
	
	public void unpause()
	{
		paused = false;
	}
	
	public void stop()
	{
		try 
		{
			myThread.join();
		} 
		catch (InterruptedException e) 
		{
			System.out.println("Something interrupted the clock thread");
			e.printStackTrace();
		}
	}
	
	
	public int getTicks()
	{
		return ticks;
	}
	
	public int getTicksInSeconds()
	{
		switch(MILLISECONDS_BETWEEN_FRAMES)
		{
			case SIXTY_FPS:
				return ticks * 60;
			case THIRTY_FPS:
				return ticks * 30;
			default:
				return 0;
		}
	}
	
	public void run()
	{
		if (!paused)
		{
			try 
			{
				Thread.sleep(MILLISECONDS_BETWEEN_FRAMES);
				tick();
			} 
			catch (InterruptedException e) 
			{
				System.out.println("Something interrupted the clock thread");
				e.printStackTrace();
			}
		}
	}
}
