package Element.Tiles;

import Element.Tile;
import Element.Unit;

public class Mountain extends Tile{
	private int attMod = 1;
	private int defMod = 3;
	
	public Mountain(int x, int y){
		super(x, y, 50, 50, 1, "DeminionWahrz/Element/Tiles/res/Mountain.png");
	}
	
	public void modUnit(){
		Unit u = (Unit) getElement();
		u.setDamageDealt(u.getAttack() + attMod);
		u.setDefenseDealt(u.getDefense() + defMod);
	}
}