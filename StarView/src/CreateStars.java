import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//class to create star objects from input text file
public class CreateStars {
	
	private final String INPUT_TEXT_FILE = "processed_181closest_data.txt";
	private String id;
	private double mag;
	private double ra;
	private double dec;
	private double par;
	private double colourInd;
	private String specType;
	//private static int idcounter = 0;
	private StarManager manager;
	
	public CreateStars(){
		
		manager = new StarManager();
	}
	
	public void createHippStars(){
		try{

			FileReader reader = new FileReader(INPUT_TEXT_FILE);
			Scanner  in = new Scanner(reader);
			try{
				while (in.hasNextLine()){
					String line = in.nextLine();
					String [] tokens = line.split("[ ,]+");
					id = tokens[0];
					mag = Double.parseDouble(tokens[1]);
					ra = Double.parseDouble(tokens[2]);
					dec = Double.parseDouble(tokens[3]);
					par = Double.parseDouble(tokens[4]);
					colourInd = Double.parseDouble(tokens[5]);
					specType = tokens[6];
					Star newStar = new Star(id, manager.getStarViewID(), mag, ra, dec, par, colourInd, specType);
					newStar.setName();
					newStar.setAbsMag();
					newStar.setDistance();
					newStar.setTemp();
					//newStar.setCylinCoord();
					newStar.calcXCoord();
					newStar.calcYCoord();
					manager.addStar(newStar);
					//System.out.println ( manager.printStarData(counter));
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
	
	//returns array of star objects
	public StarManager getManager(){
		return manager;
	}

}
