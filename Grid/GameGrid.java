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
	public int getAbsolutePositionX(int r, int c)
	{
		if( r < 0 || c < 0) {
			throw new IllegalStateException("Invalid Position");
		}
		tile = getTile(r,c);
		tile.getXpos();
	}
	public int getAbsolutePositionY(int r, int c)
	{
		if( r < 0 || c < 0) {
			throw new IllegalStateException("Invalid Position");
		}
		tile = getTile(r,c);
		tile.getYpos();
	}
	public void putElement(Element element, int r, int c) {
		element.moveTo(r,c);
		
		int xAbs = getAbsoulutePositionX(r,c);
		int yAbs = getAbsolutePositionY(r,c);
		
		element.setAbsX(xAbs);
		element.setAbsY(yAbs);
		
		tile.setElement(element);
	}
	//public Element getElement(int r, int c)
	//public void putTile(int r, int c)
	//public Tile getTile(int r, int c)
	//public void removeTile(int r, int c)
	//public void removeElement(int r, int c)
	//public boolean isValid(int r, int c)
}