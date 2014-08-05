import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {

		//DisplayPanel display = new DisplayPanel(stars.getManager());
		javax.swing.SwingUtilities.invokeLater(new Runnable(){

			public void run(){

				CreateStars stars = new CreateStars();
				StarManager man = stars.getManager();
				StarController controller = new StarController(man);
			}

			//CommonNameManager pro = new CommonNameManager();
			//pro.processNameFile();
			//pro.test();
		}
				);
	}
}

