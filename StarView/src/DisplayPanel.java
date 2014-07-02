import java.awt.*;

//import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import javax.swing.*;

//class to draw star display, taking each star in array and drawing on JPanel object

public class DisplayPanel extends JPanel{

	private StarManager manager;

	private double width, height, xdis, ydis;

	public DisplayPanel(StarManager m){

		manager = m;
		this.setBounds(0, 0, 1600, 900);
		this.setcoords();
		this.setBackground(Color.black);
		this.setLayout(null);
	}

	public double getXdisplacement(){ return xdis;}
	public double getYdisplacement(){return ydis;}
	
	// method to set (0,0) on display
	public void setcoords(){

		height = this.getHeight();
		width = this.getWidth();
		xdis = width/2;
		ydis = height/2;
		//System.out.println("width: " + width);
		//System.out.println("height: " + height);
		//System.out.println(getSize());
	}

	public void	paint(Graphics g){

		super.paint(g);
		Graphics2D gs2 = (Graphics2D) g;
		Ellipse2D.Double sun = new Ellipse2D.Double(xdis, ydis, 15, 15);
		//gs2.translate(width/2, height/2);
		gs2.setColor(Color.yellow);
		gs2.fill(sun);

		//AffineTransform tform = AffineTransform.getTranslateInstance(width/2, height);
		Star[] drawArray =  manager.getStarArray();

		for (Star star : drawArray){

			Graphics2D g2 = (Graphics2D) g;
			//g2.setTransform(tform);
			Ellipse2D.Double point = new Ellipse2D.Double(star.getCartX() + xdis, star.getCartY() + ydis, 5, 5);
			if(star.getStellarClass().substring(0, 1).equals("O")) g2.setColor(Color.blue);
			else if (star.getStellarClass().substring(0, 1).equals("B"))g2.setColor(Color.lightGray);
			else if (star.getStellarClass().substring(0, 1).equals("A"))g2.setColor(Color.white);
			else if (star.getStellarClass().substring(0, 1).equals("F"))g2.setColor(Color.pink);
			else if (star.getStellarClass().substring(0, 1).equals("G"))g2.setColor(Color.yellow);
			else if (star.getStellarClass().substring(0, 1).equals("K"))g2.setColor(Color.orange);
			else if (star.getStellarClass().substring(0, 1).equals("M"))g2.setColor(Color.red);
			else if (star.getStellarClass().substring(0, 1).equals("L"))g2.setColor(Color.magenta);
			else g2.setColor(Color.yellow);
			g2.fill(point);
		}
		
	}
}