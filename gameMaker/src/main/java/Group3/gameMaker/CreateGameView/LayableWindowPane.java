package Group3.gameMaker.CreateGameView;

import java.util.ArrayList;

import Group3.gameMaker.CreateGameView.Location.LayoutType;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class LayableWindowPane extends Pane implements Layable {

	public ArrayList<Layable> layables = new ArrayList<Layable>();

	public LayableWindowPane() {
		super();
	}

	public void AddChild(Node whatIsNode) {
		getChildren().add(whatIsNode);
		addLayable((Layable) whatIsNode);
	}

	public void changeLayout(LayoutType layout, int parentX, int parentY, int index) {
		setLayoutX(Location.BottomLayout.controlPaneX);
		setLayoutY(Location.BottomLayout.controlPaneY);
		setMinWidth(Location.BottomLayout.controlPaneWidth);
		setMinHeight(Location.BottomLayout.controlPaneHeight);
		setWidth(Location.BottomLayout.controlPaneWidth);
		setHeight(Location.BottomLayout.controlPaneHeight);
		setMaxWidth(Location.BottomLayout.controlPaneWidth);
		setMaxHeight(Location.BottomLayout.controlPaneHeight);

		requestLayout();

		for (Layable lay : layables) {
			if ((layout == LayoutType.TOP || layout == LayoutType.BOTTOM) && index >= 6) {
				index = 0;
				parentX = 0;
				parentY = 75;
			}

			lay.changeLayout(layout, parentX, parentY, index);
			index++;
		}
		layoutChildren();
	}

	@Override
	public void addLayable(Layable layable) {
		layables.add(layable);
	}

	@Override
	public void removeLayable(Layable layable) {
		layables.remove(layable);
	}
}
