import java.awt.*;
import java.awt.geom.Ellipse2D;
//import java.awt.Graphics;
import javax.swing.JComponent;

public class DrawPoint extends JComponent{
	
	public void paintComponent(Graphics g){
		
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D.Double point = new Ellipse2D.Double(200, 200, 20, 20);
		g2.setColor(Color.yellow);
		g2.fill(point);

		//g.fillOval(0, 0, 200, 200);
		//g.setColor(Color.yellow);
	}

}
