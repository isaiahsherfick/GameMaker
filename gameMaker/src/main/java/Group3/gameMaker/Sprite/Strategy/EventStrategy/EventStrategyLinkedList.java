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

	private EventStrategyLinkedList(LinkedList<EventStrategy> newList)
	{
		list = newList;
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

	public EventStrategyLinkedList copy() 
	{
		LinkedList<EventStrategy> newList = new LinkedList<>();
		for (int i  = 0 ; i  < list.size(); i++)
		{
			newList.add(list.get(i));
		}
		return new EventStrategyLinkedList(newList);
	}

	//This overwrites all of the different velocities
	//that may be present in a particularly complex object's EventStrategyLinkedList
	//but we don't have time to fix that right now
	//Just a heads up in case you inherit this code and have that issue
	public void setVelocityX(int v) 
	{
		for (int i  = 0 ; i  < list.size(); i++)
		{
			list.get(i).setVelocityX(v);
		}
	}

	//This overwrites all of the different velocities
	//that may be present in a particularly complex object's EventStrategyLinkedList
	//but we don't have time to fix that right now
	//Just a heads up in case you inherit this code and have that issue
	public void setVelocityY(int v) 
	{
		for (int i  = 0 ; i  < list.size(); i++)
		{
			list.get(i).setVelocityY(v);
		}
	}

	//Gets the largest velocity in the EventStrategyLinkedList in terms of absolute value
	public int getVelocityY() 
	{
		int largestSpeed = 0;
		boolean isNegative = false;
		for (int i = 0; i < list.size(); i++)
		{
			if (Math.abs(list.get(i).getVelocityY()) > largestSpeed)
			{
				isNegative = (list.get(i).getVelocityY() < 0);
				largestSpeed = Math.abs(list.get(i).getVelocityY());
			}
		}
		if (isNegative)
			return largestSpeed * -1;
		return largestSpeed;
	}

	//Gets the largest velocity in the EventStrategyLinkedList in terms of absolute value
	public int getVelocityX() 
	{
		int largestSpeed = 0;
		boolean isNegative = false;
		for (int i = 0; i < list.size(); i++)
		{
			if (Math.abs(list.get(i).getVelocityX()) > largestSpeed)
			{
				isNegative = (list.get(i).getVelocityX() < 0);
				largestSpeed = Math.abs(list.get(i).getVelocityX());
			}
		}
		if (isNegative)
			return largestSpeed * -1;
		return largestSpeed;
	}

	public void onClockTick() 
	{
		for ( EventStrategy e : list)
		{
			e.onClockTick();
		}
	}
}
