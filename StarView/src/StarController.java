import java.awt.event.*;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

import javax.swing.JOptionPane;

//class to listen for events. also creates gui object
public class StarController implements MouseListener, ActionListener, MouseWheelListener{

	private final int MAX_DIST = 50;				//Maximum distance for filter
	private final int MAX_MAG = 13;					//Maximum magnitude for filter

	private StarManager manager;
	private StarGUI gui;
	//private StarCanvas canvas;
	private DisplayPanel display;

	private boolean distFilterBoolean = false;
	private boolean magFilterBoolean = false;

	private int filterFlag;			//0 no filter, 1 dist filter, 2 mag filter
	private int distFilterInt = 25;		//integer to pass as parameter for distance filter
	private int magFilterInt = 13;		//integer to pass as parameter for magnitude filter

	private CreatePlanets createP;
	private boolean planetsDone = false;
	private Star selectedStar;

	public StarController(StarManager m){

		manager = m;
		selectedStar = manager.getStarArray()[0];
		display = new DisplayPanel(manager, this);


		gui = new StarGUI(this, manager, display);
		gui.setVisible(true);
		filterFlag = 0;
		//canvas = c;
		//display = d;
	}

	public Star getSelectedStar(){return selectedStar;}
	
	public void mouseWheelMoved(MouseWheelEvent e){
		int notches = e.getWheelRotation();
		
	//	if (notches < 0)
	}

	public void mousePressed(MouseEvent e){

	}

	public void mouseClicked(MouseEvent e){

		//if ( e.getX() >= display.getXdisplacement()-5  && e.getX() <= display.getXdisplacement()+5 && e.getY() >= display.getYdisplacement()-5 
		//	&& e.getY() <= display.getYdisplacement()+5 )
		//	gui.updateDataDisplay(-1);
		//	else{
		Star [] stars = manager.getStarArray();

		for (int i = 0; i < stars.length; i++){	
			double x = stars[i].getCartX() + ( display.getXdisplacement())*display.getScale();
			double y = stars[i].getCartY() + (display.getYdisplacement())* display.getScale();

			if ( e.getX() >= x-2  && e.getX() <= x+2 && e.getY() >= y-2 && e.getY() <= y+2 ){
				//if (e.getX() == stars[i].getCartX() && e.getY() == stars[i].getCartY()){
				//System.out.println("hit");
				Point2D.Double point = new Point2D.Double(stars[i].getCartX(), stars[i].getCartY());
				//System.out.println(point);
				display.setCircleCoords(stars[i].getCartX(), stars[i].getCartY());
				selectedStar = stars[i];
				display.repaint();
				gui.updateDataDisplay(i);




				//display.resetCoords(d);
			}
		}

		//}
		//System.out.println(stars[0].getCartX());
		//System.out.println(e.getX());
		//System.out.println(stars[0].getCartY());
		//System.out.println(e.getY());
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

			if (selectedStar.getInSystem()){

				SystemDisplay systemDis = new SystemDisplay();		
			}		//create system display window	

			else JOptionPane.showMessageDialog(null, selectedStar.getName() + " is not in a Star System");
		}

		else if (e.getSource() == gui.exoButton){							//create exoplanet display window

			this.processExoButton();

		}

		else if (e.getSource() == gui.returnButton){							//return main display to 0
			display.setcoords();
			display.repaint();
			gui.updateDataDisplay(-1);
		}

		else if (e.getSource() == gui.helpButton){
			UserGuide guide = new UserGuide();
		}

		else	if (e.getSource() == gui.searchbox) {							//search for star
			//manager.searchStarArray(gui.searchbox.getText().trim());
			String searchName = gui.searchbox.getText().trim();
			Point2D.Double point = manager.searchStarArray(searchName);
			gui.searchbox.setText("");

			if(manager.searchBool){

				display.setCircleCoords(point.x , point.y);
				System.out.println("points from controller: " + point.x +" : " + point.y);
				display.repaint();
				gui.updateDataDisplay(manager.getSearchIndex());
				selectedStar = manager.getStarArray()[manager.getSearchIndex()];}

			else
				JOptionPane.showMessageDialog(null, searchName + " could not be found");
		}

		else if (e.getSource() == gui.distBox){							//distance filter

			filterFlag = 1;
			//manager.filterSelected = true;
			String selectedString = (String) gui.distBox.getSelectedItem();
			if(selectedString.equals("upto 5pc"))
				distFilterInt = 5;
			else if(selectedString.equals("upto 7pc"))
				distFilterInt = 7;
			else if(selectedString.equals("upto 10pc"))
				distFilterInt = 10;
			else if(selectedString.equals("upto 20pc"))
				distFilterInt = 20;
			else if(selectedString.equals("upto 30pc"))
				distFilterInt = 30;
			else 
				distFilterInt = MAX_DIST;

			//filtArray = manager.getDistanceFilterArray(1);
			//	if(selectedString.equals("upto 10"))
			//	manager.getDistanceFilterArray(10);
			display.repaint();
			//System.out.println("repainted!");
			//manager.filterSelected = false;
		}

		else	if (e.getSource() == gui.magBox){										//magnitude filter
			filterFlag = 2;
			String selectedString = (String) gui.magBox.getSelectedItem();
			if(selectedString.equals("upto 10"))
				magFilterInt = 10;
			else if(selectedString.equals("upto 7"))
				magFilterInt = 7;
			else if(selectedString.equals("upto 3"))
				magFilterInt = 3;
			else 
				magFilterInt = MAX_MAG;

			display.repaint();

		}

		else if(e.getSource() == gui.projBox){

			String selectedString = (String) gui.projBox.getSelectedItem();


			Star [] stars = manager.getStarArray();
			

			for (int i = 0; i < stars.length; i++){	
				Star star = stars[i];
				
				MapProjection proj = new MapProjection(star.getRA(), star.getDec());
				if(selectedString.equals("Hammer-Aitoff")) star.setMapProjection(proj.setHAProjection()); //stars[i].setHAProjection();
				else if (selectedString.equals("Mercator"))star.setMapProjection(proj.setMetProj());
				else if (selectedString.equals("Cylindrical Equal Area"))star.setMapProjection(proj.setCylinProj());
				else if (selectedString.equals("Orthographic"))star.setMapProjection(proj.setOAProj());
				display.repaint();
			}

		}

	}

	public int getFilterFlag(){												//return method for filter flag
		return filterFlag;
	}

	public int getDistFilterInt(){ return distFilterInt;}					//return parameter for distance filter
	public int getMagFilterInt(){return magFilterInt;}						//return parameter for magnitude filter

	public void processExoButton(){
		if(!planetsDone){
			createP = new CreatePlanets();
			planetsDone = true;
		}
		//else
		//System.out.println("planets done");

		Planet[] planets = createP.getPlanetArray();
		Planet[] subPlanetSystem = new Planet[6];
		int planetCounter = 0;
		System.out.println(planets[0].getName());
		for (Planet planet : planets){
			System.out.println(planet.getName());
			if(planet.getParent().toUpperCase().equals(selectedStar.getName().toUpperCase()) || planet.getParent().toUpperCase().equals(selectedStar.getHDid())){
				subPlanetSystem[planetCounter] = planet;
				planetCounter ++;				
			}	
		}

		if (planetCounter == 0)
			JOptionPane.showMessageDialog(null, selectedStar.getName() + " does not have any known planets");
		//System.out.println("no planets");
		else{
			Planet[] displayPlanets = new Planet[planetCounter];

			for (int i = 0; i < planetCounter ;i++){
				displayPlanets[i] = subPlanetSystem[i];
			}

			ExoManager exoManager = new ExoManager(displayPlanets, selectedStar);
			exoManager.printPlanetData();
			//Planet p = new Planet("Kapteyn's c", 2, 0.311,121 ,0.23, 2014, "don't know!", "Kapteyn's");
			//System.out.println(p.getName());
			//Planet p1 = new Planet ("Kap's b", 2, 0.168, 48, 0.21, 2014, "don't know", "Kapteyn's");
			//	exoManager.addPlanet(p1);
			//.addPlanet(p);
			//ExoDisplay exoDis = new ExoDisplay(exoManager);
			ExoFrame exoFrame = new ExoFrame(exoManager);
		}
	}


}
