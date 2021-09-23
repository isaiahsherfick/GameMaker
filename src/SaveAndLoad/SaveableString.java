//SaveableString.java
//    Created by: Isaiah Sherfick
//    Created on: 22 Sep 2021
//     Edited by:
//Edited last by: Isaiah Sherfick
//   Last change: Created SaveFileManager.java
package SaveAndLoad;

import org.json.simple.JSONObject;

//Just exists to run some unit tests before the other objects
//are made

//Also is kind of the example for how we will write wrapper classes
//for classes which we cannot force to implement Saveable
public class SaveableString implements Saveable
{
	private String string;
	public SaveableString()
	{
		this.string = "";
	}
	public SaveableString(String string)
	{
		this.string = string;
	}
	
	public void setString(String s)
	{
		string = s;
	}
	
	public String getString()
	{
		return string;
	}

	@SuppressWarnings("unchecked")
	public JSONObject save()
	{
		JSONObject obj = new JSONObject();
		obj.put("type", "SaveableString");
		obj.put("String", string);
		return obj;
	}
	public void load(JSONObject saveData)
	{
		this.string = (String)saveData.get("String");
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (o instanceof SaveableString)
		{
			SaveableString s = (SaveableString) o;
			return string.equals(s.getString());
		}
		return false;
	}
	
}