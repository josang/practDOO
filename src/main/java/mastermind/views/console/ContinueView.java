package mastermind.views.console;

import mastermind.controllers.ContinueController;
import mastermind.utils.YesNoDialog;

class ContinueView {

	void interact(ContinueController continueController){
		continueController.resume(new YesNoDialog("Desea continuar")
		.read());
	}
}
