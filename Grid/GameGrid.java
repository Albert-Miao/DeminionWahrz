package Grid;

import javax.swing.JPanel;
import Element.Tile;
import Element.Element;
import Element.Element.Race;
import Element.Unit;

import java.util.ArrayList;
import java.awt.*;
import java.net.URL;

import Element.Tiles.*;

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
	Race victor;
	
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
				Tile t = new Regular(i, k);
				grid[i][k] = t;
			}
		}
		
		setStartingBoard();
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
	public Race getVictor() {
		int tokCount = 0;
		int azuCount = 0;
		for(int i = 0; i < grid.length;i++) {
			for(int k = 0; k < grid[0].length; k++) {
				if(hasElement(i,k) && grid[i][k].getElement().getRace().equals(Race.TOKKOKINO)) {
					tokCount++;
				}
				if(hasElement(i,k) && grid[i][k].getElement().getRace().equals(Race.AZURE)) {
					azuCount++;
				}
			}
		}
		if(azuCount == 0 && tokCount > 0) {
			victor = Race.TOKKOKINO;
			}
		else if(tokCount == 0 && azuCount > 0) {
			victor =  Race.AZURE;
			}
		else {
			victor = null;
		}
		
		return victor;
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
	
	public Unit getElementAsUnit(int r, int c) {
		return (Unit)grid[r][c].getElement();
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
	
	public void setStartingBoard(){
		
		grid[1][2] = new Desert(1, 2);
		grid[2][2] = new Desert(2, 2);
		grid[3][2] = new Desert(3, 2);
		grid[6][2] = new Desert(6, 2);
		grid[7][2] = new Desert(7, 2);
		grid[8][2] = new Desert(8, 2);
		grid[1][7] = new Desert(1, 7);
		grid[2][7] = new Desert(2, 7);
		grid[3][7] = new Desert(3, 7);
		grid[6][7] = new Desert(6, 7);
		grid[7][7] = new Desert(7, 7);
		grid[8][7] = new Desert(8, 7);
		
		grid[1][4] = new Mountain(1, 4);
		grid[4][4] = new Mountain(4, 4);
		grid[5][5] = new Mountain(5, 5);
		grid[8][5] = new Mountain(8, 5);
		grid[2][5] = new Mountain(2, 5);
		grid[3][5] = new Mountain(3, 5);
		grid[6][4] = new Mountain(6, 4);
		grid[7][4] = new Mountain(7, 4);
		
		grid[3][4] = new Forest(3, 4);
		grid[6][5] = new Forest(6, 5);
		grid[5][4] = new Forest(5, 4);
		grid[4][5] = new Forest(4, 5);
		grid[4][7] = new Forest(4, 7);
		grid[5][2] = new Forest(5, 2);
	}
	
	public void paintComponent(Graphics g) {
		
		//Graphics2D g2d = (Graphics2D) g;
		for(int row = 0; row < numRow; row++) {
			for(int col = 0; col < numCol; col++) {
				grid[row][col].paintComponent(g);
				if(grid[row][col].hasElement()){
					grid[row][col].getElement().paintComponent(g);
					grid[row][col].modUnit();
					//System.out.println(grid[row][col].getElement());
				}
			}
		}
	}
}