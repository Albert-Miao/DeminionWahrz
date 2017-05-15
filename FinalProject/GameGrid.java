import java.awt.geom.*;
import java.awt.*;
import javax.swing.JComponent;
import javax.swing.ImageIcon;

public class GameGrid extends JComponent
  {
  
    public void paint(Graphics g)
    {
      Graphics2D graph2 = (Graphics2D)g;
      graph2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      
      //Draw Grid Background
      drawGrid(graph2,"GridBackground.png");
      //Populates grid with icons
	  for(int k = 0; k < 600; k+= 50)
	  {
	  	for(int b = 0; b < 600; b+= 50)
	  	{
	  	  java.net.URL imgUrl = getClass().getResource("TestIcon.png");
	  	  ImageIcon icon = new ImageIcon(imgUrl);
	  	  icon.paintIcon(this,g,k,b);
	  	}
	  }

    }
    private void drawGrid(Graphics2D g,String backgroundName)
    {
      java.net.URL imgUrl1 = getClass().getResource(backgroundName);
  	  ImageIcon gridBackground = new ImageIcon(imgUrl1);
  	  gridBackground.paintIcon(this,g,0,0);
  	  
      for(int i = 0; i <= 600; i+= 50)
      {
	      Shape line = new Line2D.Float(0,i,600,i);
	      g.setPaint(Color.BLACK);
	      g.draw(line);
      }
      for(int i = 0; i <= 600; i+= 50)
      {
	      Shape line = new Line2D.Float(i,0,i,600);
	      g.setPaint(Color.BLACK);
	      g.draw(line);
      }
    }
  }
  