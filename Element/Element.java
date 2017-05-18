import World.Grid;
import World.Location;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public abstract class Element{
	
	private Location loc;
	private Grid<Element> gr;
	private int health;
	private String name;
	private String imageName;
	private ImageIcon img;
	private enum Race {TOKKOKINO,AZURE,NEUTRAL};
	
	public Element(String n, String imageName, int h){
		gr = null;
		loc = null;
		health = h;
		name = n;
		imageName = imgName;
		img = new ImageIcon(imgName);
	}
	
	public String getName(){
		return name;
	}
	
	public Grid<Element> getElement() {
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