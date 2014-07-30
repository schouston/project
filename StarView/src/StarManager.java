import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

import javax.swing.JComponent;
import javax.swing.JOptionPane;


public class StarManager extends JComponent{

	//class to store array of Star Objects

	private final int SIZE = 935;  //array size
	private Star[] starArray;	//array of star objects
	public static int starArrayCounter = 0;	//counter for number of star objects entered
	private int searchIndex = 0;
	public boolean filterSelected = false;

	public StarManager(){

		starArray = new Star[SIZE];

	}

	public void addStar(Star s){

		Star star = s;
		starArray[starArrayCounter] = star;
		//System.out.println(starArrayCounter);
		starArrayCounter ++;
	}

	public void drawStar(){

	}

	public String printStarData(int i){

		int index = i;
		Star star = starArray[index];

		String name = "Name: ";
		String svid = "StarView ID: ";
		String hippid = "Hipp ID: ";
		String apmag = "Apparent Magnitude: ";
		String abmag = "Absolute Magnitude: ";
		String dist = "Distance(pc): ";
		String r = "Right Ascension: ";
		String d = "Declination: ";
		String temp = "Stellar Temperature(K): ";
		String type = "Spectral Type: ";
		String system = "In System: ";
		String hd = "henry draper: ";

		String starData = String.format("%s %s" + '\n' + "%s %d" + '\n' + "%s %s" + '\n' + "%s%.2f" + '\n' + "%s%.2f" + '\n' + "%s%.2f" + '\n' + "%s%.2f" + '\n' + "%s%.2f" + '\n' + "%s%.2f" + '\n'+
				"%s%s" + '\n' + "%s%s" + '\n' + "%s%s",name, star.getName(), svid, star.getSVid(), hippid, star.getID(), dist, star.getDistance(), apmag, star.getApMag(), abmag, star.getAbMag(), r, star.getRA(), d, star.getDec(), temp,
				star.getTemp(), type, star.getStellarClass(), system, star.getInSystem(), hd, star.getHDid())
				;
		//System.out.println(starData);	
		return starData;
	}

	public String printSunData(){

		//int index = i;
		//Star star = starArray[i];

		String name = "Name: ";
		String svid = "StarView ID: ";
		String hippid = "Hipp ID: ";
		String apmag = "Apparent Magnitude: ";
		String abmag = "Absolute Magnitude: ";
		String dist = "Distance(pc): ";
		String r = "Right Ascension: ";
		String d = "Declination: ";
		String temp = "Stellar Temperature(K): ";
		String type = "Spectral Type: ";
		

		String starData = String.format("%s%s" + '\n' + "%s %s" + '\n' + "%s %s" + '\n' + "%s%s" + '\n' + "%s%s" + '\n' + "%s%s" + '\n' + "%s%s" + '\n' + "%s%s" + '\n' + "%s%s" + '\n'+
				"%s%s"  ,name, "Sun", svid, "0", hippid,"0", dist, "0", apmag, "-26.74", abmag, "4.83", r, "0", d, "0", temp,
				"5778", type, "G2V")
				;
		//System.out.println(starData);	
		return starData;
	}

	public Star[] getStarArray(){
		return starArray;
	}

	public int getStarViewID(){return starArrayCounter;}

	public void paintComponent(Graphics g){

		for (Star star : starArray){

			Graphics2D g2 = (Graphics2D) g;
			Ellipse2D.Double point = new Ellipse2D.Double(star.getCartX(), star.getCartY(), 5, 5);
			g2.setColor(Color.yellow);
			g2.fill(point);
		}

	}

	public void setStarNames(){

		CommonNameProcessor pro = new CommonNameProcessor();
		pro.processNameFile();
		CommonNameManager nameManager = pro.getNameManager();

		for (int i = 0; i < SIZE; i++ ){
			//if (starArray[i].getID() == nameManager.getNamefromID(i);
			Object key = starArray[i].getID();

			//if(	nameManager.containsKey(key));

		}
	}

	public Point2D.Double searchStarArray(String s){

		for (int i= 0; i<SIZE; i++){
			Star star = starArray[i];
			if (star.getName().toUpperCase().equals(s.toUpperCase())){

				System.out.println(star.getName() + " is at position " + star.getCartX() + " " + star.getCartY());
				JOptionPane.showMessageDialog(this, star.getName() + " is at position " + star.getCartX() + " " + star.getCartY());
				Point2D.Double point = new Point2D.Double(star.getCartX(), star.getCartY());
				searchIndex = i;

				return point;
				//return true;
			}
			//else 
			//System.out.println("not found");
		}

		//System.out.println("not found");
		JOptionPane.showMessageDialog(this, s + " could not be found");
		return null;
	}

	public Point2D.Double getcoords(int i){

		Star star = starArray[i];
		Point2D.Double point = new Point2D.Double(star.getCartX(), star.getCartY());

		return point;
	}

	public int getSearchIndex(){
		return searchIndex;
	}

public Star[] getDistanceFilterArray(double d){
		
		//filterSelected = true;
		Star[] filterArray = new Star[SIZE];
		int counter = 0;
		
		for (int i = 0; i<SIZE; i++){

			if (starArray[i].getDistance() <= d){
				//System.out.println(counter);
				filterArray[counter] = starArray[i];
			//	System.out.println(filterArray[counter].getName());
				//System.out.println(starArray[i].getName());
				counter ++;
				
			}
		}
		
		Star[] returnArray = new Star[counter];
		
		//System.out.println(returnArray.length);
		
		//for (int i = 0; i<=)
		
		for (int j = 0; j < counter; j++){
			returnArray[j] = filterArray[j];
		}
		
		//System.out.println("end of dist method: " + returnArray[0].getName());
		
		return returnArray;
	}
	
public Star[] getMagFilterArray(double m){
		
		//filterSelected = true;
		Star[] filterArray = new Star[SIZE];
		int counter = 0;
		
		for (int i = 0; i<SIZE; i++){

			if (starArray[i].getApMag()<= m){
				//System.out.println(counter);
				filterArray[counter] = starArray[i];
				//System.out.println(filterArray[counter].getName());
				//System.out.println(starArray[i].getName());
				counter ++;
				
			}
		}
		
		Star[] returnArray = new Star[counter];
		
		//System.out.println(returnArray.length);
		
		//for (int i = 0; i<=)
		
		for (int j = 0; j < counter; j++){
			returnArray[j] = filterArray[j];
		}
		
		//System.out.println("end of magfilter method: " + returnArray[0].getName());
		
		return returnArray;
	}

}
