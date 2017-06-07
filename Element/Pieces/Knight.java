package Element.Pieces;

import Element.Unit;
import Element.Element;
import Grid.GameGrid;

public class Knight extends Unit{
	public Knight(int x, int y, GameGrid gr){
		super("Knight", "DeminionWahrz/Element/Pieces/res/Knight.png", 6, Race.AZURE, "soldier", 2, 1, 1, 1, 1);
		putSelfInGrid(gr, x, y);
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