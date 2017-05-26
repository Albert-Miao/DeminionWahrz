
package World;

import World.GameGrid;
import World.Location;
import GUI.BattleGroundFrame;

import Element.Element;
import GUI.Tile;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JFrame;

public class Battleground {
	private GameGrid gr;
	private Set<String> gridClassNames;
	private Set<String> occupantClassNames;
	private Set<String> tileClassNames;
	private String message;
	private JFrame frame;
	
	private static final String DEFAULT_MESSAGE = "Click on a grid location to manipulate an actor";
	
	private static Random generator = new Random();
	
	private static final int DEFAULT_ROWS = 10;
	private static final int DEFAULT_COLS = 10;
	
	public Battleground(){
		this(new GameGrid(DEFAULT_ROWS, DEFAULT_COLS));
		message = null;
	}
	
	public Battleground(GameGrid g){
		gr = g;
		tileClassNames = new TreeSet<String>();
		occupantClassNames = new TreeSet<String>(); 
		addGridClass("World.GameGrid");
	}
	
	public void show(){
		if(getMessage() == null)
			setMessage(DEFAULT_MESSAGE);
		if(frame == null)
		{
			frame = new BattleGroundFrame(this);
			frame.setVisible(true);
		}else
			frame.repaint();
	}
	
	public GameGrid getGameGrid(){
		return gr;
	}
	
	public void setGameGrid(GameGrid newGameGrid){
		gr = newGameGrid;
		repaint();
	}
	
	public void setMessage(String newMessage){
		message = newMessage;
		repaint();
	}
	
	public String getMessage(){
		return message;
	}
	
	public boolean locationClicked(Location loc){
		return false;
	}
	
	public boolean keyPressed(String description, Location loc){
		return false;
	}
	
	public Location getRandomEmptyLocation(){
		GameGrid g = getGameGrid();
		int rows = g.getNumRows();
		int cols = g.getNumCols();
		
		if(rows > 0 && cols > 0){
			ArrayList<Location> emptyLocs = new ArrayList<Location>();
			for(int i = 0; i < rows; i++){
				for(int j = 0; j < cols; j++){
					Location loc = new Location(i, j);
					if(g.isValid(loc) && g.getElement(loc) == null){
						emptyLocs.add(loc);
					}
				}
			}
			if(emptyLocs.size() == 0)
			{
				return null;
			}
			int r = generator.nextInt(emptyLocs.size());
			return emptyLocs.get(r);
		}
	}
	
	public Location getRandomMissingLocation(){
		GameGrid g = getGameGrid();
		int rows = g.getNumRows();
		int cols = g.getNumCols();
		
		if(rows > 0 && cols > 0){
			ArrayList<Location> emptyLocs = new ArrayList<Location>();
			for(int i = 0; i < rows; i++){
				for(int j = 0; j < cols; j++){
					Location loc = new Location(i, j);
					if(g.isValid(loc) && g.getTile(loc) == null){
						emptyLocs.add(loc);
					}
				}
			}
			if(emptyLocs.size() == 0)
			{
				return null;
			}
			int r = generator.nextInt(emptyLocs.size());
			return emptyLocs.get(r);
		}
	}
	
	public void addElement(Element occupant, Location loc){
		getGameGrid().putElement(occupant, loc);
		repaint();
	}
	
	public void addTile(Tile tile, Location loc){
		getGameGrid().putTile(tile, loc);
		repaint();
	}
	
	public Element removeElement(Location loc){
		Element r = getGameGrid().removeElement(loc);
		repaint();
		return r;
	}
	
	public Tile removeTile(Location loc){
		Tile r = getGameGrid().removeTile(loc);
		repaint();
		return r;
	}
	
	public void addGridClass(String className)
    {
        gridClassNames.add(className);
    }
    
    public void addOccupantClass(String className)
    {
        occupantClassNames.add(className);
    }
    
    public void addTileClass(String className)
    {
        tileClassNames.add(className);
    }
    
    public Set<String> getGridClasses()
    {
        return gridClassNames;
    }
    
    public Set<String> getOccupantClasses()
    {
        return occupantClassNames;
    }
    
    public Set<String> getTileClasses()
    {
    	return tileClassNames;
    }
    
    private void repaint()
    {
    	if (frame != null){
    		frame.repaint();
    	}
    }
    public void step()
    {
        repaint();
    }
    
    public String toString(){
    	String s = "";
    	GameGrid g = getGameGrid();
    	
    	int rmin = 0;
        int rmax = g.getNumRows() - 1;
        int cmin = 0;
        int cmax = g.getNumCols() - 1;
        if (rmax < 0 || cmax < 0) // unbounded grid
        {
            for (Location loc : g.getOccupiedLocations())
            {
                int r = loc.getRow();
                int c = loc.getCol();
                if (r < rmin)
                    rmin = r;
                if (r > rmax)
                    rmax = r;
                if (c < cmin)
                    cmin = c;
                if (c > cmax)
                    cmax = c;
            }
        }

        for (int i = rmin; i <= rmax; i++)
        {
            for (int j = cmin; j < cmax; j++)
            {
                Object obj = g.getElement(new Location(i, j));
                if (obj == null)
                    s += " ";
                else
                    s += obj.toString().substring(0, 1);
            }
            s += "\n";
        }
        return s;
    }
}