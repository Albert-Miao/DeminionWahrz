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
	private String unitType;
	
	public Element(String n, String imageName, int h, Race r, String ut){
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
	public getUnitType()
	{
		return unitType();
	}
	public void setGrid(){
		//to be implemented
	}
	public void setLocation(){
		//to be implemented
	}
	public void setHealth(int h){
		health = h;
	}
}