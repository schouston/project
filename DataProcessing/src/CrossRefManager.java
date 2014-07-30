import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class CrossRefManager {
	
	private CrossRefID[] crossrefArray;
	private final int SIZE = 1;
	private final String INPUT_FILE = "";
	
	
	public CrossRefManager(){
		
		crossrefArray = new CrossRefID[SIZE];
	}
	
	public void readInData(){
		
		String HD;
		String HR;
		String HIP;
		
		try{

			FileReader reader = new FileReader(INPUT_FILE);
			Scanner  in = new Scanner(reader);
			try{
				while (in.hasNextLine()){
					String line = in.nextLine();
					String [] tokens = line.split("[|]+");
					HD = tokens[0].trim();
					HR = tokens[1].trim();
					HIP = tokens[2].trim();
					CrossRefID ref = new CrossRefID(HD, HR, HIP);
					//crossrefArray.add(ref);
					
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
	
	public void add(CrossRefID id){
		
	}

}
