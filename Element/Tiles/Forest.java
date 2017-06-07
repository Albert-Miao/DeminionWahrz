package Element.Tiles;

import Element.Tile;
import Element.Unit;

public class Forest extends Tile{
	
	public Forest(int x, int y){
		super(x, y, 50, 50, 1, "Element/Tiles/res/Forest.png");
		setAttMod(-1);
		setDefMod(3);
	}
}