package Group3.gameMaker.View.CreateGameView;

import java.util.ArrayList;

import Group3.gameMaker.View.CreateGameView.Location.LayoutType;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import Group3.gameMaker.Constants.*;

public class ModifyPanelWindow implements Layable {

	private Stage panelStage;
	private ArrayList<Layable> layables;

	// Accessible only within the CreateGameView package
	ModifyPanelWindow(Stage panelStage) {
		this.panelStage = panelStage;
		layables = new ArrayList<Layable>();
		panelStage.setWidth(Constants.MODIFY_PANEL_WIDTH);
		panelStage.setHeight(Constants.MODIFY_PANEL_HEIGHT);
		panelStage.setX(Constants.MODIFY_PANEL_X);
		panelStage.setY(Constants.MODIFY_PANEL_Y);
	}


	public void makeStage () {
		// Build root group and root pane
				//BorderPane rootGroup = new BorderPane();
//				menuButtons = new ArrayList<>();
//				rootGroup = new Group();
//				rootPane = new Pane();
//				Pane rootPane = new Pane();
//				//Canvas gameCanvas = new Canvas();
//
//				rootPane.setPrefSize(Location.LeftLayout.rootPaneWidth, Location.LeftLayout.rootPaneHeight);
//				rootPane.setStyle("-fx-background-color: #FF00FF");
//				rootGroup.getChildren().add(rootPane);
//
//
////				gameCanvas = new LayableCanvas(Location.LeftLayout.gameCanvasWidth, Location.LeftLayout.gameCanvasHeight);
////				layables.add(gameCanvas);
////				rootGroup.getChildren().add(gameCanvas);
////				gameCanvas.setLayoutX(Location.LeftLayout.gameCanvasX);
////				gameCanvas.setStyle("-fx-background-color: #FF00FF");
//
//				//rootGroup.getChildren().add(rootPane);
//
//
//				controlPane = new LayablePane();
//				layables.add(controlPane);
//				controlPane.setPrefSize(Location.LeftLayout.controlPaneWidth, Location.LeftLayout.controlPaneHeight);
//				rootGroup.getChildren().add(controlPane);
//				controlPane.setLayoutX(Location.TopLayout.controlPaneX);
//				controlPane.setStyle("-fx-background-color: #000000");
//
//				gameScene = new Scene(rootGroup);
//				// Not sure if this is right...
//				appStage.setScene(gameScene);
	}

	@Override
	public void changeLayout(LayoutType currentLayout, int parentX, int parentY, int index) {


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