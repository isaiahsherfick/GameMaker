package Group3.gameMaker.Sprite.Strategy.EventStrategy;

import java.util.ArrayList;
import java.util.LinkedList;

import org.json.simple.JSONObject;

import Group3.gameMaker.SaveAndLoad.Saveable;
import Group3.gameMaker.SaveAndLoad.StrategyLoader;
import Group3.gameMaker.Sprite.Sprite;

public class EventStrategyLinkedList implements Saveable
{
	private LinkedList<EventStrategy> list;

	public EventStrategyLinkedList()
	{
		list = new LinkedList<>();
		list.add(new DoNothingStrategy());
	}
	
	public void add(EventStrategy e)
	{
		list.add(e);
	}
	
	public void add(ArrayList<EventStrategy> es)
	{
		for (int i = 0; i < es.size(); i++)
		{
			list.add(es.get(i));
		}
	}
	
	public void remove(int index)
	{
		//Don't allow the DoNothingStrategy to be removed, as it marks the end of the list
		if (index == length()-1)
		{
			return;
		}
		list.remove(index);
	}
	
	public LinkedList<EventStrategy> getList()
	{
		return list;
	}
	
	public void setSubjectForAll(Sprite subject)
	{
		for (int i  = 0; i < list.size(); i++)
		{
			list.get(i).setSubject(subject);
		}
	}
	
	public int length()
	{
		return list.size();
	}

	@SuppressWarnings("unchecked")
	public JSONObject save() 
	{
		JSONObject obj = new JSONObject();
		obj.put("type","EventStrategyLinkedList");
		obj.put("length",length());
		for (int i = 0; i < length(); i++)
		{
			obj.put(i, list.get(i).save());
		}
		
		return obj;
	}

	public void load(JSONObject saveJSON) 
	{
		list.clear();
		int length = ((Long)saveJSON.get("length")).intValue();
		StrategyLoader sl = new StrategyLoader();
		for (Integer i = 0; i < length; i++)
		{
			list.add((EventStrategy)(sl.load((JSONObject)saveJSON.get(i.toString()))));
		}
	}
}
