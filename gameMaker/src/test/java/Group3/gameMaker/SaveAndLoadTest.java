//SaveAndLoadTest.java
//    Created by: Isaiah Sherfick
//    Created on: 22 Sep 2021
//     Edited by:
//Edited last by: Isaiah Sherfick
//   Last change: Created test file for save/load
package Group3.gameMaker;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.*;

import Group3.gameMaker.Sprite.SpriteMaster;
import Group3.gameMaker.Sprite.Strategy.ShapeStrategy.CircleStrategy;
import Group3.gameMaker.CreateGameModel.CreateGameModel;
import Group3.gameMaker.SaveAndLoad.SaveFileManager;
import Group3.gameMaker.SaveAndLoad.Saveable;
import Group3.gameMaker.SaveAndLoad.SaveableColor;
import Group3.gameMaker.SaveAndLoad.SaveablePoint;
import Group3.gameMaker.SaveAndLoad.SaveableString;
import Group3.gameMaker.Sprite.Sprite;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

public class SaveAndLoadTest
{
	
	@Test
	public void SaveablePointTest()
	{
		int x,y;
		x = 1;
		y = 5;
		SaveablePoint p = new SaveablePoint(x,y);
		assertEquals(p.getX(),x);
		assertEquals(p.getY(),y);
		JSONObject saveObj = p.save();
		SaveablePoint p2 = new SaveablePoint();
		assertNotEquals(p,p2);
		p2.load(saveObj);
		assertEquals(p,p2);
	}
	
	@Test
	public void SaveableStringTest()
	{
		SaveableString ss1 = new SaveableString("Hello");
		SaveableString ss2 = new SaveableString("world");
		JSONObject save1 = ss1.save();
		JSONObject save2 = ss2.save();
		SaveableString ss3 = new SaveableString();
		ss3.load(save1);
		assertEquals(ss1,ss3);
		SaveableString ss4 = new SaveableString();
		ss4.load(save2);
		assertEquals(ss2,ss4);

	}
	
	@Test
	//This also tests StrategyLoader and ShapeStrategies
	public void SpriteTest()
	{
		SaveFileManager sfm = new SaveFileManager();
		SaveableColor red = new SaveableColor(1,0,0,1);
		Sprite breakoutBall = new Sprite(1,2,new CircleStrategy(5,red), 0);
		sfm.addSaveObject(breakoutBall);
		//saving and loading to default location
		try 
		{
			sfm.saveFile();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		SaveFileManager loader = new SaveFileManager();
		try 
		{
			loader.loadFile();
		} 
		catch (IOException | ParseException e) 
		{
			e.printStackTrace();
		}

		for (int i = 0; i < loader.getSaveObjects().size(); i++)
		{
			assertEquals(loader.getSaveObjects().get(i), sfm.getSaveObjects().get(i));
		}
	}
	
	@Test
	public void SpriteMasterTest()
	{
		SpriteMaster sm = new SpriteMaster();
		Sprite breakoutBall = new Sprite();
		Sprite breakoutBall2 = new Sprite();
		Sprite breakoutBall3 = new Sprite();
		Sprite breakoutBall4 = new Sprite();
		Sprite breakoutBall5 = new Sprite();
		Sprite breakoutBall6 = new Sprite();
		
		ArrayList<Sprite> sprites = new ArrayList<>();


		sprites.add(breakoutBall);
		sprites.add(breakoutBall2);
		sprites.add(breakoutBall3);
		sprites.add(breakoutBall4);
		sprites.add(breakoutBall5);
		sprites.add(breakoutBall6);
		
		for (int i = 0; i < sprites.size(); i++)
		{
			sm.add(sprites.get(i));
			System.out.println(sprites.get(i).getSpriteId());
		}

		for (int i = 0; i < sprites.size(); i++)
		{
			//assert that the spriteId is getting set correctly
			assertEquals(sprites.get(i).getSpriteId(),i);
			
			//assert that the spritemaster is storing them correctly
			assertEquals(sprites.get(i), sm.get(i));
		}
	}
	
	@Test
	public void SaveTest()
	{
		SaveFileManager sfm = new SaveFileManager();
		SaveableString ss1 = new SaveableString("I");
		SaveableString ss2 = new SaveableString(" want");
		SaveableString ss3 = new SaveableString(" this");
		SaveableString ss4 = new SaveableString(" to");
		SaveableString ss5 = new SaveableString(" save");
		SaveableString ss6 = new SaveableString(" and");
		SaveableString ss7 = new SaveableString(" load");
		SaveableString ss8 = new SaveableString(" without issue!");
		
		ArrayList<Saveable> saveStrings = new ArrayList<>();
		saveStrings.add(ss1);
		saveStrings.add(ss2);
		saveStrings.add(ss3);
		saveStrings.add(ss4);
		saveStrings.add(ss5);
		saveStrings.add(ss6);
		saveStrings.add(ss7);
		saveStrings.add(ss8);
		
		sfm.addSaveObjects(saveStrings);
		JSONObject saveObj = sfm.save();
		
		SaveFileManager loader = new SaveFileManager();
		
		loader.load(saveObj);
		for (int i = 0; i < loader.getSaveObjects().size(); i++)
		{
			assertTrue(loader.getSaveObjects().contains(saveStrings.get(i)));
		}

		for (int i = 0; i < loader.getSaveObjects().size(); i++)
		{
			assertEquals(loader.getSaveObjects().get(i), sfm.getSaveObjects().get(i));
		}
	}
	@Test
	public void SaveFileTest()
	{
		SaveFileManager sfm = new SaveFileManager();
		SaveableString ss1 = new SaveableString("I");
		SaveableString ss2 = new SaveableString(" want");
		SaveableString ss3 = new SaveableString(" this");
		SaveableString ss4 = new SaveableString(" to");
		SaveableString ss5 = new SaveableString(" save");
		SaveableString ss6 = new SaveableString(" and");
		SaveableString ss7 = new SaveableString(" load");
		SaveableString ss8 = new SaveableString(" without issue!");
		SaveablePoint point = new SaveablePoint(1,2);
		
		ArrayList<Saveable> saveables = new ArrayList<>();
		saveables.add(ss1);
		saveables.add(ss2);
		saveables.add(ss3);
		saveables.add(ss4);
		saveables.add(ss5);
		saveables.add(ss6);
		saveables.add(ss7);
		saveables.add(ss8);
		saveables.add(point);
		
		sfm.addSaveObjects(saveables);
		
		//saving and loading to default location
		try 
		{
			sfm.saveFile();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		SaveFileManager loader = new SaveFileManager();

		try 
		{
			loader.loadFile();
		} 
		catch (IOException | ParseException e) 
		{
			e.printStackTrace();
		}
		
		for (int i = 0; i < loader.getSaveObjects().size(); i++)
		{
			assertTrue(loader.getSaveObjects().contains(saveables.get(i)));
		}

		//Somehow their ordering is preserved automatically
		//seeing as this passes too
		for (int i = 0; i < loader.getSaveObjects().size(); i++)
		{
			assertEquals(loader.getSaveObjects().get(i), sfm.getSaveObjects().get(i));
		}
	}
	
	@Test
	public void MovementStrategyPreservationTest()
	{
		//Create SLManager, SpriteMaster, Sprite with AutomaticMovementStrategy
		//Save the sprite, load it, assert that the new Sprite's 
		//AutomaticMovementStrategy points to the new sprite
		
		//TODO

		CreateGameModel cgm = new CreateGameModel();
		Sprite automaticBall = new Sprite();
		int before = automaticBall.getSpriteId();
		//System.out.println(before);
		cgm.addSprite(automaticBall);
		//System.out.println(automaticBall.getSpriteId());
		int after = automaticBall.getSpriteId();
		assertNotEquals(before,after);

		
		cgm.saveFile();
		
		//Reset these guys
		cgm.setSpriteMaster(new SpriteMaster());
		cgm.setSaveFileManager(new SaveFileManager());
		
		cgm.loadFile();
		
		assertEquals(automaticBall, cgm.getSprite(after));
		assertEquals(automaticBall.getMovementStrategy(), cgm.getSprite(after).getMovementStrategy());
	}
}