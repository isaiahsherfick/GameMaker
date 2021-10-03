package Group3.gameMaker.Sprite;

import org.json.simple.JSONObject;

import Group3.gameMaker.Exception.PathNotDefinedException;
import Group3.gameMaker.SaveAndLoad.Saveable;
import javafx.scene.media.Media;
import java.nio.file.Paths;
import javafx.scene.media.MediaPlayer;

public class Sound implements Saveable {

	String relativePath;
	String uri;

	/*
	 * This constructor accepts relative path and saves the uri as `uri`
	 */
	public Sound()
	{
		this.relativePath = "";
	}
	public Sound(String path) {
		this.relativePath = path;
		this.uri = Paths.get(relativePath).toUri().toString();
	}

	public Sound() {
		// TODO Auto-generated constructor stub
	}

	public String getUri() {
		return this.uri;
	}

	public void setUri(String path) {
		this.uri = path;
	}

	@SuppressWarnings("restriction")
	public void play() throws PathNotDefinedException {
		if(uri.isEmpty())
			throw new PathNotDefinedException();
		Media media = new Media(uri);
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject save() {
		JSONObject obj = new JSONObject();
		obj.put("type", "Sound");
		obj.put("relativePath", this.relativePath);

		return obj;
	}

	@Override
	public void load(JSONObject saveJSON) {
		relativePath = (String)saveJSON.get("relativePath");
		uri = Paths.get(relativePath).toUri().toString();
	}
}
