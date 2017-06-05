package Element;

import Grid.GameGrid;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;

public abstract class Element{
	
	private int xPos;
	private int yPos;
	private int absX;
	private int absY;
	private GameGrid gr;
	private int health;
	private String name;
	private String imageName;
	private ImageIcon img;
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
		imageName = imgName;
		img = new ImageIcon(imgName);
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
	public ImageIcon getImage()
	{
		return img;
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
        if (gr.getElement(newX, newY) != this)
            throw new IllegalStateException(
                    "The grid contains a different actor at location "
                            + newX +", " + newY + ".");
        if (!gr.isValid(newX, newY))
            throw new IllegalArgumentException("Location " + newX + ", " + newY
                    + " is not valid.");

        if (newX == xPos && newY == yPos)
            return;
        gr.removeElement(xPos, yPos);
        Element other = gr.getElement(xPos, yPos);
        if(other != null)
        	other.removeSelfFromGrid();
        xPos = newX;
        yPos = newY;
        absX = xPos * length;
        absY = yPos * width;
        gr.putElement(this, newX, newY);
	}
	
	public void putSelfInGrid(GameGrid g, int x, int y){
		if(gr != null)
			throw new IllegalStateException(
                    "This actor is already contained in a grid.");
        Element element = g.getElement(x, y);
        if(element != null){
        	element.removeSelfFromGrid();
        }
        g.putElement(this, x, y);
        gr = g;
        xPos = x;
        yPos = y;
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
}