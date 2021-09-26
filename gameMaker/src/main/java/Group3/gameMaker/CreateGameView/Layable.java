//Layable.java
//    Created by: Snehal Patare
//    Created on: 22 Sep 2021
//     Edited by:
//Edited last by: Snehal Patare


package Group3.gameMaker.CreateGameView;

import src.composite.pattern.LayoutType;

public interface Layable {
	public void changeLayout(LayoutType currentLayout, int parentX, int parentY, int index);
	public void addLayable(Layable layable);
	public void removeLayable(Layable layable);
}
