import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;


public class StarManager extends JComponent{

	//class to hold array of Star Objects

	private final int SIZE = 98;  //array size
	private Star[] starArray;	//array of star objects
	public static int starArrayCounter = 0;	//counter for number of star objects entered

	public StarManager(){

		starArray = new Star[SIZE];

	}

	public void addStar(Star s){

		Star star = s;
		starArray[starArrayCounter] = star;
		System.out.println(starArrayCounter);
		starArrayCounter ++;
	}

	public void drawStar(){

	}

	public String printStarData(int i){

		int index = i;
		Star star = starArray[i];

		String name = "Name: ";
		String svid = "StarView ID: ";
		String hippid = "ID: ";
		String apmag = "Apparent Magnitude: ";
		String abmag = "Absolute Magnitude: ";
		String dist = "Distance: ";
		String r = "Right Ascension: ";
		String d = "Declination: ";
		String temp = "Stellar Temperature: ";
		String type = "Spectral Type: ";

		String starData = String.format("%s %s" + '\n' + "%s %d" + '\n' + "%s %s" + '\n' + "%s%f" + '\n' + "%s%f" + '\n' + "%s%f" + '\n' + "%s%f" + '\n' + "%s%f" + '\n' + "%s%f" + '\n'+
				"%s%s",name, star.getName(), svid, star.getSVid(), hippid, star.getID(), dist, star.getDistance(), apmag, star.getApMag(), abmag, star.getAbMag(), r, star.getRA(), d, star.getDec(), temp,
				star.getTemp(), type, star.getStellarClass())
				;
		//System.out.println(starData);	
		return starData;
	}
	
	public Star[] getStarArray(){
		return starArray;
	}

	public void paintComponent(Graphics g){

		for (Star star : starArray){
			
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D.Double point = new Ellipse2D.Double(star.getCartX(), star.getCartY(), 5, 5);
		g2.setColor(Color.yellow);
		g2.fill(point);
		}

	}

}
