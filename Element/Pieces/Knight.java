package Element.Pieces;

import Element.Unit;
import Element.Element;
import Grid.GameGrid;

public class Knight extends Unit{
	public Knight(int x, int y, GameGrid gr){
		super("Knight", "DeminionWahrz/Element/Pieces/res/Knight.png", 5, Race.AZURE, "soldier", 2, 0, 1, 1, 1);
		putSelfInGrid(gr, x, y);
	}
	
	public void attack(Element element){
		element.setHealth(element.getHealth() - getDamageDealt());
	}
	
	public void attack(Unit u){
		int damage = getDamageDealt() - u.getDefense();
		if(u.getHealth() <= damage){
			u.setHealth(u.getHealth() - damage);
		}else{
			u.setHealth(u.getHealth() - damage);
			setHealth(getHealth() - (u.getDamageDealt() - getDefense()));
		}
	}
	public void move(int row, int col)
	{
		moveTo(row, col);
		getGameGrid().getTile(row, col).setElement(this);
		//modify tile's setElement so that it changes unit's damage dealt
	}
}