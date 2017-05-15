import java.awt.geom.*;
import java.awt.*;
import javax.swing.JComponent;
import javax.swing.ImageIcon;

public class Tile
{
	private int xPos;
	private int yPos;
	private boolean activeUnit;
	private int terrainType; //1: Normal, 2: Mountain, 3: Forest,4: Deep Sand 
	
	public Tile(int x, int y,int terrain)
	{
		xPos = x;
		yPos = y;
		terrainType = terrain;
	}
	public void makeTile(Graphics2D graphic)
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
	}	
}