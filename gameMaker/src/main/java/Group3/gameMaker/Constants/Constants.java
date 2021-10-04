package Group3.gameMaker.Constants;

import javafx.stage.Screen;

public class Constants {
	public static final double SCREEN_SCALE = (Screen.getPrimary().getDpi()/72); // This is because a 1920 screen width is registered as a 1440
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

	public static final int MODIFY_PANEL_WIDTH = (int)((VISUAL_WIDTH*SCREEN_SCALE*0.32) - WINDOW_PADDING); //25%
	public static final int MODIFY_PANEL_HEIGHT = (VISUAL_HEIGHT - WINDOW_PADDING*2);
	public static final int MODIFY_PANEL_X = WINDOW_PADDING + CREATE_PANEL_WIDTH + MAIN_WINDOW_WIDTH;
	public static final int MODIFY_PANEL_Y = WINDOW_SPACING;

	public static final int DEFAULT_CIRCLE_RADIUS = 50;
	public static final int MAIN_WINDOW_ORIGIN_OFFSET_X = 353;
	public static final int MAIN_WINDOW_ORIGIN_OFFSET_Y = 21;

	public static final int ANIMATION_START_X = 1200;
	public static final int ANIMATION_START_Y = 200;

	public static final int LAYABLE_BUTTON_WIDTH = 190;

	public final static int MENU_BUTTON_START_X = (CREATE_PANEL_WIDTH - LAYABLE_BUTTON_WIDTH) / 2;
	public final static int MENU_BUTTON_START_Y = 100;

	public static final int BUTTON_HEIGHT = 700;
	public static final int BUTTON_WIDTH = 800;

	public static final int LAYABLE_BUTTON_HEIGHT = 48;
	public static final int LAYABLE_BUTTON_HEIGHT_ON_PRESS = 44;
	public static final int LAYABLE_BUTTON_PADDING = 20;
	public static final int LAYABLE_BUTTON_MARGIN = 50;

	//MAC SPECIFIC - DO NOT MODIFY
	public static final int ADD_SPRITE_SUBSCENE_DEST_X = - CREATE_PANEL_WIDTH - LAYABLE_BUTTON_MARGIN*2 - WINDOW_SPACING - 5;
	public static final int ADD_SPRITE_SUBSCENE_DEST_Y = - 200;

	public static final int ADD_SPRITE_SUBSCENE_SOURCE_X = 500;
	public static final int ADD_SPRITE_SUBSCENE_SOURCE_Y = 600;
	public static final int ADD_SPRITE_SUBSCENE_HEIGHT = 275;
	public static final int ADD_SPRITE_SUBSCENE_WIDTH = CREATE_PANEL_WIDTH; //400
	public static final double LABEL_LEFT_PADDING = 60;
	public static final int LABEL_VERTICAL_PADDING = 50;
	public static final int LABEL_HEIGHT = 25;
}
