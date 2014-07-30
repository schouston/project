import java.awt.*;
import java.awt.geom.Point2D;
import javax.swing.*;

public class Planet {
	
	private String name;
	private double planetaryRad;
	private double semimajorA;
	private double orbitalRad;
	private double orbitalPeriod;
	private double orbitalVelocity;
	private double theta;
	private double eccentricity;
	private Point2D.Double position;
	private Star parentStar;
	private String parentName;
	private int discoveryDate;
	private String discoveryMethod;
	
	private double xpos;
	private double ypos;
	
	private int xLeft; //centre
	private int yTop; //centre
	
	
	public Planet(String n, double pr, double or, double op, double e, int d, String m,String pn){
		
		name = n;
		planetaryRad = pr * 100;
		semimajorA = or *100 ;
		orbitalPeriod = op;
		eccentricity = e;
		discoveryDate = d;
		discoveryMethod = m;
		parentName = pn;
		xpos = 0;
		ypos = 0;
		theta = 0;
		position = new Point2D.Double(xpos, ypos);
		
		xLeft = 200;
		yTop = 200;
	}
	
public void calculateRad(){
		
		double op1 = semimajorA * (1- Math.pow(eccentricity, 2));
		double op2 = 1 + (eccentricity * Math.cos(theta));
		orbitalRad = (op1/op2) ;
	}

	public void calculateVelocity(){
		orbitalVelocity = ((10 * Math.PI * orbitalRad) / orbitalPeriod)/10;
	}
	
	public void movePlanet(){
		
		theta += Math.toRadians(orbitalVelocity);
		xpos  = (orbitalRad *Math.cos(theta) + xLeft);
		ypos = (orbitalRad *Math.sin(theta) + yTop);
		position = new Point2D.Double(xpos, ypos);
		//repaint();
	}
	
	public Point2D getPosition(){
		
		return position;
		
	}
	
	public double getPlanetaryRad(){
		return planetaryRad;
	}
	
	public String getName(){
		return name;
	}
	
	public String getParent(){
		return parentName;
	}
	
	public int getDisDate(){return discoveryDate;}
	public String getDisMeth(){return discoveryMethod;}
	

}
