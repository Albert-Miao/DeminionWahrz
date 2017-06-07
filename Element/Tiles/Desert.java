package Element.Tiles;

import Element.Tile;
import Element.Unit;

public class Desert extends Tile{
	private int attMod = 0;
	private int defMod = -2;
	
	public Desert(int x, int y){
		super(x, y, 50, 50, 1, "DeminionWahrz/Element/Tiles/res/Desert.png");
	}
	
	public void modUnit(){
		Unit u = (Unit) getElement();
		u.setDamageDealt(u.getAttack() + attMod);
		u.setDefenseDealt(u.getDefense() + defMod);
		System.out.println("Hit it!");
	}
}