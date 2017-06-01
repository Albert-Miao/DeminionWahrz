package Element;

import Grid.GameGrid;
//import World.Location;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public abstract class Element{
	
	private int xPos;
	private int yPos;
	private GameGrid gr;
	private int health;
	private String name;
	private String imageName;
	private ImageIcon img;
	public enum Race {TOKKOKINO,AZURE,NEUTRAL};
	private Race race;
	private String unitType;
	
	public Element(String n, String imgName, int h, Race r, String ut){
		gr = null;
		xPos = null;
		yPos = null;
		health = h;
		name = n;
		imageName = imgName;
		img = new ImageIcon(imgName);
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
	
	public void moveTo(int newX, int newY){
		if (gr == null)
            throw new IllegalStateException("This actor is not in a grid.");
        if (gr.getElement(newX, newY) != this)
            throw new IllegalStateException(
                    "The grid contains a different actor at location "
                            + newX +", " + newY + ".");
        if (!gr.isValid(newX, newY))
            throw new IllegalArgumentException("Location " + newLoc
                    + " is not valid.");

        if (newX == xPos && newY == yPos)
            return;
        gr.removeElement(xPos, yPos);
        Element other = gr.getElement(xPos, yPos);
        if(other != null)
        	other.removeSelfFromGrid();
        xPos = newX;
        yPos = newY;
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
        loc = l;
	}
	
	public void removeSelfFromGrid(){
		if (gr == null)
            throw new IllegalStateException(
                    "This actor is not contained in a grid.");
        if (gr.getElement(loc) != this)
            throw new IllegalStateException(
                    "The grid contains a different actor at location "
                            + x + ", " + y + ".");
        gr.removeElement(x, y);
        gr = null;
        loc = null;
	}
	
	public void setHealth(int h){
		health = h;
	}
	
	public String toString()
    {
        return getClass().getName() + "[location=" + loc + "health=" + health + "]";
    }
}