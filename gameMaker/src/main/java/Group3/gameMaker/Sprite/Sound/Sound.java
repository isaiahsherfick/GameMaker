package Group3.gameMaker.Sprite.Sound;

import org.json.simple.JSONObject;

import Group3.gameMaker.Exception.PathNotDefinedException;
import Group3.gameMaker.SaveAndLoad.Saveable;
import Group3.gameMaker.Sprite.Point;
import javafx.scene.media.Media;
import java.nio.file.Paths;
import javafx.scene.media.MediaPlayer;

public class Sound implements Saveable {

	String relativePath;
	String uri;

	/*
	 * This constructor accepts relative path and saves the uri as `uri`
	 */
	public Sound(String path) {
		this.relativePath = path;
		this.uri = Paths.get(relativePath).toUri().toString();
	}

	public String getUri() {
		return this.uri;
	}

	public void setUri(String path) {
		this.uri = path;
	}

	public void play() throws PathNotDefinedException {
		if(uri.isEmpty())
			throw new PathNotDefinedException();
		Media media = new Media(uri);
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);
	}

	@Override
	public JSONObject save() {
		JSONObject obj = new JSONObject();
		obj.put("type", "Sound");
		obj.put("uri", this.uri);
		obj.put("relativePath", this.relativePath);

		return obj;
	}

	@Override
	public void load(JSONObject saveJSON) {
		uri = new String();
		uri = (String)saveJSON.get("uri");
		relativePath = new String();
		relativePath = (String)saveJSON.get("relativePath");
	}
}
