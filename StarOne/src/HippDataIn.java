import java.io.*;

import java.util.*;

public class HippDataIn {

	private final String IN_FILE = "hipp_181_closest.txt";//"hipp.txt";
	private final String OUT_FILE = "processed_181closest_datawithccdm.txt";
	private final double MIN_PARALLAX = 9;
	private int id;
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

			FileWriter out = new FileWriter(OUT_FILE);
			Scanner  in = new Scanner(reader);

			try{				
				while (in.hasNextLine()){
					String line = in.nextLine();
					String [] tokens = line.split("[|]+");
					System.out.println("token length: " +tokens.length);
					//System.out.println(tokens[76]);
					System.out.println(" before if " + tokens[11]);

					if (Double.parseDouble(tokens[11]) > MIN_PARALLAX){
						System.out.println("here");
						id = Integer.parseInt(tokens[1].trim());
						mag = Double.parseDouble(tokens[5]);
						ra = Double.parseDouble(tokens[8]);
						dec = Double.parseDouble(tokens[9]);
						par = Double.parseDouble(tokens[11]);
						//double dis = Double.parseDouble(tokens[6]);
						System.out.println(tokens[37]);
						colourInd = Double.parseDouble(tokens[37]);
						specType = tokens[76];
						String ccdmID = tokens[55];
						//Star test = new Star(id, ra, dec, mag, dis);
						//System.out.println("hi" + dec);

						//FileWriter out = new FileWriter("processed_data.text");

						String output = String.format("%s, %f, %f, %f, %f, %f, %s,%s", id, mag, ra, dec, par, colourInd, specType, ccdmID);
						out.write(output + '\n');
						//out.write(id + ", " + mag + ", " + ra + ", " + dec + ", " + par + ", " + colourInd + ", " + specType + ", " + "\n");
					}
				}
			}
			finally{
				if((in)!=null)in.close();
				if((out)!= null)out.close();
			}
		}
		catch (IOException e){
			System.out.println("exception");
		}

	}

	public void createHippStars(){
		try{

			FileReader reader = new FileReader("processed_data.txt");
			Scanner  in = new Scanner(reader);
			try{
				while (in.hasNextLine()){
					String line = in.nextLine();
					String [] tokens = line.split("[ ,]+");
					id = Integer.parseInt(tokens[0]);
					mag = Double.parseDouble(tokens[1]);
					ra = Double.parseDouble(tokens[2]);
					dec = Double.parseDouble(tokens[3]);
					par = Double.parseDouble(tokens[4]);
					colourInd = Double.parseDouble(tokens[5]);
					specType = tokens[6];
			}
			}

			finally{
				if((in)!=null)in.close();
			}
		}
		catch (IOException e){
			System.out.println("exception");
		}
	}

	public void outFile(){

		try{

			FileWriter out = new FileWriter("processed_data.txt");
			out.write(id + ", " + mag + ", " + ra + ", " + dec + ", " + par + ", " + colourInd + ", " + specType + ", " );
		}

		catch(IOException e){
			System.out.println("exception");
		}


	}
}
