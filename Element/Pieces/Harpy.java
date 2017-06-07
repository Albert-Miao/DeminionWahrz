package Element.Pieces;

import Element.Unit;
import Element.Element;
import Grid.GameGrid;

public class Harpy extends Unit //
{
	//private float burnChance; Mess with this later
	
	public Harpy(int x, int y, GameGrid gr){
		super("Harpy", "imageName", 7, Race.AZURE, "aerial", 2, 2, 1, 1, 7);
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
		//modify tile's setElement so that it changes unit's damage dealt
	}
	
}
