
public class Main {

	public static void main(String[] args) {
		
		CreateStars stars = new CreateStars();
		
		
		//DisplayPanel display = new DisplayPanel(stars.getManager());
		
		StarController controller = new StarController(stars.getManager());
		
		//CommonNameManager pro = new CommonNameManager();
		//pro.processNameFile();
		//pro.test();

	}

}
