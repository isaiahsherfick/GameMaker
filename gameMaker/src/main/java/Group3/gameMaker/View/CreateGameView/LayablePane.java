
//    Created by: Snehal Patare
//    Created on: 25 Sep 2021
//     Edited by:
//Edited last by: Snehal Patare
package Group3.gameMaker.View.CreateGameView;

import java.util.ArrayList;

import Group3.gameMaker.View.CreateGameView.Location.LayoutType;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class LayablePane extends Pane implements Layable {

	public ArrayList<Layable> layables = new ArrayList<Layable>();

	public LayablePane() {
		super();
	}

	public void AddChild(Node whatIsNode) {
		getChildren().add(whatIsNode);
		addLayable((Layable) whatIsNode);
	}

	public void changeLayout(LayoutType layout, int parentX, int parentY, int index) {
		switch (layout) {
		case LEFT:
			setLayoutX(Location.LeftLayout.controlPaneX);
			setLayoutY(Location.LeftLayout.controlPaneY);
			setMinWidth(Location.LeftLayout.controlPaneWidth);
			setMinHeight(Location.LeftLayout.controlPaneHeight);
			setWidth(Location.LeftLayout.controlPaneWidth);
			setHeight(Location.LeftLayout.controlPaneHeight);
			setMaxWidth(Location.LeftLayout.controlPaneWidth);
			setMaxHeight(Location.LeftLayout.controlPaneHeight);
			break;
		case RIGHT:
			setLayoutX(Location.RightLayout.controlPaneX);
			setLayoutY(Location.RightLayout.controlPaneY);
			setMinWidth(Location.RightLayout.controlPaneWidth);
			setMinHeight(Location.RightLayout.controlPaneHeight);
			setWidth(Location.RightLayout.controlPaneWidth);
			setHeight(Location.RightLayout.controlPaneHeight);
			setMaxWidth(Location.RightLayout.controlPaneWidth);
			setMaxHeight(Location.RightLayout.controlPaneHeight);
			break;
		case TOP:
			setLayoutX(Location.TopLayout.controlPaneX);
			setLayoutY(Location.TopLayout.controlPaneY);
			setMinWidth(Location.TopLayout.controlPaneWidth);
			setMinHeight(Location.TopLayout.controlPaneHeight);
			setWidth(Location.TopLayout.controlPaneWidth);
			setHeight(Location.TopLayout.controlPaneHeight);
			setMaxWidth(Location.TopLayout.controlPaneWidth);
			setMaxHeight(Location.TopLayout.controlPaneHeight);
			break;
		case BOTTOM:
			setLayoutX(Location.BottomLayout.controlPaneX);
			setLayoutY(Location.BottomLayout.controlPaneY);
			setMinWidth(Location.BottomLayout.controlPaneWidth);
			setMinHeight(Location.BottomLayout.controlPaneHeight);
			setWidth(Location.BottomLayout.controlPaneWidth);
			setHeight(Location.BottomLayout.controlPaneHeight);
			setMaxWidth(Location.BottomLayout.controlPaneWidth);
			setMaxHeight(Location.BottomLayout.controlPaneHeight);
			break;
		}

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
