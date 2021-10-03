package Group3.gameMaker.Command;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Group3.gameMaker.SaveAndLoad.Saveable;
import Group3.gameMaker.SaveAndLoad.SaveableString;

public class CommandInvoker
{
	private Stack<Command> commands;
	private Stack<Command> undoneCommands;

	public CommandInvoker() 
	{
		commands = new Stack<Command>();
		undoneCommands = new Stack<Command>();
	}

	public void clearStacks() 
	{
		commands.clear();
		undoneCommands.clear();
	}

	public void receiveCommand(Command command) 
	{
		commands.add(command);
		command.execute();
	}
	
	public void undo()
	{
		if (!commands.isEmpty())
		{
			Command c = commands.pop();
			c.unexecute();
			undoneCommands.add(c);
		}
	}

	public void redo() 
	{
		if (!undoneCommands.isEmpty())
		{
			Command c = undoneCommands.pop();
			c.execute();
			commands.add(c);
		}
	}
}