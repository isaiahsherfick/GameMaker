//Layable.java
//    Created by: Snehal Patare
//    Created on: 22 Sep 2021
//     Edited by:
//Edited last by: Snehal Patare


package Group3.gameMaker.CreateGameView;

import Group3.gameMaker.CreateGameView.Location.LayoutType;

public interface Layable {
	public void addLayable(Layable layable);
	public void removeLayable(Layable layable);
	public void changeLayout(LayoutType layout, int parentX, int parentY, int i);
}
