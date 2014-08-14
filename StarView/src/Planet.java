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
	private double parentRadius;
	private int discoveryDate;
	private String discoveryMethod;
	
	private double xpos;
	private double ypos;
	
	private int xLeft; //centre
	private int yTop; //centre
	
	
	public Planet(String n, double pr, double or, double op, double e, int d, String m,String pn, double parR){
		
		name = n;
		planetaryRad = pr * 100;
		System.out.println(name);
		System.out.println(or);
		semimajorA = or;
		orbitalPeriod = op;
		eccentricity = e;
		discoveryDate = d;
		discoveryMethod = m;
		parentName = pn;
		parentRadius = parR;
		xpos = 0;
		ypos = 0;
		theta = 0;
		position = new Point2D.Double(xpos, ypos);
		
		calcDisRad();
		//xLeft = 300;
		//yTop = 300;
	}
	
	public void calcDisRad(){
		
		if (semimajorA < 0.1) semimajorA  = semimajorA* 10000;
		else if (semimajorA < 1) semimajorA  = semimajorA* 1000;
		else if (semimajorA > 100) semimajorA  = semimajorA / 10;
	}
	
public void calculateRad(){
		
		double op1 = semimajorA * (1- Math.pow(eccentricity, 2));
		double op2 = 1 + (eccentricity * Math.cos(theta));
		orbitalRad = (op1/op2) ;
	}

	public void calculateVelocity(){
		orbitalVelocity = ((2 * Math.PI * orbitalRad) / orbitalPeriod);
	}
	
	public void movePlanet(){
		
		theta += Math.toRadians(orbitalVelocity);
		xpos  = (orbitalRad *Math.cos(theta)); //+ xLeft);
		ypos = (orbitalRad *Math.sin(theta))  ; //+ yTop);
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
	
	public double getStarScaleFactor(){
		
		return parentRadius;
		
	}
	
	public void setDisplayRadius(){
		 
		double disRad = orbitalRad;
	}
	
	
	
	public int getParentRadius(){
		
		double interRadius = parentRadius *100;
		int returnRadius = (int) interRadius;
		
		return returnRadius;}
	
	public int getDisDate(){return discoveryDate;}
	public String getDisMeth(){return discoveryMethod;}
	

}
