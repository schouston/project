import java.awt.*;
import javax.swing.*;

public class CircleComp extends JComponent{

	
	private double radius = 20;
	double orbitalRad1 = 17 * 2;
	double orbitalRad2 = 31 *2;
	
	private int xLeft; //centre
	private int yTop; //centre
	private double theta = 0;
	private double theta2 = 180;
	double semimajorA = 31.1;
	double eccentricity = 0.23;
	double x;
	double y;
	double p = 49;
	double v = (10 * Math.PI * orbitalRad1) / p;
	
	
	double x2;
	double y2;
	double p2 = 121;
	double v2 = (10 * Math.PI * orbitalRad2) / p2;
	
	
	public CircleComp(){
		
		xLeft = 200;
		yTop = 200;
		
	}
	
	public void paintComponent(Graphics g){
		
		Graphics2D star = (Graphics2D) g;
		star.setColor(Color.yellow);
		star.fillOval(xLeft, yTop, 30, 30);
		
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.blue);
		g2.fillOval((int)x,(int) y, (int)radius, (int)radius);
		
		Graphics2D g22 = (Graphics2D) g;
		g22.setColor(Color.green);
		g22.fillOval((int)x2,(int) y2, (int)radius, (int)radius);
		
	}
	
	public void calculateRad(){
		
		
		
		double op1 = semimajorA * (1- Math.pow(eccentricity, 2));
		double op2 = 1 + (eccentricity * Math.cos(theta));
		orbitalRad1 = op1/op2;
		
	}
	
	public void moveCircle(){
		theta += Math.toRadians(v);
		theta2 += Math.toRadians(v2);
		//xLeft += dx;
		//yTop += dy;
		calculateRad();
		x  = orbitalRad1 *Math.cos(theta) + xLeft;
		y = orbitalRad1 *Math.sin(theta)  + yTop;
		x2 = orbitalRad2  *Math.cos(theta2) + xLeft;
		y2 = orbitalRad2 *Math.sin(theta2)  + yTop;
		
		
		repaint();
		
	}

}
