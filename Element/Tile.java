package Element;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class Tile
{
	private int xPos;
	private int yPos;
	private int length;
	private int width;
	private int x;
	private int y;
	private int terrainType;
	
	public Tile(int xP, int yP, int l, int w,int tt)
	{
		xPos = xP;
		yPos = yP;
		length = l;
		width = w;
		terrainType = tt;		
	}
	public void setCoords(int xCoord,int yCoord)
	{
		x = xCoord;
		y = yCoord;
	}
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawRect(xPos,yPos,width,length);
	}
}