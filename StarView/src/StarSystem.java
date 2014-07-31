
public class StarSystem {
	
	private int noStars;
	private String ccdmID;
	private double angSeperation;
	private double semimajor;
	
	
	
	private Star[] systemArray;
	private static int arrayCounter = 0;
	
	public StarSystem(){
		
		systemArray = new Star[noStars];
		
	}
	
	public void addStar(Star s){ 
		
		systemArray[arrayCounter] = s;
		arrayCounter ++;
	}

}
