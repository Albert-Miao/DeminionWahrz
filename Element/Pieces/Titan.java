package Element.Pieces;

import Element.Unit;
import Element.Element;
import Grid.GameGrid;

public class Titan extends Unit //
{
	//private float burnChance; Mess with this later
	
	public Titan(int x, int y, GameGrid gr){
		super("Titan", "imageName", 7, Race.TOKKOKINO, "soldier", 5, 1, 1, 1, 3);
		putSelfInGrid(gr, x, y);
		//burnChance = 10;
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
