import java.awt.*;
import java.awt.event.*;

import javax.swing.*;



public class StarGUI extends JFrame {
	
	private JPanel west, centre, south;
	//private StarCanvas canvas;
	private JTextArea dataDisplay;
	private JLabel searchLabel, filterLabel;
	private JTextField searchbox;
	private JComboBox<String> distBox, magBox;
	private DisplayPanel mainDisplay;
	
	
	private StarManager manager;
	//private CreateStars stars;
	private StarController controller;
	
	final int FRAME_WIDTH = 1400;
	final int FRAME_HEIGHT = 1000;
	
	
	public StarGUI(StarController c, StarManager m, DisplayPanel d){
		
		manager = m;
		controller = c;
		mainDisplay = d;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Star Test GUI");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		//inputStars();
		layoutWest();
		layoutCentre();
		layoutSouth();
		//DrawPoint point = new DrawPoint();
		//this.add(point);		
	}
	
	/*public void inputStars(){
		stars = new CreateStars();
		stars.createHippStars();
		manager = stars.getManager();
	}*/
	
	public void layoutWest(){
		west = new JPanel();
		//west.setSize(100, 400);
		west.setBackground(Color.gray);
		dataDisplay = new JTextArea();
		dataDisplay.setBackground(Color.lightGray);
		dataDisplay.setEditable(false);
		//dataDisplay.setLayout();
		dataDisplay.append(manager.printStarData(3));
		
	
		west.add(dataDisplay);
		this.add(west, BorderLayout.WEST);
	}
	
	public void layoutCentre(){

		mainDisplay.addMouseListener(controller);
		mainDisplay.setPreferredSize(new Dimension(1600, 1600));
		
		JScrollPane scroll = new JScrollPane(mainDisplay,  ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		this.add(scroll, BorderLayout.CENTER);
		//this.getContentPane().add(scroll);
		
		
		//canvas.setBackground(Color.black);
		//canvas.addMouseListener(controller);
		//DrawPoint points = new DrawPoint(manager);
		//canvas.paint(points,BorderLayout.CENTER);
		//this.add(canvas, BorderLayout.CENTER);		
		/*centre = new JPanel();
		centre.setLayout(new BorderLayout());
		centre.setBackground(Color.black);
		DrawPoint point = new DrawPoint(manager);
		centre.add(point, BorderLayout.CENTER);
		this.add(centre, BorderLayout.CENTER);*/
	}
	
	public void layoutSouth(){
		
		south = new JPanel();
		south.setBorder(BorderFactory.createLineBorder(Color.black));
		GridLayout grid = new GridLayout(0,4);
		
		south.setBackground(Color.lightGray);
		south.setLayout(grid);
		searchLabel = new JLabel("Search");
		searchLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		searchbox = new JTextField();
		searchbox.setBorder(BorderFactory.createLineBorder(Color.black));
		searchbox.setSize(10, 10);
		searchbox.setText("enter name here");
		filterLabel = new JLabel("Filter by distance");
		filterLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel blank = new JLabel("");
		JLabel blank1 = new JLabel("");
		JLabel blank2 = new JLabel("Filter by magnitude");
		blank2.setBorder(BorderFactory.createLineBorder(Color.black));
		distBox = new JComboBox<String>();
		distBox.addItem("up to 5");
		distBox.addItem("up to 10");
		magBox = new JComboBox<String>();
		magBox.addItem("upto 10");
		magBox.addItem("upto 20");
		south.add(searchLabel);
		south.add(blank);
		south.add(filterLabel);
		south.add(distBox);
		south.add(searchbox);
		south.add(blank1);
		south.add(blank2);
		south.add(magBox);
		
		this.add(south, BorderLayout.SOUTH);
	}
	
	//method to display data on selected star
	public void updateDataDisplay(int index){
		
		dataDisplay.setText("");		
		dataDisplay.append(manager.printStarData(index));
	}
	
}
