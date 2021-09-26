package Group3.gameMaker.Command;

import org.json.simple.JSONObject;

import Group3.gameMaker.SaveAndLoad.Saveable;
import Group3.gameMaker.SaveAndLoad.SaveableString;

public abstract class Command implements Saveable {

	public void execute() {
		throw new UnsupportedOperationException();
	}

	public void undo() {
		throw new UnsupportedOperationException();
	}

	public void redo() {
		throw new UnsupportedOperationException();
	}
}
