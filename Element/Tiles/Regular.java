package Element.Tiles;

import Element.Tile;
import Element.Unit;

public class Regular extends Tile{
	private int attMod = 0;
	private int defMod = 0;
	
	public Regular(int x, int y){
		super(x, y, 50, 50, 1, "Element/Tiles/res/Regular.png");
	}
	
	public void modUnit(){
		Unit u = (Unit) getElement();
		u.setDamageDealt(u.getAttack() + attMod);
		u.setDefenseDealt(u.getDefense() + defMod);
	}
}