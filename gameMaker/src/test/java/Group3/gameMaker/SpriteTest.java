//SaveAndLoadTest.java
//    Created by: Isaiah Sherfick
//    Created on: 22 Sep 2021
//     Edited by:
//Edited last by: Isaiah Sherfick
//   Last change: Created test file for save/load
package Group3.gameMaker;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.*;

import Group3.gameMaker.SaveAndLoad.SaveFileManager;
import Group3.gameMaker.SaveAndLoad.Saveable;
import Group3.gameMaker.SaveAndLoad.SaveablePoint;
import Group3.gameMaker.SaveAndLoad.SaveableString;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class SpriteTest
{
	
	@Test
	public void PointTest()
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
}