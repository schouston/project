
public class Main {

	public static void main(String[] args) {
		
		CreateStars stars = new CreateStars();
		stars.createHippStars();
		//DisplayPanel display = new DisplayPanel(stars.getManager());
		StarController controller = new StarController(stars.getManager());

	}

}