package GUI;

import java.awt.geom.*;
import java.awt.*;
import javax.swing.JComponent;
import javax.swing.ImageIcon;
import World.Location;
import Element.Unit;


public class Tile
{
	
	private boolean activeUnit;
	private int terrainType; //1: Normal, 2: Mountain, 3: Forest,4: Deep Sand
	private Location location;
	private int row;
	private int col;
	
	public Tile(int r, int c,int terrain)
	{
		//xPos = x;
		//yPos = y;
		row = r;
		col = c;
		location = new Location(row,col);
		terrainType = terrain;
	}
	/*public void makeTile(Graphics2D graphic)
	{
	    Shape line1 = new Line2D.Float(xPos,yPos,xPos,yPos + 50);
	    graphic.setPaint(Color.BLACK);
	    Shape line2 = new Line2D.Float(xPos,yPos,xPos + 50,yPos);
	    graphic.setPaint(Color.BLACK);
	    Shape line3 = new Line2D.Float(xPos,yPos+50,xPos+50,yPos+50);
	    graphic.setPaint(Color.BLACK);
	    Shape line4 = new Line2D.Float(xPos+50,yPos,xPos+50,yPos+50);
	    graphic.setPaint(Color.BLACK);
	    
	    graphic.draw(line1);
	    graphic.draw(line2);
	    graphic.draw(line3);
	    graphic.draw(line4);
	}*/
   public Location getLocation()
   {
   		return location;
   }
   
   public void checkTileStats(Unit u)
   {
   		switch(this.terrainType){
   			case 1: break;//Normal
   			case 2: if (u.getUnitType().equals("Soldier")) {u.setAttack(u.getAttack() + 2);}//Mountain
   					else if (u.getUnitType().equals("Healer")) {u.setDefense(u.getDefense() - 1);}
   					else if (u.getUnitType().equals("Tank")) {u.setDefense(u.getDefense() + 1);}
   					else if (u.getUnitType().equals("Aerial")) {u.setDefense(u.getDefense() - 1);}
   			
   			case 3: if (u.getUnitType().equals("Soldier")) {u.setAttack(u.getAttack() + 2);}//Forest
   					else if (u.getUnitType().equals("Healer")) {u.setDefense(u.getDefense() - 1);}
   					else if (u.getUnitType().equals("Tank")) {u.setDefense(u.getDefense() + 1);}
   					else if (u.getUnitType().equals("Aerial")) {u.setDefense(u.getDefense() - 1);}
   			
   			case 4: if (u.getUnitType().equals("Soldier")) {u.setDefense(u.getDefense() - 1);}//Deep Sand
   					else if (u.getUnitType().equals("Healer")) {u.setDefense(u.getDefense() + 2);}
   					else if (u.getUnitType().equals("Tank")) {u.setDefense(u.getDefense() - 3);}
   					else if (u.getUnitType().equals("Aerial")) {u.setAttack(u.getAttack() + 2);}
   			default:
   				break;
   								
   		}
   }	
}

