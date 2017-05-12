import java.awt.geom.*;
import java.awt.*;
import javax.swing.JComponent;
import javax.swing.ImageIcon;

public class DrawStuff extends JComponent
  {
    public void paint(Graphics g)
    {
      Graphics2D graph2 = (Graphics2D)g;
      graph2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      
      //Draw Stuff 
      
      java.net.URL imgUrl1 = getClass().getResource("GridBackground.png");
  	  ImageIcon gridBackground = new ImageIcon(imgUrl1);
  	  gridBackground.paintIcon(this,g,0,0);
  	  
      for(int i = 0; i <= 600; i+= 50)//Draw the lines
      {
	      Shape line = new Line2D.Float(0,i,600,i);
	      graph2.setPaint(Color.BLACK);
	      graph2.draw(line);
      }
      for(int i = 0; i <= 600; i+= 50)
      {
	      Shape line = new Line2D.Float(i,0,i,600);
	      graph2.setPaint(Color.BLACK);
	      graph2.draw(line);
      }
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
  }
  