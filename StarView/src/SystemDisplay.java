import java.awt.*;

import javax.swing.*;
public class SystemDisplay extends JFrame{

	private int FRAME_WIDTH = 600;
	private int FRAME_HEIGHT = 600;
	
	private JPanel systemPanel;
	
	public SystemDisplay(){
		
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Star System GUI");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setVisible(true);
		systemPanel = new JPanel();
		systemPanel.setBackground(Color.blue);
		this.add(systemPanel);
	}
	
	public void paint(Graphics g){
		
		super.paint(g);
		Graphics2D gs2 = (Graphics2D) g;
		
		
		
	}

}