//SaveFileManager.java
//    Created by: Isaiah Sherfick
//    Created on: 22 Sep 2021
//     Edited by:
//Edited last by: Isaiah Sherfick
//   Last change: Created SaveFileManager.java
package SaveAndLoad;
import org.json.simple.JSONObject;
import java.util.ArrayList;
import java.util.Iterator;

public class SaveFileManager
{

	private String pathToSaveFile;
	private ArrayList<Saveable> saveObjects;
	
	//default constructor
	public SaveFileManager()
	{
		this.pathToSaveFile = "save.json";
		this.saveObjects = new ArrayList<>();
	}
	//supplied filename
	public SaveFileManager(String pathToSaveFile)
	{
		this.pathToSaveFile = pathToSaveFile;
		this.saveObjects = new ArrayList<>();
	}
	
	//adds a Saveable to the saveobjects list
	public void addSaveObject(Saveable saveObject)
	{
		saveObjects.add(saveObject);
	}
	
	//adds multiple Saveables to the saveobjects list
	public void addSaveObjects(ArrayList<Saveable> saveableList)
	{
		for (int i = 0; i < saveableList.size(); i++)
		{
			saveObjects.add(saveableList.get(i));
		}
	}
	
	//removes everything from the saveobjects list
	public void clearSaveObjects()
	{
		saveObjects.clear();
	}
	
	//getter
	public ArrayList<Saveable> getSaveObjects()
	{
		return saveObjects;
	}
	
	//getter
	public String getPathToSaveFile()
	{
		return pathToSaveFile;
	}
	
	//setter
	public void setPathToSaveFile(String path)
	{
		pathToSaveFile = path;
	}
	
	//calls save() on every Saveable in saveObjects 
	//and returns a giant JSON with all of them 
	@SuppressWarnings("unchecked")
	public JSONObject save()
	{
		JSONObject obj = new JSONObject();
		for (int i = 0; i < saveObjects.size(); i++)
		{
			obj.put(String.format("%d", i), saveObjects.get(i).save());
		}
		return obj;
	}
	
	//attempts to write the JSONObject created by save()
	//to pathToSaveFile, returns true on success false otherwise
	public boolean saveFile()
	{
		//todo
		return true;
	}
	
	//Populates the saveObjects list with objects
	//by appropriately instantiating them and 
	//calling their respective load() functions
	public void load(JSONObject dataToLoad)
	{
		clearSaveObjects();
		for(@SuppressWarnings("unchecked")
		Iterator<String> iterator = dataToLoad.keySet().iterator(); iterator.hasNext();) 
		{
			  String key = (String) iterator.next();
			  JSONObject val = (JSONObject) dataToLoad.get(key);
			  String type = (String)val.get("type");
			  switch(type)
			  {
			  		case "SaveableString":
			  			SaveableString newObject = new SaveableString();
			  			newObject.load(val);
			  			saveObjects.add(newObject);
			  			break;
			  		default:
			  			break;
			  }
		}
	}
	
	//opens the file at pathToSaveFile and calls
	//load() on the JSON found there
	public void loadFile()
	{
		//todo
	}
}
