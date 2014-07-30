import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class CreatePlanets {
	
	private final String INPUT_TEXT_FILE = "processed_exo2.txt";
	private final int SIZE = 841;
	private Planet[] planetArray; 
	private static int arrayCounter = 0;
	private boolean planetsCreated = false;
	
	//HashMap planets = new HashMap<Integer, String>();
	
	public CreatePlanets(){
		// = new HashMap<Integer, String>();
		planetArray = new Planet[SIZE]; 
		//System.out.println(" here!!!!!!");
		createExoPlanets();
	}
	
	public void createExoPlanets(){
		try{

			FileReader reader = new FileReader(INPUT_TEXT_FILE);
			Scanner  in = new Scanner(reader);
			try{
				while (in.hasNextLine()){
					String line = in.nextLine();
					String [] tokens = line.split("[,]+");
					String name = tokens[0].trim();
					double planRad = Double.parseDouble(tokens[1]);
					double period = Double.parseDouble(tokens[2]);
					double smAxis = Double.parseDouble(tokens[3]);
					double ecc = Double.parseDouble(tokens[4]);
					int disDate = Integer.parseInt(tokens[5]);
					String disMeth = tokens[6].trim();
					String parentStar = tokens[7].trim();
					
					Planet planet = new Planet(name, planRad, smAxis, period, ecc, disDate, disMeth, parentStar);
					planetArray[arrayCounter] = planet;
					//System.out.println(planetArray[arrayCounter].getName());
					arrayCounter ++;	
			}
			}

			finally{
				if((in)!=null)in.close();
			}
		}
		catch (IOException e){
			System.out.println("exception - input text file not found");
		}
		
	}
	
	public boolean planetsCreated(){
		return planetsCreated;
	}
	
	public Planet[] getPlanetArray(){
		return planetArray;
		
	}
	

}
