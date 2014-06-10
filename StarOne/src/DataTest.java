import java.io.*;
import java.util.*;

public class DataTest {

	private final String IN_FILE = "tycho_test.txt";

	public DataTest(){

	}

	public void readInFile(){
		try{
			FileReader reader = new FileReader(IN_FILE);
			Scanner  in = new Scanner(reader);
			while (in.hasNextLine()){
				String line = in.nextLine();
				String [] tokens = line.split("[;]+");
				String id = tokens[0];
				double mag = Double.parseDouble(tokens[3]);
				double ra = Double.parseDouble(tokens[4]);
				double dec = Double.parseDouble(tokens[5]);
				double dis = Double.parseDouble(tokens[6]);
				Star test = new Star(id, ra, dec, mag, dis);
				System.out.println(test.getDistance());
			}
		}
		
		catch (IOException e){
			System.out.println("exception");
		}
	}
}
