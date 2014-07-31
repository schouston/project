import java.awt.*;
//import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

import javax.swing.*;

//class to draw star display, taking each star in array and drawing on JPanel object

public class DisplayPanel extends JPanel{

	private StarManager manager;
	private StarController controller;

	private double width, height, xdis, ydis, xdisSearch, ydisSearch;

	private Star[] drawArray;

	public DisplayPanel(StarManager m, StarController c){

		manager = m;
		controller = c;
		this.setBounds(0, 0, 1600, 1600);
		this.setcoords();
		this.setBackground(Color.black);
		this.setLayout(null);
	}

	public double getXdisplacement(){ return xdis;}
	public double getYdisplacement(){return ydis;}

	// method to set (0,0) on display
	public void setcoords(){

		height = this.getHeight();
		width = this.getWidth();
		xdis = width/2;
		ydis = (height/2) - 250;
		
		xdisSearch = xdis;
		ydisSearch = ydis;
		//System.out.println("width: " + width);
	//	System.out.println("height: " + height);
		//System.out.println(getSize());
	}

	public void resetCoords(Point2D.Double d){
		//xdis -= d.x;
		//ydis -= d.y;
		
		xdisSearch += d.x;
		ydisSearch += d.y;


	}

	public void	paint(Graphics g){

		super.paint(g);
		
		//Dimension size = this.getSize();
		//g.translate(size.width/2, size.height/2);*/
		/*
		Graphics2D gs2 = (Graphics2D) g;
		Ellipse2D.Double sun = new Ellipse2D.Double(xdis, ydis, 10, 10);
		//gs2.translate(width/2, height/2);
		//gs2.translate(size.width/2, size.height/2);
		gs2.setColor(Color.yellow);
		gs2.fill(sun);
		*/
		
		Graphics2D searchg = (Graphics2D) g;
		Ellipse2D.Double searchCircle = new Ellipse2D.Double(xdisSearch - 10, ydisSearch - 10, 20, 20);
		searchg.setColor(Color.cyan);
		searchg.draw(searchCircle);

		//AffineTransform tform = AffineTransform.getTranslateInstance(width/2, height);
		
		if(controller.getFilterFlag() == 1){
			drawArray = manager.getDistanceFilterArray(controller.getDistFilterInt());
			//System.out.println(drawArray);
			//System.out.println(drawArray.length);
		//	System.out.println(drawArray[0].getName());
		//	System.out.println(drawArray[0].getCartX());
			//System.out.println("here!!");
			//System.out.println("filt length: " + drawArray.length);
			//manager.filterSelected = false;
		}
		else if(controller.getFilterFlag() == 2){
			drawArray = manager.getMagFilterArray(controller.getMagFilterInt());
			//System.out.println(drawArray);
			//System.out.println(drawArray.length);
			//System.out.println(drawArray[0].getName());
			//System.out.println(drawArray[0].getCartX());
			//System.out.println("here!!");
			//System.out.println("filt length: " + drawArray.length);
			//manager.filterSelected = false;
		}
		else{
			drawArray =  manager.getStarArray();
			//System.out.println("no filter: " +drawArray.length);
		}
		

		for (Star star : drawArray){

			Graphics2D g2 = (Graphics2D) g;
			
			//g2.setTransform(tform);
			//g2.translate(size.width/2, size.height/2);
			Ellipse2D.Double point = new Ellipse2D.Double(star.getCartX() + xdis - (star.getDisplaySize()/2), star.getCartY() + ydis - (star.getDisplaySize()/2), star.getDisplaySize(), star.getDisplaySize());
			/*if(star.getStellarClass().substring(0, 1).equals("O")) g2.setColor(Color.blue);
			else if (star.getStellarClass().substring(0, 1).equals("B"))g2.setColor(Color.lightGray);
			else if (star.getStellarClass().substring(0, 1).equals("A"))g2.setColor(Color.white);
			else if (star.getStellarClass().substring(0, 1).equals("F"))g2.setColor(Color.pink);
			else if (star.getStellarClass().substring(0, 1).equals("G"))g2.setColor(Color.yellow);
			else if (star.getStellarClass().substring(0, 1).equals("K"))g2.setColor(Color.orange);
			else if (star.getStellarClass().substring(0, 1).equals("M"))g2.setColor(Color.red);
			else if (star.getStellarClass().substring(0, 1).equals("L"))g2.setColor(Color.magenta);
			else g2.setColor(Color.yellow);*/
			g2.setColor(star.getDisplayColor());
			g2.fill(point);
			
			if (star.getCommonNameBool())
				g2.drawString(star.getName(), (int) (star.getCartX() + xdis + 5), (int) (star.getCartY() + ydis + 5));
		}
		setcoords();
	}
	
}