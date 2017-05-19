package Element;

import java.awt.Graphics;
import javax.swing.ImageIcon;

import info.gridworld.grid.Location;

public abstract class Unit extends Element
{
	 private int attack;
	 private int movement;
	 private int rangeMin;
	 private int rangeMax;
	 private Tile currentTile;
	  
	 public Unit(int att, int rngeMin, int rngeMax, int mvement)
	 {
		attack = att;
		rangeMin = rngeMin;
		rangeMax = rngeMax;
		movement = mvement;
		
	 }
	 
	 public int getAttack()
	 {
		 return attack;
	 }
	 
	 public void setAttack(int att)
	 {
	 	attack = att;
	 }
	 
	 public void setDefense(int def)
	 {
	 	defense = def;
	 }
	 
	 public Location[] getMovable(){
	 	//to be implemented
	 }
	 public Location[] getRange(){
	 	//to be implemented
	 }
	 public abstract void move();
	 public abstract void attack();
}