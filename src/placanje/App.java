package placanje;

import placanje.controller.AppController;
import placanje.model.AppModel;
import placanje.view.AppView;

public class App {

	public static void main(String[] args) {

		// MODEL
		AppModel model = new AppModel();

		// VIEW
		AppView view = new AppView();

		// CONTROLLER
		// controller(model, view)
		AppController controller = new AppController(model, view);
		controller.produzenjeClanarine();

	}

}
