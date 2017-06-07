package Element.Tiles;

import Element.Tile;
import Element.Unit;

public class Forest extends Tile{
	private int attMod = -1;
	private int defMod = 3;
	
	public Forest(int x, int y){
		super(x, y, 50, 50, 1, "DeminionWahrz/Element/Tiles/res/Forest.png");
	}
	
	public void modUnit(){
		Unit u = (Unit) getElement();
		u.setDamageDealt(u.getAttack() + attMod);
		u.setDefenseDealt(u.getDefense() + defMod);
	}
}