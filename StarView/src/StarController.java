import java.awt.event.*;
import java.awt.geom.Point2D;

//class to listen for events. also creates gui object
public class StarController implements MouseListener, ActionListener{

	private StarManager manager;
	private StarGUI gui;
	//private StarCanvas canvas;
	private DisplayPanel display;

	private boolean distFilterBoolean = false;
	private boolean magFilterBoolean = false;

	private int filterFlag;			//0 no filter, 1 dist filter, 2 mag filter
	private int distFilterInt;		//integer to pass as parameter for distance filter
	private int magFilterInt;		//integer to pass as parameter for magnitude filter

	public StarController(StarManager m){

		manager = m;
		display = new DisplayPanel(manager, this);
		gui = new StarGUI(this, manager, display);
		gui.setVisible(true);
		filterFlag = 0;
		//canvas = c;
		//display = d;
	}

	public void mousePressed(MouseEvent e){

	}

	public void mouseClicked(MouseEvent e){

		if ( e.getX() >= display.getXdisplacement()-5  && e.getX() <= display.getXdisplacement()+5 && e.getY() >= display.getYdisplacement()-5 
				&& e.getY() <= display.getYdisplacement()+5 )
			gui.updateDataDisplay(-1);
		else{
			Star [] stars = manager.getStarArray();

			for (int i = 0; i < stars.length; i++){	
				double x = stars[i].getCartX() + ( display.getXdisplacement());
				double y = stars[i].getCartY() + (display.getYdisplacement());
				if ( e.getX() >= x-2  && e.getX() <= x+2 && e.getY() >= y-2 && e.getY() <= y+2 ){

					//if (e.getX() == stars[i].getCartX() && e.getY() == stars[i].getCartY()){
					System.out.println("hit");
					gui.updateDataDisplay(i);
					//display.resetCoords(d);
				}
			}

		}
		//System.out.println(stars[0].getCartX());
		System.out.println(e.getX());
		//System.out.println(stars[0].getCartY());
		System.out.println(e.getY());
		//System.out.println("press");

	}

	public void mouseEntered(MouseEvent e){

	}

	public void mouseReleased(MouseEvent e){

	}

	public void mouseExited(MouseEvent e){

	}

	public void actionPerformed(ActionEvent e){

		if (e.getSource() == gui.systemButton){
			SystemDisplay systemDis = new SystemDisplay();				//create system display window	
		}
		
		if (e.getSource() == gui.exoButton){							//create exoplanet display window
			ExoDisplay exoDis = new ExoDisplay();
		
		}

		if (e.getSource() == gui.returnButton){							//return main display to 0
			display.setcoords();
			display.repaint();
			gui.updateDataDisplay(-1);
		}
		
		if (e.getSource() == gui.searchbox) {							//search for star
			//manager.searchStarArray(gui.searchbox.getText().trim());
			Point2D.Double point = manager.searchStarArray(gui.searchbox.getText().trim());
			gui.searchbox.setText("");

			display.resetCoords(point);
			display.repaint();
			gui.updateDataDisplay(manager.getSearchIndex());
		}
		
		if (e.getSource() == gui.distBox){							//distance filter

			filterFlag = 1;
			//manager.filterSelected = true;
			String selectedString = (String) gui.distBox.getSelectedItem();
			if(selectedString.equals("upto 5pc"))
				distFilterInt = 5;
			else if(selectedString.equals("upto 7pc"))
				distFilterInt = 7;
			else 
				filterFlag = 0;

			//filtArray = manager.getDistanceFilterArray(1);
			//	if(selectedString.equals("upto 10"))
			//	manager.getDistanceFilterArray(10);
			display.repaint();
			//System.out.println("repainted!");
			//manager.filterSelected = false;
		}

		if (e.getSource() == gui.magBox){										//magnitude filter
			filterFlag = 2;
			String selectedString = (String) gui.magBox.getSelectedItem();
			if(selectedString.equals("upto 7"))
				magFilterInt = 7;
			else if(selectedString.equals("upto 3"))
				magFilterInt = 3;
			else 
				filterFlag = 0;

			display.repaint();

		}
		
	}
	
	public int getFilterFlag(){												//return method for filter flag
		return filterFlag;
	}
	
	public int getDistFilterInt(){ return distFilterInt;}					//return parameter for distance filter
	public int getMagFilterInt(){return magFilterInt;}						//return parameter for magnitude filter


}
