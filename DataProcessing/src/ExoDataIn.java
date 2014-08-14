import java.io.*;
import java.util.*;

public class ExoDataIn {

	private final String IN_FILE = "exoplaneteu_catalog.txt";//"hipp.txt";
	private final String OUT_FILE = "processed_exo2.txt";

	public ExoDataIn(){

	}

	public void readInExoData(){
		double pRad = 0.0;
		double period = 0.0;
		double ecc = 0.0;
		double smA = 0.0;
		double starRadi = 0.0;

		try{
			FileReader reader = new FileReader(IN_FILE);

			FileWriter out = new FileWriter(OUT_FILE);
			Scanner  in = new Scanner(reader);

			try{				
				while (in.hasNextLine()){
					String line = in.nextLine();
					String [] tokens = line.split("[,]");
					System.out.println("token length: " +tokens.length);
					System.out.println(tokens[0]);

				//	if(!tokens[56].equals("")){
						//if (Double.parseDouble(tokens[56])<15){
							String name = tokens[0].trim();
							if (!tokens[4].equals(""))
							{
								pRad = Double.parseDouble(tokens[4]);}
							if (!tokens[7].equals("")){
								period = Double.parseDouble(tokens[7]);}
							if (!tokens[10].equals("")){
								smA = Double.parseDouble(tokens[10]);}
							if (!tokens[13].equals("")){
								ecc = Double.parseDouble(tokens[13]);}
							String disDate = tokens[37].trim();
							String disMethod = tokens[45].trim();
							String starName = tokens[48];
							
							if (!tokens[59].equals("")){
								starRadi = Double.parseDouble(tokens[59]);}

							String output = String.format("%s, %f, %f, %f, %f,%s,%s,%s,%f", name, pRad, period, smA, ecc, disDate, disMethod, starName, starRadi);
							out.write(output + '\n');

						//}	
					//}
				}
			}
			finally{
				if((in)!=null)in.close();
				if((out)!= null)out.close();
			}
		}
		catch (IOException e){
			System.out.println("exception - can not find exoplanet data");
		}

	}

}
