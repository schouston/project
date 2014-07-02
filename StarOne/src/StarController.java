import java.awt.event.*;

public class StarController implements MouseListener{
	
	private StarManager manager;
	private StarGUI gui;
	//private StarCanvas canvas;
	private DisplayPanel display;
	
	public StarController(StarManager m, StarGUI g, DisplayPanel d){
	
		
		manager = m;
		gui = g;
		//canvas = c;
		display = d;
	}
	
	public void mousePressed(MouseEvent e){
		
	}
	
	public void mouseClicked(MouseEvent e){
		
		Star [] stars = manager.getStarArray();
		
		for (int i = 0; i < stars.length; i++){	
			double x = stars[i].getCartX() + ( display.getXdisplacement());
			double y = stars[i].getCartY() + (display.getYdisplacement());
			if ( e.getX() >= x-2  && e.getX() <= x+2 && e.getY() >= y-2 && e.getY() <= y+2 ){
			
		//if (e.getX() == stars[i].getCartX() && e.getY() == stars[i].getCartY()){
			System.out.println("hit");
			gui.updateDataDisplay(i);
		}
			
		}
		System.out.println(stars[0].getCartX());
		System.out.println(e.getX());
		System.out.println(stars[0].getCartY());
		System.out.println(e.getY());
		System.out.println("press");
		
	}
	
	public void mouseEntered(MouseEvent e){
		
	}

	public void mouseReleased(MouseEvent e){
		
	}
	
	public void mouseExited(MouseEvent e){
		
	}
}
