package Grid;

import javax.swing.JComponent;
import javax.swing.JPanel;
import Element.Tile;
import Element.Element;
import java.util.ArrayList;
import java.awt.*;
import java.net.URL;


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
		
		int x = 0,y = 0;
		for(int i = 0;i< numRow;i++)
		{
			for(int k = 0;k < numCol;k++)
			{
				Tile t = new Tile(x,y,50,50,1,"src/Managers/res/NewPiskel.png");
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
		Tile tile = getTile(r,c);
		return tile.getXPos();
	}
	
	public int getAbsolutePositionY(int r, int c)
	{
		if( r < 0 || c < 0) {
			throw new IllegalStateException("Invalid Position");
		}
		
		Tile tile = getTile(r,c);
		return tile.getYPos();
	}
	
	public void putElement(Element element, int r, int c) {
		element.moveTo(r,c);
		
		int xAbs = getAbsolutePositionX(r,c);
		int yAbs = getAbsolutePositionY(r,c);
		
		element.setAbsX(xAbs);
		element.setAbsY(yAbs);
		
		grid[r][c].setElement(element);
	}
	
	public Tile getTile(int r, int c) {
		return grid[r][c];
	}
	
	public void putTile(Tile t, int r, int c) {
		grid[r][c] = t;
	}
	
	public Element getElement(int r, int c) {
		return grid[r][c].getElement();
	}
	
	public void removeTile(int r, int c) {
		grid[r][c] = null;
	}
	
	public void removeElement(int r, int c) {
		grid[r][c].setElement(null);
	}
	public ArrayList<Tile> getAdjacent(int r, int c) {
		ArrayList<Tile> adjacent = new ArrayList<Tile>();
		
		if (isValid(r+1,c)) { adjacent.add(grid[r+1][c]); }
		if (isValid(r-1,c)) { adjacent.add(grid[r-1][c]); }
		if (isValid(r,c+1)) { adjacent.add(grid[r][c+1]); }
		if (isValid(r,c-1)) { adjacent.add(grid[r][c-1]); }
		
		return adjacent;
	}
	public boolean isValid(int r, int c) {
		Tile tile = grid[r][c];
		if(tile == null || r < 0 || c < 0) {
			return false;
		}
		else {
			return true;
		}
		
	}
	public void paintComponent(Graphics g) {
		
		//Graphics2D g2d = (Graphics2D) g;
		for(int row = 0; row < numRow; row++) {
			for(int col = 0; col < numCol; col++) {
				grid[row][col].paintComponent(g);
			}
		}
	}
}