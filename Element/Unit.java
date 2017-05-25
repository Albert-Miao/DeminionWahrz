package Element;

import java.awt.Graphics;
import javax.swing.ImageIcon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import World.Location;
import GUI.Tile;

public abstract class Unit extends Element
{
	 private int attack;
	 private int damageDealt;
	 private int movement;
	 private int rangeMin;
	 private int rangeMax;
	 private int defense;
	 private Tile currentTile;
	  
	 public Unit(String n, String imgName, int h, Race r, String ut, int att, int def, int rngeMin, int rngeMax, int mvement)
	 {
	 	super(n, imgName, h, r, ut);
		attack = att;
		rangeMin = rngeMin;
		rangeMax = rngeMax;
		movement = mvement;
		defense = def;		
	 }
	 
	 public int getAttack()
	 {
		 return attack;
	 }
	 
	 public int getDefense(){
	 	return defense;
	 }
	 
	 public void setAttack(int att)
	 {
	 	attack = att;
	 }
	 
	 public void setDefense(int def){
	 	defense = def;
	 }
	 
	 public ArrayList<Location> getMovable(){
	 	ArrayList<Location> moveableLocs = new ArrayList<Location>();
	 	Set<Location> set = new HashSet<Location>();
	 	moveableLocs.add(getLocation());
	 	for(int i = 0; i < movement; i++){
	 		ArrayList<Location> toAddLocs = new ArrayList<Location>();
	 		for(Location loc : moveableLocs){
	 			toAddLocs.addAll(getGameGrid().getEmptyAdjacentLocations(loc));
	 		}
	 		set.addAll(toAddLocs);
	 		moveableLocs.addAll(set);
	 	}
	 	
	 	return moveableLocs;
	 }
	 public Location[] getRange(){
	 	//to be implemented
	 }
	 public abstract void move();
	 public abstract void attack();
}