import java.io.*;

import java.util.*;

public class HippDataIn {

	private final String IN_FILE = "hipp.txt";
	private String id;
	private double mag;
	private double ra;
	private double dec;
	private double par;
	private double colourInd;
	private String specType;

	public HippDataIn(){

	}

	public void readInFile(){
	
		try{
			FileReader reader = new FileReader(IN_FILE);

			FileWriter out = new FileWriter("processed_data.text");


			try{



				Scanner  in = new Scanner(reader);
				while (in.hasNextLine()){
					String line = in.nextLine();
					String [] tokens = line.split("[|]+");
					
					if (tokens[11] )
					id = tokens[1];
					mag = Double.parseDouble(tokens[5]);
					ra = Double.parseDouble(tokens[8]);
					dec = Double.parseDouble(tokens[9]);
					par = Double.parseDouble(tokens[11]);
					//double dis = Double.parseDouble(tokens[6]);
					colourInd = Double.parseDouble(tokens[37]);
					specType = tokens[76];
					//Star test = new Star(id, ra, dec, mag, dis);
					System.out.println(dec);
					
					//FileWriter out = new FileWriter("processed_data.text");
					out.write(id + ", " + mag + ", " + ra + ", " + dec + ", " + par + ", " + colourInd + ", " + specType + ", " + "\n");
				}
			}


			finally{
				if((out)!= null)
					out.close();
			}
		}
		catch (IOException e){
			System.out.println("exception");
		}

	}

	public void outFile(){

		try{

			FileWriter out = new FileWriter("processed_data.text");
			out.write(id + ", " + mag + ", " + ra + ", " + dec + ", " + par + ", " + colourInd + ", " + specType + ", " );


		}

		catch(IOException e){
			System.out.println("exception");
		}


	}
}
