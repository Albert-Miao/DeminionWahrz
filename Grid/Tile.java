package Grid;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Tile {
	
	private int xPos;
	private int yPos;
	private int height;
	private int width;
	private BufferedImage image;
	private String imageName;
	private int row;
	private int col;
	
	public Tile(int x, int y, int w, int h, String imagename) {
		xPos = x;
		yPos = y;
		width = w;
		height = h;
		imageName = imagename;
		try {
			image = ImageIO.read(getClass().getResourceAsStream(imageName));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawRect(xPos, yPos, width, height);
		g2d.drawImage(image,50,50,50,50,null);
	}
	public void setCoords(int r, int c){
		row = r;
		col = c;
	}
	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}
	public void appearMovable() { //WIP
		
	}
}
