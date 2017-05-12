import java.awt.Graphics;
import javax.swing.ImageIcon;

public abstract class Unit //extends Element
{
	 private int attack;
	 private int defense;
	 private int range;
	 private String name;
	 private String imageName;
	 private ImageIcon img;
	  
	 public Unit(int att, int def, int rnge, String unitName, String imgName)
	 {
		attack = att;
		defense = def;
		range = rnge;
		name = unitName;
		imageName = imgName;
		img = new ImageIcon(imgName);
	 }
	 
	 public int getAttack()
	 {
		 return attack;
	 }
	 public int getDefense()
	 {
		 return defense;
	 }
	 public int getRange()
	 {
		 return range;
	 }
	 public String getName()
	 {
		 return name;
	 }
	 public ImageIcon getImage()
	 {
		 return img;
	 }
	 public abstract void move();
	 public abstract void attack();
	 public abstract int getHealth();
	 public abstract void setHealth();
	 
}