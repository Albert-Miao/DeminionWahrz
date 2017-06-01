package Grid;

import javax.swing.JComponent;
import javax.swing.JPanel;
import Element.Tile;
import java.awt.*;


public class GameGrid extends JPanel
{
	private int numRow;
	private int numCol;
	private Tile[][] grid;
	
	public GameGrid(int r, int c)
	{
		numRow = r;
		numCol = c;
		grid = new Tile[numRow][numCol];
		
		int x,y = 0;
		for(int i = 0;i< numRow;i++)
		{
			for(int k = 0;k <= numCol;k++)
			{
				Tile t = new Tile(x,y,50,50,1,"Not Actually");
				grid[i][k] = t;
				t.setCoords(i,k);
			}
		}	
	}
	public int getRow()
	{
		return numRow;
	}
	public int getCol()
	{
		return numCol;
	}
	
}