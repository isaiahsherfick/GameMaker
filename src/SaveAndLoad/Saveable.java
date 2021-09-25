//Saveable.java
//    Created by: Isaiah Sherfick
//    Created on: 22 Sep 2021
//     Edited by:
//Edited last by: Isaiah Sherfick
//   Last change: Created saveable interface

package SaveAndLoad;
import org.json.simple.JSONObject;

//Saveable interface
public interface Saveable
{
	//Saveable objects will neatly package themselves into a JSON
	public JSONObject save();

	//Default constructed objects will rebuild themselves with those JSONs
	public void load(JSONObject saveJSON);
}