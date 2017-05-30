package Grid;

import javax.swing.JComponent;
import Element.Tile;
import java.awt.*;

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
		for(int i = 0;i< numRow;i++)
		{
			for(int k = 0;k <= numCol;k++)
			{
				
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
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
			
	}
	
}