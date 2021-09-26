//SpriteMaster.java
//    Created by: Isaiah Sherfick
//    Created on: 25 Sep 2021
//     Edited by:
//Edited last by: Isaiah Sherfick
//   Last change: Created class for managing all sprites in a game

package Group3.gameMaker.CreateGameModel;

import java.util.ArrayList;

import Group3.gameMaker.Sprite.Sprite;
import javafx.scene.canvas.GraphicsContext;

public class SpriteMaster
{
	private ArrayList<Sprite> sprites;
	public SpriteMaster()
	{
		this.sprites = new ArrayList<>();
	}
	public ArrayList<Sprite> getSprites()
	{
		return sprites;
	}
	public void drawSprites(GraphicsContext g)
	{
		for (int i = 0; i < sprites.size(); i++)
		{
			sprites.get(i).draw(g);
		}
	}
	public void add(Sprite s)
	{
		sprites.add(s);
	}
	public void remove(Sprite s)
	{
		sprites.remove(s);
	}
	public void add(ArrayList<Sprite> ss)
	{
		for (int i = 0; i < ss.size(); i++)
		{
			sprites.add(ss.get(i));
		}
	}
} 
