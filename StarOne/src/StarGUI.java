import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JComponent;



public class StarGUI extends JFrame {
	
	private JPanel west, centre, south;
	private StarCanvas canvas;
	private JTextArea dataDisplay;
	private JLabel searchLabel, filterLabel;
	private JTextField searchbox;
	private JComboBox distCBox, magCBox;
	
	
	private StarManager manager;
	private CreateStars stars;
	private StarController controller;
	
	final int FRAME_WIDTH = 1100;
	final int FRAME_HEIGHT = 900;
	
	
	public StarGUI(){
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Star Test GUI");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		inputStars();
		layoutWest();
		layoutCentre();
		layoutSouth();
		//DrawPoint point = new DrawPoint();
		//this.add(point);		
	}
	
	public void inputStars(){
		stars = new CreateStars();
		stars.createHippStars();
		manager = stars.getManager();
		
	}
	
	public void layoutWest(){
		west = new JPanel();
		west.setSize(1000, 400);
		west.setBackground(Color.gray);
		dataDisplay = new JTextArea();
		dataDisplay.setBackground(Color.lightGray);
		//dataDisplay.setLayout();
		dataDisplay.append(manager.printStarData(2));
		west.add(dataDisplay);
		this.add(west, BorderLayout.WEST);
	}
	
	public void layoutCentre(){
		
		controller = new StarController();
		canvas = new StarCanvas(manager);
		canvas.setBackground(Color.black);
		canvas.addMouseListener(controller);
		
		
		//DrawPoint points = new DrawPoint(manager);
		//canvas.paint(points,BorderLayout.CENTER);
		this.add(canvas, BorderLayout.CENTER);
		
		/*centre = new JPanel();
		centre.setLayout(new BorderLayout());
		centre.setBackground(Color.black);
		DrawPoint point = new DrawPoint(manager);
		centre.add(point, BorderLayout.CENTER);
		this.add(centre, BorderLayout.CENTER);*/
	}
	
	public void layoutSouth(){
		south = new JPanel();
		south.setBorder(BorderFactory.createLineBorder(Color.cyan));
		GridLayout grid = new GridLayout(0,4);
		
		south.setBackground(Color.lightGray);
		south.setLayout(grid);
		searchLabel = new JLabel("Search");
		searchLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		searchbox = new JTextField();
		searchbox.setSize(10, 10);
		searchbox.setText("enter crap here");
		filterLabel = new JLabel("Filter");
		filterLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel blank = new JLabel("");
		JLabel blank1 = new JLabel("");
		JLabel blank2 = new JLabel("");
		distCBox = new JComboBox();
		magCBox = new JComboBox();
		south.add(searchLabel);
		south.add(blank);
		south.add(filterLabel);
		south.add(distCBox);
		south.add(searchbox);
		south.add(blank1);
		south.add(blank2);
		south.add(magCBox);
		
		
		this.add(south, BorderLayout.SOUTH);
	}
	
}
