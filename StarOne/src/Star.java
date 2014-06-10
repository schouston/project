
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
	
	
	public void setBV(double bv){
		
		colourIndex = bv;
	}
	public void setTemp(){
		
		double logTemp = (14.551 - colourIndex)/3.684;
		System.out.println(logTemp);
		temp = Math.pow(10, logTemp);
		
	}
	
	

}
