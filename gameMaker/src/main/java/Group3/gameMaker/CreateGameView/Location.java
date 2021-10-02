
//    Created by: Snehal Patare
//    Created on: 22 Sep 2021
//     Edited by:
//Edited last by: Snehal Patare

package Group3.gameMaker.CreateGameView;

public class Location {
	public static enum LayoutType {
	    BOTTOM,
	    RIGHT,
	    TOP,
	    LEFT
	}
	public static class RightLayout {
		public static int rootPaneWidth = 900;
		public static int rootPaneHeight = 700;
		public static int gameCanvasWidth = 900;
		public static int gameCanvasHeight = 600;
		public static int gameCanvasX = 0;
		public static int gameCanvasY = 0;
		public static int controlPaneWidth = 500;
		public static int controlPaneHeight = 700;
		public static int controlPaneX = 900;
		public static int controlPaneY = 0;
		public static int actionPaneWidth = 500;
		public static int actionPaneHeight = 10;
		public static int actionPaneX = 100;
		public static int actionPaneY = 100;
	}
	
	public static class LeftLayout {
		public static int rootPaneWidth = 900;
		public static int rootPaneHeight = 700;
		public static int gameCanvasWidth = 900;
		public static int gameCanvasHeight = 600;
		public static int gameCanvasX = 900;
		public static int gameCanvasY = 0;
		public static int controlPaneWidth = 500;
		public static int controlPaneHeight = 700;
		public static int controlPaneX = 0;
		public static int controlPaneY = 0;
		public static int actionPaneWidth = 50;
		public static int actionPaneHeight = 10;
		public static int actionPaneX = 100;
		public static int actionPaneY = 100;

	}
	
	public static class TopLayout {
		public static int rootPaneWidth = 900;
		public static int rootPaneHeight = 800;
		public static int gameCanvasWidth = 900;
		public static int gameCanvasHeight = 600;
		public static int gameCanvasX = 0;
		public static int gameCanvasY = 174;
		public static int controlPaneWidth = 100;
		public static int controlPaneHeight = 500;
		public static int controlPaneX = 500;
		public static int controlPaneY = 0;
		public static int actionPaneWidth = 100;
		public static int actionPaneHeight = 0;
		public static int actionPaneX = 0;
		public static int actionPaneY = 0;
		
	}
	
	public static class BottomLayout {
		public static int rootPaneWidth = 900;
		public static int rootPaneHeight = 800;
		public static int gameCanvasWidth = 900;
		public static int gameCanvasHeight = 600;
		public static int gameCanvasX = 0;
		public static int gameCanvasY = 0;
		public static int controlPaneWidth = 900;
		public static int controlPaneHeight = 200;
		public static int controlPaneX = 0;
		public static int controlPaneY = 600;
		public static int actionPaneWidth = 100;
		public static int actionPaneHeight = 200;
		public static int actionPaneX = 0;
		public static int actionPaneY = 0;
	}

}
