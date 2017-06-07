package Element;

import Grid.GameGrid;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.Color;


public abstract class Tile
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
	private BufferedImage displayedImage;
	private Element element;
	
	private int attMod;
	private int defMod;
	
	public Tile(int xP, int yP, int l, int w,int tt, String imagepath)
	{
		x = xP;
		y = yP;
		xPos = l * x;
		yPos = w * y;
		length = l;
		width = w;
		terrainType = tt;
		imagePath = imagepath;
		try {
			image = ImageIO.read(new File(imagePath));
			displayedImage = ImageIO.read(new File(imagePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(imagePath);
		}
	}
	public void setCoords(int xCoord,int yCoord)
	{
		x = xCoord;
		y = yCoord;
		
		xPos = x * length;
		yPos = y * width;
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
	public boolean hasElement(){
		if(element == null)
			return false;
		return true;
	}
	public Element getElement() {
		return element;
	}
	public Image getImage(){
		return image;
	}
	public void highlightTile() { //Tint tiles green
		
		for(int i = 0; i < image.getWidth(null); i++) {
			for(int k = 0; k < image.getWidth(null); k++) {
				Color c = new Color(image.getRGB(i,k));
				//System.out.println(c.toString());
				int r = c.getRed();
				int g = c.getGreen();
				int b = c.getBlue();
				int a = c.getAlpha();
				
				Color greenTint = new Color(r, 225, b, a);
				
				displayedImage.setRGB(i, k, greenTint.getRGB());
			}
		}
		Graphics imageGraphics = displayedImage.getGraphics();
		paintComponent(imageGraphics);
	}
	public void highlightTileRed() { //Tint tiles red
			
			for(int i = 0; i < image.getWidth(null); i++) {
				for(int k = 0; k < image.getWidth(null); k++) {
					Color c = new Color(image.getRGB(i,k));
					//System.out.println(c.toString());
					int r = c.getRed();
					int g = c.getGreen();
					int b = c.getBlue();
					int a = c.getAlpha();
					
					Color greenTint = new Color(255, g, b, a);
					
					displayedImage.setRGB(i, k, greenTint.getRGB());
				}
			}
			Graphics imageGraphics = displayedImage.getGraphics();
			paintComponent(imageGraphics);
		}
	public void unHighlightTile() {	
		try {
			displayedImage = ImageIO.read(new File(imagePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(imagePath);
		}
		Graphics imageGraphics = displayedImage.getGraphics();
		paintComponent(imageGraphics);
	}
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(displayedImage,xPos,yPos,width,length,null);
		g2d.drawRect(xPos,yPos,width,length);
	}
	
	public String toString(){
		return x + " " + y;
	}
	
	public void modUnit(){
		Unit u = (Unit) getElement();
		u.setDamageDealt(u.getAttack() + attMod);
		u.setDefenseDealt(u.getDefense() + defMod);
	}
	
	public int getAttMod(){
		return attMod;
	}
	
	public int getDefMod(){
		return defMod;
	}
	
	public void setAttMod(int a){
		attMod = a;
	}
	
	public void setDefMod(int d){
		defMod = d;
	}
}