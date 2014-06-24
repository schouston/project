import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class CreateStars {
	
	private String id;
	private double mag;
	private double ra;
	private double dec;
	private double par;
	private double colourInd;
	private String specType;
	
	private StarManager manager;
	
	public CreateStars(){
		
		manager = new StarManager();
	}
	
	public void createHippStars(){
		try{

			FileReader reader = new FileReader("processed_data.txt");
			Scanner  in = new Scanner(reader);
			int counter = 0;
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
					Star newStar = new Star(id, mag, ra, dec, par, colourInd, specType);
					newStar.setName();
					newStar.setAbsMag();
					newStar.setDistance();
					newStar.setTemp();
					manager.addStar(newStar);
					counter ++;
			}
			}

			finally{
				if((in)!=null)in.close();
			}
		}
		catch (IOException e){
			System.out.println("exception");
		}
		manager.printStarData(0);
	}
	
	public StarManager getManager(){
		return manager;
	}

}
