import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import javax.swing.*;

import java.awt.event.ActionEvent;

//import CircleFrame.TimerListener;



public class ExoDisplay extends JPanel{

	private int FRAME_WIDTH = 600;
	private int FRAME_HEIGHT = 600;
	
	private ExoManager exoManager;
	private Planet[] planetArray;
	
	public ExoDisplay(ExoManager m){
		
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setTitle("Star System GUI");
		exoManager = m;
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setVisible(true);
		//JPanel exoPanel = new JPanel();
		setBackground(Color.black);
		
	}
	

public void paintComponent(Graphics g){
	
	super.paint(g);
	
		planetArray = exoManager.getPlanetArray();
		
	for (Planet planet : planetArray){
		
		planet.calculateRad();
		planet.calculateVelocity();
		planet.movePlanet();
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.blue);
		g2.fillOval((int)planet.getPosition().getX(),(int) planet.getPosition().getY(), (int)planet.getPlanetaryRad(), (int)planet.getPlanetaryRad());
	}
		
	}
}
