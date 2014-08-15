import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;


public class MapProjection {
	
	private double SCALING_FACTOR = 280;
	private double dec;
	private double ra;
	private double cartX;
	private double cartY;
	
	public MapProjection(double r, double d){
		ra = r;
		dec = d;
		
	}
	

	
	
	//calculate cartesian co-ords for HA Equal Area Projection
	private double calcHAXCoord(){

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
		return cartX;
		//System.out.println("x - coord: " +cartX);
	}

	private double calcHAYCoord(){

		double operand1 = Math.sqrt(2)* Math.sin(Math.toRadians(dec));
		double operand2 = Math.sqrt(1 + (Math.cos(Math.toRadians(dec)) * Math.cos(Math.toRadians(ra/2))));
		double y = (operand1/operand2);//*100;

		cartY = (y) * (-1) * SCALING_FACTOR; 						//reflected about y-axis
		return cartY;
		//System.out.println("y coord: " + cartY);
	}
	
/*	private void calcZ(){
		
		double z = distance * Math.cos(Math.toRadians(dec));
		cartZ = z;
	}*/
	
	public Point2D.Double setHAProjection(){
		SCALING_FACTOR = 280;
		calcHAXCoord();
		calcHAYCoord();
		Point2D.Double point = new Point2D.Double(calcHAXCoord(), calcHAYCoord());
		
		return point;
		//calcZCoord();
		
		//cartX = (cartX) * SCALING_FACTOR;
		//cartY = (cartY) * SCALING_FACTOR;
	}


	public Point2D.Double setCylinProj(){    //Lamberts Cylindical Equal Area

		double x = ra * 4;
		cartX =  x ;
		
		double y = Math.sin(Math.toRadians(dec));

	//	double y = Math.tan(Math.toRadians(dec)) * -20;//SCALING_FACTOR ;
		cartY =  y * -400;
		
		Point2D.Double point = new Point2D.Double(cartX, cartY);
		
		return point;
		//calcZCoord();
	}

	/*private void setCartesian(){
		
		double x = distance * Math.cos(Math.toRadians(dec)) * Math.cos(Math.toRadians(ra));
		
		
		double y = distance * Math.cos(Math.toRadians(dec)) * Math.sin(Math.toRadians(ra));
		
		//double z = distance * Math.sin(Math.toRadians(dec));
		SCALING_FACTOR = 20;
		
		cartX = x *SCALING_FACTOR;
		cartY = y *SCALING_FACTOR;
		//calcZCoord();
	}*/
	
	public void setLAEqualArea(){
		
		double kdivisor = 1 + Math.cos(0)* Math.cos(dec) * Math.cos(ra) ;
		
		double k = Math.sqrt(2/kdivisor);
		
		double x = k * Math.cos(Math.toRadians(dec))*Math.sin(Math.toRadians(ra));
		double y = k * Math.sin(Math.toRadians(dec));
		
		cartX =  x * 10;//SCALING_FACTOR;
		cartY =  y * 10; //SCALING_FACTOR;
		
		//calcZCoord();
	}
	
	public Point2D.Double setOAProj(){
		
	//	if (ra < 0) ra = ra + 360;
		
		SCALING_FACTOR = 380;
		
		double x = Math.cos(Math.toRadians(dec)) * Math.sin(Math.toRadians(ra));
		double y = Math.sin(Math.toRadians(dec)) ;
		if (ra < 0){
			if (ra > -90) cartX = x *  SCALING_FACTOR   - 400;			//ra between 0 and -90
			else
			cartX =  x * SCALING_FACTOR  + 400;							//ra between -90 and -180
		}
		
		else {
			if (ra < 90)											//ra between 0 and 90
			cartX =  x * SCALING_FACTOR - 400;
		else cartX = x * SCALING_FACTOR  + 400;				// ra betwwn 90 and 180
		}
		
		
		
	/*	if (ra < 180){
			if (ra <90)	 cartX = x * - SCALING_FACTOR  + 400; //if (ra <90)
			else cartX =  x * SCALING_FACTOR + 400;
		}
		else {
			if(ra < 270)
			cartX =  x * -SCALING_FACTOR - 400;
		cartX =  x * SCALING_FACTOR - 400;}*/
		cartY =  y * - SCALING_FACTOR;
		Point2D.Double point = new Point2D.Double(cartX, cartY);
		return point;
		}
	
	
	//Mercator
	public Point2D.Double setMetProj(){
		
		//if (dec < 0) dec = 180 - dec;
		double y2 = 1700 / (2* Math.PI) * Math.log(Math.tan((Math.PI / 4) + (Math.toRadians(dec)/2)));
		double y1 = Math.tan(Math.toRadians(dec)) * ( 1/ Math.cos(Math.toRadians(dec)));
		double y = Math.log(y1);
		
		cartX = ra * 4;//SCALING_FACTOR;
		cartY = y2 / -2; //SCALING_FACTOR;
		
		Point2D.Double point = new Point2D.Double(cartX, cartY);
		return point;
	}
}
