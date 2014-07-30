import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class CircleFrame extends JFrame{
	
	private int FRAME_WIDTH = 500;
	private int FRAME_HEIGHT = 500;
	
	private CircleComp scene;
	private Planet plan;
	
	class TimerListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			scene.moveCircle();
			
		}
		
	}

	public Dimension getOrigin(){
		
		return this.getSize();
	}
	
	public CircleFrame(){
		
		
		scene = new CircleComp();
		add(scene);
		// plan = new Planet();
		 //add(plan);
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ActionListener listener = new TimerListener();
		
		int DELAY = 100;
		Timer t = new Timer(DELAY, listener);
		t.start();
	}
}
