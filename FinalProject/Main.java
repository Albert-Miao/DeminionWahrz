import java.awt.geom.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;


public class Main extends JFrame{
	
  public static void main(String[] args)
  {
    new Main();
  }     
  public Main()
  {
    this.setSize(1500,800);
    this.setTitle("Test");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.add(new DrawStuff(), BorderLayout.CENTER);
    this.setVisible(true);
    System.out.println("BOOP");
    
    
  }
}