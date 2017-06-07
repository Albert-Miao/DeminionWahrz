package Element.Pieces;

import Element.Unit;
import Element.Element;
import Grid.GameGrid;

public class Spearman extends Unit //
{
	//private float burnChance; Mess with this later
	
	public Spearman(int x, int y, GameGrid gr){
		super("Spearman", "DeminionWahrz/Element/Pieces/res/Spearman.png", 3, Race.TOKKOKINO, "soldier", 4, 0, 1, 1, 2);
		putSelfInGrid(gr, x, y);
		//burnChance = 10;
	}
	
	public void attack(Element element){
		element.setHealth(element.getHealth() - (getDamageDealt() - ((Unit) element).getDefenseDealt()));
	}
	//change
	public void move(int row, int col)
	{
		moveTo(row, col);
		getGameGrid().getTile(row, col).setElement(this);
		//modify tile's setElement so that it changes unit's damage dealt
	}
	
}

