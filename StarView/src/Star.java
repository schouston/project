import java.awt.Color;

public class Star {

	private final double TEMP_CONSTANT_A = 14.551;			//constants used in setTemperature method
	private final double TEMP_CONSTANT_B = 3.684;			//
	private final double SCALING_FACTOR = 280;				//scaling factor for co-ordinates
	//private static int iDCounter = 0;						//static variable counter for unique id

	private int starViewID;									//unique starview id

	private String name;									//
	private int idNum;										//hipparcos id
	private double distance;								//distance from sun in pc
	private double apMag;									//apparent (V-band) magnitude
	private double abMag;									//absolute magnitude
	private double mass;									//stellar mass (solar-radi)
	private String stellarClass;							//stellar classification - used for colour
	private double temp;									//stellar temp (K)
	private boolean inSystem;								//boolean indicating presence in star system
	private boolean exoSystem;								//boolean indicating presence of exo-planet system
	private double ra;										//right ascension
	private double dec;										//declination
	private double cartX;									//cartesian x co-ordinate
	private double cartY;									//y co-ordinate
	private double cartZ;
	private double colourIndex;								//b-v colour index to calculate temperature
	private Color displayColor;
	private double parallax; 								//milli-arc seconds
	
	private String ccdmID = "0";
	private boolean hasCommonName;
	
	private String HDid;
	private String HRid;
	
	private double displaySize;
	
	
	
public boolean getCommonNameBool(){return hasCommonName;}
public void setCommonNameBoole(boolean b){hasCommonName = b;}

	public Star(){

	}

	//Hipparcos data constructor
	public Star(int id, int sid, double vm, double r, double d, double p, double ci, String st, String cid, String hd, String hr){

		starViewID = sid;
		//iDCounter ++;
		idNum = id;
		apMag = vm;
		
		if (r>180) ra = r - 360;
		else
		ra = r;
		
		dec = d;
		parallax = p;
		colourIndex = ci;
		stellarClass = st;
		ccdmID = cid;
		
		if (!cid.equals("0")) inSystem = true;
		HDid = hd;
		HRid = hr;
		
		setAbsMag();
		setDistance();
		setDisplaySize();
		setTemp();
		//setHAProjection();
		//setCylinCoord();
		calcXCoord();
		calcYCoord();
		z();
		//setCartesian();
		setDisplayColor();
	}

	public int getSVid(){return starViewID;}
	public String getName(){return name;}
	public int getID(){return idNum;}
	public double getDistance(){return distance;}
	public double getApMag(){return apMag;}
	public double getAbMag(){return abMag;}
	public double getRA(){return ra;}
	public double getDec(){return dec;}
	public double getMass(){return mass;}
	public String getStellarClass(){return stellarClass;}
	public double getTemp(){return temp;}
	public boolean getInSystem(){return inSystem;}
	public boolean inExoSystem(){return exoSystem;}
	public double getCartX(){return cartX;}
	public double getCartY(){return cartY;}
	
	public double getCartZ(){return cartZ;}
	
	public double getcolourIndex(){return colourIndex;}
	public Color getDisplayColor(){return displayColor;}
	public String getHDid(){return HDid;}
	public String getHRid(){return HRid;}
	public double getDisplaySize(){return displaySize;}


	public void setName(String s){
		name = s;		
		}
	
	
	
	private void setBV(double bv){colourIndex = bv;	}
	private void setParallax(double p){parallax = p;}

	//method to set the star temperature using colourIndex and formula log(T) = (14.551 - colourIndex)/3.684
	private void setTemp(){

		double logTemp = (TEMP_CONSTANT_A - colourIndex)/TEMP_CONSTANT_B;
		temp = Math.pow(10, logTemp);

	}

	//method to calculate and set star distance using parallax (d = 1/p, p in arcseconds)
	private void setDistance(){

		double paraAS = parallax/1000;
		distance = 1/(paraAS);
	}
	
	//method to calc z component - display range ie size for each unit of distance, then multiply be the maxdistance minus actual distance
	private void z(){
		
		int minSize = 2; 								// minimum display size, ie furtheset will be 2 pixels wide
		
		double displayRange = 5;						//range of display values
		double distanceRange;							
		distanceRange = 20;
		double displayRatio = displayRange/distanceRange;
		cartZ = displayRatio * (distanceRange -distance) + minSize;
	}
	
	private void setDisplaySize(){
		
		if(distance <= 5) displaySize = 6;
		else if (distance <=10) displaySize = 5;
		else if (distance <=15) displaySize = 4;
		else if (distance <=20) displaySize = 3;
		else displaySize = 2;
	}

	//method to set absolute magnitude
	private void setAbsMag(){

		double paraAS = parallax/1000;
		double x = paraAS/100;
		abMag =  5*(Math.log(x));
	}
	
	private void setDisplayColor(){
		
		if(stellarClass.substring(0, 1).equals("O")) displayColor = Color.blue;
		else if (stellarClass.substring(0, 1).equals("B"))displayColor = (Color.lightGray);
		else if (stellarClass.substring(0, 1).equals("A"))displayColor =(Color.white);
		else if (stellarClass.substring(0, 1).equals("F"))displayColor = Color.pink;
		else if (stellarClass.substring(0, 1).equals("G"))displayColor =(Color.yellow);
		else if (stellarClass.substring(0, 1).equals("K"))displayColor =(Color.orange);
		else if (stellarClass.substring(0, 1).equals("M"))displayColor =(Color.red);
		else if (stellarClass.substring(0, 1).equals("L"))displayColor =(Color.magenta);
		else displayColor = (Color.yellow);
		
	}
	
	//calculate cartesian co-ords for HA Equal Area Projection
	private void calcXCoord(){

		double operand1 = 2 * (Math.sqrt(2))* (Math.cos(Math.toRadians(dec))) * (Math.sin(Math.toRadians(ra/2)));
		double operand2 = Math.sqrt(1 + (Math.cos(Math.toRadians(dec)) * Math.cos(Math.toRadians(ra/2))));
		double x = (operand1/operand2);
		//System.out.println("2 root 2: " + operand1);
	    //System.out.println("ra: " + ra);
		//System.out.println("dec: " + dec);
		//System.out.println("op 1: " + operand1);
		//System.out.println("x coord before mul: " + x);


		//int xcartX = (int)(x);	
		cartX = x * SCALING_FACTOR;
		//System.out.println("x - coord: " +cartX);
	}

	private void calcYCoord(){

		double operand1 = Math.sqrt(2)* Math.sin(Math.toRadians(dec));
		double operand2 = Math.sqrt(1 + (Math.cos(Math.toRadians(dec)) * Math.cos(Math.toRadians(ra/2))));
		double y = (operand1/operand2);//*100;

		cartY = (y) * (-1) * SCALING_FACTOR; 						//reflected about y-axis
		//System.out.println("y coord: " + cartY);
	}
	
	private void calcZ(){
		
		double z = distance * Math.cos(Math.toRadians(dec));
		cartZ = z;
	}
	
	private void setHAProjection(){
		calcXCoord();
		calcYCoord();
		calcZ();
		
		cartX = (cartX) * SCALING_FACTOR;
		cartY = (cartY) * SCALING_FACTOR;
	}


	private void setCylinCoord(){

		double x = ra * 250;
		cartX = (int) x;

		double y = Math.tan(Math.toRadians(dec)) ;
		cartY = (int) y;
	}

	private void setCartesian(){
		
		double x = distance * Math.cos(Math.toRadians(dec)) * Math.cos(Math.toRadians(ra));
		cartX = x * 50;
		
		double y = distance * Math.cos(Math.toRadians(dec)) * Math.sin(Math.toRadians(ra));
		cartY = y * 50;
		double z = distance * Math.sin(Math.toRadians(dec));
		
		//cartX = (x/z) * 100;
		//cartY = (y/z)  * 100;
	}




}
