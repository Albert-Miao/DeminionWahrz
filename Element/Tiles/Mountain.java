package Element.Tiles;

import Element.Tile;
import Element.Unit;

public class Mountain extends Tile{
	
	public Mountain(int x, int y){
		super(x, y, 50, 50, 1, "Element/Tiles/res/Mountain.png");
		setAttMod(1);
		setDefMod(3);
	}
}