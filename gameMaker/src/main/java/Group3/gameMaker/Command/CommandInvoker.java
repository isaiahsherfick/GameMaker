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
	private Stack<Command> undoableCommands;
	private Stack<Command> redoableCommands;

	public CommandInvoker() 
	{
		commands = new Stack<Command>();
		undoableCommands = new Stack<Command>();
		redoableCommands = new Stack<Command>();
	}

	public void clearStacks() 
	{
		commands.clear();
		undoableCommands.clear();
	}

	public void receiveCommand(Command command) 
	{
		commands.add(command);
		command.execute();
	}
	
	public void undoCommand()
	{
		if (!undoableCommands.isEmpty())
		{
			Command c = undoableCommands.pop();
			c.unexecute();

		}
	}

	public void redoCommand() 
	{
		if (!redoableCommands.isEmpty())
		{
			redoableCommands.pop().execute();
		}
	}
}