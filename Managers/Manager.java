package Managers;

import Grid.GameGrid;
import Element.Tile;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Manager extends JFrame implements ActionListener{
	final static int maxGap = 20;
	
	JButton deselectButton;
	JButton moveButton;
	JButton attackButton;
	JButton endTurnButton;
	
	GridLayout controlLayout = new GridLayout(0, 4);//deselect, move, attack, endturn buttons
	public Manager(String name) {
		super(name);
		setResizable(false);
	}
	
	public void initButtons(){
		deselectButton = new JButton("Deselect");
		deselectButton.setActionCommand("deselect");
		
		moveButton = new JButton("Move");
		moveButton.setActionCommand("move");
		
		attackButton = new JButton("Attack");
		attackButton.setActionCommand("attack");
		
		endTurnButton = new JButton("End Turn");
		endTurnButton.setActionCommand("end turn");
		
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
	
		JPanel battleGround = new GameGrid(10, 10);
		battleGround.setPreferredSize(new Dimension(1000, 500));
		
		battleGround.getTile(0,0).highlightTile();
		
		pane.add(controls, BorderLayout.SOUTH);
		pane.add(new JSeparator(), BorderLayout.CENTER);
		pane.add(battleGround, BorderLayout.NORTH);
		
	}
	
	public void actionPerformed(ActionEvent e){
		
		switch(e.getActionCommand()) {
		
			case "deselect":
				break;
			
			case "move":
				break;
			
			case "attack":
				break;
			
			case "end turn":
				break;
				
			default:
				break;
		}
		
	}
	
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