import java.awt.geom.*;
import java.awt.*;
import javax.swing.JComponent;
import javax.swing.ImageIcon;

public class GameGrid extends JComponent
  {
  	public Tile[][] grid;
  	
  	public GameGrid()
  	{
  		grid = new Tile[20][20];
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
  }
  