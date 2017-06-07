package Managers;

import Grid.GameGrid;
import Grid.GameGrid.GameMode;
import Element.Tile;
import Element.Unit;
import Element.Element;
import Element.Element.Race;
import Element.Pieces.*;
import java.awt.*;
import javax.swing.JOptionPane;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.*;

public class Manager extends JFrame implements ActionListener, MouseListener{
	final static int maxGap = 20;
	
	JButton deselectButton;
	JButton moveButton;
	JButton attackButton;
	JButton endTurnButton;
	
	private ArrayList<Tile> lighted = new ArrayList<Tile>();
	private ArrayList<Tile> attackable = new ArrayList<Tile>();
	private Race victor;
	
	private GameGrid battleGround;
	
	GridLayout controlLayout = new GridLayout(0, 4);//deselect, move, attack, endturn buttons
	public Manager(String name) {
		super(name);
		setResizable(false);
	}
	
	public void initButtons(){
		deselectButton = new JButton("Deselect");
		deselectButton.setActionCommand("deselect");
		deselectButton.setEnabled(false);
		
		moveButton = new JButton("Move");
		moveButton.setActionCommand("move");
		moveButton.setEnabled(false);
		
		attackButton = new JButton("Attack");
		attackButton.setActionCommand("attack");
		attackButton.setEnabled(false);
		
		endTurnButton = new JButton("End Turn");
		endTurnButton.setActionCommand("end turn");
		endTurnButton.setEnabled(true);
		
		deselectButton.addActionListener(this);
		moveButton.addActionListener(this);
		attackButton.addActionListener(this);
		endTurnButton.addActionListener(this);
	}
	
	public void addComponentsToPane(final Container pane) {
		
		initButtons();
		
		final JPanel controls = new JPanel();
		controls.setLayout(controlLayout);
		
		JButton b = new JButton ("Fake Button");
		Dimension buttonSize = b.getPreferredSize();
		controls.setPreferredSize(new Dimension((int)(buttonSize.getWidth() * 4.5) + maxGap,
				(int)(buttonSize.getHeight() * 1.5) + maxGap));
		
		controls.add(deselectButton);
		controls.add(moveButton);
		controls.add(attackButton);
		controls.add(endTurnButton);
	
		battleGround = new GameGrid(10, 10);
		battleGround.setPreferredSize(new Dimension(500, 500));
		battleGround.addMouseListener(this);
		
		setupElements();
		
		battleGround.getTile(4,3).highlightTile();
		battleGround.getTile(4,3).unHighlightTile();
		
		pane.add(controls, BorderLayout.SOUTH);
		pane.add(new JSeparator(), BorderLayout.CENTER);
		pane.add(battleGround, BorderLayout.NORTH);
	}
	
	public void setupElements(){
		System.out.println("AZURE TURN");
		
		Unit firstE = new Spearman(5, 5, battleGround);
		Unit secondE = new Spearman(3, 7, battleGround);
		Unit thirdE = new Knight(4, 9, battleGround);
	}
	
	public void checkVictor() {
		//JOptionPane victoryMessage = new JOptionPane();
		victor = battleGround.getVictor();
		if(victor == Race.AZURE) {
			JOptionPane.showMessageDialog((JFrame) SwingUtilities.getWindowAncestor(battleGround),"AZURE WINS!");
		}
		else if(victor == Race.TOKKOKINO) {
			JOptionPane.showMessageDialog((JFrame) SwingUtilities.getWindowAncestor(battleGround),"AZURE WINS!");
		}
	}
	
	public void actionPerformed(ActionEvent e){
		
		switch(e.getActionCommand()) {
		
			case "deselect":
				battleGround.setMode(GameMode.DEFAULT);
				deselectButton.setEnabled(false);
				moveButton.setEnabled(false);
				attackButton.setEnabled(false);
				endTurnButton.setEnabled(true);
				if(battleGround.getSelected() != null) {
					battleGround.getTile(battleGround.getSelected().getXPos(), battleGround.getSelected().getYPos()).unHighlightTile();
				}
				battleGround.setSelected(null);
				for(Tile t : lighted) {
					t.unHighlightTile();
				}
				for(Tile t : attackable) {
					t.unHighlightTile();
				}
				lighted.clear();
				attackable.clear();
				battleGround.repaint();
				break;
			
			case "move":
				battleGround.setMode(GameMode.MOVE);
				moveButton.setEnabled(false);
				attackButton.setEnabled(false);
				endTurnButton.setEnabled(false);
				
				Element selected = battleGround.getSelected();
				Unit selectedUnit = (Unit) selected;
				lighted.addAll(selectedUnit.getMovable());
				for(Tile t : lighted) {
					t.highlightTile();
				}
				battleGround.repaint();
				break;
			
			case "attack":
				battleGround.setMode(GameMode.ATTACK);
				moveButton.setEnabled(false);
				attackButton.setEnabled(false);
				endTurnButton.setEnabled(false);
				
				attackable.addAll(battleGround.getSelectedAsUnit().getRange());
				System.out.println(attackable);
				for(Tile t : attackable) {
					t.highlightTileRed();
				}
				battleGround.repaint();
				break;
			
			case "end turn":
				battleGround.switchTurn();
				for(int i = 0; i < battleGround.getRow(); i++){
					for(int j = 0; j < battleGround.getCol(); j++){
						if(battleGround.hasElement(i, j) && battleGround.getElement(i, j).getRace() == battleGround.getTurn()){
							battleGround.getElement(i, j).setAction(true);
						}
					}
				}
				checkVictor();
				break;
				
			default:
				break;
		}
		
	}
	
	public void mousePressed(MouseEvent e){
		int x = (int)(e.getX() / 50);
		int y = (int)(e.getY() / 50);
		//System.out.println(x + " " + y);
		if((x < battleGround.getRow() && y < battleGround.getCol()) &&
				battleGround.hasElement(x, y) &&
				battleGround.getElement(x, y).getRace() == battleGround.getTurn() &&
				battleGround.getElement(x, y).hasAction() &&
				battleGround.getMode() != GameMode.MOVE &&
				battleGround.getMode() != GameMode.ATTACK){
			if(battleGround.getSelected() == null){
				battleGround.setMode(GameMode.SELECTED);
				deselectButton.setEnabled(true);
				moveButton.setEnabled(true);
				attackButton.setEnabled(true);
				endTurnButton.setEnabled(false);
			} else{
				battleGround.getTile(battleGround.getSelected().getXPos(), battleGround.getSelected().getYPos()).unHighlightTile();
			}
			battleGround.setSelected(battleGround.getElement(x, y));
			battleGround.getTile(battleGround.getSelected().getXPos(), battleGround.getSelected().getYPos()).highlightTile();
			battleGround.repaint();
		}else if((x < battleGround.getRow() || y < battleGround.getCol()) && //Move
				battleGround.getMode() == GameMode.MOVE &&
				!battleGround.hasElement(x, y)){
			battleGround.getTile(battleGround.getSelected().getXPos(), battleGround.getSelected().getYPos()).unHighlightTile();
			battleGround.getSelected().moveTo(x, y);
			battleGround.getSelected().setAction(false);
			//System.out.println(battleGround.getSelected());
			battleGround.setSelected(null);
			for(Tile t : lighted) {
				t.unHighlightTile();
			}
			lighted.clear();
			
			battleGround.setMode(GameMode.DEFAULT);
			deselectButton.setEnabled(false);
			endTurnButton.setEnabled(true);
			battleGround.repaint();
		}
		else if( (x < battleGround.getRow() || y < battleGround.getCol()) && battleGround.getMode() == GameMode.ATTACK && //Attack
				battleGround.getSelected() instanceof Unit) {
			battleGround.getSelectedAsUnit().attack(battleGround.getElement(x, y));
			battleGround.getSelected().setAction(false);
			System.out.println("Attacked!");
			
			for(Tile t : attackable) {
				t.unHighlightTile();
			}
			lighted.clear();
			for(Tile t : lighted) {
				t.unHighlightTile();
			}
			attackable.clear();
			
			battleGround.getTile(battleGround.getSelected().getXPos(),battleGround.getSelected().getYPos()).unHighlightTile();
			battleGround.setSelected(null);
			battleGround.setMode(GameMode.DEFAULT);
			attackButton.setEnabled(false);
			deselectButton.setEnabled(false);
			endTurnButton.setEnabled(true);
			battleGround.repaint();
		}
	}
	
	public void mouseClicked(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	
	private static void createAndShowGUI(){
		Manager frame = new Manager("DeminionWahrz");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addComponentsToPane(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args){
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (UnsupportedLookAndFeelException ex){
			ex.printStackTrace();
		} catch (IllegalAccessException ex){
			ex.printStackTrace();
		} catch (InstantiationException ex){
			ex.printStackTrace();
		} catch (ClassNotFoundException ex){
			ex.printStackTrace();
		}
		
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				createAndShowGUI();
			}
		});
	}
}