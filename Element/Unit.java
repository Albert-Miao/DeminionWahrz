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
	 
	 public ArrayList<Tile> getMovable(){
	 	ArrayList<Tile> moveableTiles = new ArrayList<Tile>();
	 	Set<Tile> set = new HashSet<Tile>();
	 	moveableTiles.add(getGameGrid().getTile(getXPos(), getYPos()));
	 	for(int i = 0; i < movement; i++){
	 		ArrayList<Tile> toAddTiles = new ArrayList<Tile>();
	 		for(Tile tile : moveableTiles){
	 			toAddTiles.addAll(getGameGrid().getEmptyAdjacentLocations(getXPos(), getYPos()));
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