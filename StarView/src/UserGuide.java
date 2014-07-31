import java.awt.*;

import javax.swing.*;

public class UserGuide extends JFrame{


	private final int FRAME_WIDTH = 1400;
	private final int FRAME_HEIGHT = 600;

	public UserGuide(){

		setTitle("StarView User Guide");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.add(ugString());
		this.setVisible(true);


	}

	public JPanel ugString(){

		JPanel guidePanel = new JPanel();
		guidePanel.setBackground(Color.gray);
		JTextArea heading = new JTextArea();
		heading.setBackground(Color.lightGray);
		heading.setEditable(false);
		Font hfont = new Font("Verdana", Font.PLAIN, 20);
		heading.setFont(hfont);
		JTextArea text = new JTextArea();
		text.setEditable(false);
		text.setBackground(Color.lightGray);

		Font font = new Font("Verdana", Font.PLAIN, 14);
		text.setFont(font);
		String head = " StarView User Guide" ;// + '\n' + "" ;
		String userGuide = 

				"Welcome to StarView, an interactive map of the Celestial Sphere which includes all stars upto a distance of x parsecs from the sun." + '\n' + '\n' +
				"Each star is displayed as viewed from our Solar System in a colour which represents the spectral class."+ '\n' +'\n' +
				"Each star can be selected by a mouse click and the panel at the top left of the screen will display information appropriate to the selected star." + '\n' + '\n' +
				"The display can be scrolled over using the scroll bars at the bottom and right side of the display." + '\n' +
				"To return to the original position the button labeled 'Centre Display' can be clicked."  + '\n' + '\n' +
				"When the button labeled 'View Star System' is pressed a star system display window shall appear if the currently selected star is part of a multiple system or an appropriate message if it is not."  + '\n' +'\n' +
				"When the button labeled 'View Planetary System' is pressed a exoplanet display window shall appear if the currently selected star has known exoplanets or an appropriate message if it does not." + '\n' +'\n' +
				"To search for a star by name or Hipparcos id number the search box at the bottom left of the window can be used." + '\n' + '\n' +
				"Currently if the name is made up of more than one word a '_' must be inserted between words." + '\n' +'\n' +
				"Currently the id must be in the format 'hippid_' followed by the id number." + '\n' +'\n' +
				"The stars displayed can be filtered using the filter boxes at the bottom right of the window." + '\n' +'\n' +
				"The filter box labeled 'Filter by distance' gives the option to reduce the stars displayed to just ones within 5 or 7 parsecs of the Sun." + '\n' +'\n' +
				"The filter box labeled 'Filter by magnitude' gives the option to reduce the stars displayed to just up to an apparent(visual) magnitude of 3 or 7." + '\n' ;

		heading.setText(head);
		text.setText(userGuide);
		guidePanel.add(heading);
		guidePanel.add(text);
		return guidePanel;
	}

}
