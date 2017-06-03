package Element;

import Grid.GameGrid;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Color;


public class Tile
{
	private int xPos;
	private int yPos;
	private int length;
	private int width;
	private int x;
	private int y;
	private int terrainType;
	private String imagePath;
	private BufferedImage image;
	private Element element;
	
	public Tile(int xP, int yP, int l, int w,int tt, String imagepath)
	{
		xPos = xP;
		yPos = yP;
		length = l;
		width = w;
		terrainType = tt;
		imagePath = imagepath;
		File imgFile = new File(imagePath);
		try {
		image = ImageIO.read(imgFile);
		}
		catch(IOException e) {
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
	public int getXPos() {
		return xPos;
	}
	public int getYPos() {
		return yPos;
	}
	public void setElement(Element e) {
		element = e;
	}
	public Element getElement() {
		return element;
	}
	public Image getImage(){
		return image;
	}
	public void highlightTiles() { //Tint tiles green
		
		for(int i = 0; i <= image.getWidth(null); i++) {
			for(int k = 0; k <= image.getWidth(null); k++) {
				Color c = new Color(image.getRGB(i,k));
				
				int r = c.getRed();
				int b = c.getGreen();
				int g = c.getBlue();
				
				Color greenTint = new Color(r - 50, g, b - 50);
				
				image.setRGB(i, k, greenTint.getRGB());
			}
		}
		
	}
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawRect(xPos,yPos,width,length);
		g2d.drawImage(image,xPos,yPos,width,length,null);
	}
}