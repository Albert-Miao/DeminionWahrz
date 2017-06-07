package Element.Tiles;

import Element.Tile;
import Element.Unit;

public class Regular extends Tile{
	
	public Regular(int x, int y){
		super(x, y, 50, 50, 1, "Element/Tiles/res/Regular.png");
		setAttMod(0);
		setDefMod(0);
	}
}