package Group3.gameMaker.Command;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Group3.gameMaker.SaveAndLoad.Saveable;
import Group3.gameMaker.SaveAndLoad.SaveableString;

public class CommandInvoker implements Saveable {

	private List<Command> currentCommandList;
	private Stack<Command> undoCommandList;
	private Stack<Command> redoCommandList;

	public CommandInvoker() {
		currentCommandList = new ArrayList<Command>();
		undoCommandList = new Stack<Command>();
		redoCommandList = new Stack<Command>();
	}

	public CommandInvoker(Stack<Command> undoCommandList, Stack<Command> redoCommandList) {
		this.undoCommandList = undoCommandList;
		this.redoCommandList = redoCommandList;
	}

	public void clearStacks() {
		undoCommandList.clear();
		undoCommandList = null;
		undoCommandList = new Stack<Command>();
		redoCommandList.clear();
		redoCommandList = null;
		redoCommandList = new Stack<Command>();
		currentCommandList = null;
		currentCommandList = new ArrayList<Command>();

	}

	public void receiveCommand(Command command) {
		currentCommandList.add(command);
	}

	/*
	 * Executes Commands in a queue
	 */
	public void executeCurrentTickCommands(boolean pushToUndo) {
		while(!currentCommandList.isEmpty()) {
			Command command = currentCommandList.remove(0);
			command.execute();
			if(pushToUndo) {
				undoCommandList.push(command);

			}
		}
	}

	public boolean undosAvailable() {
		return !undoCommandList.isEmpty();
	}

	public void undoCurrentCommands() {
		Command undoCommand = undoCommandList.pop();
		redoCommandList.push(undoCommand);
		undoCommand.undo();
	}

	public boolean redosAvailable() {
		return !redoCommandList.isEmpty();
	}

	public void redoCurrentTickCommands() {
		Command redoCommand = redoCommandList.pop();
		undoCommandList.push(redoCommand);
		redoCommand.redo();
	}



	public JSONObject save()
	{
		JSONObject obj = new JSONObject();
		obj.put("type", "CommandInvoker");
		obj.put("undoCommandList", undoCommandList);
		obj.put("redoCommandList", redoCommandList);
		obj.put("currentCommandList", currentCommandList);
		return obj;
	}

	@Override
	public void load(JSONObject saveJSON) {
		clearStacks();
//		saveJSON.get(")
	}


//	}
//	public void load(JSONObject saveData)
//	{
//		JSONArray undoCommandListJson = (JSONArray) saveData.get("undoCommandList");
//		for(int i=0; i<undoCommandListJson.size(); i++) {
//			Command command = new Command();
//			macroCommand.load(jsonElement.getAsJsonObject());
//			undoCommandList.add(macroCommand);
//		}
//
//		JsonArray redoCommandListJson = jsonObject.get("redoCommandList").getAsJsonArray();
//		for(JsonElement jsonElement: redoCommandListJson) {
//			MacroCommand macroCommand = new MacroCommand();
//			macroCommand.load(jsonElement.getAsJsonObject());
//			redoCommandList.add(macroCommand);
//		}
//		this.string = (String)saveData.get("String");
//	}

}