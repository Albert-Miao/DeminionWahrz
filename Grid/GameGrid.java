package Grid;

import javax.swing.JPanel;
import Element.Tile;
import Element.Element;
import Element.Element.Race;
import Element.Unit;

import java.util.ArrayList;
import java.awt.*;
import java.net.URL;

public class GameGrid extends JPanel
{
	private int numRow;
	private int numCol;
	private Tile[][] grid;
	
	private Tile hovered;
	
	public enum GameMode {DEFAULT, SELECTED, MOVE, ATTACK};
	
	private Element selected;
	
	private GameMode mode = GameMode.DEFAULT;
	private Race turn = Race.AZURE;
	
	public GameGrid(int r, int c)
	{
		super();
		numRow = r;
		numCol = c;
		grid = new Tile[numRow][numCol];
		
		selected = null;
		
		for(int i = 0;i< numRow;i++)
		{
			for(int k = 0;k < numCol;k++)
			{
				Tile t = new Tile(i,k,50,50,1,"DeminionWahrz/Managers/res/NewPiskel.png");
				grid[i][k] = t;
			}
		}
	}
	
	public GameMode getMode(){
		return mode;
	}
	
	public void setMode(GameMode mo){
		mode = mo;
	}
	
	public Race getTurn(){
		return turn;
	}
	
	public void switchTurn(){
		if(turn == Race.AZURE){
			turn = Race.TOKKOKINO;
			System.out.println("TOKKOKINO TURN");
		}else{
			turn = Race.AZURE;
			System.out.println("AZURE TURN");
		}
	}
	
	public Element getSelected(){
		return selected;
	}
	public Unit getSelectedAsUnit(){
		return (Unit)selected;
	}
	public void setSelected(Element e){
		selected = e;
	}
	
	public int getRow()
	{
		return numRow;
	}
	
	public int getCol()
	{
		return numCol;
	}
	
	public int getAbsolutePositionX(int r, int c)
	{
		if( r < 0 || c < 0) {
			throw new IllegalStateException("Invalid Position");
		}
		Tile tile = getTile(r,c);
		return tile.getXPos();
	}
	
	public int getAbsolutePositionY(int r, int c)
	{
		if( r < 0 || c < 0) {
			throw new IllegalStateException("Invalid Position");
		}
		
		Tile tile = getTile(r,c);
		return tile.getYPos();
	}
	
	public void putElement(Element element, int r, int c) {
		element.moveTo(r,c);
		grid[r][c].setElement(element);
	}
	
	public Tile getTile(int r, int c) {
		return grid[r][c];
	}
	
	public void putTile(Tile t, int r, int c) {
		grid[r][c] = t;
	}
	
	public Element getElement(int r, int c) {
		return grid[r][c].getElement();
	}
	
	public boolean hasElement(int r, int c) {
		return grid[r][c].hasElement();
	}
	
	public void removeTile(int r, int c) {
		grid[r][c] = null;
	}
	
	public void removeElement(int r, int c) {
		grid[r][c].setElement(null);
	}
	public ArrayList<Tile> getAdjacentTiles(int r, int c) {
		ArrayList<Tile> adjacent = new ArrayList<Tile>();
		
		if (isValid(r+1,c)) { adjacent.add(grid[r+1][c]); }
		if (isValid(r-1,c)) { adjacent.add(grid[r-1][c]); }
		if (isValid(r,c+1)) { adjacent.add(grid[r][c+1]); }
		if (isValid(r,c-1)) { adjacent.add(grid[r][c-1]); }
		
		return adjacent;
	}
	public ArrayList<Tile> getAdjacentTilesFull(int r, int c) {
		ArrayList<Tile> adjacent = new ArrayList<Tile>();
		
		if (isValid(r+1,c)) { adjacent.add(grid[r+1][c]); }
		if (isValid(r-1,c)) { adjacent.add(grid[r-1][c]); }
		if (isValid(r,c+1)) { adjacent.add(grid[r][c+1]); }
		if (isValid(r,c-1)) { adjacent.add(grid[r][c-1]); }
		if (isValid(r+1,c+1)) { adjacent.add(grid[r+1][c+1]); }
		if (isValid(r+1,c-1)) { adjacent.add(grid[r+1][c-1]); }
		if (isValid(r-1,c+1)) { adjacent.add(grid[r-1][c+1]); }
		if (isValid(r-1,c-1)) { adjacent.add(grid[r-1][c-1]); }
		
		return adjacent;
	}
	public ArrayList<Tile> getEmptyAdjacentTiles(int r, int c) {
		ArrayList<Tile> emptyAdjacent = new ArrayList<Tile>();
		
		if (isValid(r+1,c)){ 
			if(!hasElement(r+1,c)) { 
				emptyAdjacent.add(grid[r+1][c]); 
				}
			}
		if (isValid(r-1,c)){ 
			if(!hasElement(r-1,c)) { 
				emptyAdjacent.add(grid[r-1][c]); 
				}
			}
		if (isValid(r,c+1)){ 
			if(!hasElement(r,c+1)) { 
				emptyAdjacent.add(grid[r][c+1]); 
				}
			}
		if (isValid(r,c-1)){ 
			if(!hasElement(r,c-1)) { 
				emptyAdjacent.add(grid[r][c-1]); 
				}
			}
		
		return emptyAdjacent;
	}
	public ArrayList<Tile> getEnemyAdjacentTiles(int r, int c, Race race) {
		ArrayList<Tile> occupiedAdjacent = new ArrayList<Tile>();
		
		ArrayList<Tile> adjacent = getAdjacentTilesFull(r,c);
		
		for(Tile t : adjacent) {
			if(hasElement(t.getXCoord(),t.getYCoord()) && (!getTile(r,c).getElement().getRace().equals(race))) {
				occupiedAdjacent.add(t);
			}
		}
		System.out.println(occupiedAdjacent);
		return occupiedAdjacent;
	}
	public boolean isValid(int r, int c) {
		if(r < 0 || c < 0 || r >= numRow || c >= numCol) {
			return false;
		}
		Tile tile = grid[r][c];
		if(tile == null){
			return false;
		}
		else {
			return true;
		}
		
	}
	public void paintComponent(Graphics g) {
		
		//Graphics2D g2d = (Graphics2D) g;
		for(int row = 0; row < numRow; row++) {
			for(int col = 0; col < numCol; col++) {
				grid[row][col].paintComponent(g);
				if(grid[row][col].hasElement()){
					grid[row][col].getElement().paintComponent(g);
					//System.out.println(grid[row][col].getElement());
				}
			}
		}
	}
}