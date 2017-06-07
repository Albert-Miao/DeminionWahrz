package Element.Pieces;

import Element.Unit;
import Element.Element;
import Grid.GameGrid;

public class Priest extends Unit //
{
	//private float burnChance; Mess with this later
	
	public Priest(int x, int y, GameGrid gr){
		super("Priest", "imageName", 4, Race.AZURE, "support", 1, 1, 1, 1, 2);
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
	
	public void heal(Element element){
		element.setHealth(element.getHealth() + 6);
	}
	
}