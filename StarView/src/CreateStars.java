import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//class to create star objects from input text file
public class CreateStars {
	
	private final String INPUT_TEXT_FILE = "processed_upto_50mas.txt";
	private int id;
	private double mag;
	private double ra;
	private double dec;
	private double par;
	private double colourInd;
	private String specType = "Default";
	private String ccdmID = "NA";
	private String HDid;
	private String HRid;
	//private static int idcounter = 0;
	private StarManager manager;
	private CommonNameManager nameManager;
	
	public CreateStars(){
		
		manager = new StarManager();
		createHippStars();
	}
	
	public void createHippStars(){
		
		int count = 0;
		try{

			FileReader reader = new FileReader(INPUT_TEXT_FILE);
			Scanner  in = new Scanner(reader);
			try{
				while (in.hasNextLine()){
					String line = in.nextLine();
					String [] tokens = line.split("[,]+");
					id = Integer.parseInt(tokens[0]);
					mag = Double.parseDouble(tokens[1]);
					ra = Double.parseDouble(tokens[2]);
					dec = Double.parseDouble(tokens[3]);
					par = Double.parseDouble(tokens[4]);
					colourInd = Double.parseDouble(tokens[5]);
				//	if (tokens.length == 7)
					specType = tokens[6].trim();
					//if (tokens.length == 8)
					ccdmID = tokens[7];
				//	}
					HDid = tokens[8];
					System.out.println ( tokens[8]);
					HRid = tokens[9];
					
					Star newStar = new Star(id, manager.getStarViewID(), mag, ra, dec, par, colourInd, specType, ccdmID, HDid, HRid);
					//newStar.setName();
					manager.addStar(newStar);
					count ++;
					System.out.println ( count);
			}
			}

			finally{
				if((in)!=null)in.close();
			}
		}
		catch (IOException e){
			System.out.println("exception - input text file not found");
		}
		this.setNames();
	}
	
	//returns array of star objects
	public StarManager getManager(){
		return manager;
	}
	
	public void setNames(){
		
		CommonNameManager nameManager = new CommonNameManager(manager.getStarArray());
		nameManager.processNameFile();
		nameManager.setNames();
		
	}

}
