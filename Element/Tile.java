package Element;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.ImageIO;
import java.imageio.ImageIO;


public class Tile
{
	private int xPos;
	private int yPos;
	private int length;
	private int width;
	private int x;
	private int y;
	private int terrainType;
	private String imageName;
	private Image image;
	
	public Tile(int xP, int yP, int l, int w,int tt, String imagename)
	{
		xPos = xP;
		yPos = yP;
		length = l;
		width = w;
		terrainType = tt;
		imageName = imagename;
		try {
			image = ImageIO.read(getClass().getResourceAsStream(imageName));
		} 
		catch(IOException ex) {
			e.printStackTrace();
		}		
	}
	public void setCoords(int xCoord,int yCoord)
	{
		x = xCoord;
		y = yCoord;
	}
	public int getXCoord() {
		return x;
	}
	public int getYCoord() {
		return y;
	}
	public int getImage(){
		return image;
	}
	public void highlightTiles(){
		
	}
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawRect(xPos,yPos,width,length);
		g2d.drawImage(image,xPos,yPos,width,length,null);
	}
}