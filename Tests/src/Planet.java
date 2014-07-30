import java.awt.*;
import javax.swing.*;
public class Planet extends JComponent{
	
	String id;
	String name;
	//Star parentStar;
	int x0;
	int y0;
	int x;
	int y;
	double velocity;
	int radius;
	
	
	public Planet(){
		
	}

	public void paint(Graphics g){
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(Color.blue);
		g2.drawArc(x0 - radius, y0 - radius, 300, 200, 0, 360);
		
	}
}
