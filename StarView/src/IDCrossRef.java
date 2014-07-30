import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class IDCrossRef {
	
	private final String INPUT_TEXT_FILE = "idcrossref.txt";
	
	private String HDid;
	private String HRid;
	private String HIPid;

	public void readInData(){
	try{

		FileReader reader = new FileReader(INPUT_TEXT_FILE);
		Scanner  in = new Scanner(reader);
		try{
			while (in.hasNextLine()){
				String line = in.nextLine();
				String [] tokens = line.split("[|]+");
				HDid = tokens[0].trim();
				HRid = tokens[1].trim();
				HIPid = tokens[2].trim();
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
}
