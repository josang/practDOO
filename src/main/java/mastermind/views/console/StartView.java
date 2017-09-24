package mastermind.views.console;

import mastermind.controllers.StartController;
import mastermind.utils.OptionDialog;

class StartView {

	void interact(StartController startController){
	    int option = new OptionDialog( startController.gameOptions() ).read();
		startController.start(option);	
	}
}
