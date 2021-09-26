//ShapeStrategy.java
//    Created by: Isaiah Sherfick
//    Created on: 25 Sep 2021
//     Edited by:
//Edited last by: Isaiah Sherfick
//   Last change: Created interface for shape strategies
package Group3.gameMaker.Sprite.Shape;
import Group3.gameMaker.SaveAndLoad.Saveable;

public interface ShapeStrategy extends Saveable
{
	public void draw(Graphics g);
	public int getWidth();
	public int getHeight();
	
	//Returns the shape that the strategy object
	//is representing
	//used for save/load restoration 
	public String getShape();
}
