import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JComponent;


public class StarGUI extends JFrame {
	
	private JPanel east, centre, south;
	final int FRAME_WIDTH = 400;
	final int FRAME_HEIGHT = 400;
	
	public StarGUI(){
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Star Test GUI");
		setSize(800, 900);
		layoutEast();
		layoutCentre();
		layoutSouth();
		//DrawPoint point = new DrawPoint();
		//this.add(point);
		
		
		
	}
	
	public void layoutEast(){
		east = new JPanel();
		east.setBackground(Color.blue);
		this.add(east, BorderLayout.WEST);
	}
	
	public void layoutCentre(){
		centre = new JPanel();
		centre.setLayout(new BorderLayout());
		centre.setBackground(Color.black);
		DrawPoint point = new DrawPoint();
		centre.add(point, BorderLayout.CENTER);
		this.add(centre, BorderLayout.CENTER);
	}
	
	public void layoutSouth(){
		south = new JPanel();
		south.setBackground(Color.white);
		this.add(south, BorderLayout.SOUTH);
	}

}
