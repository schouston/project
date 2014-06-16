
public class Star {
	
	private final double TEMP_CONSTANTA = 14.551;
	
	private String name;
	private String idNum;
	private double distance;
	private double apMag;
	private double abMag;
	private double mass;
	private String stellarClass;
	private double temp;
	private boolean inSystem;
	private boolean exoSystem;
	private double ra;
	private double dec;
	private double cartX;
	private double cartY;
	private double colourIndex;
	private double parallax;

	
	public Star(){
		
	}
	public Star(String n){
		
		name = n;
	}
	
	public Star(String id, double r, double d, double m, double dis){
		
		idNum = id;
		distance = dis;
		ra = r;
		dec = d;
		apMag = m;
		
	}
	
	//hipp data constructor
	
	public String getName(){return name;}
	public double getDistance(){return distance;}
	public double getApMag(){return apMag;}
	public double getAbMag(){return abMag;}
	public double getMass(){return mass;}
	public String getStellarClass(){return stellarClass;}
	public double getTemp(){return temp;}
	public boolean inSystem(){return inSystem;}
	public double getCartX(){return cartX;}
	public double getCartY(){return cartY;}
	public double getcolourIndex(){return colourIndex;}
	
	
	public void setBV(double bv){colourIndex = bv;	}
	public void setParallax(double p){parallax = p;}
	
	//method to set the star temperature using colourIndex and formula log(T) = (14.551 - colourIndex)/3.684
	public void setTemp(){
		
		double logTemp = (14.551 - colourIndex)/3.684;
		System.out.println(logTemp);
		temp = Math.pow(10, logTemp);
		
	}
	
	//method to calculate and set star distance using parallax (d = 1/p, p in arcseconds)
	public void setDistance(){
		
		double paraAS = parallax/1000;
		distance = 1/(paraAS);
		
	}
	
	//method to set absolute magnitude
	public void setAbsMag(){
		
		double paraAS = parallax/1000;
		double x = paraAS/100;
		abMag =  5*(Math.log(x));
		
	}
	
	

}
