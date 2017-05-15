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
  	}
    public void paint(Graphics g)
    {
      Graphics2D graph2 = (Graphics2D)g;
      graph2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      
      //Draw Grid Background
      
      /*Populates grid with icons
	  *for(int k = 0; k < 600; k+= 50)
	  *{
	  	*for(int b = 0; b < 600; b+= 50)
	  	*{
	  	  *java.net.URL imgUrl = getClass().getResource("TestIcon.png");
	  	  *ImageIcon icon = new ImageIcon(imgUrl);
	  	 * icon.paintIcon(this,g,k,b);
	  	*}
	  *}
		*/
		drawGrid(graph2);
    }
    private void drawGrid(Graphics2D g)
    {
      /*java.net.URL imgUrl1 = getClass().getResource(backgroundName);
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
  	  int x,y = 0;
  	  for(int i = 0; i < grid.length; i++)
  	  {
  	  	for(int k = 0; k < grid[0].length;k++)
  	  	{
  	  		grid[i][k] = new Tile()
  	  	}
  	  }
  	  
    }
    
  }
  