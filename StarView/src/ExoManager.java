import java.awt.*;
import javax.swing.*;


public class ExoManager extends JPanel{

	private Planet[] planetDisplayArray;
	private final int SIZE = 2;
	private static int arrayCounter=0;
	private Star displayStar;

	private int xLeft; //centre
	private int yTop; //centre

	public ExoManager(Planet[] pa, Star s){

		planetDisplayArray = pa; //new Planet[SIZE];
		displayStar = s;
		xLeft = 200;
		yTop = 200;
		this.setBackground(Color.black);
		System.out.println(planetDisplayArray.length);
		System.out.println(planetDisplayArray[0].getName());
		System.out.println(planetDisplayArray[0].getPlanetaryRad());
		this.movePlanets();
	}


	public void addPlanet(Planet p){

		Planet planet = p;
		System.out.println(planet.getName());
		planetDisplayArray[arrayCounter] = planet;
		System.out.println(arrayCounter);
		System.out.println(planetDisplayArray[arrayCounter].getName());

		arrayCounter ++;
	}

	public Planet[] getPlanetArray(){

		return planetDisplayArray;
	}

	public void movePlanets(){

		for (Planet planet : planetDisplayArray){
			//System.out.println(planet.getName());
			planet.calculateRad();
			planet.calculateVelocity();
			planet.movePlanet();

			repaint();
		}
	}

	public void paint(Graphics g){

		super.paint(g);

		Graphics2D star = (Graphics2D) g;
		star.setColor(displayStar.getDisplayColor());
		star.fillOval(xLeft, yTop, 5, 5);

		for (Planet planet : planetDisplayArray){
			//System.out.println(planet.getName());

			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(Color.green);
			g2.fillOval((int)planet.getPosition().getX(),(int) planet.getPosition().getY(), (int)planet.getPlanetaryRad(), (int)planet.getPlanetaryRad());
			g2.drawString(planet.getName(), ((int)planet.getPosition().getX() + 5), (int) (planet.getPosition().getY()+ 5));
		}

	}

	public String printPlanetData(){

		//int index = i;
		String planetData = "Star: " + displayStar.getName() + '\n' + '\n';

		for (Planet planet : planetDisplayArray){
			//Planet planet = planetDisplayArray[index];

			String name = "Name: ";
			String dDate = "Discovered: ";
			String dMethod = "Discovery Method:";


			String data = String.format("%s%s" + '\n' + "%s%d" + '\n' + "%s" +'\n' +"%s" + '\n' ,name, planet.getName(), dDate, planet.getDisDate(), dMethod, planet.getDisMeth().trim());
			planetData += data + '\n';
		}
		//System.out.println(planetData);	
		return planetData;
	}
}
