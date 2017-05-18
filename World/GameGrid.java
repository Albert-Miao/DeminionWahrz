import java.awt.geom.*;
import java.awt.*;
import javax.swing.JComponent;
import javax.swing.ImageIcon;

import java.util.ArrayList;

import World.Location;
import GUI.Tile;



public class GameGrid extends JComponent
{
	private Tile[][] grid;
	private Element[][] occupantGrid;
	
	public GameGrid(int rows, int cols)
	{
		grid = new Tile[rows][cols];
		populateGridArray();
	}
	
	public void paint(Graphics g)
	{
	  Graphics2D graphic = (Graphics2D)g;
	  graphic.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	  makeGrid(graphic);
	}
	
	private void populateGridArray()
	{
	  /*java.net.URL imgUrl1 = getClass().getResource(backgroundName);WILL BE IMPLEMENTED LATER
	  *ImageIcon gridBackground = new ImageIcon(imgUrl1);
	  *gridBackground.paintIcon(this,g,0,0);
	  */
	  for(int i = 0; i < grid.length; i++)//Fill grid array with null tiles
	  {
	  	for(int k = 0; k < grid[0].length;k++)
	  	{
	  		Tile t = null;
	  		grid[i][k] = t;
	  	}
	  }
	  int x = 0,y = 0;
	  for(int i = 0; i < grid.length; i++)
	  {
	  	for(int k = 0; k < grid[0].length;k++)
	  	{
	  		grid[i][k] = new Tile(x,y,1);
	  		x += 50;
	  	}
	  	x = 0;
	  	y += 50;
	  }	
	}
	  	
    private void makeGrid(Graphics2D g)
    {
		for(int i = 0; i < grid.length; i++)
		{
			for(int k = 0; k < grid[0].length;k++)
  	  		{
  	  			grid[i][k].makeTile(g);
  	  		}
		}
  	  
    }
    
    public int getNumRows(){
    	return grid.length;
    }
    
    public int getNumCols(){
    	return grid[0].length;
    }
    
    public Tile getTileAt(Location loc){
    	return grid[loc.getRow()][loc.getCol()];
    }
    
    public Element getElementAt(Location loc) {
    	return occupantGrid[loc.getRow()][loc.getCol()];
    }
    
    public boolean isValid(Location loc)
    {
        return 0 <= loc.getRow() && loc.getRow() < getNumRows()
                && 0 <= loc.getCol() && loc.getCol() < getNumCols();
    }
    
    public ArrayList<Location> getOccupiedLocations()
    {
        ArrayList<Location> theLocations = new ArrayList<Location>();

        // Look at all grid locations.
        for (int r = 0; r < getNumRows(); r++)
        {
            for (int c = 0; c < getNumCols(); c++)
            {
                // If there's an object at this location, put it in the array.
                Location loc = new Location(r, c);
                if (getElementAt(loc) != null)
                    theLocations.add(loc);
            }
        }

        return theLocations;
    }
}
  