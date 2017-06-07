package Element;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import Element.Tile;

public abstract class Unit extends Element
{
	 private int attack;
	 private int damageDealt;
	 private int movement;
	 private int rangeMin;
	 private int rangeMax;
	 private int defense;
	 
	 private boolean action = true;
	 public Unit(String n, String imgName, int h, Race r, String ut, int att, int def, int rngeMin, int rngeMax, int mvement)
	 {
	 	super(n, imgName, h, r, ut);
		attack = att;
		damageDealt = attack;
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
	 
	 public int getDamageDealt(){
		 return damageDealt;
	 }
	 
	 public void setAttack(int att)
	 {
	 	attack = att;
	 }
	 
	 public void setDefense(int def){
	 	defense = def;
	 }
	 
	 public void setDamageDealt(int dmg){
		damageDealt = dmg;
	 }
	 
	 public Set<Tile> getMovable(){
		 Set<Tile> moveableTiles = new HashSet<Tile>();
		 Set<Tile> tilesToAdd = new HashSet<Tile>();
		 moveableTiles.add(getGameGrid().getTile(getXPos(), getYPos()));
		 for(int i = 0; i < movement; i++){
			 for(Tile tile : moveableTiles){
				 int r = tile.getXCoord();
				 int c = tile.getYCoord(); 
				 tilesToAdd.addAll(getGameGrid().getAdjacentTiles(r,c));
			 }
			 moveableTiles.addAll(tilesToAdd);
			 tilesToAdd.clear();
		 }
		 moveableTiles.remove(getGameGrid().getTile(getXPos(), getYPos()));
		 return moveableTiles;
	 }
	 
	 public Set<Tile> getRange(){
		 Set<Tile> inRangeTiles = new HashSet<Tile>();
		 Set<Tile> tilesToExclude = new HashSet<Tile>();
		 Set<Tile> tilesToAdd = new HashSet<Tile>();
		 inRangeTiles.add(getGameGrid().getTile(getXPos(), getYPos()));
		 tilesToExclude.add(getGameGrid().getTile(getXPos(), getYPos()));
		 for(int i = 0; i < rangeMax; i++){
			 for(Tile tile: inRangeTiles){
				 tilesToAdd.addAll(getGameGrid().getEmptyAdjacentTiles(tile.getXCoord(),tile.getYCoord()));
			 }
			 inRangeTiles.addAll(tilesToAdd);
			 tilesToAdd.clear();
		 }
		 for(int i = 0; i < rangeMin - 1; i++){
			 for(Tile tile : tilesToExclude){
				 tilesToAdd.addAll(getGameGrid().getEmptyAdjacentTiles(tile.getXCoord(),tile.getYCoord()));
			 }
			 tilesToExclude.addAll(tilesToAdd);
			 tilesToAdd.clear();
		 }
		 inRangeTiles.removeAll(tilesToExclude);
		 return inRangeTiles;
	 }
	 
	 public abstract void move(int row, int col);
	 public abstract void attack(Element e);
	 public abstract void attack(Unit u);
}