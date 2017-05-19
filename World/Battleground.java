package World;

import World.GameGrid;
import World.Location;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JFrame;

public class Battleground {
	private GameGrid gr;
	private Set<String> occupantClassNames;
	private Set<String> tileClassNames;
	private String message;
	private JFrame frame;
	
	private static Random generator = new Random();
	
	private static final int DEFAULT_ROWS = 10;
	private static final int DEFAULT_COLS = 10;
	
	public World(GameGrid g){
		gr = g;
		tileClassNames = new TreeSet<String>();
		occupantClassNames = new TreeSet<String>();
		addGridClass("World.GameGrid");
	}
	
	public void show()
    {
        if (frame == null)
        {
            frame = new WorldFrame<T>(this);
            frame.setVisible(true);
        }
        else
            frame.repaint();
    }
}