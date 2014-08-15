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
	private double scale = 2;

	private Star[] drawArray;

	public DisplayPanel(StarManager m, StarController c){

		manager = m;
		controller = c;
		
		this.setBounds(0, 0, 1700, 1000);
		this.setcoords();
		
		this.setBackground(Color.black);
		this.repaint();
		this.setLayout(null);
		
		
		
	}

	public double getXdisplacement(){ return xdis;}
	public double getYdisplacement(){return ydis;}
	public double getScale(){return scale;}

	// method to set (0,0) on display
	public void setcoords(){

		height = this.getHeight();
		width = this.getWidth();
		xdis = (width/2);
		ydis = (height/2);
		xdisSearch = xdis;
		ydisSearch = ydis;
		
		
		System.out.println("width: " + width);
	System.out.println("height: " + height);
		//System.out.println(getSize());
	}
	
	public void setCircleCoords(double x, double y){
		
		resetCoords();
		xdisSearch += x;
		ydisSearch += y;
	}

	public void resetCoords(){
		//xdis -= d.x;
		//ydis -= d.y;
		xdisSearch = xdis;
		ydisSearch = ydis;
		//System.out.println("point xy: " + d.x + " : " + d.y);
		
		//double x = xdis - xdisSearch;
		//double y = ydis - ydisSearch;
		//System.out.println("x y dis : "+ xdis + " : " + ydis);		
		//System.out.println("xySearch: "+xdisSearch +" : " +ydisSearch);
		//System.out.println(" xydis - search dis: "+ x +" : " + y);
		


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
		//resetCoords(controller.getSelectedStar().getCartX(), controller.getSelectedStar().getCartY());
		Graphics2D searchg = (Graphics2D) g;
		Ellipse2D.Double searchCircle = new Ellipse2D.Double(xdisSearch - 10, ydisSearch - 10, 20, 20);
		searchg.setColor(Color.cyan);
		searchg.draw(searchCircle);

		//AffineTransform tform = AffineTransform.getTranslateInstance(width/2, height);
		
		if(controller.getFilterFlag() == 1){
			drawArray = manager.getFilterArray(controller.getDistFilterInt(), controller.getMagFilterInt());
			//System.out.println(drawArray);
			//System.out.println(drawArray.length);
		//	System.out.println(drawArray[0].getName());
		//	System.out.println(drawArray[0].getCartX());
			//System.out.println("here!!");
			//System.out.println("filt length: " + drawArray.length);
			//manager.filterSelected = false;
		}
		else if(controller.getFilterFlag() == 2){
			System.out.println("HERE");
			drawArray = manager.getFilterArray(controller.getDistFilterInt(), controller.getMagFilterInt());
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
			//System.out.println("HERE IN DRAW");
			Ellipse2D.Double point = new Ellipse2D.Double((star.getCartX() + xdis - (star.getCartZ()/2))*scale, (star.getCartY() + ydis - (star.getCartZ()/2))*scale, star.getCartZ(), star.getCartZ());
			g2.setColor(star.getDisplayColor());
			g2.fill(point);
			
			if (star.getCommonNameBool())
				g2.drawString(star.getName(), (int) ((star.getCartX() + xdis + 5)*scale), (int) ((star.getCartY() + ydis + 5)*scale));
			
		}
		
	}
	
}