import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class ExoFrame extends JFrame{
	
	private int FRAME_WIDTH = 900;
	private int FRAME_HEIGHT = 700;
	
	private ExoManager scene;
	private Planet plan;
	
	class TimerListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			scene.movePlanets();
			
		}
	}

	public Dimension getOrigin(){
		
		return this.getSize();
	}
	
	public ExoFrame(ExoManager e){
		
		//JPanel panel = new JPanel();
		//panel.setBackground(Color.black);
		
		
		// plan = new Planet();
		 //add(plan);
		setTitle("Exoplanet Display");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		scene = e;
		//panel.add(scene);
		add(scene);
		
		setBackground(Color.black);
		infoPanel();
		ActionListener listener = new TimerListener();
		
		int DELAY = 100;
		Timer t = new Timer(DELAY, listener);
		t.start();
	}
	
	public void infoPanel(){
		JPanel infoPanel = new JPanel();
		infoPanel.setBackground(Color.gray);
		
		JTextArea dataDisplay = new JTextArea();
		Font font = new Font("Verdana", Font.PLAIN, 12);
		dataDisplay.setFont(font);
		dataDisplay.setBackground(Color.lightGray);
		dataDisplay.setEditable(false);
		dataDisplay.append(scene.printPlanetData());
		infoPanel.add(dataDisplay, BorderLayout.NORTH);
		
		//JButton closeButton = new JButton("Close Window");
		//closeButton.addActionListener();
		
		//infoPanel.add(closeButton, BorderLayout.SOUTH);
		this.add(infoPanel, BorderLayout.WEST);
		
		
	}
}