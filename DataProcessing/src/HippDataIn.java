import java.io.*;

import java.util.*;

public class HippDataIn {

	private final String IN_FILE = "upto_para_50mas.txt";//"hipp.txt";
	private final String OUT_FILE = "processed_upto_50mas.txt";
	private final double MIN_PARALLAX = 9;
	private int id;
	private double mag;
	private double ra;
	private double dec;
	private double par;
	private double colourInd;
	private String specType;
	String ccdmID;

	String HDid = "0";
	String HRid = "0";
	 String HIPid;
	
	private CrossRefID[] crossrefArray;
	private int SIZE = 4308;
	private int crCounter = 0; //cross ref counter

	public HippDataIn(){
		
		//crossrefArray = new CrossRefID[SIZE];

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
						
						for (int i = 0; i < crossrefArray.length; i++){
							//System.out.println(crossrefArray.length);
							
						if (tokens[1].trim().equals(crossrefArray[i].getHIP())){
							System.out.println(tokens[1] +" " + crossrefArray[i].getHIP());
						
							if(!crossrefArray[i].getHD().equals(""))
							HDid = crossrefArray[i].getHD();
							
							if(!crossrefArray[i].getHR().equals(""))
							HRid = crossrefArray[i].getHR();
						}
						}
						mag = Double.parseDouble(tokens[5]);
						ra = Double.parseDouble(tokens[8]);
						dec = Double.parseDouble(tokens[9]);
						par = Double.parseDouble(tokens[11]);
						//double dis = Double.parseDouble(tokens[6]);
						//System.out.println(tokens[37]);
						if (tokens[37].trim().equals(""))colourInd = 0;
						else
						colourInd = Double.parseDouble(tokens[37]);
						if (tokens[76].trim().equals(""))specType = "DEFAULT";
						else
							specType = tokens[76].trim();
						if (tokens[55].trim().equals(""))ccdmID = "0";
						else if (tokens[58].trim().equals("1"))ccdmID = "0";//unresolved system treated as one object
						else
						ccdmID = tokens[55];
						//Star test = new Star(id, ra, dec, mag, dis);
						//System.out.println("hi" + dec);

						//FileWriter out = new FileWriter("processed_data.text");

						String output = String.format("%s, %f, %f, %f, %f, %f, %s,%s,%s,%s,", id, mag, ra, dec, par, colourInd, specType, ccdmID, HDid, HRid);
						out.write(output + '\n');
						//out.write(id + ", " + mag + ", " + ra + ", " + dec + ", " + par + ", " + colourInd + ", " + specType + ", " + "\n");
					}
					HDid = "0";
					HRid= "0";
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

	public void readInCrossRefFile(){
		
		//int crossrefid = id;
		//CrossRefManager refManager = new CrossRefManager();
		String HD = "HD ";
		String HR = "HR ";
		String HIP;
		CrossRefID[] array = new CrossRefID[SIZE];

		String fileName = "idcrossref.txt";
		try{
			FileReader reader = new FileReader(fileName);
			Scanner in = new Scanner(reader);

			try{
				while (in.hasNextLine()){
					String line = in.nextLine();
					String [] tokens = line.split("[|]+");
					HD += tokens[0].trim();
					System.out.print(HD + " ");
					HR += tokens[1].trim();
					System.out.print(tokens[1] + " ");
					if (tokens.length == 3){
					HIP = tokens[2].trim();
					System.out.println(tokens[2]);
					
					CrossRefID ref = new CrossRefID(HD, HR, HIP);
					array[crCounter] = ref;
					crCounter ++;}
					
					else System.out.println("no hipp");
					
					HD = "HD ";
					HR = "HR ";
				}
			}
			finally{
				if((in)!=null)in.close();
				//if((out)!= null)out.close();
			}
		}
		catch (IOException e){
			System.out.println("exception");
		}
		
		crossrefArray = new CrossRefID[crCounter];
		
		for (int i = 0; i < crossrefArray.length; i ++){
			
			crossrefArray[i] = array[i];
		}
		System.out.println("counter " + crCounter);
	}



	/*public void createHippStars(){
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


	}*/
}