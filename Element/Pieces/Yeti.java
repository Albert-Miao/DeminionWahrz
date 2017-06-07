package Element.Pieces;

import Element.Unit;
import Element.Element;
import Grid.GameGrid;

public class Yeti extends Unit //
{
	//private float burnChance; Mess with this later
	
	public Yeti(int x, int y, GameGrid gr){
		super("Yeti", "Element/Pieces/res/Yeti.png", 10, Race.AZURE, "tank", 3, 2, 1, 1, 2);
		putSelfInGrid(gr, x, y);
		//burnChance = 10;
	}
	
	public void attack(Element element){
		element.setHealth(element.getHealth() - (getDamageDealt() - ((Unit) element).getDefenseDealt()));
	}

	public void move(int row, int col)
	{
		moveTo(row, col);
		getGameGrid().getTile(row, col).setElement(this);
	}
	
}
