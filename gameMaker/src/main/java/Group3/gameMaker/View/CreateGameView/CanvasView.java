package Group3.gameMaker.View.CreateGameView;


import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.Tooltip;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class CanvasView {
	
	public Stage stage;
	 double a = 6, a2 = a / 2;
	  double gridSize = -1;
	  double lastX, lastY;
	  double lX, lY, sX, sY, sWidth, sHeight;
	  Slider slider1, slider2;
	  CheckBox checkBox;
	  ScrollPane scrollPane;
	  Group group, overlay = null;
	  Pane zoomPane;
	  Rectangle srBnd, srNW, srN, srNE, srE, srSE, srS, srSW, srW;
	  Element selectedElement;
	  Rectangle2D area = new Rectangle2D(0, 0, 1000, 1000);
	  Paint bg1 = Paint.valueOf("linear-gradient(from 0.0% 0.0% to 0.0% 100.0%, 0x90c1eaff 0.0%, 0x5084b0ff 100.0%)");
	  BackgroundFill backgroundFill1 = new BackgroundFill(bg1, null, null);
	  Canvas canvas = new Canvas();
	  SnapshotParameters sp = new SnapshotParameters();
	  
	
public void canvasStage() {
	
	 BorderPane layout = new BorderPane();
	    stage.setScene(new Scene(layout, 500, 300));
	    group = new Group(createElement(150, 30, 105, 105, Color.AQUA), createElement(45, 30, 45, 105, Color.VIOLET),
	      createElement(45, 180, 45, 45, Color.TAN), createElement(150, 180, 105, 45, Color.LIME));
	    zoomPane = new Pane(group);
	    zoomPane.setOnMousePressed(me->select(null));
	    Scale scale = new Scale();
	    group.getTransforms().add(scale);
	    slider1 = new Slider(.1, 5, 1);
	    slider1.setMinWidth(150);
	    slider1.setMaxWidth(150);
	    slider1.setPadding(new Insets(6));
	    slider1.setTooltip(new Tooltip("Zoom"));
	    slider1.valueProperty().addListener((v, o, n) -> {
	      scale.setX(n.doubleValue());
	      scale.setY(n.doubleValue());
	      updateGrid();
	      updateZoomPane();
	      updateOverlay();
	    });
	    slider2 = new Slider(5, 35, 15);
	    slider2.setMinWidth(150);
	    slider2.setMaxWidth(150);
	    slider2.setPadding(new Insets(6));
	    slider2.setTooltip(new Tooltip("Grid size"));
	    slider2.valueProperty().addListener((v, o, n) -> {
	      updateGrid();
	    });
	    checkBox = new CheckBox();
	    checkBox.setPadding(new Insets(6));
	    checkBox.setTooltip(new Tooltip("Show grid"));
	    checkBox.selectedProperty().addListener((v, o, n) -> {
	      slider2.setDisable(!n.booleanValue());
	      updateGrid();
	    });
	    checkBox.setSelected(true);
	    scrollPane = new ScrollPane(new Group(zoomPane));
	    scrollPane.viewportBoundsProperty().addListener((v, o, n) -> {
	      updateZoomPane();
	      Platform.runLater(() -> zoomPane.requestLayout());
	    });
	    layout.setCenter(scrollPane);
	    layout.setBottom(new FlowPane(slider1, checkBox, slider2));
	    //stage.setOnCloseRequest(e -> System.out.println(group.getChildren().toString()));
	    stage.show();
	
}


Element createElement(double x, double y, double width, double height, Paint fill) {
    Element element = new Element(x, y, width, height, fill);
    element.setOnMousePressed(me -> {
      select(element);
      srBnd.fireEvent(me);
      me.consume();
    });
    element.setOnMouseDragged(me -> srBnd.fireEvent(me));
    element.setOnMouseReleased(me -> srBnd.fireEvent(me));
    element.boundsInParentProperty().addListener((v, o, n) -> updateOverlay());
    return element;
  }

class Element extends Group {

    Rectangle rectangle = new Rectangle();
    DoubleProperty widthProperty = new SimpleDoubleProperty();
    DoubleProperty heightProperty = new SimpleDoubleProperty();

    Element(double x, double y, double width, double height, Paint fill) {
      widthProperty.addListener((v, o, n) -> { rectangle.setWidth(n.doubleValue()); });
      heightProperty.addListener((v, o, n) -> { rectangle.setHeight(n.doubleValue()); });
      setLayoutX(x);
      setLayoutY(y);
      widthProperty.set(width);
      heightProperty.set(height);
      rectangle.setFill(fill);
      getChildren().add(rectangle);
      //setPickOnBounds(true);
    }
    DoubleProperty widthProperty() { return widthProperty; }
    DoubleProperty heightProperty() { return heightProperty; }
    @Override public String toString() { return "[" + getLayoutX() + ", " + getLayoutY() + ", " + widthProperty.get() + ", " + heightProperty.get() + "]"; }
  }


void select(Element element) {
    if (overlay == null && element != null) iniOverlay();
    if (element != selectedElement) {
      overlay.setVisible(element != null);
      if (element != null) element.toFront();
      selectedElement = element;
      updateOverlay();
    }
  }

void iniOverlay() {
    overlay = new Group();
    //overlay.setVisible(false);
    srBnd = new Rectangle();
    srBnd.setStroke(Color.BLACK);
    srBnd.setStrokeType(StrokeType.INSIDE);
    srBnd.setStrokeWidth(1);
    srBnd.getStrokeDashArray().addAll(2d, 4d);
    srBnd.setFill(Color.TRANSPARENT);
    handleMouse(srBnd);
    srNW = srCreate(Cursor.NW_RESIZE);
    srN = srCreate(Cursor.N_RESIZE);
    srNE = srCreate(Cursor.NE_RESIZE);
    srE = srCreate(Cursor.E_RESIZE);
    srSE = srCreate(Cursor.SE_RESIZE);
    srS = srCreate(Cursor.S_RESIZE);
    srSW = srCreate(Cursor.SW_RESIZE);
    srW = srCreate(Cursor.W_RESIZE);
    overlay.getChildren().addAll(srBnd, srNW, srN, srNE, srE, srSE, srS, srSW, srW);
    zoomPane.getChildren().add(overlay);
  }

void updateGrid() {
    double size = slider1.getValue() * slider2.getValue();
    if (!checkBox.isSelected() || size < 4) size = 0;
    if (gridSize != size) {
      if (size <= 0) {
        zoomPane.setBackground(new Background(backgroundFill1));
      } else {
        Paint bg2 = patternTransparent(size);
        BackgroundFill backgroundFill2 = new BackgroundFill(bg2, null, null);
        zoomPane.setBackground(new Background(backgroundFill1, backgroundFill2));
      }
      gridSize = size;
    }
  }
void updateZoomPane() {
    zoomPane.setPrefWidth(Math.max(scrollPane.getViewportBounds().getWidth(), group.getBoundsInParent().getMaxX()));
    zoomPane.setPrefHeight(Math.max(scrollPane.getViewportBounds().getHeight(), group.getBoundsInParent().getMaxY()));
  }
ImagePattern patternTransparent(double size) {
    canvas.setHeight(size);
    canvas.setWidth(size);
    GraphicsContext gc = canvas.getGraphicsContext2D();
    gc.clearRect(0, 0, size, size);
    gc.setFill(Color.BLACK);
    //gc.setLineWidth(2);
    gc.strokeLine(0, 0, 0, size);
    gc.strokeLine(1, 0, size, 0);
    sp.setFill(Color.TRANSPARENT);
    WritableImage image = canvas.snapshot(sp, null);
    return new ImagePattern(image, 0, 0, size, size, false);
  }
void updateOverlay() {
    if (selectedElement != null) {
      double zoom = slider1.getValue();
      srBnd.setX(selectedElement.getLayoutX() * zoom);
      srBnd.setY(selectedElement.getLayoutY() * zoom);
      srBnd.setWidth(selectedElement.widthProperty().get() * zoom);
      srBnd.setHeight(selectedElement.heightProperty().get() * zoom);
      srNW.setX(selectedElement.getLayoutX() * zoom);
      srNW.setY(selectedElement.getLayoutY() * zoom);
      srN.setX((selectedElement.getLayoutX() + selectedElement.widthProperty().get() / 2) * zoom - a2);
      srN.setY(selectedElement.getLayoutY() * zoom);
      srNE.setX((selectedElement.getLayoutX() + selectedElement.widthProperty().get()) * zoom - a);
      srNE.setY(selectedElement.getLayoutY() * zoom);
      srE.setX((selectedElement.getLayoutX() + selectedElement.widthProperty().get()) * zoom - a);
      srE.setY((selectedElement.getLayoutY() + selectedElement.heightProperty().get() / 2) * zoom - a2);
      srSE.setX((selectedElement.getLayoutX() + selectedElement.widthProperty().get()) * zoom - a);
      srSE.setY((selectedElement.getLayoutY() + selectedElement.heightProperty().get()) * zoom - a);
      srS.setX((selectedElement.getLayoutX() + selectedElement.widthProperty().get() / 2) * zoom - a2);
      srS.setY((selectedElement.getLayoutY() + selectedElement.heightProperty().get()) * zoom - a);
      srSW.setX(selectedElement.getLayoutX() * zoom);
      srSW.setY((selectedElement.getLayoutY() + selectedElement.heightProperty().get()) * zoom - a);
      srW.setX(selectedElement.getLayoutX() * zoom);
      srW.setY((selectedElement.getLayoutY() + selectedElement.heightProperty().get() / 2) * zoom - a2);
    }
  }


Rectangle srCreate(Cursor cursor) {
    Rectangle rectangle = new Rectangle(a, a, Color.BLACK);
    rectangle.setCursor(cursor);
    handleMouse(rectangle);
    return rectangle;
  }

  void handleMouse(Node node) {
    node.setOnMousePressed(me -> {
      lX = me.getX();
      lY = me.getY();
      sX = selectedElement.getLayoutX();
      sY = selectedElement.getLayoutY();
      sWidth = selectedElement.widthProperty().get();
      sHeight = selectedElement.heightProperty().get();
      me.consume();
    });
    node.setOnMouseDragged(me -> {
      double zoom = slider1.getValue();
      double dx = (me.getX() - lX) / zoom;
      double dy = (me.getY() - lY) / zoom;
      Object source = me.getSource();
      if (source == srBnd) relocate(sX + dx, sY + dy);
      else if (source == srNW) { setHSize(sX + dx, true); setVSize(sY + dy, true); }
      else if (source == srN) setVSize(sY + dy, true);
      else if (source == srNE) { setHSize(sX + sWidth + dx, false); setVSize(sY + dy, true); }
      else if (source == srE) setHSize(sX + sWidth + dx, false);
      else if (source == srSE) { setHSize(sX + sWidth + dx, false); setVSize(sY + sHeight + dy, false); }
      else if (source == srS) setVSize(sY + sHeight + dy, false);
      else if (source == srSW) { setHSize(sX + dx, true); setVSize(sY + sHeight + dy, false); }
      else if (source == srW) setHSize(sX + dx, true);
      updateZoomPane();
      me.consume();
    });
    node.setOnMouseReleased(me -> { //snap to grid
      if (checkBox.isSelected() && slider2.getValue() > 0) {
        Object source = me.getSource();
        if (source == srBnd) relocate(snap(selectedElement.getLayoutX()), snap(selectedElement.getLayoutY()));
        else {
          if (source == srNW || source == srN || source == srNE) setVSize(snap(selectedElement.getLayoutY()), true);
          else if (source == srSW || source == srS || source == srSE) setVSize(snap(selectedElement.getLayoutY() + selectedElement.heightProperty().get()), false);
          if (source == srNW || source == srW || source == srSW) setHSize(snap(selectedElement.getLayoutX()), true);
          else if (source == srNE || source == srE || source == srSE) setHSize(snap(selectedElement.getLayoutX() + selectedElement.widthProperty().get()), false);
        }
        updateZoomPane();
      }
      me.consume();
    });
  }

  double snap(double value) {
    double gridSize = slider2.getValue();
    return Math.round(value / gridSize) * gridSize;
  }

  void setHSize(double h, boolean b) {
    double x = selectedElement.getLayoutX(), w = selectedElement.widthProperty().get(), width;
    double as = (a * 3) / slider1.getValue();
    if (h < area.getMinX()) h = area.getMinX();
    if (h > area.getMaxX()) h = area.getMaxX();
    if (b) {
      width = w + x - h;
      if (width < as) { width = as; h = x + w - as; }
      selectedElement.setLayoutX(h);
    } else {
      width = h - x;
      if (width < as) width = as;
    }
    selectedElement.widthProperty().set(width);
  }

  void setVSize(double v, boolean b) {
    double y = selectedElement.getLayoutY(), h = selectedElement.heightProperty().get(), height;
    double as = (a * 3) / slider1.getValue();
    if (v < area.getMinY()) v = area.getMinY();
    if (v > area.getMaxY()) v = area.getMaxY();
    if (b) {
      height = h + y - v;
      if (height < as) { height = as; v = y + h - as; }
      selectedElement.setLayoutY(v);
    } else {
      height = v - y;
      if (height < as) height = as;
    }
    selectedElement.heightProperty().set(height);
  }

  void relocate(double x, double y) {
    double maxX = area.getMaxX() - selectedElement.widthProperty().get();
    double maxY = area.getMaxY() - selectedElement.heightProperty().get();
    if (x < area.getMinX()) x = area.getMinX();
    if (y < area.getMinY()) y = area.getMinY();
    if (x > maxX) x = maxX;
    if (y > maxY) y = maxY;
    selectedElement.setLayoutX(x);
    selectedElement.setLayoutY(y);
  }
  

}
