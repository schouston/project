import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import java.util.Scanner;

public class CommonNameManager {

	private final String IN_FILE = "common_names.txt";
	private HashMap<Integer, String> names;
	private Star[] starArray;

	public CommonNameManager(Star[] s){

		names = new HashMap<Integer, String>();
		starArray = s;
	}

	public void processNameFile(){

		try{
			FileReader reader = new FileReader(IN_FILE);

			//FileWriter out = new FileWriter(OUT_FILE);
			Scanner  in = new Scanner(reader);

			try{				
				while (in.hasNextLine()){
					String line = in.nextLine();
					String [] tokens = line.split("[,]");
					System.out.println(tokens.length);
					//System.out.println(tokens[76]);
					String name1 = tokens[0].trim();
					int id1 = Integer.parseInt(tokens[1].trim());
					String name2 = tokens[2].trim();
					int id2 = Integer.parseInt(tokens[3].trim());
					CommonName nameObject1 = new CommonName(name1, id1);
					CommonName nameObject2 = new CommonName(name2, id2);
					this.putName(nameObject1);
					this.putName(nameObject2);						
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

	public void putName(CommonName n){

		String name = n.getName();
		int id = n.getID();

		names.put(id, name);

	}

	public void setNames(){

		for (int i = 0; i < starArray.length; i++){

			Star star = starArray[i];

			if (star.getCatalogueID().equals("H")){

				if (names.containsKey(star.getHippID())){
					star.setName(names.get(star.getHippID()));
					star.setCommonNameBoole(true);
				}
				else 
					star.setName("HIP " + (star.getID()));
			}
			else star.setName("Tycho " + (star.getID()));
		}
	}

	public void getNamefromID(int i){



		if (names.containsKey(i)){



		}



		System.out.println(names.get(i));
	}
}
