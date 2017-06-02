package Element;

public class Spearman extends Unit //
{
	private float burnChance;
	
	public Spearman(int att, int rngeMin, int rngeMax, int mvement,String ut, float bc)
	{
		super(att,rngeMin,rngeMax,mvement,ut);
		burnChance = bc;
		race = TOKKOKINO;
	}
	
	public void attack(Unit u)
	{
		unitHealth = u.getHealth();
		u.setHealth(unitHealth - attack);
	}
	public void move(int row, int col)
	{
		Tile newTile = grid[row][col];
		tileLoc = newTile.getLocation();
		newTile.checkTileStatus(this);
		moveTo(tileLoc);
	}
	
}

