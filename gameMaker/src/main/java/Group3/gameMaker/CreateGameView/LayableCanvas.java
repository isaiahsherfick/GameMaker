/**
 * @author: Snehal Patare
 * @CreationDate: Sep 29, 2021
 * @editors:
 **/
package Group3.gameMaker.CreateGameView;


import Group3.gameMaker.CreateGameView.Location;
import Group3.gameMaker.CreateGameView.Location.LayoutType;
import javafx.scene.canvas.Canvas;

public class LayableCanvas extends Canvas implements Layable {

	public LayableCanvas(int width, int height) {
		super(width, height);
	}

	@Override
	public void changeLayout(LayoutType layout, int parentX, int parentY, int index) {
		switch (layout) {
		case LEFT:
			setLayoutX(Location.LeftLayout.gameCanvasX);
			setLayoutY(Location.LeftLayout.gameCanvasY);
			break;
		case RIGHT:
			setLayoutX(Location.RightLayout.gameCanvasX);
			setLayoutY(Location.RightLayout.gameCanvasY);
			break;
		case TOP:
			setLayoutX(Location.TopLayout.gameCanvasX);
			setLayoutY(Location.TopLayout.gameCanvasY);
			break;
		case BOTTOM:
			setLayoutX(Location.BottomLayout.gameCanvasX);
			setLayoutY(Location.BottomLayout.gameCanvasY);
			break;
		}
	}

	@Override
	public void addLayable(Layable layable) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeLayable(Layable layable) {
		// TODO Auto-generated method stub

	}


}
