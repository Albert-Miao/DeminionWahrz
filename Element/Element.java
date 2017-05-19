package Element;

import World.GameGrid;
import World.Location;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public abstract class Element{
	
	private Location loc;
	private GameGrid gr;
	private int health;
	private String name;
	private String imageName;
	private ImageIcon img;
	private enum Race {TOKKOKINO,AZURE,NEUTRAL};
	private Race race;
	private String unitType;
	
	public Element(String n, String imgName, int h, Race r, String ut){
		gr = null;
		loc = null;
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
	
	public Location getLocation(){
		return loc;
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
	
	public void moveTo(Location newLoc){
		if (gr == null)
            throw new IllegalStateException("This actor is not in a grid.");
        if (gr.getElement(loc) != this)
            throw new IllegalStateException(
                    "The grid contains a different actor at location "
                            + loc + ".");
        if (!gr.isValid(newLoc))
            throw new IllegalArgumentException("Location " + newLoc
                    + " is not valid.");

        if (newLoc.equals(loc))
            return;
        gr.removeElement(loc);
        Element other = gr.getElement(newLoc);
        if(other != null)
        	other.removeSelfFromGrid();
        loc = newLoc;
        gr.putElement(this, loc);
	}
	
	public void putSelfInGrid(GameGrid g, Location l){
		if(gr != null)
			throw new IllegalStateException(
                    "This actor is already contained in a grid.");
        Element element = g.getElement(l);
        if(element != null){
        	element.removeSelfFromGrid();
        }
        g.putElement(this, l);
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
                            + loc + ".");
        gr.removeElement(loc);
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