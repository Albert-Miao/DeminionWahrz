package Element.Tiles;

import Element.Tile;
import Element.Unit;

public class Desert extends Tile{
	
	public Desert(int x, int y){
		super(x, y, 50, 50, 1, "Element/Tiles/res/Desert.png");
		setAttMod(0);
		setDefMod(-2);
	}
}