package Group3.gameMaker.Constants;

import javafx.stage.Screen;

public class Constants {
	public static final double SCREEN_SCALE = 1;//(Screen.getPrimary().getDpi()/72); // This is because a 1920 screen width is registered as a 1440
	public static final int VISUAL_HEIGHT = (int)Screen.getPrimary().getVisualBounds().getWidth();
	public static final int VISUAL_WIDTH = (int)Screen.getPrimary().getVisualBounds().getHeight();
	public static final int SCREEN_HEIGHT = (int)(Screen.getPrimary().getBounds().getWidth());
	public static final int SCREEN_WIDTH = (int)(Screen.getPrimary().getBounds().getHeight());

	public static final int WINDOW_SPACING = 20;
	public static final int WINDOW_PADDING = 30;

	public static final int CREATE_PANEL_WIDTH = (int)((VISUAL_WIDTH*SCREEN_SCALE*0.25) - WINDOW_PADDING); //25%
	public static final int CREATE_PANEL_HEIGHT = (VISUAL_HEIGHT - WINDOW_PADDING);
	public static final int CREATE_PANEL_X = WINDOW_PADDING;
	public static final int CREATE_PANEL_Y = WINDOW_PADDING;

	public static final int MAIN_WINDOW_WIDTH = (int)((VISUAL_WIDTH*SCREEN_SCALE*0.5) - WINDOW_PADDING); //50%
	public static final int MAIN_WINDOW_HEIGHT = (VISUAL_HEIGHT - WINDOW_PADDING);
	public static final int MAIN_WINDOW_X = WINDOW_SPACING + CREATE_PANEL_WIDTH;
	public static final int MAIN_WINDOW_Y = WINDOW_SPACING;

	public static final int MODIFY_PANEL_WIDTH = (int)((VISUAL_WIDTH*SCREEN_SCALE*0.25) - WINDOW_PADDING); //25%
	public static final int MODIFY_PANEL_HEIGHT = (VISUAL_HEIGHT - WINDOW_PADDING*2);
	public static final int MODIFY_PANEL_X = WINDOW_PADDING + CREATE_PANEL_WIDTH + MAIN_WINDOW_WIDTH;
	public static final int MODIFY_PANEL_Y = WINDOW_SPACING;


	public static final int ANIMATION_START_X = 1200;
	public static final int ANIMATION_START_Y = 200;


	public final static int MENU_BUTTON_START_X = 100;
	public final static int MENU_BUTTON_START_Y = 100;

	public static final int BUTTON_HEIGHT = 700;
	public static final int BUTTON_WIDTH = 800;

}