package Element;

import Grid.GameGrid;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.Image;

public abstract class Element{
	
	private int xPos;
	private int yPos;
	private int absX;
	private int absY;
	private GameGrid gr;
	private int health;
	private String name;
	private String imagePath;
	private BufferedImage image;
	private BufferedImage displayedImage;
	public enum Race {TOKKOKINO,AZURE,NEUTRAL};
	private Race race;
	private String unitType;
	private int length;
	private int width;
	
	public Element(String n, String imgName, int h, Race r, String ut){
		gr = null;
		xPos = -1;
		yPos = -1;
		absX = -1;
		absY = -1;
		health = h;
		name = n;
		imagePath = imgName;
		try {
			image = ImageIO.read(new File(imagePath));
			displayedImage = ImageIO.read(new File(imagePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(imagePath);
		}
		length = 50;
		width = 50;
		race = r;
		unitType = ut;
	}
	
	public String getName(){
		return name;
	}
	
	public GameGrid getGameGrid() {
		return gr;
	}
	
	public int getXPos(){
		return xPos;
	}
	
	public int getYPos(){
		return yPos;
	}
	
	public int getAbsX(){
		return absX;
	}
	
	public int getAbsY(){
		return absY;
	}
	
	public void setAbsX(int x){
		absX = x;
	}
	
	public void setAbsY(int y){
		absY = y;
	}
	
	public int getHealth(){
		return health;
	}
	public BufferedImage getImage()
	{
		return image;
	}
	public String getUnitType()
	{
		return unitType;
	}
	
	public Race getRace(){
		return race;
	}
	
	public void moveTo(int newX, int newY){
		if (gr == null)
            throw new IllegalStateException("This actor is not in a grid.");
        if (gr.getTile(newX, newY).hasElement() && gr.getElement(newX, newY) != this)
            throw new IllegalStateException(
                    "The grid contains a different actor at location "
                            + newX +", " + newY + ". " +this);
        if (!gr.isValid(newX, newY))
            throw new IllegalArgumentException("Location " + newX + ", " + newY
                    + " is not valid.");

        if (newX == xPos && newY == yPos)
            return;
        if(xPos > 0 && yPos > 0)
        	gr.removeElement(xPos, yPos);
        Element other = gr.getElement(newX, newY);
        if(other != null)
        	other.removeSelfFromGrid();
        xPos = newX;
        yPos = newY;
        absX = xPos * length;
        absY = yPos * width;
	}
	
	public void putSelfInGrid(GameGrid g, int x, int y){
		if(gr != null)
			throw new IllegalStateException(
                    "This actor is already contained in a grid.");
        Element element = g.getElement(x, y);
        if(element != null){
        	element.removeSelfFromGrid();
        }
        gr = g;
        g.putElement(this, x, y);
	}
	
	public void removeSelfFromGrid(){
		if (gr == null)
            throw new IllegalStateException(
                    "This actor is not contained in a grid.");
        if (gr.getElement(xPos, yPos) != this)
            throw new IllegalStateException(
                    "The grid contains a different actor at location "
                            + xPos + ", " + yPos + ".");
        gr.removeElement(xPos, yPos);
        gr = null;
        xPos = -1;
        yPos = -1;
	}
	
	public void setHealth(int h){
		health = h;
		if(health <= 0){
			die();
		}
	}
	
	public void die(){
		removeSelfFromGrid();
	}
	
	public String toString()
    {
        return getClass().getName() + "[location=" + xPos + " " + yPos + " health=" + health + "]";
    }
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(displayedImage,absX,absY,width,length,null);
	}
}