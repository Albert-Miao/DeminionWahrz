package Grid;

import javax.swing.JComponent;
import Element.Tile;
java.awt.*;

public class GameGrid extends JComponent
{
	private int numRow;
	private int numCol;
	private int[][] grid;
	
	public GameGrid(int r, int c)
	{
		numRow = r;
		numCol = c;
		grid = new int[numRow][numCol];	
	}
	public int getRow()
	{
		return numRow;
	}
	public int getRow()
	{
		return numCol;
	}
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
	}
	
}