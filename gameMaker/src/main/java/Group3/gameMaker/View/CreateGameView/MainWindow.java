package Group3.gameMaker.View.CreateGameView;

import java.util.ArrayList;

import Group3.gameMaker.Constants.Constants;
import Group3.gameMaker.Sprite.Sprite;
import Group3.gameMaker.View.View;
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

	private View createGameView;
    private Group root;
    private Scene scene;
    private GraphicsContext graphicsContext;
    private Sprite selectedSprite;
    
    private double orgSceneX,orgSceneY, offsetX, offsetY;
    
	// Accessible only within the CreateGameView package
	// This one needs a canvas
	public MainWindow(View createGameView, Stage appStage)
	{
		this.appStage = appStage;
		layables = new ArrayList<Layable>();

		appStage.setWidth(Constants.MAIN_WINDOW_WIDTH);
		appStage.setHeight(Constants.MAIN_WINDOW_HEIGHT);

		this.createGameView = createGameView;
		appStage.centerOnScreen();
		appStage.setX(Constants.MAIN_WINDOW_X);
		appStage.setY(Constants.MAIN_WINDOW_Y);
		canvas = new Canvas();

		root = new Group();
		scene = new Scene(root);
		appStage.setScene(scene);

		final Canvas canvas = new Canvas(Constants.MAIN_WINDOW_WIDTH,Constants.MAIN_WINDOW_HEIGHT);
		canvas.setOnMousePressed(onMousePressedEventHandler);
		canvas.setOnMouseDragged(onMouseDraggedEventHandler);
		canvas.setOnMouseReleased(onMouseReleaseHandler);
		graphicsContext = canvas.getGraphicsContext2D();

		graphicsContext.setFill(Color.GRAY);
		graphicsContext.fillRect(0, 0, Constants.MAIN_WINDOW_WIDTH, Constants.MAIN_WINDOW_HEIGHT);
		root.getChildren().add(canvas);
	}
	
	public GraphicsContext getGraphicsContext()
	{
		return graphicsContext;
	}
	
	public void clearCanvas()
	{
		graphicsContext.setFill(Color.GRAY);
		graphicsContext.fillRect(0, 0, Constants.MAIN_WINDOW_WIDTH, Constants.MAIN_WINDOW_HEIGHT);
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
		return canvas;
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





	EventHandler<MouseEvent> onMousePressedEventHandler = new EventHandler<MouseEvent>() 
	{

		public void handle(MouseEvent t) 
		{
			offsetX =0;
			offsetY = 0;
			selectedSprite = null;
			orgSceneX = t.getSceneX();
			orgSceneY = t.getSceneY();
			ArrayList<Sprite> allSprites = createGameView.getAllSprites();
			for(Sprite s: allSprites) 
			{
				if(s.contains((int)orgSceneX, (int)orgSceneY)) 
				{
					createGameView.setCurrentSpriteId(s.getSpriteId());
					selectedSprite = s.copy();
				}
			}
	    }
	};

	    EventHandler<MouseEvent> onMouseDraggedEventHandler = new EventHandler<MouseEvent>() 
	    {

	    	public void handle(MouseEvent t) {
	    		
	    		offsetX = t.getSceneX() - orgSceneX;
	    		offsetY = t.getSceneY() - orgSceneY;
				ArrayList<Sprite> allSprites = createGameView.getAllSprites();
	    		if (selectedSprite != null)
	    		{
	    			selectedSprite.draw(graphicsContext);
	    		}

		    }
		};
		
		EventHandler<MouseEvent> onMouseReleaseHandler = new EventHandler<MouseEvent>()
		{
			public void handle(MouseEvent t)
			{
				if (selectedSprite != null)
				{
					selectedSprite.setX((int)offsetX + selectedSprite.getX());
					selectedSprite.setY((int)offsetY + selectedSprite.getY());
					createGameView.modifySprite(selectedSprite);
				}
			}
	
		};

	public Stage getStage() {
		return appStage;
	}

}