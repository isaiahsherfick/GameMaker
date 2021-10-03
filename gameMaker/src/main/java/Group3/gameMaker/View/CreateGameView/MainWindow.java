package Group3.gameMaker.View.CreateGameView;

import java.util.ArrayList;

import Group3.gameMaker.Constants.Constants;
import Group3.gameMaker.View.CreateGameView.Location.LayoutType;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MainWindow implements Layable{

	private Stage appStage;
	private ArrayList<Layable> layables;

	// Accessible only within the CreateGameView package
	// This one needs a canvas
	MainWindow(Stage appStage) {
		this.appStage = appStage;
		layables = new ArrayList<Layable>();
		appStage.setWidth(Constants.MAIN_WINDOW_WIDTH);
		appStage.setHeight(Constants.MAIN_WINDOW_HEIGHT);
//		appStage.setX(Constants.MAIN_WINDOW_X);
//		appStage.setY(Constants.MAIN_WINDOW_Y);
		appStage.centerOnScreen();

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