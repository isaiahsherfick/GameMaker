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
	private boolean threadAlreadyRunning;
	public GameClock()
	{
		observers = new ArrayList<>();
		paused = true;
		myThread = new Thread(this);
		threadAlreadyRunning = false;
		ticks = 0;
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
		ticks++;
		System.out.println("Ticks: " +ticks);
		System.out.println("Seconds: " + getTicksInSeconds());
	}
	
	public void start()
	{
		if (!threadAlreadyRunning)
		{
			myThread.start();
			paused = false;
			threadAlreadyRunning = true;
		}

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
			threadAlreadyRunning = false;
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
				return (int)Math.floor(ticks / 60);
			case THIRTY_FPS:
				return (int) Math.floor(ticks / 30);
			default:
				return 0;
		}
	}
	
	//run() for the thread
	public void run()
	{
		while(threadAlreadyRunning)
		{
			try 
			{
				Thread.sleep(MILLISECONDS_BETWEEN_FRAMES);
				if (!paused)
				{
					tick();
				}
			} 
			catch (InterruptedException e) 
			{
				System.out.println("Something interrupted the clock thread");
				e.printStackTrace();
			}
		}
	}

	public void addObserver(Controller playGameController) 
	{
		observers.add(playGameController);
	}
}
