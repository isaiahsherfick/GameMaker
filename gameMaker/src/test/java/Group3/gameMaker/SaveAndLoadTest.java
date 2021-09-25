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
import Group3.gameMaker.SaveAndLoad.SaveableString;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class SaveAndLoadTest
{
	
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
	public void SaveTest()
	{
		SaveFileManager sfm = new SaveFileManager();
		//Note: These will not save in any order
		//JSON can't do that
		//We COULD make a saveable arraylist of strings
		//if we really cared about that
		//I don't see it as necessary
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

		//Somehow their ordering is preserved automatically
		//seeing as this passes too
		for (int i = 0; i < loader.getSaveObjects().size(); i++)
		{
			assertEquals(loader.getSaveObjects().get(i), sfm.getSaveObjects().get(i));
		}
	}
	@Test
	public void SaveFileTest()
	{
		SaveFileManager sfm = new SaveFileManager();
		//Note: These will not save in any order
		//JSON can't do that
		//We COULD make a saveable arraylist of strings
		//if we really cared about that
		//I don't see it as necessary
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
	}
}