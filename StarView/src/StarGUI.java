import java.awt.*;
//import java.awt.event.*;
import java.awt.Toolkit;
import javax.swing.*;



public class StarGUI extends JFrame {
	
	private JPanel west, centre, south;
	//private StarCanvas canvas;
	private JTextArea dataDisplay;
	private JLabel searchLabel, filterDistLabel, filterMagLabel, projectionLabel;
	public JTextField searchbox;
	public JButton returnButton, systemButton, exoButton, helpButton;
	public JComboBox<String> distBox, magBox, projBox;
	private DisplayPanel mainDisplay;
	
	public JMenu distMenu;
	
	
	
	private StarManager manager;
	//private CreateStars stars;
	private StarController controller;
	
	final int FRAME_WIDTH = 1900;
	final int FRAME_HEIGHT =1150;
	
	
	public StarGUI(StarController c, StarManager m, DisplayPanel d){
		
		manager = m;
		controller = c;
		mainDisplay = d;
		
		Toolkit tool = Toolkit.getDefaultToolkit();
		int xSize = (int) tool.getScreenSize().getWidth();
		int ySi = (int) tool.getScreenSize().getHeight();
		setSize(xSize, ySi);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("StarView GUI");
		//pack();
		//setSize(FRAME_WIDTH, FRAME_HEIGHT);
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
		west = new JPanel(new BorderLayout());
		//BorderLayout border = new BorderLayout();
		//west.setLayout(border);
		//west.setSize(100, 400);
		west.setBackground(Color.gray);
		Font font = new Font("Verdana", Font.PLAIN, 12);
		dataDisplay = new JTextArea();
		dataDisplay.setFont(font);
		dataDisplay.setBackground(Color.lightGray);
		dataDisplay.setEditable(false);
		//dataDisplay.setLayout();
		dataDisplay.append(manager.printSunData());
		
		//JButton returnButton = new JButton("Centre on sun");
		Font buttonfont = new Font("Verdana", Font.BOLD, 14);
		JPanel buttonPanel = new JPanel(new GridLayout(4,1));
		returnButton = new JButton("Centre Display");
		returnButton.setFont(buttonfont);
		returnButton.addActionListener(controller);
		systemButton = new JButton("View Star System");
		systemButton.addActionListener(controller);
		systemButton.setFont(buttonfont);
		exoButton = new JButton("View Planetary System");
		exoButton.addActionListener(controller);
		exoButton.setFont(buttonfont);
		helpButton = new JButton("User Guide");
		helpButton.setFont(buttonfont);
		helpButton.addActionListener(controller);
		///returnButton.setSize(2,2);
		buttonPanel.add(returnButton);//, BorderLayout.SOUTH);
		buttonPanel.add(systemButton);//, BorderLayout.NORTH);
		buttonPanel.add(exoButton);//, BorderLayout.CENTER);
		buttonPanel.add(helpButton);//, BorderLayout.CENTER);
	
		west.add(dataDisplay, BorderLayout.NORTH);
		west.add(buttonPanel, BorderLayout.SOUTH);
		//west.add(returnButton, BorderLayout.SOUTH);
		this.add(west, BorderLayout.WEST);
	}
	
	public void layoutCentre(){

		mainDisplay.addMouseListener(controller);
		mainDisplay.addMouseWheelListener(controller);
		mainDisplay.setPreferredSize(new Dimension(1600, 1600));
		
		JScrollPane scroll = new JScrollPane(mainDisplay,  ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		//scroll.addMouseWheelListener(controller);
		this.add(scroll, BorderLayout.CENTER);
		//this.getContentPane().add(scroll);
		//this.add(mainDisplay, BorderLayout.CENTER);
		
		
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
		Font font = new Font("Verdana", Font.BOLD, 12);
		searchLabel = new JLabel("Search");
		searchLabel.setFont(font);
		searchLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		searchbox = new JTextField();
		searchbox.addActionListener(controller);
		searchbox.setBorder(BorderFactory.createLineBorder(Color.black));
		searchbox.setSize(10, 10);
		searchbox.setText("enter name here");
		filterDistLabel = new JLabel("Filter by distance");
		filterDistLabel.setFont(font);
		filterDistLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		projectionLabel = new JLabel("Projection Type");
		projectionLabel.setFont(font);
		projectionLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel blank = new JLabel("");
		JLabel blank1 = new JLabel("");
		filterMagLabel = new JLabel("Filter by magnitude");
		filterMagLabel.setFont(font);
		filterMagLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		/*distMenu = new JMenu("dist filter");
		JMenuItem ten = new JMenuItem("upto 10");
		JMenuItem five = new JMenuItem("upto 5");
		distMenu.add(ten);
		distMenu.add(five);*/
		
		String [] filtDStrings = { "all", "upto 5pc", "upto 7pc", "upto 10pc", "upto 20pc", "upto 30pc"};
		distBox = new JComboBox<String>(filtDStrings);
		distBox.addActionListener(controller);
		//distBox.addItem("up to 5");
		//distBox.addItem("up to 10");
		String [] filtMStrings = {"all","upto 10", "upto 7", "upto 3"};
		magBox = new JComboBox<String>(filtMStrings);
		magBox.addActionListener(controller);
		//magBox.addItem("upto 10");
		//magBox.addItem("upto 20");
		String [] projStrings = { "Hammer-Aitoff", "Mercator", "Cylindrical Equal Area", "Orthographic"};
		projBox = new JComboBox<String>(projStrings);
		projBox.addActionListener(controller);
		south.add(searchLabel);
		south.add(projectionLabel);
		//south.add(blank);
		
		south.add(filterDistLabel);
		south.add(filterMagLabel);
		//south.add(distMenu);
		
		south.add(searchbox);
		south.add(projBox);
		//south.add(blank1);
		south.add(distBox);
		south.add(magBox);
		
		this.add(south, BorderLayout.SOUTH);
	}
	
	//method to display data on selected star
	public void updateDataDisplay(int index){
		dataDisplay.setText("");	
		if (index == -1)
			dataDisplay.append(manager.printSunData());
		else
			dataDisplay.append(manager.printStarData(index));
	}
	
}
