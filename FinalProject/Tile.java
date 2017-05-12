
public class Tile
{
	private int xPos;
	private int yPos;
	private boolean activeUnit;
	private int terrainType; //1: Normal, 2: Mountain, 3: Forest,4: Deep Sand 
	
	public Tile(int x, int y,int terrain)
	{
		xPos = x;
		yPos = y;
		terrainType = terrain;
		
		
	}
	
}