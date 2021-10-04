package Group3.gameMaker.View.CreateGameView;

import java.util.ArrayList;

import Group3.gameMaker.Constants.Constants;
import Group3.gameMaker.Sprite.Sprite;
import Group3.gameMaker.View.CreateGameView.Location.LayoutType;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MainWindow implements Layable{

	private Stage appStage;
	private ArrayList<Layable> layables;
	private Canvas canvas;

	private LayableCanvas gameCanvas;

	private CreateGameView createGameView;
    private Group root;
    private GraphicsContext graphics;

	// Accessible only within the CreateGameView package
	// This one needs a canvas
	MainWindow(CreateGameView createGameView, Stage appStage)
	{
		this.appStage = appStage;
		layables = new ArrayList<Layable>();

		appStage.setWidth(Constants.MAIN_WINDOW_WIDTH);
		appStage.setHeight(Constants.MAIN_WINDOW_HEIGHT);

		this.createGameView = createGameView;
		appStage.centerOnScreen();
		canvas = new Canvas();

		Group root = new Group();
		Scene s = new Scene(root);
		appStage.setScene(s);

		final Canvas canvas = new Canvas(250,250);
		canvas.setOnMousePressed(onMousePressedEventHandler);
		GraphicsContext gc = canvas.getGraphicsContext2D();

		gc.setFill(Color.BLUE);
		gc.fillRect(0, 0, 250, 250);
		root.getChildren().add(canvas);
	}



	public void makeStage () {
		// Build root group and root pane
				//BorderPane rootGroup = new BorderPane();
//				menuButtons = new ArrayList<>();
		Group rootGroup = new Group();
//		Pane controlPane = new Pane();
//				Pane rootPane = new Pane();
//		Canvas gameCanvas = new Canvas();
//
//				rootPane.setPrefSize(Location.LeftLayout.rootPaneWidth, Location.LeftLayout.rootPaneHeight);
//				rootPane.setStyle("-fx-background-color: #FF00FF");
//				rootGroup.getChildren().add(rootPane);
//

		gameCanvas = new LayableCanvas(Constants.MAIN_WINDOW_WIDTH, Constants.MAIN_WINDOW_HEIGHT);
		gameCanvas.setOnMousePressed(onMousePressedEventHandler);
//		gameCanvas.setOnMouseDragged(OnMouseDraggedEventHandler);
		layables.add(gameCanvas);
		System.out.println(gameCanvas.getBoundsInLocal());
		System.out.println(gameCanvas.getBoundsInParent());
		System.out.println(gameCanvas.getBaselineOffset());

		rootGroup.getChildren().add(gameCanvas);
		gameCanvas.setLayoutX(Constants.MAIN_WINDOW_X);
		gameCanvas.setLayoutY(Constants.MAIN_WINDOW_Y);
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
		Scene gameScene = new Scene(rootGroup);
//				// Not sure if this is right...
		appStage.setScene(gameScene);
	}


	public Canvas getCanvas() {
		return gameCanvas;
	}

	@Override
	public void changeLayout(LayoutType currentLayout, int parentX, int parentY, int index) {
		for (Layable lay : layables) {
			lay.changeLayout(currentLayout, parentX, parentY, index);
			index++;
		}
	}

	@Override
	public void addLayable(Layable layable) {
		layables.add(layable);
	}

	@Override
	public void removeLayable(Layable layable) {
		layables.remove(layable);
	}





	EventHandler<MouseEvent> onMousePressedEventHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent t) {
			double orgSceneX = t.getSceneX();
			double orgSceneY = t.getSceneY();
//    		double offsetX = t.getSceneX() - orgSceneX;
//    		double offsetY = t.getSceneY() - orgSceneY;
			System.out.println("x: "+(int)orgSceneX+ " y: "+(int)orgSceneY);
			ArrayList<Sprite> allSprites = createGameView.getAllSprites();
			for(Sprite s: allSprites) {
				if(s.contains((int)orgSceneX - Constants.MAIN_WINDOW_ORIGIN_OFFSET_X, (int)orgSceneY - Constants.MAIN_WINDOW_ORIGIN_OFFSET_Y)) {
					createGameView.setCurrentSpriteId(s.getSpriteId());
					System.out.println(s.getSpriteId());
				}
				System.out.println(s.getX()+"    "+s.getY());
			}


//			orgTranslateX = ((Node)(t.getSource())).getTranslateX();
//			orgTranslateY = ((Node)(t.getSource())).getTranslateY();



	        }
	    };

	    EventHandler<MouseEvent> onMouseDraggedEventHandler = new EventHandler<MouseEvent>() {

	    	@Override
	    	public void handle(MouseEvent t) {
//	    		double offsetX = t.getSceneX() - orgSceneX;
//	    		double offsetY = t.getSceneY() - orgSceneY;
//






//	    		double newTranslateX = orgTranslateX + offsetX;
//	    		double newTranslateY = orgTranslateY + offsetY;
//	    		System.out.println(offsetX+ " "+offsetY);
//				ArrayList<Sprite> allSprites = createGameView.getAllSprites();
//				Sprite s_out = null;
//	    		for(Sprite s: allSprites) {
//					if(s.contains((int)orgSceneX - Constants.MAIN_WINDOW_ORIGIN_OFFSET_X, (int)orgSceneY - Constants.MAIN_WINDOW_ORIGIN_OFFSET_Y)) {
//						createGameView.setCurrentSpriteId(s.getSpriteId());
//						s_out = s.copy();
//						System.out.println(s.getSpriteId());
//					}
//				}
//
//	    		if (s_out != null)
//	    		{
//					s_out.setX((int)orgSceneX - Constants.MAIN_WINDOW_ORIGIN_OFFSET_X);
//					s_out.setY((int)orgSceneY - Constants.MAIN_WINDOW_ORIGIN_OFFSET_Y);
//					createGameView.modifySprite(s_out);
//					s_out = null;
//	    		}
//	    		((Node)(t.getSource())).setTranslateX(newTranslateX);
//	    		((Node)(t.getSource())).setTranslateY(newTranslateY);

		    }
		};

}